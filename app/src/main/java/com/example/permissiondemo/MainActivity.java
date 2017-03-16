package com.example.permissiondemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        File file = getExternalFilesDir("aaa"); //如果写入空字符的话，被写入文件会在fils根目录下
//        //向我这样写入  aaa  是在files 文件中新建一个文件夹
//        file.getPath();//可以拿到 目录文件


    }

    public void ButtonClick(View view) {
        //申请多个权限的写法
        ArrayList<String> permission = new ArrayList<>();// 创建一个集合
        //判断 某个权限是否开通， 如果没有开通 就把这个权限添加进入集合
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            permission.add(Manifest.permission.CALL_PHONE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permission.isEmpty()) {
            //申请开通权限
            ActivityCompat.requestPermissions(this, permission.toArray(new String[permission.size()]), 1);
        } else {
            //你所申请的权限都已经开启，可以运行你想要的操作了。
            makecall();
        }

////-----------------------------------开通单个权限
//        //这里是申请单个权限。
//        //检测应用 每个权限是否 已经开通。如果不开通之后 所做的判断
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            // 就是没有开通状态，需要去申请权限
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
//        } else {
//            makecall();
//        }
    }

    // 你所想做的事情，
    private void makecall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://12333333333"));
        startActivity(intent);
    }


    //用户 选择之后的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // requestCode 申请权限所传递状态吗
        // permissions 我认为 是所申请的权限
        // grantResults 所申请权限认证状态 是一个数组
//        switch (requestCode) {
//            case 1:
//                // 首先判断返回状态数组长度是否为0， 如果不为0 ，在判断状态是否同意了
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //同意权限
//        makecall();
//                } else {
//                    //不同意权限
//                }
//                break;
//            default:
//                break;
//        }
        //以上 是单个权限申请，所走的回调
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int grantResult : grantResults) {
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            //  如果进来了，就说明 某个权限被关闭了。
                            return;
                        }
                    }
                    //如果没有被return,说明你所申请的权限都已经被同意，可以去做想做的事情
                    makecall();
                }
                break;
            default:
                break;
        }

    }
}
