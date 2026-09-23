package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbou extends zzbow {
    private final zzaxd zza;

    zzbou(@Nonnull zzaxd zzaxdVar) {
        zzkt.zzc(zzaxdVar, NotificationCompat.CATEGORY_STATUS);
        this.zza = zzaxdVar;
    }

    public final String toString() {
        zzkn zzknVarZza = zzko.zza(zzbou.class);
        zzknVarZza.zzd(NotificationCompat.CATEGORY_STATUS, this.zza);
        return zzknVarZza.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzauz
    public final zzaut zza(zzauu zzauuVar) {
        zzaxd zzaxdVar = this.zza;
        return zzaxdVar.zzl() ? zzaut.zzc() : zzaut.zzb(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbow
    public final boolean zzb(zzbow zzbowVar) {
        if (!(zzbowVar instanceof zzbou)) {
            return false;
        }
        zzbou zzbouVar = (zzbou) zzbowVar;
        if (zzkp.zza(this.zza, zzbouVar.zza)) {
            return true;
        }
        return this.zza.zzl() && zzbouVar.zza.zzl();
    }
}
