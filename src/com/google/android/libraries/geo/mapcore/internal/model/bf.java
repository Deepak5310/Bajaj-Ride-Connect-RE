package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bf extends br {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final fd e;
    public final boolean f;
    private final int g;
    private final int h;

    public bf(int i, int i2, float f, float f2, int i3, int i4, ba baVar, int i5, fd fdVar, boolean z) {
        super(baVar, i5);
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.g = i3;
        this.h = i4;
        this.e = null;
        this.f = false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int a() {
        return 13;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int b() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int c() {
        return this.h;
    }
}
