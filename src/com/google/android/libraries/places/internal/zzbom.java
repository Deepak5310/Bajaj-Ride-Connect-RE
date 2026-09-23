package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbom extends zzbok {
    zzavb zza;
    final /* synthetic */ zzboo zzb;

    zzbom(zzboo zzbooVar) {
        this.zzb = zzbooVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbok, com.google.android.libraries.places.internal.zzaus
    public final void zzd(zzasu zzasuVar, zzauz zzauzVar) {
        zzboo zzbooVar = this.zzb;
        zzavb zzavbVar = this.zza;
        if (zzavbVar == zzbooVar.zzi) {
            zzkt.zzo(zzbooVar.zzl, "there's pending lb while current lb has been out of READY");
            this.zzb.zzj = zzasuVar;
            this.zzb.zzk = zzauzVar;
            if (zzasuVar == zzasu.READY) {
                this.zzb.zzr();
                return;
            }
            return;
        }
        if (zzavbVar == zzbooVar.zzg) {
            zzbooVar.zzl = zzasuVar == zzasu.READY;
            zzboo zzbooVar2 = this.zzb;
            if (zzbooVar2.zzl || zzbooVar2.zzi == zzbooVar2.zzd) {
                zzbooVar2.zze.zzd(zzasuVar, zzauzVar);
            } else {
                zzbooVar2.zzr();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbok
    protected final zzaus zze() {
        return this.zzb.zze;
    }
}
