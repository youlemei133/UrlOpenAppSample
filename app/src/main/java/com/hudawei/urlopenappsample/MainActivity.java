package com.hudawei.urlopenappsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 1. 自定义Scheme
 * 2. 基于Intent
 *
 * 第三方浏览器
 * QQ内部
 * 微信内部
 *
 * 1.打开网页
 * 2.点击链接
 * 3.没有下载，去下载安装，再次点击链接，打开App
 * 4.下载，打开App
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processClick(View view){
        switch (view.getId()){
            case R.id.custom_scheme:

                break;
            case R.id.base_intent:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("myapp://yaotia.com/intent"));
                intent.putExtra("username","胡大伟");
                intent.putExtra("password","123456");
                Log.e(this.getClass().getSimpleName(),intent.toUri(0));
                startActivity(intent);
                break;
        }
    }
}
