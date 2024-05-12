package scaffold.framework.demo.models;

import orm.DynamicORM;

public class Interets extends DynamicORM<Interets> {
    Integer id;
    String interets;
    private String checked;

    public void setChecked() {
        checked = "checked";
    }

    public String getChecked() {
        if (checked == null) {
            return "";
        }
        return checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterets() {
        return interets;
    }

    public void setInterets(String interets) {
        this.interets = interets;
    }
}