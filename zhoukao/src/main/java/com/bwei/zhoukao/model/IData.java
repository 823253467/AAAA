package com.bwei.zhoukao.model;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/9.
 */
public interface IData {
    public void getData(int type,Callback callback);
}
