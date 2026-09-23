package com.google.android.libraries.navigation.internal.aer;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum m implements bm {
    UNKNOWN(0),
    CONTRACT_HAPPY_MEAL(1),
    ALLOWLIST_TOS(2),
    UNRECOGNIZED(-1);

    private final int f;

    m(int i) {
        this.f = i;
    }

    public static m b(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return CONTRACT_HAPPY_MEAL;
        }
        if (i != 2) {
            return null;
        }
        return ALLOWLIST_TOS;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(a());
    }
}
