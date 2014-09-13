package com.tesla.dota;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by tesla on 16/08/14.
 */

//used to set up NewsObject items in a Grid View
public class NewsGridAdapter extends BaseAdapter {


    /* Fields */

    //Context of Activity
    private Context mContext;
    //ArrayList of News Objects to be displayed in Grid
    private ArrayList<NewsObject> mNewsObjects = new ArrayList<NewsObject>();


    /* Constructors */

    //default non-empty public constructor
    public NewsGridAdapter(Context context, ArrayList<NewsObject> newsObjects){
        //assigns parameter to fields
        this.mContext = context;
        this.mNewsObjects = newsObjects;
    }

    //How many items are in the data set represented by this Adapter.
    public int getCount(){
        return mNewsObjects.size();
    }

    //Get the data item associated with the specified position in the data set.
    public Object getItem(int position){
        return mNewsObjects.get(position);
    }

    //Get the row id associated with the specified position in the list.
    public long getItemId(int position){
        //arbitrary long value
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridSq = convertView;

        //inflate View if null
        if (convertView == null){

            //initialise inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate row layout
            gridSq = inflater.inflate(R.layout.newsgridsq, parent, false);

            //fetches current NewsObject
            NewsObject newsObject = mNewsObjects.get(position);

            //declares view holding title of newsObject
            TextView title = (TextView) gridSq.findViewById(R.id.grid_sq_title);

            //declares RelativeLayout
            LinearLayout linearLayout = (LinearLayout) gridSq.findViewById(R.id.grid_sq_label);

            //declares view holding image of newObject
            //ImageView img = (ImageView) gridSq.findViewById(R.id.grid_sq_img);

            //declares view holding summary of newsObject
            TextView category = (TextView) gridSq.findViewById(R.id.grid_sq_category);

            //sets title
            title.setText(newsObject.getmTitle());

            //sets summary
            category.setText(newsObject.getmCategory());

            //sets image
            gridSq.setBackground(getGridSquareImage(newsObject));

        }


        //returns view to be displayed
        return gridSq;
    }


    /* Helper Methods */

    //returns appropriate Image given a NewsObject
    //TO BE MODIFIED
    private Drawable getGridSquareImage(NewsObject newsObject){
        return mContext.getResources().getDrawable(R.drawable.giggle);
    }
}
