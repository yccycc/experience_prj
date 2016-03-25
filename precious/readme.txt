ldpi：240x320

mdpi：320x480
hdpi：480x800、480x854
xhdpi：至少960*720
xxhdpi：1280×720
//  // TODO Auto-generated method stub

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
//
  mPaint.setColor(Color.RED);
        //实心
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2, getHeight()/2, 100, mPaint);
        ??????????????????????????????????????????????


