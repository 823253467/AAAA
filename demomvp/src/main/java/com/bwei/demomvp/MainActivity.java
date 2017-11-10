package com.bwei.demomvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {


    private Button button;
    private LoginPresenter loginPresenter;
    private EditText phone;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        loginPresenter = new LoginPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"sasa",Toast.LENGTH_SHORT).show();
                loginPresenter.login(phone.getText().toString(),password.getText().toString());

            }
        });

    }


    @Override
    public void phoneEmpty() {
        Toast.makeText(this, "phone is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordEmpty() {

        Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(Object object) {


    }

    @Override
    public void loginFailed(int code) {


    }
}
