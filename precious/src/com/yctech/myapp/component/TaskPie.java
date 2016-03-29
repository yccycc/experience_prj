package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TaskPie extends View {
    private int mCountDownTextMl = 252;
    private int mCountDownTextMt = 513;
    private String mCountDownDay = "3";
    private Paint mPaint = new Paint();
    private Canvas mCanvas;
    private int mCircleX = 360;
    private int mCircleY = 286;
    private int mInsideCircleRadius = 53;
    private int mOutsideCircleRadius = 180;
    private int mMidCircleRadius = 170;
    public TaskPie(Context context) {
        super(context);
    }

    public TaskPie(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(20);
        mCanvas.drawText("距离抄表截止日还有",mCountDownTextMl,mCountDownTextMt,mPaint);
        //
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(25);
        mCanvas.drawText(mCountDownDay+"",185+mCountDownTextMl,mCountDownTextMt,mPaint);
        //
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(20);
        mCanvas.drawText("天",202+mCountDownTextMl,mCountDownTextMt,mPaint);
        //
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(mCircleX,mCircleY,mInsideCircleRadius,mPaint);
        //
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawText("97%",347,290,mPaint);
    }










    public int getmCountDownTextMl() {
        return mCountDownTextMl;
    }

    public void setmCountDownTextMl(int mCountDownTextMl) {
        this.mCountDownTextMl = mCountDownTextMl;
    }

    public int getmCountDownTextMt() {
        return mCountDownTextMt;
    }

    public void setmCountDownTextMt(int mCountDownTextMt) {
        this.mCountDownTextMt = mCountDownTextMt;
    }

    public Paint getmPaint() {
        return mPaint;
    }

    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    public Canvas getmCanvas() {
        return mCanvas;
    }

    public String getmCountDownDay() {
        return mCountDownDay;
    }

    public void setmCountDownDay(String mCountDownDay) {
        this.mCountDownDay = mCountDownDay;
        postInvalidate();
    }

    public void setmCanvas(Canvas mCanvas) {
        this.mCanvas = mCanvas;
    }
}
