package com.bwei.mvpframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText edit01_id;
    private EditText edit02_id;
    private Button button;
    private LoginPresenter loginPresenter;
    String Tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit01_id = (EditText) findViewById(R.id.edit01_id);
        edit02_id = (EditText) findViewById(R.id.edit02_id);
        button = (Button) findViewById(R.id.btn01);
        loginPresenter = new LoginPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit01_id.getText().toString();
                String pwd = edit02_id.getText().toString();
                loginPresenter.login(username, pwd);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.a.main, menu);
        return true;
    }*/

    @Override
    public void showMsg(String msg) {
        // TODO Auto-generated method stub
        Log.i(Tag, msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        // TODO Auto-generated method stub
        Log.i(Tag, "showLoading");
    }

    @Override
    public void hiddenLoading() {
        // TODO Auto-generated method stub
        Log.i(Tag, "hiddenLoading");
    }

    @Override
    public void jumpActivity() {
        // TODO Auto-generated method stub
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }

    long lastTime;
    @Override
    public boolean back() {
        long currTime=System.currentTimeMillis();
        if(currTime-lastTime>3000){
            showMsg("再按一次退出");
            lastTime=currTime;
        }else{
            finish();
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK){
            return back();
        }
        return super.onKeyDown(keyCode, event);
    }
}
