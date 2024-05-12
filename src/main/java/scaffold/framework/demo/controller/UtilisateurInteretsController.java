package scaffold.framework.demo.controller;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import scaffold.framework.demo.FormHelper.ValidationHelper;
import scaffold.framework.demo.config.ValidatorConfig;
import scaffold.framework.demo.models.Interets;
import scaffold.framework.demo.models.Utilisateur;
import scaffold.framework.demo.models.Utilisateurinterets;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.micrometer.common.lang.Nullable;

@Controller
public class UtilisateurInteretsController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/utilisateurinterets")
    public String page(Model model) throws Exception {
        model.addAttribute("utilisateur", new Utilisateur().select());
        model.addAttribute("interets", new Interets().select());
        return "pages/models/utilisateur/interets";
    }

    @PostMapping("/utilisateurinterets")
    public String insert(Model model, String utilisateur, @Nullable @RequestParam("interets[]") List<String> interets)
            throws Exception {
        Utilisateurinterets utilisateurinterets = new Utilisateurinterets();
        ValidationHelper val = ValidatorConfig.getValidationHelper();
        Interets[] interets2 = new Interets().select();
        Utilisateur[] user2 = new Utilisateur().select();
        try {
            val.validate(utilisateurinterets, model, "utilisateur", utilisateur);
        } catch (Exception e) {
            model.addAttribute("error", e.getCause());
            val.setHasError(true);
        }
        try {
            utilisateurinterets.setListInterets(interets);
        } catch (Exception e) {
            System.out.println("tay be");
            model.addAttribute("err_interets", e.getMessage());
            val.setHasError(true);
        }

        if (!val.hasError()) {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            try {
                utilisateurinterets.insertAll(connection);
                connection.commit();
            } catch (Exception e) {
                throw e;
            } finally {
                connection.close();
            }
        } else {
            if (interets != null) {
                for (int i = 0; i < interets2.length; i++) {
                    for (int j = 0; j < interets.size(); j++) {
                        if (interets2[i].getId() == Integer.parseInt(interets.get(j))) {
                            interets2[i].setChecked();
                            break;
                        }
                    }
                }
            }
            if (!utilisateur.isBlank()) {
                for (int i = 0; i < user2.length; i++) {
                    if (user2[i].getId() == Integer.parseInt(utilisateur)) {
                        user2[i].setChecked();
                    }
                }
            }

        }

        model.addAttribute("utilisateur", user2);
        model.addAttribute("interets", interets2);

        return "pages/models/utilisateur/interets";

    }

}
