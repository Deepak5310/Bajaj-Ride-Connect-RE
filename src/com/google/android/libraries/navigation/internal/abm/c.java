package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    static final Paint a;
    static final Bitmap.Config b;
    private static c c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;

    static {
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        a = paint;
        b = Bitmap.Config.ARGB_8888;
    }

    public c() {
        synchronized (this) {
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    public static synchronized c h() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    final synchronized Bitmap a() {
        int[] iArr;
        iArr = new int[512];
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr, 0, 257, ViewCompat.MEASURED_STATE_MASK);
        return Bitmap.createBitmap(iArr, 1, 512, b);
    }

    final synchronized Bitmap b(Canvas canvas) {
        Bitmap.Config config;
        Bitmap bitmapCreateBitmap;
        config = b;
        bitmapCreateBitmap = Bitmap.createBitmap(512, 512, config);
        canvas.setBitmap(bitmapCreateBitmap);
        Paint paint = a;
        canvas.drawRect(0.0f, 257.0f, 512.0f, 0.01f, paint);
        canvas.drawCircle(256.0f, 256.0f, 256.0f, paint);
        return bitmapCreateBitmap.copy(config, false);
    }

    final synchronized Bitmap c() {
        return Bitmap.createBitmap(new int[]{ViewCompat.MEASURED_STATE_MASK}, 1, 1, b);
    }

    public final synchronized Bitmap d() {
        if (this.e == null) {
            Bitmap bitmapA = a();
            this.e = bitmapA;
            bitmapA.isMutable();
        }
        return this.e;
    }

    public final synchronized Bitmap f() {
        if (this.f == null) {
            Bitmap bitmapB = b(new Canvas());
            this.f = bitmapB;
            bitmapB.isMutable();
        }
        return this.f;
    }

    public final synchronized Bitmap g() {
        if (this.d == null) {
            Bitmap bitmapC = c();
            this.d = bitmapC;
            bitmapC.isMutable();
        }
        return this.d;
    }

    public final Bitmap e(int i) {
        if (i == 0) {
            return d();
        }
        if (i == 1) {
            return g();
        }
        if (i != 2) {
            return i != 3 ? d() : d();
        }
        return f();
    }
}
