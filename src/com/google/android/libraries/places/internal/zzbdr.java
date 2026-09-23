package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdr implements Runnable {
    final /* synthetic */ zzbds zza;

    zzbdr(zzbds zzbdsVar) {
        this.zza = zzbdsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbds zzbdsVar = this.zza;
        zzbdsVar.zzc.zzq.remove(zzbdsVar.zza);
        if (this.zza.zzc.zzu.zza() == zzasu.SHUTDOWN && this.zza.zzc.zzq.isEmpty()) {
            zzbdu.zzA(this.zza.zzc);
        }
    }
}
