package scaffold.framework.demo.models.imports;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

import scaffold.framework.demo.config.opencsvconfig.DoubleConverter;

public class Maisontravaux {

    @CsvBindByName(column = "type_maison")
    String type_maison;

    @CsvBindByName(column = "description")
    String description;

    @CsvBindByName(column = "surface")
    String surface;

    @CsvBindByName(column = "code_travaux")
    String code_travaux;

    @CsvBindByName(column = "type_travaux")
    String type_travaux;

    @CsvBindByName(column = "unite")
    String unite;

    @CsvBindByName(column = "prix_unitaire")
    String prix_unitaire;

    @CsvBindByName(column = "quantite")
    String quantite;

    @CsvBindByName(column = "duree_travaux")
    String duree_travaux;

    public String getType_maison() {
        return type_maison.replaceAll("'", "");
    }

    public void setType_maison(String type_maison) {
        this.type_maison = type_maison;
    }

    public String getDescription() {
        return description.replaceAll("'", "");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSurface() throws Exception {
        try {
            return DoubleConverter.convert(surface);
        } catch (Exception e) {
            throw new Exception("Nombre invalide");
        }
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getCode_travaux() {
        return code_travaux.replaceAll("'", "");
    }

    public void setCode_travaux(String code_travaux) {
        this.code_travaux = code_travaux;
    }

    public String getType_travaux() {
        return type_travaux.replaceAll("'", "");
    }

    public void setType_travaux(String type_travaux) {
        this.type_travaux = type_travaux;
    }

    public String getUnite() {
        return unite.replaceAll("'", "");
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getPrix_unitaire() throws Exception {
        try {
            return DoubleConverter.convert(prix_unitaire);
        } catch (Exception e) {
            throw new Exception("Nombre invalide");
        }
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Double getQuantite() throws Exception {
        try {
            return DoubleConverter.convert(quantite);
        } catch (Exception e) {
            throw new Exception("Nombre invalide");
        }
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Integer getDuree_travaux() {
        return Integer.parseInt(duree_travaux);
    }

    public void setDuree_travaux(String duree_travaux) {
        this.duree_travaux = duree_travaux;
    }

    public static void insertAllPeripherie(Connection connection) throws Exception {
        Statement statement = connection.createStatement();

        // Première requête
        statement.executeUpdate(
                "INSERT INTO construction ( construction , jourdetravaux , description , surface) SELECT      MAISONTRAVAUX.type_maison ,      MAISONTRAVAUX.duree_travaux ,     MAISONTRAVAUX.description ,     MAISONTRAVAUX.surface  FROM      MAISONTRAVAUX ON CONFLICT DO NOTHING;");

        System.err.println("1");

        // Troisième requête
        statement.executeUpdate(
                "INSERT INTO unite (unite) SELECT     MAISONTRAVAUX.unite from     MAISONTRAVAUX ON CONFLICT do NOTHING    ;");

        System.err.println("3");

        // Quatrième requête
        statement.executeUpdate(
                "INSERT INTO travauxdispo(travauxdispo , unite , prixunitaire , typedetravaux) select  MAISONTRAVAUX.type_travaux, unite.id,  MAISONTRAVAUX.prix_unitaire , MAISONTRAVAUX.code_travaux from      MAISONTRAVAUX join unite on unite.unite = MAISONTRAVAUX.unite      ON CONFLICT do NOTHING    ; ");

        System.out.println("4");

        statement.executeUpdate(
                "INSERT INTO  detailconstruction (construction , travauxdispo , quantitevrai) SELECT     construction.ID,     travauxdispo.ID ,     MAISONTRAVAUX.quantite FROM MAISONTRAVAUX     JOIN construction ON MAISONTRAVAUX.type_maison = construction.construction     JOIN travauxdispo ON travauxdispo.travauxdispo=MAISONTRAVAUX.type_travaux;");
        System.out.println("5");

        statement.close();

    }

    public static void insertAll(Connection connection, List<Maisontravaux> importedDataList) throws Exception {
        if (importedDataList.size() > 0) {
            String sql = "INSERT INTO Maisontravaux VALUES";
            Integer i = 1;
            try {
                for (Maisontravaux importedData : importedDataList) {
                    sql += "('" +
                            importedData.getType_maison() +
                            "','" +
                            importedData.getDescription() +
                            "'," +
                            importedData.getSurface() +
                            ",'" +
                            importedData.getCode_travaux() +
                            "','" +
                            importedData.getType_travaux() +
                            "','" +
                            importedData.getUnite() +
                            "'," +
                            importedData.getPrix_unitaire() +
                            "," +
                            importedData.getQuantite() +
                            "," +
                            importedData.getDuree_travaux() +
                            "),";
                    i++;
                }
            } catch (Exception e) {
                throw new Exception("CSV MaisonTravaux a la " + i + " eme ligne avec " + e.getMessage());
            }

            sql = sql.substring(0, sql.length() - 1);
            System.out.println(sql);
            Statement tStatement = connection.createStatement();
            tStatement.executeUpdate(sql);

            System.out.println("inserted Maisontravaux");
        }

    }
}
