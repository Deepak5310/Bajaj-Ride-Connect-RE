package com.google.android.libraries.navigation.internal.tz;

import com.google.common.base.Ascii;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends o {
    public int a;
    public l b;
    public l c;
    public l d;
    public r e;
    public r f;
    public int g;
    public r h;
    public int i;
    public int j;
    public r k;
    public int l;
    public Optional m = Optional.empty();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte f609n;

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void a(int i) {
        this.a = i;
        this.f609n = (byte) (this.f609n | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void b(l lVar) {
        Objects.requireNonNull(lVar);
        this.b = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void c(r rVar) {
        Objects.requireNonNull(rVar);
        this.h = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void d(l lVar) {
        Objects.requireNonNull(lVar);
        this.c = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void e(int i) {
        this.j = i;
        this.f609n = (byte) (this.f609n | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void f(int i) {
        this.l = i;
        this.f609n = (byte) (this.f609n | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void g(int i) {
        this.i = i;
        this.f609n = (byte) (this.f609n | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void h(r rVar) {
        Objects.requireNonNull(rVar);
        this.k = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void i(r rVar) {
        Objects.requireNonNull(rVar);
        this.e = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void j(r rVar) {
        Objects.requireNonNull(rVar);
        this.f = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.o
    public final void k(l lVar) {
        Objects.requireNonNull(lVar);
        this.d = lVar;
    }
}
