package com.google.android.libraries.places.internal;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfe implements Runnable {
    final /* synthetic */ zzbfh zza;
    final /* synthetic */ zzbfj zzb;

    zzbfe(zzbfj zzbfjVar, zzbfh zzbfhVar) {
        this.zzb = zzbfjVar;
        this.zza = zzbfhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzb.get() != zzbfr.zzi) {
            this.zza.zzl();
            return;
        }
        zzbfj zzbfjVar = this.zzb;
        if (zzbfjVar.zza.zzK == null) {
            zzbfjVar.zza.zzK = new LinkedHashSet();
            zzbfr zzbfrVar = this.zzb.zza;
            zzbfrVar.zzg.zzc(zzbfrVar.zzL, true);
        }
        zzbfj zzbfjVar2 = this.zzb;
        zzbfjVar2.zza.zzK.add(this.zza);
    }
}
