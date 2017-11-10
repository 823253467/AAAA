package com.bwei.zhanghaoqing20171031;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by MK on 2017/10/31.
 */
public class CustomTextView extends TextView{

    private int textSize;
    private int color;
    private String text;
    private Paint mPaint;
    private Rect mRect;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

       TypedArray typedArray =  context.obtainStyledAttributes(attrs,R.styleable.CustomTextView);

        int count = typedArray.getIndexCount();

        for (int i=0;i<count;i++){
           int attr =  typedArray.getIndex(i);

            switch (attr){
                case R.styleable.CustomTextView_text:
                    text = typedArray.getString(attr);
                    break;
                case R.styleable.CustomTextView_textColor:
                    color = typedArray.getInt(attr, Color.BLUE);
                    break;
                case R.styleable.CustomTextView_textSize:
                    textSize = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(textSize);

        mRect = new Rect();
        mPaint.getTextBounds(text,0,text.length(),mRect);

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        System.out.println("w = "+ w + " " + h + " " +oldh + " "+oldh);

    }

   @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        /*int wi = MeasureSpec.getMode(widthMeasureSpec);
        int he = MeasureSpec.getMode(heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        System.out.println("width = " + width);
        System.out.println("height = " + height);*/

       setMeasuredDimension(100,100);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       /* int width = getWidth();
        int height = getHeight();

        int width1 = mRect.width();
        int height1 = mRect.height();


        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        mPaint.setColor(color);

        canvas.drawText(text,(getWidth()-mRect.width())/2,(getHeight()+mRect.height())/2,mPaint);*/
       // canvas.drawText(text,(getWidth()-mRect.width())/2,(getHeight()+mRect.height())/2,mPaint);



    }
  /* @Override
   protected void onDraw(Canvas canvas) {
       super.onDraw(canvas);
       Paint paint=new Paint();
       Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.a);
       canvas.drawBitmap(bitmap,0,0,paint);
       if (bitmap.isRecycled()){
           bitmap.recycle();
       }
   }*/
}
