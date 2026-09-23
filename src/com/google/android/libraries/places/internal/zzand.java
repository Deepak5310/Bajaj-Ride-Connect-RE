package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzand {
    static final zzand zza = new zzand(true);
    private static volatile boolean zzb = false;
    private final Map zzc;

    zzand() {
        this.zzc = new HashMap();
    }

    public static zzand zza() {
        return zza;
    }

    public final zzanp zzb(zzaoz zzaozVar, int i) {
        return (zzanp) this.zzc.get(new zzanc(zzaozVar, i));
    }

    zzand(boolean z) {
        this.zzc = Collections.emptyMap();
    }
}
