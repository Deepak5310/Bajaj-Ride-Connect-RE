package com.google.android.libraries.navigation.internal.my;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static boolean a(TypedValue typedValue) {
        return typedValue.type >= 28 && typedValue.type <= 31;
    }

    public static TypedValue b(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        throw new IllegalArgumentException(String.format("Failed to resolve theme attribute: %s (resolveRefs = %s)", g.a(i, context), true));
    }
}
