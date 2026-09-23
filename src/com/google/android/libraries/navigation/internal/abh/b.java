package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static boolean a(Context context) {
        if (context.getSystemService("accessibility") == null) {
            return false;
        }
        return ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
    }
}
