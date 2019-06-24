
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Ilactanimi implements Serializable{
  
    private int ilacid;
    private String ilacadi;
    private String ml;
    private String tur;
    
    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Ilactanimi() {
    }

    public Ilactanimi(int ilacid, String ilacadi, String ml, String tur) {
        this.ilacid = ilacid;
        this.ilacadi = ilacadi;
        this.ml = ml;
        this.tur = tur;
    }

    public int getIlacid() {
        return ilacid;
    }

    public void setIlacid(int ilacid) {
        this.ilacid = ilacid;
    }

    public String getIlacadi() {
        return ilacadi;
    }

    public void setIlacadi(String ilacadi) {
        this.ilacadi = ilacadi;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public String toString() {
        return "Ilactanimi{" + "ilacid=" + ilacid + ", ilacadi=" + ilacadi + ", ml=" + ml + ", tur=" + tur + '}';
    }
    
}
