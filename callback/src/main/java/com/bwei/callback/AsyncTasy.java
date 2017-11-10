package com.bwei.callback;

import android.os.AsyncTask;

/**
 * Created by MK on 2017/11/5.
 */
public class AsyncTasy extends AsyncTask<String,Void,String>{
    ChangText changText;


    public void AsyncTasy(ChangText changText){
        this.changText=changText;
    }
    @Override
    protected String doInBackground(String... strings) {
        if (strings[0]!=null){
            changText.Text(strings[0]);
        }

        return null;
    }
}
