package com.tesla.dota;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.tesla.dota.R;

public class News extends Activity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,
        NewsGrid.OnFragmentInteractionListener,
        NewsReader.OnFragmentInteractionListener{

    /* Fields */

    //Activity Navigation Fragment class
    private NavigationDrawerFragment mNavigationDrawerFragment;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer_news);


        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer_news,
                (DrawerLayout) findViewById(R.id.drawer_layout_news));



         /* Commits NewsGrid Fragment */

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises NewsGrid Fragment
        //NewsGrid newsGrid = new NewsGrid();

        //adds NewsGrid Fragment to container in XML
        //fragmentTransaction.add(R.id.news_container, newsGrid);

        //commits added fragment
        //fragmentTransaction.commit();

        /* Replaces NewsGrid with NewsReader Fragment */

        //initialises NewsReader Fragment
        NewsReader newsReader = NewsReader.newInstance(0, "lorem Ipsum", "Lorem Ipsum Dolor", "editorial", "r u 'avin a giggle there m8");

        //replaces newsGrid with newsReader
        fragmentTransaction.add(R.id.news_container, newsReader);

        //commits newsReader Fragment
        fragmentTransaction.commit();
    }


    /* Menu */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.news, menu);
            restoreActionBar();
            return true;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()) {

           default: return super.onOptionsItemSelected(item);
       }
    }

    /* Interface Methods */


    //TO BE REPLACED BY FINAL METHOD
    //REFER TO SAME METHOD IN LIVEGAME ACTIVITY
    @Override
    public void onNavigationDrawerItemSelected(int position) {
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        //actionBar.setTitle(mTitle);
    }

    //Implements Abstract Class for NewsGrid Fragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }
}