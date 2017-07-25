package com.wall.widget

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.wall.R

/**
 * Created by zlisa on 2017/7/19.
 */
class WheelViewDialog(context: Context) {
    var mDialog: AlertDialog? = null
    var mWheelView: WheelView? = null

    var mButtonGroup: ButtonGroup? = null

    init {
        val mCustomView = (LayoutInflater.from(context).inflate(R.layout.layout_wheel_view, null) as ViewGroup?)!!
        mButtonGroup = ButtonGroup(context)

        mCustomView.addView(mButtonGroup, mCustomView.childCount)

        mDialog = AlertDialog.Builder(context)
                .setView(mCustomView)
                .create()

        mWheelView = mCustomView.findViewById<WheelView>(R.id.wheel_view)
    }

    public fun addButton(text: String, onClickListener: View.OnClickListener): WheelViewDialog {
        mButtonGroup?.addButton(text, onClickListener)
        return this
    }

    public fun setData(data: List<String>): WheelViewDialog {
        mWheelView?.setItems(data)
        return this
    }

    public fun show() {
        mDialog?.show()
    }

    class ButtonGroup @JvmOverloads constructor(
            context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : LinearLayoutCompat(context, attrs, defStyleAttr) {
        init {
            orientation = HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        fun addButton(text: String, onClickListener: OnClickListener) {
            val button: Button = LayoutInflater.from(context).inflate(R.layout.layout_single_choice_dialog_button, this, false) as Button
            button.text = text
            button.setOnClickListener(onClickListener)
            addView(button)
        }
    }
}