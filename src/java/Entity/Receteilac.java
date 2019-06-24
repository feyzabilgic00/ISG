
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Receteilac implements Serializable{
   
 private int rilacid;
 private int rid;
 private int ilacid;
 private int kullanimadedi;
 private String kullanimsekli;
 private String periyod;
 private String ilacdozu;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
 private Recete recete;
 private Ilactanimi ilactanimi;
 
    public Receteilac() {
    }

    public Receteilac(int rilacid, int rid, int ilacid, int kullanimadedi, String kullanimsekli, String periyod, String ilacdozu) {
        this.rilacid = rilacid;
        this.rid = rid;
        this.ilacid = ilacid;
        this.kullanimadedi = kullanimadedi;
        this.kullanimsekli = kullanimsekli;
        this.periyod = periyod;
        this.ilacdozu = ilacdozu;
    }

    public int getRilacid() {
        return rilacid;
    }

    public void setRilacid(int rilacid) {
        this.rilacid = rilacid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getIlacid() {
        return ilacid;
    }

    public void setIlacid(int ilacid) {
        this.ilacid = ilacid;
    }

    public int getKullanimadedi() {
        return kullanimadedi;
    }

    public void setKullanimadedi(int kullanimadedi) {
        this.kullanimadedi = kullanimadedi;
    }

    public String getKullanimsekli() {
        return kullanimsekli;
    }

    public void setKullanimsekli(String kullanimsekli) {
        this.kullanimsekli = kullanimsekli;
    }

    public String getPeriyod() {
        return periyod;
    }

    public void setPeriyod(String periyod) {
        this.periyod = periyod;
    }

    public String getIlacdozu() {
        return ilacdozu;
    }

    public void setIlacdozu(String ilacdozu) {
        this.ilacdozu = ilacdozu;
    }

    public Recete getRecete() {
        return recete;
    }

    public void setRecete(Recete recete) {
        this.recete = recete;
    }

    public Ilactanimi getIlactanimi() {
        return ilactanimi;
    }

    public void setIlactanimi(Ilactanimi ilactanimi) {
        this.ilactanimi = ilactanimi;
    }
    
    @Override
    public String toString() {
        return "receteilac{" + "rilacid=" + rilacid + ", rid=" + rid + ", ilacid=" + ilacid + ", kullanimadedi=" + kullanimadedi + ", kullanimsekli=" + kullanimsekli + ", periyod=" + periyod + ", ilacdozu=" + ilacdozu + '}';
    }
 
}
