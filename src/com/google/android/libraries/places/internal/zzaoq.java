package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaoq implements zzaox {
    private final zzaox[] zza;

    zzaoq(zzaox... zzaoxVarArr) {
        this.zza = zzaoxVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzaox
    public final zzaow zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzaox zzaoxVar = this.zza[i];
            if (zzaoxVar.zzc(cls)) {
                return zzaoxVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.libraries.places.internal.zzaox
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
