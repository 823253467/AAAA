package com.bwei.usercenter;

import android.text.TextUtils;

/**
 * Created by MK on 2017/11/8.
 */
public class LoginPresenter {

    LoginView loginview;
    LoginModel loginmodel;
    public LoginPresenter(LoginView loginview) {
        this.loginview=loginview;
        loginmodel = new LoginModel();
    }

    public void detach(){
        this.loginview = null;
    }

    public void login(String phone, String pwd) {
        if (TextUtils.isEmpty(phone)){
            loginview.phoneEmpty();
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            loginview.passwordEmpty();
            return;
        }


        loginmodel.login(phone, pwd, new LoginModel.ModeleCallBack() {
            @Override
            public void success(String data) {
                    loginview.loginSuccess(data);
            }

            @Override
            public void failed(int code) {

                loginview.loginFailed(code);
            }
        });
    }
}
