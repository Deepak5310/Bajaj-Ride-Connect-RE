package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgt implements Runnable {
    final /* synthetic */ zzbgu zza;

    zzbgt(zzbgu zzbguVar) {
        this.zza = zzbguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
