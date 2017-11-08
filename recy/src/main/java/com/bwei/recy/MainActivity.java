package com.bwei.recy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.recy.adapter.MyAdatper;
import com.bwei.recy.bean.JavaBean;
import com.bwei.recy.presenter.MyPresenter;
import com.bwei.recy.view.Iview;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements Iview{
    MyPresenter presenter=new MyPresenter(this,this);
    RecyclerView rv;
    private MyAdatper myAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= (RecyclerView) findViewById(R.id.rv);
        presenter.MyPresenter();


    }

    @Override
    public void showData(JavaBean javaBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        myAdatper = new MyAdatper(MainActivity.this,javaBean);

        rv.setAdapter(myAdatper);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.abcd();
    }
}
