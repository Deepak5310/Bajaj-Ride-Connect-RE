package com.mappls.sdk.navigation.ui.navigation.nextinstruction;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.mappls.sdk.navigation.ui.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends CardView {
    private int layoutMargin;
    private int layoutMarginBottom;
    private int layoutMarginEnd;
    private int layoutMarginStart;
    private int layoutMarginTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setClickable(true);
        setLayoutTransition(new LayoutTransition());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SoundController, i, i2);
            setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.SoundController_android_background, 0));
            this.layoutMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SoundController_android_layout_margin, -1);
            this.layoutMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SoundController_android_layout_marginTop, 0);
            this.layoutMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SoundController_android_layout_marginBottom, 0);
            this.layoutMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SoundController_android_layout_marginStart, 0);
            this.layoutMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SoundController_android_layout_marginEnd, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = this.layoutMargin;
        if (i >= 0) {
            marginLayoutParams.setMargins(i, i, i, i);
        } else {
            marginLayoutParams.setMargins(this.layoutMarginStart, this.layoutMarginTop, this.layoutMarginEnd, this.layoutMarginBottom);
        }
    }
}
