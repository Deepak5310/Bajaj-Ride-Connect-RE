package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbof {
    static final zzary zza;
    private static final Logger zzb = Logger.getLogger(zzbof.class.getName());

    static {
        if (!zzlb.zzd(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"))) {
            Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        }
        zza = zzary.zza("internal-stub-type");
    }

    private zzbof() {
    }

    public static zzaho zza(zzasf zzasfVar, Object obj) {
        zzboa zzboaVar = new zzboa(zzasfVar);
        zzc(zzasfVar, obj, new zzboe(zzboaVar));
        return zzboaVar;
    }

    private static RuntimeException zzb(zzasf zzasfVar, Throwable th) {
        try {
            zzasfVar.zza(null, th);
        } catch (Error | RuntimeException e) {
            zzb.logp(Level.SEVERE, "io.grpc.stub.ClientCalls", "cancelThrow", "RuntimeException encountered while closing call", e);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    private static void zzc(zzasf zzasfVar, Object obj, zzboc zzbocVar) {
        zzasfVar.zze(zzbocVar, new zzavu());
        zzbocVar.zze();
        try {
            zzasfVar.zzd(obj);
            zzasfVar.zzb();
        } catch (Error | RuntimeException e) {
            throw zzb(zzasfVar, e);
        }
    }
}
