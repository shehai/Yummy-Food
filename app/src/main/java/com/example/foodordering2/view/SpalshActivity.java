package com.example.foodordering2.view;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.foodordering2.R;

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

                Intent intent = new Intent(SpalshActivity.this, Login01.class);

                startActivity(intent);

            }
        }, 1000);
    }
}
