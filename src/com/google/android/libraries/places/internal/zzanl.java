package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzanl implements zzaox {
    private static final zzanl zza = new zzanl();

    private zzanl() {
    }

    public static zzanl zza() {
        return zza;
    }

    @Override // com.google.android.libraries.places.internal.zzaox
    public final zzaow zzb(Class cls) {
        if (!zzanr.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzaow) zzanr.zzan(cls.asSubclass(zzanr.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaox
    public final boolean zzc(Class cls) {
        return zzanr.class.isAssignableFrom(cls);
    }
}
