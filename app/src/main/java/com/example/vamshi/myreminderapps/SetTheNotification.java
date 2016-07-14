package com.example.vamshi.myreminderapps;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;



public class SetTheNotification extends IntentService {
    private static final int NOTIFICATION_ID=123;


    public SetTheNotification() {
        super("SetTheNotification");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String text = "This is Your Notification";
        showText(text);

    }

    private void showText(final String text){


        Intent it = new Intent(this, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
           stackBuilder.addParentStack(MainActivity.class);
          stackBuilder.addNextIntent(it);
          PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
             .setSmallIcon(R.mipmap.ic_add_reminder)
             .setContentTitle(getString(R.string.app_name))
               .setAutoCancel(true)
               .setPriority(Notification.PRIORITY_MIN)
              .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)
               .setContentText(text)
                .build();
        NotificationManager notificationManager =
                  (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
           notificationManager.notify(NOTIFICATION_ID, notification);

    }
}
