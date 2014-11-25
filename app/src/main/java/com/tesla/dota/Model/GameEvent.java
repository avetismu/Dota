package com.tesla.dota.Model;

import android.text.format.Time;

public class GameEvent {

    /* Fields */
    private int ID;
    //int[0-2] least to most important
    private int Priority;
    private String Update;
    private Time Time;

    /* Constructor */
    public GameEvent(int ID, int Priority, String Update){
        this.ID = ID;
        this.Priority = Priority;
        this.Update = Update;
        this.Time = new Time();
        Time.setToNow();
    }

    /* Mutator and Accessor Methods */
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public String getUpdate() {
        return Update;
    }

    public void setUpdate(String Update) {
        this.Update = Update;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

}