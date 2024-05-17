package scaffold.framework.demo.controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.config.springAuth.annotations.Auth;
import scaffold.framework.demo.config.springAuth.rules.RulesConf;
import scaffold.framework.demo.models.Detailcommandeaveclibelle;
import scaffold.framework.demo.models.V_devistotalavecelevationdejasurcentcomplet;
import scaffold.framework.demo.models.admin.Fn_statdevisanneemois;
import scaffold.framework.demo.models.admin.V_dejapayetotal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/mesdevisencours")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getDevisEncours(Model model) throws Exception {
        V_devistotalavecelevationdejasurcentcomplet[] mesvdevis = new V_devistotalavecelevationdejasurcentcomplet()
                .select();
        model.addAttribute("devis", mesvdevis);
        V_dejapayetotal[] vs = new V_dejapayetotal().select();
        Double montant = vs[0].getMontant();
        if (montant == null) {
            montant = 0.;
        }
        System.out.println();
        model.addAttribute("montant", (new BigDecimal(montant + "").toPlainString()));
        return "pages/models/admin/cesdevis";
    }

    @GetMapping("/delete")
    public String delete() throws Exception {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "        delete from paiement ;");
            statement.executeUpdate(
                    "delete from detailcommande    ;");
            statement.executeUpdate("delete from commande;");
            statement.executeUpdate("delete from DETAILCONSTRUCTION;");
            statement.executeUpdate("delete from typefinition;");
            statement.executeUpdate("delete from construction;");
            statement.executeUpdate("delete from travauxdispo;");
            statement.executeUpdate("delete from UNITE;");
            statement.executeUpdate("delete from utilisateur where hierarchie<10;");

            statement.executeUpdate("delete from paiementimported");
            statement.executeUpdate("delete from devisimported");
            statement.executeUpdate("delete from maisontravaux");

            statement.close();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.close();
        }
        return "redirect:/admin/mesdevisencours";

    }

    @GetMapping("/detaildevis/{id}")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getDetailDevis(@PathVariable("id") String idcommande, Model model) throws Exception {
        Detailcommandeaveclibelle[] detailcommandeaveclibelles = new Detailcommandeaveclibelle().select();
        model.addAttribute("detailcommande", detailcommandeaveclibelles);
        return "pages/models/admin/cesDetailsDevis";
    }

    @GetMapping("/histogramme")
    @Auth(rule = "isAdmin", classSource = RulesConf.class)
    public String getHistogramme(Model model, Integer annee) throws Exception {
        if (annee == null) {
            annee = 2024;
        }

        Connection connection = dataSource.getConnection();
        String[] infs = new Fn_statdevisanneemois().getJSONPieChartInformation(connection, annee);
        model.addAttribute("data", infs[0]);
        model.addAttribute("color", infs[1]);
        model.addAttribute("label", infs[2]);

        return "pages/models/admin/histogramme";
    }

}
