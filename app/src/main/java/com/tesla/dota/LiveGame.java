package com.tesla.dota;
import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/*TO DO
 * Create abstract Activity containing drawer navigation
 * use View in NavigatorSuperClass to assign content
 * inflate the View R.id.activity_content
 */

public class LiveGame extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks{


	/* Fields */

    //Activity Navigation Fragment class
    public static NavigationDrawerFragment mNavigationDrawerFragment;


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_game);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer_live_game);


        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer_live_game,
                (DrawerLayout) findViewById(R.id.drawer_layout_live_game));
    }


    /* Interface Methods and Drawer Methods */

    @Override
    public void onNavigationDrawerItemSelected(int position) {
/*
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, GameUpdates.newInstance("stuff", "stuff"))
                .commit();
                */
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        //actionBar.setTitle(mTitle);
    }


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


    /* Menu */

    public boolean onOptionsItemSelected(MenuItem item){

        return true;
    }

}
