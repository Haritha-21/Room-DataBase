package com.example.addvwinsuproomdata;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={user.class},version=1)
public  abstract class Myappdatabase extends RoomDatabase{

    public abstract  myDao myDao();
}
