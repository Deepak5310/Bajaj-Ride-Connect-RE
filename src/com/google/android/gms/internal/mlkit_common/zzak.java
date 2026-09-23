package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzak extends zzad {
    private final zzam zza;

    zzak(zzam zzamVar, int i) {
        super(zzamVar.size(), i);
        this.zza = zzamVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzad
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
