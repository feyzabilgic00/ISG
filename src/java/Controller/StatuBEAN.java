package Controller;

import Dao.StatuDAO;
import Entity.Statu;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class StatuBEAN implements Serializable {

    private List<Statu> statulist;
    private StatuDAO statuDao;
    private Statu statu;
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
        this.getStatulist();
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
        this.pageCount = (int) Math.ceil(this.getStatuDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.statu = new Statu();
        return "tmm";
    }

    public String updateForm(Statu s) {
        this.statu = s;
        return "tmm";
    }

    public String update() {
        this.getStatuDao().update(this.statu);
        this.statu = new Statu();
        return "tmm";
    }

    public String delete(Statu s) {
        this.getStatuDao().delete(s);
        this.statu = new Statu();
        return "tmm";
    }

    public String create() {
        this.statu.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getStatuDao().insert(this.statu);
        this.statu = new Statu();
        return "tmm";
    }

    public List<Statu> getStatulist() {
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.statulist = this.getStatuDao().findAll(page, pageSize, arama, userid);
        return statulist;
    }

    public void setStatulist(List<Statu> statulist) {
        this.statulist = statulist;
    }

    public StatuDAO getStatuDao() {
        if (this.statuDao == null) {
            this.statuDao = new StatuDAO();
        }
        return statuDao;
    }

    public void setStatuDao(StatuDAO statuDao) {
        this.statuDao = statuDao;
    }

    public Statu getStatu() {
        if (this.statu == null) {
            this.statu = new Statu();
        }
        return statu;
    }

    public void setStatu(Statu statu) {
        this.statu = statu;
    }

}
