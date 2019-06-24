package Controller;

import Dao.MuayeneDAO;
import Entity.Muayene;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class MuayeneBEAN implements Serializable {

    private List<Muayene> muayenelist;
    private MuayeneDAO muayeneDao;

    private Muayene muayene;
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

    public void ara() {
        this.page = 1;
        this.getMuayenelist();
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
        this.pageCount = (int) Math.ceil(this.getMuayeneDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.muayene = new Muayene();
        return "tmm";
    }

    public String updateForm(Muayene m) {
        this.muayene = m;
        return "tmm";
    }

    public String update() {
        this.getMuayeneDao().update(this.muayene);
        this.muayene = new Muayene();
        return "tmm";
    }

    public String delete(Muayene m) {
        this.getMuayeneDao().delete(m);
        this.muayene = new Muayene();
        return "tmm";
    }

    public String create() {
        this.muayene.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getMuayeneDao().insert(this.muayene);
        this.muayene = new Muayene();
        return "muayene";
    }

    public List<Muayene> getMuayenelist() {
        
        
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.muayenelist = this.getMuayeneDao().findAll(page, pageSize, arama, userid);
        return muayenelist;
    }

    public void setMuayenelist(List<Muayene> muayenelist) {
        this.muayenelist = muayenelist;
    }

    public MuayeneDAO getMuayeneDao() {
        if (this.muayeneDao == null) {
            this.muayeneDao = new MuayeneDAO();
        }
        return muayeneDao;
    }

    public void setMuayeneDao(MuayeneDAO muayeneDao) {
        this.muayeneDao = muayeneDao;
    }

    public Muayene getMuayene() {
        if (this.muayene == null) {
            this.muayene = new Muayene();
        }
        return muayene;
    }

    public void setMuayene(Muayene muayene) {
        this.muayene = muayene;
    }

}
