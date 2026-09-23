package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaux {
    private final List zza;
    private final zzarv zzb;

    @Nullable
    private final Object zzc;

    /* synthetic */ zzaux(List list, zzarv zzarvVar, Object obj, zzauw zzauwVar) {
        zzkt.zzc(list, "addresses");
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        zzkt.zzc(zzarvVar, "attributes");
        this.zzb = zzarvVar;
        this.zzc = obj;
    }

    public static zzauv zzb() {
        return new zzauv();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaux)) {
            return false;
        }
        zzaux zzauxVar = (zzaux) obj;
        return zzkp.zza(this.zza, zzauxVar.zza) && zzkp.zza(this.zzb, zzauxVar.zzb) && zzkp.zza(this.zzc, zzauxVar.zzc);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("addresses", this.zza);
        zzknVarZzb.zzd("attributes", this.zzb);
        zzknVarZzb.zzd("loadBalancingPolicyConfig", this.zzc);
        return zzknVarZzb.toString();
    }

    public final zzarv zza() {
        return this.zzb;
    }

    public final zzauv zzc() {
        zzauv zzauvVar = new zzauv();
        zzauvVar.zza(this.zza);
        zzauvVar.zzb(this.zzb);
        zzauvVar.zzc(this.zzc);
        return zzauvVar;
    }

    @Nullable
    public final Object zzd() {
        return this.zzc;
    }

    public final List zze() {
        return this.zza;
    }
}
