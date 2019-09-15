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

public class Payment extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    TextView textView8;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        textView8 = findViewById(R.id.textView);

        btn = findViewById(R.id.button2);

       /* Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = bundle.getString("name");
        String message1 = bundle.getString("price");*/

        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText) findViewById(R.id.editText6);

        //editText.setText(message);
        //editText1.setText(message1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Thanks for your payment",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Payment.this, Feedback.class);
        startActivity(intent);
    }

}
