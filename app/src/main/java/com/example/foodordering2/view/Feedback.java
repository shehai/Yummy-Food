package com.example.foodordering2.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering2.R;
import com.example.foodordering2.model.SubmitFeedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    EditText editText1;
    Button btn1;



    DatabaseReference DBref;
    SubmitFeedback fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editText1 = findViewById(R.id.editText8);
        fb = new SubmitFeedback();

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBref = FirebaseDatabase.getInstance().getReference().child("SubmitFeedback");
                fb.setFeedback(editText1.getText().toString().trim());

                DBref.push().setValue(fb);



                Toast.makeText(getApplicationContext(),"Thanks for your Feedback",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Feedback.this, MainActivity.class);
        startActivity(intent);
    }

}
