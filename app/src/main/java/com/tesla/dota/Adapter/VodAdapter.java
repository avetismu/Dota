package com.tesla.dota.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tesla.dota.Model.Match;
import com.tesla.dota.Model.VodMatch;
import com.tesla.dota.R;

import java.util.ArrayList;

/**
 * Created by tesla on 07/11/14.
 */
public class VodAdapter extends ArrayAdapter<VodMatch> {

    /* Fie;ds  */

    private ArrayList<VodMatch> mVodsList;
    private Context mContext;


    /* Constructors */

    public VodAdapter(Context context, ArrayList<VodMatch> matches) {
        super(context, R.layout.vod_update, matches);
        mContext = context;
        mVodsList = matches;
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
            Match match = mVodsList.get(position);

            //sets team text in format i.e "alpha  vs. beta"
            teams.setText(match.getTeam1() + " vs. " + match.getTeam2());

            //sets results text in format i.e "delta  - gamma"
            results.setText(match.getResults1() + " - " + match.getResults2());

        }

        return rowView;

    }
}
