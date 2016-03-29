package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MoveRect extends View {
    private Paint mPaint;
    private Canvas mCanvas;
    private int count = 5;
    private Handler mHandler;
    private RectF rectF;
    private float strokeWid;

    public MoveRect(Context context) {
        super(context);
        init();
    }

    public MoveRect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mHandler = new Handler();
        new MoveThread().start();
        setBackgroundColor(Color.YELLOW);
        //
        rectF = new RectF(200,0,400,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mCanvas.drawRect(0, 0, 100, count++, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mCanvas.drawArc(rectF,0,360,false,mPaint);
    }

    class MoveThread extends Thread {
        float strokeWids[] ={1.0f,3.0f};
        int i =0;
        @Override
        public void run() {
            super.run();
            for (; ; ) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count >= 200) {
                    count = 10;
                }
                switch (++i%2)
                {
                    case 0:strokeWid = strokeWids[0];break;
                    case 1:strokeWid = strokeWids[1];break;
                }
                mPaint.setStrokeWidth(strokeWid);
                MoveRect.this.postInvalidate();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("w--h",event.getX()+"&"+event.getY());
        return super.onTouchEvent(event);
    }
}
