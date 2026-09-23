package com.google.android.libraries.places.internal;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbov extends zzbow {
    private static final AtomicIntegerFieldUpdater zza = AtomicIntegerFieldUpdater.newUpdater(zzbov.class, "zzc");
    private final List zzb;
    private volatile int zzc;

    public zzbov(List list, int i) {
        zzkt.zzf(!list.isEmpty(), "empty list");
        this.zzb = list;
        this.zzc = i - 1;
    }

    public final String toString() {
        zzkn zzknVarZza = zzko.zza(zzbov.class);
        zzknVarZza.zzd("subchannelPickers", this.zzb);
        return zzknVarZza.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzauz
    public final zzaut zza(zzauu zzauuVar) {
        int size = this.zzb.size();
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = zza;
        int iIncrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
        if (iIncrementAndGet >= size) {
            int i = iIncrementAndGet % size;
            atomicIntegerFieldUpdater.compareAndSet(this, iIncrementAndGet, i);
            iIncrementAndGet = i;
        }
        return ((zzauz) this.zzb.get(iIncrementAndGet)).zza(zzauuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbow
    public final boolean zzb(zzbow zzbowVar) {
        if (!(zzbowVar instanceof zzbov)) {
            return false;
        }
        zzbov zzbovVar = (zzbov) zzbowVar;
        return zzbovVar == this || (this.zzb.size() == zzbovVar.zzb.size() && new HashSet(this.zzb).containsAll(zzbovVar.zzb));
    }
}
