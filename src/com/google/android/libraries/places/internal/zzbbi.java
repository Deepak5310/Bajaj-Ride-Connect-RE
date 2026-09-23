package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbi implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbbp zzb;

    zzbbi(zzbbp zzbbpVar, zzaxd zzaxdVar) {
        this.zzb = zzbbpVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzh(this.zza);
    }
}
