package scaffold.framework.demo.models.admin;

import java.math.BigDecimal;

import orm.DynamicORM;
import orm.annotations.Id;

public class Travauxdispo extends DynamicORM<Travauxdispo> {
    @Id
    String id;
    String travauxdispo;
    String unite;
    Double prixunitaire;
    String typedetravaux;

    public void setPrixunitaire(BigDecimal bigDecimal){
        setPrixunitaire(bigDecimal.doubleValue());
    }

    public void setPrixunitaire(String pr) {
        setPrixunitaire(Double.parseDouble(pr));
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTravauxdispo() {
        return travauxdispo;
    }

    public void setTravauxdispo(String travauxdispo) {
        this.travauxdispo = travauxdispo;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public String getTypedetravaux() {
        return typedetravaux;
    }

    public void setTypedetravaux(String typedetravaux) {
        this.typedetravaux = typedetravaux;
    }
}
