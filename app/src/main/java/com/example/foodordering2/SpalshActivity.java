package com.example.foodordering2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        //Removing Action Bar

        getSupportActionBar().hide();

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SpalshActivity.this,MainActivity.class);

                startActivity(intent);

                finish();
            }
        }, 3000);
    }
}
