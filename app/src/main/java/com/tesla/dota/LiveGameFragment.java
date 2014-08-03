package com.tesla.dota;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LiveGameFragment extends Fragment {

    /* Fields */

    //Holds all game updates
    private ArrayList<GameEvent> GameEvents = new ArrayList<GameEvent>();
    //Holds low priority game updates
    private ArrayList<GameEvent> lowPriorityEvents = new ArrayList<GameEvent>();
    //Holds medium priority game updates
    private ArrayList<GameEvent> mediumPriorityEvents = new ArrayList<GameEvent>();
    //Holds high priority game updates
    private ArrayList<GameEvent> highPriorityEvents = new ArrayList<GameEvent>();
    //Team Names
    private String Team1 = "Default Team";
    private String Team2 = "Random Team";
    //Tournament Type
    private String Tournament = "Tourn. Type";
    //GameEvent ListView
    private ListView updateList;
    //GameEvent Adapter
    private EventAdapter adapter;

    //Interface declared
    //What is the purpose of this?
    private OnFragmentInteractionListener mListener;


    /* Constructors and Instances */

    public static LiveGameFragment newInstance() {

        LiveGameFragment fragment = new LiveGameFragment();
        return fragment;

    }
    public LiveGameFragment() {
        // Required empty public constructor
    }


    /* Fragment States */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //allows Fragment to add items to Action Bar
        setHasOptionsMenu(true);
/*
        //sets Activity Title
        getActivity().setTitle(Team1 + " vs. " + Team2);

        //initialises Feed title TextView
        final TextView feedTitle = (TextView) getActivity().findViewById(R.id.feed_title);
        //sets Feed Title
        feedTitle.setText("Updates - " + Tournament);

        //adds GameEvent to GameEvents for demo
        addEvent(0, 0, "She should have died hereafter." + "\n" +
                "There would have been a time for such a word." + "\n" +
                "Tomorrow, and tomorrow, and tomorrow" + "\n" +
                "Creeps in this petty pace from day to day" + "\n" +
                "To the last syllable of recorded time." + "\n" +
                "And all our yesterdays have lighted fools" + "\n" +
                "The way to dusty death. Out, out, brief candle." + "\n" +
                "Life’s but a walking shadow, a poor player" + "\n" +
                "That struts and frets his hour upon the stage," + "\n" +
                "And then is heard no more. It is a tale" + "\n" +
                "Told by an idiot, full of sound and fury," + "\n" +
                "Signifying nothing." + "\n" +
                " - Shakespeare, Macbeth");

        //adds GameEvent for demo
        addEvent(1, 1, "I sung of Chaos and Eternal Night," + "\n" +
                "Taught by the heav'nly Muse to venture down" + "\n" +
                "The dark descent, and up to reascend... " + "\n" +
                " - Milton, Paradise Lost");

        //adds GameEvent for demo
        addEvent(2, 2, "Love will find a way through paths where wolves fear to prey." + "\n" +
                "- Lord Gordon Byron");

        //Setup priority lists
        fillPriorityArrayLists();

        //initialises ListView
        updateList = (ListView) getActivity().findViewById(R.id.updateList);

        //initialises Custom Adapter EventAdapter
        adapter = new EventAdapter(getActivity().getBaseContext(), GameEvents);

        //sets ListView Adapter
        updateList.setAdapter(adapter);

        */

    }

    /* Fragment Methods */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_game, container, false);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /* Helper Methods */

    //Adds GameEvent Object to Arraylist() GameEvents
    public void addEvent(int ID, int Priority, String Update){
        GameEvent update = new GameEvent(ID, Priority, Update);
        GameEvents.add(update);
    }


    /* Menu */

    public boolean onCreateOptionsMenu(Menu menu) {

        //inflates Menu
        getActivity().getMenuInflater().inflate(R.menu.fragment_live_game, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
/*
        switch(item.getItemId()){

            //Highest Priority First
            case (R.id.list_by_priority_High):
                //HELPER METHOD
                GameEvents = listByPriorityHigh();
                //reinitialises adapter with new GameEvent values
                adapter = new EventAdapter(this.getActivity(), GameEvents);
                //sets ListView Adapter
                updateList.setAdapter(adapter);
                break;

            //Lowest Priority First
            case (R.id.list_by_priority_Low):
                //HELPER METHOD
                GameEvents = listByPriorityLow();
                //reinitialises adapter with new GameEvent values
                adapter = new EventAdapter(this.getActivity().getBaseContext(), GameEvents);
                //sets ListView Adapter
                updateList.setAdapter(adapter);
                break;

            //Newest First
            case (R.id.newest):
                //HELPER METHOD
                GameEvents = listByTimeNewest();
                //reinitialises adapter with new GameEvent values
                adapter = new EventAdapter(this.getActivity().getBaseContext(), GameEvents);
                //sets ListView Adapter
                updateList.setAdapter(adapter);
                break;

            //Oldest First
            case (R.id.oldest):
                //HELPER METHOD
                GameEvents = listByTimeOldest();
                //reinitialises adapter with new GameEvent values
                adapter = new EventAdapter(this.getActivity().getBaseContext(), GameEvents);
                //sets ListView Adapter
                updateList.setAdapter(adapter);
        }
*/
        return true;
    }

    /* Options Menu Methods */

    //Classifies object by priority, highest first
    public ArrayList<GameEvent> listByPriorityHigh(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(highPriorityEvents);
        priorityList.addAll(mediumPriorityEvents);
        priorityList.addAll(lowPriorityEvents);

        //returns ArrayList sorted by priority
        return priorityList;
    }


    //Classifies object by priority, highest first
    public ArrayList<GameEvent> listByPriorityLow(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(lowPriorityEvents);
        priorityList.addAll(mediumPriorityEvents);
        priorityList.addAll(highPriorityEvents);

        //returns ArrayList sorted by priority
        return priorityList;
    }

    //sorts all events from Newest to Oldest
    public ArrayList<GameEvent> listByTimeNewest(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(highPriorityEvents);
        priorityList.addAll(mediumPriorityEvents);
        priorityList.addAll(lowPriorityEvents);

        //sort priorityList by time, Newest to oldest
        sortByTime(priorityList);

        //returns ArrayList sorted by priority
        return priorityList;
    }

    //sorts all events from Oldest to Newest
    public ArrayList<GameEvent> listByTimeOldest(){

        //declares priorityList to be returned
        ArrayList<GameEvent> priorityList = new ArrayList<GameEvent>();

        //initialises empty ArrayList which will temporarily contain the reversed PriorityList
        ArrayList<GameEvent> tempList = new ArrayList<GameEvent>();

        //Append all priority lists, highest to lowest
        priorityList.addAll(highPriorityEvents);
        priorityList.addAll(mediumPriorityEvents);
        priorityList.addAll(lowPriorityEvents);

        //sort priorityList by time, Newest to oldest
        sortByTime(priorityList);

        //reverse priorityList;
        for(int i = priorityList.size()-1; i>=0; i--){

            //add last element of priorityList to first element of tempList
            tempList.add(priorityList.get(i));

        }

        //assign tempList to priorityList
        priorityList = tempList;

        //returns ArrayList sorted by priority
        return priorityList;
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
    public void fillPriorityArrayLists() {
        //clear all items in current priority list
        lowPriorityEvents.clear();
        mediumPriorityEvents.clear();
        highPriorityEvents.clear();

        //fill priority lists with corresponding elements from GameEvents ArrayList
        for (int i = 0; i < GameEvents.size(); i++) {
            //fetches game event at index i
            GameEvent currentGE = GameEvents.get(i);

            //checks value of GameEvent priority then adds it to appropriate priority lsit
            switch (currentGE.getPriority()) {
                //priority == 0
                case 0:
                    lowPriorityEvents.add(currentGE);
                    break;
                //priority == 1
                case 1:
                    mediumPriorityEvents.add(currentGE);
                    break;
                //priority == 2
                case 2:
                    highPriorityEvents.add(currentGE);
                    break;
            }
        }

        //rearrange all lists by time
        sortByTime(lowPriorityEvents);
        sortByTime(mediumPriorityEvents);
        sortByTime(highPriorityEvents);
    }


    /* Interfaces */

    //Allows Communication with Activity and Other Fragments
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
