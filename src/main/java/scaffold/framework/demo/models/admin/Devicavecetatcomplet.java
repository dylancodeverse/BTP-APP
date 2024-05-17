package scaffold.framework.demo.models.admin;

import java.sql.Date;

import orm.DynamicORM;

/**
 * Devisavecetat
 */
public class Devicavecetatcomplet extends DynamicORM<Devicavecetatcomplet> {
    String client;
    Date datedebutconstruction;
    Date datefinconstruction;
    String construction;
    String typefinition;

    

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getTypefinition() {
        return typefinition;
    }

    public void setTypefinition(String typefinition) {
        this.typefinition = typefinition;
    }
}