package com.google.android.libraries.navigation.internal.px;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends dw {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private long g;
    private long h;
    private byte i;

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final dx a() {
        if (this.i == -1) {
            return new r(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void b(int i) {
        this.c = i;
        this.i = (byte) (this.i | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void c(long j) {
        this.h = j;
        this.i = (byte) (this.i | (-128));
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void d(long j) {
        this.g = j;
        this.i = (byte) (this.i | SignedBytes.MAX_POWER_OF_TWO);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void e(int i) {
        this.f = i;
        this.i = (byte) (this.i | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void f(int i) {
        this.e = i;
        this.i = (byte) (this.i | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void g(int i) {
        this.b = i;
        this.i = (byte) (this.i | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void h(int i) {
        this.a = i;
        this.i = (byte) (this.i | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.px.dw
    public final void i(int i) {
        this.d = i;
        this.i = (byte) (this.i | 8);
    }
}
