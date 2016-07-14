package com.example.vamshi.myreminderapps;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class PickTheTime extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public static final int YEAR=0;
    public static final int MONTH=0;
    public static final int DAY=0;
    private  Calendar c;

    private int hour;
    private int minute;
    private int YREC;
    private int MREC;
    private int DREC;

    private static final String abc="DATE";
    @Override
   public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle;
        bundle = this.getArguments();
        DREC = bundle.getInt("DATE");
        YREC = bundle.getInt("YEAR");
        MREC = bundle.getInt("MONTH");
        System.out.println("Date is " + DREC + "yEAR IS " + YREC + "MONTH IS " + (MREC + 1));
        c = Calendar.getInstance();
        c.set(YREC, (MREC + 1), DREC);
        return  new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        c.set(YREC,(MREC+1),DREC);
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR_OF_DAY,i);
        c.set(Calendar.MINUTE,i1);
        System.out.println("HOUR IS CALENDER----------"+DREC);
        Log.v("calling","setAlarm()");
        setAlarm();

    }

    public void setAlarm() {

        Log.v("IN time class 57","correct6667");
        AlarmManager alarmManager=(AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(getActivity().getBaseContext(),AlarmReceiver234.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity().getApplicationContext(),457,intent,0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
        Toast.makeText(getActivity(),"SET ALARM DONE",Toast.LENGTH_SHORT).show();
        Log.v("IN time class","correct");

    }


}

