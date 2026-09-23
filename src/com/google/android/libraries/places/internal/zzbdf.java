package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdf implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzbdu zzb;

    zzbdf(zzbdu zzbduVar, List list) {
        this.zzb = zzbduVar;
        this.zza = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgc zzbgcVar;
        SocketAddress socketAddressZzb = this.zzb.zzk.zzb();
        this.zzb.zzk.zze(this.zza);
        this.zzb.zzl = this.zza;
        if ((this.zzb.zzu.zza() != zzasu.READY && this.zzb.zzu.zza() != zzasu.CONNECTING) || this.zzb.zzk.zzh(socketAddressZzb)) {
            zzbgcVar = null;
        } else if (this.zzb.zzu.zza() == zzasu.READY) {
            zzbdu zzbduVar = this.zzb;
            zzbgcVar = zzbduVar.zzt;
            zzbduVar.zzt = null;
            this.zzb.zzk.zzd();
            zzbdu.zzz(this.zzb, zzasu.IDLE);
        } else {
            this.zzb.zzs.zzd(zzaxd.zzp.zzg("InternalSubchannel closed pending transport due to address change"));
            this.zzb.zzs = null;
            this.zzb.zzk.zzd();
            zzbdu.zzD(this.zzb);
            zzbgcVar = null;
        }
        if (zzbgcVar != null) {
            zzbdu zzbduVar2 = this.zzb;
            if (zzbduVar2.zzo != null) {
                zzbduVar2.zzp.zzd(zzaxd.zzp.zzg("InternalSubchannel closed transport early due to address change"));
                this.zzb.zzo.zza();
                this.zzb.zzo = null;
                this.zzb.zzp = null;
            }
            this.zzb.zzp = zzbgcVar;
            zzbdu zzbduVar3 = this.zzb;
            zzbduVar3.zzo = zzbduVar3.zzj.zza(new zzbde(this), 5L, TimeUnit.SECONDS, zzbduVar3.zze);
        }
    }
}
