package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bm implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_ENABLED_STATE(0),
    ENABLED(1),
    COUNTERFACTUAL(2);

    private final int e;

    bm(int i) {
        this.e = i;
    }

    public static bm b(int i) {
        if (i == 0) {
            return UNKNOWN_ENABLED_STATE;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i != 2) {
            return null;
        }
        return COUNTERFACTUAL;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.e);
    }
}
