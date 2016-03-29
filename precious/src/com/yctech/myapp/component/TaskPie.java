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
    private RectF mInnerCircleRect = new RectF(mMidSideLen+mOutSideLen,mMidSideLen+mOutSideLen,
            2*mInnerSideLen+mMidSideLen+mOutSideLen,
            2*mInnerSideLen+mMidSideLen+mOutSideLen);
    private int mPartCircleBeginAngle = 130;
    private int mCircleAngleIncrement = 280/18;
    private int mDoneSectorNums = 6;
    private int mSectorColorSet[] ={Color.YELLOW,Color.BLUE};
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
        mCanvas.drawArc(mInnerCircleRect,0,360,false,mPaint);
        //draw mid circle
        mCanvas.drawArc(mMidCircleRect,mPartCircleBeginAngle,280,false,mPaint);
        //draw out circle
        mCanvas.drawArc(mOutCircleRect,mPartCircleBeginAngle,280,false,mPaint);
        //draw sector
        mPaint.setStyle(Paint.Style.FILL);
        for(int i =0;i<mDoneSectorNums;i++)
        {
            mPaint.setColor(mSectorColorSet[i%2]);
            mCanvas.drawArc(mMidCircleRect,mPartCircleBeginAngle+mCircleAngleIncrement*i,mCircleAngleIncrement,true,mPaint);
        }
    }

}
