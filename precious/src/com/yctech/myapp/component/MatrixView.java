package com.yctech.myapp.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.yctech.myapp.R;

public class MatrixView extends View {

    private Bitmap mBitmap;

    private Matrix mMatrix = new Matrix();

    public MatrixView(Context context) {

        super(context);

        initialize();

    }

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize() {

        mBitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();

        float cosValue = (float) Math.cos(-Math.PI/6);

        float sinValue = (float) Math.sin(-Math.PI/6);

        mMatrix.setValues(

                new float[]{

                        cosValue, -sinValue, 100,

                        sinValue, cosValue, 100,

                        0, 0, 2});

    }

    @Override protected void onDraw(Canvas canvas) {

//      super.onDraw(canvas);  //当然，如果界面上还有其他元素需要绘制，只需要将这句话写上就行了。

        canvas.drawBitmap(mBitmap, mMatrix, null);

    }

}