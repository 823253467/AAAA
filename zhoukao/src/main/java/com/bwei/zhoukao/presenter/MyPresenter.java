package com.bwei.zhoukao.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bwei.zhoukao.MainActivity;
import com.bwei.zhoukao.bean.JavaBean;
import com.bwei.zhoukao.model.MyDataModel;
import com.bwei.zhoukao.util.OnUiCallback;
import com.bwei.zhoukao.view.ShowView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by MK on 2017/11/9.
 */
public class MyPresenter {
    ShowView showview;
   MyDataModel myDataModel;
   /* private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                JavaBean javaBean = (JavaBean) msg.obj;

            }
        }
    };*/
    public MyPresenter(ShowView showview) {
        this.showview=showview;
        myDataModel = new MyDataModel();
    }

    public void can(){
        this.showview=null;
    }
    public void show(int i) {
//        myDataModel.getData();
        myDataModel.getData(i,new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {

               // String string = response.body().string();
                Gson gson = new Gson();
                JavaBean javaBean = gson.fromJson(result, JavaBean.class);
                if (javaBean!=null&&javaBean.getSong_list()!=null){
                    //Log.i("sas",javaBean.getSong_list().get(3).getTitle());
                    showview.ShowData(javaBean);
                }

            }
        });
    }
}
