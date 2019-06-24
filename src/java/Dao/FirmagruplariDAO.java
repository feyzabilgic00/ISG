package Dao;

import Entity.Firmagruplari;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirmagruplariDAO {

    public Firmagruplari find(Long id) {
        Firmagruplari f = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from firmagruplari where grup_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();

            f = new Firmagruplari();
            f.setGrup_id(rs.getInt("grup_id"));
            f.setGrup_ad(rs.getString("grup_ad"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }

    public List<Firmagruplari> getFirmaGruplari() {
        List<Firmagruplari> firmagruplarilist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from firmagruplari");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Firmagruplari tmp = new Firmagruplari(rs.getInt("grup_id"), rs.getString("grup_ad"));
                firmagruplarilist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmagruplarilist;
    }

    public void insert(Firmagruplari firmagruplari) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into firmagruplari(grup_id,grup_ad,user_id) values(?,?,?)");
            st.setInt(1, firmagruplari.getGrup_id());
            st.setString(2, firmagruplari.getGrup_ad());
            st.setInt(3, firmagruplari.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Firmagruplari fgrp) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from firmagruplari where grup_id=?");
            st.setInt(1, fgrp.getGrup_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Firmagruplari firmagruplari) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update firmagruplari set grup_ad=?  where grup_id=?");
            st.setString(1, firmagruplari.getGrup_ad());
            st.setInt(2, firmagruplari.getGrup_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Firmagruplari> findAll(int page, int pageSize, String arama, String userid) {
        List<Firmagruplari> firmagruplarilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";

            if (arama != null) {
                aramaSql += "and (grup_id = '" + arama + "' or grup_ad like '%" + arama + "%' )";
            }

            //Statement st = c.createStatement();
            PreparedStatement st = c.prepareStatement("select * from firmagruplari " + aramaSql + " order by grup_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Firmagruplari tmp = new Firmagruplari();
                tmp.setGrup_id(rs.getInt("grup_id"));
                tmp.setGrup_ad(rs.getString("grup_ad"));
                firmagruplarilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmagruplarilist;
    }

    public List<Firmagruplari> findAll(int page, int pageSize) {
        List<Firmagruplari> firmagruplarilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            //Statement st = c.createStatement();
            PreparedStatement st = c.prepareStatement("select * from firmagruplari order by grup_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Firmagruplari tmp = new Firmagruplari();
                tmp.setGrup_id(rs.getInt("grup_id"));
                tmp.setGrup_ad(rs.getString("grup_ad"));
                firmagruplarilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmagruplarilist;
    }

    public int count() {
        {

            DBConnection db = new DBConnection();
            Connection c = db.connect();
            int count = 0;
            try {
                //Statement st = c.createStatement();
                PreparedStatement st = c.prepareStatement("select count(grup_id) as firmagruplari_count from firmagruplari");
                ResultSet rs = st.executeQuery();
                rs.next();
                count = rs.getInt("firmagruplari_count");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return count;

        }
    }

}
