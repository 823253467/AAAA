package com.bwei.titleactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("标题");
        showBackwardView(R.string.app_name,true);
        showForwardView(R.string.app_name,true);
    }
}
