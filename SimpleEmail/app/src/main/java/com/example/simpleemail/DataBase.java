package com.example.simpleemail;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {Mail.class},version = 1)
@TypeConverters({Converters.class})
public abstract class DataBase extends RoomDatabase
{
    public abstract MailDao mailDao();

    public static DataBase INSTANCE;

    public static DataBase getDbInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DataBase.class,"DB_NAME")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
