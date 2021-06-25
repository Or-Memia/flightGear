package com.example.flightgear.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class JoystickView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val p = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    var circleRadius = 0f
    var center = PointF()
    var defaultCenter = PointF()
    var mWidth = -1
    var mHeight = 0

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.i(":::JoystickView", "@onSizeChanged -> called wit w = $w h = $h")
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        circleRadius = minOf(w, h) / 6.0f
        center = PointF(w / 2.0f, h / 2.0f)
        defaultCenter = PointF(w / 2.0f, h / 2.0f)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(center.x, center.y, circleRadius, p)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let { e ->
            Log.i(":::JoystickView", "@onTouchEvent -> got $e")
            when (e.action) {
                MotionEvent.ACTION_MOVE -> {
                    val margin = circleRadius / 2
                    if (e.x > (mWidth - margin) || e.x < margin
                        || e.y > mHeight - margin || e.y < margin
                    ) {
                        return true
                    } else {
                        updateView(e.x, e.y)
                    }
                }
                MotionEvent.ACTION_UP -> resetView()
                else -> {
                    /*ignore*/
                }
            }
            return true
        } ?: return true
    }

    private fun resetView() {
        Log.i(":::JoystickView", "@resetView -> called")
        center = defaultCenter
        invalidate()
    }

    private fun updateView(x: Float, y: Float) {
        center = PointF(x, y)
        invalidate()
    }


}