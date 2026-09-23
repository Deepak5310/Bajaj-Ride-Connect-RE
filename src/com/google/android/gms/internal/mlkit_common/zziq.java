package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziq {
    private final String zza;
    private final zzio zzc;
    private final String zze;
    private final zzin zzf;
    private final String zzb = null;
    private final String zzd = null;
    private final Long zzg = null;
    private final Boolean zzh = null;
    private final Boolean zzi = null;

    /* synthetic */ zziq(zzim zzimVar, zzip zzipVar) {
        this.zza = zzimVar.zza;
        this.zzc = zzimVar.zzb;
        this.zze = zzimVar.zzc;
        this.zzf = zzimVar.zzd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziqVar = (zziq) obj;
        if (Objects.equal(this.zza, zziqVar.zza)) {
            String str = zziqVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zziqVar.zzc)) {
                String str2 = zziqVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zziqVar.zze) && Objects.equal(this.zzf, zziqVar.zzf)) {
                    Long l = zziqVar.zzg;
                    if (Objects.equal(null, null)) {
                        Boolean bool = zziqVar.zzh;
                        if (Objects.equal(null, null)) {
                            Boolean bool2 = zziqVar.zzi;
                            if (Objects.equal(null, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    public final zzin zza() {
        return this.zzf;
    }

    public final zzio zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }
}
