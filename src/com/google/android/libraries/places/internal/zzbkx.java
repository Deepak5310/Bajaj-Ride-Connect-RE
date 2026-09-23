package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkx implements Runnable {
    final /* synthetic */ zzayc zza;

    zzbkx(zzbkz zzbkzVar, zzayc zzaycVar) {
        this.zza = zzaycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza();
    }
}
