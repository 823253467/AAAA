package com.bwei.usercenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText phone;
    private EditText pwd;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        phone = (EditText) findViewById(R.id.edit01);

        pwd = (EditText) findViewById(R.id.edit02);

        Button button01 = (Button) findViewById(R.id.btn01);
        Button button02 = (Button) findViewById(R.id.btn02);

        presenter = new LoginPresenter(this);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(phone.getText().toString(),pwd.getText().toString());
            }
        });
    }

    @Override
    public void phoneEmpty() {
        Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordEmpty() {
        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(Object object) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void loginFailed(int code) {

        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
