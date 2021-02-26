package com.britishbroadcast.mvpapplicationroomdb.model.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.britishbroadcast.mvpapplicationroomdb.model.data.GymMember;

import java.util.List;

@Dao
public interface GymDAO {

    @Insert
    void createMember(GymMember... gymMember);//(gm1) or (gm1, gm2.....gmn)

    @Query("SELECT * FROM gym_member")
    List<GymMember> viewAllGymMembers();

    @Query("SELECT * FROM gym_member WHERE member_id = :memberId")
    GymMember selectGymMember(String memberId);

}
