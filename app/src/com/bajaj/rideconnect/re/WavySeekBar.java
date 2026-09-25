package com.bajaj.rideconnect.re;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;

/**
 * Android 14/15 Material You inspired Wavy/Squiggly Media Scrubber SeekBar.
 * Features:
 * - Sleek, thin stroke thickness (2.5dp) for high-end automotive styling.
 * - Smooth sine wave ripple animation when music is playing.
 * - Graceful transition to flat straight line when paused.
 * - Smooth envelope damping at wave boundaries (starts and ends seamlessly on centerline).
 * - Full-height tactile touch hit-box (40dp) for effortless tapping and scrubbing.
 * - High-contrast glowing cyan & white thumb handle.
 */
public class WavySeekBar extends SeekBar {

    private final Paint wavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint bgTrackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint thumbPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint thumbGlowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path wavePath = new Path();

    private float density = 1.0f;
    private float strokeWidth;
    private float waveAmplitude;
    private float waveLength;
    private float currentAmplitude = 0f;
    private float phase = 0f;

    private float thumbRadius;
    private float thumbGlowRadius;

    private boolean isPlaying = false;
    private boolean isDragging = false;

    private ValueAnimator waveAnimator;
    private ValueAnimator amplitudeAnimator;
    private OnSeekBarChangeListener listener;

    public WavySeekBar(Context context) {
        super(context);
        init(context);
    }

    public WavySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WavySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        density = context.getResources().getDisplayMetrics().density;

        strokeWidth = 2.5f * density;
        waveAmplitude = 3.5f * density;
        waveLength = 22.0f * density;
        thumbRadius = 5.5f * density;
        thumbGlowRadius = 8.5f * density;

        // Wave Paint (Played progress) - Vibrant Neon Cyan
        wavePaint.setColor(Color.parseColor("#38BDF8"));
        wavePaint.setStyle(Paint.Style.STROKE);
        wavePaint.setStrokeWidth(strokeWidth);
        wavePaint.setStrokeCap(Paint.Cap.ROUND);
        wavePaint.setStrokeJoin(Paint.Join.ROUND);

        // Background Track (Unplayed) - Sleek Dark Slate
        bgTrackPaint.setColor(Color.parseColor("#222838"));
        bgTrackPaint.setStyle(Paint.Style.STROKE);
        bgTrackPaint.setStrokeWidth(strokeWidth);
        bgTrackPaint.setStrokeCap(Paint.Cap.ROUND);

        // Thumb Paints
        thumbPaint.setColor(Color.WHITE);
        thumbPaint.setStyle(Paint.Style.FILL);

        thumbGlowPaint.setColor(Color.parseColor("#06B6D4"));
        thumbGlowPaint.setStyle(Paint.Style.FILL);

        // Clear default Android SeekBar drawables to ensure 100% custom canvas rendering
        setProgressDrawable(new ColorDrawable(Color.TRANSPARENT));
        setThumb(new ColorDrawable(Color.TRANSPARENT));
        setSplitTrack(false);
        setBackgroundColor(Color.TRANSPARENT);

        // Default to flat line until playing state is enabled
        currentAmplitude = 0f;
    }

    /**
     * Dynamically updates the Material You accent color for the wave ripple and thumb glow.
     */
    public void setAccentColor(int accentColor) {
        wavePaint.setColor(accentColor);
        thumbGlowPaint.setColor(accentColor);
        invalidate();
    }

    @Override
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        super.setOnSeekBarChangeListener(l);
        this.listener = l;
    }

    /**
     * Updates playback state. Starts wavy ripple animation when playing,
     * or smoothly flattens out into a straight line when paused.
     */
    public void setPlaying(boolean playing) {
        if (this.isPlaying == playing) return;
        this.isPlaying = playing;
        animateStateTransition();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    private void animateStateTransition() {
        if (amplitudeAnimator != null) {
            amplitudeAnimator.cancel();
        }

        float targetAmp = isPlaying ? waveAmplitude : 0f;
        amplitudeAnimator = ValueAnimator.ofFloat(currentAmplitude, targetAmp);
        amplitudeAnimator.setDuration(350);
        amplitudeAnimator.addUpdateListener(animation -> {
            currentAmplitude = (float) animation.getAnimatedValue();
            invalidate();
        });
        amplitudeAnimator.start();

        if (isPlaying) {
            if (waveAnimator == null) {
                waveAnimator = ValueAnimator.ofFloat(0f, (float) (2 * Math.PI));
                waveAnimator.setDuration(1200);
                waveAnimator.setInterpolator(new LinearInterpolator());
                waveAnimator.setRepeatCount(ValueAnimator.INFINITE);
                waveAnimator.addUpdateListener(animation -> {
                    phase = (float) animation.getAnimatedValue();
                    invalidate();
                });
            }
            if (!waveAnimator.isRunning()) {
                waveAnimator.start();
            }
        } else {
            if (waveAnimator != null && currentAmplitude <= 0.05f) {
                waveAnimator.cancel();
            }
        }
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredHeight = Math.round(36f * density);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int measuredHeight;
        if (heightMode == MeasureSpec.EXACTLY) {
            measuredHeight = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            measuredHeight = Math.min(desiredHeight, heightSize);
        } else {
            measuredHeight = desiredHeight;
        }

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), measuredHeight);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) return;

        float centerY = h / 2f;
        float trackStart = getPaddingLeft() + thumbGlowRadius;
        float trackEnd = w - getPaddingRight() - thumbGlowRadius;
        float trackWidth = Math.max(1f, trackEnd - trackStart);

        int max = getMax();
        float progressFraction = (max > 0) ? Math.max(0f, Math.min(1f, (float) getProgress() / max)) : 0f;
        float thumbX = trackStart + trackWidth * progressFraction;

        // 1. Draw Unplayed Track (Straight line from thumbX to trackEnd)
        if (thumbX < trackEnd) {
            canvas.drawLine(thumbX, centerY, trackEnd, centerY, bgTrackPaint);
        }

        // 2. Draw Played Track (Wavy Sine Wave from trackStart to thumbX)
        if (thumbX > trackStart) {
            float playedWidth = thumbX - trackStart;
            if (currentAmplitude > 0.1f && playedWidth > 4f * density) {
                wavePath.reset();
                wavePath.moveTo(trackStart, centerY);

                float step = 2.0f * density;
                float rampDist = Math.min(waveLength * 0.75f, playedWidth / 2f);

                for (float x = trackStart; x <= thumbX; x += step) {
                    float distStart = x - trackStart;
                    float distEnd = thumbX - x;
                    float env = 1f;

                    if (rampDist > 0.1f) {
                        float startRamp = Math.min(1f, distStart / rampDist);
                        float endRamp = Math.min(1f, distEnd / rampDist);
                        float minRamp = Math.min(startRamp, endRamp);
                        // Smooth sinusoidal easing envelope
                        env = (float) Math.sin(minRamp * Math.PI / 2.0);
                    }

                    float angle = (float) (2.0 * Math.PI * (x - trackStart) / waveLength - phase);
                    float y = centerY + currentAmplitude * env * (float) Math.sin(angle);
                    wavePath.lineTo(x, y);
                }

                // Ensure perfect connection to thumb point
                wavePath.lineTo(thumbX, centerY);
                canvas.drawPath(wavePath, wavePaint);
            } else {
                // Flat line fallback when paused or very short progress
                canvas.drawLine(trackStart, centerY, thumbX, centerY, wavePaint);
            }
        }

        // 3. Draw Thumb Handle
        float currentGlow = isDragging ? (thumbGlowRadius + 3.0f * density) : thumbGlowRadius;
        int glowAlpha = isDragging ? 180 : 120;
        thumbGlowPaint.setAlpha(glowAlpha);
        canvas.drawCircle(thumbX, centerY, currentGlow, thumbGlowPaint);

        // Inner solid white circle
        canvas.drawCircle(thumbX, centerY, thumbRadius, thumbPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) return false;

        float trackStart = getPaddingLeft() + thumbGlowRadius;
        float trackEnd = getWidth() - getPaddingRight() - thumbGlowRadius;
        float trackWidth = Math.max(1f, trackEnd - trackStart);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isDragging = true;
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                updateTouchProgress(event.getX(), trackStart, trackWidth);
                if (listener != null) {
                    listener.onStartTrackingTouch(this);
                }
                invalidate();
                return true;

            case MotionEvent.ACTION_MOVE:
                if (isDragging) {
                    updateTouchProgress(event.getX(), trackStart, trackWidth);
                    invalidate();
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isDragging) {
                    updateTouchProgress(event.getX(), trackStart, trackWidth);
                    isDragging = false;
                    if (listener != null) {
                        listener.onStopTrackingTouch(this);
                    }
                    invalidate();
                    return true;
                }
                break;
        }

        return super.onTouchEvent(event);
    }

    private void updateTouchProgress(float x, float trackStart, float trackWidth) {
        float clampedX = Math.max(trackStart, Math.min(trackStart + trackWidth, x));
        float fraction = (clampedX - trackStart) / trackWidth;
        int newProgress = Math.round(fraction * getMax());
        setProgress(newProgress);
        if (listener != null) {
            listener.onProgressChanged(this, newProgress, true);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (waveAnimator != null) {
            waveAnimator.cancel();
        }
        if (amplitudeAnimator != null) {
            amplitudeAnimator.cancel();
        }
    }
}
