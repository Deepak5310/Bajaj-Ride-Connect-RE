package com.google.android.libraries.navigation.internal.gd;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum h implements bm {
    UNSPECIFIED(0),
    TIME_CRITICAL(1),
    TIME_DEFERRABLE(2);

    public final int d;

    h(int i) {
        this.d = i;
    }

    public static h b(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return TIME_CRITICAL;
        }
        if (i != 2) {
            return null;
        }
        return TIME_DEFERRABLE;
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
