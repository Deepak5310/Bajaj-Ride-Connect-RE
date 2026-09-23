package com.google.android.libraries.places.internal;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazm {
    private String zza = "unknown-authority";
    private zzarv zzb = zzarv.zza;

    @Nullable
    private String zzc;

    @Nullable
    private zzatq zzd;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzazm)) {
            return false;
        }
        zzazm zzazmVar = (zzazm) obj;
        if (this.zza.equals(zzazmVar.zza) && this.zzb.equals(zzazmVar.zzb)) {
            String str = zzazmVar.zzc;
            if (zzkp.zza(null, null) && zzkp.zza(this.zzd, zzazmVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, null, this.zzd});
    }

    public final zzarv zza() {
        return this.zzb;
    }

    @Nullable
    public final zzatq zzb() {
        return this.zzd;
    }

    public final zzazm zzc(String str) {
        zzkt.zzc(str, "authority");
        this.zza = str;
        return this;
    }

    public final zzazm zzd(zzarv zzarvVar) {
        this.zzb = zzarvVar;
        return this;
    }

    public final zzazm zze(@Nullable zzatq zzatqVar) {
        this.zzd = zzatqVar;
        return this;
    }

    public final zzazm zzf(@Nullable String str) {
        this.zzc = null;
        return this;
    }

    public final String zzg() {
        return this.zza;
    }
}
