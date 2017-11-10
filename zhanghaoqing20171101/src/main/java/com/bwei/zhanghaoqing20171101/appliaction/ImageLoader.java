package com.bwei.zhanghaoqing20171101.appliaction;

import android.app.Application;

/**
 * Created by MK on 2017/11/1.
 */
public class ImageLoader extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtil.getInit(this);
    }
}
