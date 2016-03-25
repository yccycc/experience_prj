package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.yctech.myapp.R;

public class DrawView extends View {
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private RectF  mRectF = new RectF();

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
// 设置画笔相关属性
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.rgb(0xe9, 0xe9, 0xe9));
        canvas.drawColor(Color.TRANSPARENT);
        mPaint.setStrokeWidth(200);
        mPaint.setStyle(Paint.Style.FILL);
        // 位置
        mRectF.left = 10; // 左上角x
        mRectF.top = 10; // 左上角y
        mRectF.right = 100; // 左下角x
        mRectF.bottom =100; // 右下角y

        // 绘制圆圈，进度条背景
        canvas.drawArc(mRectF, 0, 60, true, mPaint);

        canvas.drawArc(mRectF, 60, 60, true, mPaint);
    }
}
