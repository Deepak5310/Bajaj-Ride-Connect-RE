package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends an {
    final /* synthetic */ o a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(o oVar, int i) {
        super(i);
        this.a = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am, com.google.android.libraries.navigation.internal.agd.b, com.google.android.libraries.navigation.internal.agd.al
    /* JADX INFO: renamed from: b */
    public final void forEachRemaining(ai aiVar) {
        o oVar = this.a;
        int i = oVar.c - oVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            o oVar2 = this.a;
            byte[] bArr = oVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            aiVar.c(bArr[oVar2.b + i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am, com.google.android.libraries.navigation.internal.agd.al
    public final byte c() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        o oVar = this.a;
        byte[] bArr = oVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return bArr[oVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.an, com.google.android.libraries.navigation.internal.agd.s
    public final byte d() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        o oVar = this.a;
        byte[] bArr = oVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return bArr[oVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am, com.google.android.libraries.navigation.internal.agd.b, java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ai) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final byte j(int i) {
        o oVar = this.a;
        return oVar.d.a[oVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final int k() {
        o oVar = this.a;
        return oVar.c - oVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.an
    protected final void l(int i, byte b) {
        this.a.p(i, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.am
    protected final void m(int i) {
        this.a.m(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.an
    protected final void n(int i, byte b) {
        this.a.n(i, b);
    }
}
