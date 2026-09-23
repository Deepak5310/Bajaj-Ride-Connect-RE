package com.google.android.libraries.places.internal;

import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatr {
    private String zza;
    private zzats zzb;
    private Long zzc;
    private zzauk zzd;

    public final zzatr zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzatr zzb(zzats zzatsVar) {
        this.zzb = zzatsVar;
        return this;
    }

    public final zzatr zzc(zzauk zzaukVar) {
        this.zzd = zzaukVar;
        return this;
    }

    public final zzatr zzd(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzatu zze() {
        zzkt.zzc(this.zza, SavingTrackHelper.POINT_COL_DESCRIPTION);
        zzkt.zzc(this.zzb, "severity");
        zzkt.zzc(this.zzc, "timestampNanos");
        return new zzatu(this.zza, this.zzb, this.zzc.longValue(), null, this.zzd, null);
    }
}
