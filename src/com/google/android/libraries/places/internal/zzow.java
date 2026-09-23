package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzow extends zzpc {
    private static final zzow zza = new zzow(zzpc.zze());
    private final AtomicReference zzb;

    zzow(zzpc zzpcVar) {
        this.zzb = new AtomicReference(zzpcVar);
    }

    public static final zzow zzb() {
        return zza;
    }

    @Override // com.google.android.libraries.places.internal.zzpc
    public final zzny zza() {
        return ((zzpc) this.zzb.get()).zza();
    }

    @Override // com.google.android.libraries.places.internal.zzpc
    public final zzpp zzc() {
        return ((zzpc) this.zzb.get()).zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzpc
    public final boolean zzd(String str, Level level, boolean z) {
        ((zzpc) this.zzb.get()).zzd(str, level, z);
        return false;
    }
}
