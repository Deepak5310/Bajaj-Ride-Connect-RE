package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ar implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_MODE(0),
    FOLLOW(1),
    INSPECT_STEP(2),
    INSPECT_ROUTE(3),
    SEARCH_RESULTS(4),
    OVERRIDE_MODE(5),
    OVERVIEW_MODE(6),
    FREE_MOVEMENT(7),
    ARRIVAL(8);

    private final int k;

    ar(int i) {
        this.k = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.k;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.k);
    }
}
