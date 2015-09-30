package com.jg.navigationtest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.jg.navigationtest.R;
import com.jg.navigationtest.utility.Constants;
import com.jg.navigationtest.utility.Util;

public class ColorPickedActivity extends AppCompatActivity {
    public static final String TAG = "ColorPickedActivity";

    private RelativeLayout mRelativeLayout;
    private String mDefaultColor;


    @Override
    protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_color_picked);
            mRelativeLayout = (RelativeLayout) findViewById(R.id.layout);
      //  mDefaultColor = Util.readFromSharePreference(this, Constants.CURRENT_COLOR,""+255);
        mDefaultColor =Integer.toHexString(Util.readFromSharePreference(this, Constants.CURRENT_COLOR,  255));
        Log.d(TAG, " mDefaultColor: " + mDefaultColor);

//        String hexValue = Integer.toHexString(mDefaultColor);
     //   Log.d(TAG, "  hexValue : " +  hexValue );
        mRelativeLayout.setBackgroundColor(Color.parseColor("#"+mDefaultColor));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                        setSupportActionBar(toolbar);


                        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
//    private Vector4f rgba;
//
//    public int toHex() {
//        String alpha = pad(Integer.toHexString((int) rgba.w));
//        String red = pad(Integer.toHexString((int) rgba.x));
//        String blue = pad(Integer.toHexString((int) rgba.y));
//        String green = pad(Integer.toHexString((int) rgba.z));
//        String hex = "0x" + alpha + red + blue + green;
//        return Integer.parseInt(hex, 16);
//    }
//
//    private static final String pad(String s) {
//        return (s.length() == 1) ? "0" + s : s;
//    }

}
