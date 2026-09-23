package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblb implements zzaxr {
    final /* synthetic */ zzbld zza;

    zzblb(zzbld zzbldVar) {
        this.zza = zzbldVar;
    }

    @Override // com.google.android.libraries.places.internal.zzaxr
    public final void zza(zzaxd zzaxdVar) {
        int i = zzbpb.zza;
        synchronized (this.zza.zzf.zzc) {
            this.zza.zzf.zzQ(zzaxdVar, true, null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxr
    public final void zzb(zzbkf zzbkfVar, boolean z, boolean z2, int i) {
        zzbpl zzbplVarZze;
        int i2 = zzbpb.zza;
        if (zzbkfVar == null) {
            zzbplVarZze = zzbld.zza;
        } else {
            zzbplVarZze = ((zzbls) zzbkfVar).zze();
            int zzb = (int) zzbplVarZze.getZzb();
            if (zzb > 0) {
                this.zza.zzs(zzb);
            }
        }
        synchronized (this.zza.zzf.zzc) {
            zzblc.zzL(this.zza.zzf, zzbplVarZze, z, z2);
            this.zza.zze().zzd(i);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxr
    public final void zzc(zzavu zzavuVar, byte[] bArr) {
        int i = zzbpb.zza;
        String str = RemoteSettings.FORWARD_SLASH_STRING + this.zza.zzb.zzf();
        synchronized (this.zza.zzf.zzc) {
            zzblc.zzM(this.zza.zzf, zzavuVar, str);
        }
    }
}
