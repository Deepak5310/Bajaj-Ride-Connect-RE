package com.bajajconnect.navigate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.bajajconnect.R;

/* JADX INFO: loaded from: classes3.dex */
public class RecenterButton extends LinearLayout {
    private Animation slideUpBottom;

    public RecenterButton(Context context) {
        this(context, null);
    }

    public RecenterButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RecenterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void show() {
        setVisibility(0);
        startAnimation(this.slideUpBottom);
    }

    public void hide() {
        setVisibility(4);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initAnimation();
    }

    private void init() {
        inflate(getContext(), R.layout.recenter_btn_layout, this);
    }

    private void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 125.0f, 0.0f);
        this.slideUpBottom = translateAnimation;
        translateAnimation.setDuration(300L);
        this.slideUpBottom.setInterpolator(new OvershootInterpolator(2.0f));
    }
}
