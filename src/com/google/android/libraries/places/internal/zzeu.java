package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeu {
    private final zzhx zza;

    protected zzeu(zzhx zzhxVar) {
        this.zza = zzhxVar;
    }

    protected final CancellationToken zza() {
        return this.zza.getCancellationToken();
    }

    protected final zzhx zzb() {
        return this.zza;
    }

    protected abstract String zzc();

    protected abstract Map zzd();
}
