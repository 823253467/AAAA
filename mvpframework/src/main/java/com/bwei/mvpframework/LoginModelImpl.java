package com.bwei.mvpframework;

import android.os.AsyncTask;

/**
 * Created by MK on 2017/11/7.
 */
public class LoginModelImpl implements ILoginModel{
    public int status = ILoginModel.STATUS_NORMAL;    //记录登陆状态
    public String msg;    //登陆操作后的提示语


    public void login(final String username, final String pwd,
                      final ILoginModel.ILoginCallBack loginCallBack) {
        if (status == ILoginModel.STATUS_VERIFY_ING) {
            return;
        }
        new AsyncTask<Void, Void, ILoginModel.ILoginCallBack>() {

            @Override
            protected void onPreExecute() {
                // TODO Auto-generated method stub
                super.onPreExecute();
            }

            @Override
            protected ILoginModel.ILoginCallBack doInBackground(Void... params) {
                // TODO Auto-generated method stub
                //具体的业务实现
                if (username.equals("123") && pwd.equals("123")) {
                    status = ILoginModel.STATUS_SUCCESS;
                    msg = "登陸成功";
                } else {
                    msg = "用户名或密码错误";
                    status = ILoginModel.STATUS_FAIL;
                }
                return loginCallBack;
            }

            @Override
            protected void onPostExecute(ILoginModel.ILoginCallBack result) {
                // TODO Auto-generated method stub
                loginCallBack.onStatus();    //登陆成功后进行接口回调，告诉presenter对view操作进行界面操作
                super.onPostExecute(result);
            }

        }.execute();
    }
}
