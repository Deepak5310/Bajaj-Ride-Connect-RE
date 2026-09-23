package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbd implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbbp zzb;

    zzbbd(zzbbp zzbbpVar, int i) {
        this.zzb = zzbbpVar;
        this.zza = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzn(this.zza);
    }
}
