package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.yctech.myapp.R;

public class DrawView extends View {
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED);
        //设置字体大小
        mPaint.setTextSize(100);
        //设置画出的线的 粗细程度
        mPaint.setStrokeWidth(5);
        //draw circle
        //让画出的图形是空心的
        //mPaint.setStyle(Paint.Style.STROKE);
        //实心
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2, getHeight()/2, 100, mPaint);
        //
    }
}
