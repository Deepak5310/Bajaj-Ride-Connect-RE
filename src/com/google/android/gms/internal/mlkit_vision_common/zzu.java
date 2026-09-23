package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzu extends zzp {
    final /* synthetic */ zzv zza;

    zzu(zzv zzvVar) {
        this.zza = zzvVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzf.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzv zzvVar = this.zza;
        int i2 = i + i;
        Object obj = zzvVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzvVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
