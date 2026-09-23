package com.google.android.libraries.geo.mapcore.renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements h {
    private final int a;
    private final Resources b;
    private Bitmap c;

    public k(Resources resources, int i) {
        this.b = resources;
        this.a = i;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final Bitmap a() {
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.b, this.a);
        this.c = bitmapDecodeResource;
        return bitmapDecodeResource;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final eg b() {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(this.b, this.a, options);
        int i2 = this.b.getDisplayMetrics().densityDpi;
        TypedValue typedValue = new TypedValue();
        this.b.getValue(this.a, typedValue, true);
        if (typedValue.density == 65535) {
            i = i2;
        } else {
            i = typedValue.density == 0 ? 160 : typedValue.density;
        }
        float f = i2 / i;
        return new g((int) ((options.outWidth * f) + 0.5f), (int) ((options.outHeight * f) + 0.5f));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final void c() {
        this.c = null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ac
    public final boolean d() {
        return true;
    }
}
