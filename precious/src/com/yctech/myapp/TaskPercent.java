package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.yctech.myapp.component.GameUI;

public class TaskPercent extends Activity {

    private GameUI mMr;
    private Button mBtn;

    private void assignViews() {
        mMr = (GameUI) findViewById(R.id.mr);
        mBtn = (Button) findViewById(R.id.btn);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas2);
        assignViews();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMr.drawNotInOndraw();
            }
        });
    }
}