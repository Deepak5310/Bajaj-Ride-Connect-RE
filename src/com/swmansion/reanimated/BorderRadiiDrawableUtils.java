package com.swmansion.reanimated;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.drawable.CSSBackgroundDrawable;
import com.facebook.react.uimanager.style.ComputedBorderRadius;

/* JADX INFO: loaded from: classes4.dex */
public class BorderRadiiDrawableUtils {
    public static ReactNativeUtils.BorderRadii getBorderRadii(View view) {
        Drawable background = view.getBackground();
        if (background instanceof CSSBackgroundDrawable) {
            CSSBackgroundDrawable cSSBackgroundDrawable = (CSSBackgroundDrawable) background;
            LengthPercentage uniform = cSSBackgroundDrawable.getBorderRadius().getUniform();
            float fResolve = uniform != null ? uniform.resolve(view.getWidth(), view.getHeight()) : Float.NaN;
            ComputedBorderRadius computedBorderRadius = cSSBackgroundDrawable.getComputedBorderRadius();
            return new ReactNativeUtils.BorderRadii(fResolve, computedBorderRadius.getTopLeft(), computedBorderRadius.getTopRight(), computedBorderRadius.getBottomLeft(), computedBorderRadius.getBottomRight());
        }
        return new ReactNativeUtils.BorderRadii(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }
}
