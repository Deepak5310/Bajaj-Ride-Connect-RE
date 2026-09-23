package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdq {
    private static final zzdo zza = new zzdp();
    private static final zzdo zzb;

    static {
        zzdo zzdoVar = null;
        try {
            zzdoVar = (zzdo) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzdoVar;
    }

    static zzdo zza() {
        zzdo zzdoVar = zzb;
        if (zzdoVar != null) {
            return zzdoVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzdo zzb() {
        return zza;
    }
}
