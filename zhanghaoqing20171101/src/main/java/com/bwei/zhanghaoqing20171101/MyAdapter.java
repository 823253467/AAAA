package com.bwei.zhanghaoqing20171101;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.zhanghaoqing20171101.appliaction.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by MK on 2017/11/1.
 */
public class MyAdapter extends BaseAdapter{
    List<DataDataBean.DataBean> list;
    private int left=0;
    private int rigeht=1;
    Context context;
    public MyAdapter(List<DataDataBean.DataBean> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return left;
        }
        return rigeht;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i)==left){
            ViewHolder01 holder;
            if (view==null){
                view = View.inflate(context,R.layout.left_item,null);

                holder = new ViewHolder01();

                holder.text01 = (TextView) view.findViewById(R.id.text01);

                holder.image01 = (ImageView) view.findViewById(R.id.image01);

                view.setTag(holder);
            }else {
                holder = (ViewHolder01) view.getTag();
            }

            holder.text01.setText(list.get(i).getTitle());
            ImageLoader.getInstance().displayImage(list.get(i).getImages(),holder.image01, ImageLoaderUtil.getoption());
        }else if (getItemViewType(i)==rigeht){
            ViewHolder02 holder;
            if (view==null){
                view = View.inflate(context,R.layout.right,null);

                holder = new ViewHolder02();

                holder.text01 = (TextView) view.findViewById(R.id.text01);



                view.setTag(holder);
            }else {
                holder = (ViewHolder02) view.getTag();
            }

            holder.text01.setText(list.get(i).getTitle());
        }
        return view;
    }
    class ViewHolder01{
        TextView text01;
        ImageView image01;
    }
    class ViewHolder02{
        TextView text01;

    }
}
