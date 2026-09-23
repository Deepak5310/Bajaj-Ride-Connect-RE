package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum dc implements com.google.android.libraries.navigation.internal.ael.bm {
    NORMAL(1),
    PREFETCH_OFFLINE_MAP(4),
    PREFETCH_SAVE_THIS_ROUTE(5),
    PREFETCH_ROUTE(6),
    PREFETCH_AREA(12);

    private final int g;

    dc(int i) {
        this.g = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.g);
    }
}
