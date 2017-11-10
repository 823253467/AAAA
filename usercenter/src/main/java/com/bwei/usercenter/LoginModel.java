package com.bwei.usercenter;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by MK on 2017/11/8.
 */
public class LoginModel {

    ModeleCallBack acallback;
    String phone;
    String pwd;
    public void login(String phone,String pwd,ModeleCallBack acallback){
        this.phone=phone;
        this.pwd=pwd;
        this.acallback=acallback;
        postEnqueue();
    }

    private void postEnqueue() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();
        RequestBody requestBody = new FormBody.Builder()
                .add("mobile",phone)
                .add("password",pwd)
                .build();
        final Request request = new Request.Builder().url("http://120.27.23.105/user/login")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                    acallback.failed(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();


               /* Gson gson = new Gson();

                JavaBean javaBean = gson.fromJson(string, JavaBean.class);

                //String username = javaBean.getData().getUsername();

                String mobile = javaBean.getData().getMobile();
                String password = javaBean.getData().getPassword();*/

                acallback.success(string);

            }
        });


    }


    interface ModeleCallBack{
        public void success(String data);
        public void failed(int code);
    }

}
