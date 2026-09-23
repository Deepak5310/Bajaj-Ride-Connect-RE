package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhl implements Thread.UncaughtExceptionHandler {
    zzbhl(zzbit zzbitVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        throw new zzaxf(zzaxd.zze(th).zzg("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
