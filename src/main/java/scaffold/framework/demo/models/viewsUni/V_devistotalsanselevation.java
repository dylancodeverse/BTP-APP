package scaffold.framework.demo.models.viewsUni;

import java.math.BigDecimal;

import orm.DynamicORM;

public class V_devistotalsanselevation extends DynamicORM<V_devistotalsanselevation> {
    Double montant;
    String commandemere;

    public void setMontant(BigDecimal bigDecimal) {
        setMontant(bigDecimal.doubleValue());
    }

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
