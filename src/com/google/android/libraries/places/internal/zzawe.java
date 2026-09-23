package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawe {
    private final zzaxd zza;
    private final Object zzb;

    private zzawe(zzaxd zzaxdVar) {
        this.zzb = null;
        zzkt.zzc(zzaxdVar, NotificationCompat.CATEGORY_STATUS);
        this.zza = zzaxdVar;
        zzkt.zzj(!zzaxdVar.zzl(), "cannot use OK status: %s", zzaxdVar);
    }

    private zzawe(Object obj) {
        this.zzb = obj;
        this.zza = null;
    }

    public static zzawe zza(Object obj) {
        return new zzawe(obj);
    }

    public static zzawe zzb(zzaxd zzaxdVar) {
        return new zzawe(zzaxdVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzawe zzaweVar = (zzawe) obj;
            if (zzkp.zza(this.zza, zzaweVar.zza) && zzkp.zza(this.zzb, zzaweVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        if (this.zzb != null) {
            zzkn zzknVarZzb = zzko.zzb(this);
            zzknVarZzb.zzd("config", this.zzb);
            return zzknVarZzb.toString();
        }
        zzkn zzknVarZzb2 = zzko.zzb(this);
        zzknVarZzb2.zzd("error", this.zza);
        return zzknVarZzb2.toString();
    }

    @Nullable
    public final zzaxd zzc() {
        return this.zza;
    }

    @Nullable
    public final Object zzd() {
        return this.zzb;
    }
}
