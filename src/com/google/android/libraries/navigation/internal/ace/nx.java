package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum nx implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_SEVERITY(0),
    HIGH_SEVERITY(1),
    MODERATE_SEVERITY(2),
    LOW_SEVERITY(3);

    private final int f;

    nx(int i) {
        this.f = i;
    }

    public static nx b(int i) {
        if (i == 0) {
            return UNKNOWN_SEVERITY;
        }
        if (i == 1) {
            return HIGH_SEVERITY;
        }
        if (i == 2) {
            return MODERATE_SEVERITY;
        }
        if (i != 3) {
            return null;
        }
        return LOW_SEVERITY;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f);
    }
}
