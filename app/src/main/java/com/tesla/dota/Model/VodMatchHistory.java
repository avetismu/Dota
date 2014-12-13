package com.tesla.dota.Model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * uses the iterator and singleton design patterns
 * TODO: Add History Storage
 */
public class VodMatchHistory implements Iterable<VodMatch> {

    /* Fields */
    //holds instance of VodMatchHistory
    private static volatile VodMatchHistory instance;

    //ArrayList of LIST_SIZE latest vodmqtches, latest first
    private ArrayList<VodMatch> mVodMatches;

    //Maximum Number of items in mVodMatches
    private final static int LIST_SIZE = 30;

    //current Context
    private static Context mContext;


    /* Instantiation */

    public VodMatchHistory(){
        mVodMatches = new ArrayList<VodMatch>();
    }

    public static VodMatchHistory getInstance(Context context){
        mContext = context;
        if(instance == null){
            instance = new VodMatchHistory();
        }

        return new VodMatchHistory();
    }


    public ArrayList<VodMatch> getFiveLatestVods(){
        ArrayList<VodMatch> temp = new ArrayList<VodMatch>();

        //determines num of elements over which to iterate
        //if mVodMatches has less than 5 elements, iterate over its length
        int iterationLength = 5;
        if(iterationLength>mVodMatches.size())
            iterationLength = mVodMatches.size();

        for(int i=0; i<iterationLength; i++){
            temp.add(mVodMatches.get(i));
        }

        return temp;
    }

    /**
     * MOCK METHOD
     * TODO: REMOVE AFTER DEBUGGING
     */
    public ArrayList<String> getFiveLatestVodsName(){
        ArrayList<String> temp = new ArrayList<String>();

        //determines num of elements over which to iterate
        //if mVodMatches has less than 5 elements, iterate over its length
        int iterationLength = 5;
        if(iterationLength>mVodMatches.size())
            iterationLength = mVodMatches.size();

        for(int i=0; i<iterationLength; i++){
            temp.add(mVodMatches.get(i).getTeam1() + " vs " + mVodMatches.get(i).getTeam2());
        }

        return temp;
    }


    /* Iterable Methods*/

    /**
     * adds VodMatch to mVodMatches ArrayList at index 0
     * limit size of mVodMatches to LIST_SIZE
     *
     * @param vm VodMatch object to be added
     */
    public void addVodMatch(VodMatch vm){

        //adds VodMatch Object to mVodMatches
        if(!mVodMatches.contains(vm))
            mVodMatches.add(0, vm);

        //trim mVodMatches to a size of 30
        trimList();

    }
    @Override
    public Iterator<VodMatch> iterator() {
        return mVodMatches.iterator();
    }


    /* Helper Methods */

    /**
     * Trim mVodMatches to maximum size specified by LIST_SIZE
     */
    public void trimList(){
        int currentListSize= mVodMatches.size();
        for(int i = LIST_SIZE-1; i<currentListSize; i++){
            mVodMatches.remove(i);
        }
    }




}
