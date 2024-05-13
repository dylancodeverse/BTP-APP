package scaffold.framework.demo.models;

import orm.DynamicORM;
import orm.annotations.Id;

public class Typefinition extends DynamicORM<Typefinition> {

    @Id
    String id;

    String typefinition;

    Double elevation;

    public Double getNewPrixSansSurCent(Double initPrix) {
        return initPrix + initPrix * (elevation / 100);
    }

    public Double getNewPrixDejaSurCent(Double initPrix) {
        return initPrix + initPrix * (elevation);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
