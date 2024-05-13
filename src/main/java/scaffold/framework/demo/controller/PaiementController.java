package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import scaffold.framework.demo.models.Commande;
import scaffold.framework.demo.models.Paiement;

@Controller
@RequestMapping("/paiement")
public class PaiementController {

    @GetMapping("/paiement")
    public String getPage(HttpServletRequest request, Model model) throws Exception {
        String id = ((String) request.getSession().getAttribute("id"));
        Commande[] cmd = new Commande().selectWhere("client='" + id + "'");
        model.addAttribute("mescommandes", cmd);
        return "/pages/models/paiement/Paiement";
    }

    @PostMapping("/paiement")
    public String insert(String datedepaiement, String montant, String commande) throws Exception {
        Paiement paiement = new Paiement();
        paiement.setDatedepaiement(datedepaiement);
        paiement.setMontant(montant);
        paiement.setCommande(commande);
        paiement.insert();
        return "redirect:/paiement/paiement";
    }
}
