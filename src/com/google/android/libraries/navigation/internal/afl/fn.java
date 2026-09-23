package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fn implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_NAVIGATION_SDK_LOG_MECHANISM(0),
    UE3_ONLY(1),
    CLEARCUT_ONLY(2),
    UE3_AND_CLEARCUT(3);

    private final int f;

    fn(int i) {
        this.f = i;
    }

    public static fn b(int i) {
        if (i == 0) {
            return UNKNOWN_NAVIGATION_SDK_LOG_MECHANISM;
        }
        if (i == 1) {
            return UE3_ONLY;
        }
        if (i == 2) {
            return CLEARCUT_ONLY;
        }
        if (i != 3) {
            return null;
        }
        return UE3_AND_CLEARCUT;
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
