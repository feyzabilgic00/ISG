package Dao;

import Entity.Muayene;
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

public class MuayeneDAO {

    private PersonelDAO personelDAO;
    private KullaniciDAO kullaniciDAO;

    public Muayene find(Long id) {
        Muayene m = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from muayene where mid=?");
            ResultSet rs = st.executeQuery();
            rs.next();
            m = new Muayene();
            m.setMid(rs.getInt("mid"));
            m.setMneden(rs.getString("mneden"));
            m.setMtarihi(rs.getString("mtarihi"));
            m.setSonrakimtarih(rs.getString("sonrakimtarih"));
            m.setAnnehastalikg(rs.getString("annehastalikg"));
            m.setBabahastalikg(rs.getString("babahastalikg"));
            m.setCocukhastalikg(rs.getString("cocukhastalikg"));
            m.setKardeshastalikg(rs.getString("kardeshastalikg"));
            m.setBüyüktan(rs.getInt("büyüktan"));
            m.setKücüktan(rs.getInt("kücüktan"));
            m.setNabiz(rs.getInt("nabiz"));
            m.setKilo(rs.getDouble("kilo"));
            m.setBoy(rs.getDouble("boy"));
            m.setKangrup(rs.getString("kangrup"));
            m.setSicilno(rs.getInt("sicilno"));
            m.setSicilnop(rs.getInt("sicilnop"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }

    public List<Muayene> getMuayenes() {
        List<Muayene> mlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from muayene order by mid desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Muayene tmp = new Muayene(rs.getInt("mid"), rs.getString("mneden"), rs.getString("mtarihi"), rs.getString("sonrakimtarih"), rs.getString("annehastalikg"), rs.getString("babahastalikg"), rs.getString("cocukhastalikg"), rs.getString("kardeshastalikg"), rs.getInt("büyüktan"), rs.getInt("kücüktan"), rs.getInt("nabiz"), rs.getDouble("kilo"), rs.getDouble("boy"), rs.getString("kangrup"), rs.getInt("sicilno"), rs.getInt("sicilnop"));
                mlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mlist;
    }

    public void insert(Muayene muayene) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into muayene(mneden,mtarihi,sonrakimtarih,annehastalikg,babahastalikg,"
                    + "cocukhastalikg,kardeshastalikg,büyüktan,kücüktan,nabiz,kilo,boy,kangrup,sicilno,sicilnop,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, muayene.getMneden());
            st.setString(2, muayene.getMtarihi());
            st.setString(3, muayene.getSonrakimtarih());
            st.setString(4, muayene.getAnnehastalikg());
            st.setString(5, muayene.getBabahastalikg());
            st.setString(6, muayene.getCocukhastalikg());
            st.setString(7, muayene.getKardeshastalikg());
            st.setInt(8, muayene.getBüyüktan());
            st.setInt(9, muayene.getKücüktan());
            st.setInt(10, muayene.getNabiz());
            st.setDouble(11, muayene.getKilo());
            st.setDouble(12, muayene.getBoy());
            st.setString(13, muayene.getKangrup());
            st.setInt(14, muayene.getSicilno());
            st.setInt(15, muayene.getSicilnop());
            st.setInt(16, muayene.getUser_id());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Muayene m) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from muayene where mid=?");
            st.setInt(1, m.getMid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Muayene muayene) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update muayene set mneden=?,mtarihi=?,sonrakimtarih=?,annehastalikg=?,babahastalikg=?,cocukhastalikg=?,kardeshastalikg=?,büyüktan=?,kücüktan=?,nabiz=?,kilo=?,boy=?,kangrup=?,sicilno=?,sicilnop=? where mid=?");
            st.setString(1, muayene.getMneden());
            st.setString(2, muayene.getMtarihi());
            st.setString(3, muayene.getSonrakimtarih());
            st.setString(4, muayene.getAnnehastalikg());
            st.setString(5, muayene.getBabahastalikg());
            st.setString(6, muayene.getCocukhastalikg());
            st.setString(7, muayene.getKardeshastalikg());
            st.setInt(8, muayene.getBüyüktan());
            st.setInt(9, muayene.getKücüktan());
            st.setInt(10, muayene.getNabiz());
            st.setDouble(11, muayene.getKilo());
            st.setDouble(12, muayene.getBoy());
            st.setString(13, muayene.getKangrup());
            st.setInt(14, muayene.getSicilno());
            st.setInt(15, muayene.getSicilnop());
            st.setInt(16, muayene.getMid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Muayene> findAll(int page, int pageSize, String arama, String userid) {
        List<Muayene> muayenelist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";
            if (arama != null) {
                aramaSql += "and (mid = '" + arama + "' or mneden like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from muayene " + aramaSql + " order by mid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Muayene tmp = new Muayene();
                tmp.setMid(rs.getInt("mid"));
                tmp.setMneden(rs.getString("mneden"));
                tmp.setMtarihi(rs.getString("mtarihi"));
                tmp.setSonrakimtarih(rs.getString("sonrakimtarih"));
                tmp.setAnnehastalikg(rs.getString("annehastalikg"));
                tmp.setBabahastalikg(rs.getString("babahastalikg"));
                tmp.setCocukhastalikg(rs.getString("cocukhastalikg"));
                tmp.setKardeshastalikg(rs.getString("kardeshastalikg"));
                tmp.setBüyüktan(rs.getInt("büyüktan"));
                tmp.setKücüktan(rs.getInt("kücüktan"));
                tmp.setNabiz(rs.getInt("nabiz"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKangrup(rs.getString("kangrup"));
                //tmp.setSicilno(rs.getInt("sicilno"));
                //tmp.setSicilnop(rs.getInt("sicilnop"));

                //rs.getInt("sicilnop");
                //rs.getInt("sicilno");
                tmp.setKullanici(this.getKullaniciDAO().find(rs.getLong("sicilno")));
                tmp.setPersonel(this.getPersonelDAO().find(rs.getLong("sicilnop")));
                muayenelist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return muayenelist;
    }

    public List<Muayene> findAll(int page, int pageSize) {
        List<Muayene> muayenelist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from muayene order by mid asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Muayene tmp = new Muayene();
                tmp.setMid(rs.getInt("mid"));
                tmp.setMneden(rs.getString("mneden"));
                tmp.setMtarihi(rs.getString("mtarihi"));
                tmp.setSonrakimtarih(rs.getString("sonrakimtarih"));
                tmp.setAnnehastalikg(rs.getString("annehastalikg"));
                tmp.setBabahastalikg(rs.getString("babahastalikg"));
                tmp.setCocukhastalikg(rs.getString("cocukhastalikg"));
                tmp.setKardeshastalikg(rs.getString("kardeshastalikg"));
                tmp.setBüyüktan(rs.getInt("büyüktan"));
                tmp.setKücüktan(rs.getInt("kücüktan"));
                tmp.setNabiz(rs.getInt("nabiz"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKangrup(rs.getString("kangrup"));
                //tmp.setSicilno(rs.getInt("sicilno"));
                //tmp.setSicilnop(rs.getInt("sicilnop"));

                //rs.getInt("sicilnop");
                //rs.getInt("sicilno");
                tmp.setKullanici(this.getKullaniciDAO().find(rs.getLong("sicilno")));
                tmp.setPersonel(this.getPersonelDAO().find(rs.getLong("sicilnop")));
                muayenelist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return muayenelist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(mid) as muayene_count from muayene");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("muayene_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public PersonelDAO getPersonelDAO() {
        if (this.personelDAO == null) {
            this.personelDAO = new PersonelDAO();
        }
        return personelDAO;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

}
