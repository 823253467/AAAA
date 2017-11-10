package com.bwei.mvpusercenter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.mvpusercenter.R;
import com.bwei.mvpusercenter.bean.Loginbean;
import com.bwei.mvpusercenter.presenter.LoginPresenter;
import com.bwei.mvpusercenter.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText phone;
    private EditText pwd;
    private Button dl;
    private Button zc;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = (EditText) findViewById(R.id.phone);
        pwd = (EditText) findViewById(R.id.psd);
        dl = (Button) findViewById(R.id.dl);
        zc = (Button) findViewById(R.id.zc);


        loginPresenter = new LoginPresenter(this, this);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.abc(phone.getText().toString(),pwd.getText().toString());
                Intent intent1=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent1);

            }
        });
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ZCActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void showData(Loginbean loginbean) {
//        Toast.makeText(this,loginPresenter.)
    }
}
