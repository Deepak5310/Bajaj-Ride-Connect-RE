package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayz extends zzazz {
    final /* synthetic */ zzbpa zza;
    final /* synthetic */ zzbjv zzb;
    final /* synthetic */ zzazc zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzayz(zzazc zzazcVar, zzbpa zzbpaVar, zzbjv zzbjvVar) {
        super(zzazcVar.zza.zzi);
        this.zzc = zzazcVar;
        this.zza = zzbpaVar;
        this.zzb = zzbjvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazz
    public final void zza() {
        int i = zzbpb.zza;
        if (this.zzc.zzc != null) {
            zzbcu.zzh(this.zzb);
            return;
        }
        while (true) {
            try {
                InputStream inputStreamZza = this.zzb.zza();
                if (inputStreamZza == null) {
                    return;
                }
                try {
                    zzazc zzazcVar = this.zzc;
                    zzazcVar.zzb.zzc(zzazcVar.zza.zzd.zzd(inputStreamZza));
                    inputStreamZza.close();
                } catch (Throwable th) {
                    zzbcu.zzi(inputStreamZza);
                    throw th;
                }
            } catch (Throwable th2) {
                zzbcu.zzh(this.zzb);
                zzazc.zzc(this.zzc, zzaxd.zzb.zzf(th2).zzg("Failed to read message."));
                return;
            }
        }
    }
}
