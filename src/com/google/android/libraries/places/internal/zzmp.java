package com.google.android.libraries.places.internal;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmp extends zzmb {
    private final transient zzma zza;
    private final transient zzlx zzb;

    zzmp(zzma zzmaVar, zzlx zzlxVar) {
        this.zza = zzmaVar;
        this.zzb = zzlxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    public final zzlx zzd() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    /* JADX INFO: renamed from: zze */
    public final zzmx iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final boolean zzf() {
        return true;
    }
}
