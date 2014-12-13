package com.tesla.dota.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.tesla.dota.Model.VodMatch;
import com.tesla.dota.R;

import java.util.ArrayList;

/**
 * Created by tesla on 07/12/14.
 */
public class VodMatchHistoryAdapter extends ArrayAdapter<VodMatch> {

    /* Fields */
    private ArrayList<VodMatch> mMatches;
    private Context mContext;

    /* Constructors */

    /**
     * Default Constructor
     *
     * @param context Activity where called
     * @param matches ArrayList of VodMatches to be displayed in drop-down list
     */
    public VodMatchHistoryAdapter(Context context, ArrayList<VodMatch> matches){
        super(context, R.layout.drop_down_vodmatch_update, matches);
        mMatches = matches;
        mContext = context;


    }

    /* Methods */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(convertView == null){

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            rowView = inflater.inflate(R.layout.drop_down_vodmatch_update, parent, false);

            //declares TextView containing name
            TextView vodmatchName = (TextView) rowView.findViewById(R.id.vodmatch_name);

            //sets Name of Match
            vodmatchName.setText(mMatches.get(position).getTeam1() + " vs. " + mMatches.get(position).getTeam2());
        }

        return rowView;

    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
