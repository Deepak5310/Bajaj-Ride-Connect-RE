package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfg implements Runnable {
    final /* synthetic */ zzbfh zza;

    zzbfg(zzbfh zzbfhVar) {
        this.zza = zzbfhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfh zzbfhVar = this.zza;
        zzbfr zzbfrVar = zzbfhVar.zzd.zza;
        if (zzbfrVar.zzK != null) {
            zzbfrVar.zzK.remove(zzbfhVar);
            if (this.zza.zzd.zza.zzK.isEmpty()) {
                zzbfr zzbfrVar2 = this.zza.zzd.zza;
                zzbfrVar2.zzg.zzc(zzbfrVar2.zzL, false);
                this.zza.zzd.zza.zzK = null;
                if (this.zza.zzd.zza.zzP.get()) {
                    zzbfq zzbfqVar = this.zza.zzd.zza.zzO;
                    Object obj = zzbfqVar.zza;
                    zzaxd zzaxdVar = zzbfr.zzd;
                    synchronized (obj) {
                        if (zzbfqVar.zzc != null) {
                            return;
                        }
                        zzbfqVar.zzc = zzaxdVar;
                        boolean zIsEmpty = zzbfqVar.zzb.isEmpty();
                        if (zIsEmpty) {
                            zzbfqVar.zzd.zzN.zzd(zzaxdVar);
                        }
                    }
                }
            }
        }
    }
}
