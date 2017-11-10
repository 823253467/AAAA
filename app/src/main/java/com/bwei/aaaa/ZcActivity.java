package com.bwei.aaaa;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.aaaa.bean.Bean;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ZcActivity extends AppCompatActivity {
    EditText et_phone;
    EditText et_pwd;
    Button bt_yes;
    Button btcannel;
    Bean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        et_phone= (EditText) findViewById(R.id.et_phone1);
        et_pwd= (EditText) findViewById(R.id.et_pwd1);
        btcannel= (Button) findViewById(R.id.bt_cannel);
        bt_yes= (Button) findViewById(R.id.bt_yse);


    btcannel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
        bt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phone=et_phone.getText().toString();
                final String pwd=et_pwd.getText().toString();
                new AsyncTask<String,String,String>(){

                    @Override
                    protected String doInBackground(String... strings) {
                        String data="";
                        try {
                            URL url=new URL("http://120.27.23.105/user/reg?mobile="+phone+"&password="+pwd+"");
                           // URL url=new URL("http://120.27.23.105/user/reg?mobile="+phone+"&password="+pwd+"");
                            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                            if(conn.getResponseCode()==200){
                                InputStream is=conn.getInputStream();
                                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                                int len=-1;
                                byte[] size=new byte[1024];
                                while((len=is.read(size))!=-1){
                                    bos.write(size,0,len);
                                }
                                data=new String(bos.toByteArray());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return data;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        Gson gson=new Gson();
                        b=gson.fromJson(s,Bean.class);
                        String ps=b.getMsg();
                        Toast.makeText(ZcActivity.this,ps,Toast.LENGTH_SHORT).show();
                    }
                }.execute();

            }
        });




    }
}
