package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends ca {
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public byte g;
    private int h;
    private int i;

    public n() {
    }

    public n(cb cbVar) {
        o oVar = (o) cbVar;
        this.a = oVar.a;
        this.b = oVar.b;
        this.h = oVar.c;
        this.c = oVar.d;
        this.d = oVar.e;
        this.e = oVar.f;
        this.i = oVar.g;
        this.f = oVar.h;
        this.g = (byte) -1;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.ca
    public final cb a() {
        if (this.g == -1) {
            return new o(this.a, this.b, this.h, this.c, this.d, this.e, this.i, this.f);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.ca
    public final void b(int i) {
        this.i = i;
        this.g = (byte) (this.g | SignedBytes.MAX_POWER_OF_TWO);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.ca
    public final void c(int i) {
        this.h = i;
        this.g = (byte) (this.g | 4);
    }
}
