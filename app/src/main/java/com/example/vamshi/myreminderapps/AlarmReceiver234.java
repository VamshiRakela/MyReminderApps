package com.example.vamshi.myreminderapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class AlarmReceiver234 extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("Entered  ","Notification class");
        Intent innt = new Intent(context, SetTheNotification.class);
        context.startService(innt);
    }
}
