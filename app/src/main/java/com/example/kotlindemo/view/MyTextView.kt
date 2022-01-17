package com.example.kotlindemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * @author TomCan
 * @description:
 * @date:2021/12/30 16:14
 */
@SuppressLint("AppCompatCustomView")
class MyTextView : TextView {

    constructor (context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )




}