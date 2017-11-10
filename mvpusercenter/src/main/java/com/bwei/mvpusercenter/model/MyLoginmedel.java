package com.bwei.mvpusercenter.model;

import com.bwei.mvpusercenter.util.OkHttpUtils;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/8.
 */
public class MyLoginmedel implements Loginmodel{

    @Override
    public void initDta(String mobile, String password, Callback callback) {
        OkHttpUtils.getInstance().doGet("http://120.27.23.105/user/login?mobile="+mobile+"&password="+password+"",callback);
    }
}
