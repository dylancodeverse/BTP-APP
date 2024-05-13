package scaffold.framework.demo.models;

import java.sql.Date;

import orm.DynamicORM;

public class Paiement extends DynamicORM<Paiement> {
    String id;
    String commande;
    Double montant;
    Date datedepaiement;

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

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDatedepaiement() {
        return datedepaiement;
    }

    public void setDatedepaiement(Date datedepaiement) {
        this.datedepaiement = datedepaiement;
    }

    public void setMontant(String montant2) {
        setMontant(Double.parseDouble(montant2));
    }

    public void setDatedepaiement(String datedepaiement2) {
        setDatedepaiement(Date.valueOf(datedepaiement2));
    }
}
