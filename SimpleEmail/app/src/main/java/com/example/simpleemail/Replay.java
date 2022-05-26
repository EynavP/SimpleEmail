package com.example.simpleemail;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Replay implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    int mail_id;
    String comment;

    public Replay(int mail_id, String comment) {
        this.mail_id = mail_id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMail_id() {
        return mail_id;
    }

    public void setMail_id(int mail_id) {
        this.mail_id = mail_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
