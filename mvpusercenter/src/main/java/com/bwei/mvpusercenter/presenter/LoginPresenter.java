package com.bwei.mvpusercenter.presenter;

import android.content.Context;

import com.bwei.mvpusercenter.activity.MainActivity;
import com.bwei.mvpusercenter.bean.Loginbean;
import com.bwei.mvpusercenter.model.MyLoginmedel;
import com.bwei.mvpusercenter.util.OnUiCallback;
import com.bwei.mvpusercenter.view.LoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by MK on 2017/11/8.
 */
public class LoginPresenter {
    Context context;
    LoginView loginview;
    private final MyLoginmedel myLoginmedel;

    public LoginPresenter(Context context, LoginView loginview) {
        this.context = context;
        this.loginview = loginview;
        myLoginmedel = new MyLoginmedel();

    }

    public void abc(String phone, String pwd) {

        myLoginmedel.initDta(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Loginbean loginbean = gson.fromJson(result, Loginbean.class);

                loginview.showData(loginbean);


            }
        });
    }
}
