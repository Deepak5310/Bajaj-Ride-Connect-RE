package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzasx {
    static final zzasy zza;

    static {
        zzasy zzaxmVar;
        AtomicReference atomicReference = new AtomicReference();
        try {
            zzaxmVar = (zzasy) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(zzasy.class).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            atomicReference.set(e);
            zzaxmVar = new zzaxm();
        } catch (Exception e2) {
            throw new RuntimeException("Storage override failed to initialize", e2);
        }
        zza = zzaxmVar;
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            zzasz.zza.logp(Level.FINE, "io.grpc.Context$LazyStorage", "<clinit>", "Storage override doesn't exist. Using default", th);
        }
    }
}
