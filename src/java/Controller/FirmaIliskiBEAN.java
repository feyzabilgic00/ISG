package Controller;

import Dao.FirmaDAO;
import Dao.FirmagruplariDAO;
import Dao.KullanicifirmaDAO;
import Entity.Firma;
import Entity.Kullanicifirma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class FirmaIliskiBEAN implements Serializable {

    private List<Kullanicifirma> itemlist;
    private List<Kullanicifirma> datatable;
    final KullanicifirmaDAO kullanicifirmaDAO;
    Kullanicifirma kullanicifirma;
    ArrayList<SelectItem> firmalar;
    ArrayList<SelectItem> kullanicilar;
    ArrayList<SelectItem> personeller;
    int firmaid;
    int[] kullaniciids;
 
    public FirmaIliskiBEAN() {
        itemlist = new ArrayList<>();
        kullanicifirmaDAO = new KullanicifirmaDAO();
        this.kullanicifirma = new Kullanicifirma();
        this.datatable = this.kullanicifirmaDAO.getKullaniciFirmas();
    }

    public String updateForm(Kullanicifirma firm) {

        return "tmm";
    }

    public String update() {

        return "tmm";
    }

    public String clearForm() {
        itemlist = new ArrayList<>();
        return "tmm";
    }

    public String deleteConfirm(Kullanicifirma kullanicifirma) {
        this.kullanicifirma = kullanicifirma;
        return "confirm_delete";
    }

    public String delete(Firma fir) {

        return "firma.xhtml";
    }

    public String create() {
        this.kullanicifirmaDAO.create(this.itemlist);
        this.datatable = this.kullanicifirmaDAO.getKullaniciFirmas();
        return "tmm";
    }

    public List<Kullanicifirma> getDatatable() {
        return datatable;
    }

    public void setDatatable(List<Kullanicifirma> datatable) {
        this.datatable = datatable;
    }

    public ArrayList<SelectItem> getFirmalar() {
        return this.kullanicifirmaDAO.firmaListesi();
    }

    public void setFirmalar(ArrayList<SelectItem> firmalar) {
        this.firmalar = firmalar;
    }

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public int[] getKullaniciids() {
        return kullaniciids;
    }

    public void setKullaniciids(int[] kullaniciids) {
        this.kullaniciids = kullaniciids;
    }

    public ArrayList<SelectItem> getKullanicilar() {
        return this.kullanicifirmaDAO.kullaniciListesi();
    }

    public void setKullanicilar(ArrayList<SelectItem> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    
    public ArrayList<SelectItem> getPersoneller() {
        return this.kullanicifirmaDAO.personelListesi();
    }
 
    
    
    
}
