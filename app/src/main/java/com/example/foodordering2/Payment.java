package com.example.foodordering2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        textView6 = findViewById(R.id.textView);
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Payment.this,Feedback.class);
        startActivity(intent);
    }
}
