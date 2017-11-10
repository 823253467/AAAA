package com.bwei.mvplogin.presenter;

import com.bwei.mvplogin.MainActivity;
import com.bwei.mvplogin.bean.LoginBean;
import com.bwei.mvplogin.model.MyLoginView;
import com.bwei.mvplogin.view.LoginView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by MK on 2017/11/7.
 */
public class LoginPresenter {

    LoginView loginview;
    MyLoginView myLoginView;

    public LoginPresenter(LoginView loginview) {
        this.loginview=loginview;
        myLoginView = new MyLoginView();
    }
    public void sa(){
        this.loginview=null;
    }

    public void abc(String phone, String pwd) {
        myLoginView.initdata(phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(string, LoginBean.class);

                loginview.viewData(loginBean);
            }
        });
    }
}
