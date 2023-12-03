/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wahyubagus.project.chatbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ConnectMysql {
    String url, usr, pwd, dbn;
    public ConnectMysql(String dbn){
        this.url = "jdbc:mysql://localhost/"+ dbn;
        this.usr = "root";
        this.pwd = "";
    }
    
    public ConnectMysql (String host, String user, String pass, String dbn) {
        this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr = user;
        this.pwd = pass;
    }
    
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.usr,this.pwd);
            //System.out.println("Berhasil ");
        } 
        
        catch (ClassNotFoundException e) {
            System.out.println ("Error #1 : " + e.getMessage());
            System.exit(0);
        } 
        catch (SQLException e) {
            System.out.println ("Error #2 : " + e.getMessage());
            System.exit(0);
        }
        return con;
    }
    
}
