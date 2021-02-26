package com.britishbroadcast.mvpapplicationroomdb.presenter;

import android.content.Context;

import com.britishbroadcast.mvpapplicationroomdb.model.data.GymMember;

import java.util.List;

public interface GymContract {


    interface GymPresenter {
        void insertGymMember(GymMember gymMember);
        void getAllGymMembers();
        void deleteGymMember(GymMember gymMember);
    }

    interface GymView {
        void displayMembers(List<GymMember> members);
        void displayError(String errorMessage);
        void displaySuccess(String successMessage);
        Context getContext();
    }

}
