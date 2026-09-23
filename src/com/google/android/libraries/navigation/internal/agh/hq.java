package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class hq extends hm {
    private boolean a;
    protected int c;

    protected hq(int i) {
        super(i);
        this.c = -1;
        this.a = false;
    }

    protected abstract int a();

    @Override // com.google.android.libraries.navigation.internal.agh.hm, com.google.android.libraries.navigation.internal.agh.hl
    /* JADX INFO: renamed from: aP */
    public final hl trySplit() {
        hl hlVarTrySplit = super.trySplit();
        if (!this.a && hlVarTrySplit != null) {
            this.c = a();
            this.a = true;
        }
        return hlVarTrySplit;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final int e() {
        return this.a ? this.c : a();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, com.google.android.libraries.navigation.internal.agh.x, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
        return trySplit();
    }

    protected hq(int i, int i2) {
        super(i);
        this.c = i2;
        this.a = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, com.google.android.libraries.navigation.internal.agh.x, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return trySplit();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, com.google.android.libraries.navigation.internal.agh.x, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return trySplit();
    }
}
