package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzhz implements zzbg {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzd;

    zzhz(int i) {
        this.zzd = i;
    }

    public static zzhz zzb(int i) {
        for (zzhz zzhzVar : values()) {
            if (zzhzVar.zzd == i) {
                return zzhzVar;
            }
        }
        return UNKNOWN;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbg
    public final int zza() {
        return this.zzd;
    }
}
