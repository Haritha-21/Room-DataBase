package com.example.addvwinsuproomdata;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDao {

    @Insert
    public void adduser(user user);


    @Query("Select * from users")
    public List<user> getuser();

    @Update
    public void updateuser(user user);


    @Delete
    public void deleteuser(user user);

}
