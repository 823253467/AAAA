package com.bwie.mvpframework.mview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvpframework.R;

public class MyHeadView extends RelativeLayout {
    String text;
    public MyHeadView(Context context) {
        super(context);
    }

    public MyHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=View.inflate(context,R.layout.zc_head_layout,null);
        addView(view);
        Button bt_back= view.findViewById(R.id.bt_back);
        Button bt_my=view.findViewById(R.id.my);
        TextView tv_head=view.findViewById(R.id.tv_head);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyHeadView);
        text= typedArray.getString(R.styleable.MyHeadView_Tittle_Text);
        tv_head.setText(text);
        typedArray.recycle();

    }
    public MyHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
