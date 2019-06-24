/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.GrupDao;
import Dao.UserDao;
import Entity.Grup;
import Entity.User;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean
@ViewScoped
public class UserController implements Serializable {

    private User user;
    private List<User> userList;
    private UserDao userDao;

    private GrupDao grupDao;

    private List<Grup> grupList;

    public UserController() {
        this.user = new User();
    }

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
    public void clearForm() {
        this.user = new User();
    }

    public void updateForm(User user) {
        this.user = user;
    }

    public void delete() {
        this.getUserDao().remove(this.user);
        clearForm();
    }

    public void update() {
        this.getUserDao().edit(this.user);
        clearForm();
    }

    public void create() {
        this.getUserDao().create(this.user);
        clearForm();
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        this.userList = this.getUserDao().findAll(page, pageSize);
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserDao getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //-----------------------------------------------------

    public GrupDao getGrupDao() {
        if (this.grupDao == null) {
            this.grupDao = new GrupDao();
        }
        return grupDao;
    }

    public void setGrupDao(GrupDao grupDao) {
        this.grupDao = grupDao;
    }

    public List<Grup> getGrupList() {
        this.grupList = this.getGrupDao().findAll();
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
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
        this.pageCount = (int) Math.ceil(this.getUserDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
