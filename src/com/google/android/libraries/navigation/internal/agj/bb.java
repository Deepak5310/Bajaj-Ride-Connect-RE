package com.google.android.libraries.navigation.internal.agj;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bb extends az {
    private boolean a;
    protected int c;

    protected bb(int i) {
        super(i);
        this.c = -1;
        this.a = false;
    }

    protected abstract int a();

    @Override // com.google.android.libraries.navigation.internal.agj.az, com.google.android.libraries.navigation.internal.agj.ay
    /* JADX INFO: renamed from: aV */
    public final ay trySplit() {
        int iG = g();
        int i = this.b;
        int iG2 = g();
        int i2 = this.b;
        int i3 = ((iG2 - i2) / 2) + i;
        ay ayVarB = null;
        if (i3 != i2 && i3 != iG) {
            if (i3 < i2 || i3 > iG) {
                throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.m(iG, i2, i3, "splitPoint ", " outside of range of current position ", " and range end "));
            }
            ayVarB = b(i2, i3);
            this.b = i3;
        }
        if (!this.a && ayVarB != null) {
            this.c = a();
            this.a = true;
        }
        return ayVarB;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    protected final int g() {
        return this.a ? this.c : a();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az, com.google.android.libraries.navigation.internal.agj.i, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return trySplit();
    }

    protected bb(int i, int i2) {
        super(i);
        this.c = i2;
        this.a = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az, com.google.android.libraries.navigation.internal.agj.i, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return trySplit();
    }
}
