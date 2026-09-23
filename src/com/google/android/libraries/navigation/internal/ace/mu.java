package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum mu implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_SEVERITY(0),
    HIGH_SEVERITY(1),
    MODERATE_SEVERITY(2),
    LOW_SEVERITY(3),
    NEUTRAL_SEVERITY(4);

    private final int g;

    mu(int i) {
        this.g = i;
    }

    public static mu b(int i) {
        if (i == 0) {
            return UNKNOWN_SEVERITY;
        }
        if (i == 1) {
            return HIGH_SEVERITY;
        }
        if (i == 2) {
            return MODERATE_SEVERITY;
        }
        if (i == 3) {
            return LOW_SEVERITY;
        }
        if (i != 4) {
            return null;
        }
        return NEUTRAL_SEVERITY;
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
