package com.bwie.mvpframework.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.mvpframework.R;
import com.bwie.mvpframework.bean.ZcBean;
import com.bwie.mvpframework.presenter.MyZcPresenter;
import com.bwie.mvpframework.view.ShowZCview;

public class ZcActivity extends AppCompatActivity implements ShowZCview, View.OnClickListener {

    private EditText mPhoneZc;
    private EditText mPwdZc;
    private Button mZhuceBt;
    MyZcPresenter presenter=new MyZcPresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        initView();


    }

    private void initView() {
        mPhoneZc = (EditText) findViewById(R.id.zc_phone);
        mPwdZc = (EditText) findViewById(R.id.zc_pwd);
        mZhuceBt = (Button) findViewById(R.id.bt_zhuce);
        mZhuceBt.setOnClickListener(this);
    }

    @Override
    public void ShowZcView(ZcBean bean) {
        Toast.makeText(ZcActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_zhuce:
                presenter.clickzc(mPhoneZc.getText().toString(),mPwdZc.getText().toString());
                break;
            default:
                break;
        }
    }
}
