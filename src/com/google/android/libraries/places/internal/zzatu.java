package com.google.android.libraries.places.internal;

import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatu {
    public final String zza;
    public final zzats zzb;
    public final long zzc;

    @Nullable
    public final zzauk zzd;

    @Nullable
    public final zzauk zze;

    /* synthetic */ zzatu(String str, zzats zzatsVar, long j, zzauk zzaukVar, zzauk zzaukVar2, zzatt zzattVar) {
        this.zza = str;
        zzkt.zzc(zzatsVar, "severity");
        this.zzb = zzatsVar;
        this.zzc = j;
        this.zzd = null;
        this.zze = zzaukVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzatu) {
            zzatu zzatuVar = (zzatu) obj;
            if (zzkp.zza(this.zza, zzatuVar.zza) && zzkp.zza(this.zzb, zzatuVar.zzb) && this.zzc == zzatuVar.zzc) {
                zzauk zzaukVar = zzatuVar.zzd;
                if (zzkp.zza(null, null) && zzkp.zza(this.zze, zzatuVar.zze)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, Long.valueOf(this.zzc), null, this.zze});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd(SavingTrackHelper.POINT_COL_DESCRIPTION, this.zza);
        zzknVarZzb.zzd("severity", this.zzb);
        zzknVarZzb.zzc("timestampNanos", this.zzc);
        zzknVarZzb.zzd("channelRef", null);
        zzknVarZzb.zzd("subchannelRef", this.zze);
        return zzknVarZzb.toString();
    }
}
