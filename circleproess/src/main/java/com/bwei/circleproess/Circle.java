package com.bwei.circleproess;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.RectF;
        import android.util.AttributeSet;
        import android.view.View;

/**
 * Created by MK on 2017/11/5.
 */
public class Circle extends View{

    private Paint paint;
    private int proess = 0;
    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    if (proess>=360){
                        return;
                    }
                    proess+=10;
//                    子线程更新调用 系统方法ondraw

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
        int bj = 200;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(x,y,bj,paint);


        paint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(x-bj,y-bj,x+bj,y+bj),-90,proess,false,paint);


        /*float t = proess / 360 * 100;
        int t1 = (int) t;*/
        //int text = (int) ((float)proess / 360  * 100 );
        int vext = (int) ((float) proess / 360 * 100);
        paint.setTextSize(30);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText(vext+"%",x,y,paint);
    }
}
