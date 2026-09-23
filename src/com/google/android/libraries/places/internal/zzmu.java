package com.google.android.libraries.places.internal;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmu extends zzmb {
    final transient Object zza;

    zzmu(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzmb, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzmc(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.zza.toString() + "]";
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    public final zzlx zzd() {
        return zzlx.zzm(this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    /* JADX INFO: renamed from: zze */
    public final zzmx iterator() {
        return new zzmc(this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final boolean zzf() {
        return false;
    }
}
