
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Kullanici implements Serializable{
   
    private int sicilno;
    private String gorevtanim;
    private String tc;
    private String ad;
    private String soyad;
    private String durum;
    private double boy;
    private double kilo;
    private String kangrup;
    private String cinsiyet;
    private String dogumtarih;
    private String dogumyer;
    private String statü;
    private String ogrenimdurum;
    private String isgkurulgorev;
    private String isebaslangictarih;
    private String unvan;

    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Kullanici() {
    }

    public Kullanici(int sicilno, String gorevtanim, String tc, String ad, String soyad, String durum, double boy, double kilo, String kangrup, String cinsiyet, String dogumtarih, String dogumyer, String statü, String ogrenimdurum, String isgkurulgorev, String isebaslangictarih, String unvan) {
        this.sicilno = sicilno;
        this.gorevtanim = gorevtanim;
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.durum = durum;
        this.boy = boy;
        this.kilo = kilo;
        this.kangrup = kangrup;
        this.cinsiyet = cinsiyet;
        this.dogumtarih = dogumtarih;
        this.dogumyer = dogumyer;
        this.statü = statü;
        this.ogrenimdurum = ogrenimdurum;
        this.isgkurulgorev = isgkurulgorev;
        this.isebaslangictarih = isebaslangictarih;
        this.unvan = unvan;
    }
    public int getSicilno() {
        return sicilno;
    }

    public void setSicilno(int sicilno) {
        this.sicilno = sicilno;
    }

    public String getGorevtanim() {
        return gorevtanim;
    }

    public void setGorevtanim(String gorevtanim) {
        this.gorevtanim = gorevtanim;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
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

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
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

    public String getKangrup() {
        return kangrup;
    }

    public void setKangrup(String kangrup) {
        this.kangrup = kangrup;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
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

    public String getStatü() {
        return statü;
    }

    public void setStatü(String statü) {
        this.statü = statü;
    }

    public String getOgrenimdurum() {
        return ogrenimdurum;
    }

    public void setOgrenimdurum(String ogrenimdurum) {
        this.ogrenimdurum = ogrenimdurum;
    }

    public String getIsgkurulgorev() {
        return isgkurulgorev;
    }

    public void setIsgkurulgorev(String isgkurulgorev) {
        this.isgkurulgorev = isgkurulgorev;
    }

    public String getIsebaslangictarih() {
        return isebaslangictarih;
    }

    public void setIsebaslangictarih(String isebaslangictarih) {
        this.isebaslangictarih = isebaslangictarih;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }
    
    
}
