package com.tesla.dota.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;

import com.tesla.dota.ConnectionFailedFragment;
import com.tesla.dota.LiveGameFragment;
import com.tesla.dota.NavigationDrawerFragment;
import com.tesla.dota.R;

public class LiveGame extends NavigationActivity
        implements LiveGameFragment.OnFragmentInteractionListener {


	/* Fields */

    //Activity Navigation Fragment class
    public static NavigationDrawerFragment mNavigationDrawerFragment;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState,
                R.layout.activity_live_game,
                R.id.navigation_drawer_live_game,
                R.id.drawer_layout_live_game);

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

    /* Menu */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu, R.menu.live_game);
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
