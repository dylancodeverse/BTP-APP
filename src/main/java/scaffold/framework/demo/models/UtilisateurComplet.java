package scaffold.framework.demo.models;

import orm.DynamicORM;

public class UtilisateurComplet extends DynamicORM<UtilisateurComplet> {
    Integer id;
    String utilisateur;
    Integer sex;
    String description;
    String dept;

    public String getSexLabel() {
        if (sex == 1) {
            return "Homme";
        }
        return "Femme";
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
