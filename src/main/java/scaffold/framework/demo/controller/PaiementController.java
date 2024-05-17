package scaffold.framework.demo.controller;

import java.sql.Connection;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.Commande;
import scaffold.framework.demo.models.Paiement;
import scaffold.framework.demo.models.V_devistotalavecelevationdejasurcentavecdejapaye;

@Controller
@RequestMapping("/paiement")
public class PaiementController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/paiement")
    @Auth(rule = "loginPresent", classSource = RulesConf.class)
    public String getPage(HttpServletRequest request, Model model) throws Exception {
        String id = ((String) request.getSession().getAttribute("id"));
        Commande[] cmd = new Commande().selectWhere("client='" + id + "'");
        model.addAttribute("mescommandes", cmd);
        return "/pages/models/paiement/Paiement";
    }

    @PostMapping("/paiement")
    @Auth(rule = "loginPresent", classSource = RulesConf.class)
    public ResponseEntity<?> insert(String datedepaiement, String montant, String commande) throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        Paiement paiement = new Paiement();
        try {
            paiement.setDatedepaiement(datedepaiement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            hashMap.put("datedepaiement", e.getMessage());
        }
        try {
            paiement.setMontant(montant);
        } catch (Exception e) {
            hashMap.put("montant", e.getMessage());
        }
        try {
            paiement.setCommande(commande);
        } catch (Exception e) {
            hashMap.put("commande", e.getMessage());
        }
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        if (hashMap.isEmpty()) {
            try {
                V_devistotalavecelevationdejasurcentavecdejapaye etatPaiement = new V_devistotalavecelevationdejasurcentavecdejapaye()
                        .select(V_devistotalavecelevationdejasurcentavecdejapaye.getSpecialQuery(commande))[0];

                if (etatPaiement.getEtatPaiementAvec(paiement.getMontant())) {
                    paiement.insert(connection, true);
                } else {
                    throw new Exception(
                            "Beaucoup trop de montant avec sur plus " + (-etatPaiement.getMontanttotal()
                                    + etatPaiement.getMontantpaye() + paiement.getMontant()));
                }

            } catch (Exception e) {
                connection.rollback();
                hashMap.put("transaction", e.getMessage());
            } finally {
                connection.close();
            }
        }

        if (hashMap.isEmpty()) {
            return ResponseEntity.ok("Paiement effectué avec succès !");
        } else {
            return ResponseEntity.badRequest().body(hashMap);
        }
    }

}
