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

    var jListener: ((a: Float, e: Float) -> Unit)? = null
        private set

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

    fun setJListener(l: (a: Float, e: Float) -> Unit) {
        jListener = l
    }

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
        event?.let { mEvent ->
//            Log.i(":::JoystickView", "@onTouchEvent -> got $mEvent")
            when (mEvent.action) {
                MotionEvent.ACTION_MOVE -> {
                    val margin = circleRadius / 2
                    if (mEvent.x > (mWidth - margin) || mEvent.x < margin
                        || mEvent.y > mHeight - margin || mEvent.y < margin
                    ) {
                        return true
                    } else {
                        val mX = mEvent.x
                        val mY = mEvent.y
                        val xMax = mWidth - margin
                        val yMax = mHeight - margin
                        val trueWidth = (mWidth - circleRadius) * 0.9
                        val trueHeight = (mHeight - circleRadius) * 0.9

                        val a = when {
                            mX > 0 && mX <= defaultCenter.x -> {
                                (((defaultCenter.x - mX) / (trueWidth / 2)) * -1).toFloat()
                            }
                            mX > defaultCenter.x && mX < xMax -> {
                                ((mX - defaultCenter.x) / (trueWidth / 2)).toFloat()
                            }
                            else -> 0f
                        }

                        val e = when {
                            mY > 0 && mY <= defaultCenter.y -> {
                                ((defaultCenter.y - mY) / (trueHeight / 2)).toFloat()
                            }
                            mY > defaultCenter.y && mY < yMax -> {
                                ((mY - defaultCenter.y) / (trueHeight / 2) * -1).toFloat()
                            }
                            else -> 0f
                        }
                        Log.i(":::JoystickView", "@onTouchEvent -> centerX = ${defaultCenter.x}, mX = $mX, a = $a")
                        Log.i(":::JoystickView", "@onTouchEvent -> centerY = ${defaultCenter.y}, mY = $mY, e = $e")
                        val aOut = when {
                            a > 1 -> 1.0f
                            a < -1 -> -1.0f
                            else -> a
                        }
                        val eOut = when {
                            e > 1 -> 1.0f
                            e < -1 -> -1.0f
                            else -> e
                        }
                        jListener?.invoke(aOut, eOut)
                        updateView(mX, mY)
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

    interface JListener {
        fun onMove(a: Float, e: Float)
    }
}