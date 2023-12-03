/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wahyubagus.project.chatbot;

import Form.frmLogin;
import Form.frmMain;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
    
        frmMain frmmain = new frmMain();
        frmmain.setVisible(false);
        frmLogin frmlogin = new frmLogin();
        frmlogin.setfrmMain(frmmain);
        frmlogin.setVisible(true);


        System.out.println("Siap dimulai");
    }
}
