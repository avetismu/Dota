package com.tesla.dota.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tesla.dota.Adapter.EventAdapter;
import com.tesla.dota.Model.GameEvent;
import com.tesla.dota.Model.Match;
import com.tesla.dota.R;

import java.util.ArrayList;

public class LiveGameFragment extends Fragment {

    /* Fields */

    //Holds all game updates
    private ArrayList<GameEvent> mGameEvents = new ArrayList<GameEvent>();
    //Holds low priority game updates
    private ArrayList<GameEvent> mLowPriorityEvents = new ArrayList<GameEvent>();
    //Holds medium priority game updates
    private ArrayList<GameEvent> mMediumPriorityEvents = new ArrayList<GameEvent>();
    //Holds high priority game updates
    private ArrayList<GameEvent> mHighPriorityEvents = new ArrayList<GameEvent>();
    //Current Match
    private static Match mMatch;
    //Tournament Type
    private static String mTournament;
    //GameEvent ListView
    private ListView mUpdateList;
    //GameEvent Adapter
    private EventAdapter mAdapter;


    /* Constructors and Instances */

    public static LiveGameFragment newInstance(Match currentMatch, String tournament) {
        LiveGameFragment fragment = new LiveGameFragment();
        mMatch = currentMatch;
        mTournament = tournament;
        return fragment;

    }
    public LiveGameFragment() {
        // Required empty public constructor
    }


    /* Fragment States */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //calls superclass method
        super.onCreate(savedInstanceState);


        //allows Fragment to add items to Action Bar
        setHasOptionsMenu(true);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //calls superclass method
        super.onActivityCreated(savedInstanceState);

        //sets Activity Title
        //TODO:Fix Title
        getActivity().setTitle(mMatch.getTeam1() + " vs. " + mMatch.getTeam2());

        //initialises Feed title TextView
        TextView feedTitle = (TextView) getActivity().findViewById(R.id.feed_title);
        //sets Feed Title
        feedTitle.setText("Updates - " + mTournament);

        //adds GameEvent to mGameEvents for demo
        addEvent(0, 0, getActivity().getResources().getString(R.string.lorem_ipsum));

        //adds GameEvent for demo
        addEvent(1, 1, getActivity().getResources().getString(R.string.lorem_ipsum));

        //adds GameEvent for demo
        addEvent(2, 2, getActivity().getResources().getString(R.string.lorem_ipsum));

        //Setup priority lists
        fillPriorityLists();

        //initialises ListView
        mUpdateList = (ListView) getActivity().findViewById(R.id.updateList);

        //initialises Custom Adapter EventAdapter
        mAdapter = new EventAdapter(getActivity().getBaseContext(), mGameEvents);

        //sets ListView Adapter
        mUpdateList.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_game, container, false);

    }


    /* Fragment Methods */

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /* Helper Methods */

    //Adds GameEvent Object to Arraylist() mGameEvents
    public void addEvent(int ID, int Priority, String Update){
        GameEvent update = new GameEvent(ID, Priority, Update);
        mGameEvents.add(update);
    }


    /* Menu */

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        //inflates Menu
        inflater.inflate(R.menu.fragment_live_game, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            //Highest Priority First
            case (R.id.list_by_priority_High):
                //HELPER METHOD
                listByPriorityHigh();
                //reinitialises adapter with new GameEvent values
                mAdapter = new EventAdapter(getActivity().getBaseContext(), mGameEvents);
                //sets ListView Adapter
                mUpdateList.setAdapter(mAdapter);
                break;

            //Lowest Priority First
            case (R.id.list_by_priority_Low):
                //HELPER METHOD
                listByPriorityLow();
                //reinitialises adapter with new GameEvent values
                mAdapter = new EventAdapter(this.getActivity().getBaseContext(), mGameEvents);
                //sets ListView Adapter
                mUpdateList.setAdapter(mAdapter);
                break;

            //Newest First
            case (R.id.newest):
                //HELPER METHOD
                listByTimeNewest();
                //reinitialises adapter with new GameEvent values
                mAdapter = new EventAdapter(this.getActivity().getBaseContext(), mGameEvents);
                //sets ListView Adapter
                mUpdateList.setAdapter(mAdapter);
                break;

            //Oldest First
            case (R.id.oldest):
                //HELPER METHOD
                listByTimeOldest();
                //reinitialises adapter with new GameEvent values
                mAdapter = new EventAdapter(this.getActivity().getBaseContext(), mGameEvents);
                //sets ListView Adapter
                mUpdateList.setAdapter(mAdapter);
        }

        return true;
    }

    /* Options Menu Methods */

    //Classifies object by priority, highest first
    public void listByPriorityHigh(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(mHighPriorityEvents);
        priorityList.addAll(mMediumPriorityEvents);
        priorityList.addAll(mLowPriorityEvents);

        //mGameEvents sorted by priority
        mGameEvents =  priorityList;
    }


    //Classifies object by priority, highest first
    public void listByPriorityLow(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(mLowPriorityEvents);
        priorityList.addAll(mMediumPriorityEvents);
        priorityList.addAll(mHighPriorityEvents);

        //mGameEvents sorted by priority
        mGameEvents = priorityList;
    }

    //sorts all events from Newest to Oldest
    public void listByTimeNewest(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(mHighPriorityEvents);
        priorityList.addAll(mMediumPriorityEvents);
        priorityList.addAll(mLowPriorityEvents);

        //sort priorityList by time, Newest to oldest
        sortByTime(priorityList);

        //mGameEvents sorted by priority
        mGameEvents = priorityList;
    }

    //sorts all events from Oldest to Newest
    public void listByTimeOldest(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //initialises empty ArrayList which will temporarily contain the reversed PriorityList
        ArrayList<GameEvent> tempList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(mHighPriorityEvents);
        priorityList.addAll(mMediumPriorityEvents);
        priorityList.addAll(mLowPriorityEvents);

        //sort priorityList by time, Newest to oldest
        sortByTime(priorityList);

        //reverse priorityList;
        for(int i = priorityList.size()-1; i>=0; i--){

            //add last element of priorityList to first element of tempList
            tempList.add(priorityList.get(i));

        }

        //assign tempList to priorityList
        priorityList = tempList;

        //mGameEvents sorted by priority
        mGameEvents = priorityList;
    }

    //sorts objects in parameter list by time, with newest first
    public void sortByTime(ArrayList<GameEvent> Updates){
        for(int i = 1; i<Updates.size()-1; i++){
            //maximum time value of GameEvent object
            Time newest = Updates.get(i).getTime();
            //index of newest GameEvent
            int Index = i;

            for(int j=i+1; j<Updates.size(); j++){
                if(Time.compare(newest, Updates.get(j).getTime()) < 0){
                    //finds minimum priority
                    newest = Updates.get(j).getTime();
                    Index = j;
                }
            }

            if(Index != i){
                Updates.add(i, Updates.remove(Index));
            }
        }

    }


		/* Mutators */

    //add values to priority lists and sort them according to time
    public void fillPriorityLists() {
        //clear all items in current priority list
        mLowPriorityEvents.clear();
        mMediumPriorityEvents.clear();
        mHighPriorityEvents.clear();

        //fill priority lists with corresponding elements from mGameEvents ArrayList
        for (int i = 0; i < mGameEvents.size(); i++) {
            //fetches game event at index i
            GameEvent currentGE = mGameEvents.get(i);

            //checks value of GameEvent priority then adds it to appropriate priority lsit
            switch (currentGE.getPriority()) {
                //priority == 0
                case 0:
                    mLowPriorityEvents.add(currentGE);
                    break;
                //priority == 1
                case 1:
                    mMediumPriorityEvents.add(currentGE);
                    break;
                //priority == 2
                case 2:
                    mHighPriorityEvents.add(currentGE);
                    break;
            }
        }

        //rearrange all lists by time
        sortByTime(mLowPriorityEvents);
        sortByTime(mMediumPriorityEvents);
        sortByTime(mHighPriorityEvents);
    }

}
