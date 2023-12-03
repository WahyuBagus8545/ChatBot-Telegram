 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Chat;
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
public class ChatControl {
     final static String TABLE_NAME = "Chats";
    
    // statement = interface untuk menggunakan query
    static Statement statement;
    static ResultSet result;   
    

    
    public List<Chat> index() {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY created_at DESC;";
        List<Chat> listChat = new ArrayList<Chat>();
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Chat chat = new Chat(result.getString("id"), result.getString("category"), result.getString("sender"), result.getString("message"));
                listChat.add(chat);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Controllers.ChatControl.getAll() : " + e);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Controllers.UserControl.index() : " + e);
        }
        
        return listChat;
        

    
    }
    
    public boolean store(Chat chat) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(UPPER('" + chat.getId() + "'), '" + chat.getCategory()+ "', '" + chat.getSender()+ "', '" + chat.getMessage() + "', NOW());";
            
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
//            System.out.println("controllers.ChatController.store() : Berhasil menyimpan data chat");
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
            System.err.println("Controllers.ChatControl.store() : Gagal menyimpan data chat (" + e + ")");
            return false;
        }
    }
    
    public Chat show(String id) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = '" + id + "';";
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Chat selectedChat = new Chat(result.getString("id"), result.getString("category"), result.getString("sender"), result.getString("message"));
                con.close();
                statement.close();
                return selectedChat;
            }
            statement.close();
            return null;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.ChatControl.show() : " + e);
            return null;
        }
    }
    
    public boolean destroy(String id) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = '" + id + "';";
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
//            System.out.println("controllers.ChatController.destroy() : Data Chat berhasil dihapus");
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
            System.err.println("Controllers.ChatControl.destroy() : " + e);
            return false;
        }
    }
    
}
