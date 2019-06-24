package Controller;

import Dao.IlactanimiDAO;
import Dao.ReceteDAO;
import Dao.ReceteilacDAO;
import Entity.Ilactanimi;
import Entity.Recete;
import Entity.Receteilac;
import Utility.SessionUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ReceteilacBEAN implements Serializable {

    private List<Receteilac> receteilaclist;
    private ReceteilacDAO receteilacDao = null;
    private Receteilac receteilac;
    private Recete rct = null;
    private ArrayList<Recete> rlist = null;
    private ReceteDAO receteDAO;
    private IlactanimiDAO ilactanimiDAO;
    private Ilactanimi it = null;
    private ArrayList<Ilactanimi> itlist = null;
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
        this.getReceteilaclist();
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
        this.pageCount = (int) Math.ceil(this.getReceteilacDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<Ilactanimi> getItlist() {
        this.itlist = (ArrayList<Ilactanimi>) this.getIlactanimiDAO().findAll(page, pageSize);
        return itlist;
    }

    public void setItlist(ArrayList<Ilactanimi> itlist) {
        this.itlist = itlist;
    }

    public IlactanimiDAO getIlactanimiDAO() {
        if (this.ilactanimiDAO == null) {
            this.ilactanimiDAO = new IlactanimiDAO();
        }
        return ilactanimiDAO;
    }

    public void setIlactanimiDAO(IlactanimiDAO ilactanimiDAO) {
        this.ilactanimiDAO = ilactanimiDAO;
    }

    public Ilactanimi getIt() {
        if (this.it == null) {
            this.it = new Ilactanimi();
        }
        return it;
    }

    public void setIt(Ilactanimi it) {
        this.it = it;
    }

    public ArrayList<Recete> getRlist() {
        if (this.rlist == null) {
            this.rlist = new ArrayList();
        }
        rlist = (ArrayList<Recete>) this.getReceteDAO().findAll(page, pageSize);
        return rlist;
    }

    public void setRlist(ArrayList<Recete> rlist) {
        this.rlist = rlist;
    }

    public ReceteDAO getReceteDAO() {
        if (this.receteDAO == null) {
            this.receteDAO = new ReceteDAO();
        }
        return receteDAO;
    }

    public String clearForm() {
        this.receteilac = new Receteilac();
        return "tmm";
    }

    public String updateForm(Receteilac ri) {
        this.receteilac = ri;
        return "tmm";
    }

    public String update() {
        this.getReceteilacDao().update(this.receteilac);
        this.receteilac = new Receteilac();
        return "tmm";
    }

    public String delete(Receteilac ri) {
        this.getReceteilacDao().delete(ri);
        this.receteilac = new Receteilac();
        return "tmm";
    }

    public String create() {
        this.receteilac.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getReceteilacDao().insert(this.receteilac);
        this.receteilac = new Receteilac();
        return "tmm";
    }

    public List<Receteilac> getReceteilaclist() {
        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();
        this.receteilaclist = this.getReceteilacDao().findAll(page, pageSize, arama, userid);
        return receteilaclist;
    }

    public void setReceteilaclist(List<Receteilac> receteilaclist) {
        this.receteilaclist = receteilaclist;
    }

    public ReceteilacDAO getReceteilacDao() {
        if (this.receteilacDao == null) {
            this.receteilacDao = new ReceteilacDAO();
        }
        return receteilacDao;
    }

    public void setReceteilacDao(ReceteilacDAO receteilacDao) {
        this.receteilacDao = receteilacDao;
    }

    public Receteilac getReceteilac() {
        if (this.receteilac == null) {
            this.receteilac = new Receteilac();
        }
        return receteilac;
    }

    public void setReceteilac(Receteilac receteilac) {
        this.receteilac = receteilac;
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
