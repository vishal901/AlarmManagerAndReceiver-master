package bootcamp.android.demoapp;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);

//        Date d=new Date();
//        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
//        String currentDateTimeString = sdf.format(d);
//
        //-----------------------------------------------
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

        Log.e("dghfuyfuyf", String.valueOf(startDate));

        //---------------------------------------------

        PreferenceHelper prefs = new PreferenceHelper(NotificationActivity.this);
        prefs.storeData(startDate);

        Log.e("open nofi time------->", currentDateTimeString);

       long aa = prefs.GetRecData();
        long bb = prefs.GetSendData();

        //bb e recive time nofi
        // aa e open nofi time-
        Log.e("open nofi time", String.valueOf(aa));
        Log.e("recive time nofi", String.valueOf(bb));

        long opennofitime = aa;
        long recivetimenofi = bb;

        long difference = opennofitime - recivetimenofi;
        int days = (int) (difference / (1000 * 60 * 60 * 24));
        int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);

        Log.e("difffrent",""+min);

        if (min <30){

            Toast.makeText(NotificationActivity.this, "diffternt  se", Toast.LENGTH_SHORT).show();
            //PreferenceHelper prefs = new PreferenceHelper(NotificationActivity.this);
            prefs.setConfigure(true);

            MainActivity.alarmManager.cancel(MainActivity.broadcast);

        }else {

            Toast.makeText(NotificationActivity.this, "diffternt wharew se ", Toast.LENGTH_SHORT).show();
        }


//        PreferenceHelper prefs = new PreferenceHelper(NotificationActivity.this);
//        prefs.setConfigure(true);

    }
}
