package com.example.panda.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by panda on 2018/3/22.
 */

public  class SettingActivity extends AppCompatActivity {
//    private String[] settings={"联系我们","关于我们","清除缓存","版本v0.01"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intent=getIntent();

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        } //去标题栏

    }


}
