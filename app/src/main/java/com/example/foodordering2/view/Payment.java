package com.example.foodordering2.view;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodordering2.R;
import com.example.foodordering2.model.UserPayment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Payment extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    Button btn2;
    Button btn;
    Button button1;

    DatabaseReference DBref;
    UserPayment pmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText6);
        editText3 = findViewById(R.id.editText2);
        editText4 = findViewById(R.id.editText5);
        editText5 = findViewById(R.id.editText3);
        pmt = new UserPayment();

        btn = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);





        //editText.setText(message);
        //editText1.setText(message1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBref = FirebaseDatabase.getInstance().getReference().child("UserPayment");

                pmt.setName(editText1.getText().toString().trim());
                pmt.setPrice(editText2.getText().toString().trim());
                pmt.setFoodNo(editText3.getText().toString().trim());
                pmt.setContactNo(editText4.getText().toString().trim());
                pmt.setPaymentMtehod(editText5.getText().toString().trim());

                DBref.push().setValue(pmt);
               // DBref.child("IT18147988").setValue(pmt);

                Toast.makeText(getApplicationContext(),"Thanks for your payment",Toast.LENGTH_LONG).show();
            }
        });

       button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBref = FirebaseDatabase.getInstance().getReference().child("Student");

                DBref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("IT18023824")){
                            pmt.setName(editText1.getText().toString().trim());
                            pmt.setPrice(editText2.getText().toString().trim());
                            pmt.setFoodNo(editText3.getText().toString().trim());
                            pmt.setContactNo(editText4.getText().toString().trim());
                            pmt.setPaymentMtehod(editText5.getText().toString().trim());

//                            dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("IT18147988");
                            DBref = DBref.child("IT18147988");
                            DBref.setValue(pmt);
                            Toast.makeText(getApplicationContext(),"Update Success",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public void startnewActivity(View view){
        Intent intent = new Intent(Payment.this, Feedback.class);
        startActivity(intent);
    }

}
