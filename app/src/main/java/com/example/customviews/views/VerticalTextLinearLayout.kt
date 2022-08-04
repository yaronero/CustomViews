package com.example.customviews.views

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.core.view.setPadding

class VerticalTextLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : LinearLayout(context, attrs, defaultStyle) {

    init {
        orientation = VERTICAL
    }

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.textSize = 18F
        textView.text = item
        textView.setTextColor("#ffffff".toColorInt())
        textView.setBackgroundColor("#000000".toColorInt())
        textView.setPadding(dpToPx(4))
        addView(textView)
    }

    private fun dpToPx(dp: Int) = (dp * Resources.getSystem().displayMetrics.density).toInt()
}