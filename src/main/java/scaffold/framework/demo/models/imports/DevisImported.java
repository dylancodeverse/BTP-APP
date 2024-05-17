package scaffold.framework.demo.models.imports;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

import scaffold.framework.demo.FormHelper.DateUtils;
import scaffold.framework.demo.config.opencsvconfig.PourcentageConverter;

public class DevisImported {
    @CsvBindByName(column = "client")
    String client;
    @CsvBindByName(column = "ref_devis")
    String ref_devis;
    @CsvBindByName(column = "type_maison")
    String type_maison;
    @CsvBindByName(column = "finition")
    String finition;

    @CsvBindByName(column = "taux_finition")
    String taux_finition;

    @CsvBindByName(column = "date_devis")
    String date_devis;

    @CsvBindByName(column = "date_debut")
    String date_debut;

    @CsvBindByName(column = "lieu")
    String lieu;

    public static void insertAllPeripherie(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // Première requête
        statement.executeUpdate(
                "INSERT INTO utilisateur (numero,hierarchie) select DEVISIMPORTED.client, 0 as h FROM DEVISIMPORTED ON CONFLICT do NOTHING    ;");

        System.err.println("5");

        // Deuxième requête
        statement.executeUpdate(
                "INSERT INTO typefinition ( typefinition , elevation) SELECT finition, taux_finition FROM DEVISIMPORTED  ON CONFLICT DO NOTHING ;");

        System.err.println("6");

        // Troisième requête
        statement.executeUpdate(
                "INSERT INTO commande ( client, construction ,datedebutconstruction ,datefinconstruction , datedecommande ,typefinition , elevation , lieu , commanderef) SELECT utilisateur.ID ,construction.ID ,DEVISIMPORTED.date_debut, DEVISIMPORTED.date_debut + INTERVAL '1 days' * construction.jourdetravaux , DEVISIMPORTED.date_devis, typefinition.ID ,DEVISIMPORTED.taux_finition , DEVISIMPORTED.LIEU , DEVISIMPORTED.ref_devis FROM DEVISIMPORTED JOIN utilisateur ON DEVISIMPORTED.client =utilisateur.numero JOIN construction ON construction.construction =DEVISIMPORTED.type_maison  JOIN typefinition on DEVISIMPORTED.finition = typefinition.typefinition;");
        System.err.println("7");

        statement.execute(
                "select MISAJOURDETAILCOMMANDE ()");
        System.err.println("7");
        statement.close();
    }

    public static void insertAll(Connection connection, List<DevisImported> importedDataList) throws Exception {
        if (importedDataList.size() > 0) {
            String sql = "INSERT INTO DevisImported VALUES";
            Integer i = 1;
            try {
                for (DevisImported importedData : importedDataList) {
                    sql += "('" +
                            importedData.getClient() +
                            "','" +
                            importedData.getRef_devis() +
                            "','" +
                            importedData.getType_maison() +
                            "','" +
                            importedData.getFinition() +
                            "'," +
                            importedData.getTaux_finition() +
                            ",'" +
                            importedData.getDate_devis() +
                            "','" +
                            importedData.getDate_debut() +
                            "','" +
                            importedData.getLieu() +
                            "'),";
                    i++;
                }

            } catch (Exception e) {
                throw new Exception("CSV Devis import a la " + i + " eme ligne avec " + e.getMessage());
            }
            sql = sql.substring(0, sql.length() - 1);

            Statement tStatement = connection.createStatement();
            tStatement.executeUpdate(sql);

        }
    }

    public String getClient() {
        return client.replaceAll("'", "");
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRef_devis() {
        return ref_devis.replaceAll("'", "");
    }

    public void setRef_devis(String ref_devis) {
        this.ref_devis = ref_devis;
    }

    public String getType_maison() {
        return type_maison.replaceAll("'", "");
    }

    public void setType_maison(String type_maison) {
        this.type_maison = type_maison;
    }

    public String getFinition() {
        return finition.replaceAll("'", "");
    }

    public void setFinition(String finition) {
        this.finition = finition;
    }

    public Double getTaux_finition() throws Exception {
        try {
            return PourcentageConverter.convert(taux_finition);
        } catch (Exception e) {
            throw new Exception("Nombre invalide");
        }
    }

    public void setTaux_finition(String taux_finition) {
        this.taux_finition = taux_finition;
    }

    public Date getDate_devis() throws ParseException {
        System.out.println(date_devis);
        System.out.println();
        return DateUtils.convertStringToSQLDate(date_devis, "dd/MM/YYYY");
    }

    public void setDate_devis(String date_devis) {
        this.date_devis = date_devis;
    }

    public Date getDate_debut() throws ParseException {
        return DateUtils.convertStringToSQLDate(date_debut, "dd/MM/YYYY");

    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getLieu() {
        return lieu.replaceAll("'", "");
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}
