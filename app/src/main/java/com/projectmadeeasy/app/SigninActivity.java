package com.projectmadeeasy.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.projectmadeeasy.app.utils.Session;
import com.projectmadeeasy.app.utils.Utility;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRegister;
    Context context;
    EditText etUsername;
    EditText etPassword;
    Button btnSignin;

    String userName = "avik";
    String password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        context = this;

        initView();
        navigate();
    }

    private void navigate() {
        if(Session.getisLogged(context)){
            gotoDashboard();
        }
    }

    private void initView() {
        tvRegister = findViewById(R.id.tvRegister);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignin = findViewById(R.id.btnSignin);

        tvRegister.setOnClickListener(this);
        btnSignin.setOnClickListener(this);

        //lambda Expression java 8 feature
       /* btnSignin.setOnClickListener(e->{

        });*/
    }

    @Override
    public void onClick(View v) {
        if (v == tvRegister) {
            Intent i = new Intent(context, RegisterActivity.class);
            startActivity(i);
        } else if (v == btnSignin) {
            validateSigin();
        }
    }

    private void validateSigin() {
        if (etUsername.getText().toString().trim().isEmpty()) {
            Utility.showToast(context, getString(R.string.v_username));
            return;
        }

        if (etPassword.getText().toString().trim().isEmpty()) {
            Utility.showToast(context, getString(R.string.v_password));
            return;
        }

        if (etUsername.getText().toString().trim().equals(userName) && etPassword.getText().toString().trim().equals(password)) {
            Session.setisLogged(context, true);
            Session.set_userName(context, userName);
            gotoDashboard();
            finishAffinity(); //to kill all backstack activities
        } else {
            Utility.showToast(context, getString(R.string.v_credentials));
        }

    }

    private void gotoDashboard() {
        Intent i = new Intent(context, MyProfile.class);
        //i.putExtra("username", userName); // send value to another activity
        startActivity(i);
    }
}
