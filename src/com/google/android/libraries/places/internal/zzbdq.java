package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdq implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbds zzb;

    zzbdq(zzbds zzbdsVar, zzaxd zzaxdVar) {
        this.zzb = zzbdsVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzc.zzu.zza() == zzasu.SHUTDOWN) {
            return;
        }
        zzbds zzbdsVar = this.zzb;
        if (zzbdsVar.zzc.zzt == zzbdsVar.zza) {
            this.zzb.zzc.zzt = null;
            this.zzb.zzc.zzk.zzd();
            zzbdu.zzz(this.zzb.zzc, zzasu.IDLE);
            return;
        }
        zzbds zzbdsVar2 = this.zzb;
        zzbdu zzbduVar = zzbdsVar2.zzc;
        if (zzbduVar.zzs == zzbdsVar2.zza) {
            zzkt.zzq(zzbduVar.zzu.zza() == zzasu.CONNECTING, "Expected state is CONNECTING, actual state is %s", this.zzb.zzc.zzu.zza());
            this.zzb.zzc.zzk.zzc();
            if (this.zzb.zzc.zzk.zzg()) {
                zzbdu.zzD(this.zzb.zzc);
                return;
            }
            this.zzb.zzc.zzs = null;
            this.zzb.zzc.zzk.zzd();
            zzbdu.zzC(this.zzb.zzc, this.zza);
        }
    }
}
