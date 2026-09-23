package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkj implements Runnable {
    final /* synthetic */ zzbkn zza;

    zzbkj(zzbkn zzbknVar) {
        this.zza = zzbknVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzbkn zzbknVar = this.zza;
            if (zzbknVar.zzh != null && zzbknVar.zzb.getZzb() > 0) {
                zzbknVar.zzh.zzn(zzbknVar.zzb, zzbknVar.zzb.getZzb());
            }
        } catch (IOException e) {
            this.zza.zzd.zzb(e);
        }
        try {
            zzbkn zzbknVar2 = this.zza;
            if (zzbknVar2.zzh != null) {
                zzbknVar2.zzh.close();
            }
        } catch (IOException e2) {
            this.zza.zzd.zzb(e2);
        }
        try {
            zzbkn zzbknVar3 = this.zza;
            if (zzbknVar3.zzi != null) {
                zzbknVar3.zzi.close();
            }
        } catch (IOException e3) {
            this.zza.zzd.zzb(e3);
        }
    }
}
