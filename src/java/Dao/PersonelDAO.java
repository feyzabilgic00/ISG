package Dao;

import Entity.Personel;
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

public class PersonelDAO {

    private FirmaDAO firmaDAO;

    public Personel find(Long id) {
        Personel p = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from personel where sicilnop=?");
            ResultSet rs = st.executeQuery();
            rs.next();

            p = new Personel();
            p.setSicilnop(rs.getInt("sicilnop"));
            p.setAd(rs.getString("ad"));
            p.setSoyad(rs.getString("soyad"));
            p.setUnvan(rs.getString("unvan"));
            p.setOgrenimdurum(rs.getString("ogrenimdurum"));
            p.setCinsiyet(rs.getString("cinsiyet"));
            p.setBoy(rs.getDouble("boy"));
            p.setKilo(rs.getDouble("kilo"));
            p.setIsegiristrh(rs.getString("isegiristrh"));
            p.setDogumtarih(rs.getString("dogumtarih"));
            p.setDogumyer(rs.getString("dogumyer"));
            p.setFirmaid(rs.getInt("firmaid"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public List<Personel> getPersonels() {
        List<Personel> plist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from personel order by sicilnop desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Personel tmp = new Personel(rs.getInt("sicilnop"), rs.getString("ad"), rs.getString("soyad"), rs.getString("unvan"), rs.getString("ogrenimdurum"), rs.getString("cinsiyet"), rs.getDouble("boy"), rs.getDouble("kilo"), rs.getString("isegiristrh"), rs.getString("dogumtarih"), rs.getString("dogumyer"), rs.getInt("firmaid"));
                plist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return plist;
    }

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            this.firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public void insert(Personel personel) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into personel "
                    + "(sicilnop,ad,soyad,unvan,ogrenimdurum,cinsiyet,boy,kilo,isegiristrh,dogumtarih,dogumyer,firmaid,cv,user_id) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, personel.getSicilnop());
            st.setString(2, personel.getAd());
            st.setString(3, personel.getSoyad());
            st.setString(4, personel.getUnvan());
            st.setString(5, personel.getOgrenimdurum());
            st.setString(6, personel.getCinsiyet());
            st.setDouble(7, personel.getBoy());
            st.setDouble(8, personel.getKilo());
            st.setString(9, personel.getIsegiristrh());
            st.setString(10, personel.getDogumtarih());
            st.setString(11, personel.getDogumyer());
            st.setInt(12, personel.getFirmaid());
            st.setString(13, personel.getCv());
            st.setInt(14, personel.getUser_id());

            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Personel p) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from personel where sicilnop=?");
            st.setInt(1, p.getSicilnop());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Personel personel) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update personel set ad=?,"
                    + "soyad=?,"
                    + "unvan=?,"
                    + "ogrenimdurum=?,"
                    + "cinsiyet=?,"
                    + "boy=?,"
                    + "kilo=?,"
                    + "isegiristrh=?,"
                    + "dogumtarih=?,"
                    + "dogumyer=?,"
                    + "firmaid=?, "
                    + "cv=? where "
                    + "sicilnop=?");

            st.setString(1, personel.getAd());
            st.setString(2, personel.getSoyad());
            st.setString(3, personel.getUnvan());
            st.setString(4, personel.getOgrenimdurum());
            st.setString(5, personel.getCinsiyet());
            st.setDouble(6, personel.getBoy());
            st.setDouble(7, personel.getKilo());
            st.setString(8, personel.getIsegiristrh());
            st.setString(9, personel.getDogumtarih());
            st.setString(10, personel.getDogumyer());
            st.setInt(11, personel.getFirmaid());
            st.setString(12, personel.getCv());
            st.setInt(13, personel.getSicilnop());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Personel> findAll(int page, int pageSize, String arama, String userid) {
        List<Personel> personellist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";

            if (arama != null) {
                aramaSql += " and (sicilnop = '" + arama + "' or ad like '" + arama + "' or soyad like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from personel " + aramaSql + " order by sicilnop asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Personel tmp = new Personel();
                tmp.setSicilnop(rs.getInt("sicilnop"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setUnvan(rs.getString("unvan"));
                tmp.setOgrenimdurum(rs.getString("ogrenimdurum"));
                tmp.setCinsiyet(rs.getString("cinsiyet"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setIsegiristrh(rs.getString("isegiristrh"));
                tmp.setDogumtarih(rs.getString("dogumtarih"));
                tmp.setDogumyer(rs.getString("dogumyer"));
                tmp.setCv(rs.getString("cv"));
                //tmp.setFirmaid(rs.getInt("firmaid"));
                //rs.getInt("firmaid");
                tmp.setFirma(this.getFirmaDAO().find(rs.getLong("firmaid")));
                personellist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personellist;
    }

    public List<Personel> findAll(int page, int pageSize) {
        List<Personel> personellist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from personel order by sicilnop asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Personel tmp = new Personel();
                tmp.setSicilnop(rs.getInt("sicilnop"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setUnvan(rs.getString("unvan"));
                tmp.setOgrenimdurum(rs.getString("ogrenimdurum"));
                tmp.setCinsiyet(rs.getString("cinsiyet"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setIsegiristrh(rs.getString("isegiristrh"));
                tmp.setDogumtarih(rs.getString("dogumtarih"));
                tmp.setDogumyer(rs.getString("dogumyer"));
                //tmp.setFirmaid(rs.getInt("firmaid"));
                //rs.getInt("firmaid");
                tmp.setFirma(this.getFirmaDAO().find(rs.getLong("firmaid")));
                personellist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personellist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(sicilnop) as personel_count from personel");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("personel_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
