package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zze {
    private final zzaj zza = zzam.zzg();
    private Boolean zzb;

    private zze() {
    }

    public final zze zza() {
        zzab.zzd(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = false;
        return this;
    }

    public final zze zzb() {
        zzab.zzd(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = true;
        return this;
    }

    public final zzg zzc() {
        if (this.zzb == null) {
            throw new NullPointerException("Must call internal() or external() when building a SourcePolicy.");
        }
        return new zzg(this.zzb.booleanValue(), false, this.zza.zzc(), null);
    }

    /* synthetic */ zze(zzd zzdVar) {
    }
}
