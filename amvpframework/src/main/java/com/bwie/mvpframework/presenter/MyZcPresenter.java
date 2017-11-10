package com.bwie.mvpframework.presenter;

import android.content.Context;

import com.bwie.mvpframework.bean.ZcBean;
import com.bwie.mvpframework.model.MyZcModel;
import com.bwie.mvpframework.utils.okhttp.okhttp.OnUiCallback;
import com.bwie.mvpframework.view.ShowZCview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by asus on 2017/11/7.
 */

public class MyZcPresenter {
    Context context;
    MyZcModel model;
    ShowZCview view;

    public MyZcPresenter(Context context, ShowZCview view) {
        this.context = context;
        this.view = view;
        model=new MyZcModel();
    }
    public void clickzc(String phone,String pwd ){
        model.getnetZCdata(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ZcBean bean = gson.fromJson(result, ZcBean.class);
                view.ShowZcView(bean);
            }
        });
    }

}
