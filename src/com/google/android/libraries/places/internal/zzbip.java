package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbip implements Runnable {
    final /* synthetic */ zzbiq zza;

    zzbip(zzbiq zzbiqVar) {
        this.zza = zzbiqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbit zzbitVar = this.zza.zzb;
        if (zzbitVar.zzD) {
            return;
        }
        zzbitVar.zzy.zzg();
    }
}
