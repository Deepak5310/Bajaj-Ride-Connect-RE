package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapf {
    private static final zzape zza;
    private static final zzape zzb;

    static {
        zzape zzapeVar = null;
        try {
            zzapeVar = (zzape) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzapeVar;
        zzb = new zzape();
    }

    static zzape zza() {
        return zza;
    }

    static zzape zzb() {
        return zzb;
    }
}
