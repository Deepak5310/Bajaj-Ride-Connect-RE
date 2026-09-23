package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaov {
    private static final zzaou zza;
    private static final zzaou zzb;

    static {
        zzaou zzaouVar = null;
        try {
            zzaouVar = (zzaou) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzaouVar;
        zzb = new zzaou();
    }

    static zzaou zza() {
        return zza;
    }

    static zzaou zzb() {
        return zzb;
    }
}
