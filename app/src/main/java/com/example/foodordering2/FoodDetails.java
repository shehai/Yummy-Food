package com.example.foodordering2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FoodDetails extends AppCompatActivity {

    private TextView tx1;
    private  TextView tx2;
    private  TextView tx3;
    private  TextView tx4;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        tx1 = (TextView) findViewById(R.id.food_name);
        tx2= (TextView) findViewById(R.id.txt1);
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = tx1.getText().toString();
                String p = tx2.getText().toString();

                Intent i = new Intent(FoodDetails.this,OrderDetails.class);

                i.putExtra("name",s);
                i.putExtra("price",p);

                startActivity(i);


            }
        });

    }
}
