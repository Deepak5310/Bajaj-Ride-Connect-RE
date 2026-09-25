package com.bajaj.rideconnect.re;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/**
 * Custom ImageView supporting independent corner radii (top-left, top-right, bottom-left, bottom-right).
 * Dynamically computes image bounds and clips the actual visible artwork with smooth rounded corners,
 * seamlessly matching the cockpit's rounded frosted card container.
 */
public class RoundedImageView extends ImageView {

    private Path clipPath = new Path();
    private final RectF rectF = new RectF();
    private float topLeftRadius;
    private float topRightRadius;
    private float bottomLeftRadius;
    private float bottomRightRadius;

    public RoundedImageView(Context context) {
        super(context);
        init(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        if (clipPath == null) {
            clipPath = new Path();
        }
        float density = context.getResources().getDisplayMetrics().density;
        // Default: Uniform 15dp rounded corners matching the inner artwork stage
        topLeftRadius = 15f * density;
        topRightRadius = 15f * density;
        bottomLeftRadius = 15f * density;
        bottomRightRadius = 15f * density;

        setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                if (view.getWidth() > 0 && view.getHeight() > 0) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), topLeftRadius);
                }
            }
        });
        setClipToOutline(true);
    }

    public void setCornerRadii(float tlDp, float trDp, float blDp, float brDp) {
        float density = getResources().getDisplayMetrics().density;
        this.topLeftRadius = tlDp * density;
        this.topRightRadius = trDp * density;
        this.bottomLeftRadius = blDp * density;
        this.bottomRightRadius = brDp * density;
        updatePath();
        invalidate();
    }

    private void updatePath() {
        if (clipPath == null) return;
        clipPath.reset();
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) return;

        rectF.set(0, 0, w, h);

        Drawable d = getDrawable();
        if (d != null && d.getIntrinsicWidth() > 0 && d.getIntrinsicHeight() > 0) {
            RectF mapped = new RectF(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            getImageMatrix().mapRect(mapped);
            if (mapped.width() > 10 && mapped.height() > 10) {
                mapped.intersect(0, 0, w, h);
                rectF.set(mapped);
            }
        }

        float[] radii = new float[] {
            topLeftRadius, topLeftRadius,
            topRightRadius, topRightRadius,
            bottomRightRadius, bottomRightRadius,
            bottomLeftRadius, bottomLeftRadius
        };
        clipPath.addRoundRect(rectF, radii, Path.Direction.CW);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updatePath();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (clipPath != null) {
            updatePath();
            invalidate();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (clipPath != null && !clipPath.isEmpty()) {
            canvas.save();
            canvas.clipPath(clipPath);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }
}
