package Dao;

import Entity.Tanilar;
import Utility.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TanilarDAO {

    public List<Tanilar> getTanilars() {
        List<Tanilar> tnlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from tanilar");
            while (rs.next()) {
                Tanilar tmp = new Tanilar(rs.getInt("taniid"), rs.getInt("tanimid"), rs.getInt("mid"));
                tnlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tnlist;
    }

}
