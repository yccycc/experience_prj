package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.yctech.myapp.R;

public class ShaderView extends View{
    Bitmap mBitmap = null;                              //Bitmap对象
    Shader mBitmapShader = null;               //Bitmap渲染对象
    Shader mLinearGradient = null;             //线性渐变渲染对象
    Shader mComposeShader = null;           //混合渲染对象
    Shader mRadialGradient = null;             //环形渲染对象
    Shader mSweepGradient = null;             //梯度渲染对象

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载图像资源
        mBitmap = ((BitmapDrawable) getResources().
                getDrawable(R.drawable.ic_launcher)).getBitmap();

        //创建Bitmap渲染对象
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT,
                Shader.TileMode.MIRROR);

        //创建线性渲染对象
        int mColorLinear[] = {Color.RED, Color.GREEN};
        mLinearGradient = new LinearGradient(0, 0, 20, 20, mColorLinear, null,
                Shader.TileMode.CLAMP);

        //创建环形渲染对象
        int mColorRadial[] = {Color.GREEN, Color.RED, Color.BLUE, Color.WHITE};
        mRadialGradient = new RadialGradient(350, 325, 75, mColorRadial, null,
                Shader.TileMode.REPEAT);

        //创建混合渲染对象
        mComposeShader = new ComposeShader(mLinearGradient, mRadialGradient,
                PorterDuff.Mode.DARKEN);

        //创建梯形渲染对象
        int mColorSweep[] = {Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
        mSweepGradient = new SweepGradient(370, 495, mColorSweep, null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mPaint = new Paint();
        canvas.drawColor(Color.GRAY);      //背景置为灰色

        //绘制Bitmap渲染的椭圆
        mPaint.setShader(mBitmapShader);
        canvas.drawOval(new RectF(90, 20, 90+mBitmap.getWidth(),
                20+mBitmap.getHeight()), mPaint);

        //绘制线性渐变的矩形
        mPaint.setShader(mLinearGradient);
        canvas.drawRect(10, 250, 250, 400, mPaint);

        //绘制环形渐变的圆
        mPaint.setShader(mRadialGradient);
        canvas.drawCircle(350, 325, 75, mPaint);

        //绘制混合渐变(线性与环形混合)的矩形
        mPaint.setShader(mComposeShader);
        canvas.drawRect(10, 420, 250, 570, mPaint);

        //绘制梯形渐变的矩形
        mPaint.setShader(mSweepGradient);
        canvas.drawRect(270, 420, 470, 570, mPaint);
    }
}
