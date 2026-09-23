package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cs {
    public Bitmap a;
    public final byte[] b;
    public ab c;
    public final h d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;
    public final aa k;

    public cs(Bitmap bitmap, boolean z) {
        int width;
        int height;
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        if (bt.a().a(z)) {
            width = width2;
            height = height2;
        } else {
            bitmap = e(bitmap, bitmap.getConfig(), z);
            width = bitmap.getWidth();
            height = bitmap.getHeight();
            if (z) {
                width2 = width;
                height2 = height;
            }
        }
        this.a = bitmap;
        this.b = null;
        this.c = null;
        this.d = null;
        this.k = null;
        this.e = 0;
        this.f = width2;
        this.g = height2;
        this.h = width;
        this.i = height;
        this.j = z;
    }

    public cs(aa aaVar, int i, int i2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.k = aaVar;
        this.e = 0;
        this.f = i;
        this.g = i2;
        this.h = i;
        this.i = i2;
        this.j = false;
    }

    public cs(h hVar, int i, int i2, int i3, int i4, boolean z) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = hVar;
        this.k = null;
        this.e = 0;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.j = z;
    }

    public cs(byte[] bArr, int i, int i2, int i3, boolean z) {
        int iF;
        int iF2;
        if (bt.a().a(z)) {
            iF = i2;
            iF2 = i3;
        } else {
            iF = f(i2);
            iF2 = f(i3);
            if (!g(i2) || !g(i3)) {
                byte[] bArr2 = new byte[i * iF * iF2];
                for (int i4 = 0; i4 < i3; i4++) {
                    System.arraycopy(bArr, i4 * i2 * i, bArr2, i4 * iF * i, i2 * i);
                }
                bArr = bArr2;
            }
            if (z) {
                i2 = iF;
                i3 = iF2;
            }
        }
        this.a = null;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.k = null;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = iF;
        this.i = iF2;
        this.j = z;
    }

    public static Bitmap e(Bitmap bitmap, Bitmap.Config config, boolean z) {
        if (g(bitmap.getWidth()) && g(bitmap.getHeight())) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iF = f(width);
        int iF2 = f(height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF2, config);
        if (bitmapCreateBitmap == null) {
            throw new OutOfMemoryError(com.google.android.libraries.navigation.internal.b.b.l(iF2, iF, "Could not allocate new bitmap of size ", " * "));
        }
        bitmapCreateBitmap.setDensity(bitmap.getDensity());
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        if (z) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, iF, iF2), paint);
            return bitmapCreateBitmap;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (iF > width) {
            canvas.drawBitmap(bitmap, new Rect(width - 1, 0, width, height), new Rect(width, 0, width + 1, height), paint);
        }
        if (iF2 > height) {
            canvas.drawBitmap(bitmap, new Rect(0, height - 1, width, height), new Rect(0, height, width, height + 1), paint);
        }
        if (iF > width && iF2 > height) {
            canvas.drawBitmap(bitmap, new Rect(width - 1, height - 1, width, height), new Rect(width, height, width + 1, height + 1), paint);
        }
        return bitmapCreateBitmap;
    }

    public static int f(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 += i2;
        }
        return i2;
    }

    private static boolean g(int i) {
        return i != 0 && (i & (i + (-1))) == 0;
    }

    public final float a() {
        float f = this.f;
        float f2 = this.h;
        return ((f + f) - 1.0f) * (1.0f / (f2 + f2));
    }

    public final float b() {
        float f = this.g;
        float f2 = this.i;
        return ((f + f) - 1.0f) * (1.0f / (f2 + f2));
    }

    public final float c() {
        float f = this.h;
        return 1.0f / (f + f);
    }

    public final float d() {
        float f = this.i;
        return 1.0f / (f + f);
    }
}
