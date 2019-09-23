package com.example.foodordering2.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.Interface.ItemClickListner;
import com.example.foodordering2.R;

public class FoodViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener   {

    public TextView txtProductName, txtProductDescription, txtProductPrice;
   // private Button btn;
    public ImageView imageView;
    public ItemClickListner listner;
    View mView;
   public Button button;


    public FoodViewHolder(View itemView)
    {

        super(itemView);

        button = (Button)itemView.findViewById(R.id.order_btn);

        mView= itemView;


        imageView = (ImageView) itemView.findViewById(R.id.imageView5);
        txtProductName = (TextView) itemView.findViewById(R.id.textView);
        txtProductDescription = (TextView) itemView.findViewById(R.id.description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.price);
       // btn=(Button)itemView.findViewById(R.id.order_btn);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }

}
