package com.bwei.monizk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by MK on 2017/11/5.
 */
public class Title extends LinearLayout{
    public Title(Context context) {
        this(context,null);
    }

    public Title(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Title(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.title_item, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(view);

        Button btn_left = (Button) view.findViewById(R.id.btn_left);
        Button btn_right = (Button) view.findViewById(R.id.btn_right);

        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                my.leftClick();
            }
        });
        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                my.rightClick();

            }
        });
    }
    private MyCallBack my;
    public void setMy(MyCallBack my){
        this.my=my;
    }
    /*public interface MyCallBack{
        public void leftClick();
        public void rightClick();
    }*/
}
