package com.google.android.libraries.places.internal;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoy implements zzor {
    private final String zza;
    private final zznu zzb;
    private final Level zzc;
    private final Set zzd;
    private final zzoh zze;

    private zzoy() {
        zznv zznvVar = zznv.DEFAULT;
        throw null;
    }

    private zzoy(String str, boolean z, zznu zznuVar, Level level, boolean z2, Set set, zzoh zzohVar) {
        this.zza = "";
        this.zzb = zznuVar;
        this.zzc = level;
        this.zzd = set;
        this.zze = zzohVar;
    }

    @Override // com.google.android.libraries.places.internal.zzor
    public final zznw zza(String str) {
        return new zzpb(this.zza, str, true, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    public final zzoy zzb(boolean z) {
        Set set = this.zzd;
        zzoh zzohVar = this.zze;
        return new zzoy(this.zza, true, this.zzb, Level.OFF, false, set, zzohVar);
    }
}
