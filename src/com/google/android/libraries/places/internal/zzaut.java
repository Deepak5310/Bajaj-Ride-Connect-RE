package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaut {
    private static final zzaut zza = new zzaut(null, null, zzaxd.zza, false);

    @Nullable
    private final zzauy zzb;

    @Nullable
    private final zzasl zzc = null;
    private final zzaxd zzd;
    private final boolean zze;

    private zzaut(@Nullable zzauy zzauyVar, @Nullable zzasl zzaslVar, zzaxd zzaxdVar, boolean z) {
        this.zzb = zzauyVar;
        zzkt.zzc(zzaxdVar, NotificationCompat.CATEGORY_STATUS);
        this.zzd = zzaxdVar;
        this.zze = z;
    }

    public static zzaut zza(zzaxd zzaxdVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "drop status shouldn't be OK");
        return new zzaut(null, null, zzaxdVar, true);
    }

    public static zzaut zzb(zzaxd zzaxdVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "error status shouldn't be OK");
        return new zzaut(null, null, zzaxdVar, false);
    }

    public static zzaut zzc() {
        return zza;
    }

    public static zzaut zzd(zzauy zzauyVar, @Nullable zzasl zzaslVar) {
        return new zzaut(zzauyVar, null, zzaxd.zza, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaut)) {
            return false;
        }
        zzaut zzautVar = (zzaut) obj;
        if (zzkp.zza(this.zzb, zzautVar.zzb) && zzkp.zza(this.zzd, zzautVar.zzd)) {
            zzasl zzaslVar = zzautVar.zzc;
            if (zzkp.zza(null, null) && this.zze == zzautVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzd, null, Boolean.valueOf(this.zze)});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("subchannel", this.zzb);
        zzknVarZzb.zzd("streamTracerFactory", null);
        zzknVarZzb.zzd(NotificationCompat.CATEGORY_STATUS, this.zzd);
        zzknVarZzb.zze("drop", this.zze);
        return zzknVarZzb.toString();
    }

    @Nullable
    public final zzauy zze() {
        return this.zzb;
    }

    public final zzaxd zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze;
    }
}
