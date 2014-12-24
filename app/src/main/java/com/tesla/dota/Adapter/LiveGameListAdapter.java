package com.tesla.dota.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tesla.dota.Model.GameEvent;
import com.tesla.dota.Model.Match;
import com.tesla.dota.R;

import java.util.ArrayList;

/**
 * Created by tesla on 23/12/14.
 */
public class LiveGameListAdapter extends ArrayAdapter<Match> {

    /* Fields */
    private Context mContext;
    private ArrayList<Match> mMatches;

    /* Constructor */
    public LiveGameListAdapter(Context context, ArrayList<Match> matches){
        super(context,R.layout.live_game_update , matches);
        mContext= context;
        mMatches = matches;
    }

    /* Methods */

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View rowView = convertView;

        if (convertView == null){

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            rowView = inflater.inflate(R.layout.live_game_update, parent, false);

            //intialise TextView
            TextView textView = (TextView) rowView.findViewById(R.id.live_game_update_textView);

            //current Match
            Match match = mMatches.get(position);

            //sets Teams
            textView.setText(match.getTeam1() + " vs. " + match.getTeam2());

        }

        return rowView;
    }


}
