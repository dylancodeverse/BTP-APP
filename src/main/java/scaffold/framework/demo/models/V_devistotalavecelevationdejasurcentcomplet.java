package scaffold.framework.demo.models;

import java.sql.Date;

import orm.DynamicORM;

public class V_devistotalavecelevationdejasurcentcomplet
        extends DynamicORM<V_devistotalavecelevationdejasurcentcomplet> {
    String id;
    String client;
    String construction;
    Date datedebutconstruction;
    Date datefinconstruction;
    Date datedecommande;
    String typefinition;
    Double montanttotal;
    String constructionlabel;
    String typefinitionlabel;
    String clientlabel;

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

    public Double getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(Double montanttotal) {
        this.montanttotal = montanttotal;
    }

    public String getConstructionlabel() {
        return constructionlabel;
    }

    public void setConstructionlabel(String constructionlabel) {
        this.constructionlabel = constructionlabel;
    }

    public String getTypefinitionlabel() {
        return typefinitionlabel;
    }

    public void setTypefinitionlabel(String typefinitionlabel) {
        this.typefinitionlabel = typefinitionlabel;
    }

    public String getClientlabel() {
        return clientlabel;
    }

    public void setClientlabel(String clientlabel) {
        this.clientlabel = clientlabel;
    }
}