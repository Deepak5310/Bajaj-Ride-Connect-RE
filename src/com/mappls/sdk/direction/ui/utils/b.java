package com.mappls.sdk.direction.ui.utils;

import android.content.Context;
import com.mappls.sdk.direction.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static int a(int i, int i2, Context context) {
        return context.getTheme().obtainStyledAttributes(R.styleable.mappls_direction).getColor(i, i2);
    }

    public static int b(int i, int i2, Context context) {
        return context.getTheme().obtainStyledAttributes(R.styleable.mappls_direction).getResourceId(i, i2);
    }
}
