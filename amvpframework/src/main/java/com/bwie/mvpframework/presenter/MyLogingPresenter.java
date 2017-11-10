package com.bwie.mvpframework.presenter;

import android.content.Context;

import com.bwie.mvpframework.bean.LoginBean;
import com.bwie.mvpframework.model.MyloginModel;
import com.bwie.mvpframework.utils.okhttp.okhttp.OnUiCallback;
import com.bwie.mvpframework.view.ShowLoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by asus on 2017/11/7.
 */

public class MyLogingPresenter {
    ShowLoginView view;
    Context context;
    MyloginModel model;

    public MyLogingPresenter(ShowLoginView view, Context context) {
        this.view = view;
        this.context = context;
        model=new MyloginModel();
    }

    public void login(String phone,String pwd){
        model.getNetData(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                LoginBean bean = gson.fromJson(result, LoginBean.class);
                view.showLogin(bean);
            }
        });
    }


}
