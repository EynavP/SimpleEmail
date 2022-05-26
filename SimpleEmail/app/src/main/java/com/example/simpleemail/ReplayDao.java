package com.example.simpleemail;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReplayDao {

    @Query("SELECT * FROM Replay WHERE mail_id = :id")
    List<Replay> getAllReplays(int id);

    @Query("SELECT * FROM Replay WHERE id = :id")
    Replay get(int id);

    @Insert
    void insertReplay(Replay...replays);

    @Delete
    void delete(Replay replay);
}
