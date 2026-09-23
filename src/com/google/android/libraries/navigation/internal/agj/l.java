package com.google.android.libraries.navigation.internal.agj;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends al {
    final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, int i) {
        super(i);
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak, com.google.android.libraries.navigation.internal.agj.b, com.google.android.libraries.navigation.internal.agj.aj
    /* JADX INFO: renamed from: b */
    public final void forEachRemaining(ag agVar) {
        n nVar = this.a;
        int i = nVar.c - nVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            n nVar2 = this.a;
            short[] sArr = nVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            agVar.d(sArr[nVar2.b + i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak, com.google.android.libraries.navigation.internal.agj.aj
    public final short d() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        n nVar = this.a;
        short[] sArr = nVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return sArr[nVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.al, com.google.android.libraries.navigation.internal.agj.r
    public final short e() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        n nVar = this.a;
        short[] sArr = nVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return sArr[nVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak, com.google.android.libraries.navigation.internal.agj.b, java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ag) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final int j() {
        n nVar = this.a;
        return nVar.c - nVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final short k(int i) {
        n nVar = this.a;
        return nVar.d.a[nVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.al
    protected final void l(int i, short s) {
        this.a.o(i, s);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ak
    protected final void m(int i) {
        this.a.m(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.al
    protected final void n(int i, short s) {
        this.a.n(i, s);
    }
}
