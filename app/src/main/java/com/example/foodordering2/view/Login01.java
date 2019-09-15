package com.example.foodordering2.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodordering2.R;

public class
Login01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        Button button = findViewById(R.id.CRaccount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Login01.this, Registration01.class);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.USlog);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Login01.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
