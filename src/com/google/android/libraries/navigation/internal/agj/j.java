package com.google.android.libraries.navigation.internal.agj;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements ao {
    int a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ o d;

    public j(o oVar, int i) {
        this.c = i;
        this.d = oVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short a() {
        return ai.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        f((Short) obj);
    }

    @Override // java.util.PrimitiveIterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void forEachRemaining(ag agVar) {
        while (true) {
            int i = this.a;
            o oVar = this.d;
            if (i >= oVar.b) {
                return;
            }
            short[] sArr = oVar.a;
            this.a = i + 1;
            this.b = i;
            agVar.d(sArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short c() {
        return q.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj
    public final short d() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        short[] sArr = this.d.a;
        int i = this.a;
        this.a = i + 1;
        this.b = i;
        return sArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.r
    public final short e() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        short[] sArr = this.d.a;
        int i = this.a - 1;
        this.a = i;
        this.b = i;
        return sArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void f(Short sh) {
        an.d(this, sh);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ai.c(this, consumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void g(short s) {
        int i = this.a;
        this.a = i + 1;
        this.d.o(i, s);
        this.b = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void h(Short sh) {
        an.f(this, sh);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void i(short s) {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.n(i, s);
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
        return c();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao, java.util.ListIterator, java.util.Iterator
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
        h((Short) obj);
    }
}
