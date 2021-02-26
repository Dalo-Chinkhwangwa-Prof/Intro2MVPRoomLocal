package com.britishbroadcast.mvpapplicationroomdb.view;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.britishbroadcast.mvpapplicationroomdb.R;
import com.britishbroadcast.mvpapplicationroomdb.model.data.GymMember;
import com.britishbroadcast.mvpapplicationroomdb.presenter.GymContract;
import com.britishbroadcast.mvpapplicationroomdb.presenter.GymContract.GymView;
import com.britishbroadcast.mvpapplicationroomdb.presenter.GymPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GymView {

    private TextView textView;
    private GymContract.GymPresenter gymPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gymPresenter = new GymPresenter(this);
        textView = findViewById(R.id.main_textview);
    }

    @Override
    public void displayMembers(List<GymMember> members) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < members.size(); i++)
            sBuilder.append(members.get(i).getName() + " $" + members.get(i).getMonthlyPay() + "\n");

        textView.setText(sBuilder.toString());
    }

    @Override
    public void displayError(String errorMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.Theme_AppCompat))
                        .setTitle("Error!!")
                        .setMessage(errorMessage)
                        .setPositiveButton("Okay", (dialog, i) -> {
                            dialog.dismiss();
                        }).create()
                        .show();
            }
        });
    }

    @Override
    public void displaySuccess(String successMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.Theme_AppCompat))
                        .setTitle("Success!!")
                        .setMessage(successMessage)
                        .setPositiveButton("Perfect!", (dialog, i) -> {
                            dialog.dismiss();
                        }).create()
                        .show();
            }
        });

    }

    @Override
    public Context getContext() {
        return this;
    }
}