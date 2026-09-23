package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbki extends zzbkm {
    final zzbpa zza;
    final /* synthetic */ zzbkn zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbki(zzbkn zzbknVar) {
        super(zzbknVar, null);
        this.zzb = zzbknVar;
        this.zza = zzbpb.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbkm
    public final void zza() throws IOException {
        zzbpl zzbplVar = new zzbpl();
        int i = zzbpb.zza;
        synchronized (this.zzb.zza) {
            zzbkn zzbknVar = this.zzb;
            zzbplVar.zzn(zzbknVar.zzb, zzbknVar.zzb.getZzb());
            this.zzb.zzf = false;
        }
        this.zzb.zzh.zzn(zzbplVar, zzbplVar.getZzb());
        this.zzb.zzh.flush();
    }
}
