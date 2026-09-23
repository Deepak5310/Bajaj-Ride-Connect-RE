package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbau implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbax zzb;

    zzbau(zzbax zzbaxVar, zzaxd zzaxdVar) {
        this.zzb = zzbaxVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkt.zzo(((zzbeo) this.zzb.zzh).zza.zzP.get(), "Channel must have been shut down");
    }
}
