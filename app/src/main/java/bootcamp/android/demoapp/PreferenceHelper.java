/**
 * @author Jenish Khanpara
 */

package bootcamp.android.demoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by JENISH KHANPARA on 12/07/2015.
 */
public class PreferenceHelper {

    private final String PREFS_IS_CONFIGURE = "isConfigure";
    private SharedPreferences prefs;


    public PreferenceHelper(Context ctx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static PreferenceHelper newInstance(Context ctx) {
        return new PreferenceHelper(ctx);
    }


    public boolean isConfigure() {
        return prefs.getBoolean(PREFS_IS_CONFIGURE, false);
    }

    public void setConfigure(boolean value) {
        prefs.edit().putBoolean(PREFS_IS_CONFIGURE, value).commit();
    }

    public void clearAllPrefs() {
        prefs.edit().clear().commit();
    }

    public void storeData(long currentDateTimeString) {


        prefs.edit().putLong("sdate", currentDateTimeString).commit();
    }

    public void storeRecData(long currentDateTimeString) {

        prefs.edit().putLong("rdate", currentDateTimeString).commit();
    }

    public long GetRecData() {

        long a = prefs.getLong("sdate", 0);
//        String b = prefs.getString("rdate", "No name defined");
        return a;
    }

    public long GetSendData() {

        long b = prefs.getLong("rdate",0);
//        String b = prefs.getString("rdate", "No name defined");
        return b;
    }
}