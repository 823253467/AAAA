package com.bwei.qqlogindemoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView imageView = (ImageView) findViewById(R.id.image01);
        TextView mname = (TextView) findViewById(R.id.text_name);
        TextView msex = (TextView) findViewById(R.id.text_sex);
        Button mbutton = (Button) findViewById(R.id.btn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String image = intent.getStringExtra("image");

        Glide.with(this)
                .load(image)
                .into(imageView);
        mname.setText(name);
        msex.setText(sex);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });


    }
}
