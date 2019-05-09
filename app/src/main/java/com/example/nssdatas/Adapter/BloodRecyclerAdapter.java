package com.example.nssdatas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nssdatas.Models.BloodModel;
import com.example.nssdatas.Models.ThankModel;
import com.example.nssdatas.R;

import java.util.ArrayList;

public class BloodRecyclerAdapter extends RecyclerView.Adapter<BloodRecyclerAdapter.MyHoder> {

    ArrayList<BloodModel> bloodList;
    Context context;

    public BloodRecyclerAdapter(ArrayList<BloodModel> bloodList, Context context) {
        this.bloodList = bloodList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.blood_item_card, viewGroup, false);//try put for parent
        MyHoder myHoder = new MyHoder(view);

        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder myHoder, int position) {
        BloodModel feedbackList = bloodList.get(position);
        myHoder.name.setText(feedbackList.getName());
        myHoder.email.setText(feedbackList.getEmail());
        myHoder.phone.setText(feedbackList.getPhone());
        myHoder.address.setText(feedbackList.getAddress());
        myHoder.blood_for_whom.setText(feedbackList.getBlood_for_whom());
        myHoder.id_roll.setText(feedbackList.getId_roll());

    }

    @Override
    public int getItemCount() {
        return bloodList.size();
    }

    class MyHoder extends RecyclerView.ViewHolder {
        TextView name, email, phone, address, blood_for_whom, id_roll;


        public MyHoder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            phone = (TextView) itemView.findViewById(R.id.phone);
            address = (TextView) itemView.findViewById(R.id.address);
            blood_for_whom = (TextView) itemView.findViewById(R.id.blood_for_whom);
            id_roll=(TextView) itemView.findViewById(R.id.id_roll);

        }
    }
}
