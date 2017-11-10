package com.bwie.mvpframework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.mvpframework.R;
import com.bwie.mvpframework.bean.LoginBean;
import com.bwie.mvpframework.presenter.MyLogingPresenter;
import com.bwie.mvpframework.view.ShowLoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ShowLoginView {

    private EditText mPhoneEt;
    private EditText mPwdEt;
    private Button mLogBt;
    private Button mZcBt;
    MyLogingPresenter presenter=new MyLogingPresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPhoneEt = (EditText) findViewById(R.id.et_phone);
        mPwdEt = (EditText) findViewById(R.id.et_pwd);
        mLogBt = (Button) findViewById(R.id.bt_log);
        mLogBt.setOnClickListener(this);
        mZcBt = (Button) findViewById(R.id.bt_zc);
        mZcBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_log:
                presenter.login(mPhoneEt.getText().toString(),mPwdEt.getText().toString());
                break;
            case R.id.bt_zc:
                Intent intent=new Intent(MainActivity.this,ZcActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void showLogin(LoginBean bean) {
        Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
    }


}
