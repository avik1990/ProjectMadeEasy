package com.projectmadeeasy.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    Context context;
    LinearLayout llBox1, llBox2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        context = this;


        initViews();
    }

    private void initViews() {
        llBox1 = findViewById(R.id.llBox1);
        llBox2 = findViewById(R.id.llBox2);

        llBox1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == llBox1) {
            Intent i = new Intent(context, AddAssignments.class);
            startActivity(i);
        }
    }
}
