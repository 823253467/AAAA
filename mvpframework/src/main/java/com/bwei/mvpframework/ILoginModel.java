package com.bwei.mvpframework;

/**
 * Created by MK on 2017/11/7.
 */
public interface ILoginModel extends IBaseModel{
    /**
     *
     * @param username 用户名
     * @param pwd    密码
     * @param loginCallBack    登陆回调接口
     */
    public void login(String username,String pwd,ILoginCallBack loginCallBack);
    /**
     *    登陆回调接口及回调方法
     */
    interface ILoginCallBack {
        public void onStatus();
    }
}
