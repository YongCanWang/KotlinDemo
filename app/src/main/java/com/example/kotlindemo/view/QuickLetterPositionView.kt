package com.example.kotlindemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.kotlindemo.R

/**
 * @author TomCan
 * @description:
 * @date:2021/12/29 16:30
 */
class QuickLetterPositionView : View {

    companion object {
        var TAG = "QuickLetterPositionView"
    }

    val ALetters = charArrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    )

    var lettersHeight = 0f

    var onLetterContentListener: OnLetterContentListener? = null

    constructor (context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        lettersHeight = measuredHeight / ALetters.size.toFloat()
        for (index in 0 until ALetters.size) {
            var p = Paint()
            p.setStyle(Paint.Style.FILL)
//            p.setAntiAlias(true)
            p.setTextAlign(Paint.Align.CENTER)
            p.color = context.getColor(R.color.light_gray)
            p.textSize = 85f
            canvas?.drawText(
                ALetters[index].toString(),
                measuredWidth.toFloat() / 2,
                lettersHeight * (index + 1),
                p,
            )
        }
    }


    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "dispatchTouchEvent---> DOWN")
//                return true
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "dispatchTouchEvent---> MOVE")
//                super.dispatchTouchEvent(event)
//                return true
            }

            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "dispatchTouchEvent---> UP")
//                return true
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                val index = (event?.y / lettersHeight).toInt()
                if (index >= 0 && index < ALetters.size) {
                    val position = ALetters[index]
//                    Log.e(TAG, "position:$position")
                    onLetterContentListener?.letterContent(position.toString())
                }
                onLetterContentListener?.touchEvent(event)
            }
        }

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "onTouchEvent---> DOWN")
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "onTouchEvent---> MOVE")
//                super.onTouchEvent(event)
//                return false
            }

            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "onTouchEvent---> UP")
            }
        }

        return super.onTouchEvent(event)
    }


    interface OnLetterContentListener {
        fun letterContent(latter: String)
        fun touchEvent(event: MotionEvent?)
    }


    fun setLetterContentListener(onLetterContentListener: OnLetterContentListener) {
        this.onLetterContentListener = onLetterContentListener
    }

}