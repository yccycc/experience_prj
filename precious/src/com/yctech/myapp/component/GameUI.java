package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameUI extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private RenderThread renderThread;
    private boolean isDraw = false;// 控制绘制的开关
    private Paint mPaint = new Paint();
    private int count = 10;

    public GameUI(Context context) {
        super(context);
        holder = this.getHolder();
        holder.addCallback(this);

        renderThread = new RenderThread();
    }

    public GameUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = this.getHolder();
        holder.addCallback(this);

        renderThread = new RenderThread();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDraw = true;
        renderThread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDraw = false;

    }

    /**
     * 绘制界面的线程
     *
     * @author Administrator
     *
     */
    private class RenderThread extends Thread {
        @Override
        public void run() {
            // 不停绘制界面
            while (isDraw) {
                drawUI();
            }
            super.run();
        }
    }

    /**
     * 界面绘制
     */
    public void drawUI() {
        Canvas canvas = holder.lockCanvas();
        try {
            drawCanvas(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawCanvas(Canvas canvas) {
        // 在 canvas 上绘制需要的图形
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        if(count==100)
        {
            count = 10;
        }
        canvas.drawRect(0, 0, 100, count++, mPaint);
    }
}
