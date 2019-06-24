
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Tanilar implements Serializable {
  
    private int taniid;
    private int tanimid;
    private int mid;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    private Muayene muayene;
    
    public Tanilar() {
    }

    public Tanilar(int taniid, int tanimid, int mid) {
        this.taniid = taniid;
        this.tanimid = tanimid;
        this.mid = mid;
    }
    
    public int getTaniid() {
        return taniid;
    }

    public void setTaniid(int taniid) {
        this.taniid = taniid;
    }

    public int getTanimid() {
        return tanimid;
    }

    public void setTanimid(int tanimid) {
        this.tanimid = tanimid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Muayene getMuayene() {
        return muayene;
    }

    public void setMuayene(Muayene muayene) {
        this.muayene = muayene;
    }

    @Override
    public String toString() {
        return "tanilar{" + "taniid=" + taniid + ", tanimid=" + tanimid + ", mid=" + mid + '}';
    }
}
