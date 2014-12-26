package com.tesla.dota.Adapter;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tesla.dota.Model.GameEvent;
import com.tesla.dota.R;

public class EventAdapter extends ArrayAdapter<GameEvent>{

	/* Fields */

    private ArrayList<GameEvent> mGameEvents;
    private Context mContext;

	/* Constructors */

    public EventAdapter(Context context, ArrayList<GameEvent> gameEvents){
        super(context, R.layout.game_event_row, gameEvents);
        this.mContext = context;
        this.mGameEvents = gameEvents;
    }

	/* Methods */

    //Generates Row with Time, Priority and Update
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View rowView = convertView;

        if (convertView == null){

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            rowView = inflater.inflate(R.layout.game_event_row, parent, false);

            //initialises Time
            TextView time = (TextView) rowView.findViewById(R.id.date);
            //initialises Update
            TextView update = (TextView) rowView.findViewById(R.id.update);
            //initialises Priority Icon
            ImageView icon =  (ImageView) rowView.findViewById(R.id.priority_Icon);

            //fetches current GameEvent from position
            GameEvent currentGE = mGameEvents.get(position);

            //fetches corresponding icon drawable as input stream
            //HELPER METHOD
            //InputStream ims = getIcon(currentGE);

            //creates Drawable from InputStream
            //Drawable priorityIcon = Drawable.createFromStream(ims, null);

            //sets current time
            time.setText(currentGE.getTime().hour + ":" + currentGE.getTime().minute);

            //sets game_event_row
            update.setText(currentGE.getUpdate());

            //sets image to priorityIcon
            icon.setImageDrawable(getIcon(currentGE));
        }

        return rowView;
    }

		/* Helper Methods */

    //returns icon as input stream based on Priority level
    private Drawable getIcon(GameEvent currentGE){

        //priority level of current GameEvent
        int Priority = currentGE.getPriority();

        //declares drawable to be returned
        Drawable d = null;

        //fetches corresponding icon based on priority level as input stream
        switch(Priority){

            //Priority == 0
            case 0:
                d = mContext.getResources().getDrawable(R.drawable.ic_action_not_important);
                break;

            //Priority == 1
            case 1:
                d = mContext.getResources().getDrawable(R.drawable.ic_action_half_important);
                break;

            //Priority == 2
            case 2:
                d = mContext.getResources().getDrawable(R.drawable.ic_action_important);
                break;
        }

        //returns icon as drawable
        return d;

    }

}
