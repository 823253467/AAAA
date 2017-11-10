package com.bwei.mvplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.mvplogin.bean.LoginBean;
import com.bwei.mvplogin.bean.RegBean;
import com.bwei.mvplogin.presenter.LoginPresenter;
import com.bwei.mvplogin.view.LoginView;
import com.bwei.mvplogin.view.RegView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText phone;
    private EditText pwd;
    private Button log;
    private Button zc;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.phone);
        pwd = (EditText) findViewById(R.id.pwd);
        log = (Button) findViewById(R.id.log);
        zc = (Button) findViewById(R.id.zc);
        loginPresenter = new LoginPresenter(this);
        // viewData(LoginBean bean);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.abc(phone.getText().toString(),pwd.getText().toString());
            }
        });
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ZhuCeActivity.class);

                startActivity(intent);

            }
        });
    }





    @Override
    public void viewData(final LoginBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.sa();
    }
}
