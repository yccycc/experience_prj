package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import com.yctech.myapp.component.DrawView;

public class CanvasTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(CanvasTest.this));

    }
}