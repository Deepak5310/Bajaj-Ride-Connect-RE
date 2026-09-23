package com.google.android.libraries.places.internal;

import javax.annotation.CheckReturnValue;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavw {
    private zzavx zza;
    private zzavx zzb;
    private zzavy zzc;
    private String zzd;
    private boolean zze;

    private zzavw() {
    }

    /* synthetic */ zzavw(zzavv zzavvVar) {
    }

    public final zzavw zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzavw zzb(zzavx zzavxVar) {
        this.zza = zzavxVar;
        return this;
    }

    public final zzavw zzc(zzavx zzavxVar) {
        this.zzb = zzavxVar;
        return this;
    }

    public final zzavw zzd(boolean z) {
        this.zze = true;
        return this;
    }

    public final zzavw zze(zzavy zzavyVar) {
        this.zzc = zzavyVar;
        return this;
    }

    @CheckReturnValue
    public final zzawa zzf() {
        return new zzawa(this.zzc, this.zzd, this.zza, this.zzb, null, false, false, this.zze, null);
    }
}
