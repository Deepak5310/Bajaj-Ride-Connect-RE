package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmm extends zzlx {
    static final zzlx zza = new zzmm(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzmm(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzkt.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzlx, com.google.android.libraries.places.internal.zzlt
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final Object[] zzg() {
        return this.zzb;
    }
}
