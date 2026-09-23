package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawi {
    private final List zza;
    private final zzarv zzb;

    @Nullable
    private final zzawe zzc;

    zzawi(List list, zzarv zzarvVar, zzawe zzaweVar) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        zzkt.zzc(zzarvVar, "attributes");
        this.zzb = zzarvVar;
        this.zzc = zzaweVar;
    }

    public static zzawh zzc() {
        return new zzawh();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzawi)) {
            return false;
        }
        zzawi zzawiVar = (zzawi) obj;
        return zzkp.zza(this.zza, zzawiVar.zza) && zzkp.zza(this.zzb, zzawiVar.zzb) && zzkp.zza(this.zzc, zzawiVar.zzc);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("addresses", this.zza);
        zzknVarZzb.zzd("attributes", this.zzb);
        zzknVarZzb.zzd("serviceConfig", this.zzc);
        return zzknVarZzb.toString();
    }

    public final zzarv zza() {
        return this.zzb;
    }

    @Nullable
    public final zzawe zzb() {
        return this.zzc;
    }

    public final zzawh zzd() {
        zzawh zzawhVar = new zzawh();
        zzawhVar.zza(this.zza);
        zzawhVar.zzb(this.zzb);
        zzawhVar.zzc(this.zzc);
        return zzawhVar;
    }

    public final List zze() {
        return this.zza;
    }
}
