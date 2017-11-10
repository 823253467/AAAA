package com.bwei.aaaa;


        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.bwei.aaaa.bean.LogBean;
        import com.google.gson.Gson;


        import java.io.ByteArrayOutputStream;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.URL;



public class MainActivity extends AppCompatActivity {
    Button bt_zc;
    Button bt_log;
    EditText et_phone;
    EditText et_pwd;
    LogBean log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_log= (Button) findViewById(R.id.bt_log);
        bt_zc= (Button) findViewById(R.id.bt_zc);

        et_phone= (EditText) findViewById(R.id.et_phone);
        et_pwd= (EditText) findViewById(R.id.et_pwd);
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phone=et_phone.getText().toString();
                final String pwd=et_pwd.getText().toString();
                //Toast.makeText(MainActivity.this,phone+"///"+pwd,Toast.LENGTH_SHORT).show();
                new AsyncTask<String,String,String>(){

                    @Override
                    protected String doInBackground(String... strings) {
                        String data="";
                        try {
                            URL url=new URL("http://120.27.23.105/user/login?mobile="+phone+"&password="+pwd+"");
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
                        log=gson.fromJson(s,LogBean.class);
                        String ps=log.getMsg();
                        Toast.makeText(MainActivity.this,ps,Toast.LENGTH_SHORT).show();
                    }
                }.execute();
            }
        });

        bt_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,ZcActivity.class);
                startActivity(it);
            }
        });



    }
}

