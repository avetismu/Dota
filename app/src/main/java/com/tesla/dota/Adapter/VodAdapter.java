package com.tesla.dota.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tesla.dota.R;
import com.tesla.dota.Model.VodObject;

import java.util.ArrayList;

/**
 * Created by tesla on 07/11/14.
 */
public class VodAdapter extends ArrayAdapter<VodObject> {

    /* Fie;ds  */

    private ArrayList<VodObject> mVodsList;
    private Context mContext;


    /* Constructors */

    public VodAdapter(Context context, ArrayList<VodObject> vodObjects) {
        super(context, R.layout.vod_update, vodObjects);
        mContext = context;
        mVodsList = vodObjects;
    }

    /* Methods */

    //Generates Row with Time, Priority and Update
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            rowView = inflater.inflate(R.layout.vod_update, parent, false);

            //Declares team text
            TextView teams = (TextView) rowView.findViewById(R.id.vod_update_teams);

            //Declares results text
            TextView results = (TextView) rowView.findViewById(R.id.vod_update_results);

            //fetches current VodObject
            VodObject vodObject = mVodsList.get(position);

            //sets team text in format i.e "alpha  vs. beta"
            teams.setText(vodObject.getTeam1() + " vs. " + vodObject.getTeam2());

            //sets results text in format i.e "delta  - gamma"
            results.setText(vodObject.getResults1() + " - " +vodObject.getResults2());

        }

        return rowView;

    }
}
