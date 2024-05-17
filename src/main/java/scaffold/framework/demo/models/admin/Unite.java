package scaffold.framework.demo.models.admin;

import orm.DynamicORM;
import orm.annotations.Id;
import orm.annotations.Ignore;

public class Unite extends DynamicORM<Unite> {
    @Id
    String id;
    String unite;

    @Ignore
    String checked;

    public static void setChecked(Unite[] unites, String idUniteChecked) {
        for (Unite unite : unites) {
            if (unite.getId().equals(idUniteChecked)) {
                unite.setChecked();
                return;
            }
        }
    }

    public void setChecked() {
        checked = "selected";
    }

    public String getChecked() {
        if (checked == null) {
            return "";
        }
        return checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
