package com.bwei.zhoukao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwei.zhoukao.adapter.ItemDecoration;
import com.bwei.zhoukao.adapter.MyAdapter;
import com.bwei.zhoukao.bean.JavaBean;
import com.bwei.zhoukao.presenter.MyPresenter;
import com.bwei.zhoukao.view.ShowView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.widget.SpringView;

public class MainActivity extends AppCompatActivity implements ShowView {

    private MyPresenter myPresenter;
    private XRecyclerView recyclerView;
    private MyAdapter myAdapter;
    private SpringView springView;
   // private XRecyclerView x;
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (XRecyclerView) findViewById(R.id.recyclerview);

        myPresenter = new MyPresenter(this);
        myPresenter.show(i);
       // recyclerView.addHeaderView
        View view=View.inflate(MainActivity.this,R.layout.header_item,null);
        recyclerView.addHeaderView(view);

    }

    @Override
    public void ShowData(final JavaBean javaBean) {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(MainActivity.this, javaBean);

        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new ItemDecoration(MainActivity.this));
        myAdapter.setIListener(new MyAdapter.Listener() {
            @Override
            public void onClickView(View view, int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void longClickView(View view, int position) {

            }
        });

        springView = (SpringView) findViewById(R.id.springView);

        springView.setHeader(new DefaultFooter(this));
        springView.setFooter(new DefaultFooter(this));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {


                //下拉
                springView.onFinishFreshAndLoad();


                myPresenter.show(i++);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadmore() {

                springView.onFinishFreshAndLoad();
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myPresenter.can();
    }
}
