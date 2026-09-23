package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbga {

    @Nullable
    private final zzbfx zza;
    private final Map zzb;
    private final Map zzc;

    @Nullable
    private final zzbis zzd;

    @Nullable
    private final Object zze;

    @Nullable
    private final Map zzf;

    zzbga(@Nullable zzbfx zzbfxVar, Map map, Map map2, @Nullable zzbis zzbisVar, @Nullable Object obj, @Nullable Map map3) {
        this.zza = zzbfxVar;
        this.zzb = Collections.unmodifiableMap(new HashMap(map));
        this.zzc = Collections.unmodifiableMap(new HashMap(map2));
        this.zzd = zzbisVar;
        this.zze = obj;
        this.zzf = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbga zzbgaVar = (zzbga) obj;
            if (zzkp.zza(this.zza, zzbgaVar.zza) && zzkp.zza(this.zzb, zzbgaVar.zzb) && zzkp.zza(this.zzc, zzbgaVar.zzc) && zzkp.zza(this.zzd, zzbgaVar.zzd) && zzkp.zza(this.zze, zzbgaVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("defaultMethodConfig", this.zza);
        zzknVarZzb.zzd("serviceMethodMap", this.zzb);
        zzknVarZzb.zzd("serviceMap", this.zzc);
        zzknVarZzb.zzd("retryThrottling", this.zzd);
        zzknVarZzb.zzd("loadBalancingConfig", this.zze);
        return zzknVarZzb.toString();
    }

    @Nullable
    final zzauc zza() {
        if (this.zzc.isEmpty() && this.zzb.isEmpty() && this.zza == null) {
            return null;
        }
        return new zzbfz(this, null);
    }

    @Nullable
    final zzbfx zzb(zzawa zzawaVar) {
        zzbfx zzbfxVar = (zzbfx) this.zzb.get(zzawaVar.zzf());
        if (zzbfxVar == null) {
            zzbfxVar = (zzbfx) this.zzc.get(zzawaVar.zzg());
        }
        return zzbfxVar == null ? this.zza : zzbfxVar;
    }

    @Nullable
    final zzbis zzc() {
        return this.zzd;
    }

    @Nullable
    final Object zzd() {
        return this.zze;
    }

    @Nullable
    final Map zze() {
        return this.zzf;
    }
}
