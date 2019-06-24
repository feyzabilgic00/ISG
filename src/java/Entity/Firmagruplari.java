package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Firmagruplari implements Serializable {

    private int grup_id;
    private String grup_ad;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Firmagruplari() {
    }

    public Firmagruplari(int grup_id, String grup_ad) {
        this.grup_id = grup_id;
        this.grup_ad = grup_ad;
    }

    public int getGrup_id() {
        return grup_id;
    }

    public void setGrup_id(int grup_id) {
        this.grup_id = grup_id;
    }

    public String getGrup_ad() {
        return grup_ad;
    }

    public void setGrup_ad(String grup_ad) {
        this.grup_ad = grup_ad;
    }

    @Override
    public String toString() {
        return "firmagruplari{" + "grup_id=" + grup_id + ", grup_ad=" + grup_ad + '}';
    }

}
