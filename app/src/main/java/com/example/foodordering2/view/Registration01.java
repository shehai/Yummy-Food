package com.example.foodordering2.view;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foodordering2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Registration01 extends AppCompatActivity {


    private EditText userName;
    private EditText useEmail;
    private EditText userPwd;
    private  EditText userPhone;
    private Button button;
    private ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration01);
        userName= (EditText)findViewById(R.id.UName);
         useEmail= (EditText) findViewById(R.id.UEmail);
         userPwd= (EditText) findViewById(R.id.UPword);
         userPhone=(EditText)findViewById(R.id.UPhone);
        button = (Button) findViewById(R.id.UFin);
        progressBar= new ProgressDialog(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateUser();


            }
        });
    }

    private void CreateUser() {
         String name= userName.getText().toString();
         String email= useEmail.getText().toString();
         String pwd= userPwd.getText().toString();
         String phone=userPhone.getText().toString();

        if(TextUtils.isEmpty(name)){

            Toast.makeText(this,"Please Enter your name",Toast.LENGTH_LONG).show();
        }

       else if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Please Enter your email",Toast.LENGTH_LONG).show();
       }

        else if(TextUtils.isEmpty(pwd)){

            Toast.makeText(this,"Please Enter your  password",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(phone)){

            Toast.makeText(this,"Please Enter your  phone number",Toast.LENGTH_LONG).show();
        }

        else {

           progressBar.setTitle("Create Account");
            progressBar.setMessage("Please wait checking the data");
            progressBar.setCanceledOnTouchOutside(false);
            progressBar.show();
            
           ValidateEmail(name,email,pwd,phone);
        }

    }

    private void ValidateEmail(final String name, final String email, final String pwd, final String phone) {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (!(dataSnapshot.child("Users").child(phone).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone", phone);
                    userdataMap.put("email", email);
                    userdataMap.put("pwd",pwd);
                    userdataMap.put("name",name);

                    RootRef.child("Users").child(phone).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(Registration01.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();
                                        progressBar.dismiss();

                                        Intent intent = new Intent(Registration01.this, Login01.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        progressBar.dismiss();
                                        Toast.makeText(Registration01.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                {
                    Toast.makeText(Registration01.this, "This " + phone + " already exists.", Toast.LENGTH_SHORT).show();
                    progressBar.dismiss();
                    Toast.makeText(Registration01.this, "Please try again using another phone number.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Registration01.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
