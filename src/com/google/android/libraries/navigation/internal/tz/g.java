package com.google.android.libraries.navigation.internal.tz;

import android.graphics.Typeface;
import com.google.common.base.Ascii;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends q {
    private int a;
    private int b;
    private Typeface c;
    private int d;
    private int e;
    private int f;
    private int g;
    private byte h;

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final r a() {
        Typeface typeface;
        if (this.h != 63 || (typeface = this.c) == null) {
            throw new IllegalStateException();
        }
        return new h(this.a, this.b, typeface, this.d, this.e, this.f, this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void b(int i) {
        this.f = i;
        this.h = (byte) (this.h | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void c(int i) {
        this.g = i;
        this.h = (byte) (this.h | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void d(int i) {
        this.d = i;
        this.h = (byte) (this.h | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void e(int i) {
        this.e = i;
        this.h = (byte) (this.h | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void f(int i) {
        this.a = i;
        this.h = (byte) (this.h | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void g(int i) {
        this.b = i;
        this.h = (byte) (this.h | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.q
    public final void h(Typeface typeface) {
        Objects.requireNonNull(typeface);
        this.c = typeface;
    }
}
