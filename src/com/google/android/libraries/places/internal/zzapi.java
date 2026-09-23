package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapi {
    private static final zzapi zza = new zzapi();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzapn zzb = new zzaor();

    private zzapi() {
    }

    public static zzapi zza() {
        return zza;
    }

    public final zzapm zzb(Class cls) {
        zzaoa.zzc(cls, "messageType");
        zzapm zzapmVarZza = (zzapm) this.zzc.get(cls);
        if (zzapmVarZza == null) {
            zzapmVarZza = this.zzb.zza(cls);
            zzaoa.zzc(cls, "messageType");
            zzapm zzapmVar = (zzapm) this.zzc.putIfAbsent(cls, zzapmVarZza);
            if (zzapmVar != null) {
                return zzapmVar;
            }
        }
        return zzapmVarZza;
    }
}
