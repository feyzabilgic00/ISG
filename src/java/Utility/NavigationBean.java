/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author LENOVO
 */
@ManagedBean
@RequestScoped
public class NavigationBean implements Serializable{

   public String page2(String p) {
        return "/pages/" +p+ "?faces-redirect=true";
    }
    
    public String page(String p) {
        return "/pages/"+p+"/"+p+"?faces-redirect=true";
    }

    public String front(String f) {
        return "/frontend/" + f + "/" + f + "?faces-redirect=true";
    }

}
