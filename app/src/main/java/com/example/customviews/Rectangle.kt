package com.example.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.Px

class Rectangle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var rect = RectF(5F, 5F, 200F, 200F)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    @Px
    private var borderRadius = DEFAULT_RADIUS
    @Px
    private var borderWidth = DEFAULT_BORDER_WIDTH
    @ColorInt
    private var borderColor = DEFAULT_BORDER_COLOR

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Rectangle,
            0, 0
        ).apply {
            try {
                borderRadius = getDimension(R.styleable.Rectangle_borderRadius, DEFAULT_RADIUS)
                borderWidth = getDimension(R.styleable.Rectangle_borderWidth, DEFAULT_BORDER_WIDTH)
                borderColor = getColor(R.styleable.Rectangle_borderColor, DEFAULT_BORDER_COLOR)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        canvas?.drawRoundRect(rect, borderRadius, borderRadius, paint)

        paint.style = Paint.Style.STROKE
        paint.color = borderColor
        paint.strokeWidth = borderWidth
        canvas?.drawRoundRect(rect, borderRadius, borderRadius, paint)

    }

    companion object {
        private const val DEFAULT_RADIUS = 5F
        private const val DEFAULT_BORDER_WIDTH = 2F
        private const val DEFAULT_BORDER_COLOR = Color.BLUE
    }
}