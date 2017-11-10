package com.bwei.zhoukao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.zhoukao.MainActivity;
import com.bwei.zhoukao.R;
import com.bwei.zhoukao.bean.JavaBean;

/**
 * Created by MK on 2017/11/9.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHodelr>{
    Context context;
    JavaBean javaBean;
    private int left=0;
    private int rigeht=1;
    public MyAdapter(Context context, JavaBean javaBean) {
        this.context=context;
        this.javaBean=javaBean;
    }


   /* @Override
    public int getItemViewType(int position) {
        if (position==0){
            return left;
        }
        return rigeht;
    }*/

    @Override
    public MyHodelr onCreateViewHolder(ViewGroup parent, int viewType) {
        /*if (getItemViewType(viewType)==left){
            View view = View.inflate(context, R.layout.header_item, null);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
            return headerViewHolder;
        }else {*/
            View view = View.inflate(context, R.layout.item_layout, null);
            MyHodelr hodelr = new MyHodelr(view);
            return hodelr;
//        }
    }
    @Override
    public void onBindViewHolder(MyHodelr holder, final int position) {
        Glide.with(context)
                .load(javaBean.getSong_list().get(position).getPic_big())
                .into(holder.image01);
        holder.text01.setText(javaBean.getSong_list().get(position).getTitle());
        holder.text02.setText(javaBean.getSong_list().get(position).getAuthor());

        holder.image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onClickView(view,position);
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return javaBean.getSong_list()==null?0:javaBean.getSong_list().size();
    }

    class MyHodelr extends RecyclerView.ViewHolder {

        private final ImageView image01;
        private final TextView text01;
        private final TextView text02;

        public MyHodelr(View itemView) {
            super(itemView);
            image01 = (ImageView) itemView.findViewById(R.id.image01);
            text01 = (TextView) itemView.findViewById(R.id.text01);
            text02 = (TextView) itemView.findViewById(R.id.text02);
        }
    }
  /*  //头部 ViewHolder
   class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image01a);
        }
    }*/

    Listener listener;

    public void setIListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener{
        public void onClickView(View view,int position);
        public void longClickView(View view,int position);

    }
}
