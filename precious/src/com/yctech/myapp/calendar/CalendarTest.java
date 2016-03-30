package com.yctech.myapp.calendar;

import android.app.Activity;
import android.os.Bundle;
import com.yctech.myapp.R;

public class CalendarTest extends Activity implements DatePickerController {
    private DayPickerView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_test);

        calendarView = (DayPickerView) findViewById(R.id.calendar_view);
        calendarView.setController(this);
    }

    @Override
    public int getMaxYear() {
        return 0;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {

    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {

    }
}