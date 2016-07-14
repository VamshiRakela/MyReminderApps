package com.example.vamshi.myreminderapps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;


public class DialogueExample extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setMessage("Hello Iam Dialogue Box !!!")
        .setPositiveButton("Go Ahead", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int ID){
                FragmentManager mgr=getFragmentManager();
                PickTheDate pickTheDate=new PickTheDate();
                pickTheDate.show(mgr,"This is date picker");
            }
        })
        .setNegativeButton("Go Back",new DialogInterface.OnClickListener(){


                    public void  onClick(DialogInterface d, int id){



            }
        });

        return builder.create();

    }
}
