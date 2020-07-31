package com.example.dongluong.democustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class demo extends View {
    public Paint paint;
    public RectF rectOval;
    private float count = 1.0f;

    public demo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public demo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public demo(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        paint = new Paint();
        paint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectOval = new RectF(getWidth() / 2 - getWidth() / 3, getHeight() / 2 - getWidth() / 3,
                getWidth() / 2 + getWidth() / 3, getHeight() / 2 + getWidth() / 3);
    }

    public void init() {

    }

    public void setCount(float count) {
        this.count = count;
        invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // hình tròn
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(30);
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 50, paint);

        paint.setStrokeWidth(20);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 3, paint);

        // hình vuông

        Rect rect = new Rect(10, 10, getWidth() - 10, getHeight() - 10);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect, paint);

        // đường thẳng
        paint.setColor(Color.YELLOW);
        canvas.drawLine(100, 100, getWidth() - 100, getHeight() - 100, paint);

        // vẽ oval
        paint.setColor(Color.RED);
        canvas.drawArc(rectOval, 0f, 20f * count, false, paint);


        canvas.drawARGB(20, 20, 20, 20);

        // vẽ chữ
        paint.setColor(Color.YELLOW);
        paint.setTextSize(200);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("orange", 200, 200, paint);

        canvas.rotate(100, 200, 200);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if((event.getX() >getWidth() / 2 -50 && event.getX() < getWidth() / 2 +50 )&&
                    (event.getY() > getHeight()/2 -50 && event.getY() < getHeight()/2 +50)){
                Log.d("123", "onTouchEvent: ssssssssss");
            }
        }
        return super.onTouchEvent(event);
    }
}
