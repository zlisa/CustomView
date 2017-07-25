package com.wall.widget

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.wall.R

/**
 * Created by zlisa on 2017/7/18.
 */
class SingleChoiceDialog(context: Context) {

    var mDialog: AlertDialog? = null
    var mRecyclerView: RecyclerView? = null
    var mButtonGroup: ButtonGroup? = null

    init {
        val mCustomView = (LayoutInflater.from(context).inflate(R.layout.layout_single_choice, null) as ViewGroup?)!!
        mButtonGroup = ButtonGroup(context)

        mCustomView.addView(mButtonGroup, mCustomView.childCount)

        mDialog = AlertDialog.Builder(context)
                .setView(mCustomView)
                .create()

        mCustomView.findViewById<RecyclerView>(R.id.recycler_view)

        mRecyclerView = mCustomView.findViewById<RecyclerView>(R.id.recycler_view)
        mRecyclerView?.layoutManager = LinearLayoutManager(context)
    }

    public fun addButton(text: String, onClickListener: View.OnClickListener): SingleChoiceDialog {
        mButtonGroup?.addButton(text, onClickListener)
        return this
    }

    public fun setData(data: List<String>): SingleChoiceDialog {
        val adapter: BaseQuickAdapter<String, BaseViewHolder> = object : BaseQuickAdapter<String, BaseViewHolder>(
                R.layout.item_single_choice, data) {
            override fun convert(helper: BaseViewHolder?, item: String) {
                helper?.setText(R.id.text_view, item)
            }
        }
        return setAdapter(adapter)
    }

    public fun <T> setAdapter(adapter: BaseQuickAdapter<T, BaseViewHolder>): SingleChoiceDialog {
        mRecyclerView?.adapter = adapter
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