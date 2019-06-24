/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Grup;
import Utility.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GrupDao extends AbstractDao implements Serializable {

    //--Pagination
    public List<Grup> findAll(int page, int pageSize) {
        List<Grup> grupList = new ArrayList<>();
        int start = (page - 1) * pageSize;
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from grup order by grup_id limit " + pageSize + " offset " + start);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Grup g = new Grup();

                g.setGrup_id(rs.getInt("grup_id"));
                g.setGrup_adi(rs.getString("grup_adi"));

                grupList.add(g);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grupList;
    }

    public int count() {
        int count = 0;
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select count(grup_id) as grup_count from grup");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("grup_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    //--

    public List<Grup> findAll() {
        List<Grup> grupList = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from grup order by grup_id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Grup g = new Grup();
                g.setGrup_id(rs.getInt("grup_id"));
                g.setGrup_adi(rs.getString("grup_adi"));

                grupList.add(g);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grupList;
    }

    public Grup find(Long id) {
        Grup g = null;
 DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select * from grup where grup_id=" + id);
            ResultSet rs = pst.executeQuery();

            rs.next();

            g = new Grup();
            g.setGrup_id(rs.getInt("grup_id"));
            g.setGrup_adi(rs.getString("grup_adi"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return g;

    }

    public void remove(Grup grup) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("delete from grup where grup_id=?");
            pst.setLong(1, grup.getGrup_id());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(Grup grup) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("update grup set grup_adi=? where grup_id=?");
            pst.setString(1, grup.getGrup_adi());
            pst.setLong(2, grup.getGrup_id());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Grup grup) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("insert into grup(grup_adi)values(?)");
            pst.setString(1, grup.getGrup_adi());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
