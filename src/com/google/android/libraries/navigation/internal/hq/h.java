package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.afl.dz;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class h implements Function {
    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        dz dzVar = (dz) obj;
        int iOrdinal = dzVar.ordinal();
        if (iOrdinal == 0) {
            return com.google.android.libraries.navigation.internal.nk.o.GMM_SERVER_ONLY;
        }
        if (iOrdinal == 1) {
            return com.google.android.libraries.navigation.internal.nk.o.CLEARCUT_SERVICE_ONLY;
        }
        if (iOrdinal == 2) {
            return com.google.android.libraries.navigation.internal.nk.o.DUAL_WRITE;
        }
        if (iOrdinal == 3) {
            return com.google.android.libraries.navigation.internal.nk.o.NON_LOG204_CLEARCUT_ONLY_LOG204_GMM_SERVER_ONLY;
        }
        if (iOrdinal == 4) {
            return com.google.android.libraries.navigation.internal.nk.o.NON_LOG204_CLEARCUT_ONLY_LOG204_DUAL_WRITE;
        }
        throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(dzVar))));
    }
}
