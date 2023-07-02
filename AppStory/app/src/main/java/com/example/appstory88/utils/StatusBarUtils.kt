package com.example.appstory88.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager

object  StatusBarUtils {
     fun  makeStatusBarLight(activity: Activity, color: Int) {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             activity.window.statusBarColor = color
             val decorView: View = activity.window.decorView
             var flags = decorView.systemUiVisibility
             flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
             decorView.systemUiVisibility = flags
         }
    }
}