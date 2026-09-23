package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbli implements Runnable {
    final /* synthetic */ zzblk zza;

    zzbli(zzblk zzblkVar) {
        this.zza = zzblkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzblk zzblkVar = this.zza;
        zzblkVar.zzs.execute(zzblkVar.zzx);
        synchronized (this.zza.zzo) {
            this.zza.zzH = Integer.MAX_VALUE;
            this.zza.zzad();
        }
    }
}
