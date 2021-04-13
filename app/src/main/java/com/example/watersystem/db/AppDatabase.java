package com.example.watersystem.db;

import android.content.Context;

import com.example.watersystem.db.dao.UserWaterDao;
import com.example.watersystem.db.table.UserWater;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserWater.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserWaterDao userWaterDao();


    public static AppDatabase appDatabase;

    public static synchronized AppDatabase newInstance(Context context) {

        if (appDatabase == null) {

            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Water")
                    .fallbackToDestructiveMigration().build();
        }
        return appDatabase;
    }
}
