package com.tesla.dota.Activity;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.tesla.dota.Adapter.VodMatchHistoryAdapter;
import com.tesla.dota.Model.VodMatch;
import com.tesla.dota.Model.VodMatchHistory;
import com.tesla.dota.R;
import com.tesla.dota.Fragment.VodListFragment;

import java.util.ArrayList;

/**
 * TODO: Optimise with helper functions
 */
public class Vods extends NavigationActivity implements
        YouTubePlayer.OnInitializedListener,
        VodListFragment.OnFragmentInteractionListener,
        AdapterView.OnItemSelectedListener {


     /* Fields */

    //declares a YouTube Player
    private YouTubePlayer YPlayer;
    //initialisation success of YPlayer
    private boolean wasInitialised;
    //declares API KEY
    private String YoutubeDeveloperKey;
    //id of the dialog to be brought up in case of error concerning the player
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    //declares link of video to be played
    private String videoLink;
    //youtube url
    private VodMatch mCurrentVodMatch;
    //List of the vodmatches viewed
    private VodMatchHistory mHistory;
    //Action Bar
    private ActionBar actionBar;
    //spinner Adapter
    private VodMatchHistoryAdapter adapter;
    //History Spinner
    private Spinner spinner;
    

    //Log Tag
    private static final String TAG = "VODS_ACTIVITY";
    

    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState,
                R.layout.activity_vods,
                R.id.drawer_layout_vods,
                R.id.navigation_drawer_vods);
        
        //initalises mHistory
        mHistory= VodMatchHistory.getInstance(this);

        //assigns actionBar
        actionBar = getActionBar();

        //set up actionBar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        //fetches Developer Key
        YoutubeDeveloperKey = getResources().getString(R.string.API_KEY);

        //DEMO
        //initialises current VodMatch
        //TODO: Remove Demo and set real value
        mCurrentVodMatch = new VodMatch( "EepOhNefloE", "MVP Phoenix", "Cloud9", "1","1");

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //fetches YPlayerFragment
        YouTubePlayerFragment YPlayerFragment = (YouTubePlayerFragment)fragmentManager.findFragmentById(R.id.vod_youtubeplayerfragment);

        //intialises YPlayerFragment
        YPlayerFragment.initialize(YoutubeDeveloperKey, this);

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises VodListFragment
        VodListFragment vodListFragment = VodListFragment.newInstance();

        //adds VodListFragment Fragment to container in XML
        fragmentTransaction.add(R.id.vod_vodlistfragment, vodListFragment);

        fragmentTransaction.commit();

    }

    /* Menu */

    /**
     * Overrides NavigationActivity onCreateOptionsMenu method
     * TODO: Implement Spinner Functionality
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.vods, menu);


        //DEMO
        //VodObjects to be added to mHistory
        //TODO: Remove DEMO, Replace with real values
        mHistory.addVodMatch(new VodMatch("Gmv1EeVB2es", "Zyori", "Merlini", "1", "0"));
        mHistory.addVodMatch(new VodMatch( "fUMKzbCEHZ8", "LD","PyrionFlax","2","1"));

        //initialises spinner
        MenuItem menuItem = menu.findItem(R.id.vods_history_drop_down);
        spinner = (Spinner) menuItem.getActionView().findViewById(R.id.history_spinner);

        //initialises adapter
        adapter = new VodMatchHistoryAdapter(this, mHistory.getFiveLatestVods());

        //sets adapter
        /*
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                mHistory.getFiveLatestVodsName()));
*/
        spinner.setAdapter(adapter);

        //Selection Listener
        spinner.setOnItemSelectedListener(this);

        //
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
        // Only show items in the action bar relevant to this screen
        // if the drawer is not showing. Otherwise, let the drawer
        // decide what to show in the action bar.
            restoreActionBar();
        }

        return true;
    }

    
    //NO ITEMS YET
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //return superclass method
            default: return super.onOptionsItemSelected(item);
        }
    }

  /* YouTube Player Methods */

    //Implements YouTube interface
    //in case of YouTube failure
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult error){

        //initialisation failure
        wasInitialised = false;

        //if error is recoverable launch the dialog
        if (error.isUserRecoverableError()){
            error.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        }
        //if error is related to initalisation, use toast to communicate error
        else{
            //declares error message
            String errorMessage = String.format("There was an initialisation error", error.toString());
            //launch toast
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }

    }

    //Implements YouTube interface
    //in case of success
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            //initialisation
            wasInitialised = true;
            YPlayer = player;
            YPlayer.cueVideo(mCurrentVodMatch.getUrl());
        }
    }


/* Interface Methods */

    //Implements Abstract Class for VodsListFragment Fragment
    public void runVod(VodMatch vodMatch){

        mHistory.addVodMatch(vodMatch);
        adapter.clear();
        adapter.addAll(mHistory.getFiveLatestVods());
        adapter.notifyDataSetChanged();

        if(wasInitialised){
            YPlayer.cueVideo(vodMatch.getUrl());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        VodMatch vodMatch = (VodMatch) spinner.getAdapter().getItem(i);

        if(wasInitialised)
            YPlayer.cueVideo(vodMatch.getUrl());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //DO NOTHING
    }

    /* Getters Setters */

    public String getTag(){
        return TAG;
    }



}