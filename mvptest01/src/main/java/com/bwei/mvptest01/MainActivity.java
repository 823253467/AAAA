package com.bwei.mvptest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.mvptest01.bean.Loginbean;
import com.bwei.mvptest01.presenter.LoginPresenter;
import com.bwei.mvptest01.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

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

            }
        });
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void showData(Loginbean loginbean) {

        Toast.makeText(this,""+loginbean.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
