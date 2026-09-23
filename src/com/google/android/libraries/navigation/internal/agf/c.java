package com.google.android.libraries.navigation.internal.agf;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements v {
    int a = 0;
    final /* synthetic */ e b;

    public c(e eVar) {
        this.b = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final float a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        float[] fArr = this.b.a;
        int i = this.a;
        this.a = i + 1;
        return fArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final /* synthetic */ Float b() {
        return u.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ void forEachRemaining(s sVar) {
        u.c(this, sVar);
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((s) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        u.e(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.b;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public final void remove() {
        e eVar = this.b;
        int i = eVar.b;
        eVar.b = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        float[] fArr = eVar.a;
        System.arraycopy(fArr, i2, fArr, i3, i - i2);
    }
}
