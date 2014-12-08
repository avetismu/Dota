package com.tesla.dota.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.pm.ActivityInfo;

import com.tesla.dota.Adapter.NewsGridAdapter;
import com.tesla.dota.Model.NewsObject;
import com.tesla.dota.R;

import java.util.ArrayList;


public class NewsGridFragment extends Fragment {


    /* Fields */

    //GridView to display
    private GridView mGridView;
    //ArrayList of News Objects to be displayed in Grid
    private ArrayList<NewsObject> mNewsObjects = new ArrayList<NewsObject>();

    //Interface declared
    //What is the purpose of this?
    private OnFragmentInteractionListener mListener;


    /* Fragment States */

    public static NewsGridFragment newInstance() {
        NewsGridFragment fragment = new NewsGridFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public NewsGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_grid, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //assigns GridView
        mGridView = (GridView) getActivity().findViewById(R.id.newsgrid_grid);

        //DEMO
        //adds item to mNewsObject
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        mNewsObjects.add(new NewsObject(1917, "Lorem Ipsum", "Lorem ipsum dolor sit amet,", "editorial", "r u 'avin a giggle there m8"));
        //mNewsObjects.add(new NewsObject(1917, "Giggle", "'avin a giggle?", "editorial", "r u 'avin a giggle there m8"));

        //creates new adapter
        NewsGridAdapter adapter = new NewsGridAdapter(getActivity(), mNewsObjects);

        //sets adapter
        mGridView.setAdapter(adapter);

        //handles clicks in gridview
        mGridView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        //fetches NewsObject at selected position
                        NewsObject newsObject = mNewsObjects.get(position);
                        //passes newsObject as argument to callback method onGridClicked
                        mListener.onGridClicked(newsObject);
                    }
                }
        );
    }

    @Override
    public void onPause() {
        //empties mNewsObjects
        mNewsObjects.clear();

        //superclass method
        super.onPause();
    }


    /* Fragment Methods */

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


    /* Interfaces */

    //Allows Communication with Activity and Other Fragments
    public interface OnFragmentInteractionListener {
        public void onGridClicked(NewsObject newsObject);
    }

}
