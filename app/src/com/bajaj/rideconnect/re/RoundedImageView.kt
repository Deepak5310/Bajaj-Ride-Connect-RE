package com.bajaj.rideconnect.re

import android.content.Context
import android.graphics.Canvas
import android.graphics.Outline
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView

class RoundedImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private var clipPath: Path? = Path()
    private var rectF: RectF? = RectF()
    private var topLeftRadius = 0f
    private var topRightRadius = 0f
    private var bottomLeftRadius = 0f
    private var bottomRightRadius = 0f

    init {
        val density = context.resources.displayMetrics.density
        topLeftRadius = 15f * density
        topRightRadius = 15f * density
        bottomLeftRadius = 15f * density
        bottomRightRadius = 15f * density

        outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                if (view.width > 0 && view.height > 0) {
                    outline.setRoundRect(0, 0, view.width, view.height, topLeftRadius)
                }
            }
        }
        clipToOutline = true
    }

    fun setCornerRadii(tlDp: Float, trDp: Float, blDp: Float, brDp: Float) {
        val density = resources.displayMetrics.density
        topLeftRadius = tlDp * density
        topRightRadius = trDp * density
        bottomLeftRadius = blDp * density
        bottomRightRadius = brDp * density
        updatePath()
        invalidate()
    }

    private fun updatePath() {
        val path = clipPath ?: return
        val rect = rectF ?: return
        path.reset()
        val w = width
        val h = height
        if (w <= 0 || h <= 0) return

        rect.set(0f, 0f, w.toFloat(), h.toFloat())

        val d = drawable
        if (d != null && d.intrinsicWidth > 0 && d.intrinsicHeight > 0) {
            val mapped = RectF(0f, 0f, d.intrinsicWidth.toFloat(), d.intrinsicHeight.toFloat())
            imageMatrix.mapRect(mapped)
            if (mapped.width() > 10 && mapped.height() > 10) {
                mapped.intersect(0f, 0f, w.toFloat(), h.toFloat())
                rect.set(mapped)
            }
        }

        val radii = floatArrayOf(
            topLeftRadius, topLeftRadius,
            topRightRadius, topRightRadius,
            bottomRightRadius, bottomRightRadius,
            bottomLeftRadius, bottomLeftRadius
        )
        path.addRoundRect(rect, radii, Path.Direction.CW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updatePath()
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        updatePath()
        invalidate()
    }

    override fun draw(canvas: Canvas) {
        val path = clipPath
        if (path != null && !path.isEmpty) {
            canvas.save()
            canvas.clipPath(path)
            super.draw(canvas)
            canvas.restore()
        } else {
            super.draw(canvas)
        }
    }
}
