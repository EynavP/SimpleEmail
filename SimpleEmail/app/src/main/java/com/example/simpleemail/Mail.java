package com.example.simpleemail;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;


public class Mail implements Serializable {

    String mail_title;
    String first_letter;
    String sender;
    String time;
    String content;


    public Mail(String mail_title, String sender, String content) {
        this.mail_title = mail_title;
        this.first_letter = sender.charAt(0)+"";
        this.sender = sender;
        this.time = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        this.content = content;
    }

    public String getMail_title() {
        return mail_title;
    }

    public void setMail_title(String mail_title) {
        this.mail_title = mail_title;
    }

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public String getTime() {
        return time;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
