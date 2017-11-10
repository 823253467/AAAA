package com.bwei.zhanghaoqing20171102;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MK on 2017/11/2.
 */
public class Drawview extends View{
    public float currentx=40;
    public float currenty=50;
    public float prex;
    public float prey;
    //之前坐标
    private Path mpath= new Path();//定义路径
    public Paint p; //定义画笔
    public Drawview(Context context) {
        super(context);
    }

    public Drawview(Context context, AttributeSet attrs) {
        super(context, attrs);

        //mycontext=context;
        p= new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);//将画笔设置为空心，才会画成曲线
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeWidth(5);//设置画笔宽度
        p.setAntiAlias(true);
    }

    public Drawview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint m=new Paint();
        m.setColor(Color.BLUE);
        canvas.drawCircle(currentx,currenty,15,m);
        canvas.drawPath(mpath,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {   //不断触发触摸屏事件，将监听到的信息都传入DrawView 组件
        currentx=event.getX();
        currenty=event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mpath.moveTo(currentx,currenty);
                prex = currentx;
                prey = currenty;
                break;
            case MotionEvent.ACTION_MOVE:
                mpath.quadTo(prex,prey,currentx,currenty);
                prex = currentx;
                prey = currenty;
                break;
            case MotionEvent.ACTION_UP:
                mpath.reset();
                break;
        }
        invalidate();
        return true;

    }
}
