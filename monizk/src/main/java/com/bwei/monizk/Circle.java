package com.bwei.monizk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by MK on 2017/11/5.
 */
public class Circle extends View{

    private Paint paint;
    private int progress = 0;
    Context context;
    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);

        /*new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){

                    if (press>=360){
                        return;
                    }
                    press +=10;

                    postInvalidate();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();*/
//        start();

    }
    public void start(final Context context){
        this.context=context;
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){


                    if(progress >= 360){

                        return;
                    }

                    progress += 10 ;

                    //子线程刷新 系统调用onDraw（） 方法
                    postInvalidate();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();


    }



    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int x = getWidth() / 2;
        int y = getHeight() / 2;

        int radius = 100;
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x,y,radius,paint);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(x - radius, y - radius, x + radius, y + radius);
        canvas.drawArc(rectF,-90,progress,false,paint);


        int text = (int) ((float) progress /360*100);
        paint.setStrokeWidth(1);
        paint.setTextSize(20);
        canvas.drawText(text+"%",x,y,paint);

        if (progress==360){
            Intent intent = new Intent(context, SecondActivity.class);
            context.startActivity(intent);

        }
    }




}
