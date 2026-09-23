package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.az;
import com.google.android.libraries.navigation.internal.adr.hs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class h extends com.google.android.libraries.navigation.internal.yx.v {
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        hs hsVar = (hs) obj;
        int iOrdinal = hsVar.ordinal();
        if (iOrdinal == 0) {
            return az.SIDE_LEFT;
        }
        if (iOrdinal == 1) {
            return az.SIDE_RIGHT;
        }
        if (iOrdinal == 2) {
            return az.SIDE_UNSPECIFIED;
        }
        throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(hsVar))));
    }
}
