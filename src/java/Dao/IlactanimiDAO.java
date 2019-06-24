package Dao;

import Entity.Ilactanimi;
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

public class IlactanimiDAO {

    public Ilactanimi find(Long id) {
        Ilactanimi i = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from ilactanimi where ilacid=?");
            ResultSet rs = st.executeQuery();
            st.setLong(1, id);
            rs.next();
            i = new Ilactanimi();
            i.setIlacid(rs.getInt("ilacid"));
            i.setIlacadi(rs.getString("ilacadi"));
            i.setMl(rs.getString("ml"));
            i.setTur(rs.getString("tur"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public List<Ilactanimi> getIlacTanımıs() {
        List<Ilactanimi> ilactanimilist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from ilactanimi");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ilactanimi tmp = new Ilactanimi(rs.getInt("ilacid"), rs.getString("ilacadi"), rs.getString("ml"), rs.getString("tur"));
                ilactanimilist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ilactanimilist;
    }

    public void insert(Ilactanimi ilactanimi) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into ilactanimi(ilacadi,ml,tur,user_id) values(?,?,?,?)");
            st.setString(1, ilactanimi.getIlacadi());
            st.setString(2, ilactanimi.getMl());
            st.setString(3, ilactanimi.getTur());
            st.setInt(4, ilactanimi.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Ilactanimi ilactanimi) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update ilactanimi set ilacadi=?,ml=?,tur=? where ilacid=?");
            st.setString(1, ilactanimi.getIlacadi());
            st.setString(2, ilactanimi.getMl());
            st.setString(3, ilactanimi.getTur());
            st.setInt(4,ilactanimi.getIlacid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Ilactanimi ilc) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from ilactanimi where ilacid=?");
            st.setInt(1, ilc.getIlacid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ilactanimi> findAll(int page, int pageSize, String arama, String userid) {
        List<Ilactanimi> ilactanimilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";

            if (arama != null) {
                aramaSql += " and (ilacid ='" + arama + "' or ilacadi like '%" + arama + "%') ";
            }

            PreparedStatement st = c.prepareStatement("select * from ilactanimi " + aramaSql + " order by ilacid asc  limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ilactanimi tmp = new Ilactanimi();
                tmp.setIlacid(rs.getInt("ilacid"));
                tmp.setIlacadi(rs.getString("ilacadi"));
                tmp.setMl(rs.getString("ml"));
                tmp.setTur(rs.getString("tur"));
                ilactanimilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ilactanimilist;
    }

    public List<Ilactanimi> findAll(int page, int pageSize) {
        List<Ilactanimi> ilactanimilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from ilactanimi order by ilacid asc  limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ilactanimi tmp = new Ilactanimi();
                tmp.setIlacid(rs.getInt("ilacid"));
                tmp.setIlacadi(rs.getString("ilacadi"));
                tmp.setMl(rs.getString("ml"));
                tmp.setTur(rs.getString("tur"));
                ilactanimilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ilactanimilist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(ilacid) as ilactanimi_count from ilactanimi");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("ilactanimi_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
