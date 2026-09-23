package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasv {
    private final zzasu zza;
    private final zzaxd zzb;

    private zzasv(zzasu zzasuVar, zzaxd zzaxdVar) {
        zzkt.zzc(zzasuVar, "state is null");
        this.zza = zzasuVar;
        zzkt.zzc(zzaxdVar, "status is null");
        this.zzb = zzaxdVar;
    }

    public static zzasv zzb(zzasu zzasuVar) {
        zzkt.zzf(zzasuVar != zzasu.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new zzasv(zzasuVar, zzaxd.zza);
    }

    public static zzasv zzc(zzaxd zzaxdVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "The error status must not be OK");
        return new zzasv(zzasu.TRANSIENT_FAILURE, zzaxdVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzasv)) {
            return false;
        }
        zzasv zzasvVar = (zzasv) obj;
        return this.zza.equals(zzasvVar.zza) && this.zzb.equals(zzasvVar.zzb);
    }

    public final int hashCode() {
        zzaxd zzaxdVar = this.zzb;
        return zzaxdVar.hashCode() ^ this.zza.hashCode();
    }

    public final String toString() {
        zzaxd zzaxdVar = this.zzb;
        if (zzaxdVar.zzl()) {
            return this.zza.toString();
        }
        return this.zza.toString() + "(" + zzaxdVar.toString() + ")";
    }

    public final zzasu zza() {
        return this.zza;
    }

    public final zzaxd zzd() {
        return this.zzb;
    }
}
