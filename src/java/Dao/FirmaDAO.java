package Dao;

import Entity.Firma;
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

public class FirmaDAO {

    private DBConnection db;
    private Connection c;

    private FirmagruplariDAO firmagruplariDAO;
    private KullaniciDAO kullaniciDAO;

    public Firma find(Long id) {
        Firma f = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement st = c.prepareStatement("select * from firma where firmaid=?");
            ResultSet rs = st.executeQuery("");
            rs.next();
            f = new Firma();
            f.setFirmaid(rs.getInt("firmaid"));
            f.setFunvan(rs.getString("funvan"));
            f.setIsvrnadsoyad(rs.getString("isvrnadsoyad"));
            f.setIsvrngsm(rs.getString("isvrngsm"));
            f.setFirmatlfn(rs.getString("firmatlfn"));
            f.setFaks(rs.getString("faks"));
            f.setFirmamail(rs.getString("firmamail"));
            f.setIl(rs.getString("il"));
            f.setIlce(rs.getString("ilce"));
            f.setAdres(rs.getString("adres"));
            f.setFaaliyetalan(rs.getString("faaliyetalan"));
            f.setSgksicil(rs.getString("sgksicil"));
            f.setTehlikesinif(rs.getString("tehlikesinif"));
            f.setGrupsirket(rs.getString("grupsirket"));
            f.setDurum(rs.getString("durum"));
            f.setGrup_id(rs.getInt("grup_id"));

            ArrayList<Kullanici> firmaKullanicis = new ArrayList<Kullanici>();

            ResultSet rskullanici = st.executeQuery("select ad, soyad from kullanici k, kullanicifirma f where k.sicilno = f.sicilno and f.firmaid = " + f.getFirmaid());

            while (rskullanici.next()) {
                Kullanici tmpKullanici = new Kullanici();
                tmpKullanici.setAd(rskullanici.getString("ad"));
                tmpKullanici.setSoyad(rskullanici.getString("soyad"));
                firmaKullanicis.add(tmpKullanici);
            }
            f.setFirmaKullanicis(firmaKullanicis);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }

    public List<Firma> getFirmas() {
        List<Firma> firmalist = new ArrayList();

        try {
            PreparedStatement st = this.getC().prepareStatement("select * from firma");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Firma tmp = new Firma(rs.getInt("firmaid"), rs.getString("funvan"), rs.getString("isvrnadsoyad"), rs.getString("isvrngsm"), rs.getString("firmatlfn"), rs.getString("faks"), rs.getString("firmamail"), rs.getString("il"), rs.getString("ilce"), rs.getString("adres"), rs.getString("faaliyetalan"), rs.getString("sgksicil"), rs.getString("tehlikesinif"), rs.getString("grupsirket"), rs.getString("durum"), rs.getInt("grup_id"));

                ArrayList<Kullanici> firmaKullanicis = new ArrayList<Kullanici>();

                ResultSet rskullanici = st.executeQuery("select ad, soyad from kullanici k, kullanicifirma f where k.sicilno = f.sicilno and f.firmaid = " + tmp.getFirmaid());

                while (rskullanici.next()) {
                    Kullanici tmpKullanici = new Kullanici();
                    tmpKullanici.setAd(rskullanici.getString("ad"));
                    tmpKullanici.setSoyad(rskullanici.getString("soyad"));
                    firmaKullanicis.add(tmpKullanici);
                }
                tmp.setFirmaKullanicis(firmaKullanicis);

                firmalist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firmalist;
    }

    public void insert(Firma firma, int[] kullaniciids) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into firma(funvan,isvrnadsoyad,isvrngsm,firmatlfn,faks,firmamail,il,ilce,adres,faaliyetalan,sgksicil,tehlikesinif,grupsirket,durum,grup_id,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, firma.getFunvan());
            pst.setString(2, firma.getIsvrnadsoyad());
            pst.setString(3, firma.getIsvrngsm());
            pst.setString(4, firma.getFirmatlfn());
            pst.setString(5, firma.getFaks());
            pst.setString(6, firma.getFirmamail());
            pst.setString(7, firma.getIl());
            pst.setString(8, firma.getIlce());
            pst.setString(9, firma.getAdres());
            pst.setString(10, firma.getFaaliyetalan());
            pst.setString(11, firma.getSgksicil());
            pst.setString(12, firma.getTehlikesinif());
            pst.setString(13, firma.getGrupsirket());
            pst.setString(14, firma.getDurum());
            pst.setInt(15, firma.getGrup_id());
            pst.setInt(16, firma.getUser_id());

            pst.executeUpdate();

            ResultSet keys = pst.getGeneratedKeys();

            int firmaid = 0;
            while (keys.next()) {
                firmaid = keys.getInt(1);
            }

            for (int i = 0; i < kullaniciids.length; i++) {
                pst = this.getC().prepareStatement("insert into kullanicifirma (sicilno, firmaid) values (" + kullaniciids[i] + "," + firmaid + ")");
                pst.setInt(1, kullaniciids[i]);
                pst.setInt(2, firmaid);
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Firma firm) {

        try {
            PreparedStatement st = this.getC().prepareStatement("delete from firma where firmaid=?");
            st.setInt(1, firm.getFirmaid());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Firma firma) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update firma set funvan=?,isvrnadsoyad=?,isvrngsm=?,firmatlfn=?,faks=?,firmamail=?,il=?,ilce=?,adres=?,faaliyetalan=?,sgksicil=?,tehlikesinif=?,grupsirket=?,durum=?,grup_id=? where firmaid=?");

            pst.setString(1, firma.getFunvan());
            pst.setString(2, firma.getIsvrnadsoyad());
            pst.setString(3, firma.getIsvrngsm());
            pst.setString(4, firma.getFirmatlfn());
            pst.setString(5, firma.getFaks());
            pst.setString(6, firma.getFirmamail());
            pst.setString(7, firma.getIl());
            pst.setString(8, firma.getIlce());
            pst.setString(9, firma.getAdres());
            pst.setString(10, firma.getFaaliyetalan());
            pst.setString(11, firma.getSgksicil());
            pst.setString(12, firma.getTehlikesinif());
            pst.setString(13, firma.getGrupsirket());
            pst.setString(14, firma.getDurum());
            pst.setInt(15, firma.getGrup_id());
            pst.setInt(16, firma.getFirmaid());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FirmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public FirmagruplariDAO getFirmagruplariDAO() {
        if (this.firmagruplariDAO == null) {
            this.firmagruplariDAO = new FirmagruplariDAO();
        }
        return firmagruplariDAO;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public List<Firma> findAll(int page, int pageSize, String arama, String userid) {
        List<Firma> firmalist = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            String aramaSql = "where user_id = '"+userid+"'";
            if (arama != null) {
                aramaSql += " and (firmaid ='" + arama + "' or funvan like '%" + arama + "%')";
            }

            PreparedStatement pst = this.getC().prepareStatement("select * from firma " + aramaSql + " order by firmaid asc limit " + start + "," + pageSize);
            //Statement st = this.getC().createStatement();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Firma tmp = new Firma();
                tmp.setFirmaid(rs.getInt("firmaid"));
                tmp.setFunvan(rs.getString("funvan"));
                tmp.setIsvrnadsoyad(rs.getString("isvrnadsoyad"));
                tmp.setIsvrngsm(rs.getString("isvrngsm"));
                tmp.setFirmatlfn(rs.getString("firmatlfn"));
                tmp.setFaks(rs.getString("faks"));
                tmp.setFirmamail(rs.getString("firmamail"));
                tmp.setIl(rs.getString("il"));
                tmp.setIlce(rs.getString("ilce"));
                tmp.setAdres(rs.getString("adres"));
                tmp.setFaaliyetalan(rs.getString("faaliyetalan"));
                tmp.setSgksicil(rs.getString("sgksicil"));
                tmp.setTehlikesinif(rs.getString("tehlikesinif"));
                tmp.setGrupsirket(rs.getString("grupsirket"));
                tmp.setDurum(rs.getString("durum"));

                tmp.setFirmaKullanicis(this.getKullaniciDAO().getFirmaKullanicis(tmp.getFirmaid()));
                tmp.setFirmagruplari(this.getFirmagruplariDAO().find(rs.getLong("grup_id")));
                firmalist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmalist;
    }

    public List<Firma> findAll(int page, int pageSize) {
        List<Firma> firmalist = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from firma order by firmaid asc limit " + start + "," + pageSize);
            //Statement st = this.getC().createStatement();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Firma tmp = new Firma();
                tmp.setFirmaid(rs.getInt("firmaid"));
                tmp.setFunvan(rs.getString("funvan"));
                tmp.setIsvrnadsoyad(rs.getString("isvrnadsoyad"));
                tmp.setIsvrngsm(rs.getString("isvrngsm"));
                tmp.setFirmatlfn(rs.getString("firmatlfn"));
                tmp.setFaks(rs.getString("faks"));
                tmp.setFirmamail(rs.getString("firmamail"));
                tmp.setIl(rs.getString("il"));
                tmp.setIlce(rs.getString("ilce"));
                tmp.setAdres(rs.getString("adres"));
                tmp.setFaaliyetalan(rs.getString("faaliyetalan"));
                tmp.setSgksicil(rs.getString("sgksicil"));
                tmp.setTehlikesinif(rs.getString("tehlikesinif"));
                tmp.setGrupsirket(rs.getString("grupsirket"));
                tmp.setDurum(rs.getString("durum"));

                tmp.setFirmaKullanicis(this.getKullaniciDAO().getFirmaKullanicis(tmp.getFirmaid()));
                tmp.setFirmagruplari(this.getFirmagruplariDAO().find(rs.getLong("grup_id")));
                firmalist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmalist;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(firmaid) as firma_count from firma");
            //Statement st = this.getC().createStatement();
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("firma_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
