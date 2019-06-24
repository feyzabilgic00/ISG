package Controller;

import Dao.FirmagruplariDAO;
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
public class FirmagruplariBEAN implements Serializable {

    private List<Firmagruplari> firmagruplarilist;
    private FirmagruplariDAO firmagruplariDao;

    private Firmagruplari firmagruplari;
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
        this.getFirmagruplarilist();
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
        this.pageCount = (int) Math.ceil(this.getFirmagruplariDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String clearForm() {
        this.firmagruplari = new Firmagruplari();
        return "tmm";
    }

    public String updateForm(Firmagruplari fgrp) {
        this.setFirmagruplari(fgrp);
        return "tmm";
    }

    public String update() {
        this.getFirmagruplariDao().update(this.firmagruplari);
        this.firmagruplari = new Firmagruplari();
        return "tmm";
    }

    public String delete(Firmagruplari fgrp) {
        this.getFirmagruplariDao().delete(fgrp);
        this.firmagruplari = new Firmagruplari();
        return "tmm";
    }

    public String create() {
        this.firmagruplari.setUser_id((int) SessionUtility.getSession().getAttribute("userId"));

        this.getFirmagruplariDao().insert(this.firmagruplari);
        this.firmagruplari = new Firmagruplari();
        return "tmm";
    }

    public List<Firmagruplari> getFirmagruplarilist() {

        HttpSession session = SessionUtility.getSession();
        String userid = session.getAttribute("userId").toString();

        this.firmagruplarilist = this.getFirmagruplariDao().findAll(page, pageSize, arama, userid);
        return firmagruplarilist;
    }

    public void setFirmagruplarilist(List<Firmagruplari> firmagruplarilist) {
        this.firmagruplarilist = firmagruplarilist;
    }

    public FirmagruplariDAO getFirmagruplariDao() {
        if (this.firmagruplariDao == null) {
            this.firmagruplariDao = new FirmagruplariDAO();
        }
        return firmagruplariDao;
    }

    public void setFirmagruplariDao(FirmagruplariDAO firmagruplariDao) {
        this.firmagruplariDao = firmagruplariDao;
    }

    public Firmagruplari getFirmagruplari() {
        if (this.firmagruplari == null) {
            this.firmagruplari = new Firmagruplari();
        }
        return firmagruplari;
    }

    public void setFirmagruplari(Firmagruplari firmagruplari) {
        this.firmagruplari = firmagruplari;
    }

}
