package com.example.nssdatas;

import android.content.Context;
import android.net.Uri;
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

import com.example.nssdatas.Adapter.ThankRecyclerAdapter;
import com.example.nssdatas.Models.ThankModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThankFragment extends Fragment {

    RecyclerView recycle;

    public ThankFragment() {
        // Required empty public constructor
    }

    ArrayList<ThankModel> thankList= new ArrayList<ThankModel>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_thank,container,false);
        recycle = (RecyclerView) rootView.findViewById(R.id.thank_recycle_view);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadDatas();
     //   showDatas();
    }

    private void showDatas() {

        Log.d("GettingDatas",Integer.toString(thankList.size()));
    }

    private void loadDatas() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference thankRef = database.getReference("ThankFeedback");

        thankRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshots) {
                ArrayList<ThankModel> array=new ArrayList<ThankModel>();
                for(DataSnapshot dataSnapshot:dataSnapshots.getChildren()){
                    ThankModel toAdd=new ThankModel();
                    ThankModel value=dataSnapshot.getValue(ThankModel.class);

                    toAdd.setEmail(value.getEmail());
                    toAdd.setName(value.getName());
                    toAdd.setPhone(value.getPhone());
                    toAdd.setThought(value.getThought());
                    array.add(toAdd);
                }

                Collections.reverse(array);
                Log.d("GettingDatas",Integer.toString(array.size()));

                ThankRecyclerAdapter recyclerAdapter=new ThankRecyclerAdapter(array,getContext());
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
