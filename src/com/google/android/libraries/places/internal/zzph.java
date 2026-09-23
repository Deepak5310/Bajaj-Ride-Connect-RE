package com.google.android.libraries.places.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzph implements Comparator {
    zzph() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzpo zzpoVarZza = zzpo.zza(obj);
        zzpo zzpoVarZza2 = zzpo.zza(obj2);
        if (zzpoVarZza != zzpoVarZza2) {
            return zzpoVarZza.compareTo(zzpoVarZza2);
        }
        int iOrdinal = zzpoVarZza.ordinal();
        if (iOrdinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (iOrdinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (iOrdinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (iOrdinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
