package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzboh implements zzasg {
    private final zzavu zza;

    zzboh(zzavu zzavuVar) {
        this.zza = zzavuVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasg
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar, zzasb zzasbVar) {
        return new zzbog(this, zzasbVar.zza(zzawaVar, zzasaVar));
    }
}
