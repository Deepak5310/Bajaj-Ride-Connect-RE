package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoc {
    private static final zzog zza = new zznz();
    private static final zzof zzb = new zzoa();
    private final zzog zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzof zzf = null;

    public final zzoc zza(zzof zzofVar) {
        this.zzf = zzofVar;
        return this;
    }

    public final zzoh zzd() {
        return new zzoe(this, null);
    }

    final void zzg(zznr zznrVar) {
        zzpr.zza(zznrVar, "key");
        if (!zznrVar.zzb()) {
            zzog zzogVar = zza;
            zzpr.zza(zznrVar, "key");
            this.zzd.remove(zznrVar);
            this.zzc.put(zznrVar, zzogVar);
            return;
        }
        zzof zzofVar = zzb;
        zzpr.zza(zznrVar, "key");
        if (!zznrVar.zzb()) {
            throw new IllegalArgumentException("key must be repeating");
        }
        this.zzc.remove(zznrVar);
        this.zzd.put(zznrVar, zzofVar);
    }
}
