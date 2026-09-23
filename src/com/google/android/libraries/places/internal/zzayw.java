package com.google.android.libraries.places.internal;

import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayw extends zzasd {
    private final zzayx zza;
    private final zzbjy zzb;

    zzayw(zzayx zzayxVar, zzbjy zzbjyVar) {
        zzkt.zzc(zzayxVar, "tracer");
        this.zza = zzayxVar;
        zzkt.zzc(zzbjyVar, "time");
        this.zzb = zzbjyVar;
    }

    private static Level zzc(int i) {
        int i2 = i - 1;
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? Level.FINE : Level.FINEST;
        }
        return Level.FINER;
    }

    private final boolean zzd(int i) {
        if (i == 1) {
            return false;
        }
        this.zza.zzd();
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzasd
    public final void zza(int i, String str) {
        zzauf zzaufVarZza = this.zza.zza();
        Level levelZzc = zzc(i);
        if (zzayx.zza.isLoggable(levelZzc)) {
            zzayx.zzb(zzaufVarZza, levelZzc, str);
        }
        zzd(i);
    }

    @Override // com.google.android.libraries.places.internal.zzasd
    public final void zzb(int i, String str, Object... objArr) {
        Level levelZzc = zzc(i);
        zzd(i);
        zza(i, zzayx.zza.isLoggable(levelZzc) ? MessageFormat.format(str, objArr) : null);
    }
}
