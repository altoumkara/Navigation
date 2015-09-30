package com.jg.navigationtest.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Utility class to represent common methods
 *
 * @author Alama Tounkara
 */
public class Util {
    public static final String TAG = "Util";


    /**
     * Used to read key-value in a share preference file name:  PREF_FILE_NAME
     *
     * @param context   is the context we are in
     * @param prefKey   the key for a specif value
     * @param prefValue the value associated with the key
     */
    public static void saveToSharePreference(Context context, String prefKey, String prefValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(prefKey, prefValue);
        editor.apply();//same as commit(), but faster, but dosent return result whether the commit was succefull or not
        //we could also use editor.commit(return result whether the commit was successful or not),

    }

    /**
     * Used to save key-value in a share preference file name:  PREF_FILE_NAME
     *
     * @param context      is the context we are in
     * @param prefKey      the key for a specif value
     * @param defaultValue default value to show if @prefKey associated value was not found
     * @return  String value   or   defaultValue
     */
    public static String readFromSharePreference(Context context, String prefKey, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(prefKey, defaultValue);
    }



    /**
     * Used to read key-value in a share preference file name:  PREF_FILE_NAME
     *
     * @param context   is the context we are in
     * @param prefKey   the key for a specif value
     * @param prefValue the value associated with the key
     */
    public static void saveToSharePreference(Context context, String prefKey, int prefValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(prefKey, prefValue);
        editor.apply();//same as commit(), but faster, but dosent return result whether the commit was succefull or not
        //we could also use editor.commit(return result whether the commit was successful or not),

    }

    /**
     * Used to save key-value in a share preference file name:  PREF_FILE_NAME
     *
     * @param context      is the context we are in
     * @param prefKey      the key for a specif value
     * @param defaultValue default value to show if @prefKey associated value was not found
     * @return  int value   or   defaultValue

     */
    public static int readFromSharePreference(Context context, String prefKey, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getInt(prefKey, defaultValue);
    }


    /**
     * display error msg
     * @param context the context in which you are calling this
     * @param message message to display
     */
    public static void displayError(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
