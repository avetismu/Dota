package com.tesla.dota;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.SurfaceView;


public class VideoPlayerFragment extends Fragment implements
        SurfaceHolder.Callback,
        MediaPlayer.OnPreparedListener {


    /* Fields */

    //declares MediaPlayer
    private MediaPlayer mediaPlayer;
    //declares SurfaceHolder, holds video
    private SurfaceHolder vidHolder;
    //declares SurfaceView
    private SurfaceView vidSurface;
    //declares URL to video file
    String url = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";



    //Interface declared
    //What is the purpose of this?
    private OnFragmentInteractionListener mListener;

    public static VideoPlayerFragment newInstance() {
        VideoPlayerFragment fragment = new VideoPlayerFragment();
        return fragment;
    }
    public VideoPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //assigns vidSurface View from layout
        vidSurface = (SurfaceView) getActivity().findViewById(R.id.surfView_fragment_video_player);
        //assigns holder id/surfView_fragment_video_player
        vidHolder = vidSurface.getHolder();
        //callback setup
        vidHolder.addCallback(this);
    }


    /* Fragment Methods */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_player, container, false);
    }

    /*
    * NOT IN USE
    // TODO: Rename method, update argument and hook method into UI event
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

    /* Interface */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    /* Interface Methods */


        /* Surface Holder States */
    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // DO NOTHING
    }

    //State in which video is played
    @Override
    public void surfaceCreated(SurfaceHolder arg0) {

        //setup
        try{
            //initialises new media player
            mediaPlayer = new MediaPlayer();
            //sets View where video is played
            mediaPlayer.setDisplay(vidHolder);
            //sets source of video
            mediaPlayer.setDataSource(url);
            //prepare media player for playback, set audio settings
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }
        catch(Exception e){
           e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
    }

        /* Media Player Methods */

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
       //start playback
        mediaPlayer.start();
    }
}
