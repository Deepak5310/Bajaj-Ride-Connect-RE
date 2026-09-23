package com.google.android.libraries.places.internal;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjl {
    final zzavd zza;

    @Nullable
    final Object zzb;

    public zzbjl(zzavd zzavdVar, @Nullable Object obj) {
        this.zza = zzavdVar;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbjl zzbjlVar = (zzbjl) obj;
            if (zzkp.zza(this.zza, zzbjlVar.zza) && zzkp.zza(this.zzb, zzbjlVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("provider", this.zza);
        zzknVarZzb.zzd("config", this.zzb);
        return zzknVarZzb.toString();
    }
}
