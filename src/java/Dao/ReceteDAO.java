package Dao;

import Entity.Recete;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceteDAO {

    private MuayeneDAO muayeneDAO;

    public Recete find(Long id) {
        Recete r = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from recete where rid=?");
            ResultSet rs = st.executeQuery();
            rs.next();
            r = new Recete();
            r.setRid(rs.getInt("rid"));
            r.setMid(rs.getInt("mid"));
            r.setRtarihi(rs.getString("rtarihi"));
            r.setRtipi(rs.getString("rtipi"));
            r.setRalttipi(rs.getString("ralttipi"));
            r.setProvizyontipi(rs.getString("provizyontipi"));
            r.setSerino(rs.getString("serino"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public List<Recete> getRecetes() {
        List<Recete> rlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from recete order by rid desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Recete tmp = new Recete(rs.getInt("rid"), rs.getInt("mid"), rs.getString("rtarihi"), rs.getString("rtipi"), rs.getString("ralttipi"), rs.getString("provizyontipi"), rs.getString("serino"));
                rlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rlist;
    }

    public void insert(Recete recete) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into recete(mid,rtarihi,rtipi,ralttipi,provizyontipi,serino,user_id) values(?,?,?,?,?,?,?)");
            st.setInt(1, recete.getMid());
            st.setString(2, recete.getRtarihi());
            st.setString(3, recete.getRtipi());
            st.setString(4, recete.getRalttipi());
            st.setString(5, recete.getProvizyontipi());
            st.setString(6, recete.getSerino());
            st.setInt(7, recete.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Recete r) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from recete where rid=?");
            st.setInt(1, r.getRid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Recete recete) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update recete set mid=?,rtarihi=?,rtipi=?,ralttipi=?,provizyontipi=?,serino=? where rid=?");
            st.setInt(1, recete.getMid());
            st.setString(2, recete.getRtarihi());
            st.setString(3, recete.getRtipi());
            st.setString(4, recete.getRalttipi());
            st.setString(5, recete.getProvizyontipi());
            st.setString(6, recete.getSerino());
            st.setInt(7, recete.getRid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Recete> findAll(int page, int pageSize) {
        List<Recete> recetelist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            PreparedStatement st = c.prepareStatement("select * from recete  order by rid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Recete tmp = new Recete();
                tmp.setRid(rs.getInt("rid"));
                //tmp.setMid(rs.getInt("mid"));
                tmp.setRtarihi(rs.getString("rtarihi"));
                tmp.setRtipi(rs.getString("rtipi"));
                tmp.setRalttipi(rs.getString("ralttipi"));
                tmp.setProvizyontipi(rs.getString("provizyontipi"));
                tmp.setSerino(rs.getString("serino"));

                //rs.getInt("mid");
                tmp.setMuayene(this.getMuayeneDAO().find(rs.getLong("mid")));
                recetelist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return recetelist;
    }

    
    public List<Recete> findAll(int page, int pageSize, String arama, String userid) {
        List<Recete> recetelist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += " and (rid = '" + arama + "' or rtipi like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from recete " + aramaSql + " order by rid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Recete tmp = new Recete();
                tmp.setRid(rs.getInt("rid"));
                //tmp.setMid(rs.getInt("mid"));
                tmp.setRtarihi(rs.getString("rtarihi"));
                tmp.setRtipi(rs.getString("rtipi"));
                tmp.setRalttipi(rs.getString("ralttipi"));
                tmp.setProvizyontipi(rs.getString("provizyontipi"));
                tmp.setSerino(rs.getString("serino"));

                //rs.getInt("mid");
                tmp.setMuayene(this.getMuayeneDAO().find(rs.getLong("mid")));
                recetelist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return recetelist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(rid) as recete_count from recete");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("recete_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public MuayeneDAO getMuayeneDAO() {
        if (this.muayeneDAO == null) {
            this.muayeneDAO = new MuayeneDAO();
        }
        return muayeneDAO;
    }

}
