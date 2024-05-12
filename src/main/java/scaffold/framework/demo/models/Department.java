package scaffold.framework.demo.models;

import orm.DynamicORM;

public class Department extends DynamicORM<Department> {
    Integer id;
    String dept;

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
