package com.tesla.dota;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;

public class LiveGame extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
                   LiveGameFragment.OnFragmentInteractionListener{


	/* Fields */

    //Activity Navigation Fragment class
    public static NavigationDrawerFragment mNavigationDrawerFragment;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);


        //declares Navigation Fragment
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer_live_game);


        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer_live_game,
                (DrawerLayout) findViewById(R.id.drawer_layout_live_game));

        /* Commits LiveGame Fragment */

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises LiveGame Fragment
        LiveGameFragment liveGameFragment= new LiveGameFragment();

        //adds LiveGame Fragment to container in XML
        fragmentTransaction.add(R.id.fragment_container, liveGameFragment);

        //commits added fragment
        fragmentTransaction.commit();

        /* DEMO */

        //instantiates ConnectionFailedFragment
        ConnectionFailedFragment connectionFailedFragment = new ConnectionFailedFragment();

        //display connection failed dialog
        connectionFailedFragment.show(fragmentManager, "Connect Again?");
    }


    /* Interface Methods and Drawer Methods */

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


    /* Menu */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.live_game, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    //Manages Menu Item Selection
    //No Menu Items in LiveGame Activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //will call activity's handler before passing it on to the fragment
        switch (item.getItemId()){
            default: return super.onOptionsItemSelected(item);
        }
    }

    /* Interface Methods */

    //Implements Abstract Class for LiveGame Fragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }

}
