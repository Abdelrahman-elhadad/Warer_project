package com.example.watersystem.db.dao;

import com.example.watersystem.db.table.UserWater;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserWaterDao {

    @Query("SELECT * FROM userwater")
    List<UserWater> getAll();

    @Query("SELECT * FROM userwater where date=:date1 limit 1 ")
    List<UserWater> getDate(String date1);

    @Insert
    void insertAll(UserWater... users);

    @Delete
    void delete(UserWater user);

    @Update
    void update(UserWater user);

    @Query("DELEtE from userwater")
    void deleteAll();

}
