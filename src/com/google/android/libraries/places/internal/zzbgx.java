package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgx extends zzauu {
    private final zzasa zza;
    private final zzavu zzb;
    private final zzawa zzc;

    public zzbgx(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar) {
        zzkt.zzc(zzawaVar, FirebaseAnalytics.Param.METHOD);
        this.zzc = zzawaVar;
        this.zzb = zzavuVar;
        zzkt.zzc(zzasaVar, "callOptions");
        this.zza = zzasaVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbgx zzbgxVar = (zzbgx) obj;
            if (zzkp.zza(this.zza, zzbgxVar.zza) && zzkp.zza(this.zzb, zzbgxVar.zzb) && zzkp.zza(this.zzc, zzbgxVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzasa zzasaVar = this.zza;
        zzavu zzavuVar = this.zzb;
        return "[method=" + this.zzc.toString() + " headers=" + zzavuVar.toString() + " callOptions=" + zzasaVar.toString() + "]";
    }

    @Override // com.google.android.libraries.places.internal.zzauu
    public final zzasa zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzauu
    public final zzavu zzb() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzauu
    public final zzawa zzc() {
        return this.zzc;
    }
}
