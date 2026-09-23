package com.google.android.libraries.navigation.internal.yy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum aq {
    STRONG,
    SOFT,
    WEAK;

    final com.google.android.libraries.navigation.internal.yx.y a() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return com.google.android.libraries.navigation.internal.yx.w.a;
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            return com.google.android.libraries.navigation.internal.yx.x.a;
        }
        throw null;
    }
}
