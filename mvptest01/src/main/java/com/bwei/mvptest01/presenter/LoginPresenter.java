package com.bwei.mvptest01.presenter;

import android.content.Context;

import com.bwei.mvptest01.MainActivity;
import com.bwei.mvptest01.bean.Loginbean;
import com.bwei.mvptest01.medel.MyLoginModel;
import com.bwei.mvptest01.util.OnUiCallback;
import com.bwei.mvptest01.view.LoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by MK on 2017/11/8.
 */
public class LoginPresenter {
    Context context;
    LoginView loginView;
    MyLoginModel myLoginModel;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
        myLoginModel = new MyLoginModel();
    }


    public void abc(String phone, String pwd) {
        myLoginModel.initdata(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Loginbean loginbean = gson.fromJson(result, Loginbean.class);
                loginView.showData(loginbean);
            }
        });

    }
}
