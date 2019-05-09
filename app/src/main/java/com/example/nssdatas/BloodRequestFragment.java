package com.example.nssdatas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nssdatas.Adapter.BloodRecyclerAdapter;
import com.example.nssdatas.Models.BloodModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class BloodRequestFragment extends Fragment {

    RecyclerView recycle;

    public BloodRequestFragment() {
        // Required empty public constructor
    }

    ArrayList<BloodModel> bloodList= new ArrayList<BloodModel>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_blood_request,container,false);
        recycle = (RecyclerView) rootView.findViewById(R.id.blood_request_recycle_view);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadDatas();
    }

    private void loadDatas() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference thankRef = database.getReference("requestBlood");

        thankRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshots) {
                ArrayList<BloodModel> array=new ArrayList<BloodModel>();
                for(DataSnapshot dataSnapshot:dataSnapshots.getChildren()){
                    BloodModel toAdd=new BloodModel();
                    BloodModel value=dataSnapshot.getValue(BloodModel.class);

                    toAdd.setEmail(value.getEmail());
                    toAdd.setName(value.getName());
                    toAdd.setPhone(value.getPhone());
                    toAdd.setAddress(value.getAddress());
                    toAdd.setBlood_for_whom(value.getBlood_for_whom());
                    toAdd.setId_roll(value.getId_roll());
                    array.add(toAdd);
                }
                Log.d("GettingDatas",Integer.toString(array.size()));

                BloodRecyclerAdapter recyclerAdapter=new BloodRecyclerAdapter(array,getContext());
                RecyclerView.LayoutManager recyce=new LinearLayoutManager(getContext());
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator( new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
