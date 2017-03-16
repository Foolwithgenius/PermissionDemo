package com.example.permissiondemo;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by 大鹏 on 2017/3/16.
 */
public class ActivityCollector {
    public static ArrayList<Activity> activitys = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activitys.add(activity);
    }

    ;

    public static void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public static Activity getTopActivity() {
        if (activitys.isEmpty()) {
            return null;
        } else {
            return activitys.get(activitys.size() - 1);
        }
    }


}
