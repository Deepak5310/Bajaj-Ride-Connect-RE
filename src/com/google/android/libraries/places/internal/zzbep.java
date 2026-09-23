package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbep implements Executor {
    private Executor zza;
    private final zzbjs zzb;

    zzbep(zzbjs zzbjsVar) {
        this.zzb = zzbjsVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zza().execute(runnable);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.concurrent.Executor] */
    final synchronized Executor zza() {
        if (this.zza == null) {
            ?? Zzb = this.zzb.zzb();
            zzkt.zzd(Zzb, "%s.getObject()", this.zza);
            this.zza = Zzb;
        }
        return this.zza;
    }

    final synchronized void zzb() {
        Executor executor = this.zza;
        if (executor != null) {
            this.zzb.zzc(executor);
            this.zza = null;
        }
    }
}
