package com.reactnativekeyboardcontroller.extensions;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\f\u0010\u0010\u001a\u00020\u0007*\u00020\u0003H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"tmpIntArr", "", "screenLocation", "Landroid/view/View;", "getScreenLocation", "(Landroid/view/View;)[I", "copyBoundsInWindow", "", "rect", "Landroid/graphics/Rect;", "replaceStatusBarInsets", "Landroidx/core/view/WindowInsetsCompat;", "insets", "isStatusBarTranslucent", "", "active", "requestApplyInsetsWhenAttached", "react-native-keyboard-controller_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ViewKt {
    private static final int[] tmpIntArr = new int[2];

    public static final void requestApplyInsetsWhenAttached(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.reactnativekeyboardcontroller.extensions.ViewKt.requestApplyInsetsWhenAttached.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    v.removeOnAttachStateChangeListener(this);
                    v.requestApplyInsets();
                }
            });
        }
    }

    public static final void copyBoundsInWindow(View view, Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (view.isAttachedToWindow()) {
            rect.set(0, 0, view.getWidth(), view.getHeight());
            int[] iArr = tmpIntArr;
            view.getLocationInWindow(iArr);
            rect.offset(iArr[0], iArr[1]);
            return;
        }
        Logger.w$default(Logger.INSTANCE, "View.copyBoundsInWindow", "Can not copy bounds as view is not attached to window", null, 4, null);
    }

    public static final int[] getScreenLocation(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static final WindowInsetsCompat replaceStatusBarInsets(View view, WindowInsetsCompat insets, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (Build.VERSION.SDK_INT >= 30) {
            Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            Insets insets4 = insets.getInsets(WindowInsetsCompat.Type.ime());
            Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
            int i = z ? 0 : insets2.top;
            int i2 = insets4.bottom > 0 ? insets4.bottom : insets3.bottom;
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(insets);
            int iSystemBars = WindowInsetsCompat.Type.systemBars();
            int i3 = insets2.left;
            int i4 = insets2.right;
            if (z2) {
                i2 = insets2.bottom;
            }
            WindowInsetsCompat windowInsetsCompatBuild = builder.setInsets(iSystemBars, Insets.of(i3, i, i4, i2)).build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
            WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompatBuild);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
            return windowInsetsCompatOnApplyWindowInsets;
        }
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets2 = ViewCompat.onApplyWindowInsets(view, insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets2, "onApplyWindowInsets(...)");
        WindowInsetsCompat windowInsetsCompatReplaceSystemWindowInsets = windowInsetsCompatOnApplyWindowInsets2.replaceSystemWindowInsets(windowInsetsCompatOnApplyWindowInsets2.getSystemWindowInsetLeft(), z ? 0 : windowInsetsCompatOnApplyWindowInsets2.getSystemWindowInsetTop(), windowInsetsCompatOnApplyWindowInsets2.getSystemWindowInsetRight(), windowInsetsCompatOnApplyWindowInsets2.getSystemWindowInsetBottom());
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatReplaceSystemWindowInsets, "replaceSystemWindowInsets(...)");
        return windowInsetsCompatReplaceSystemWindowInsets;
    }
}
