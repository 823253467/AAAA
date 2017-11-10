package com.bwie.mvpframework.model;

import com.bwie.mvpframework.utils.okhttp.okhttp.OkHttp3Utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

/**
 * Created by asus on 2017/11/7.
 */

public class MyloginModel implements Ilogin {

        @Override
        public void getNetData(String phone, String pwd, Callback callback) {
                Map<String,String> map=new HashMap<>();
                map.put("mobile",phone);
                map.put("password",pwd);
                OkHttp3Utils.doPost("http://120.27.23.105/user/login",map,callback);
        }
}
