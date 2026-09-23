package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasz {
    static final Logger zza = Logger.getLogger(zzasz.class.getName());
    public static final zzasz zzb = new zzasz();

    private zzasz() {
    }

    public static zzasz zzb() {
        zzasz zzaszVarZza = zzasx.zza.zza();
        return zzaszVarZza == null ? zzb : zzaszVarZza;
    }

    static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public final zzasz zza() {
        zzasz zzaszVarZzb = zzasx.zza.zzb(this);
        return zzaszVarZzb == null ? zzb : zzaszVarZzb;
    }

    public final void zzd(zzasw zzaswVar, Executor executor) {
        zzc(zzaswVar, "cancellationListener");
        zzc(executor, "executor");
    }

    public final void zze(zzasz zzaszVar) {
        zzc(zzaszVar, "toAttach");
        zzasx.zza.zzc(this, zzaszVar);
    }
}
