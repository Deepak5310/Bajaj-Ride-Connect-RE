package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static Bitmap a(Drawable drawable, int i, int i2, Bitmap.Config config) {
        ar.a(i > 0);
        ar.a(i2 > 0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap b(Drawable drawable, int i, int i2, Bitmap.Config config) {
        ar.a(i > 0);
        ar.a(i2 > 0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, i, i2);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
        } else {
            int iWidth = rect.width();
            int iHeight = rect.height();
            float f = intrinsicWidth;
            float f2 = intrinsicHeight;
            float fMin = Math.min(iWidth / f, iHeight / f2);
            int iRound = Math.round(f * fMin);
            int iRound2 = Math.round(f2 * fMin);
            int iRound3 = Math.round((iWidth - iRound) * 0.5f);
            int iRound4 = Math.round((iHeight - iRound2) * 0.5f);
            drawable.setBounds(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
        }
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
