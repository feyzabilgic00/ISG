
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Tanitanimi implements Serializable {
 
    private int tanitid;
    private String taniadi;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Tanitanimi() {
    }

    public Tanitanimi(int tanitid, String taniadi) {
        this.tanitid = tanitid;
        this.taniadi = taniadi;
    }
    public int getTanitid() {
        return tanitid;
    }

    public void setTanitid(int tanitid) {
        this.tanitid = tanitid;
    }

    public String getTaniadi() {
        return taniadi;
    }

    public void setTaniadi(String taniadi) {
        this.taniadi = taniadi;
    }

    @Override
    public String toString() {
        return "tanitanimi{" + "tanitid=" + tanitid + ", taniadi=" + taniadi + '}';
    }
    
}
