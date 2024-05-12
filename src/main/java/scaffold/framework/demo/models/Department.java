package scaffold.framework.demo.models;

import orm.DynamicORM;

public class Department extends DynamicORM<Department> {
    Integer id;
    String dept;
    String checked;

    public void setChecked() {
        checked = "selected";
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
