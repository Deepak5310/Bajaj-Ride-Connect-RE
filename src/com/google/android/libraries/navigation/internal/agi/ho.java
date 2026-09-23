package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ho extends hk {
    private boolean a;
    protected int c;

    protected ho(int i) {
        super(i);
        this.c = -1;
        this.a = false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final hj trySplit() {
        hj hjVarTrySplit = super.trySplit();
        if (!this.a && hjVarTrySplit != null) {
            this.c = d();
            this.a = true;
        }
        return hjVarTrySplit;
    }

    protected abstract int d();

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final int e() {
        return this.a ? this.c : d();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, com.google.android.libraries.navigation.internal.agi.w, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return trySplit();
    }

    protected ho(int i, int i2) {
        super(i);
        this.c = i2;
        this.a = true;
    }
}
