package com.projectmadeeasy.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectmadeeasy.app.utils.Session;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyProfile extends AppCompatActivity implements View.OnClickListener {

    //String userName;
    Context context;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        context = this;

        //userName=getIntent().getExtras().getString("username"); // to recieve value sent from anther activity

        initViews();
        redirection();
    }

    private void redirection() {

        if (Session.getisProfile(context)) {
            if (Session.getisLogged(context)) {
                gotoDashboard();
            }
        }
    }

        private void initViews () {
            btnSave = findViewById(R.id.btnSave);

            btnSave.setOnClickListener(this);
        /*//labda expression
        btnSave.setOnClickListener(e -> {

        });*/
        }

        @Override
        public void onClick(View v){
            if (v == btnSave) {
                Session.setisProfile(context, true);
                Intent i = new Intent(context, Dashboard.class);
                startActivity(i);
                finish();
            }
        }


    private void gotoDashboard() {

        Intent i = new Intent(context, Dashboard.class);
        //i.putExtra("username", userName); // send value to another activity
        startActivity(i);
    }
}