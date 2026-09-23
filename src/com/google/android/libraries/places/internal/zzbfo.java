package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfo extends zzaxz {
    final zzaup zza;
    final zzauf zzb;
    final zzayw zzc;
    final zzayx zzd;
    List zze;
    zzbdu zzf;
    boolean zzg;
    boolean zzh;
    zzaxk zzi;
    final /* synthetic */ zzbfr zzj;

    zzbfo(zzbfr zzbfrVar, zzaup zzaupVar) {
        this.zzj = zzbfrVar;
        this.zze = zzaupVar.zzb();
        this.zza = zzaupVar;
        zzauf zzaufVarZzc = zzauf.zzc("Subchannel", zzbfrVar.zzb());
        this.zzb = zzaufVarZzc;
        zzayx zzayxVar = new zzayx(zzaufVarZzc, 0, zzbfrVar.zzx.zza(), "Subchannel for ".concat(zzaupVar.zzb().toString()));
        this.zzd = zzayxVar;
        this.zzc = new zzayw(zzayxVar, zzbfrVar.zzx);
    }

    public final String toString() {
        return this.zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzauy
    public final void zza() {
        this.zzj.zzf.zzd();
        zzkt.zzo(this.zzg, "not started");
        this.zzf.zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzauy
    public final void zzb() {
        zzaxk zzaxkVar;
        this.zzj.zzf.zzd();
        if (this.zzf == null) {
            this.zzh = true;
            return;
        }
        if (!this.zzh) {
            this.zzh = true;
        } else {
            if (!this.zzj.zzQ || (zzaxkVar = this.zzi) == null) {
                return;
            }
            zzaxkVar.zza();
            this.zzi = null;
        }
        zzbfr zzbfrVar = this.zzj;
        if (zzbfrVar.zzQ) {
            this.zzf.zzE(zzbfr.zzd);
            return;
        }
        this.zzi = zzbfrVar.zzf.zza(new zzbdz(new zzbfn(this)), 5L, TimeUnit.SECONDS, this.zzj.zzr.zzb());
    }
}
