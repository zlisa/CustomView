package com.wall.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.wall.R
import kotlinx.android.synthetic.main.layout_level_bar.view.*

/**
 * Created by zlisa on 2017/7/24.
 */
class LevelBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_level_bar, this)
    }

    var level: Int = 0
        set(value) {
            field = value
            start_level.text = "LV" + field
            end_level.text = "LV" + (field + 1)
        }

    var speed: Int = 0
        set(value) {
            field = value
            start_progress.text = "" + level * field
            end_progress.text = "" + (level + 1) * field
        }

    var progress: Int = 0
        set(value) {
            field = value
            progress_bar.progress = field
        }

}