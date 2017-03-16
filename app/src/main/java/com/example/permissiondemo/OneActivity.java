package com.example.permissiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 大鹏 on 2017/3/16.
 */
public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }


    public void ButtonClick(View view) {
        startActivity(new Intent(OneActivity.this, MainActivity.class));
    }

    public void ButtonClickTwo(View view) {
        startActivity(new Intent(OneActivity.this, SendActivity.class));
    }
}
