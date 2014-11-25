package com.tesla.dota.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.tesla.dota.NavigationDrawerFragment;
import com.tesla.dota.R;
import com.tesla.dota.Fragment.VodListFragment;

public class Vods extends NavigationActivity implements
        YouTubePlayer.OnInitializedListener,
        VodListFragment.OnFragmentInteractionListener {


     /* Fields */

    //declares a YouTube Player
    private YouTubePlayer YPlayer;
    //declares API KEY
    private static final String YoutubeDeveloperKey = "AIzaSyCtujPJUBt3GDlFD6R7FZywEZ9q4lQ80FQ";
    //id of the dialog to be brought up in case of error concerning the player
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    //declares link of video to be played
    private String videoLink;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vods);

        //declares Navigation Fragment
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer_vod);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer_video_player,
                (DrawerLayout) findViewById(R.id.drawer_layout_vod));
                */

        super.onCreate(savedInstanceState,
                R.layout.activity_vods,
                R.id.drawer_layout_vods,
                R.id.navigation_drawer_vods);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu, R.menu.vods);
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
            YPlayer = player;
            YPlayer.cueVideo("2zNSgSzhBfM");
        }
    }


/* Interface Methods */

    //Implements Abstract Class for VodsListFragment Fragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }
}