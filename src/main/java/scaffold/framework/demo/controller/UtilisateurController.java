package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.models.Department;
import scaffold.framework.demo.models.Utilisateur;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurController {

    @GetMapping("/utilisateur")
    public String page(Model model) throws Exception {
        model.addAttribute("dept", new Department().select());
        return "pages/models/utilisateur/add";
    }

    @PostMapping("/utilisateur")
    public String add(String utilisateur, String sex, String description, String department,
            Model model) throws Exception {
        Utilisateur utilisateur2 = new Utilisateur();
        ValidationHelper val = ValidatorConfig.getValidationHelper();
        try {
            val.validate(utilisateur2, model, "utilisateur,sex,description,department", utilisateur, sex, description,
                    department);
        } catch (NoSuchMethodException | SecurityException e) {
            model.addAttribute("error", e.getCause());
        }
        model.addAttribute("dept", new Department().select());

        return "pages/models/utilisateur/add";
    }

}
