/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Keyword;
import com.wahyubagus.project.chatbot.ConnectMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class KeywordControl {
    final static String TABLE_NAME = "Keywords";
    
    // statement = interface untuk menggunakan query
    static Statement statement;
    static ResultSet result;   
    
    public KeywordControl() {
    }
    
    public List<Keyword> index() {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY keyword ASC;";
        List<Keyword> listKeyword = new ArrayList<Keyword>();
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Keyword keyword = new Keyword(result.getString("id"), result.getString("keyword"), result.getString("response"));
                listKeyword.add(keyword);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Controllers.KeywordControl.getAll() : " + e);
        }
        
        try {
            statement.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Controllers.UserControl.index() : " + e);
        }
        
        return listKeyword;
    }
    
    public boolean store(Keyword keyword) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(UPPER('" + keyword.getId() + "'), '" + keyword.getKeyword()+ "', '" + keyword.getResponse() + "');";
            
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
            con.close();
            statement.close();
            return true;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.KeywordControl.store() : Gagal menyimpan data keyword (" + e + ")");
            return false;
        }
    }
    
    public Keyword show(String keyword) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE keyword = '" + keyword + "';";
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Keyword selectedKeyword = new Keyword(result.getString("id"), result.getString("keyword"), result.getString("response"));
                con.close();
                statement.close();
                return selectedKeyword;
            }
            con.close();
            statement.close();
            System.err.println("Controllers.KeywordControl.show() : Keyword tidak ditemukan");
            return null;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.out.println("Controllers.KeywordControl.show() (" + e + ")");
            return null;
        }
    }

    public String getResponse(String keyword) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT response FROM " + TABLE_NAME + " WHERE keyword = '" + keyword + "';";
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                String response = result.getString("response");
                con.close();
                statement.close();
                return response;
            }
            con.close();
            statement.close();
            System.err.println("Controllers.KeywordControl.show() : Keyword tidak ditemukan");
            return "Maaf, Keyword belum terdaftar";
            
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.out.println("Controllers.KeywordControl.show() : Keyword tidak ditemukan (" + e + ")");
            return "Maaf, terjadi kesalahan pada sistem kami";
        }
    }
    
    public boolean update(Keyword keyword) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String id = keyword.getId();
        String textKeyword = keyword.getKeyword();
        String response = keyword.getResponse();
        
        String query = "UPDATE keywords SET keyword = '" + textKeyword + "', response = '" + response + "' WHERE keywords.id = '" + id + "'";
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
            con.close();
            statement.close();
            return true;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.KeywordControl.destroy() : " + e);
            return false;
        }
    }
    
    public Boolean destroy(String id) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = '" + id + "';";
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
            con.close();
            statement.close();
            return true;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.KeywordControl.destroy() : " + e);
            return false;
        }
    }   
}
