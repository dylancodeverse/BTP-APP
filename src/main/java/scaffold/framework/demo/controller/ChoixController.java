package scaffold.framework.demo.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.Commande;
import scaffold.framework.demo.models.Complet_constructionavecprix;
import scaffold.framework.demo.models.DetailCommande;
import scaffold.framework.demo.models.Typefinition;
import scaffold.framework.demo.models.V_CONSTRUCTIONCOMPLET;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/choix")
public class ChoixController {

    @Autowired
    DataSource dataSource;

    @Auth(rule = "loginPresent", classSource = RulesConf.class)
    @GetMapping("/liste")
    public String getListe(HttpServletRequest request, Model model) throws Exception {
        Complet_constructionavecprix[] allConstructions = new Complet_constructionavecprix().select();
        request.getSession().setAttribute("constructions", allConstructions);
        model.addAttribute("constructions", allConstructions);
        return "pages/models/choix/choix";
    }

    @Auth(rule = "loginPresent", classSource = RulesConf.class)
    @GetMapping("/finalisation")
    public String pageFinalisation(HttpServletRequest request, String prix, String construction, String idconstruction,
            Model model)
            throws Exception {
        Double prixd = Double.parseDouble(prix);
        Typefinition[] f = new Typefinition().select();
        request.getSession().setAttribute("listefinition", f);

        model.addAttribute("prix", prixd);
        model.addAttribute("construction", construction);
        model.addAttribute("idconstruction", idconstruction);

        model.addAttribute("listefinition", f);

        return "pages/models/choix/finalisationCommande";
    }

    @Auth(rule = "loginPresent", classSource = RulesConf.class)
    @PostMapping("/finalisation")
    public String finalisation(HttpServletRequest request, String typefinition, String idconstruction,
            String datedebutravaux) throws Exception {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        String idclient = (String) request.getSession().getAttribute("id");
        Complet_constructionavecprix complet_constructionavecprix = null;
        // maka anle type finition rehtra
        Typefinition[] typefinitions = ((Typefinition[]) request.getSession().getAttribute("listefinition"));

        // maka anle construction rehetra
        Complet_constructionavecprix[] listComplet_constructionavecprixs = (Complet_constructionavecprix[]) request
                .getSession()
                .getAttribute("constructions");

        Double elevation = null;

        // mampitovy anle typefinition nofidiny
        for (Typefinition typefinition2 : typefinitions) {
            if (typefinition2.getId().equals(typefinition)) {
                elevation = typefinition2.getElevation();
                break;
            }
        }
        // mampitovy anle construction nofidiny
        for (Complet_constructionavecprix complet_constructionavecprixs : listComplet_constructionavecprixs) {
            if (complet_constructionavecprixs.getConstructionid().equals(idconstruction)) {
                complet_constructionavecprix = complet_constructionavecprixs;
                break;
            }
        }
        // raha tsy hita de tsy normal
        if (elevation == null || complet_constructionavecprix == null)
            throw new Exception("Misy tsy milamina");
        try {

            // mi initialiser anle commande
            Commande commande = new Commande();
            commande.setClient(idclient);
            commande.setConstruction(idconstruction);
            commande.setDatedebutconstruction(datedebutravaux);
            commande.setDatefinconstruction(complet_constructionavecprix);
            commande.setElevation(elevation);
            commande.setTypefinition(typefinition);
            commande.insert(connection, true);

            V_CONSTRUCTIONCOMPLET[] v_construct = new V_CONSTRUCTIONCOMPLET().selectWhere(connection, true,
                    "constructionid='" + idconstruction + "'");

            // mampiditra ny detail commande rehetra
            for (int i = 0; i < v_construct.length; i++) {
                DetailCommande detailCommande = new DetailCommande();
                detailCommande.setCommandemere(commande.getId());
                detailCommande.setPrixunitaire(v_construct[i].getPrixunitaire());
                detailCommande.setQuantite(v_construct[i].getQuantitevrai());
                detailCommande.setTravauxdispo(v_construct[i].getTravauxdispo());
                detailCommande.insert(connection, true);
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }
        return "redirect:/choix/liste";
    }

}
