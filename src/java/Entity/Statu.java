
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Statu implements Serializable {
    
    private int statuid;
    private String statuadi;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Statu() {
    }

    public Statu(int statuid, String statuadi) {
        this.statuid = statuid;
        this.statuadi = statuadi;
    }

    
    public int getStatuid() {
        return statuid;
    }

    public void setStatuid(int statuid) {
        this.statuid = statuid;
    }

    public String getStatuadi() {
        return statuadi;
    }

    public void setStatuadi(String statuadi) {
        this.statuadi = statuadi;
    }

    @Override
    public String toString() {
        return "statu{" + "statuid=" + statuid + ", statuadi=" + statuadi + '}';
    }
    
}
