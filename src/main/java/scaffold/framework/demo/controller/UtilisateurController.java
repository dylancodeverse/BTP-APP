package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.models.Department;
import scaffold.framework.demo.models.Utilisateur;
import scaffold.framework.demo.models.UtilisateurComplet;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        if (!val.hasError()) {
            utilisateur2.insert();
        }

        model.addAttribute("dept", new Department().select());

        return "pages/models/utilisateur/add";
    }

    @GetMapping("/utilisateur/edit/{id}")
    public String pageUpdate(@PathVariable Integer id, Model mode) throws Exception {

        Utilisateur user = new Utilisateur().selectWhere("id=" + id)[0];
        mode.addAttribute("def_utilisateur", user.getUtilisateur());
        mode.addAttribute("def_sex", user.getSex());
        mode.addAttribute("def_description", user.getDescription());
        mode.addAttribute("department", user.getDepartment());
        mode.addAttribute("id", id);
        Department[] departments = new Department().select();

        for (int i = 0; i < departments.length; i++) {
            if (departments[i].getId() == user.getDepartment()) {
                departments[i].setChecked();
            }
        }
        mode.addAttribute("dept", departments);

        return "pages/models/utilisateur/edit";

    }

    @GetMapping("/utilisateur/editVRAI/{id}")
    public String update(@PathVariable Integer id, String utilisateur, String sex, String description,
            String department,
            Model model) throws Exception {
        Utilisateur utilisateur2 = new Utilisateur();
        ValidationHelper val = ValidatorConfig.getValidationHelper();
        model.addAttribute("id", id);
        try {
            val.validate(utilisateur2, model, "utilisateur,sex,description,department", utilisateur, sex, description,
                    department);
        } catch (NoSuchMethodException | SecurityException e) {

            model.addAttribute("error", e.getCause());
        }
        if (!val.hasError()) {
            utilisateur2.setId(id);
            utilisateur2.updateById();
            return "redirect:/utilisateur/list";
        }
        model.addAttribute("dept", new Department().select());
        return "pages/models/utilisateur/edit";

    }

    @GetMapping("utilisateur/list")
    public String pageListe(Model mode, Integer elementParPage, Integer pageNumber, String filtre) throws Exception {
        if (elementParPage == null) {
            elementParPage = 5;
        }
        if (pageNumber == null) {
            pageNumber = 1;
        }
        mode.addAttribute("elementParPage", elementParPage);
        mode.addAttribute("pageNumber", pageNumber);
        mode.addAttribute("previous", pageNumber - 1);
        mode.addAttribute("next", pageNumber + 1);

        try {
            if (filtre != null) {
                mode.addAttribute("list", new UtilisateurComplet().selectPaginationSpecialQuery(
                        "select * from UtilisateurComplet order by " + filtre, pageNumber, elementParPage));
            } else {
                mode.addAttribute("list", new UtilisateurComplet().selectPagination(pageNumber, elementParPage));
            }

        } catch (Exception e) {
            mode.addAttribute("list", new UtilisateurComplet().selectPagination(1, 5));
            mode.addAttribute("elementParPage", elementParPage);
            mode.addAttribute("pageNumber", pageNumber);
            mode.addAttribute("previous", 0);
            mode.addAttribute("next", 2);
            mode.addAttribute("error", e.getMessage());
        }
        return "pages/models/utilisateur/list";

    }

}
