package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzas extends zzam {
    final /* synthetic */ zzat zza;

    zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzab.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzat zzatVar = this.zza;
        int i2 = i + i;
        Object obj = zzatVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzatVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
