package Controller;

import Dao.MuayeneDAO;
import Dao.ReceteDAO;
import Entity.Muayene;
import Entity.Recete;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ReceteBEAN implements Serializable {

    private List<Recete> recetelist;
    private ReceteDAO receteDao;
    private MuayeneDAO muayeneDAO = null;
    private Recete recete;
    private Recete rct = null;
    private ArrayList<Muayene> mlist = null;
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
        this.getRecetelist();
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
        this.pageCount = (int) Math.ceil(this.getReceteDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public MuayeneDAO getMuayeneDAO() {
        if (this.muayeneDAO == null) {
            this.muayeneDAO = new MuayeneDAO();
        }
        return muayeneDAO;
    }

    public void setMuayeneDAO(MuayeneDAO muayeneDAO) {
        this.muayeneDAO = muayeneDAO;
    }

    public ArrayList<Muayene> getMlist() {
        this.mlist = (ArrayList<Muayene>) this.getMuayeneDAO().findAll(page, pageSize);
        return mlist;
    }

    public void setMlist(ArrayList<Muayene> mlist) {
        this.mlist = mlist;
    }

    public String updateForm(Recete r) {
        this.recete = r;
        return "tmm";
    }

    public String clearForm() {
        this.recete = new Recete();
        return "tmm";
    }

    public String update() {
        this.getReceteDao().update(this.recete);
        this.recete = new Recete();
        return "tmm";
    }

    public String delete(Recete r) {
        this.getReceteDao().delete(r);
        this.recete = new Recete();
        return "tmm";
    }

    public String create() {
        this.recete.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getReceteDao().insert(this.recete);
        this.recete = new Recete();
        return "tmm";
    }

    public List<Recete> getRecetelist() {
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.recetelist = this.getReceteDao().findAll(page, pageSize, arama, userid);
        return recetelist;
    }

    public void setRecetelist(List<Recete> recetelist) {
        this.recetelist = recetelist;
    }

    public ReceteDAO getReceteDao() {
        if (this.receteDao == null) {
            this.receteDao = new ReceteDAO();
        }
        return receteDao;
    }

    public void setReceteDao(ReceteDAO receteDao) {
        this.receteDao = receteDao;
    }

    public Recete getRecete() {
        if (this.recete == null) {
            this.recete = new Recete();
        }
        return recete;
    }

    public void setRecete(Recete recete) {
        this.recete = recete;
    }

    public Recete getRct() {
        if (this.rct == null) {
            this.rct = new Recete();
        }
        return rct;
    }

    public void setRct(Recete rct) {
        this.rct = rct;
    }

}
