package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fa implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_STARTUP_EVENT_ACCOUNT_STATE(0),
    SIGNED_OUT_AS_UNKNOWN(1),
    RESTORED_AS_SIGNED_IN(2);

    public final int d;

    fa(int i) {
        this.d = i;
    }

    public static fa b(int i) {
        if (i == 0) {
            return UNKNOWN_STARTUP_EVENT_ACCOUNT_STATE;
        }
        if (i == 1) {
            return SIGNED_OUT_AS_UNKNOWN;
        }
        if (i != 2) {
            return null;
        }
        return RESTORED_AS_SIGNED_IN;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}
