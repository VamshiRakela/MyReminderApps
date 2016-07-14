package com.example.vamshi.myreminderapps;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class PickTheDate extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);

    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

        System.out.println(year+"  "+month+"  "+date);
        PickTheTime pickTheTime=new PickTheTime();
        FragmentManager mr=getFragmentManager();
        pickTheTime.show(mr,"Time  Picker");
        Bundle args = new Bundle();
        args.putInt("DATE",date);
        args.putInt("YEAR",year);
        args.putInt("MONTH",month);
        pickTheTime.setArguments(args);
     }
}
