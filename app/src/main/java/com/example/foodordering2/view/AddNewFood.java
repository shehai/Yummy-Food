package com.example.foodordering2.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodordering2.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AddNewFood extends AppCompatActivity {

    private EditText foodName;
    private EditText foodDetails;
    private  EditText foodPrice;
    private ImageView img;
    private Button addFood;
    private  static  final  int imageSelecter = 1;
    private Uri imageUri;
    private  String fName,fDetails,fPrice, saveCdate, saveCTime;
    private  String foodRandomKey, downloadImageUrl;
    private StorageReference FoodImagesRef;
    private DatabaseReference FoodRef;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_food);

        FoodImagesRef = FirebaseStorage.getInstance().getReference().child("Food Images");
        FoodRef=FirebaseDatabase.getInstance().getReference().child("Foods");

        foodName=(EditText)findViewById(R.id.food_name);
        foodDetails=(EditText)findViewById(R.id.food_description);
        foodName=(EditText)findViewById(R.id.food_price);
        img=(ImageView) findViewById(R.id.imageView);
        addFood=(Button)findViewById(R.id.add_food);
        progressBar = new ProgressDialog(this);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();
            }
        });

        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValidateFoodDetails();
            }
        });

    }

    private void selectImage() {

        Intent imageIntent = new Intent();

        imageIntent.setAction(Intent.ACTION_GET_CONTENT);
        imageIntent.setType("image/*");
        startActivityForResult(imageIntent, imageSelecter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==imageSelecter && requestCode==RESULT_OK && data!=null){

            imageUri = data.getData();

            img.setImageURI(imageUri);


        }
    }

    private  void  ValidateFoodDetails(){

        fName = foodName.getText().toString();
        fDetails = foodDetails.getText().toString();
        fPrice = foodPrice.getText().toString();

        if (imageUri==null){

            Toast.makeText(AddNewFood.this,"Food Image Field is Mandatory",Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(fName)){

            Toast.makeText(AddNewFood.this,"Please Enter Food Name",Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(fDetails)){

            Toast.makeText(AddNewFood.this,"Please Enter Food Details",Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(fPrice)){

            Toast.makeText(AddNewFood.this,"Please Enter Food Price",Toast.LENGTH_LONG).show();
        }

        else
        {
            storeFoodDetails();
        }

    }

    private void storeFoodDetails() {

        progressBar.setTitle("Login Account");
        progressBar.setMessage("Please wait, while we are checking the credentials.");
        progressBar.setCanceledOnTouchOutside(false);
        progressBar.show();

        Calendar calender = Calendar.getInstance();

        SimpleDateFormat currentDate= new SimpleDateFormat("MMM dd, YYY");

        saveCdate= currentDate.format(calender.getTime());

        SimpleDateFormat currentTime= new SimpleDateFormat("HH:mm:ss a");

        saveCTime= currentTime.format(calender.getTime());

        foodRandomKey = saveCdate + saveCTime;

        final StorageReference filePath = FoodImagesRef.child(imageUri.getLastPathSegment()+ foodRandomKey +".jpg");

        final UploadTask uploadTask = filePath.putFile(imageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String message = e.toString();

                Toast.makeText(AddNewFood.this,"Error Occur:"+message,Toast.LENGTH_LONG).show();

                progressBar.dismiss();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(AddNewFood.this," Tmage Successfully Uploaded",Toast.LENGTH_LONG).show();

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                        if (!task.isSuccessful()){

                            throw task.getException();
                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();

                        return  filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {

                        if (task.isSuccessful()){

                            downloadImageUrl =task.getResult().toString();

                        Toast.makeText(AddNewFood.this,"Successfully Image Save to database",Toast.LENGTH_LONG).show();

                        SaveFoodDetailsTodatabase();}

                    }
                });
            }
        });
    }

    private void SaveFoodDetailsTodatabase() {

        HashMap<String,Object> foodMap= new HashMap<>();

        foodMap.put("pid",foodRandomKey);
        foodMap.put("date",saveCdate);
        foodMap.put("time",saveCTime);
        foodMap.put("pname",fName);
        foodMap.put("pdescription",fDetails);
        foodMap.put("price",fPrice);
        foodMap.put("image",downloadImageUrl);

        FoodRef.child(foodRandomKey).updateChildren(foodMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){

                    Intent intent= new Intent(AddNewFood.this,AdminManageActivity.class);
                    startActivity(intent);

                    progressBar.dismiss();

                    Toast.makeText(AddNewFood.this,"Food Details Added Successfully",Toast.LENGTH_LONG).show();
                }
                else {

                    progressBar.dismiss();

                    String  message = task.getException().toString();

                    Toast.makeText(AddNewFood.this,"Error:"+ message,Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
