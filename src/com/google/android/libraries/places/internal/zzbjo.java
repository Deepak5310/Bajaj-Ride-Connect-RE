package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbjo implements Runnable {
    final /* synthetic */ zzbjp zza;
    final /* synthetic */ zzbjq zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ zzbjr zzd;

    zzbjo(zzbjr zzbjrVar, zzbjp zzbjpVar, zzbjq zzbjqVar, Object obj) {
        this.zzd = zzbjrVar;
        this.zza = zzbjpVar;
        this.zzb = zzbjqVar;
        this.zzc = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzd) {
            if (this.zza.zzb == 0) {
                try {
                    this.zzb.zzb(this.zzc);
                    this.zzd.zzb.remove(this.zzb);
                    if (this.zzd.zzb.isEmpty()) {
                        this.zzd.zzc.shutdown();
                        this.zzd.zzc = null;
                    }
                } catch (Throwable th) {
                    this.zzd.zzb.remove(this.zzb);
                    if (this.zzd.zzb.isEmpty()) {
                        this.zzd.zzc.shutdown();
                        this.zzd.zzc = null;
                    }
                    throw th;
                }
            }
        }
    }
}
