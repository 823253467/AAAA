package com.bwei.mvptest01.medel;

import com.bwei.mvptest01.util.OkHttpUtils;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/8.
 */
public class MyLoginModel implements LoginMedl{
    @Override
    public void initdata(String mobile, String password, Callback callback) {
        OkHttpUtils.getInstance().doGet("http://120.27.23.105/user/login?mobile="+mobile+"&password="+password+"",callback);
    }
}
