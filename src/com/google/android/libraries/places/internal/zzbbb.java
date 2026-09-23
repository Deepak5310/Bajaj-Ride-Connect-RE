package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbb implements Runnable {
    final /* synthetic */ zzatg zza;
    final /* synthetic */ zzbbp zzb;

    zzbbb(zzbbp zzbbpVar, zzatg zzatgVar) {
        this.zzb = zzbbpVar;
        this.zza = zzatgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzl(this.zza);
    }
}
