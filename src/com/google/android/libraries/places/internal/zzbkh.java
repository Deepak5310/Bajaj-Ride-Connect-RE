package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkh extends zzbkm {
    final zzbpa zza;
    final /* synthetic */ zzbkn zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbkh(zzbkn zzbknVar) {
        super(zzbknVar, null);
        this.zzb = zzbknVar;
        this.zza = zzbpb.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbkm
    public final void zza() throws IOException {
        int i;
        zzbpl zzbplVar = new zzbpl();
        int i2 = zzbpb.zza;
        synchronized (this.zzb.zza) {
            zzbkn zzbknVar = this.zzb;
            zzbplVar.zzn(zzbknVar.zzb, zzbknVar.zzb.zzf());
            this.zzb.zze = false;
            i = this.zzb.zzl;
        }
        this.zzb.zzh.zzn(zzbplVar, zzbplVar.getZzb());
        synchronized (this.zzb.zza) {
            this.zzb.zzl -= i;
        }
    }
}
