package com.example.permissiondemo;

import java.util.List;

/**
 * Created by 大鹏 on 2017/3/16.
 * 申请权限的回调
 */
public interface PermissionListener {
    void onGrande(); //所有权限都申请成功之后的回调

    void onDenied(List<String> deniedPermissions); //没有通过的权限  参数： 没有通过的权限集合
}
