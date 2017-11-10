package com.bwei.mvpusercenter.model;

import okhttp3.Callback;

/**
 * Created by MK on 2017/11/8.
 */
public interface Loginmodel {
    public void initDta(String mobile, String password, Callback callback);
}
