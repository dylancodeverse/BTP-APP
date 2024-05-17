package scaffold.framework.demo.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import orm.DynamicORM;
import orm.annotations.Id;

public class Commande extends DynamicORM<Commande> {
    @Id
    String id;
    //
    String client;
    //
    String construction;
    //
    Date datedebutconstruction;
    Date datefinconstruction;
    Date datedecommande;
    //
    String typefinition;
    //
    Double elevation;

    public void setElevation(BigDecimal bigDecimal) {
        setElevation(bigDecimal.doubleValue());
    }

    public String getLabel() {
        return getConstruction() + " debut en " + getDatedebutconstruction();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Date getDatedebutconstruction() {
        return datedebutconstruction;
    }

    public void setDatedebutconstruction(Date datedebutconstruction) {
        this.datedebutconstruction = datedebutconstruction;
    }

    public Date getDatefinconstruction() {
        return datefinconstruction;
    }

    public void setDatefinconstruction(Date datefinconstruction) {
        this.datefinconstruction = datefinconstruction;
    }

    public Date getDatedecommande() {
        return datedecommande;
    }

    public void setDatedecommande(Date datedecommande) {
        this.datedecommande = datedecommande;
    }

    public String getTypefinition() {
        return typefinition;
    }

    public void setTypefinition(String typefinition) {
        this.typefinition = typefinition;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public void setDatedebutconstruction(String datedebutravaux) {
        setDatedebutconstruction(Date.valueOf(datedebutravaux));
    }

    public void setDatefinconstruction(Complet_constructionavecprix complet_constructionavecprix) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDatedebutconstruction());
        calendar.add(Calendar.DAY_OF_YEAR, complet_constructionavecprix.getJourdetravaux().intValue());

        // Date résultante
        Date newDate = new Date(calendar.getTimeInMillis());
        setDatefinconstruction(newDate);
    }

}
