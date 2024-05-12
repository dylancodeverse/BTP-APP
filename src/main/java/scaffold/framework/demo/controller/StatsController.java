package scaffold.framework.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import scaffold.framework.demo.models.Statistiquedeventedebilletparfilm;

@Controller
public class StatsController {

    @GetMapping("/statistiques")
    public String getMethodName(Model model) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/cinepax",
                "postgres",
                "post");
        String[] infs = new Statistiquedeventedebilletparfilm().getJSONPieChartInformation(connection);
        model.addAttribute("data", infs[0]);
        model.addAttribute("color", infs[1]);
        model.addAttribute("label", infs[2]);

        return "pages/models/stats/stats";
    }

}
