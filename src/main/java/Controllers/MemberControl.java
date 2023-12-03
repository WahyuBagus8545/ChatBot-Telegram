/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Member;
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
public class MemberControl {
    final static String TABLE_NAME = "Members";
    
    // statement = interface untuk menggunakan query
    static Statement statement;
    static ResultSet result;   
    
    public MemberControl() {
    }
    
    public List<Member> index() {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY name;";
        List<Member> listMember = new ArrayList<Member>();
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Member member = new Member(result.getString("id"), result.getString("name"), result.getString("username"));
                listMember.add(member);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Controllers.MemberControl.getAll() : " + e);
        }
        try {
            statement.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Controllers.UserControl.index() : " + e);
        }
        return listMember;
    }
    
    public boolean store(Member member) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(UPPER('" + member.getId() + "'), '" + member.getName() + "', '" + member.getUsername()+ "')";
            
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
            } catch (Exception e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.MemberControl.store() : Gagal menyimpan data member (" + e + ")");
            return false;
        }
    }
    
    public Member show(String id) {
        ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = '" + id + "';";
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                Member member = new Member(result.getString("id"), result.getString("name"), result.getString("username"));
                con.close();
                statement.close();
                return member;
            }
            con.close();
            statement.close();
            System.err.println("Controllers.MemberControl.show() : Member tidak ditemukan");
            return null;
        } catch (SQLException e) {
            try {
                statement.close();
                con.close();
            } catch (Exception e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.MemberControl.show() : " + e);
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
            try {
                statement.close();
                con.close();
            } catch (Exception e2) {
                System.err.println("Controllers.UserControl.index() : " + e2);
            }
            System.err.println("Controllers.MemberControl.destroy() : " + e);
            return false;
        }
    }
}
