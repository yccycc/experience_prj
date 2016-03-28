package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Canvas2 extends Activity {
    private Button mBtn;
    int count;

    private void assignViews() {
        mBtn = (Button) findViewById(R.id.btn);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas2);
        assignViews();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtn.setText(count+++"");
            }
        });
    }
}