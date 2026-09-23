package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbas implements Runnable {
    final /* synthetic */ zzbgb zza;

    zzbas(zzbax zzbaxVar, zzbgb zzbgbVar) {
        this.zza = zzbgbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(false);
    }
}
