package com.tesla.dota.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.tesla.dota.Fragment.NavigationDrawerFragment;
import com.tesla.dota.R;
import com.tesla.dota.Fragment.VideoPlayerFragment;

//used for RTSP live stream
public class VideoPlayer extends NavigationActivity implements
        VideoPlayerFragment.OnFragmentInteractionListener {

    /* Fields */

    //Logcat Tag
    private final static String TAG = "VIDEO_PLAYER_ACTIVITY";


    /* Activity States */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState,
                R.layout.activity_video_player,
                R.id.drawer_layout_video_player,
                R.id.navigation_drawer_video_player);

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

        /* Interface Methods */

    //Implements Abstract Class for  VideoPlayer Fragment
    public void onFragmentInteraction(Uri uri){
        /*
        no Interactions yet */

    }

    /* Getters */

    @Override
    public String getTag() {
        return TAG;
    }


}
