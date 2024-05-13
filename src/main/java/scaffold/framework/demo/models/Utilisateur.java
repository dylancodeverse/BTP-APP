package scaffold.framework.demo.models;

import orm.DynamicORM;
import orm.annotations.Id;

public class Utilisateur extends DynamicORM<Utilisateur> {

    @Id
    String id;

    String numero;

    Integer hierarchie;

    String motdepasse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Integer hierarchie) {
        this.hierarchie = hierarchie;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
