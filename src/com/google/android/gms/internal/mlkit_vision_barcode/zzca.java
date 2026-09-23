package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzca extends zzas {
    private final zzcc zza;

    zzca(zzcc zzccVar, int i) {
        super(zzccVar.size(), i);
        this.zza = zzccVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzas
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
