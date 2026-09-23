package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fw extends gk {
    final /* synthetic */ fy a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw(fy fyVar, int i) {
        super(i);
        this.a = fyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final int a() {
        fy fyVar = this.a;
        return fyVar.c - fyVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj
    protected final Object b(int i) {
        fy fyVar = this.a;
        return fyVar.d.a[fyVar.b + i];
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
        fy fyVar = this.a;
        int i = fyVar.c - fyVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            fy fyVar2 = this.a;
            Object[] objArr = fyVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            consumer.accept(objArr[fyVar2.b + i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gj, java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        fy fyVar = this.a;
        Object[] objArr = fyVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return objArr[fyVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gk, java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        fy fyVar = this.a;
        Object[] objArr = fyVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return objArr[fyVar.b + i];
    }
}
