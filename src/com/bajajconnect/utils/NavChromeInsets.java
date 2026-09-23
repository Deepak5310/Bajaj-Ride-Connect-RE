package com.bajajconnect.utils;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.mediarouter.media.SystemMediaRouteProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class NavChromeInsets {
    private NavChromeInsets() {
    }

    public static void applyBottomChromeInsets(View view, final View view2, final View... viewArr) {
        if (view2 == null) {
            return;
        }
        final int paddingBottom = view2.getPaddingBottom();
        if (viewArr == null) {
            viewArr = new View[0];
        }
        final int[] iArr = new int[viewArr.length];
        for (int i = 0; i < viewArr.length; i++) {
            View view3 = viewArr[i];
            if (view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                iArr[i] = ((ViewGroup.MarginLayoutParams) view3.getLayoutParams()).bottomMargin;
            }
        }
        Runnable runnable = new Runnable() { // from class: com.bajajconnect.utils.NavChromeInsets$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NavChromeInsets.lambda$applyBottomChromeInsets$0(view2, paddingBottom, viewArr, iArr);
            }
        };
        ViewCompat.setOnApplyWindowInsetsListener(view2, new OnApplyWindowInsetsListener() { // from class: com.bajajconnect.utils.NavChromeInsets$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view4, WindowInsetsCompat windowInsetsCompat) {
                return NavChromeInsets.lambda$applyBottomChromeInsets$1(paddingBottom, viewArr, iArr, view4, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(view2);
        view2.post(runnable);
        view2.postDelayed(runnable, 250L);
        view2.postDelayed(runnable, 1000L);
    }

    static /* synthetic */ void lambda$applyBottomChromeInsets$0(View view, int i, View[] viewArr, int[] iArr) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null) {
            return;
        }
        applyPaddingAndFabMargins(view, i, viewArr, iArr, resolveBottomInset(view, rootWindowInsets));
    }

    static /* synthetic */ WindowInsetsCompat lambda$applyBottomChromeInsets$1(int i, View[] viewArr, int[] iArr, View view, WindowInsetsCompat windowInsetsCompat) {
        applyPaddingAndFabMargins(view, i, viewArr, iArr, resolveBottomInset(view, windowInsetsCompat));
        return windowInsetsCompat;
    }

    private static void applyPaddingAndFabMargins(View view, int i, View[] viewArr, int[] iArr, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i + i2);
        for (int i3 = 0; i3 < viewArr.length; i3++) {
            View view2 = viewArr[i3];
            if (view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                marginLayoutParams.bottomMargin = iArr[i3] + i2;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private static int resolveBottomInset(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int i2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom;
        int dimensionPixelSize = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        int iMax = Math.max(i, i2);
        if (iMax > 0) {
            dimensionPixelSize = iMax;
        }
        if (dimensionPixelSize <= 0 && Build.VERSION.SDK_INT >= 35 && windowInsetsCompat.isVisible(WindowInsetsCompat.Type.navigationBars())) {
            try {
                int identifier = view.getResources().getIdentifier("navigation_bar_height", "dimen", SystemMediaRouteProvider.PACKAGE_NAME);
                if (identifier > 0) {
                    dimensionPixelSize = view.getResources().getDimensionPixelSize(identifier);
                }
            } catch (Exception unused) {
            }
        }
        return Math.max(0, dimensionPixelSize);
    }
}
