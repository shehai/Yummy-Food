package com.example.foodordering2.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodordering2.R;

public class OrderDetails extends AppCompatActivity {

    private EditText txt1;
    private  EditText txt2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

       /*//get value from the intent
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String userName = bundle.getString("name");
        String foodPrice = bundle.getString("price");

        */

        //Setting the name to text vie
        txt1 =(EditText) findViewById(R.id.editText10);
        txt1 =(EditText) findViewById(R.id.editText11);

        // txt1.setText( userName);
        //txt2.setText(foodPrice);
        btn = (Button) findViewById(R.id.btn_purchase);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String s = txt1.getText().toString();
                String p = txt2.getText().toString();

                 intent1.putExtra("name",s);
                intent1.putExtra("price",p);*/

                Intent intent1 = new Intent(OrderDetails.this, Payment.class);


                startActivity(intent1);
            }
        });





    }
}
