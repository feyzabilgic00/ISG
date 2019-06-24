/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Entity.User;
import Utility.SessionUtility;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class SessionController {

    User user;
    UserDao userDao;

    public SessionController() {
        userDao = new UserDao();
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() {
        this.user = userDao.Login(user);

        if (this.user != null) {

            HttpSession session = SessionUtility.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUser_id());
            session.setAttribute("userName", user.getUser_adi());

            return "/faces/pages/index.xhtml";
        }

        this.user = new User();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email veya Şifre Yanlış! Lütfen Tekrar Deneyiniz!", null);

        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/faces/frontend/login/login.xhtml";
    }

    public String register() {
        try {

            userDao.register(user);

            HttpSession session = SessionUtility.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUser_id());
            session.setAttribute("userName", user.getUser_adi());

            return "/faces/pages/index.xhtml";
        } catch (Exception e) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bir Hata Oluştu! Lütfen Tekrar Deneyiniz!", null);

            FacesContext.getCurrentInstance().addMessage(null, msg);

            return "/faces/frontend/register/register.xhtml";
        }
    }

}
