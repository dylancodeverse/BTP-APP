package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.Typefinition;

@Controller
@RequestMapping("/typefinition")
public class TypefinitionController {

    @GetMapping("/typefinition")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getPage(Model model) throws Exception {
        model.addAttribute("typefinitions", new Typefinition().select());
        return "pages/models/typefinition/liste";
    }

    @GetMapping("/edit/{id}")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String pageUpdate(@PathVariable String id, Model mode) throws Exception {

        Typefinition typefinition = new Typefinition().selectWhere("id='" + id + "'")[0];
        mode.addAttribute("def_typefinition", typefinition.getTypefinition());
        mode.addAttribute("def_elevation", typefinition.getElevation());
        mode.addAttribute("id", id);
        return "pages/models/typefinition/edit";

    }

    @GetMapping("/editVRAI/{id}")
    public String update(@PathVariable String id, String typefinition,
            String elevation,
            Model model) throws Exception {
        // tokony asiana setters string amle classe update

        // tokony manisy anle setChecked raha misy liste (jerevo Unite)
        Typefinition typefinition2 = new Typefinition();
        ValidationHelper val = ValidatorConfig.getValidationHelper();
        model.addAttribute("id", id);
        try {
            val.validate(typefinition2, model, "id,typefinition,elevation",
                    id, typefinition, elevation);
        } catch (NoSuchMethodException | SecurityException e) {

            model.addAttribute("error", e.getMessage());
            val.setHasError(true);
        }
        if (!val.hasError()) {
            typefinition2.setId(id);
            try {
                typefinition2.updateById();
                return "redirect:/typefinition/typefinition";
            } catch (Exception e) {
                System.out.println("eto");
                model.addAttribute("error", e.getMessage());
                val.setHasError(model, "id,typefinition,elevation",
                        id, typefinition, elevation);
            }

        }

        return "pages/models/typefinition/edit";

    }

}
