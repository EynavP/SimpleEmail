package com.example.simpleemail;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Mail implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    String mail_title;
    String first_letter;
    String sender;
    String to;
    String time;
    String content;



    public Mail(String mail_title, String sender,String to, String content) {
        this.mail_title = mail_title;
        this.first_letter = sender.charAt(0)+"";
        this.sender = sender;
        this.to = to;
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

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}


    public String getTo() { return to; }

    public void setTo(String to) { this.to = to; }
}
