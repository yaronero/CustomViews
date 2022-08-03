package com.example.customviews.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.toColorInt

class VerticalTextLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : LinearLayout(context, attrs, defaultStyle) {

    private val cont = context

    init {
        orientation = VERTICAL
    }

    fun addItem(item: String) {
        val textView = TextView(cont)
        textView.textSize = 18F
        textView.text = item
        textView.setTextColor("#ffffff".toColorInt())
        textView.setBackgroundColor("#000000".toColorInt())
        textView.setPadding(4, 4, 4, 4)
        addView(textView)
    }
}