package com.bwei.zhoukao01.model;

import com.bwei.zhoukao01.bean.JavaBean;
import com.bwei.zhoukao01.okhttp.AbstractUiCallBack;
import com.bwei.zhoukao01.okhttp.OkhttpUtils;

/**
 * Created by MK on 2017/11/10.
 */
public class MyModel{

    public void onRefresh(boolean up,ModuleCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://v.juhe.cn/toutiao/index?type=top&key=597b4f9dcb50e051fd725a9ec54d6653", new AbstractUiCallBack() {
            @Override
            public void success(Object o) {

            }

            @Override
            public void failure(Exception e) {

            }
        });
    }

    public  interface ModuleCallBack {
        public void success(JavaBean bean);
        public void failure(Exception bean);

    }
}
