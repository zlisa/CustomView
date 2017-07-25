package com.wall.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.TypefaceSpan
import android.util.AttributeSet
import com.wall.R

class GradientTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.support.v7.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    companion object {
        val HORIZONTAL = 0
        val VERTICAL = 1
    }

    var mShader: LinearGradient? = null
    var orientation: Int? = null
    var fromColor: Int? = null
    var toColor: Int? = null

    init {
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView)
        //渐变方向，默认水平
        orientation = ta.getInt(R.styleable.GradientTextView_orientation, HORIZONTAL)
        fromColor = ta.getColor(R.styleable.GradientTextView_from_color, Color.GRAY)
        toColor = ta.getColor(R.styleable.GradientTextView_to_color, Color.BLACK)
        ta.recycle()
    }

    override fun setText(text: CharSequence, type: BufferType?) {
        val ss: SpannableString = SpannableString(text)
        ss.setSpan(RelativeSizeSpan(1.5F), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        ss.setSpan(TypefaceSpan("sans-serif"), 0, text.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        super.setText(ss, type)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed){
            when (orientation) {
                HORIZONTAL -> {
                    mShader = LinearGradient(0F, (height / 2).toFloat(),
                            width.toFloat(), (height / 2).toFloat(),
                            fromColor!!, toColor!!,
                            Shader.TileMode.CLAMP)
                }
                else -> {
                    mShader = LinearGradient((width / 2).toFloat(), 0F,
                            (width / 2).toFloat(), height.toFloat(),
                            fromColor!!, toColor!!,
                            Shader.TileMode.CLAMP)
                }
            }
            paint.shader = mShader
        }
    }
}