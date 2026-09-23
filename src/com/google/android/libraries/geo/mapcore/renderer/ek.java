package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ek extends ey {
    public ek(String str, int i, int i2) {
        super(str, null, i, i2);
    }

    final synchronized void a(Bitmap bitmap, int i, int i2) {
        int width;
        int height;
        boolean z = true;
        try {
            if (bitmap == null) {
                width = com.google.android.libraries.navigation.internal.nq.a.f(i, 1);
                height = com.google.android.libraries.navigation.internal.nq.a.f(i2, 1);
            } else {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
            }
            int i3 = bt.a().b;
            if (width <= i3 && height <= i3) {
                if (this.f == 1) {
                    z = false;
                }
                if (bitmap != null) {
                    d(new cs(bitmap, z));
                    bitmap.getRowBytes();
                    bitmap.getHeight();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Textures with dimensions " + width + "x" + height + " are larger than  the maximum supported size " + i3 + "x" + i3);
        } catch (Throwable th) {
            throw th;
        }
    }
}
