package scaffold.framework.demo.models;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import orm.DynamicORM;
import scaffold.framework.demo.models.viewsUni.V_devistotalsanselevation;

public class Detailcommandeaveclibelle extends DynamicORM<Detailcommandeaveclibelle> {

    String travauxdispo;
    Double quantite;
    Double prixunitaire;
    String unite;

    public void setPrixunitaire(BigDecimal bigDecimal) {
        setPrixunitaire(bigDecimal.doubleValue());
    }

    public void setQuantite(BigDecimal bigDecimal) {
        setQuantite(bigDecimal.doubleValue());
    }

    public byte[] generatePDF(Connection connection, String idcommande) throws Exception {
        V_devistotalsanselevation devis = new V_devistotalsanselevation().selectWhere(connection, true,
                "commandemere='" + idcommande + "'")[0];
        String fileTemplate = "C:/Users/MISA/Desktop/Workspace/S6/ConstructionBTP/spring-server/src/main/resources/static/Devis.jrxml";
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(select(connection, true));
        JasperReport jasperReport = JasperCompileManager.compileReport(fileTemplate);
        Map<String, Object> mpas = new HashMap<>();
        mpas.put("Montant total", "Montant total :" + devis.getMontant().toString() + " AR");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mpas, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);

    }

    public String getTravauxdispo() {
        return travauxdispo;
    }

    public void setTravauxdispo(String travauxdispo) {
        this.travauxdispo = travauxdispo;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
