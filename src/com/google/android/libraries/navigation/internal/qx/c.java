package com.google.android.libraries.navigation.internal.qx;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c {
    public static final Rect a(String str, float f, Typeface typeface) {
        Rect rect = new Rect();
        if (aq.c(str)) {
            return rect;
        }
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setTypeface(typeface);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }
}
