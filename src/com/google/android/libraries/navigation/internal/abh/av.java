package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends ImageView implements Animation.AnimationListener, com.google.android.libraries.navigation.internal.ly.u {
    Matrix a;
    public final Animation b;
    public final Animation c;
    public boolean d;
    private Matrix e;
    private float f;
    private float g;
    private boolean h;

    public av(be beVar) {
        super(beVar.a);
        this.h = false;
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageDrawable(beVar.l(com.google.android.gms.maps.al.q));
        setBackground(beVar.l(com.google.android.gms.maps.al.l));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.b = alphaAnimation;
        alphaAnimation.setDuration(100L);
        alphaAnimation.setAnimationListener(this);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.c = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        alphaAnimation2.setStartOffset(1600L);
        alphaAnimation2.setAnimationListener(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.u
    public final void a(CameraPosition cameraPosition) {
        if (this.d) {
            this.f = cameraPosition.bearing;
            this.g = cameraPosition.tilt;
            b();
        }
    }

    protected final void b() {
        Matrix matrix;
        Matrix matrix2 = this.e;
        if (matrix2 != null && (matrix = this.a) != null) {
            matrix.set(matrix2);
            this.a.postRotate(-this.f, getWidth() / 2.0f, getHeight() / 2.0f);
            float f = (this.g / 90.0f) * 0.7f;
            this.a.postScale(1.0f, 1.0f - f);
            this.a.postTranslate(0.0f, (f / 2.0f) * getHeight());
            setImageMatrix(this.a);
        }
        float f2 = this.g;
        float f3 = this.f;
        if (f2 <= 0.5f && (f3 < 0.5f || f3 > 359.5f)) {
            if (getVisibility() == 0) {
                Animation animation = getAnimation();
                Animation animation2 = this.c;
                if (animation != animation2) {
                    this.h = false;
                    startAnimation(animation2);
                    return;
                }
                return;
            }
            return;
        }
        if (getVisibility() == 0 && getAnimation() == this.c) {
            this.h = true;
            clearAnimation();
        } else if (getVisibility() == 4) {
            Animation animation3 = getAnimation();
            Animation animation4 = this.b;
            if (animation3 != animation4) {
                startAnimation(animation4);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        if (animation == this.c && this.d && !this.h) {
            setVisibility(4);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (animation == this.b && this.d) {
            setVisibility(0);
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = new Matrix();
        this.a = new Matrix();
        this.e.setRectToRect(new RectF(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight()), new RectF(0.0f, 0.0f, i, i2), Matrix.ScaleToFit.CENTER);
        b();
    }
}
