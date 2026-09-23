package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzau extends zzap {
    private final transient zzao zza;
    private final transient zzam zzb;

    zzau(zzao zzaoVar, zzam zzamVar) {
        this.zza = zzaoVar;
        this.zzb = zzamVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzap, com.google.android.gms.internal.mlkit_common.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzap, com.google.android.gms.internal.mlkit_common.zzai
    /* JADX INFO: renamed from: zzd */
    public final zzay iterator() {
        return this.zzb.listIterator(0);
    }
}
