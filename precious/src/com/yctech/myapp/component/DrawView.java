package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import com.yctech.myapp.R;

public class DrawView extends View {
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    public DrawView(Context context) {
        super(context);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // TODO Auto-generated method stub

        mPaint.setColor(Color.RED);
        //设置字体大小
        mPaint.setTextSize(100);

        //让画出的图形是空心的
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画出的线的 粗细程度
        mPaint.setStrokeWidth(5);
        //画出一根线
        canvas.drawLine(0, 0, 200, 800, mPaint);

        //画矩形
        canvas.drawRect(200, 300, 300, 320, mPaint);

        //画圆
        canvas.drawCircle(200, 800, 100, mPaint);
        //画出字符串 drawText(String text, float x, float y, Paint paint)
        // y 是 基准线 ，不是 字符串的 底部
        canvas.drawText("apple", 60, 600, mPaint);
        canvas.drawLine(60, 60, 500, 60, mPaint);

        //绘制图片
        canvas.drawBitmap(mBitmap, 150, 150, mPaint);

        super.onDraw(canvas);
    }
}
