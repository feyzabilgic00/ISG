

package Dao;

import Entity.Kullanici;
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

public class KullaniciDAO {

    public Kullanici find(Long id) {
        Kullanici k = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from kullanici where sicilno=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            k = new Kullanici();
            k.setSicilno(rs.getInt("sicilno"));
            k.setGorevtanim(rs.getString("gorevtanim"));
            k.setTc(rs.getString("tc"));
            k.setAd(rs.getString("ad"));
            k.setSoyad(rs.getString("soyad"));
            k.setDurum(rs.getString("durum"));
            k.setBoy(rs.getDouble("boy"));
            k.setKilo(rs.getDouble("kilo"));
            k.setKangrup(rs.getString("kangrup"));
            k.setCinsiyet(rs.getString("cinsiyet"));
            k.setDogumtarih(rs.getString("dogumtarih"));
            k.setDogumyer(rs.getString("dogumyer"));
            k.setStatü(rs.getString("statü"));
            k.setOgrenimdurum(rs.getString("ogrenimdurum"));
            k.setIsgkurulgorev(rs.getString("isgkurulgorev"));
            k.setIsebaslangictarih(rs.getString("isebaslangictarih"));
            k.setUnvan(rs.getString("unvan"));

        } /*catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/ catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    public List<Kullanici> getKullanicis() {
        List<Kullanici> kullanicilist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici");
            while (rs.next()) {
                Kullanici tmp = new Kullanici(rs.getInt("sicilno"), rs.getString("gorevtanim"), rs.getString("tc"), rs.getString("ad"), rs.getString("soyad"), rs.getString("durum"), rs.getDouble("boy"), rs.getDouble("kilo"), rs.getString("kangrup"), rs.getString("cinsiyet"), rs.getString("dogumtarih"), rs.getString("dogumyer"), rs.getString("statü"), rs.getString("ogrenimdurum"), rs.getString("isgkurulgorev"), rs.getString("isebaslangictarih"), rs.getString("unvan"));
                kullanicilist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullanicilist;
    }

    public void insert(Kullanici kullanici) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("insert into kullanici(sicilno,gorevtanim,tc,ad,soyad,durum,boy,kilo,kangrup,"
                    + "cinsiyet,dogumtarih,dogumyer,statü,ogrenimdurum,isgkurulgorev,isebaslangictarih,unvan,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, kullanici.getSicilno());
            st.setString(2, kullanici.getGorevtanim());
            st.setString(3, kullanici.getTc());
            st.setString(4, kullanici.getAd());
            st.setString(5, kullanici.getSoyad());
            st.setString(6, kullanici.getDurum());
            st.setDouble(7, kullanici.getBoy());
            st.setDouble(8, kullanici.getKilo());
            st.setString(9, kullanici.getKangrup());
            st.setString(10, kullanici.getCinsiyet());
            st.setString(11, kullanici.getDogumtarih());
            st.setString(12, kullanici.getDogumyer());
            st.setString(13, kullanici.getStatü());
            st.setString(14, kullanici.getOgrenimdurum());
            st.setString(15, kullanici.getIsgkurulgorev());
            st.setString(16, kullanici.getIsebaslangictarih());
            st.setString(17, kullanici.getUnvan());
            st.setInt(18, kullanici.getUser_id());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Kullanici k) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("delete from kullanici where sicilno=?");
            st.setInt(1, k.getSicilno());
            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Kullanici kullanici) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("update kullanici set gorevtanim=?,tc=?,ad=?,soyad=?,durum=?,boy=?,kilo=?,kangrup=?,cinsiyet=?,dogumtarih=?,dogumyer=?,statü=?,ogrenimdurum=?,isgkurulgorev=?,isebaslangictarih=?,unvan=? where sicilno=?");

            st.setString(1, kullanici.getGorevtanim());
            st.setString(2, kullanici.getTc());
            st.setString(3, kullanici.getAd());
            st.setString(4, kullanici.getSoyad());
            st.setString(5, kullanici.getDurum());
            st.setDouble(6, kullanici.getBoy());
            st.setDouble(7, kullanici.getKilo());
            st.setString(8, kullanici.getKangrup());
            st.setString(9, kullanici.getCinsiyet());
            st.setString(10, kullanici.getDogumtarih());
            st.setString(11, kullanici.getDogumyer());
            st.setString(12, kullanici.getStatü());
            st.setString(13, kullanici.getOgrenimdurum());
            st.setString(14, kullanici.getIsgkurulgorev());
            st.setString(15, kullanici.getIsebaslangictarih());
            st.setString(16, kullanici.getUnvan());
            st.setInt(17, kullanici.getSicilno());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Kullanici> getFirmaKullanicis(int firmaid) {
        ArrayList<Kullanici> firmaKullanicis = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from kullanicifirma where firmaid=");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                firmaKullanicis.add(this.find(rs.getLong("sicilno")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaKullanicis;
    }

    public List<Kullanici> findAll(int page, int pageSize, String arama, String userid) {
        List<Kullanici> kullanicilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {

            String aramaSql = "where user_id = '" + userid + "'";

            if (arama != null) {
                aramaSql += "and (sicilno = '" + arama + "' or ad like '%" + arama + "%' or soyad like '%" + arama + "%' or gorevtanim like '%" + arama + "%' or tc like '%" + arama + "%')";
            }

            PreparedStatement st = c.prepareStatement("select * from kullanici " + aramaSql + " order by sicilno asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Kullanici tmp = new Kullanici();
                tmp.setSicilno(rs.getInt("sicilno"));
                tmp.setGorevtanim(rs.getString("gorevtanim"));
                tmp.setTc(rs.getString("tc"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setDurum(rs.getString("durum"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setKangrup(rs.getString("kangrup"));
                tmp.setCinsiyet(rs.getString("cinsiyet"));
                tmp.setDogumtarih(rs.getString("dogumtarih"));
                tmp.setDogumyer(rs.getString("dogumyer"));
                tmp.setStatü(rs.getString("statü"));
                tmp.setOgrenimdurum(rs.getString("ogrenimdurum"));
                tmp.setIsgkurulgorev(rs.getString("isgkurulgorev"));
                tmp.setIsebaslangictarih(rs.getString("isebaslangictarih"));
                tmp.setUnvan(rs.getString("unvan"));

                kullanicilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullanicilist;
    }

    public List<Kullanici> findAll(int page, int pageSize) {
        List<Kullanici> kullanicilist = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = c.prepareStatement("select * from kullanici order by sicilno asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Kullanici tmp = new Kullanici();
                tmp.setSicilno(rs.getInt("sicilno"));
                tmp.setGorevtanim(rs.getString("gorevtanim"));
                tmp.setTc(rs.getString("tc"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setDurum(rs.getString("durum"));
                tmp.setBoy(rs.getDouble("boy"));
                tmp.setKilo(rs.getDouble("kilo"));
                tmp.setKangrup(rs.getString("kangrup"));
                tmp.setCinsiyet(rs.getString("cinsiyet"));
                tmp.setDogumtarih(rs.getString("dogumtarih"));
                tmp.setDogumyer(rs.getString("dogumyer"));
                tmp.setStatü(rs.getString("statü"));
                tmp.setOgrenimdurum(rs.getString("ogrenimdurum"));
                tmp.setIsgkurulgorev(rs.getString("isgkurulgorev"));
                tmp.setIsebaslangictarih(rs.getString("isebaslangictarih"));
                tmp.setUnvan(rs.getString("unvan"));

                kullanicilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullanicilist;
    }

    public int count() {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int count = 0;
        try {
            PreparedStatement st = c.prepareStatement("select count(sicilno) as kullanici_count from kullanici");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("kullanici_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
