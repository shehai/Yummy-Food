package com.example.foodordering2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {




        private TextView LOGIN;
        private EditText Username;
        private EditText Password;
        private Button CONTINUE;
        private TextView Info;
        private Button CREATEACCOUNT;
        private int counter = 5;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);


            /*LOGIN = (TextView)findViewById(R.id.ULogin);
            Username = (EditText)findViewById(R.id.USname);
            Password = (EditText) findViewById(R.id.USPword);
            CONTINUE = (Button) findViewById(R.id.USlog);
            Info = (TextView)findViewById(R.id.Info);
            CREATEACCOUNT = (Button) findViewById(R.id.CRaccount);

            Info.setText("No of attempts remaining:5");*/


            /*CONTINUE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate(Username.getText().toString(),Password.getText().toString());
                }
            });*/

            CREATEACCOUNT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent =new Intent(login.this, Registration.class);

                    startActivity(intent);
                }
            });

        }

       /* private void validate (String name,String userPassword){
            if((name == "Admin") && (userPassword == "1234")){
                Intent intent = new Intent(login.this,Registration.class);
                startActivity(intent);
            }else{
                counter--;

                Info.setText("No of attempts remaining: " + String.valueOf(counter));

                if(counter == 0){
                    CONTINUE.setEnabled(false);
                }
            }
        }*/


    }
