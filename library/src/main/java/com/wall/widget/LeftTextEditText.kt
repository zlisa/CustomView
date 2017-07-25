package com.wall.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import com.wall.R
import com.wall.util.SizeUtils
import kotlinx.android.synthetic.main.layout_left_text_edit_text.view.*

/**
 * Created by zlisa on 2017/7/17.
 */
class LeftTextEditText @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    init {
        val text_size_16_sp: Float = SizeUtils.dp2px(context, 16f).toFloat()
        val padding_4_dp: Float = SizeUtils.dp2px(context, 4f).toFloat()
        //获取自定义属性
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LeftTextEditText)
        val leftText: String = ta.getString(R.styleable.LeftTextEditText_left_text) ?: "left text"
        val hint: String = ta.getString(R.styleable.LeftTextEditText_hint) ?: "hint text"
        val text: String? = ta.getString(R.styleable.LeftTextEditText_text)
        var leftTextSize: Float = ta.getDimension(R.styleable.LeftTextEditText_left_text_size, text_size_16_sp)
        var textSize: Float = ta.getDimension(R.styleable.LeftTextEditText_text_size, text_size_16_sp)
        val leftTextPadding = ta.getDimension(R.styleable.LeftTextEditText_left_text_padding, padding_4_dp)
        val leftTextColor: Int = ta.getColor(R.styleable.LeftTextEditText_left_text_color, Color.BLACK)
        val hintColor: Int = ta.getColor(R.styleable.LeftTextEditText_hint_color, Color.LTGRAY)
        val textColor: Int = ta.getColor(R.styleable.LeftTextEditText_text_color, Color.BLACK)
        val imeOptions: Int = ta.getInt(R.styleable.LeftTextEditText_ime_options, 0)
        val inputType: Int = ta.getInt(R.styleable.LeftTextEditText_input_type, 1)
        ta.recycle()
        //更正字体大小
        leftTextSize = SizeUtils.px2dp(context, leftTextSize).toFloat()
        textSize = SizeUtils.px2dp(context, textSize).toFloat()
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.layout_left_text_edit_text, this)
        gravity = Gravity.CENTER_VERTICAL
        val padding: Int = SizeUtils.dp2px(context, 4f)
        setPadding(padding, 0, padding, 0)
        //设置默认属性值
        //文字
        setLeftText(leftText)
        setHint(hint)
        text?.let {
            setText(text)
        }
        //文字颜色
        setLeftTextColor(leftTextColor)
        setHintColor(hintColor)
        setTextColor(textColor)
        //文字大小
        setLeftTextSize(leftTextSize)
        setTextSize(textSize)
        //内边距
        if (paddingLeft == 0
                && paddingRight == 0
                && paddingTop == 0
                && paddingBottom == 0) {
            val padding: Int = SizeUtils.dp2px(context, 4f)
            setPadding(padding)
        }
        setLeftTextPadding(leftTextPadding.toInt())

        setInputType(inputType)
        setImeOptions(imeOptions)
    }

    /**
     * 设置编辑框InputType
     * @param inputType InputType
     */
    public fun setInputType(inputType: Int) {
        try {
            edit_text.inputType = inputType
        } catch (e: Exception) {
            Log.e("Error", "inputType not found!")
        }
    }

    /**
     * 设置编辑框IME
     * @param imeOptions IME
     */
    public fun setImeOptions(imeOptions: Int) {
        try {
            edit_text.imeOptions = imeOptions
        } catch (e: Exception) {
            Log.e("Error", "IME Options not found!")
        }
    }

    /**
     * 设置编辑框文字颜色
     * @param color 文字颜色
     */
    public fun setTextColor(color: Int) {
        edit_text.setTextColor(color)
    }

    /**
     * 设置提示文字颜色
     * @param color 文字颜色
     */
    public fun setHintColor(color: Int) {
        edit_text.setHintTextColor(color)
    }

    /**
     * 设置左边文字颜色
     * @param color 文字颜色
     */
    public fun setLeftTextColor(color: Int) {
        left_text.setTextColor(color)
    }

    /**
     * 设置左边文字和编辑框边距
     * @param padding 边距
     */
    public fun setLeftTextPadding(padding: Int) {
        left_text.setPadding(0, 0, padding, 0)
    }

    /**
     * 设置边距
     * @param padding 边距
     */
    public fun setPadding(padding: Int) {
        setPadding(padding, padding)
    }

    /**
     * 设置左右、上下边距
     * @param LRPadding 左右边距
     * @param TBPadding 上下边距
     */
    public fun setPadding(LRPadding: Int, TBPadding: Int) {
        setPadding(LRPadding, TBPadding, LRPadding, TBPadding)
    }

    /**
     * 设置输入框文字大小
     * @param textSize 左输入框文字大小
     */
    public fun setTextSize(textSize: Float) {
        edit_text.textSize = textSize
    }

    /**
     * 设置左边文字大小
     * @param textSize 左边文字大小
     */
    public fun setLeftTextSize(textSize: Float) {
        left_text.textSize = textSize
    }

    /**
     * 设置输入框显示文字
     * @param text 输入框文字内容
     */
    public fun setText(text: String) {
        edit_text.setText(text)
    }

    /**
     * 设置输入框提示文字
     * @param hint 提示文字内容
     */
    public fun setHint(hint: String) {
        edit_text.hint = hint
    }

    /**
     * 设置左边显示文字
     * @param leftText 文字内容
     */
    public fun setLeftText(leftText: String) {
        left_text.text = leftText
    }
}