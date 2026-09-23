package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzln {
    public static zzlm zzh() {
        zzkz zzkzVar = new zzkz();
        zzkzVar.zzg("NA");
        zzkzVar.zzf(false);
        zzkzVar.zze(false);
        zzkzVar.zzd(ModelType.UNKNOWN);
        zzkzVar.zzb(zzid.NO_ERROR);
        zzkzVar.zza(zzij.UNKNOWN_STATUS);
        zzkzVar.zzc(0);
        return zzkzVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzid zzc();

    public abstract zzij zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
