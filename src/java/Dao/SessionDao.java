/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LENOVO
 */
public class SessionDao extends AbstractDao {

    public User login(String user_adi, String sifre) {
        User u = null;
DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from public.user where user_adi=? and sifre=?");
            pst.setString(1, user_adi);
            pst.setString(2, sifre);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setUser_adi(rs.getString("user_adi"));
                u.setSifre(rs.getString("sifre"));
                u.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return u;
    }

    public void insert(User user) {
DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("insert into public.user (user_adi,sifre,email,grup_id) values (?,?,?,?)");
            pst.setString(1, user.getUser_adi());
            pst.setString(2, user.getSifre());
            pst.setString(3, user.getEmail());
            pst.setInt(4, 1);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
