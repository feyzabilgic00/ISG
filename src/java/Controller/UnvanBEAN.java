package Controller;

import Dao.UnvanDAO;
import Entity.Unvan;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class UnvanBEAN implements Serializable {

    private List<Unvan> unvanlist;
    private UnvanDAO unvanDao;
    private Unvan unvan;
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
        this.getUnvanlist();
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
        this.pageCount = (int) Math.ceil(this.getUnvanDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.unvan = new Unvan();
        return "tmm";
    }

    public String updateForm(Unvan u) {
        this.unvan = u;
        return "tmm";
    }

    public String update() {
        this.getUnvanDao().update(this.unvan);
        this.unvan = new Unvan();
        return "tmm";
    }

    public String delete(Unvan u) {
        this.getUnvanDao().delete(u);
        this.unvan = new Unvan();
        return "tmm";
    }

    public String create() {
        this.unvan.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getUnvanDao().insert(this.unvan);
        this.unvan = new Unvan();
        return "tmm";
    }

    public List<Unvan> getUnvanlist() {
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.unvanlist = this.getUnvanDao().findAll(page, pageSize, arama, userid);
        return unvanlist;
    }

    public void setUnvanlist(List<Unvan> unvanlist) {
        this.unvanlist = unvanlist;
    }

    public UnvanDAO getUnvanDao() {
        if (this.unvanDao == null) {
            this.unvanDao = new UnvanDAO();
        }
        return unvanDao;
    }

    public void setUnvanDao(UnvanDAO unvanDao) {
        this.unvanDao = unvanDao;
    }

    public Unvan getUnvan() {
        if (this.unvan == null) {
            this.unvan = new Unvan();
        }
        return unvan;
    }

    public void setUnvan(Unvan unvan) {
        this.unvan = unvan;
    }

}
