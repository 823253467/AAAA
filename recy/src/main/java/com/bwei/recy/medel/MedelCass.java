package com.bwei.recy.medel;

import com.bwei.recy.bean.JavaBean;
import com.bwei.recy.util.OkHttp3Utils;
import com.bwei.recy.util.OnUiCallback;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by MK on 2017/11/8.
 */
public class MedelCass implements IData{

    @Override
    public void getData(Callback callback) {
        OkHttp3Utils.doGet("http://m.yunifang.com/yunifang/mobile/home",callback);
    }


}
