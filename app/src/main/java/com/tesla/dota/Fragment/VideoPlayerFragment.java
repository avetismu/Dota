package com.tesla.dota.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.tesla.dota.R;

//used for RTSP video live stream
public class VideoPlayerFragment extends Fragment {


    /* Fields */

    //declares VideoView
    private VideoView videoView;
    //declares MediaController to be assigned to VideoView
    private MediaController mediaController;
    //declares Source of Video
    private String url = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
    //declares uri Source to be passed to VideoView
    private Uri uri;


    //Interface declared
    //What is the purpose of this?
    private OnFragmentInteractionListener mListener;

    public static VideoPlayerFragment newInstance() {
        return new VideoPlayerFragment();
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

        //assigns View to vidView
        videoView = (VideoView) getActivity().findViewById(R.id.vidView_fragment_video_player);
        //assigns uri from url
        uri = Uri.parse(url);
        //assigns videoview source
        videoView.setVideoURI(uri);
        //instantiates mediaController
        mediaController = new MediaController(getActivity());
        //sets View where mediaController is located. Uses videoViews parent as anchor
        mediaController.setAnchorView(videoView);
        //adds mediaController to videoVIew
        videoView.setMediaController(mediaController);
        //starts video
        videoView.start();
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

    //NOT USED YET
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    }
