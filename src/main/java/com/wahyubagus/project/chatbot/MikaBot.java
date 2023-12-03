/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wahyubagus.project.chatbot;

import static com.google.common.base.Strings.nullToEmpty;
import Controllers.ChatControl;
import Controllers.KeywordControl;
import Controllers.MemberControl;
import Model.Chat;
import Model.Member;
import Panel.pnlChat;
import Panel.pnlMember;
import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author user
 */
public class MikaBot extends TelegramLongPollingBot{
    private pnlMember pnlmember;
    private pnlChat pnlchat;
    private static String admin;
    
    public void setAdmin(String admin) {
        this.admin = admin;
        System.out.println("MikaBot.setAdmin() disini " + admin);
    }
    
    
    @Override
    public String getBotToken() {
        return "6246329806:AAEPUme5WbwopWNalhmaoCBO9ZetkOzxWgM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            
            // Controller 
            KeywordControl keywordControl= new KeywordControl();
            MemberControl memberControl = new MemberControl();
            ChatControl chatControl = new ChatControl();
            
            String textMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            String username = update.getMessage().getFrom().getUserName();
            
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            
            Chat receivedChat = new Chat("I", username, update.getMessage().getText());
            chatControl.store(receivedChat);
//            pnlchat.refresh();
//            
            
            if (textMessage.equals("/register")) {
                String name = nullToEmpty(update.getMessage().getFrom().getFirstName()) + " " + nullToEmpty(update.getMessage().getFrom().getLastName());
                
                if (memberControl.show(chatId) != null) {
                    sendMessage(message, "O", admin, "Akun mu sudah terdaftar, Selamat datang di Mika Bot", chatControl);
//                    pnlchat.refresh();
                    System.out.println("masuk1");
                    
                }
                else if (memberControl.store(new Member(chatId, name, username))) {
                    pnlmember.refresh();

                    sendMessage(message, "O", admin, "Register berhasil!, Selamat datang di Mika Bot", chatControl);
                    pnlchat.refresh();
                   
                } else {
                    sendMessage(message, "O", admin, "Register gagal", chatControl);
//                    pnlchat.refresh();
                    
                }
                
            } else if (memberControl.show(chatId) == null) {
                sendMessage(message, "O", admin, "Silahkan /register dulu !", chatControl);
//                pnlchat.refresh();
               
            } else {
                String keyword = update.getMessage().getText();
                String response = keywordControl.getResponse(keyword);
                message.setText(response);

                sendMessage(message, "O", admin, response, chatControl);
                pnlchat.refresh();
                }
            }
         
    }


    @Override
    public String getBotUsername() {
        return "MikaBot";
    }

    public void setMemberPanel(pnlMember pnlmember) {
        this.pnlmember = pnlmember;
    }

    public void setChatPanel(pnlChat pnlchat) {
        this.pnlchat = pnlchat;
    }
    

    public boolean sendBroadcast(String broadcastText) {
        MemberControl memberControl = new MemberControl();
        List<Member> listMember = memberControl.index();
        
        SendMessage message = new SendMessage();
        message.setText(broadcastText);
        
        try {
            for (int i = 0; i < listMember.size(); i++) {
                message.setChatId(listMember.get(i).getId());
                execute(message); // Call method to send the message
            }
            System.out.println("chatbot.MikaBot.sendBroadcast()" + admin);
            Chat chat = new Chat("B", admin, broadcastText);
            ChatControl chatControl = new ChatControl();
            chatControl.store(chat);
            System.out.println("chatbot.MikaBot.sendBroadcast()");
            return true;
        } catch (TelegramApiException e) {
            System.out.println("chatbot.MikaBot.sendBroadcast() broadcast gagal");
            return false;
        }
    }

    private void sendMessage(SendMessage message, String category, String sender, String text, ChatControl chatControl) {
        message.setText(text);
        try {
            execute(message); // Call method to send the message
            Chat newChat = new Chat(category, sender, text);
            chatControl.store(newChat);
        } catch (TelegramApiException e) {
        }
    }
    
}
