package scaffold.framework.demo.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import scaffold.framework.demo.models.Detailcommandeaveclibelle;
import scaffold.framework.demo.models.V_devistotalavecelevationdejasurcentcomplet;

@Controller
@RequestMapping("devis")
public class MesDevisController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/mesdevis")
    public String getDevis(HttpServletRequest request, Model model) throws Exception {

        String id = ((String) request.getSession().getAttribute("id"));
        V_devistotalavecelevationdejasurcentcomplet[] mesvdevis = new V_devistotalavecelevationdejasurcentcomplet()
                .selectWhere("client='" + id + "'");
        model.addAttribute("devis", mesvdevis);
        return "pages/models/mesdevis/mesdevis";
    }

    @GetMapping("/exportpdf/{id}")
    public ResponseEntity<byte[]> downloadPDF(@PathVariable("id") String idcommande) throws Exception {
        Connection connection = dataSource.getConnection();
        // Supposons que vous avez déjà le contenu du fichier PDF dans un byte[]
        try {
            byte[] pdfContent = new Detailcommandeaveclibelle().generatePDF(connection, idcommande);
            // Créer les en-têtes de la réponse
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            // Nom du fichier PDF téléchargé
            headers.setContentDispositionFormData("filename", "example.pdf");
            // Retourner la réponse avec le contenu du fichier PDF et les en-têtes
            return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        } finally {
            connection.close();
        }

    }

}
