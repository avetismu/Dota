package com.tesla.dota.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tesla.dota.Activity.Vods;
import com.tesla.dota.Model.VodMatch;
import com.tesla.dota.R;
import com.tesla.dota.Adapter.VodAdapter;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VodListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VodListFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class VodListFragment extends Fragment {

    /* Fields */
    private OnFragmentInteractionListener mListener;

    private ArrayList<VodMatch> mVodsList = new ArrayList<VodMatch>();

    /* Constructors and Instances */

    public static VodListFragment newInstance() {
        VodListFragment fragment = new VodListFragment();

        return fragment;
    }
    public VodListFragment() {
        // Required empty public constructor
    }

    /* Fragment States */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vod_list, container, false);
    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }
*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        //calls superclass constructor
        super.onActivityCreated(savedInstanceState);

        //DEMO
        //VodObjects to be added to ListView
        //TODO: Remove DEMO, Replace with real values
        ArrayList<VodMatch> tempList = new ArrayList<VodMatch>();
        tempList.add(new VodMatch( "Gmv1EeVB2es", "Zyori", "Merlini", "1", "0"));
        tempList.add(new VodMatch( "fUMKzbCEHZ8", "LD","PyrionFlax","2","1"));
        tempList.add(new VodMatch("5csI_uwjeRg", "Uliumbrella", "Blaze", "0", "0"));

        //add tempList to a
        fillmVodsList(tempList);

        ListView listView = (ListView) getActivity().findViewById(R.id.vodsList);

        VodAdapter adapter = new VodAdapter(getActivity().getBaseContext(), mVodsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.runVod(mVodsList.get((i)));
            }
        });

    }

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
        public void runVod(VodMatch vodMatch);
    }

    /**
     * @param list list of VodObjects to be added to field mVodsList
     */
    public void fillmVodsList(Collection<VodMatch> list){

        mVodsList.addAll(list);

    }

}
