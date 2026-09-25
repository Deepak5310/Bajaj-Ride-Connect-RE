package com.bajaj.rideconnect.re

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.LinearInterpolator
import android.widget.SeekBar
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sin

class WavySeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SeekBar(context, attrs, defStyleAttr) {

    private val wavePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bgTrackPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val thumbPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val thumbGlowPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val wavePath = Path()

    private var density = 1.0f
    private var strokeWidth = 0f
    private var waveAmplitude = 0f
    private var waveLength = 0f
    private var currentAmplitude = 0f
    private var phase = 0f

    private var thumbRadius = 0f
    private var thumbGlowRadius = 0f

    var isPlaying: Boolean = false
        private set

    private var isDragging = false

    private var waveAnimator: ValueAnimator? = null
    private var amplitudeAnimator: ValueAnimator? = null
    private var listener: OnSeekBarChangeListener? = null

    init {
        density = context.resources.displayMetrics.density

        strokeWidth = 2.5f * density
        waveAmplitude = 3.5f * density
        waveLength = 22.0f * density
        thumbRadius = 5.5f * density
        thumbGlowRadius = 8.5f * density

        wavePaint.color = Color.parseColor("#38BDF8")
        wavePaint.style = Paint.Style.STROKE
        wavePaint.strokeWidth = strokeWidth
        wavePaint.strokeCap = Paint.Cap.ROUND
        wavePaint.strokeJoin = Paint.Join.ROUND

        bgTrackPaint.color = Color.parseColor("#222838")
        bgTrackPaint.style = Paint.Style.STROKE
        bgTrackPaint.strokeWidth = strokeWidth
        bgTrackPaint.strokeCap = Paint.Cap.ROUND

        thumbPaint.color = Color.WHITE
        thumbPaint.style = Paint.Style.FILL

        thumbGlowPaint.color = Color.parseColor("#06B6D4")
        thumbGlowPaint.style = Paint.Style.FILL

        progressDrawable = ColorDrawable(Color.TRANSPARENT)
        thumb = ColorDrawable(Color.TRANSPARENT)
        splitTrack = false
        setBackgroundColor(Color.TRANSPARENT)
        currentAmplitude = 0f
    }

    fun setAccentColor(accentColor: Int) {
        wavePaint.color = accentColor
        thumbGlowPaint.color = accentColor
        invalidate()
    }

    override fun setOnSeekBarChangeListener(l: OnSeekBarChangeListener?) {
        super.setOnSeekBarChangeListener(l)
        this.listener = l
    }

    fun setPlaying(playing: Boolean) {
        if (this.isPlaying == playing) return
        this.isPlaying = playing
        animateStateTransition()
    }

    private fun animateStateTransition() {
        amplitudeAnimator?.cancel()

        val targetAmp = if (isPlaying) waveAmplitude else 0f
        amplitudeAnimator = ValueAnimator.ofFloat(currentAmplitude, targetAmp).apply {
            duration = 350
            addUpdateListener { animation ->
                currentAmplitude = animation.animatedValue as Float
                invalidate()
            }
            start()
        }

        if (isPlaying) {
            if (waveAnimator == null) {
                waveAnimator = ValueAnimator.ofFloat(0f, (2 * PI).toFloat()).apply {
                    duration = 1200
                    interpolator = LinearInterpolator()
                    repeatCount = ValueAnimator.INFINITE
                    addUpdateListener { animation ->
                        phase = animation.animatedValue as Float
                        invalidate()
                    }
                }
            }
            if (waveAnimator?.isRunning != true) {
                waveAnimator?.start()
            }
        } else {
            if (currentAmplitude <= 0.05f) {
                waveAnimator?.cancel()
            }
        }
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredHeight = (36f * density).roundToInt()
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val measuredHeight = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> min(desiredHeight, heightSize)
            else -> desiredHeight
        }

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), measuredHeight)
    }

    @Synchronized
    override fun onDraw(canvas: Canvas) {
        val w = width
        val h = height
        if (w <= 0 || h <= 0) return

        val centerY = h / 2f
        val trackStart = paddingLeft + thumbGlowRadius
        val trackEnd = w - paddingRight - thumbGlowRadius
        val trackWidth = max(1f, trackEnd - trackStart)

        val maxVal = max
        val progressFraction = if (maxVal > 0) max(0f, min(1f, progress.toFloat() / maxVal)) else 0f
        val thumbX = trackStart + trackWidth * progressFraction

        if (thumbX < trackEnd) {
            canvas.drawLine(thumbX, centerY, trackEnd, centerY, bgTrackPaint)
        }

        if (thumbX > trackStart) {
            val playedWidth = thumbX - trackStart
            if (currentAmplitude > 0.1f && playedWidth > 4f * density) {
                wavePath.reset()
                wavePath.moveTo(trackStart, centerY)

                val step = 2.0f * density
                val rampDist = min(waveLength * 0.75f, playedWidth / 2f)

                var x = trackStart
                while (x <= thumbX) {
                    val distStart = x - trackStart
                    val distEnd = thumbX - x
                    var env = 1f

                    if (rampDist > 0.1f) {
                        val startRamp = min(1f, distStart / rampDist)
                        val endRamp = min(1f, distEnd / rampDist)
                        val minRamp = min(startRamp, endRamp)
                        env = sin(minRamp * PI / 2.0).toFloat()
                    }

                    val angle = (2.0 * PI * (x - trackStart) / waveLength - phase).toFloat()
                    val y = centerY + currentAmplitude * env * sin(angle.toDouble()).toFloat()
                    wavePath.lineTo(x, y)
                    x += step
                }

                wavePath.lineTo(thumbX, centerY)
                canvas.drawPath(wavePath, wavePaint)
            } else {
                canvas.drawLine(trackStart, centerY, thumbX, centerY, wavePaint)
            }
        }

        val currentGlow = if (isDragging) (thumbGlowRadius + 3.0f * density) else thumbGlowRadius
        val glowAlpha = if (isDragging) 180 else 120
        thumbGlowPaint.alpha = glowAlpha
        canvas.drawCircle(thumbX, centerY, currentGlow, thumbGlowPaint)
        canvas.drawCircle(thumbX, centerY, thumbRadius, thumbPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled) return false

        val trackStart = paddingLeft + thumbGlowRadius
        val trackEnd = width - paddingRight - thumbGlowRadius
        val trackWidth = max(1f, trackEnd - trackStart)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                isDragging = true
                parent?.requestDisallowInterceptTouchEvent(true)
                updateTouchProgress(event.x, trackStart, trackWidth)
                listener?.onStartTrackingTouch(this)
                invalidate()
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (isDragging) {
                    updateTouchProgress(event.x, trackStart, trackWidth)
                    invalidate()
                    return true
                }
            }
            MotionEvent.ACTION_UP -> {
                if (isDragging) {
                    updateTouchProgress(event.x, trackStart, trackWidth)
                    isDragging = false
                    listener?.onStopTrackingTouch(this)
                    performClick()
                    invalidate()
                    return true
                }
            }
            MotionEvent.ACTION_CANCEL -> {
                if (isDragging) {
                    updateTouchProgress(event.x, trackStart, trackWidth)
                    isDragging = false
                    listener?.onStopTrackingTouch(this)
                    invalidate()
                    return true
                }
            }
        }

        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private fun updateTouchProgress(x: Float, trackStart: Float, trackWidth: Float) {
        val clampedX = max(trackStart, min(trackStart + trackWidth, x))
        val fraction = (clampedX - trackStart) / trackWidth
        val newProgress = (fraction * max).roundToInt()
        progress = newProgress
        listener?.onProgressChanged(this, newProgress, true)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        waveAnimator?.cancel()
        amplitudeAnimator?.cancel()
    }
}
