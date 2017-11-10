package com.bwei.zhanghaoqing20171101;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    private AsyncTask<Void, Void, String> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        textView = (TextView) findViewById(R.id.textview);


       // asyncTask();

        //enqueue();

        postEnqueue();

    }

    private void postEnqueue() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();
        RequestBody requestBody = new FormBody.Builder()
                .add("pscid","39")
                .add("page","1")
                .build();
        Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"1111",Toast.LENGTH_SHORT).show();
                    }
                });
                Log.i("------",response.body().string());
            }
        });
    }

    private void enqueue() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts?pscid=39&page=1").build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//            System.out.println();
                String string = response.body().string();
                Log.i("---",string);
            }
        });
    }

    private void asyncTask() {
        asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                String path ="http://120.27.23.105/product/getProducts?pscid=39&page=1";

                try {
                    URL url = new URL(path);
                   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);

                    int responseCode = connection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = connection.getInputStream();

                        String s = stringStream(inputStream,"utf-8");
                       // Log.i("---------sas----------",s);
                        return s;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "saasas";
            }

            @Override
            protected void onPostExecute(String st) {
                super.onPostExecute(st);

               // Log.i("-------------------",st);


                Gson gson = new Gson();
                DataDataBean dataDataBean = gson.fromJson(st, DataDataBean.class);
                List<DataDataBean.DataBean> list = dataDataBean.getData();
                MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
                listView.setAdapter(myAdapter);


            }
        };
        asyncTask.execute();
    }


    private String stringStream(InputStream inputStream, String s) {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, s);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String string = null;

            StringBuilder stringBuilder = new StringBuilder();

            while ((string = bufferedReader.readLine())!=null){
                stringBuilder.append(string);
            }

            bufferedReader.close();

            return  stringBuilder.toString();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}



