package com.tesla.dota;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;

//Dialog called when connection to server fails
//has options Connect Again and Cancel
//called in Activity using ConnectionFailedFragment.show()
public class ConnectionFailedFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        /* Uses Dialog Builder */

        //instantiates AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //sets AlertDialog title
        builder.setTitle(R.string.connection_failed_fragment_title);

        //sets message
        builder.setMessage(R.string.connection_failed_fragment_message).
                //sets Positive Button
                //Connect Again
                setPositiveButton(R.string.connection_failed_fragment_positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*
                        Attempt Connection Again
                         */

                    }
                })
                //sets Negative Button
                //Cancel
                .setNegativeButton(R.string.connection_failed_fragment_negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //cancel dialog
                        dismiss();;
                    }
                });

        //generates dialog based on previous above set specifications
        return builder.create();
    }

    //Empty Constructor
    public ConnectionFailedFragment(){
        //no fields
        //DO NOTHING
    }


}
