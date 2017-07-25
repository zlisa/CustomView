package com.wall.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import com.wall.R
import com.wall.util.SizeUtils
import kotlinx.android.synthetic.main.layout_left_text_right_icon_text_view.view.*

/**
 * Created by zlisa on 2017/7/17.
 */
class LeftTextRightIconTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    init {
        val text_size_16_sp: Float = SizeUtils.dp2px(context, 16f).toFloat()
        val padding_4_dp: Float = SizeUtils.dp2px(context, 4f).toFloat()

        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LeftTextRightIconTextView)
        val leftText: String = ta.getString(R.styleable.LeftTextRightIconTextView_left_text) ?: "left text"
        val text: String = ta.getString(R.styleable.LeftTextRightIconTextView_text) ?: "text"
        var leftTextSize: Float = ta.getDimension(R.styleable.LeftTextRightIconTextView_left_text_size, text_size_16_sp)
        var textSize: Float = ta.getDimension(R.styleable.LeftTextRightIconTextView_text_size, text_size_16_sp)
        val leftTextColor: Int = ta.getColor(R.styleable.LeftTextRightIconTextView_left_text_color, Color.BLACK)
        val textColor: Int = ta.getColor(R.styleable.LeftTextRightIconTextView_text_color, Color.BLACK)
        val rightIcon: Int = ta.getResourceId(R.styleable.LeftTextRightIconTextView_right_icon, R.mipmap.ic_launcher)
        ta.recycle()

        LayoutInflater.from(context).inflate(R.layout.layout_left_text_right_icon_text_view, this)
        gravity = Gravity.CENTER_VERTICAL
        val padding: Int = SizeUtils.dp2px(context, 4f)
        setPadding(padding, 0, padding, 0)
        //更正字体大小
        leftTextSize = SizeUtils.px2dp(context, leftTextSize).toFloat()
        textSize = SizeUtils.px2dp(context, textSize).toFloat()
        setLeftText(leftText)
        setText(text)
        setRightIcon(rightIcon)

        setLeftTextSize(leftTextSize)
        setTextSize(textSize)

        setLeftTextColor(leftTextColor)
        setTextColor(textColor)
    }

    private fun setTextColor(textColor: Int) {
        text_view.setTextColor(textColor)
    }

    private fun setLeftTextColor(textColor: Int) {
        left_text.setTextColor(textColor)
    }

    private fun setTextSize(textSize: Float) {
        text_view.textSize = textSize
    }

    private fun setLeftTextSize(textSize: Float) {
        left_text.textSize = textSize
    }

    private fun setRightIcon(icon: Int) {
        right_icon.setImageResource(icon)
    }

    private fun setText(text: String) {
        text_view.text = text
    }

    private fun setLeftText(text: String) {
        left_text.text = text
    }
}