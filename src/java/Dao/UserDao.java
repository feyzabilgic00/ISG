/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utility.DBConnection;
import Entity.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UserDao extends AbstractDao implements Serializable {

    private GrupDao grupDao;

    public User Login(User model) {

        User u = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from user where email = '" + model.getEmail() + "' and sifre = '" + model.getSifre() + "' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_adi(rs.getString("user_adi"));
                u.setSifre(rs.getString("sifre"));
                u.setEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    //--
    public List<User> findAll(int page, int pageSize) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        List<User> userList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = c.prepareStatement("select * from public.user order by user_id limit " + pageSize + " offset " + start);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_adi(rs.getString("user_adi"));
                u.setSifre(rs.getString("sifre"));
                u.setEmail(rs.getString("email"));

                u.setGrup(this.getGrupDao().find(rs.getLong("grup_id")));

                userList.add(u);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public int count() {
        int count = 0;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select count(user_id) as user_count from public.user");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("user_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    //--

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from public.user");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_adi(rs.getString("user_adi"));
                u.setSifre(rs.getString("sifre"));
                u.setEmail(rs.getString("email"));

                u.setGrup(this.getGrupDao().find(rs.getLong("grup_id")));

                userList.add(u);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;

    }

    public User find(int user_id) {

        User u = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from public.user where user_id=?");
            pst.setInt(1, user_id);

            ResultSet rs = pst.executeQuery();

            rs.next();

            u = new User();
            u.setUser_id(rs.getInt("user_id"));
            u.setUser_adi(rs.getString("user_adi"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
    }

    public void remove(User user) {
        try {
            DBConnection db = new DBConnection();
            Connection c = db.connect();
            PreparedStatement pst = c.prepareStatement("delete from public.user where user_id=?");
            pst.setLong(1, user.getUser_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(User user) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("update public.user set user_adi=?, sifre=?, email=?, grup_id=? where user_id=?");
            pst.setString(1, user.getUser_adi());
            pst.setString(2, user.getSifre());
            pst.setString(3, user.getEmail());
            pst.setLong(4, user.getGrup().getGrup_id());
            pst.setLong(5, user.getUser_id());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(User user) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("insert into public.user(user_adi,sifre,email,grup_id) values (?,?,?,?)");
            pst.setString(1, user.getUser_adi());
            pst.setString(2, user.getSifre());
            pst.setString(3, user.getEmail());
            pst.setLong(4, user.getGrup().getGrup_id());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void register(User user) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("insert into user(user_adi,sifre,email) values (?,?,?)");
            pst.setString(1, user.getUser_adi());
            pst.setString(2, user.getSifre());
            pst.setString(3, user.getEmail());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

}
