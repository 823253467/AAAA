package com.bwei.democircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MK on 2017/11/2.
 */
public class CircleView extends View{
    public CircleView(Context context) {
        super(context);
    }
    Paint mpaint;
    int x;
    int y;
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       /* x = MeasureSpec.getSize(widthMeasureSpec) / 2 ;
        y = MeasureSpec.getSize(heightMeasureSpec) / 2 ;*/
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xx = getWidth()/2;
        canvas.drawCircle(xx,xx,100,mpaint);
    }
}
