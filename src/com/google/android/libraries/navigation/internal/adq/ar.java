package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ar implements bm {
    UNKNOWN_PARKING_DIFFICULTY(0),
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int f;

    ar(int i) {
        this.f = i;
    }

    public static ar b(int i) {
        if (i == 0) {
            return UNKNOWN_PARKING_DIFFICULTY;
        }
        if (i == 1) {
            return EASY;
        }
        if (i == 2) {
            return MEDIUM;
        }
        if (i != 3) {
            return null;
        }
        return HARD;
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
