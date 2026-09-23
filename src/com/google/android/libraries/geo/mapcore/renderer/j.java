package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements h {
    private Bitmap a;
    private final eg b;

    public j(Bitmap bitmap) {
        this.a = bitmap;
        this.b = new g(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.h
    public final Bitmap a() {
        Bitmap bitmap = this.a;
        this.a = null;
        return bitmap;
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
        return this.a != null;
    }
}
