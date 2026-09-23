package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.afl.dx;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class g implements Function {
    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        dx dxVar = (dx) obj;
        int iOrdinal = dxVar.ordinal();
        if (iOrdinal == 0) {
            return com.google.android.libraries.navigation.internal.nk.m.UNKNOWN_UE3_REPORTER_FLUSH_STRATEGY;
        }
        if (iOrdinal == 1) {
            return com.google.android.libraries.navigation.internal.nk.m.NONE;
        }
        if (iOrdinal == 2) {
            return com.google.android.libraries.navigation.internal.nk.m.SEQUENTIAL_ON_UI_THREAD;
        }
        if (iOrdinal == 3) {
            return com.google.android.libraries.navigation.internal.nk.m.WAIT_ON_UI_THREAD;
        }
        throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(dxVar))));
    }
}
