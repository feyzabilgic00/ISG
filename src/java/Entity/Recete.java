
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Recete implements Serializable{
  
    private int rid;
    private int mid;
    private String rtarihi;
    private String rtipi;
    private String ralttipi;
    private String provizyontipi;
    private String serino;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    private Muayene muayene;
    private Recete recete;
    public Recete() {
    }

    public Recete(int rid, int mid, String rtarihi, String rtipi, String ralttipi, String provizyontipi, String serino) {
        this.rid = rid;
        this.mid = mid;
        this.rtarihi = rtarihi;
        this.rtipi = rtipi;
        this.ralttipi = ralttipi;
        this.provizyontipi = provizyontipi;
        this.serino = serino;
    }
    
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getRtarihi() {
        return rtarihi;
    }

    public void setRtarihi(String rtarihi) {
        this.rtarihi = rtarihi;
    }

    public String getRtipi() {
        return rtipi;
    }

    public void setRtipi(String rtipi) {
        this.rtipi = rtipi;
    }

    public String getRalttipi() {
        return ralttipi;
    }

    public void setRalttipi(String ralttipi) {
        this.ralttipi = ralttipi;
    }

    public String getProvizyontipi() {
        return provizyontipi;
    }

    public void setProvizyontipi(String provizyontipi) {
        this.provizyontipi = provizyontipi;
    }

    public String getSerino() {
        return serino;
    }

    public void setSerino(String serino) {
        this.serino = serino;
    }

    public Muayene getMuayene() {
        return muayene;
    }

    public void setMuayene(Muayene muayene) {
        this.muayene = muayene;
    }

    public Recete getRecete() {
        return recete;
    }

    public void setRecete(Recete recete) {
        this.recete = recete;
    }

    @Override
    public String toString() {
        return "recete{" + "rid=" + rid + ", mid=" + mid + ", rtarihi=" + rtarihi + ", rtipi=" + rtipi + ", ralttipi=" + ralttipi + ", provizyontipi=" + provizyontipi + ", serino=" + serino + '}';
    }  
}
