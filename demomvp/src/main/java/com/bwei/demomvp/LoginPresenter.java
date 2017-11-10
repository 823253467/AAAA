package com.bwei.demomvp;

import android.text.TextUtils;

/**
 * Created by MK on 2017/11/5.
 */
public class LoginPresenter {

    private LoginView loginView ;
    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }
    public void login(String phone,String password){

        if(TextUtils.isEmpty(phone)){
            loginView.phoneEmpty();
            return;
        }

        if(TextUtils.isEmpty(password)){
            loginView.passwordEmpty();
            return;
        }
    }

}
