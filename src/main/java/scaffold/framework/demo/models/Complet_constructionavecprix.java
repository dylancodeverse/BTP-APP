package scaffold.framework.demo.models;

import java.math.BigDecimal;

import orm.DynamicORM;

public class Complet_constructionavecprix extends DynamicORM<Complet_constructionavecprix> {

    String constructionid;
    String construction;
    Double jourdetravaux;
    Double prix;

    public void setJourdetravaux(BigDecimal bigDecimal) {
        setJourdetravaux(bigDecimal.doubleValue());
    }

    public void setPrix(BigDecimal bigDecimal) {
        setPrix(bigDecimal.doubleValue());
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getConstructionid() {
        return constructionid;
    }

    public void setConstructionid(String constructionid) {
        this.constructionid = constructionid;
    }
}
