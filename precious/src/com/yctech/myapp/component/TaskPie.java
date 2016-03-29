package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TaskPie extends View {
    private int mOutSideLen = 10;
    private int mMidSideLen = 80;
    private int mInnerSideLen = 30;
    private int mInnerCircleRadius = mInnerSideLen;
    private int mInnerCircleX= mOutSideLen+mMidSideLen+mInnerSideLen,mInnerCircleY = mInnerCircleX;
    private Paint mPaint = new Paint();
    private Canvas mCanvas;
    private RectF mMidCircleRect = new RectF(mOutSideLen,mOutSideLen,mOutSideLen+2*(mMidSideLen+mInnerSideLen),
            mOutSideLen+2*(mInnerSideLen+mMidSideLen));
    private RectF mOutCircleRect = new RectF(0,0,2*(mMidSideLen+mInnerSideLen+mOutSideLen),
            2*(mInnerSideLen+mMidSideLen+mOutSideLen));
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
        //draw inner circle
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(mInnerCircleX,mInnerCircleY,mInnerCircleRadius,mPaint);
        //draw mid circle
        mCanvas.drawArc(mMidCircleRect,130,280,false,mPaint);
        //draw out circle
        mCanvas.drawArc(mOutCircleRect,130,280,false,mPaint);
        //draw sector
        mPaint.setStyle(Paint.Style.FILL);
        mCanvas.drawArc(mMidCircleRect,130,280,true,mPaint);
    }

}
