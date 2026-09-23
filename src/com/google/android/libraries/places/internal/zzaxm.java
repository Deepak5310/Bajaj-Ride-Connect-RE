package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxm extends zzasy {
    private static final Logger zzb = Logger.getLogger(zzaxm.class.getName());
    static final ThreadLocal zza = new ThreadLocal();

    zzaxm() {
    }

    @Override // com.google.android.libraries.places.internal.zzasy
    public final zzasz zza() {
        zzasz zzaszVar = (zzasz) zza.get();
        return zzaszVar == null ? zzasz.zzb : zzaszVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasy
    public final zzasz zzb(zzasz zzaszVar) {
        zzasz zzaszVarZza = zza();
        zza.set(zzaszVar);
        return zzaszVarZza;
    }

    @Override // com.google.android.libraries.places.internal.zzasy
    public final void zzc(zzasz zzaszVar, zzasz zzaszVar2) {
        if (zza() != zzaszVar) {
            zzb.logp(Level.SEVERE, "io.grpc.ThreadLocalContextStorage", "detach", "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (zzaszVar2 != zzasz.zzb) {
            zza.set(zzaszVar2);
        } else {
            zza.set(null);
        }
    }
}
