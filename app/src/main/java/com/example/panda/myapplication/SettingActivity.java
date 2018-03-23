package com.example.panda.myapplication;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

/**
 * Created by panda on 2018/3/22.
 */

public  class SettingActivity extends AppCompatActivity {
//    private String[] settings={"联系我们","关于我们","清除缓存","版本v0.01"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        } //去标题栏

        TextView version=(TextView)findViewById(R.id.version);
        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取NotificationManager实例
                NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //实例化NotificationCompat.Builde
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplication());
                //设置小图标
                builder.setSmallIcon(R.mipmap.ic_launcher);
                //设置通知标题
                builder.setContentTitle("版本更新通知");
                //设置通知内容
                builder.setContentText("最新版本");
                //设置声音
                builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

                //设置通知时间，默认为系统发出通知的时间，通常不用设置
                //.setWhen(System.currentTimeMillis());
                //通过builder.build()方法生成Notification对象,并发送通知,id=1
                notifyManager.notify(1, builder.build());
            }
        });





    }


}
