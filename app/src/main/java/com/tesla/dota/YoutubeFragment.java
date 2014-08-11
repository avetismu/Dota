package com.tesla.dota;

import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.content.Intent;


public class YoutubeFragment extends YouTubePlayerFragment
        implements YouTubePlayer.OnInitializedListener {


    /* Fields */

    //Interface declared
    private OnFragmentInteractionListener mListener;

    //declares a YouTuve Player
    private YouTubePlayer YPlayer;
    //declares API KEY
    private static final String YoutubeDeveloperKey = "AIzaSyCtujPJUBt3GDlFD6R7FZywEZ9q4lQ80FQ";
    //id of the dialog to be brought up in case of error concerning the player
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    //declares link of video to be played
    private String videoLink;


    /* Fragment States */

    public static YoutubeFragment newInstance(String videoLink) {

        return new YoutubeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_youtube, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //declares youtube player container view
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) getActivity().findViewById(R.id.youtube_player_view);
        //initialises the youtubeplayer
        youTubePlayerView.initialize(YoutubeDeveloperKey, this);
    }

    /* Constructors */

    //empty constructor
    public YoutubeFragment(){
        //EMPTY
    }


    /* Fragment Methods */

    /*
    NOT IN USE
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
*/
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /* YouTube Player Methods */

    //Implements YouTube interface
    //in case of YouTube failure
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult error){
        //if error is recoverable launch the dialog
        if (error.isUserRecoverableError()){
            error.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
        }
        //if error is related to initalisation, use toast to communicate error
        else{
            //declares error message
            String errorMessage = String.format("There was an initialisation error", error.toString());
            //launch toast
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
        }

    }

    //Implements YouTube interface
    //in case of success
    @Override
    public void onInitializationSuccess(Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            YPlayer = player;
            YPlayer.cueVideo("2zNSgSzhBfM");
        }
    }


    /* Interface */

    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
