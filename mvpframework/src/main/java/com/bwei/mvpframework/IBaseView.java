package com.bwei.mvpframework;

/**
 * Created by MK on 2017/11/7.
 */
public interface IBaseView {
    //Toast形式提示
    public void showMsg(String msg);
    //加载提示框
    public void    showLoading();
    //隐藏加载提示框
    public void hiddenLoading();
    //页面跳转
    public void jumpActivity();
    //返回
    public boolean back();
}
