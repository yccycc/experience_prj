package com.yctech.myapp.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.yctech.myapp.R;

import java.util.Arrays;
import java.util.List;

public class SpinnerTest extends Activity {
    private Spinner mSpinner;

    private void assignViews() {
        mSpinner = (Spinner) findViewById(R.id.spinner);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_test);
        assignViews();
        List<CharSequence> age_data = null;
        age_data = Arrays.asList(new CharSequence[] { "10岁以下", "10-20岁",
                "20-30岁", "30-40岁", "40-50岁", "50-60岁", "60岁以上" });
        ArrayAdapter arrayAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, age_data);
        mSpinner.setAdapter(arrayAdapter);
    }
}