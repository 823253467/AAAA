package com.bwei.monizk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(SecondActivity.this, CaptureActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();

            String result = bundle.getString("result");

            //text.setText(result);
            Toast.makeText(SecondActivity.this,result,Toast.LENGTH_SHORT).show();

            Button button = new Button(this);



        }
    }
}
