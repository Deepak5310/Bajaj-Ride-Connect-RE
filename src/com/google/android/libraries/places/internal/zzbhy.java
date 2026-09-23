package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhy implements Runnable {
    final /* synthetic */ zzbit zza;

    zzbhy(zzbit zzbitVar) {
        this.zza = zzbitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbit zzbitVar = this.zza;
        if (zzbitVar.zzD) {
            return;
        }
        zzbitVar.zzy.zzg();
    }
}
