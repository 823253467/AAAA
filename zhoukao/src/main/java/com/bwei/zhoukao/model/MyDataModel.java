package com.bwei.zhoukao.model;

import com.bwei.zhoukao.util.OkHttp3Utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by MK on 2017/11/9.
 */
public class MyDataModel implements IData{
    @Override
    public void getData(int type,Callback callback) {
        /*OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .addHeader("User_Agent","")
                .url("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);*/
        OkHttp3Utils.doGet("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type="+type+"&size=10&offset=0",callback);
    }


}
