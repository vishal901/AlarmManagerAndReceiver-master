package bootcamp.android.demoapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity {


   public static  AlarmManager alarmManager;

    public static  PendingIntent broadcast;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.txt);

        PreferenceHelper prefs = new PreferenceHelper(MainActivity.this);

        if (prefs.isConfigure()) {

            Toast.makeText(MainActivity.this, "set thai gayu", Toast.LENGTH_SHORT).show();
            textView.setText("nofification open kareli se");


        } else {
            Toast.makeText(MainActivity.this, "set thai nathi thayu", Toast.LENGTH_SHORT).show();

            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            notificationIntent.addCategory("android.intent.category.DEFAULT");

            broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE, 2);

            long i = cal.getTimeInMillis();



       // SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");


//        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
//        Date d=new Date();
//        String currentDateTimeString = sdf.format(d);
//        Date date = null;
//        try {
//            date = sdf.parse(currentDateTimeString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        long startDate = date.getTime();
//
//        Log.e("dghfuyfuyf", String.valueOf(startDate));

//        String dateString = "05:20:10";
//        SimpleDateFormat sdfa = new SimpleDateFormat("hh:mm:ss");
//        Date datea = null;
//        try {
//            datea = sdfa.parse(dateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        long startDatess = datea.getTime();
//
////
//         Log.e("wetertertgertr------->", String.valueOf(startDatess));
//
//        prefs.storeData(currentDateTimeString);

//        cal.getTime();
//
//        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
//        Log.e("time------->", String.valueOf(cal.getTime()));
//
//
//        Long tsLong = System.currentTimeMillis()/1000;
//        String ts = tsLong.toString();
//        Log.e("abababbab------->", currentDateTimeString);


//        int hours = new Time(System.currentTimeMillis()).getHours();
//
//        Log.e("time------->", String.valueOf(cal.getTime()));
//
//        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => " + hours);


            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  2*60*1000, broadcast);



            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
            }
       }



    }


}
