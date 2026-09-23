package com.google.android.libraries.places.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzawv implements Comparator {
    final /* synthetic */ zzaww zza;

    zzawv(zzaww zzawwVar) {
        this.zza = zzawwVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.zza.zza(obj);
        this.zza.zza(obj2);
        return obj.getClass().getName().compareTo(obj2.getClass().getName());
    }
}
