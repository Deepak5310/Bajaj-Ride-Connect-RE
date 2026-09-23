package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzast {
    private static final zzast zza = new zzast(new zzasp(), zzasq.zza);
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    zzast(zzass... zzassVarArr) {
        for (int i = 0; i < 2; i++) {
            zzass zzassVar = zzassVarArr[i];
            this.zzb.put(zzassVar.zzb(), zzassVar);
        }
    }

    public static zzast zza() {
        return zza;
    }
}
