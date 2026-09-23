package com.google.android.libraries.places.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public abstract class zzbnz {
    private final zzasb zza;
    private final zzasa zzb;

    protected zzbnz(zzasb zzasbVar, zzasa zzasaVar) {
        zzkt.zzc(zzasbVar, "channel");
        this.zza = zzasbVar;
        this.zzb = zzasaVar;
    }

    protected abstract zzbnz zza(zzasb zzasbVar, zzasa zzasaVar);

    public final zzasa zzc() {
        return this.zzb;
    }

    public final zzasb zzd() {
        return this.zza;
    }

    public final zzbnz zze(zzasg... zzasgVarArr) {
        return zza(zzask.zza(this.zza, Arrays.asList(zzasgVarArr)), this.zzb);
    }
}
