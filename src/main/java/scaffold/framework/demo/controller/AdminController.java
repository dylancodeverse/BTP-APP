package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.models.Detailcommandeaveclibelle;
import scaffold.framework.demo.models.V_devistotalavecelevationdejasurcentcomplet;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/mesdevisencours")
    public String getDevisEncours(Model model) throws Exception {
        V_devistotalavecelevationdejasurcentcomplet[] mesvdevis = new V_devistotalavecelevationdejasurcentcomplet()
                .selectWhere("datefinconstruction>=now()");
        model.addAttribute("devis", mesvdevis);
        return "pages/models/admin/cesdevis";
    }

    @GetMapping("/detaildevis/{id}")
    public String getDetailDevis(@PathVariable("id") String idcommande, Model model) throws Exception {
        Detailcommandeaveclibelle[] detailcommandeaveclibelles = new Detailcommandeaveclibelle().select();
        model.addAttribute("detailcommande", detailcommandeaveclibelles);
        return "pages/models/admin/cesDetailsDevis";

    }

}
