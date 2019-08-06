package com.example.foodordering2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {


    private EditText name, userEmail, userPassword, userPasswordAgain;
    private Button finButton;
    private TextView registration;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViewes();


        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    //**upload data to the data base**
                }
            }
        });


    }


    private void setupUIViewes() {
        registration = (TextView) findViewById(R.id.UReg);
        name = (EditText) findViewById(R.id.UName);
        userEmail = (EditText) findViewById(R.id.UEmail);
        userPassword = (EditText) findViewById(R.id.UPword);
        userPasswordAgain = (EditText) findViewById(R.id.UPWagain);
        finButton = (Button) findViewById(R.id.UFin);
        login = (Button) findViewById(R.id.Uals);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Registration.this, login.class);

                startActivity(intent);
            }
        });





    }

    private Boolean validate() {
        Boolean result = false;

        String Username = name.getText().toString();
        String Email = userEmail.getText().toString();
        String Password = userPassword.getText().toString();
        String Passwordagain = userPasswordAgain.getText().toString();

        if (Username.isEmpty() && Email.isEmpty() && Password.isEmpty() && Passwordagain.isEmpty()) {

            Toast.makeText(this, "Please enter all the details: ", Toast.LENGTH_SHORT).show();

        } else {
            result = true;
        }

        return true;


    }
}