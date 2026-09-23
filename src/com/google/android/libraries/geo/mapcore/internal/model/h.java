package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends y {
    public byte[] a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private aa g;
    private byte h;

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final z a() {
        String str;
        aa aaVar;
        if (this.h != 15 || (str = this.b) == null || (aaVar = this.g) == null) {
            throw new IllegalStateException();
        }
        return new i(str, this.a, this.c, this.d, this.e, this.f, aaVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void b(int i) {
        this.f = i;
        this.h = (byte) (this.h | 8);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void c(int i) {
        this.e = i;
        this.h = (byte) (this.h | 4);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void d(int i) {
        this.d = i;
        this.h = (byte) (this.h | 2);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void e(aa aaVar) {
        Objects.requireNonNull(aaVar);
        this.g = aaVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void f(String str) {
        Objects.requireNonNull(str);
        this.b = str;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.y
    public final void g(int i) {
        this.c = i;
        this.h = (byte) (this.h | 1);
    }
}
