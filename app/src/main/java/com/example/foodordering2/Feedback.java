package com.example.foodordering2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Feedback extends AppCompatActivity {

    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        textView11 = findViewById(R.id.textView);
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Feedback.this,MainActivity.class);
        startActivity(intent);
    }

}
