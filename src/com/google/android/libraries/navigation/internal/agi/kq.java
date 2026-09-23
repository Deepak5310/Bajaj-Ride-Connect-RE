package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class kq extends gk {
    final /* synthetic */ ks a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kq(ks ksVar, int i) {
        super(i);
        this.a = ksVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final int a() {
        ks ksVar = this.a;
        return ksVar.c - ksVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final Object b(int i) {
        ks ksVar = this.a;
        return ksVar.d.a[ksVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk
    protected final void c(int i, Object obj) {
        this.a.add(i, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final void d(int i) {
        this.a.remove(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk
    protected final void e(int i, Object obj) {
        this.a.set(i, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj, java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        ks ksVar = this.a;
        int i = ksVar.c - ksVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            ks ksVar2 = this.a;
            Object[] objArr = ksVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            consumer.accept(objArr[ksVar2.b + i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj, java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ks ksVar = this.a;
        Object[] objArr = ksVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return objArr[ksVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk, java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        ks ksVar = this.a;
        Object[] objArr = ksVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return objArr[ksVar.b + i];
    }
}
