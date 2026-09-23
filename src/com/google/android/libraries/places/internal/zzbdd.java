package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdd implements Runnable {
    final /* synthetic */ zzbdu zza;

    zzbdd(zzbdu zzbduVar) {
        this.zza = zzbduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zzu.zza() == zzasu.IDLE) {
            this.zza.zzi.zza(2, "CONNECTING as requested");
            zzbdu.zzz(this.zza, zzasu.CONNECTING);
            zzbdu.zzD(this.zza);
        }
    }
}
