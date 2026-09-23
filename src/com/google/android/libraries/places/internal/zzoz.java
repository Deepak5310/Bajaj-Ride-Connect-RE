package com.google.android.libraries.places.internal;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzoz extends zzop {
    private final zznu zza;
    private final Level zzb;
    private final Set zzc;
    private final zzoh zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzoz(String str, String str2, boolean z, zznu zznuVar, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        Set set = zzpb.zza;
        zzoh zzohVar = zzpb.zzb;
        this.zza = zznuVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzohVar;
    }
}
