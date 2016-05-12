package bootcamp.android.demoapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {


//        Date d=new Date();
//        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
//        String currentDateTimeString = sdf.format(d);
//

        //--------------------------------------------
        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
        Date d=new Date();
        String currentDateTimeString = sdf.format(d);
        Date date = null;
        try {
            date = sdf.parse(currentDateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long startDate = date.getTime();

     //   Log.e("reciver", String.valueOf(startDate));

        //----------------------------------------


        Log.e("recive time nofi----->", String.valueOf(startDate));
        PreferenceHelper prefs = new PreferenceHelper(context);
        prefs.storeRecData(startDate);

        Intent notificationIntent = new Intent(context, NotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(NotificationActivity.class);
        stackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        Notification notification = builder.setContentTitle("Demo App Notification")
                .setContentText("New Notification From Demo App..")
                .setTicker("New Message Alert!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
