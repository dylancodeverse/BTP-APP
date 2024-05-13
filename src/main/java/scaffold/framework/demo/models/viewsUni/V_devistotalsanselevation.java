package scaffold.framework.demo.models.viewsUni;

import orm.DynamicORM;

public class V_devistotalsanselevation extends DynamicORM<V_devistotalsanselevation> {
    Double montant;
    String commandemere;

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getCommandemere() {
        return commandemere;
    }

    public void setCommandemere(String commandemere) {
        this.commandemere = commandemere;
    }
}
