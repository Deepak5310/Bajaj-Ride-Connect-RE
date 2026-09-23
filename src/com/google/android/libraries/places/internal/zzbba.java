package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbba implements Runnable {
    final /* synthetic */ zzass zza;
    final /* synthetic */ zzbbp zzb;

    zzbba(zzbbp zzbbpVar, zzass zzassVar) {
        this.zzb = zzbbpVar;
        this.zza = zzassVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzv(this.zza);
    }
}
