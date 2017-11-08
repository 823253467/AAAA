package com.bwei.recy.presenter;

import android.content.Context;

import com.bwei.recy.bean.JavaBean;
import com.bwei.recy.medel.MedelCass;
import com.bwei.recy.util.OnUiCallback;
import com.bwei.recy.view.Iview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;

/**
 * Created by MK on 2017/11/8.
 */
public class MyPresenter {

    Context context;
    Iview view;
    MedelCass medel;

    public MyPresenter(Iview view, Context context) {
        this.view = view;
        this.context = context;
        medel = new MedelCass();
    }

    public void MyPresenter(){
        medel.getData(new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                JavaBean javaBean = gson.fromJson(result, JavaBean.class);
                view.showData(javaBean);
            }
        });
    }

    public void abcd(){
        this.view=null;
    }

}
