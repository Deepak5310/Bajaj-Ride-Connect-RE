package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdp implements Runnable {
    final /* synthetic */ zzbds zza;

    zzbdp(zzbds zzbdsVar) {
        this.zza = zzbdsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzc.zzx = null;
        zzbds zzbdsVar = this.zza;
        zzbdu zzbduVar = zzbdsVar.zzc;
        if (zzbduVar.zzv != null) {
            zzkt.zzo(zzbduVar.zzt == null, "Unexpected non-null activeTransport");
            zzbds zzbdsVar2 = this.zza;
            zzbdsVar2.zza.zzd(zzbdsVar2.zzc.zzv);
        } else {
            zzazw zzazwVar = zzbdsVar.zza;
            if (zzbduVar.zzs == zzazwVar) {
                zzbduVar.zzt = zzazwVar;
                this.zza.zzc.zzs = null;
                zzbdu.zzz(this.zza.zzc, zzasu.READY);
            }
        }
    }
}
