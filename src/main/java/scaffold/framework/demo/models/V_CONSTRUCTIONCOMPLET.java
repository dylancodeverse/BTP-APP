package scaffold.framework.demo.models;

import java.math.BigDecimal;

import orm.DynamicORM;

public class V_CONSTRUCTIONCOMPLET extends DynamicORM<V_CONSTRUCTIONCOMPLET> {
    String constructionid;
    String construction;
    Double jourdetravaux;
    Double quantitevrai;
    String travauxdispo;
    Double prixunitaire;

    public void setPrixunitaire(BigDecimal bigDecimal) {
        setPrixunitaire(bigDecimal.doubleValue());
    }

    public void setJourdetravaux(BigDecimal bigDecimal) {
        setJourdetravaux(bigDecimal.doubleValue());
    }

    public void setQuantitevrai(BigDecimal bigDecimal) {
        setQuantitevrai(bigDecimal.doubleValue());
    }

    public String getConstructionid() {
        return constructionid;
    }

    public void setConstructionid(String constructionid) {
        this.constructionid = constructionid;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Double getJourdetravaux() {
        return jourdetravaux;
    }

    public void setJourdetravaux(Double jourdetravaux) {
        this.jourdetravaux = jourdetravaux;
    }

    public Double getQuantitevrai() {
        return quantitevrai;
    }

    public void setQuantitevrai(Double quantitevrai) {
        this.quantitevrai = quantitevrai;
    }

    public String getTravauxdispo() {
        return travauxdispo;
    }

    public void setTravauxdispo(String travauxdispo) {
        this.travauxdispo = travauxdispo;
    }

    public Double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }
}
