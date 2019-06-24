package Dao;

import Entity.Firma;
import Entity.Kullanici;
import Entity.Kullanicifirma;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class KullanicifirmaDAO {

    public List<Kullanicifirma> getKullaniciFirmas() {
        List<Kullanicifirma> kflist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from kullanicifirma");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kullanicifirma tmp = new Kullanicifirma(rs.getInt("sicilno"), rs.getInt("firmaid"));

                ResultSet rsFirma = st.executeQuery("select ad from firma");

                Firma tmpFirma = new Firma();
                tmpFirma.setFunvan(rsFirma.getString("ad"));

                tmp.setFirma(tmpFirma);

                ResultSet rskullanici = st.executeQuery("select ad, soyad from kullanici");

                Kullanici tmpKullanici = new Kullanici();
                tmpKullanici.setAd(rsFirma.getString("ad"));
                tmpKullanici.setSoyad(rsFirma.getString("soyad"));

                tmp.setKullanici(tmpKullanici);

                kflist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kflist;
    }

    public boolean create(List<Kullanicifirma> list) {
        try {
            DBConnection db = new DBConnection();
            Connection c = db.connect();
            Statement st = c.createStatement();

            for (Kullanicifirma item : list) {
                st.execute("insert into (" + item.getSicilno() + "," + item.getFirmaid() + ")");
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<SelectItem> firmaListesi() {
        ArrayList<SelectItem> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select firmaid, funvan from firma order by firmaid desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                SelectItem tmp = new SelectItem(rs.getInt("firmaid"), rs.getString("funvan"));

                list.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public ArrayList<SelectItem> kullaniciListesi() {
        ArrayList<SelectItem> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select ad, soyad, sicilno from kullanici order by sicilno desc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                SelectItem tmp = new SelectItem(rs.getInt("sicilno"), rs.getString("ad")+" "+rs.getString("soyad"));

                list.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public ArrayList<SelectItem> personelListesi() {
        ArrayList<SelectItem> list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select ad, soyad, sicilnop from personel");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                SelectItem tmp = new SelectItem(rs.getInt("sicilnop"), rs.getString("ad")+" "+rs.getString("soyad"));

                list.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

}
