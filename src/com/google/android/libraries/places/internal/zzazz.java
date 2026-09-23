package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzazz implements Runnable {
    private final zzasz zza;

    protected zzazz(zzasz zzaszVar) {
        this.zza = zzaszVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasz zzaszVarZza = this.zza.zza();
        try {
            zza();
        } finally {
            this.zza.zze(zzaszVarZza);
        }
    }

    public abstract void zza();
}
