package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzang {
    private static final zzane zza = new zzanf();
    private static final zzane zzb;

    static {
        zzane zzaneVar = null;
        try {
            zzaneVar = (zzane) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzaneVar;
    }

    static zzane zza() {
        zzane zzaneVar = zzb;
        if (zzaneVar != null) {
            return zzaneVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzane zzb() {
        return zza;
    }
}
