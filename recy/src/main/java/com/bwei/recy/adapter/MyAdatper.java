package com.bwei.recy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.recy.R;
import com.bwei.recy.bean.JavaBean;

/**
 * Created by MK on 2017/11/8.
 */
public class MyAdatper extends RecyclerView.Adapter<MyAdatper.MyHolder> {
    Context context;
    JavaBean bean;

    public MyAdatper(Context context, JavaBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_layout,null);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.item_tv.setText(bean.getData().getSubjects().get(position).getDetail());
        Glide.with(context)
                .load(bean.getData().getSubjects().get(position).getImage())
                .into(holder.item_iv);
    }

    @Override
    public int getItemCount() {
        return bean.getData().getSubjects()==null?0:bean.getData().getSubjects().size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView item_iv;
        TextView item_tv;
        public MyHolder(View itemView) {
            super(itemView);
            item_iv= (ImageView) itemView.findViewById(R.id.item_iv);
            item_tv= (TextView) itemView.findViewById(R.id.item_tv);

        }
    }
}
