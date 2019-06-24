
package Entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Kullanicifirma implements Serializable {
  
    private int sicilno;
    private int firmaid;
    
    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    Kullanici kullanici;
    Firma firma;
    
    public Kullanicifirma() {
    }

    public Kullanicifirma(int sicilno, int firmaid) {
        this.sicilno = sicilno;
        this.firmaid = firmaid;
    }

    
    public int getSicilno() {
        return sicilno;
    }

    public void setSicilno(int sicilno) {
        this.sicilno = sicilno;
    }

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
    
    

    @Override
    public String toString() {
        return "kullanicifirma{" + "sicilno=" + sicilno + ", firmaid=" + firmaid + '}';
    }
}
