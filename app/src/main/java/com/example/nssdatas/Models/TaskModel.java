package com.example.nssdatas.Models;

public class TaskModel {

    String date;
    String adder;
    String tasks;

    public TaskModel(){}

    public String getAdder() {
        return adder;
    }

    public String getDate() {
        return date;
    }

    public String getTasks() {
        return tasks;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}
