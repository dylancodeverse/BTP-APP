package scaffold.framework.demo.models;

import java.math.BigDecimal;

import orm.DynamicORM;

public class V_devistotalavecelevationdejasurcentavecdejapaye
        extends DynamicORM<V_devistotalavecelevationdejasurcentavecdejapaye> {

    String id;
    Double montanttotal;
    Double montantpaye;

    public void setMontantpaye(BigDecimal bigDecimal) {
        setMontantpaye(bigDecimal.doubleValue());
    }

    public void setMontanttotal(BigDecimal bigDecimal) {
        setMontanttotal(bigDecimal.doubleValue());
    }

    
    public static String getSpecialQuery(String idd) {
        return "select id,montanttotal, montantpaye from v_devistotalavecelevationdejasurcentavecdejapaye where id='"
                + idd + "'";
    }

    public Double getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(Double montanttotal) {
        this.montanttotal = montanttotal;
    }

    public Double getMontantpaye() {
        return montantpaye;
    }

    public void setMontantpaye(Double montantpaye) {
        this.montantpaye = montantpaye;
    }

    public boolean getEtatPaiementAvec(Double double1) {
        return getMontanttotal() - getMontantpaye() - double1 >= 0;
    }

}
