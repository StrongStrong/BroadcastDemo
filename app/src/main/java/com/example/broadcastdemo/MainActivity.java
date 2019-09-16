package com.example.broadcastdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyReceiver mMyReceiver;
    private LocalBroadcastManager mLocalBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyReceiver = new MyReceiver();                                                     //实例化广播接收器 MyReceiver()
        IntentFilter filter = new IntentFilter("com.package.yanglei.action.test");          //动态配置广播接收器action
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);                   //广播变量管理器获得本地广播管理器
        mLocalBroadcastManager.registerReceiver(mMyReceiver, filter);                       //注册本地广播



    }

    public void sendLocalBroadcast(View view) {
        Intent intent = new Intent("com.package.yanglei.action.test");      //创建发送广播的Action
        intent.putExtra(Intent.EXTRA_TEXT, "hi lllllllllll");                //发送携带的数据
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    public void sendOtherAppBroadcast(View view) {
        sendBroadcast(new Intent("com.example.bapp.MY_BROADCAST"));
    }

    //广播接收器
    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Aapp收到了通知",Toast.LENGTH_SHORT).show();
        }
    }
}
