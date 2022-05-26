package com.example.simpleemail;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MailDao {

    @Query("SELECT * FROM Mail")
    List<Mail> getAllMails();

    @Query("SELECT * FROM Mail WHERE id = :id")
    Mail get(int id);

    @Query("SELECT Reply FROM Mail WHERE id = :id")
    List<String> getAllReplay(int id);

    @Insert
    void insertMail(Mail...mails);

    @Delete
    void delete(Mail mail);



}
