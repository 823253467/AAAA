package com.bwei.zhoukao01.model;

import com.bwei.zhoukao01.bean.JavaBean;

/**
 * Created by MK on 2017/11/10.
 */
public interface IModel {
    public void success(JavaBean javaBean);
    public void success(Exception javaBean);
}
