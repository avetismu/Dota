package com.tesla.dota.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;

import com.tesla.dota.Fragment.ConnectionFailedFragment;
import com.tesla.dota.Fragment.LiveGameFragment;
import com.tesla.dota.Fragment.LiveGameListFragment;
import com.tesla.dota.Model.Match;
import com.tesla.dota.R;

import java.util.ArrayList;

public class LiveGame extends NavigationActivity
        implements LiveGameListFragment.OnLiveGameListSelectedListener{


	/* Fields */

    //Log Tag
    private final static String TAG = "LIVE_GAME_ACTIVITY";

    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState,
                R.layout.activity_live_game,
                R.id.drawer_layout_live_game,
                R.id.navigation_drawer_live_game);

        /* Commits LiveGame Fragment */

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //initialises fragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises LiveGameList Fragment
        LiveGameListFragment liveGameListFragment = LiveGameListFragment.newInstance(new ArrayList<Match>());

        //adds LiveGameList Fragment to container in XML
        fragmentTransaction.add(R.id.fragment_container, liveGameListFragment);

        //commits added fragment
        fragmentTransaction.commit();

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

    public void onLiveGameListSelected(Match match){

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //initialises fragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises LiveGame Fragment
        LiveGameFragment liveGameFragment = LiveGameFragment.newInstance(match, "Tournament");

        //replaces liveGameListFragment with liveGameFragment with Match object selected in liveGameListFragment
        fragmentTransaction.replace(R.id.fragment_container, liveGameFragment);
        fragmentTransaction.addToBackStack(null);

        //commits liveGameFragment
        fragmentTransaction.commit();
    }
    /* Getters Setters*/

    public String getTag(){
        return TAG;
    }

}
