package scaffold.framework.demo.models.imports;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

import scaffold.framework.demo.FormHelper.DateUtils;
import scaffold.framework.demo.config.opencsvconfig.DoubleConverter;

public class PaiementImported {

    @CsvBindByName(column = "ref_devis")
    String ref_devis;
    @CsvBindByName(column = "ref_paiement")
    String ref_paiement;

    @CsvBindByName(column = "date_paiement")
    String date_paiement;
    @CsvBindByName(column = "montant")
    String montant;

    public static void insertAll(Connection connection, List<PaiementImported> importedDataList)
            throws ParseException, Exception {
        if (importedDataList.size() > 0) {

            String sql = "INSERT INTO PaiementImported VALUES";
            Integer i = 1;
            try {
                for (PaiementImported importedData : importedDataList) {
                        
                    sql += "('" +
                    importedData.getRef_devis() +
                    "','" +
                    importedData.getRef_paiement() +
                    "','" +
                    importedData.getDate_paiement() +
                    "'," +
                    importedData.getMontant() +
                    "),";
                    i++;
                }
            } catch (Exception e) {
                throw new Exception("CSV Paiement  a la "+i+" eme ligne avec "+e.getMessage() );
            }
            sql = sql.substring(0, sql.length() - 1);
            System.out.println(sql);
            Statement tStatement = connection.createStatement();
            tStatement.executeUpdate(sql);

            System.out.println("inserted paiementimported");
        }
    }

    public static void insertAllPeripherie(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // Première requête
        statement.executeUpdate(
                "INSERT INTO paiement (commande,montant ,datedepaiement ,paiementref) select commande.id , PAIEMENTIMPORTED.montant ,PAIEMENTIMPORTED.date_paiement ,PAIEMENTIMPORTED.ref_paiement from PAIEMENTIMPORTED join commande on commande.commandeREF = PAIEMENTIMPORTED.ref_devis ;");

    }

    public String getRef_devis() {
        return ref_devis.replaceAll("'", "");
    }

    public void setRef_devis(String ref_devis) {
        this.ref_devis = ref_devis;
    }

    public String getRef_paiement() {
        return ref_paiement.replaceAll("'", "");
    }

    public void setRef_paiement(String ref_paiement) {
        this.ref_paiement = ref_paiement;
    }

    public Date getDate_paiement() throws ParseException {
        return DateUtils.convertStringToSQLDate(date_paiement, "dd/MM/YYYY");

    }

    public void setDate_paiement(String date_paiement) {
        this.date_paiement = date_paiement;
    }

    public Double getMontant() throws Exception {
        try {
            return DoubleConverter.convert(montant);
        } catch (Exception e) {
            throw new Exception("Nombre invalide");
        }
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

}
