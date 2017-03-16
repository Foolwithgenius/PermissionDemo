package com.example.permissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.List;

/**
 * Created by 大鹏 on 2017/3/16.
 * 封装一种申请运行时权限的方法
 */
public class SendActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonClick(View view) {
        requestRuntimePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionListener() {
            @Override
            public void onGrande() {
                //权限申请通过
            }

            @Override
            public void onDenied(List<String> deniedPermissions) {
                for (String deniedPermission :
                        deniedPermissions
                        ) {
                    //                   deniedPermission  权限没有申请通过
                }
            }
        });
    }
}
