package com.britishbroadcast.mvpapplicationroomdb.presenter;

import android.util.Log;

import androidx.room.Room;

import com.britishbroadcast.mvpapplicationroomdb.model.data.GymMember;
import com.britishbroadcast.mvpapplicationroomdb.model.db.GymDatabase;
import com.britishbroadcast.mvpapplicationroomdb.presenter.GymContract.GymView;

import java.util.List;

import static com.britishbroadcast.mvpapplicationroomdb.model.db.GymDatabase.DATABASE_NAME;

public class GymPresenter implements GymContract.GymPresenter {

    private GymView gymView;
    private GymDatabase gymDatabase;

    public GymPresenter(GymView gymView) {
        this.gymView = gymView;

        gymDatabase = Room.databaseBuilder(
                gymView.getContext(),
                GymDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Override
    public void insertGymMember(GymMember gymMember) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    gymDatabase.gymDAO().createMember(gymMember);
                    gymView.displaySuccess(
                            "Memeber "
                                    + gymMember.getName() +
                                    " created successfully.");
                } catch (Exception e) {
                    Log.d("TAG_X", e.getLocalizedMessage());
                    gymView.displayError("Failed to create member "+ gymMember.getName()+".");
                }
            }
        }.start();

        getAllGymMembers();

    }

    @Override
    public void getAllGymMembers() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    List<GymMember > members = gymDatabase.gymDAO().viewAllGymMembers();
                    if(members.isEmpty())
                        gymView.displayError("No members in the database :(");
                    else
                        gymView.displayMembers(members);

                } catch (Exception e) {
                    Log.d("TAG_X", e.getLocalizedMessage());
                    gymView.displayError("Failed to read from members. Please try again later.");
                }
            }
        }.start();

    }

    @Override
    public void deleteGymMember(GymMember gymMember) {

    }
}
