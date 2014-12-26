package com.tesla.dota.Model;

import android.text.format.Time;

public class GameEvent {

    /* Fields */
    private int mId;
    //int[0-2] least to most important
    private int mPriority;
    private String mUpdate;
    private Time mTime;

    /* Constructor */

    /**
     * @param id unique integer stored on server
     * @param priority low, medium, high [0-2]
     * @param update String message written by caster
     */
    public GameEvent(int id, int priority, String update){
        this.mId = id;
        this.mPriority = priority;
        this.mUpdate = update;
        this.mTime = new Time();
        mTime.setToNow();
    }

    /* Mutator and Accessor Methods */
    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public String getUpdate() {
        return mUpdate;
    }

    public void setUpdate(String Update) {
        this.mUpdate = Update;
    }

    public Time getTime() {
        return mTime;
    }

    public void setTime(Time time) {
        this.mTime = time;
    }

}