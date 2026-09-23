package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.az;
import com.google.android.libraries.navigation.internal.rz.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class g extends com.google.android.libraries.navigation.internal.yx.v {
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        aa aaVar = (aa) obj;
        int iOrdinal = aaVar.ordinal();
        if (iOrdinal == 0) {
            return az.SIDE_UNSPECIFIED;
        }
        if (iOrdinal == 1) {
            return az.SIDE_LEFT;
        }
        if (iOrdinal == 2) {
            return az.SIDE_RIGHT;
        }
        throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(aaVar))));
    }
}
