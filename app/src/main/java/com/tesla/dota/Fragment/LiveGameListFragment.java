package com.tesla.dota.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tesla.dota.Adapter.LiveGameListAdapter;
import com.tesla.dota.Model.Match;
import com.tesla.dota.Model.VodMatch;
import com.tesla.dota.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.tesla.dota.Fragment.LiveGameListFragment.OnLiveGameListSelectedListener} interface
 * to handle interaction events.
 * Use the {@link LiveGameListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveGameListFragment extends Fragment
        implements ListView.OnItemClickListener {

    /* Fields */
    private static ArrayList<Match> mMatches;
    private OnLiveGameListSelectedListener mListener;


    /* Fragment States */

    public static LiveGameListFragment newInstance(ArrayList<Match> matches) {
        LiveGameListFragment fragment = new LiveGameListFragment();
        mMatches = matches;
        return fragment;
    }

    public LiveGameListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.title_activity_live_game);

        //DEMO
        //TODO: Remove and replace with actual values
        mMatches.add(new VodMatch( "EepOhNefloE", "MVP Phoenix", "Cloud9", "1","1"));
        mMatches.add(new VodMatch( "EepOhNefloE", "MVP Phoenix", "Cloud9", "1","1"));

        //initialises listView
        ListView listView = (ListView) getActivity().findViewById(R.id.fragment_live_game_list_listView);

        //sets Click Listener
        listView.setOnItemClickListener(this);

        //initialises Custom ArrayAdapter
        LiveGameListAdapter adapter = new LiveGameListAdapter(getActivity(), mMatches);

        listView.setAdapter(adapter);

    }

    @Override
    public void onPause(){

        mMatches.clear();
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_game_list, container, false);

    }



    /* Fragment Methods */

    /**
     *
     * NOT IN USE

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
     **/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnLiveGameListSelectedListener) activity;
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


    /* Interfaces */

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnLiveGameListSelectedListener {
        // TODO: Update argument type and name
        public void onLiveGameListSelected(Match match);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg2){
        //Match at index position selected
        mListener.onLiveGameListSelected(mMatches.get(position));
    }

}
