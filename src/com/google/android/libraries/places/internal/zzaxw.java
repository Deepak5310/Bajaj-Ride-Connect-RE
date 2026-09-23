package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxw implements Runnable {
    final /* synthetic */ zzbpa zza;
    final /* synthetic */ zzaxx zzb;

    zzaxw(zzaxx zzaxxVar, zzbpa zzbpaVar, int i) {
        this.zzb = zzaxxVar;
        this.zza = zzbpaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = zzbpb.zza;
            this.zzb.zzr.zzc(2);
        } catch (Throwable th) {
            this.zzb.zzF(th);
        }
    }
}
