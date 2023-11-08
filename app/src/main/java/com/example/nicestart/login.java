package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openMain(View v) {
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    }

    public void openSignup(View v) {
        Intent intent = new Intent(login.this, register.class);
        startActivity(intent);
    }
}