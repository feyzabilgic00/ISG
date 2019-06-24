package Dao;

import Entity.Unvan;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnvanDAO {

    public List<Unvan> getUnvans() {
        List<Unvan> ulist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from unvan order by unvanid desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Unvan tmp = new Unvan(rs.getInt("unvanid"), rs.getString("unvanadi"));
                ulist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ulist;
    }

    public void insert(Unvan unvan) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into unvan(unvanadi,user_id) values(?,?)");
            st.setString(1, unvan.getUnvanadi());
            st.setInt(2, unvan.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Unvan u) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from unvan where unvanid=?");
            st.setInt(1, u.getUnvanid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Unvan unvan) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update unvan set unvanadi=? where unvanid=?");
            st.setString(1, unvan.getUnvanadi());
            st.setInt(2, unvan.getUnvanid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Unvan> findAll(int page, int pageSize, String arama, String userid) {
        List<Unvan> unvanlist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += " and (unvanid ='" + arama + "' or unvanadi like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from unvan " + aramaSql + " order by unvanid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Unvan tmp = new Unvan();
                tmp.setUnvanid(rs.getInt("unvanid"));
                tmp.setUnvanadi(rs.getString("unvanadi"));

                unvanlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return unvanlist;
    }

    public List<Unvan> findAll(int page, int pageSize) {
        List<Unvan> unvanlist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from unvan order by unvanid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Unvan tmp = new Unvan();
                tmp.setUnvanid(rs.getInt("unvanid"));
                tmp.setUnvanadi(rs.getString("unvanadi"));

                unvanlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return unvanlist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(unvanid) as unvan_count from unvan");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("unvan_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
