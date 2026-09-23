package com.google.android.libraries.navigation.internal.agg;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fm extends fi {
    private boolean a;
    protected int c;

    protected fm(int i) {
        super(i);
        this.c = -1;
        this.a = false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, com.google.android.libraries.navigation.internal.agg.fh
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        fh fhVarTrySplit = super.trySplit();
        if (!this.a && fhVarTrySplit != null) {
            this.c = b();
            this.a = true;
        }
        return fhVarTrySplit;
    }

    protected abstract int b();

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final int e() {
        return this.a ? this.c : b();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, com.google.android.libraries.navigation.internal.agg.r, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
        return trySplit();
    }

    protected fm(int i, int i2) {
        super(i);
        this.c = i2;
        this.a = true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, com.google.android.libraries.navigation.internal.agg.r, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return trySplit();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, com.google.android.libraries.navigation.internal.agg.r, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return trySplit();
    }
}
