package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdc implements Runnable {
    final /* synthetic */ zzbdu zza;

    zzbdc(zzbdu zzbduVar) {
        this.zza = zzbduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzn = null;
        this.zza.zzi.zza(2, "CONNECTING after backoff");
        zzbdu.zzz(this.zza, zzasu.CONNECTING);
        zzbdu.zzD(this.zza);
    }
}
