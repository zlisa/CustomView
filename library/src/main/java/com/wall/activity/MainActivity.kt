package com.wall.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import com.wall.R
import com.wall.widget.WheelViewDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: ArrayAdapter<String>? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        level_bar.level = 10
        level_bar.progress = 50
        level_bar.speed = 100

//        adapter = ArrayAdapter(this,
//                R.layout.item_single_choice,
//                R.id.text_view,
//                getData())
//
//        dialog = AlertDialog.Builder(this)
////                .setSingleChoiceItems(getItems(), 0, { _, _ -> })
//                .setSingleChoiceItems(adapter, 0, { _, _ -> })
//                .setPositiveButton("确定", { _, _ -> })
//                .setNegativeButton("取消", { _, _ -> })
//                .create()
//        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
//
//        wheel_view.setItems(getData())
//
//        wheel_view.setBackgroundResource(R.color.colorPrimary)

//        wheel_view.setItems(getData())
//        wheel_view.setTextSize(16F)
//
//        scroll_choice.addItems(getData(), 0)
    }

    fun showDialog(v: View) {
//        dialog?.show()

        WheelViewDialog(this)
                .setData(getData())
                .addButton("1", View.OnClickListener { })
                .addButton("2", View.OnClickListener { })
                .addButton("3", View.OnClickListener { })
                .show()
//        MaterialDialog.Builder(this)
//                .content("aaa")
//                .positiveText("1")
//                .negativeText("2")
//                .show()
    }

    private fun getData(): List<String> {
        return (0..20).map { "item - " + it }
    }

    private fun getItems(): Array<CharSequence> {
        return Array(10, { i -> "item - " + i })
    }
}
