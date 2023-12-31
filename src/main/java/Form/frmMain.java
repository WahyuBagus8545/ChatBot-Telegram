/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Panel.pnlBroadcast;
import Panel.pnlChat;
import Panel.pnlKeyword;
import Panel.pnlMember;
import Panel.pnlUser;


/**
 *
 * @author user
 */
public class frmMain extends javax.swing.JFrame {
    public void setName(String name) {
        txtUsername.setText(name);
    }
    

    /**
     * @return the broadcastPanel
     */
    public pnlBroadcast getpnlBroadcast() {
        return pnlbroadcast;
    }
    public pnlKeyword getpnlKeyword() {
        return pnlkeyword;
    }
    public pnlMember getpnlMember() {
        return pnlmember;
    }
    public pnlUser getpnlUser() {
        return pnluser;
    }
    public pnlChat getpnlChat() {
        return pnlchat;
    }

    
     // content
    private pnlBroadcast pnlbroadcast = new pnlBroadcast();
    private pnlChat pnlchat = new pnlChat();
    private pnlKeyword pnlkeyword = new pnlKeyword();
    private pnlMember pnlmember = new pnlMember();
    private pnlUser pnluser = new pnlUser();

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        ContentPanel.add(pnlbroadcast);
        ContentPanel.add(pnlchat);
        ContentPanel.add(pnlkeyword);
        ContentPanel.add(pnlmember);
        ContentPanel.add(pnluser);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnBroadcast = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnKeyword = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JLayeredPane();
        txtUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("MIKABOT");

        btnBroadcast.setText("Broadcast");
        btnBroadcast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBroadcastMouseClicked(evt);
            }
        });
        btnBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastActionPerformed(evt);
            }
        });

        btnUsers.setText("Users");
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsersMouseClicked(evt);
            }
        });

        btnMember.setText("Member");
        btnMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemberMouseClicked(evt);
            }
        });

        btnKeyword.setText("Keyword");
        btnKeyword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeywordMouseClicked(evt);
            }
        });
        btnKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeywordActionPerformed(evt);
            }
        });

        btnHistory.setText("History Chat");
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });

        jLabel1.setText("Log out");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        ContentPanel.setLayout(new java.awt.CardLayout());

        txtUsername.setText("username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(260, 260, 260)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKeyword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHistory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBroadcast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeyword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistory))
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBroadcastActionPerformed

    private void btnKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeywordActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnBroadcastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBroadcastMouseClicked
        // TODO add your handling code here:

        // sembunyikan konten
        getpnlBroadcast().setVisible(true);
        getpnlChat().setVisible(false);
        getpnlKeyword().setVisible(false);
        getpnlMember().setVisible(false);
        getpnlUser().setVisible(false);
    }//GEN-LAST:event_btnBroadcastMouseClicked

    private void btnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseClicked
        // TODO add your handling code here:
        getpnlUser().refresh();
        
        getpnlBroadcast().setVisible(false);
        getpnlChat().setVisible(false);
        getpnlKeyword().setVisible(false);
        getpnlMember().setVisible(false);
        getpnlUser().setVisible(true);
    }//GEN-LAST:event_btnUsersMouseClicked

    private void btnMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemberMouseClicked
        // TODO add your handling code here:
        getpnlMember().refresh();
        
        getpnlBroadcast().setVisible(false);
        getpnlChat().setVisible(false);
        getpnlKeyword().setVisible(false);
        getpnlMember().setVisible(true);
        getpnlUser().setVisible(false);
    }//GEN-LAST:event_btnMemberMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        // TODO add your handling code here:
        getpnlChat().refresh();
        
        getpnlBroadcast().setVisible(false);
        getpnlChat().setVisible(true);
        getpnlKeyword().setVisible(false);
        getpnlMember().setVisible(false);
        getpnlUser().setVisible(false);

    }//GEN-LAST:event_btnHistoryMouseClicked

    private void btnKeywordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeywordMouseClicked
        // TODO add your handling code here:
        getpnlKeyword().refresh();
        
        getpnlBroadcast().setVisible(false);
        getpnlChat().setVisible(false);
        getpnlKeyword().setVisible(true);
        getpnlMember().setVisible(false);
        getpnlUser().setVisible(false);
    }//GEN-LAST:event_btnKeywordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane ContentPanel;
    private javax.swing.JButton btnBroadcast;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnKeyword;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
