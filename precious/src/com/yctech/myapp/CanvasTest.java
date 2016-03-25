package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.yctech.myapp.component.DrawView;

public class CanvasTest extends Activity {
    private DrawView mDvYcc;
    private EditText mParta;
    private EditText mPartb;
    private Button mDrawConfirm;

    private void assignViews() {
        mDvYcc = (DrawView) findViewById(R.id.dv_ycc);
        mParta = (EditText) findViewById(R.id.parta);
        mPartb = (EditText) findViewById(R.id.partb);
        mDrawConfirm = (Button) findViewById(R.id.draw_confirm);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_test);
        assignViews();
        mDrawConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aValue = Integer.parseInt(mParta.getText().toString());
                int bValue = Integer.parseInt(mPartb.getText().toString());
                mDvYcc.dividerTwoParts(aValue, bValue);
            }
        });
    }
}