package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfh {
    private static final zzfg zza;
    private static final zzfg zzb;

    static {
        zzfg zzfgVar = null;
        try {
            zzfgVar = (zzfg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzfgVar;
        zzb = new zzfg();
    }

    static zzfg zza() {
        return zza;
    }

    static zzfg zzb() {
        return zzb;
    }
}
