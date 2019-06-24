package Controller;

import Dao.KullaniciDAO;
import Entity.Kullanici;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class KullaniciBEAN implements Serializable {

    private List<Kullanici> kullanicilist;
    private KullaniciDAO kullaniciDao;
    private Kullanici kullanici;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    
    String arama;

    public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }
    
    public void ara(){
        this.page = 1;
        this.getKullanicilist();
    }
    
    
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
        this.pageCount = (int) Math.ceil(this.getKullaniciDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String updateForm(Kullanici k) {
        this.kullanici = k;
        return "tmm";
    }

    public String clearForm() {
        this.kullanici = new Kullanici();
        return "tmm";
    }

    public String update() {
        this.getKullaniciDao().update(this.kullanici);
        this.kullanici = new Kullanici();
        return "tmm";
    }

    public String delete(Kullanici k) {
        this.getKullaniciDao().delete(k);
        this.kullanici = new Kullanici();
        return "tmm";
    }

    public String create() {
        this.kullanici.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getKullaniciDao().insert(this.kullanici);
        this.kullanici = new Kullanici();
        return "tmm";
    }

    public List<Kullanici> getKullanicilist() {
        
        
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.kullanicilist = this.getKullaniciDao().findAll(page, pageSize, arama, userid);
        return kullanicilist;
    }

    public void setKullanicilist(List<Kullanici> kullanicilist) {
        this.kullanicilist = kullanicilist;
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

}
