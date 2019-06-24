package Entity;

import java.util.ArrayList;
import java.util.List;

public class Firma {

    private int firmaid;
    private String funvan;
    private String isvrnadsoyad;
    private String isvrngsm;
    private String firmatlfn;
    private String faks;
    private String firmamail;
    private String il;
    private String ilce;
    private String adres;
    private String faaliyetalan;
    private String sgksicil;
    private String tehlikesinif;
    private String grupsirket;
    private String durum;
    private int grup_id;
    
    private Firmagruplari firmagruplari;
    private ArrayList<Kullanici> firmaKullanicis;
    
    int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    public Firma() {
    }

    public Firma(int firmaid, String funvan, String isvrnadsoyad, String isvrngsm, String firmatlfn, String faks, String firmamail, String il, String ilce, String adres, String faaliyetalan, String sgksicil, String tehlikesinif, String grupsirket, String durum, int grup_id) {
        this.firmaid = firmaid;
        this.funvan = funvan;
        this.isvrnadsoyad = isvrnadsoyad;
        this.isvrngsm = isvrngsm;
        this.firmatlfn = firmatlfn;
        this.faks = faks;
        this.firmamail = firmamail;
        this.il = il;
        this.ilce = ilce;
        this.adres = adres;
        this.faaliyetalan = faaliyetalan;
        this.sgksicil = sgksicil;
        this.tehlikesinif = tehlikesinif;
        this.grupsirket = grupsirket;
        this.durum = durum;
        this.grup_id = grup_id;
    }

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public String getFunvan() {
        return funvan;
    }

    public void setFunvan(String funvan) {
        this.funvan = funvan;
    }

    public String getIsvrnadsoyad() {
        return isvrnadsoyad;
    }

    public void setIsvrnadsoyad(String isvrnadsoyad) {
        this.isvrnadsoyad = isvrnadsoyad;
    }

    public String getIsvrngsm() {
        return isvrngsm;
    }

    public void setIsvrngsm(String isvrngsm) {
        this.isvrngsm = isvrngsm;
    }

    public String getFirmatlfn() {
        return firmatlfn;
    }

    public void setFirmatlfn(String firmatlfn) {
        this.firmatlfn = firmatlfn;
    }

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    public String getFirmamail() {
        return firmamail;
    }

    public void setFirmamail(String firmamail) {
        this.firmamail = firmamail;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getFaaliyetalan() {
        return faaliyetalan;
    }

    public void setFaaliyetalan(String faaliyetalan) {
        this.faaliyetalan = faaliyetalan;
    }

    public String getSgksicil() {
        return sgksicil;
    }

    public void setSgksicil(String sgksicil) {
        this.sgksicil = sgksicil;
    }

    public String getTehlikesinif() {
        return tehlikesinif;
    }

    public void setTehlikesinif(String tehlikesinif) {
        this.tehlikesinif = tehlikesinif;
    }

    public String getGrupsirket() {
        return grupsirket;
    }

    public void setGrupsirket(String grupsirket) {
        this.grupsirket = grupsirket;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public int getGrup_id() {
        return grup_id;
    }

    public void setGrup_id(int grup_id) {
        this.grup_id = grup_id;
    }

    public Firmagruplari getFirmagruplari() {
        return firmagruplari;
    }

    public void setFirmagruplari(Firmagruplari firmagruplari) {
        this.firmagruplari = firmagruplari;
    }

    public ArrayList<Kullanici> getFirmaKullanicis() {
        return firmaKullanicis;
    }

    public void setFirmaKullanicis(ArrayList<Kullanici> firmaKullanicis) {
        this.firmaKullanicis = firmaKullanicis;
    }

    @Override
    public String toString() {
        return "firma{" + "firmaid=" + firmaid + ", funvan=" + funvan + ", isvrnadsoyad=" + isvrnadsoyad + ", isvrngsm=" + isvrngsm + ", firmatlfn=" + firmatlfn + ", faks=" + faks + ", firmamail=" + firmamail + ", il=" + il + ", ilce=" + ilce + ", adres=" + adres + ", faaliyetalan=" + faaliyetalan + ", sgksicil=" + sgksicil + ", tehlikesinif=" + tehlikesinif + ", grupsirket=" + grupsirket + ", durum=" + durum + ", grup_id=" + grup_id + '}';
    }

}
