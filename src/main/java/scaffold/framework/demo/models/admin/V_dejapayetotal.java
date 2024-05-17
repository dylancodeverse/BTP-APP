package scaffold.framework.demo.models.admin;

import java.math.BigDecimal;

import orm.DynamicORM;

public class V_dejapayetotal extends DynamicORM<V_dejapayetotal> {
    Double montant;

    public void setMontant(BigDecimal bigDecimal) {
        setMontant(bigDecimal.doubleValue());
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
