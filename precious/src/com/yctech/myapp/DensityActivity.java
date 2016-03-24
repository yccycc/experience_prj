package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class DensityActivity extends Activity {
    private WindowManager windowManager;
    private Display defaultDisplay;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        windowManager = getWindowManager();
        defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics metric = new DisplayMetrics();
        defaultDisplay.getMetrics(metric);
        Log.i("bitch", metric.widthPixels
                + "&" + metric.heightPixels
                + "&" + metric.densityDpi
                + "&" + metric.density
        );
    }
}
