package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbjg extends zzbje {
    private final AtomicIntegerFieldUpdater zza;

    /* synthetic */ zzbjg(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, zzbjf zzbjfVar) {
        super(null);
        this.zza = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.libraries.places.internal.zzbje
    public final void zza(zzbjj zzbjjVar, int i) {
        this.zza.set(zzbjjVar, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbje
    public final boolean zzb(zzbjj zzbjjVar, int i, int i2) {
        return this.zza.compareAndSet(zzbjjVar, 0, -1);
    }
}
