package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdz implements Runnable {
    private static final Logger zza = Logger.getLogger(zzbdz.class.getName());
    private final Runnable zzb;

    public zzbdz(Runnable runnable) {
        this.zzb = runnable;
    }

    public final String toString() {
        return "LogExceptionRunnable(" + this.zzb.toString() + ")";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.run();
        } catch (Throwable th) {
            zza.logp(Level.SEVERE, "io.grpc.internal.LogExceptionRunnable", "run", "Exception while executing runnable ".concat(this.zzb.toString()), th);
            zzld.zza(th);
            throw new AssertionError(th);
        }
    }
}
