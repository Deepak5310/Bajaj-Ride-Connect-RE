package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum dx implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_UE3_REPORTER_FLUSH_STRATEGY(0),
    NONE(1),
    SEQUENTIAL_ON_UI_THREAD(2),
    WAIT_ON_UI_THREAD(3);

    private final int f;

    dx(int i) {
        this.f = i;
    }

    public static dx b(int i) {
        if (i == 0) {
            return UNKNOWN_UE3_REPORTER_FLUSH_STRATEGY;
        }
        if (i == 1) {
            return NONE;
        }
        if (i == 2) {
            return SEQUENTIAL_ON_UI_THREAD;
        }
        if (i != 3) {
            return null;
        }
        return WAIT_ON_UI_THREAD;
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
