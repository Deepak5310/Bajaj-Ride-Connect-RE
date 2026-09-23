package com.google.android.libraries.places.internal;

import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzars {
    private zzarv zza;
    private IdentityHashMap zzb;

    /* synthetic */ zzars(zzarv zzarvVar, zzarr zzarrVar) {
        this.zza = zzarvVar;
    }

    public final zzars zza(zzart zzartVar) {
        if (this.zza.zzc.containsKey(zzartVar)) {
            IdentityHashMap identityHashMap = new IdentityHashMap(this.zza.zzc);
            identityHashMap.remove(zzartVar);
            this.zza = new zzarv(identityHashMap, null);
        }
        IdentityHashMap identityHashMap2 = this.zzb;
        if (identityHashMap2 != null) {
            identityHashMap2.remove(zzartVar);
        }
        return this;
    }

    public final zzars zzb(zzart zzartVar, Object obj) {
        if (this.zzb == null) {
            this.zzb = new IdentityHashMap(1);
        }
        this.zzb.put(zzartVar, obj);
        return this;
    }

    public final zzarv zzc() {
        if (this.zzb != null) {
            for (Map.Entry entry : this.zza.zzc.entrySet()) {
                if (!this.zzb.containsKey(entry.getKey())) {
                    this.zzb.put((zzart) entry.getKey(), entry.getValue());
                }
            }
            this.zza = new zzarv(this.zzb, null);
            this.zzb = null;
        }
        return this.zza;
    }
}
