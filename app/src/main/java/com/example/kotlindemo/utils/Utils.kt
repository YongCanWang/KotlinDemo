package com.example.kotlindemo.utils

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * @author TomCan
 * @description:
 * @date:2021/12/9 11:56
 */
class Utils {

    companion object {

        fun getAssetsJson(fileName: String, context: Context) : String{
            //将json数据变成字符串
            val stringBuilder = StringBuilder()
            try {
                //获取assets资源管理器
                val assetManager = context.assets
                //通过管理器打开文件并读取
                val bf = BufferedReader(
                    InputStreamReader(
                        assetManager.open(fileName)
                    )
                )
                var line: String?
                while (bf.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return stringBuilder.toString()
        }


    }


}