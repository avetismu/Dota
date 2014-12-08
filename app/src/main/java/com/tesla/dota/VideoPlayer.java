package com.tesla.dota;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.tesla.dota.Fragment.NavigationDrawerFragment;

//used for RTSP live stream
public class VideoPlayer extends Activity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,
        VideoPlayerFragment.OnFragmentInteractionListener{

    /* Fields */

    //Activity Navigation Fragment class
    public static NavigationDrawerFragment mNavigationDrawerFragment;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //declares Navigation Fragment
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer_video_player);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer_video_player,
                (DrawerLayout) findViewById(R.id.drawer_layout_video_player));

        /* Commits LiveGame Fragment */

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises YoutubeFragment
        VideoPlayerFragment videoPlayer= new VideoPlayerFragment();

        //adds YoutubeFragment to container in XML
        fragmentTransaction.add(R.id.video_player_container, videoPlayer);

        //commits added fragment
        fragmentTransaction.commit();
    }

    /* Menu */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.video_player, menu);
        return true;
    }

    //No Menu Items yet
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            default: return super.onOptionsItemSelected(item);
        }
    }


    /* Interface Methods and Drawer Methods */

    //TO BE REPLACED BY FINAL METHOD
    //REFER TO SAME METHOD IN LIVEGAME ACTIVITY
    @Override
    public void onNavigationDrawerItemSelected(int position) {

        /*
        Can be used to Update Content or Navigate
                */
    }

    //Sets Up Action Bar
    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
    }

        /* Interface Methods */

    //Implements Abstract Class for LiveGame Fragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }


}
