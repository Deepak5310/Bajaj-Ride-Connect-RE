package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmo extends zzmb {
    private final transient zzma zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzmo(zzma zzmaVar, Object[] objArr, int i, int i2) {
        this.zza = zzmaVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    /* JADX INFO: renamed from: zze */
    public final zzmx iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzmb
    final zzlx zzi() {
        return new zzmn(this);
    }
}
