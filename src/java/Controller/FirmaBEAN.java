package Controller;

import Dao.FirmaDAO;
import Dao.FirmagruplariDAO;
import Entity.Firma;
import Entity.Firmagruplari;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class FirmaBEAN implements Serializable {

    private List<Firma> firmalist;
    private FirmaDAO firmaDao;

    private Firma firma;
    private FirmagruplariDAO firmagruplariDao;
    private Long selectedTehlikeSınıfı;
    private Long selectedGrupSirket;
    int[] kullaniciids;

    private KullaniciBEAN kullaniciBEAN;

    String arama;

    public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }

    public void ara() {
        this.page = 1;
        this.getFirmalist();
    }

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.pageCount) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.pageCount;
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getFirmaDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String updateForm(Firma firm) {
        this.setFirma(firm);
        return "tmm";
    }

    public String update() {
        this.getFirmaDao().update(this.firma);
        this.firma = new Firma();
        return "tmm";
    }

    public String clearForm() {
        this.firma = new Firma();
        return "tmm";
    }

    public String deleteConfirm(Firma firm) {
        this.firma = firm;
        return "confirm_delete";
    }

    public String delete(Firma fir) {
        this.getFirmaDao().delete(fir);
        this.firma = new Firma();
        return "firma.xhtml";
    }

    public String create() {

        this.firma.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        
        this.getFirmaDao().insert(this.firma, this.kullaniciids);
        this.firma = new Firma();
        return "tmm";
    }

    public List<Firma> getFirmalist() {

        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();

        this.firmalist = this.getFirmaDao().findAll(page, pageSize, arama, userid);
        return firmalist;
    }

    public void setFirmalist(List<Firma> firmalist) {
        this.firmalist = firmalist;
    }

    public FirmaDAO getFirmaDao() {
        if (this.firmaDao == null) {
            this.firmaDao = new FirmaDAO();
        }
        return firmaDao;
    }

    public void setFirmaDao(FirmaDAO firmaDao) {
        this.firmaDao = firmaDao;
    }

    public Firma getFirma() {
        if (this.firma == null) {
            this.firma = new Firma();
        }
        return firma;

    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public FirmagruplariDAO getFirmagruplariDao() {
        if (this.firmagruplariDao == null) {
            this.firmagruplariDao = new FirmagruplariDAO();
        }
        return firmagruplariDao;
    }

    public Long getSelectedTehlikeSınıfı() {
        return selectedTehlikeSınıfı;
    }

    public void setSelectedTehlikeSınıfı(Long selectedTehlikeSınıfı) {
        this.selectedTehlikeSınıfı = selectedTehlikeSınıfı;
    }

    public Long getSelectedGrupSirket() {
        return selectedGrupSirket;
    }

    public void setSelectedGrupSirket(Long selectedGrupSirket) {
        this.selectedGrupSirket = selectedGrupSirket;
    }

    public int[] getKullaniciids() {
        return kullaniciids;
    }

    public void setKullaniciids(int[] kullaniciids) {
        this.kullaniciids = kullaniciids;
    }

    public KullaniciBEAN getKullaniciBEAN() {
        return kullaniciBEAN;
    }

    public void setKullaniciBEAN(KullaniciBEAN kullaniciBEAN) {
        this.kullaniciBEAN = kullaniciBEAN;
    }

}
