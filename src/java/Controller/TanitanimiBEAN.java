package Controller;

import Dao.TanitanimiDAO;
import Entity.Tanitanimi;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class TanitanimiBEAN implements Serializable {

    private List<Tanitanimi> tanitanimilist;
    private TanitanimiDAO tanitanimiDao;
    private Tanitanimi tanitanimi;

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
        this.getTanitanimilist();
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
        this.pageCount = (int) Math.ceil(this.getTanitanimiDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.tanitanimi = new Tanitanimi();
        return "tmm";
    }

    public String updateForm(Tanitanimi tt) {
        this.tanitanimi = tt;
        return "tmm";
    }

    public String update() {
        this.getTanitanimiDao().update(this.tanitanimi);
        this.tanitanimi = new Tanitanimi();
        return "tmm";
    }

    public String delete(Tanitanimi t) {
        this.getTanitanimiDao().delete(t);
        this.tanitanimi = new Tanitanimi();
        return "tmm";
    }

    public String create() {
        this.tanitanimi.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getTanitanimiDao().insert(this.tanitanimi);
        this.tanitanimi = new Tanitanimi();
        return "tmm";
    }

    public List<Tanitanimi> getTanitanimilist() {
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.tanitanimilist = this.getTanitanimiDao().findAll(page, pageSize, arama, userid);
        return tanitanimilist;
    }

    public void setTanitanimilist(List<Tanitanimi> tanitanimilist) {
        this.tanitanimilist = tanitanimilist;
    }

    public TanitanimiDAO getTanitanimiDao() {
        if (this.tanitanimiDao == null) {
            this.tanitanimiDao = new TanitanimiDAO();
        }
        return tanitanimiDao;
    }

    public void setTanitanimiDao(TanitanimiDAO tanitanimiDao) {
        this.tanitanimiDao = tanitanimiDao;
    }

    public Tanitanimi getTanitanimi() {
        if (this.tanitanimi == null) {
            this.tanitanimi = new Tanitanimi();
        }
        return tanitanimi;
    }

    public void setTanitanimi(Tanitanimi tanitanimi) {
        this.tanitanimi = tanitanimi;
    }

}
