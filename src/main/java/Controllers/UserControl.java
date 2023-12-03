/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.User;
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
public class UserControl {
    final static String TABLE_NAME = "users";
    
    // statement = interface untuk menggunakan query
    static Statement statement;
    static ResultSet result;   
    
    public UserControl() {
    }
    
    public List<User> index() {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
         
        
        String query = "SELECT * FROM " + TABLE_NAME + ";";
        List<User> listUser = new ArrayList<User>();
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                User user = new User(result.getString("id"), result.getString("name"), result.getString("username"), result.getString("password"));
                listUser.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Controllers.UserControl.getAll() : " + e);
        }
        try {
            statement.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Controllers.UserControl.index() : " + e);
        }
        
        return listUser;
    }
    
    public void store(User user) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        
        String query = "INSERT INTO " + TABLE_NAME+ " VALUES(UPPER('" + user.getId() + "'), '" + user.getName() + "', '" + user.getUsername() + "','" + user.getPassword() + "')";
            
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            System.err.println("Controllers.UserControl.store() : " + e);
        }
        
        try {
            statement.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Controllers.UserControl.index() : " + e);
        }
    }
    
    public User show(String username) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = '" + username + "';";
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                User user = new User(result.getString("id"), result.getString("name"), result.getString("username"), result.getString("password"));
                con.close();
                statement.close();
                return user;
            }
            System.err.println("Controllers.UserControl.show() : User tidak ditemukan");
            return null;
        } catch (SQLException e) {
            System.err.println("Controllers.UserControl.show() : "+ e);
            return null;
        }
    }
    
    public Boolean destroy(String username) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        
        String query = "DELETE FROM " + TABLE_NAME + " WHERE username = '" + username + "';";
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
            con.close();
            statement.close();
            return true;
        } catch (Exception e) {
            System.err.println("Controllers.UserControl.destroy() : " + e);
            return false;
        }
    }
}
