package Dao;

import Entity.Statu;
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

public class StatuDAO {

    public List<Statu> getStatus() {
        List<Statu> slist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from statu order by statuid desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Statu tmp = new Statu(rs.getInt("statuid"), rs.getString("statuadi"));
                slist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return slist;
    }

    public void insert(Statu statu) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into statu(statuadi,user_id) values(?,?)");
            st.setString(1, statu.getStatuadi());
            st.setInt(2, statu.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Statu s) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from statu where statuid=?");
            st.setInt(1, s.getStatuid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Statu statu) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update statu set statuadi=? where statuid=?");
            st.setString(1, statu.getStatuadi());
            st.setInt(2, statu.getStatuid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Statu> findAll(int page, int pageSize) {
        List<Statu> statulist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from statu order by statuid  asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Statu tmp = new Statu();
                tmp.setStatuid(rs.getInt("statuid"));
                tmp.setStatuadi(rs.getString("statuadi"));

                statulist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return statulist;
    }

    public List<Statu> findAll(int page, int pageSize, String arama, String userid) {
        List<Statu> statulist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += " and (statuid ='" + arama + "' or statuadi like '%" + arama + "%' )";
            }

            PreparedStatement st = c.prepareStatement("select * from statu " + aramaSql + " order by statuid  asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Statu tmp = new Statu();
                tmp.setStatuid(rs.getInt("statuid"));
                tmp.setStatuadi(rs.getString("statuadi"));

                statulist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return statulist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(statuid) as statu_count from statu");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("statu_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
