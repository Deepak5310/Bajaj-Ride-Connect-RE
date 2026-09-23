package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.mappls.sdk.navigation.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mappls/sdk/navigation/ui/navigation/infobar/BaseInfobarBottomSheet;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "layoutMargin", "layoutMarginBottom", "layoutMarginEnd", "layoutMarginStart", "layoutMarginTop", "onAttachedToWindow", "", "mappls-navigation-ui_thirdPartyRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseInfobarBottomSheet extends CoordinatorLayout {
    private int layoutMargin;
    private int layoutMarginBottom;
    private int layoutMarginEnd;
    private int layoutMarginStart;
    private int layoutMarginTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInfobarBottomSheet(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setClickable(true);
        setLayoutTransition(new LayoutTransition());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetInfoBar, i, i2);
            setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.BottomSheetInfoBar_android_background, 0));
            this.layoutMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetInfoBar_android_layout_margin, -1);
            this.layoutMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetInfoBar_android_layout_marginTop, 0);
            this.layoutMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetInfoBar_android_layout_marginBottom, 0);
            this.layoutMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetInfoBar_android_layout_marginStart, 0);
            this.layoutMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetInfoBar_android_layout_marginEnd, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
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
