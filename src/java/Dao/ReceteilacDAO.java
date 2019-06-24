package Dao;

import Entity.Receteilac;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceteilacDAO {

    private ReceteDAO receteDAO;
    private IlactanimiDAO ilactanimiDAO;

    public List<Receteilac> getReceteIlacs() {
        List<Receteilac> rilist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from receteilac");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Receteilac tmp = new Receteilac(rs.getInt("rilacid"), rs.getInt("rid"), rs.getInt("ilacid"), rs.getInt("kullanimadedi"), rs.getString("kullanimsekli"), rs.getString("periyod"), rs.getString("ilacdozu"));
                rilist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rilist;
    }

    public void insert(Receteilac receteilac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into receteilac(rid,ilacid,kullanimadedi,kullanimsekli,periyod,ilacdozu,user_id) values(?,?,?,?,?,?,?)");
            st.setInt(1, receteilac.getRid());
            st.setInt(2, receteilac.getIlacid());
            st.setInt(3, receteilac.getKullanimadedi());
            st.setString(4, receteilac.getKullanimsekli());
            st.setString(5, receteilac.getPeriyod());
            st.setString(6, receteilac.getIlacdozu());
            st.setInt(7, receteilac.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Receteilac ri) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from receteilac where rilacid=?");
            st.setInt(1, ri.getRilacid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Receteilac receteilac) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update receteilac set rid=?,ilacid=?,kullanimadedi=?,kullanimsekli=?,periyod=?,ilacdozu=? where rilacid=?");
            st.setInt(1, receteilac.getRid());
            st.setInt(2, receteilac.getIlacid());
            st.setInt(3, receteilac.getKullanimadedi());
            st.setString(4, receteilac.getKullanimsekli());
            st.setString(5, receteilac.getPeriyod());
            st.setString(6, receteilac.getIlacdozu());
            st.setInt(7, receteilac.getRilacid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Receteilac> findAll(int page, int pageSize) {
        List<Receteilac> receteilaclist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from receteilac order by rilacid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Receteilac tmp = new Receteilac();
                tmp.setRilacid(rs.getInt("rilacid"));
                tmp.setRid(rs.getInt("rid"));
                tmp.setIlacid(rs.getInt("ilacid"));
                tmp.setKullanimadedi(rs.getInt("kullanimadedi"));
                tmp.setKullanimsekli(rs.getString("kullanimsekli"));
                tmp.setPeriyod(rs.getString("periyod"));
                tmp.setIlacdozu(rs.getString("ilacdozu"));

                //rs.getInt("rid");
                //rs.getInt("ilacid");
                tmp.setIlactanimi(this.getIlactanimiDAO().find(rs.getLong("ilacid")));
                tmp.setRecete(this.getReceteDAO().find(rs.getLong("rid")));
                receteilaclist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return receteilaclist;
    }

    public List<Receteilac> findAll(int page, int pageSize, String arama, String userid) {
        List<Receteilac> receteilaclist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += " and (rilacid ='" + arama + "' or kullanimsekli like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from receteilac " + aramaSql + " order by rilacid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Receteilac tmp = new Receteilac();
                tmp.setRilacid(rs.getInt("rilacid"));
                tmp.setRid(rs.getInt("rid"));
                tmp.setIlacid(rs.getInt("ilacid"));
                tmp.setKullanimadedi(rs.getInt("kullanimadedi"));
                tmp.setKullanimsekli(rs.getString("kullanimsekli"));
                tmp.setPeriyod(rs.getString("periyod"));
                tmp.setIlacdozu(rs.getString("ilacdozu"));

                //rs.getInt("rid");
                //rs.getInt("ilacid");
                tmp.setIlactanimi(this.getIlactanimiDAO().find(rs.getLong("ilacid")));
                tmp.setRecete(this.getReceteDAO().find(rs.getLong("rid")));
                receteilaclist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return receteilaclist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(rilacid) as receteilac_count from receteilac");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("receteilac_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public ReceteDAO getReceteDAO() {
        if (this.receteDAO == null) {
            this.receteDAO = new ReceteDAO();
        }
        return receteDAO;
    }

    public IlactanimiDAO getIlactanimiDAO() {
        if (this.ilactanimiDAO == null) {
            this.ilactanimiDAO = new IlactanimiDAO();
        }
        return ilactanimiDAO;
    }

}
