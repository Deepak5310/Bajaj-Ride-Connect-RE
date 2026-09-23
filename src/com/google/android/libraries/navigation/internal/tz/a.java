package com.google.android.libraries.navigation.internal.tz;

import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends k {
    public int a;
    public int b;
    public byte g;
    private int h;
    private int i;
    private int j;
    private int k;
    public Optional c = Optional.empty();
    public Optional d = Optional.empty();
    public Optional e = Optional.empty();
    public Optional f = Optional.empty();
    private final Optional l = Optional.empty();
    private final Optional m = Optional.empty();

    @Override // com.google.android.libraries.navigation.internal.tz.k
    public final l a() {
        if (this.g == 63) {
            return new b(this.h, this.i, this.j, this.k, this.a, this.b, this.c, this.d, this.e, this.f, this.l, this.m);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.tz.k
    public final void b(int i) {
        this.h = i;
        this.g = (byte) (this.g | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.k
    public final void c(int i) {
        this.j = i;
        this.g = (byte) (this.g | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.k
    public final void d(int i) {
        this.i = i;
        this.g = (byte) (this.g | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.k
    public final void e() {
        this.k = -1;
        this.g = (byte) (this.g | 8);
    }
}
