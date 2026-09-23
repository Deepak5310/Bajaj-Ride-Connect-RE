package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements aq {
    int a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ p d;

    public k(p pVar, int i) {
        this.c = i;
        this.d = pVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte a() {
        return ak.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        g((Byte) obj);
    }

    @Override // java.util.PrimitiveIterator
    /* JADX INFO: renamed from: b */
    public final void forEachRemaining(ai aiVar) {
        while (true) {
            int i = this.a;
            p pVar = this.d;
            if (i >= pVar.b) {
                return;
            }
            byte[] bArr = pVar.a;
            this.a = i + 1;
            this.b = i;
            aiVar.c(bArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    public final byte c() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        byte[] bArr = this.d.a;
        int i = this.a;
        this.a = i + 1;
        this.b = i;
        return bArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.s
    public final byte d() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        byte[] bArr = this.d.a;
        int i = this.a - 1;
        this.a = i;
        this.b = i;
        return bArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte e() {
        return r.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void f(byte b) {
        int i = this.a;
        this.a = i + 1;
        this.d.p(i, b);
        this.b = -1;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ak.d(this, consumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void g(Byte b) {
        ap.c(this, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void h(byte b) {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.n(i, b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void i(Byte b) {
        ap.e(this, b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return e();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.m(i);
        int i2 = this.b;
        int i3 = this.a;
        if (i2 < i3) {
            this.a = i3 - 1;
        }
        this.b = -1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        i((Byte) obj);
    }
}
