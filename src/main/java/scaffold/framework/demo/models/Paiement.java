package scaffold.framework.demo.models;

import java.math.BigDecimal;
import java.sql.Date;

import orm.DynamicORM;

public class Paiement extends DynamicORM<Paiement> {
    String id;
    String commande;
    Double montant;
    Date datedepaiement;

    public void setMontant(BigDecimal bigDecimal) throws Exception {
        setMontant(bigDecimal.doubleValue());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommande() {
        return commande;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) throws Exception {
        if (montant <= 0)
            throw new Exception("Montant negatif non autorise");
        this.montant = montant;
    }

    public Date getDatedepaiement() {
        return datedepaiement;
    }

    public void setDatedepaiement(Date datedepaiement) {
        this.datedepaiement = datedepaiement;
    }

    public void setMontant(String montant2) throws NumberFormatException, Exception {
        setMontant(Double.parseDouble(montant2));
    }

    public void setDatedepaiement(String datedepaiement2) throws Exception {
        try {
            setDatedepaiement(Date.valueOf(datedepaiement2));
        } catch (Exception e) {
            throw new Exception("Format de date pas normal");
        }

    }

}
