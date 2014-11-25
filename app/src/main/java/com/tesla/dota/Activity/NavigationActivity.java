package com.tesla.dota.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.tesla.dota.NavigationDrawerFragment;

/**
 * Extended by all activities in the Application
 * Holds all navigation drawer functionality
 * also has Youtube functionality
 */
public class NavigationActivity extends YouTubeBaseActivity
implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /* Fields */

    //Activity Navigation Fragment class
    public static NavigationDrawerFragment mNavigationDrawerFragment;

    /* Activity States */


    /**
     * Does all required setup for Activity State onCreate() with a navigation drawer,
     * Similar to super.onCreate(...)
     *
     * @param savedInstanceState Bundle
     * @param layout Resources id for xml layout file
     * @param drawerId Resources id for root drawer layout(android.support.v4.widget.DrawerLayout) in xml
     * @param navigationId Resources id for navigation drawer fragment in xml
     */
    public void onCreate(Bundle savedInstanceState, int layout, int drawerId, int navigationId){
        super.onCreate(savedInstanceState);

        setContentView(layout);


        //declares Navigation Fragment
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(drawerId);


        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                drawerId,
                (DrawerLayout) findViewById(navigationId));


    }

    /* Menu */

    /**
     * All required setup for Activity onCreateOptionsMenu() with navigation drawer
     * Similar to super.onCreateOptions Menu
     *
     * @param menu  Menu object, required for superclass method onCreateOptionsMenu(Menu menu)
     * @param menuId Resource id for menu xml file
     * @return true if properly setup
     */
    public boolean onCreateOptionsMenu(Menu menu, int menuId){
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(menuId, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* Navigation Drawer Methods */

    //Handles Navigation Bar Selection
    @Override
    public void onNavigationDrawerItemSelected(int position) {

        //declares Intent of Activity to be launched
        Intent intent;

        switch (position){

            //Vods selected
            case (2):
                //intialises intent with Activity to be launched
                intent = new Intent(this, Vods.class);
                //launch Activity Specified in Intent
                this.startActivity(intent);
                //destroy current Activity
                this.onDestroy();
                break;
        }

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
}
