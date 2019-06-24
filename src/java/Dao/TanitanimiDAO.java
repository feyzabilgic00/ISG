package Dao;

import Entity.Tanitanimi;
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

public class TanitanimiDAO {

    public List<Tanitanimi> getTaniTanimis() {
        List<Tanitanimi> tlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from tanitanimi order by tanitid");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tanitanimi tmp = new Tanitanimi(rs.getInt("tanitid"), rs.getString("taniadi"));
                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tlist;
    }

    public void insert(Tanitanimi tanitanimi) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into tanitanimi(taniadi,user_id) values(?,?)");
            st.setString(1, tanitanimi.getTaniadi());
            st.setInt(2, tanitanimi.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Tanitanimi t) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from tanitanimi where tanitid=?");
            st.setInt(1, t.getTanitid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Tanitanimi tanitanimi) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update tanitanimi set taniadi=? where tanitid=?");
            st.setString(1, tanitanimi.getTaniadi());
            st.setInt(2, tanitanimi.getTanitid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Tanitanimi> findAll(int page, int pageSize) {
        List<Tanitanimi> tanitanimilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from tanitanimi order by tanitid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Tanitanimi tmp = new Tanitanimi();
                tmp.setTanitid(rs.getInt("tanitid"));
                tmp.setTaniadi(rs.getString("taniadi"));

                tanitanimilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tanitanimilist;
    }

    public List<Tanitanimi> findAll(int page, int pageSize, String arama, String userid) {
        List<Tanitanimi> tanitanimilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += " and (tanitid = '" + arama + "' or taniadi like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from tanitanimi " + aramaSql + " order by tanitid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Tanitanimi tmp = new Tanitanimi();
                tmp.setTanitid(rs.getInt("tanitid"));
                tmp.setTaniadi(rs.getString("taniadi"));

                tanitanimilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tanitanimilist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(tanitid) as tanitanimi_count from tanitanimi");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("tanitanimi_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
