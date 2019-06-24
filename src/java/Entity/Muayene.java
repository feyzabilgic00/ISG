
package Entity;

import java.util.Date;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Muayene implements Serializable{
 
    private int mid;
    private String mneden ;
    private String mtarihi;
    private String sonrakimtarih;
    private String annehastalikg;
    private String babahastalikg;
    private String cocukhastalikg;
    private String kardeshastalikg;
    private int büyüktan;
    private int kücüktan;
    private int nabiz;
    private double kilo;
    private double boy;
    private String kangrup;
    private int sicilno;
    private int sicilnop;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    private Personel personel;
    private Kullanici kullanici;
    
    public Muayene() {
    }

    public Muayene(int mid, String mneden, String mtarihi, String sonrakimtarih, String annehastalikg, String babahastalikg, String cocukhastalikg, String kardeshastalikg, int büyüktan, int kücüktan, int nabiz, double kilo, double boy, String kangrup, int sicilno, int sicilnop) {
        this.mid = mid;
        this.mneden = mneden;
        this.mtarihi = mtarihi;
        this.sonrakimtarih = sonrakimtarih;
        this.annehastalikg = annehastalikg;
        this.babahastalikg = babahastalikg;
        this.cocukhastalikg = cocukhastalikg;
        this.kardeshastalikg = kardeshastalikg;
        this.büyüktan = büyüktan;
        this.kücüktan = kücüktan;
        this.nabiz = nabiz;
        this.kilo = kilo;
        this.boy = boy;
        this.kangrup = kangrup;
        this.sicilno = sicilno;
        this.sicilnop = sicilnop;
    }
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMneden() {
        return mneden;
    }

    public void setMneden(String mneden) {
        this.mneden = mneden;
    }

    public String getMtarihi() {
        return mtarihi;
    }

    public void setMtarihi(String mtarihi) {
        this.mtarihi = mtarihi;
    }

    public String getSonrakimtarih() {
        return sonrakimtarih;
    }

    public void setSonrakimtarih(String sonrakimtarih) {
        this.sonrakimtarih = sonrakimtarih;
    }

    public String getAnnehastalikg() {
        return annehastalikg;
    }

    public void setAnnehastalikg(String annehastalikg) {
        this.annehastalikg = annehastalikg;
    }

    public String getBabahastalikg() {
        return babahastalikg;
    }

    public void setBabahastalikg(String babahastalikg) {
        this.babahastalikg = babahastalikg;
    }

    public String getCocukhastalikg() {
        return cocukhastalikg;
    }

    public void setCocukhastalikg(String cocukhastalikg) {
        this.cocukhastalikg = cocukhastalikg;
    }

    public String getKardeshastalikg() {
        return kardeshastalikg;
    }

    public void setKardeshastalikg(String kardeshastalikg) {
        this.kardeshastalikg = kardeshastalikg;
    }

    public int getBüyüktan() {
        return büyüktan;
    }

    public void setBüyüktan(int büyüktan) {
        this.büyüktan = büyüktan;
    }

    public int getKücüktan() {
        return kücüktan;
    }

    public void setKücüktan(int kücüktan) {
        this.kücüktan = kücüktan;
    }

    public int getNabiz() {
        return nabiz;
    }

    public void setNabiz(int nabiz) {
        this.nabiz = nabiz;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    public String getKangrup() {
        return kangrup;
    }

    public void setKangrup(String kangrup) {
        this.kangrup = kangrup;
    }

    public int getSicilno() {
        return sicilno;
    }

    public void setSicilno(int sicilno) {
        this.sicilno = sicilno;
    }

    public int getSicilnop() {
        return sicilnop;
    }

    public void setSicilnop(int sicilnop) {
        this.sicilnop = sicilnop;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    
    @Override
    public String toString() {
        return "muayene{" + "mid=" + mid + ", mneden=" + mneden + ", mtarihi=" + mtarihi + ", sonrakimtarih=" + sonrakimtarih + ", annehastalikg=" + annehastalikg + ", babahastalikg=" + babahastalikg + ", cocukhastalikg=" + cocukhastalikg + ", kardeshastalikg=" + kardeshastalikg + ", b\u00fcy\u00fcktan=" + büyüktan + ", k\u00fcc\u00fcktan=" + kücüktan + ", nabiz=" + nabiz + ", kilo=" + kilo + ", boy=" + boy + ", kangrup=" + kangrup + ", sicilno=" + sicilno + ", sicilnop=" + sicilnop + '}';
    }
    
}
