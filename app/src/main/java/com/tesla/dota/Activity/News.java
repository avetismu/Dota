package com.tesla.dota.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tesla.dota.Fragment.NewsGridFragment;
import com.tesla.dota.Fragment.NewsReaderFragment;
import com.tesla.dota.Model.NewsObject;
import com.tesla.dota.R;

public class News extends NavigationActivity implements
        NewsGridFragment.OnFragmentInteractionListener,
        NewsReaderFragment.OnFragmentInteractionListener {

    /* Fields */

    //Log Tag
    private final static String TAG = "NEWS_ACTIVITY";

    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState,
                R.layout.activity_news,
                R.id.drawer_layout_news,
                R.id.navigation_drawer_news);


         /* Commits NewsGrid Fragment */

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //initialises NewsGrid Fragment
        NewsGridFragment newsGrid = NewsGridFragment.newInstance();

        //adds NewsGrid Fragment to container in XML
        fragmentTransaction.add(R.id.news_container, newsGrid);

        //commits added fragment
        fragmentTransaction.commit();
    }


    /* Menu */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu, R.menu.news);
    }

    //NO ITEMS YET
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //return superclass method
            default: return super.onOptionsItemSelected(item);
        }
    }


    /* Interface Methods */

    //Implements Abstract Class Method for NewsGrid Fragment
    //Opens NewsReader for clicked Grid
    public void onGridClicked(NewsObject newsObject){

        //instantiates NewsReader with newsObject fields as arguments
        NewsReaderFragment newsReaderFragment = NewsReaderFragment.newInstance(
                newsObject.getmID(),
                newsObject.getmTitle(),
                newsObject.getmSummary(),
                newsObject.getmCategory(),
                newsObject.getmContent()
        );

        //declares Fragment Manager
        FragmentManager fragmentManager = getFragmentManager();

        //declares new Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //replaces former fragment with NewsReader fragment
        fragmentTransaction.replace(R.id.news_container, newsReaderFragment);

        //adds to stack
        fragmentTransaction.addToBackStack(null);

        //commits NewsReader to Container
        fragmentTransaction.commit();

    }

    //Implements Abstract Class for NewsReaderFragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }

    /* Getters Setters */

    public String getTag(){
        return TAG;
    }
}