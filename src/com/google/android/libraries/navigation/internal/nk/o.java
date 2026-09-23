package com.google.android.libraries.navigation.internal.nk;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum o implements bm {
    GMM_SERVER_ONLY(0),
    CLEARCUT_SERVICE_ONLY(1),
    DUAL_WRITE(2),
    NON_LOG204_CLEARCUT_ONLY_LOG204_GMM_SERVER_ONLY(3),
    NON_LOG204_CLEARCUT_ONLY_LOG204_DUAL_WRITE(4);

    public final int f;

    o(int i) {
        this.f = i;
    }

    public static o b(int i) {
        if (i == 0) {
            return GMM_SERVER_ONLY;
        }
        if (i == 1) {
            return CLEARCUT_SERVICE_ONLY;
        }
        if (i == 2) {
            return DUAL_WRITE;
        }
        if (i == 3) {
            return NON_LOG204_CLEARCUT_ONLY_LOG204_GMM_SERVER_ONLY;
        }
        if (i != 4) {
            return null;
        }
        return NON_LOG204_CLEARCUT_ONLY_LOG204_DUAL_WRITE;
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
