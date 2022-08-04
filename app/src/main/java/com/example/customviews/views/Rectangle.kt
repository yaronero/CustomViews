package com.example.customviews.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.Px
import com.example.customviews.R

class Rectangle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var rect = RectF(0F, 0F, DEFAULT_SIZE.toFloat(), DEFAULT_SIZE.toFloat())

    private var fillPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.GREEN
    }
    private var strokePaint = Paint().apply { style = Paint.Style.STROKE }

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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = setupSize(widthMeasureSpec)
        val height = setupSize(heightMeasureSpec)
        setMeasuredDimension(width, height)

        val halfBorderWidth = borderWidth / 2
        rect.left = halfBorderWidth
        rect.top = halfBorderWidth
        rect.right = width.toFloat() - halfBorderWidth
        rect.bottom = height.toFloat() - halfBorderWidth

        strokePaint.color = borderColor
        strokePaint.strokeWidth = borderWidth
    }

    private fun setupSize(size: Int): Int {
        return when(MeasureSpec.getMode(size)) {
            MeasureSpec.UNSPECIFIED -> DEFAULT_SIZE
            MeasureSpec.AT_MOST -> DEFAULT_SIZE
            MeasureSpec.EXACTLY -> MeasureSpec.getSize(size)
            else -> DEFAULT_SIZE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRoundRect(rect, borderRadius, borderRadius, fillPaint)


        canvas?.drawRoundRect(rect, borderRadius, borderRadius, strokePaint)
    }

    companion object {
        private const val DEFAULT_SIZE = 200

        private const val DEFAULT_RADIUS = 5F
        private const val DEFAULT_BORDER_WIDTH = 2F
        private const val DEFAULT_BORDER_COLOR = Color.BLUE
    }
}