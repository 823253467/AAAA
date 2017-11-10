package com.bwie.mvpframework.model;

import okhttp3.Callback;

/**
 * Created by asus on 2017/11/7.
 */

public interface IZCmodel {
    public void getnetZCdata(String phone, String pwd, Callback callback);
}
