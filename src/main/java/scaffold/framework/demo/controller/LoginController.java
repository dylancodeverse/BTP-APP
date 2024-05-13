package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.models.Utilisateur;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String pageLogin() {
        return "/pages/authentification/login";
    }

    @GetMapping("/loginadmin")
    public String pageLoginAdmin() {
        return "/pages/authentification/loginadmin";
    }

    @PostMapping("/loginadmin")
    public String loginAdmin(HttpServletRequest request, String numero, String motdepasse, Model model)
            throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        ValidationHelper validator = ValidatorConfig.getValidationHelper();
        validator.validate(utilisateur, model, "numero,motdepasse", numero, motdepasse);

        if (!validator.hasError()) {
            // jerevo ny users misy an iny num iny
            Utilisateur[] users = utilisateur.selectWhere(" numero = '" + numero + "'");
            Integer a = users.length;
            if (a == 0) {
                try {
                    // raha tsy hita de insereo
                    utilisateur.setHierarchie(10);
                    utilisateur.insert();
                } catch (Exception e) {
                    // raha sanatria tsy mety inserer-na dia miverena amn page login miaraka amn
                    // erreur
                    model.addAttribute("error", e.getMessage());
                    return "/pages/authentification/login";
                }
            } else {
                utilisateur.setId(users[0].getId());
                utilisateur.setHierarchie(users[0].getHierarchie());
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("id", utilisateur.getId());
            session.setAttribute("hierarchie", utilisateur.getHierarchie());
        }

        return "redirect:/choix/liste";

    }

    @PostMapping("/login")
    public String postMethodName(HttpServletRequest request, String numero, Model model) throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        ValidationHelper validator = ValidatorConfig.getValidationHelper();
        validator.validate(utilisateur, model, "numero", numero);

        if (!validator.hasError()) {
            // jerevo ny users misy an iny num iny
            Utilisateur[] users = utilisateur.selectWhere(" numero = '" + numero + "'");
            Integer a = users.length;
            if (a == 0) {
                try {
                    // raha tsy hita de insereo
                    utilisateur.setHierarchie(0);
                    utilisateur.insert();
                } catch (Exception e) {
                    // raha sanatria tsy mety inserer-na dia miverena amn page login miaraka amn
                    // erreur
                    model.addAttribute("error", e.getMessage());
                    return "/pages/authentification/login";
                }
            } else {
                utilisateur.setId(users[0].getId());
                utilisateur.setHierarchie(users[0].getHierarchie());
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("id", utilisateur.getId());
            session.setAttribute("hierarchie", utilisateur.getHierarchie());
        }

        return "redirect:/choix/liste";

    }

}
