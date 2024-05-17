package scaffold.framework.demo.models;

import java.math.BigDecimal;

import orm.DynamicORM;
import orm.annotations.Id;

public class DetailCommande extends DynamicORM<DetailCommande> {
    @Id
    String id;
    Double quantite;
    Double prixunitaire;
    String commandemere;
    String travauxdispo;

    public void setQuantite(BigDecimal bigDecimal) {
        setQuantite(bigDecimal.doubleValue());
    }
    public void setPrixunitaire(BigDecimal bigDecimal){
        setPrixunitaire(bigDecimal.doubleValue());
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCommandemere() {
        return commandemere;
    }

    public void setCommandemere(String commandemere) {
        this.commandemere = commandemere;
    }

    public String getTravauxdispo() {
        return travauxdispo;
    }

    public void setTravauxdispo(String travauxdispo) {
        this.travauxdispo = travauxdispo;
    }
}
