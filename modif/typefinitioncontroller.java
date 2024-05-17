package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.Typefinition;
import scaffold.framework.demo.models.admin.Travauxdispo;

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
    public String pageUpdate(@PathVariable String id, Model mode) throws Exception {

        Typefinition typefinition = new Typefinition().selectWhere("id='" + id + "'")[0];
        mode.addAttribute("def_typefinition", typefinition.getTypefinition());
        mode.addAttribute("def_elevation", typefinition.getElevation());
       
        mode.addAttribute("id", id);

        return "pages/models/typefinition/edit";

    }
}
