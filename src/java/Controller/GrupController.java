/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.GrupDao;
import Entity.Grup;
import java.io.Serializable;
import java.util.List;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean
@ViewScoped
public class GrupController implements Serializable {

    private Grup grup;
    private List<Grup> grupList;
    private GrupDao grupDao;

    //-----------Pagination-------------- 
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
    //---------Pagination-------------- 
    
    //--CRUD
    public void updateForm(Grup grup) {
        this.grup = grup;
    }
    
    public void clearForm(){
        this.grup = new Grup();
    }

    public void delete() {
        this.getGrupDao().remove(this.grup);
        clearForm();
    }
    
    public void update() {
        this.getGrupDao().edit(this.grup);
        clearForm();
    }

    public void create() {
        this.getGrupDao().insert(this.grup);
        clearForm();
    }
    //------
    
    public Grup getGrup() {
        if (this.grup == null) {
            this.grup = new Grup();
        }
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public List<Grup> getGrupList() {
        this.grupList = this.getGrupDao().findAll(page, pageSize);
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
    }

    public GrupDao getGrupDao() {
        if (this.grupDao == null) {
            this.grupDao = new GrupDao();
        }
        return grupDao;
    }

    public void setGrupDao(GrupDao grupDao) {
        this.grupDao = grupDao;
    }

    //--
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
        this.pageCount = (int) Math.ceil(this.getGrupDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
