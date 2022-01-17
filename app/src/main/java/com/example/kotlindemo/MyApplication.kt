package com.example.kotlindemo

import android.app.Application
import com.example.kotlindemo.utils.ThemeManager

/**
 * @author TomCan
 * @description:
 * @date:2021/11/29 13:36
 */
class MyApplication : Application() {

    companion object {
         var isDayNight = false
    }

    override fun onCreate() {
        super.onCreate()
        ThemeManager.init(this, 2, 0, null)
    }


}