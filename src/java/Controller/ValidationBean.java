/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SessionDao;
import Dao.ValidationDao;
import java.awt.event.KeyEvent;
import java.io.Serializable;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
public class ValidationBean implements Serializable {

    private ValidationDao validDao;

    public boolean sayiMi(FacesContext fc, UIComponent c, Object value) {
        String tmp = (String) value;
        if (tmp.isEmpty()) {
            String mesaj = "*Bu alan boş bırakılamaz.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, mesaj, mesaj));
        } else if (tmp.contains("1") || tmp.contains("2") || tmp.contains("3") || tmp.contains("4") || tmp.contains("5") || tmp.contains("6") || tmp.contains("7") || tmp.contains("8") || tmp.contains("9") || tmp.contains("0")) {
            String mesaj = "*Bu alana sayı girilemez.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, mesaj, mesaj));
        } else if (tmp.length() < 5 || tmp.length() > 20) {
            String mesaj = "*Bu alan az 5 en fazla 20 harf uzunluğundadır.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, mesaj, mesaj));
        } else {
            return true;
        }
    }

    public boolean validateUsername(FacesContext fc, UIComponent c, Object value) {
        String tmp = (String) value;
        if (tmp.isEmpty()) {
            String msg = "*Kullanıcı adı alanı boş bırakılamaz";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (tmp.length() < 5 || tmp.length() > 11) {
            String msg = "*Kullanıcı adı en az 5 en fazla 11 karakter olabilir.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (this.getValidDao().userNameControl(tmp) == true) {
            String msg = "*Kullanıcı adı sistemde kayıtlı başka bir kullanıcı adı girin.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
    }

    public boolean validateEmail(FacesContext fc, UIComponent c, Object value) {
        String tmp = (String) value;
        if (tmp.isEmpty()) {
            String msg = "*E-mail alanı boş bırakılamaz.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (!tmp.contains("@")) {
            String msg = "*Email alanına @ işareti koyulmalıdır.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (this.getValidDao().mailControl(tmp)) {
            String msg = "*Girilen Email adresi sistemde zaten kayıtlı.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (!tmp.contains("@gmail.com") && !tmp.contains("@hotmail.com")) {
            String msg = "*Email alanına alan adı koymak zorundasın. \n (Örneğin ...@gmail.com)";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
    }

    public boolean validateSifre(FacesContext fc, UIComponent c, Object value) {
        String tmp = (String) value;
        if (tmp.isEmpty()) {
            String msg = "*Şifre alanı boş bırakılamaz";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (tmp.length() < 5 || tmp.length() > 11) {
            String msg = "*Şifre en az 5 en fazla 11 karakter içermelidir.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
    }

    public boolean validatesehAdi(FacesContext fc, UIComponent c, Object value) {
        String tmp = (String) value;
        if (tmp.isEmpty()) {
            String msg = "*Şehir adı alanı boş bırakılamaz.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (tmp.contains("1") || tmp.contains("2") || tmp.contains("3") || tmp.contains("4") || tmp.contains("5") || tmp.contains("6") || tmp.contains("7") || tmp.contains("8") || tmp.contains("9") || tmp.contains("0")) {
            String msg = "*Şehir adı alanına sayı girilemez.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else if (tmp.length() < 3 || tmp.length() > 14) {
            String msg = "*En kısa 3 harfli en uzun 14 harfli ilimiz var.";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            return true;
        }
    }

    public ValidationDao getValidDao() {
        if (this.validDao == null) {
            this.validDao = new ValidationDao();
        }
        return validDao;
    }

    public void setValidDao(ValidationDao validDao) {
        this.validDao = validDao;
    }

}
