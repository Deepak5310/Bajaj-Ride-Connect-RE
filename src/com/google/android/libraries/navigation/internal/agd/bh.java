package com.google.android.libraries.navigation.internal.agd;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bh extends bf {
    private boolean a;
    protected int c;

    protected bh(int i) {
        super(i);
        this.c = -1;
        this.a = false;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf, com.google.android.libraries.navigation.internal.agd.be
    /* JADX INFO: renamed from: aL */
    public final be trySplit() {
        int iG = g();
        int i = this.b;
        int iG2 = g();
        int i2 = this.b;
        int i3 = ((iG2 - i2) / 2) + i;
        be beVarC = null;
        if (i3 != i2 && i3 != iG) {
            if (i3 < i2 || i3 > iG) {
                throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.m(iG, i2, i3, "splitPoint ", " outside of range of current position ", " and range end "));
            }
            beVarC = c(i2, i3);
            this.b = i3;
        }
        if (!this.a && beVarC != null) {
            this.c = b();
            this.a = true;
        }
        return beVarC;
    }

    protected abstract int b();

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    protected final int g() {
        return this.a ? this.c : b();
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf, com.google.android.libraries.navigation.internal.agd.j, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return trySplit();
    }

    protected bh(int i, int i2) {
        super(i);
        this.c = i2;
        this.a = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf, com.google.android.libraries.navigation.internal.agd.j, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return trySplit();
    }
}
