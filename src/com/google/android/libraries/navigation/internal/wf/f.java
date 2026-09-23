package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.aj;
import com.google.android.libraries.navigation.internal.rz.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class f extends com.google.android.libraries.navigation.internal.yx.v {
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        z zVar = (z) obj;
        switch (zVar) {
            case UNKNOWN:
                return aj.UNKNOWN;
            case STRAIGHT:
                return aj.STRAIGHT;
            case STRAIGHT_TALL:
                return aj.STRAIGHT_TALL;
            case SLIGHT:
                return aj.SLIGHT;
            case SLIGHT_TALL:
                return aj.SLIGHT_TALL;
            case NORMAL:
                return aj.NORMAL;
            case NORMAL_SHORT:
                return aj.NORMAL_SHORT;
            case SHARP:
                return aj.SHARP;
            case SHARP_SHORT:
                return aj.SHARP_SHORT;
            case UTURN:
                return aj.UTURN;
            case UTURN_SHORT:
                return aj.UTURN_SHORT;
            case STUB:
                return aj.STUB;
            default:
                throw new IllegalArgumentException("unknown enum value: ".concat(String.valueOf(String.valueOf(zVar))));
        }
    }
}
