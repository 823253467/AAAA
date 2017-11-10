package com.bwei.mvptest01.medel;


import okhttp3.Callback;

/**
 * Created by MK on 2017/11/8.
 */
public interface LoginMedl {
    public void initdata(String mobile, String password , Callback callback);
}
