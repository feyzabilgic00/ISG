package Controller;

import Dao.PersonelDAO;
import Entity.Personel;
import Utility.SessionUtility;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class PersonelBEAN implements Serializable {

    private List<Personel> personellist;
    private PersonelDAO personelDao;
    private Personel personel;
    
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    Part dosya;

    public Part getDosya() {
        return dosya;
    }

    public void setDosya(Part dosya) {
        this.dosya = dosya;
    }

    String arama;

    public String getArama() {
        return arama;
    }

    public void setArama(String arama) {
        this.arama = arama;
    }

    public void ara() {
        this.page = 1;
        this.getPersonellist();
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
        this.pageCount = (int) Math.ceil(this.getPersonelDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.personel = new Personel();
        return "personel";
    }

    public String updateForm(Personel p) {
        this.personel = p;
        return "personel";
    }

    public String update() {

        if (dosya != null) {
            try {
                String resimName = "";

                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                        .getExternalContext().getContext();
                String realPath = ctx.getRealPath("/");

                resimName = getFilename(dosya);
                this.personel.setCv(resimName);

                dosya.write(realPath + "\\dosyalar\\" + resimName);

            } catch (IOException ex) {
                Logger.getLogger(PersonelBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        this.getPersonelDao().update(this.personel);
        this.personel = new Personel();
        return "personel";
    }

    public String delete(Personel p) {
        this.getPersonelDao().delete(p);
        this.personel = new Personel();
        return "personel";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public String create() {

        if (dosya != null) {
            try {
                String resimName = "";

                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                        .getExternalContext().getContext();
                String realPath = ctx.getRealPath("/");

                resimName = getFilename(dosya);
                this.personel.setCv(resimName);

                dosya.write(realPath + "\\dosyalar\\" + resimName);

            } catch (IOException ex) {
                Logger.getLogger(PersonelBEAN.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        this.personel.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));
        this.getPersonelDao().insert(this.personel);
        this.personel = new Personel();
        return "personel";
    }

    public List<Personel> getPersonellist() {

        try {
            HttpSession session = SessionUtility.getSession();
            String userid = session.getAttribute("userId").toString();
            this.personellist = this.getPersonelDao().findAll(page, pageSize, arama, userid);
        } catch (Exception e) {
            this.personellist = this.getPersonelDao().findAll(page, pageSize, arama, "2");
        }
        return personellist;
    }

    public void setPersonellist(List<Personel> personellist) {
        this.personellist = personellist;
    }

    public PersonelDAO getPersonelDao() {
        if (this.personelDao == null) {
            this.personelDao = new PersonelDAO();
        }
        return personelDao;
    }

    public void setPersonelDao(PersonelDAO personelDao) {
        this.personelDao = personelDao;
    }

    public Personel getPersonel() {
        if (this.personel == null) {
            this.personel = new Personel();
        }
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

}
