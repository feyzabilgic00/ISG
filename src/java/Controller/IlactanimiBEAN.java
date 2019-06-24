package Controller;

import Dao.IlactanimiDAO;
import Entity.Ilactanimi;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class IlactanimiBEAN implements Serializable {

    private List<Ilactanimi> ilactanimilist;
    private IlactanimiDAO ilactanimiDao;

    private Ilactanimi ilactanimi;

    String arama;

    public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }

    public void ara() {
        this.page = 1;
        this.getIlactanimilist();
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
        this.pageCount = (int) Math.ceil(this.getIlactanimiDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.ilactanimi = new Ilactanimi();
        return "tmm";
    }

    public String updateForm(Ilactanimi ilc) {
        this.setIlactanimi(ilc);
        return "tmm";
    }

    public String update() {
        this.getIlactanimiDao().update(this.ilactanimi);
        this.ilactanimi = new Ilactanimi();
        return "tmm";
    }

    public String delete(Ilactanimi ilc) {
        this.getIlactanimiDao().delete(ilc);
        this.ilactanimi = new Ilactanimi();
        return "tmm";
    }

    public String create() {
        this.ilactanimi.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));

        this.getIlactanimiDao().insert(this.ilactanimi);
        return "tmm";
    }

    public List<Ilactanimi> getIlactanimilist() {

        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();

        this.ilactanimilist = this.getIlactanimiDao().findAll(page, pageSize, arama, userid);
        return ilactanimilist;
    }

    public void setIlactanimilist(List<Ilactanimi> ilactanimilist) {
        this.ilactanimilist = ilactanimilist;
    }

    public IlactanimiDAO getIlactanimiDao() {
        if (this.ilactanimiDao == null) {
            this.ilactanimiDao = new IlactanimiDAO();
        }
        return ilactanimiDao;
    }

    public void setIlactanimiDao(IlactanimiDAO ilactanimiDao) {
        this.ilactanimiDao = ilactanimiDao;
    }

    public Ilactanimi getIlactanimi() {
        if (this.ilactanimi == null) {
            this.ilactanimi = new Ilactanimi();
        }
        return ilactanimi;
    }

    public void setIlactanimi(Ilactanimi ilactanimi) {
        this.ilactanimi = ilactanimi;
    }

}
