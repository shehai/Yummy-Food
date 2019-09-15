package com.example.foodordering2.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering2.R;

public class Feedback extends AppCompatActivity {

    TextView textView11;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        textView11 = findViewById(R.id.textView);

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Thanks for your Feedback",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Feedback.this, MainActivity.class);
        startActivity(intent);
    }

}
