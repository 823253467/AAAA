package com.bwei.aaa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MK on 2017/11/6.
 */
public class Custom extends View{

    private Paint paint;

    public Custom(Context context) {
        super(context);
    }

    public Custom(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public Custom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int x = getWidth() / 2;
        int y = getHeight() / 2;
        for (int i = 0;i<10;i++){
            int sa = i;
        }
        int ra = 20;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);
        canvas.drawText("张",x,y,paint);


    }
}
