package scaffold.framework.demo.models;

import orm.DynamicORM;

/**
 * Utilisateur
 */
public class Utilisateur extends DynamicORM<Utilisateur> {

    Integer id;
    String utilisateur;
    Integer sex;
    String description;
    Integer department;

    public void setSex(String x) {
        setSex(Integer.parseInt(x));
    }

    public void setDepartment(String department) {
        setDepartment(Integer.parseInt(department));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }
}