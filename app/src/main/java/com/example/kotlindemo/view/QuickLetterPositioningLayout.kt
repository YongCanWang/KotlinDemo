package com.example.kotlindemo.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.TextView


/**
 * @author TomCan
 * @description:
 * @date:2021/12/29 11:16
 */
class QuickLetterPositioningLayout : ViewGroup, QuickLetterPositionView.OnLetterContentListener {

    var quickLetterPositionView: QuickLetterPositionView? = null
    var textTitle: TextView? = null
    var scroll_y = 0
    var t = 0
    var b = 0

    companion object {
        var TAG = "QuickLetterPositioningLayout"
    }

    constructor (context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, -1)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr) {
        Log.e(TAG, "constructor")
    }


    override fun onFinishInflate() {
        super.onFinishInflate()
        Log.e(TAG, "onFinishInflate")
        initView()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e(TAG, "onMeasure")
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        quickLetterPositionView?.measure(measuredWidth / 2, measuredHeight)
        textTitle?.measure(measuredWidth / 2, measuredHeight)
        b = textTitle!!.measuredHeight
    }


    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        Log.e(TAG, "onLayout")
        quickLetterPositionView?.layout(measuredWidth / 2, 0, measuredWidth, measuredHeight)
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "dispatchTouchEvent---> DOWN")
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "dispatchTouchEvent---> MOVE")
            }

            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "dispatchTouchEvent---> UP")
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "onInterceptTouchEvent---> DOWN")
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "onInterceptTouchEvent---> MOVE")
            }

            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "onInterceptTouchEvent---> UP")
            }
        }
        return super.onInterceptTouchEvent(ev)
    }


    override fun letterContent(latter: String) {
        textTitle?.text = latter
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e(TAG, "onTouchEvent---> DOWN")
            }

            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "onTouchEvent---> MOVE")
            }

            MotionEvent.ACTION_UP -> {
                Log.e(TAG, "onTouchEvent---> UP")
            }
        }
        return super.onTouchEvent(event)
    }

    var down_y: Int = 0
    override fun touchEvent(event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                down_y = event.y.toInt()
                textTitle?.layout(0, down_y, textTitle!!.measuredWidth, down_y + textTitle!!.measuredHeight)
                textTitle?.visibility = VISIBLE
                Log.e(TAG, "DOWN------>:$down_y")
            }

            MotionEvent.ACTION_MOVE -> {
                val move_y = event.y.toInt()
                scroll_y = move_y - down_y
                Log.e(TAG, "MOVE------>:$scroll_y")
                t = (scroll_y + textTitle!!.measuredHeight) + down_y - textTitle!!.measuredHeight
                b = (scroll_y + textTitle!!.measuredHeight) + down_y
                if (t < 0) t = 0
                if (b < textTitle!!.measuredHeight) b = textTitle!!.measuredHeight
                if (t > measuredHeight - textTitle!!.measuredHeight) t = measuredHeight - textTitle!!.measuredHeight
                if (b > measuredHeight) b = measuredHeight
                textTitle?.layout(0, t, textTitle!!.measuredWidth, b)
            }

            MotionEvent.ACTION_UP -> {
                textTitle?.visibility = GONE
                Log.e(TAG, "UP------>:$scroll_y")
            }
        }
    }


    private fun initView() {
        quickLetterPositionView = getChildAt(0) as QuickLetterPositionView?
        quickLetterPositionView?.setLetterContentListener(this)
        textTitle = getChildAt(1) as TextView?
    }
}