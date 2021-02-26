package com.britishbroadcast.mvpapplicationroomdb.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.britishbroadcast.mvpapplicationroomdb.model.data.GymMember;

@Database(version = 1, entities = {GymMember.class})
public abstract class GymDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "gym.db";
    public abstract GymDAO gymDAO();
}
