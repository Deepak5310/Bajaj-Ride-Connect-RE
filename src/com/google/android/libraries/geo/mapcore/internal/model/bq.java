package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.fs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bq extends br {
    public final byte[] a;
    public final fs b;
    private final int c;
    private final int d;

    public bq(int i, int i2, byte[] bArr, ba baVar, int i3, fs fsVar) {
        super(baVar, i3);
        this.c = i;
        this.d = i2;
        this.a = bArr;
        this.b = fsVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int a() {
        return 6;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int c() {
        return this.d;
    }
}
