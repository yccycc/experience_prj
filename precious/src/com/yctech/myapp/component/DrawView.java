package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DrawView extends View {
    private Paint mPaint = new Paint();
    private RectF  mRectF = new RectF();
    private int mWidth;
    private int mHeight;
    private int mPartAStopAngle = 60;
    private Canvas mCanvas;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        mWidth = getWidth();
        mHeight = getHeight();
        // 设置画笔相关属性
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        // 位置
        Log.i("goddes",mHeight+"");
        mRectF.left = 20; // 左上角x
        mRectF.top = 0; // 左上角y
        mRectF.right = mWidth-20; // 左下角x
        mRectF.bottom =mWidth-40; // 右下角y

        mCanvas.drawArc(mRectF, 0, mPartAStopAngle, true, mPaint);
        //
        mPaint.setColor(Color.RED);
        mCanvas.drawArc(mRectF, mPartAStopAngle, 360 - mPartAStopAngle, true, mPaint);
    }

    public void dividerTwoParts(int partA,int partB)
    {
        mPartAStopAngle = (int) ((partA+0.0)/(partA+partB+0.0)*360);
        invalidate();
    }
}


