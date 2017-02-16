package com.hudawei.urlopenappsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by hudawei on 2017/2/16.
 *
 */

public class CustomSchemeActivity extends AppCompatActivity {
    private String userName="未知";
    private String passWord="未知";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView userNameView=(TextView) findViewById(R.id.userName);
        TextView passWordView=(TextView) findViewById(R.id.passWord);

        getIntentInfo();
        userNameView.setText(userName);
        passWordView.setText(passWord);

    }

    public void getIntentInfo(){
        Intent intent=getIntent();
        String action=intent.getAction();
        if(Intent.ACTION_VIEW.equals(action)){
            Uri uri=intent.getData();
            userName=uri.getQueryParameter("username");
            passWord=uri.getQueryParameter("password");
        }
    }
}
