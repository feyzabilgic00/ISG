/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utility.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class ValidationDao extends AbstractDao implements Serializable {
    
    public boolean mailControl(String email) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select email from public.user where email=?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean userNameControl(String uName) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select user_adi from public.user where user_adi=?");
            pst.setString(1, uName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
