/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Document;
import Utility.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class DocumentDao extends AbstractDao implements Serializable {

    public List<Document> findAll(int page, int pageSize) {
          DBConnection db = new DBConnection();
        Connection c = db.connect();
        List<Document> dList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = c.prepareStatement("select * from document order by fileid limit " + pageSize + " offset " + start);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setFileId(rs.getInt("fileid"));
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));

                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public int count() {
        int count = 0;
          DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            PreparedStatement pst = c.prepareStatement("select count(fileid) as doc_count from document");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("doc_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public List<Document> findAll() {
          DBConnection db = new DBConnection();
        Connection c = db.connect();
        List<Document> dList = new ArrayList<>();
        try {
            PreparedStatement pst = c.prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setFileId(rs.getInt("fileid"));
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));

                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public void insert(Document d) {
          DBConnection db = new DBConnection();
        Connection c = db.connect();
        String query = "insert into document (path,name,type) values (?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
