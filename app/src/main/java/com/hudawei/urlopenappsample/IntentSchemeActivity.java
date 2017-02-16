package com.hudawei.urlopenappsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.net.URISyntaxException;

/**
 * Created by hudawei on 2017/2/16.
 *
 */

public class IntentSchemeActivity extends AppCompatActivity {
    private String userName;
    private String passWord;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView userNameView=(TextView) findViewById(R.id.userName);
        TextView passWordView=(TextView) findViewById(R.id.passWord);
        userNameView.setText("IntentSchemeActivity");
        parseIntent();
        userNameView.setText(userName);
        passWordView.setText(passWord);
    }

    private void parseIntent() {
        Intent intent=getIntent();
        String dataString=intent.getDataString();
        String uriString= intent.toUri(0);
        Log.e(this.getClass().getSimpleName(),"intent.getDataString()  "+
                dataString+"\nintent.toUri(0)  "+uriString);
        if(dataString!=null){
            try {
                Intent parseIntent=Intent.parseUri(uriString,0);
                userName=parseIntent.getStringExtra("username");
                passWord=parseIntent.getStringExtra("password");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
