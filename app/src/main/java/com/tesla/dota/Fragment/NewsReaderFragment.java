package com.tesla.dota.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tesla.dota.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsReaderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsReaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class NewsReaderFragment extends Fragment {

    /* Fields */

    // the fragment initialisation parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ID = "ID";
    private static final String ARG_TITLE= "TITLE";
    private static final String ARG_SUMMARY = "SUMMARY";
    private static final String ARG_CATEGORY = "CATEGORY";
    private static final String ARG_CONTENT = "CONTENT";

    //ID of the News Object
    private int ID;
    //Title, First Headline to be Displayed
    private String Title;
    //Summary, to be displayed under/with Title as subtitle
    private String Summary;
    //category of news, i.e. competitive, tournament, editorial, stats, etc
    private String Category;
    //Body of the News object
    private String Content;

    //Interface declared
    //What is the purpose of this?
    private OnFragmentInteractionListener mListener;


    /* Fragment States */

    /**
     * @param Id News Object ID.
     * @param Title News Object Title.
     * @param Category News Object Category.
     * @param Content News Object Content.
     * @return A new instance of fragment NewsReader.
     */

    public static NewsReaderFragment newInstance(int Id, String Title, String Summary, String Category, String Content) {
        NewsReaderFragment fragment = new NewsReaderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, Id);
        args.putString(ARG_TITLE, Title);
        args.putString(ARG_SUMMARY, Summary);
        args.putString (ARG_CATEGORY, Category);
        args.putString(ARG_CONTENT, Content);
        fragment.setArguments(args);
        return fragment;
    }
    public NewsReaderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ID = getArguments().getInt(ARG_ID);
            Title = getArguments().getString(ARG_TITLE);
            Summary = getArguments().getString(ARG_SUMMARY);
            Category = getArguments().getString(ARG_CATEGORY);
            Content = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_reader, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //calls superclass method
        super.onActivityCreated(savedInstanceState);

        //declares Title TextView
        TextView title = (TextView) getActivity().findViewById(R.id.NewsReader_Title);
        //declares Category TextView
        TextView category = (TextView) getActivity().findViewById(R.id.NewsReader_Category);
        //declares Summary TextView
        TextView summary = (TextView) getActivity().findViewById(R.id.NewsReader_Summary);
        //declares Content TextView
        TextView content = (TextView) getActivity().findViewById(R.id.NewsReader_Content);

        //sets text of title TextView to string of Title field
        title.setText(Title);
        //sets text of category TextView to string of Category field
        category.setText(Category);
        //sets text of summary TextView to string of Summary field
        summary.setText(Summary);
        //sets text of content to TextView string of Content field
        content.setText(Content);
    }

    /* Fragment Methods */

    /* NOT IN USE
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
