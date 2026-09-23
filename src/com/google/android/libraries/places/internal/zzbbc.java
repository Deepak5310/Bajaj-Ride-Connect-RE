package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbc implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbbp zzb;

    zzbbc(zzbbp zzbbpVar, int i) {
        this.zzb = zzbbpVar;
        this.zza = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzm(this.zza);
    }
}
