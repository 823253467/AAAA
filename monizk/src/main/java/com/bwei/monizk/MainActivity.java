package com.bwei.monizk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Title title1 = new Title();
        Title title = (Title) findViewById(R.id.title_id);
        Button btn = (Button) findViewById(R.id.btn_sm);
        text = (TextView) findViewById(R.id.text_id);
        circle = (Circle) findViewById(R.id.circle_id);
        title.setMy(new MyCallBack() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {


                Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
            }
        });
        /*title.setMy(new Title.MyCallBack() {
            @Override
            public void leftClick() {


            }

            @Override
            public void rightClick() {


            }
        });*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle.start(MainActivity.this);

            }
        });
    }


}
