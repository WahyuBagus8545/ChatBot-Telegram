/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import Controllers.ChatControl;
import Model.Chat;
import com.wahyubagus.project.chatbot.ConnectMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author user
 */
public class pnlChat extends javax.swing.JPanel {

    /**
     * Creates new form pnlChat
     */
     ConnectMysql kon = new ConnectMysql("localhost","root","","chatbot");
        Connection con = kon.getConnection();
        
    public pnlChat() {
        initComponents();
        refresh();
        dateFromLog.setDateFormatString("yyyy-MM-dd");
        dateToLog.setDateFormatString("yyyy-MM-dd");
        
        // agar background putih
        ChatTable.setOpaque(true);
        ChatTable.setFillsViewportHeight(true);
        
        ChatTable.setShowGrid(true);
    }
    void filterLog(){
        DefaultTableModel tableModel = (DefaultTableModel)ChatTable.getModel();
        tableModel.setRowCount(0); //reset data
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        inputFormat.setTimeZone(TimeZone.getTimeZone("WIB"));
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateFrom = dateFromLog.getDate();
        Date dateTo = dateToLog.getDate();
        String stringFrom = outputFormat.format(dateFrom);
        String stringTo = outputFormat.format(dateTo);
   
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chats WHERE date(created_at)>=" + "date('"+ stringFrom+"') and date(created_at)<=" + "date('"+ stringTo+"')");
       
            
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String category =  resultSet.getString("category");
                String sender = resultSet.getString("sender");
                String message = resultSet.getString("message");
                String time = resultSet.getString("created_at");
//                System.out.println(time);
                Object[] rowData = {id,category,sender,message,time};
                tableModel.addRow(rowData);
            }
        }
        catch (SQLException e) {
        }
    }
    
    public void refresh() {
         try {
              String[] HEADER = {"Id", "Category", "Sender", "Message","Create at"};
              
              
             Statement statement = con.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM chats");
             DefaultTableModel tableModel = (DefaultTableModel) ChatTable.getModel();
             
             tableModel.setRowCount(0);
//             Object[][] dataTable;
            
//             int columnSize = HEADER.length;
             
//             ChatControl chatControl = new ChatControl();
//             List<Chat> listChat = chatControl.index();
//             int baris = listChat.size();
//             dataTable = new Object[baris][columnSize];
             
//             for(int i = 0; i < baris; i++) {
//                 Chat chat = listChat.get(i);
//                 dataTable[i][0] = chat.getId();
//                 dataTable[i][1] = chat.getCategory();
//                 dataTable[i][2] = chat.getSender();
//                 dataTable[i][3] = chat.getMessage();
//                 dataTable[i][4] = chat.getTime();
//             }
            while(result.next()){
                
                Object[] rowData = {result.getString("id"),result.getString("category"),result.getString("sender"),result.getString("message"),result.getString("created_at")};
                tableModel.addRow(rowData);
            }
             
//             ChatTable.setModel(new DefaultTableModel(dataTable, HEADER));
//                ChatTable.setModel(tableModel);
//            
         } catch (SQLException ex) {
             Logger.getLogger(pnlChat.class.getName()).log(Level.SEVERE, null, ex);
         }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ChatTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        MessageArea = new javax.swing.JTextArea();
        dateFromLog = new com.toedter.calendar.JDateChooser();
        dateToLog = new com.toedter.calendar.JDateChooser();
        btnCari = new javax.swing.JButton();

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        ChatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "category", "sender", "message", "created at"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ChatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChatTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ChatTable);

        MessageArea.setColumns(20);
        MessageArea.setRows(5);
        jScrollPane2.setViewportView(MessageArea);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateFromLog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateToLog, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateFromLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateToLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void ChatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatTableMouseClicked
        // TODO add your handling code here:
        int row = ChatTable.getSelectedRow();
        String message = "" + ChatTable.getValueAt(row, 3);
        MessageArea.setEditable(true);
        MessageArea.setText(message);
        MessageArea.setEditable(false);
    }//GEN-LAST:event_ChatTableMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        this.filterLog();
    }//GEN-LAST:event_btnCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ChatTable;
    private javax.swing.JTextArea MessageArea;
    private javax.swing.JButton btnCari;
    private com.toedter.calendar.JDateChooser dateFromLog;
    private com.toedter.calendar.JDateChooser dateToLog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
