package com.google.android.libraries.navigation.internal.gz;

import android.graphics.Color;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static int a(String str, int i) {
        if (aq.c(str)) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return i;
        }
    }

    public static boolean b(String str) {
        if (aq.c(str)) {
            return false;
        }
        try {
            Color.parseColor(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
