package com.google.android.libraries.navigation.internal.ap;

import android.view.View;
import android.view.ViewGroup;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static {
        Duration.ofSeconds(1L);
    }

    public static boolean a(View view, float f, float f2) {
        if (view.getBackground() != null) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    float scrollX = ((view.getScrollX() + f) - childAt.getLeft()) - childAt.getTranslationX();
                    float scrollY = ((view.getScrollY() + f2) - childAt.getTop()) - childAt.getTranslationY();
                    if (scrollX >= 0.0f && scrollX <= childAt.getWidth() && scrollY >= 0.0f && scrollY <= childAt.getHeight() && a(childAt, scrollX, scrollY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
