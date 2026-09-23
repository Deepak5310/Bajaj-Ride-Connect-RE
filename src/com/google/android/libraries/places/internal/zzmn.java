package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmn extends zzlx {
    final /* synthetic */ zzmo zza;

    zzmn(zzmo zzmoVar) {
        this.zza = zzmoVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzkt.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzmo zzmoVar = this.zza;
        int i2 = i + i;
        Object obj = zzmoVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzmoVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    public final boolean zzf() {
        return true;
    }
}
