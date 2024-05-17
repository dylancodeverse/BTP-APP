package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.admin.Travauxdispo;
import scaffold.framework.demo.models.admin.Unite;

/**
 * TravauxdispoController
 */
@Controller
@RequestMapping("/travauxdispo")
public class TravauxdispoController {

    @GetMapping("/travauxdispo")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getPage(Model model) throws Exception {
        model.addAttribute("travauxdispos", new Travauxdispo().select());
        return "pages/models/travauxdispo/liste";
    }

    @GetMapping("/edit/{id}")
    public String pageUpdate(@PathVariable String id, Model mode) throws Exception {

        Travauxdispo travauxdispo = new Travauxdispo().selectWhere("id='" + id + "'")[0];
        mode.addAttribute("def_prixunitaire", travauxdispo.getPrixunitaire());
        mode.addAttribute("def_travauxdispo", travauxdispo.getTravauxdispo());
        mode.addAttribute("def_typedetravaux", travauxdispo.getTypedetravaux());
        mode.addAttribute("def_unite", travauxdispo.getUnite());
        mode.addAttribute("id", id);

        // partie liste des unites:
        Unite[] unites = new Unite().select();
        for (int i = 0; i < unites.length; i++) {
            if (unites[i].getId().equals(travauxdispo.getUnite())) {
                unites[i].setChecked();
            }
        }

        mode.addAttribute("unite", unites);

        return "pages/models/travauxdispo/edit";

    }

    @GetMapping("/editVRAI/{id}")
    public String update(@PathVariable String id, String travauxdispo, String unite,
            String prixunitaire,
            String typedetravaux,
            Model model) throws Exception {

        // tokony asiana setters string amle classe update

        // tokony manisy anle setChecked raha misy liste (jerevo Unite)

        Travauxdispo travauxdispo2 = new Travauxdispo();
        ValidationHelper val = ValidatorConfig.getValidationHelper();
        // partie liste des unites:
        Unite[] unites = new Unite().select();

        model.addAttribute("id", id);
        try {
            val.validate(travauxdispo2, model, "id,travauxdispo,unite,prixunitaire,typedetravaux",
                    id, travauxdispo, unite, prixunitaire, typedetravaux);
        } catch (NoSuchMethodException | SecurityException e) {

            model.addAttribute("error", e.getMessage());
            val.setHasError(true);
        }
        if (!val.hasError()) {
            travauxdispo2.setId(id);
            try {
                travauxdispo2.updateById();
                return "redirect:/travauxdispo/travauxdispo";
            } catch (Exception e) {
                System.out.println("eto");
                model.addAttribute("error", e.getMessage());
                val.setHasError(model, "id,travauxdispo,unite,prixunitaire,typedetravaux",
                        id, travauxdispo, unite, prixunitaire, typedetravaux);
                // raha misy select
                Unite.setChecked(unites, ((String) model.getAttribute("def_unite")));
            }

        } else {
            // raha misy select
            Unite.setChecked(unites, ((String) model.getAttribute("def_unite")));

        }
        // raha misy select
        model.addAttribute("unite", unites);
        return "pages/models/travauxdispo/edit";

    }

}