
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Unvan implements Serializable {
    
    private int unvanid;
    private String unvanadi;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Unvan() {
    }

    public Unvan(int unvanid, String unvanadi) {
        this.unvanid = unvanid;
        this.unvanadi = unvanadi;
    }

    
    public int getUnvanid() {
        return unvanid;
    }

    public void setUnvanid(int unvanid) {
        this.unvanid = unvanid;
    }

    public String getUnvanadi() {
        return unvanadi;
    }

    public void setUnvanadi(String unvanadi) {
        this.unvanadi = unvanadi;
    }

    @Override
    public String toString() {
        return "unvan{" + "unvanid=" + unvanid + ", unvanadi=" + unvanadi + '}';
    }
    
}
