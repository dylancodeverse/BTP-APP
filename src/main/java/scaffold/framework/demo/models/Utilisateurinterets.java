package scaffold.framework.demo.models;

import java.sql.Connection;

import orm.DynamicORM;
import orm.annotations.Id;
import orm.annotations.Ignore;

public class Utilisateurinterets extends DynamicORM<Utilisateurinterets> {
    @Id
    Integer id;
    Integer utilisateur;
    Integer interets;
    
    @Ignore
    Integer[] listInterets;

    public void setUtilisateur(String x) {
        setUtilisateur(Integer.parseInt(x));
    }

    public void setListInterets(java.util.List<String> list) throws Exception {
        if (list == null) {
            throw new Exception("champ obligatoire");
        }
        listInterets = new Integer[list.size()];
        for (int i = 0; i < listInterets.length; i++) {
            listInterets[i] = Integer.parseInt(list.get(i));
        }
    }

    public void insertAll(Connection con) throws Exception {
        

        for (int i = 0; i < listInterets.length; i++) {
            setInterets(listInterets[i]);
            try {
                insert(con, true);
            } catch (Exception e) {
                con.rollback();
                throw e;
            }
        }
    }

    public void setInterets(String x) {
        setInterets(Integer.parseInt(x));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Integer utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getInterets() {
        return interets;
    }

    public void setInterets(Integer Interets) {
        this.interets = Interets;
    }

}
