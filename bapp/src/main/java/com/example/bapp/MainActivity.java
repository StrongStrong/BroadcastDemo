package com.example.bapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private BReceiver bReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter=new IntentFilter();
        //这里定义接受器监听广播的类型，这里添加相应的广播
        intentFilter.addAction("com.example.bapp.MY_BROADCAST");
        //实例化接收器
        bReceiver=new BReceiver();
        //注册事件，将监听类型赋给对应的广播接收器----所以这叫动态注册
        registerReceiver(bReceiver,intentFilter);

    }

    public void sendBroadcast(View view) {
        Log.i("BReceiver","tttt");
        sendBroadcast(new Intent("com.example.bapp.MY_BROADCAST"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bReceiver);
    }
}
