package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg {
    public static final zzg zza;
    public static final zzg zzb;
    private final boolean zzc;
    private final boolean zzd = false;
    private final zzam zze;

    static {
        zzd zzdVar = null;
        zze zzeVar = new zze(zzdVar);
        zzeVar.zza();
        zza = zzeVar.zzc();
        zze zzeVar2 = new zze(zzdVar);
        zzeVar2.zzb();
        zzb = zzeVar2.zzc();
    }

    /* synthetic */ zzg(boolean z, boolean z2, zzam zzamVar, zzf zzfVar) {
        this.zzc = z;
        this.zze = zzamVar;
    }

    static /* bridge */ /* synthetic */ boolean zza(zzg zzgVar) {
        boolean z = zzgVar.zzd;
        return false;
    }

    static /* bridge */ /* synthetic */ int zzc(zzg zzgVar, Context context, zzp zzpVar) {
        zzam zzamVar = zzgVar.zze;
        int size = zzamVar.size();
        int i = 0;
        while (i < size) {
            zzq zzqVar = (zzq) zzamVar.get(i);
            boolean z = zzgVar.zzc;
            int iZza = zzqVar.zza();
            int i2 = iZza - 1;
            if (iZza == 0) {
                throw null;
            }
            i++;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
        }
        return 3;
    }
}
