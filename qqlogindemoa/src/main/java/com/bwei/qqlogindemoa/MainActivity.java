package com.bwei.qqlogindemoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
   // private static final String APP_ID = "1105602574"; //获取的APPID
    private ShareUiListener mIUiListenera;
   // private Tencent mTencent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID,MainActivity.this.getApplicationContext());
    }
    public void buttonLogin(View v){
        /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
         官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
         第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
        mIUiListener = new BaseUiListener();
        //all表示获取所有权限
        mTencent.login(MainActivity.this,"all", mIUiListener);
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                        Gson gson = new Gson();

                        javaBean javaBean = gson.fromJson(response.toString(), javaBean.class);

                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("name",javaBean.getNickname());
                        intent.putExtra("sex",javaBean.getGender());
                        intent.putExtra("image",javaBean.getFigureurl_qq_2());
                        startActivity(intent);

                        finish();


                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /**
     * 分享到QQ
     * @param v
     */
    public void qqShare(View v) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);//分享的类型
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "然了个然CSDN博客");//分享标题
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY,"不管是怎样的过程,最终目的还是那个理想的结果。");//要分享的内容摘要
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL,"http://blog.csdn.net/sandyran");//内容地址
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,"http://avatar.csdn.net/B/3/F/1_sandyran.jpg");//分享的图片URL
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试");//应用名称
        mTencent.shareToQQ(MainActivity.this, params, new ShareUiListener());
    }

    /**
     * 分享到QQ空间
     * @param v
     */
    public void qqQzoneShare(View v) {
        int QzoneType = QzoneShare.SHARE_TO_QZONE_TYPE_NO_TYPE;
        Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneType);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "然了个然CSDN博客");//分享标题
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "不管是怎样的过程,最终目的还是那个理想的结果。");//分享的内容摘要
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "http://blog.csdn.net/sandyran/article/details/53204529");//分享的链接
        //分享的图片, 以ArrayList<String>的类型传入，以便支持多张图片（注：图片最多支持9张图片，多余的图片会被丢弃）
        ArrayList<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://avatar.csdn.net/B/3/F/1_sandyran.jpg");//添加一个图片地址
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imageUrls);//分享的图片URL
        mTencent.shareToQzone(MainActivity.this, params, new ShareUiListener());
    }

    /**
     * 分享音乐
     * @param v
     */
    public void qqMusicShare(View v) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);//分享的类型
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "歌曲名：说穿");//分享的标题
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "专辑名：最好的我们，歌手：谢楠");//分享的内容摘要
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "https://y.qq.com/n/yqq/song/004Dle9I3TaSai.html");//分享的链接
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "https://y.gtimg.cn/music/photo_new/T002R300x300M000000kbocv24CRbE.jpg?max_age=2592000");//分享的图片URL
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试");//应用名称
        params.putString(QQShare.SHARE_TO_QQ_EXT_INT, String.valueOf(QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN));//分享时自动打开分享到QZone的对话框
        mTencent.shareToQQ(MainActivity.this, params, new ShareUiListener());

    }

    /**
     * 自定义监听器实现IUiListener，需要3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class ShareUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            //分享成功

        }

        @Override
        public void onError(UiError uiError) {
            //分享失败

        }

        @Override
        public void onCancel() {
            //分享取消

        }
    }

    /**
     * 回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (null != mTencent) {
            mTencent.onActivityResult(requestCode, resultCode, data);
        }
    }*/
}
