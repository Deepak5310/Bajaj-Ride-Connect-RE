package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzasj extends zzasb {
    private final zzasb zza;
    private final zzasg zzb;

    /* synthetic */ zzasj(zzasb zzasbVar, zzasg zzasgVar, zzasi zzasiVar) {
        this.zza = zzasbVar;
        zzkt.zzc(zzasgVar, "interceptor");
        this.zzb = zzasgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar) {
        return this.zzb.zza(zzawaVar, zzasaVar, this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final String zzb() {
        return this.zza.zzb();
    }
}
