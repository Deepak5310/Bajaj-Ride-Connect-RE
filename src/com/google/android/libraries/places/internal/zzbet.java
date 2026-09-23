package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbet implements Runnable {
    final /* synthetic */ zzbfr zza;

    /* synthetic */ zzbet(zzbfr zzbfrVar, zzbes zzbesVar) {
        this.zza = zzbfrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar = this.zza;
        if (zzbfrVar.zzG == null) {
            return;
        }
        zzbfr.zzO(zzbfrVar);
    }
}
