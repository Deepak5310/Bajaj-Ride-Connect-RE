package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbe implements Runnable {
    final /* synthetic */ zzatd zza;
    final /* synthetic */ zzbbp zzb;

    zzbbe(zzbbp zzbbpVar, zzatd zzatdVar) {
        this.zzb = zzbbpVar;
        this.zza = zzatdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzk(this.zza);
    }
}
