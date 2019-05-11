package com.example.nssdatas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nssdatas.Models.TaskModel;
import com.example.nssdatas.Models.ThankModel;
import com.example.nssdatas.R;

import java.util.ArrayList;
import java.util.List;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.MyHoder> {

    ArrayList<TaskModel> taskList;
    Context context;

    public TaskRecyclerAdapter(ArrayList<TaskModel> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_item_card,viewGroup,false);//try put for parent
        MyHoder myHoder = new MyHoder(view);

        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder myHoder, int position) {
        TaskModel feedbackList=taskList.get(position);
        myHoder.date.setText(feedbackList.getDate());
        myHoder.task.setText(feedbackList.getTasks());
        myHoder.adder.setText("Added by "+feedbackList.getAdder());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class MyHoder extends RecyclerView.ViewHolder{
        TextView date,task,adder;


        public MyHoder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.task_date);
            task= (TextView) itemView.findViewById(R.id.task_done);
            adder= (TextView) itemView.findViewById(R.id.task_added_by);

        }
    }
}
