package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements h {
    private final Bitmap a;
    private final eg b;

    public i(Bitmap bitmap) {
        this.a = bitmap;
        this.b = bitmap != null ? new g(bitmap.getWidth(), bitmap.getHeight()) : new g(0, 0);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final Bitmap a() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final eg b() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final void c() {
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ac
    public final boolean d() {
        return true;
    }
}
