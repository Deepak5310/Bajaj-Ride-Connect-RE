package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mappls.sdk.navigation.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0015J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H&R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mappls/sdk/navigation/ui/navigation/instructioncontainer/BaseInstructionContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "layoutMargin", "layoutMarginBottom", "layoutMarginEnd", "layoutMarginStart", "layoutMarginTop", "leftButtonIcon", "rightButtonIcon", "onAttachedToWindow", "", "setLeftButtonIcon", "resourceId", "setRightButtonIcon", "mappls-navigation-ui_thirdPartyRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseInstructionContainerView extends ConstraintLayout {
    private int layoutMargin;
    private int layoutMarginBottom;
    private int layoutMarginEnd;
    private int layoutMarginStart;
    private int layoutMarginTop;
    private int leftButtonIcon;
    private int rightButtonIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInstructionContainerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setClickable(true);
        setLayoutTransition(new LayoutTransition());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InstructionContainer, i, i2);
            setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.InstructionContainer_android_background, 0));
            this.layoutMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.InstructionContainer_android_layout_margin, -1);
            this.layoutMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.InstructionContainer_android_layout_marginTop, 0);
            this.layoutMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.InstructionContainer_android_layout_marginBottom, 0);
            this.layoutMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.InstructionContainer_android_layout_marginStart, 0);
            this.layoutMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.InstructionContainer_android_layout_marginEnd, 0);
            this.leftButtonIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.InstructionContainer_prevButtonIcon, 0);
            this.rightButtonIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.InstructionContainer_nextButtonIcon, 0);
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
        setLeftButtonIcon(this.leftButtonIcon);
        setRightButtonIcon(this.rightButtonIcon);
    }

    public abstract void setLeftButtonIcon(int resourceId);

    public abstract void setRightButtonIcon(int resourceId);
}
