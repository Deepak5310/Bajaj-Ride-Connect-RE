package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziu {
    private final zziq zza;
    private final zzis zzb = null;
    private final zzis zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zziu(zzir zzirVar, zzit zzitVar) {
        this.zza = zzirVar.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zziu)) {
            return false;
        }
        zziu zziuVar = (zziu) obj;
        if (Objects.equal(this.zza, zziuVar.zza)) {
            zzis zzisVar = zziuVar.zzb;
            if (Objects.equal(null, null)) {
                zzis zzisVar2 = zziuVar.zzc;
                if (Objects.equal(null, null)) {
                    Boolean bool = zziuVar.zzd;
                    if (Objects.equal(null, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    public final zziq zza() {
        return this.zza;
    }
}
