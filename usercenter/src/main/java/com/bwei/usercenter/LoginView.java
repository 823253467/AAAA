package com.bwei.usercenter;

/**
 * Created by MK on 2017/11/8.
 */
public interface LoginView {
    public void phoneEmpty();
    public void passwordEmpty();
    public void loginSuccess(Object object);
    public void loginFailed(int code);
}
