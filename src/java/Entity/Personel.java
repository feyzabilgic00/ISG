
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Personel implements Serializable{
   
    private int sicilnop;
    private String ad;
    private String soyad;
    private String unvan;
    private String ogrenimdurum;
    private String cinsiyet;
    private double boy;
    private double kilo;
    private String isegiristrh;
    private String dogumtarih;
    private String dogumyer;
    private int firmaid;
    private String cv;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    private Firma firma;
    
    public Personel() {
    }

    public Personel(int sicilnop, String ad, String soyad, String unvan, String ogrenimdurum, String cinsiyet, double boy, double kilo, String isegiristrh, String dogumtarih, String dogumyer, int firmaid) {
        this.sicilnop = sicilnop;
        this.ad = ad;
        this.soyad = soyad;
        this.unvan = unvan;
        this.ogrenimdurum = ogrenimdurum;
        this.cinsiyet = cinsiyet;
        this.boy = boy;
        this.kilo = kilo;
        this.isegiristrh = isegiristrh;
        this.dogumtarih = dogumtarih;
        this.dogumyer = dogumyer;
        this.firmaid = firmaid;
    }
    
    public int getSicilnop() {
        return sicilnop;
    }

    public void setSicilnop(int sicilnop) {
        this.sicilnop = sicilnop;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getOgrenimdurum() {
        return ogrenimdurum;
    }

    public void setOgrenimdurum(String ogrenimdurum) {
        this.ogrenimdurum = ogrenimdurum;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public String getIsegiristrh() {
        return isegiristrh;
    }

    public void setIsegiristrh(String isegiristrh) {
        this.isegiristrh = isegiristrh;
    }

    public String getDogumtarih() {
        return dogumtarih;
    }

    public void setDogumtarih(String dogumtarih) {
        this.dogumtarih = dogumtarih;
    }

    public String getDogumyer() {
        return dogumyer;
    }

    public void setDogumyer(String dogumyer) {
        this.dogumyer = dogumyer;
    }

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "personel{" + "sicilnop=" + sicilnop + ", ad=" + ad + ", soyad=" + soyad + ", unvan=" + unvan + ", ogrenimdurum=" + ogrenimdurum + ", cinsiyet=" + cinsiyet + ", boy=" + boy + ", kilo=" + kilo + ", isegiristrh=" + isegiristrh + ", dogumtarih=" + dogumtarih + ", dogumyer=" + dogumyer + ", firmaid=" + firmaid + '}';
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
    
}
