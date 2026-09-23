package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbac implements Runnable {
    final /* synthetic */ StringBuilder zza;
    final /* synthetic */ zzbaq zzb;

    zzbac(zzbaq zzbaqVar, StringBuilder sb) {
        this.zzb = zzbaqVar;
        this.zza = sb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzl(zzaxd.zze.zzg(this.zza.toString()), true);
    }
}
