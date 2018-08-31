package com.example.brand.carpool.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.brand.carpool.MainActivity;
import com.example.brand.carpool.R;
import com.example.brand.carpool.utils.StaticClass;

/*
 @ project: CarPool
 @ package: com.example.brand.carpool.ui
 @ file: SplashActivity
 @ author : Jingliang Zhang (Brand)
 @ create time: 2018/8/29 1:20
 @ description: TODO
 */
public class SplashActivity extends AppCompatActivity{
    private TextView tv_splash;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case StaticClass.HANDLER_SPLASH:
                if(true){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this,RegisteredActivity.class));
                }
                finish();
                break;
            }
        }
    };

    // whether the program run first time
    private boolean isFirst(){
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    //initial View
    private void initView(){
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tv_splash = (TextView) findViewById(R.id.tv_splash);
    }
}
