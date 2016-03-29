package com.yctech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.yctech.myapp.component.TaskPie;

public class TaskPercent extends Activity {
    private TaskPie mTaskPieView;
    private Button mSetCountdownDaysBtn;
    private EditText mCountdownDaysEt;

    private void assignViews() {
        mTaskPieView = (TaskPie) findViewById(R.id.task_pie_view);
        mSetCountdownDaysBtn = (Button) findViewById(R.id.set_countdown_days_btn);
        mCountdownDaysEt = (EditText) findViewById(R.id.countdown_days_et);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_percent);
        assignViews();
        mSetCountdownDaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTaskPieView.setmCountDownDay(mCountdownDaysEt.getText().toString());
            }
        });
    }
}