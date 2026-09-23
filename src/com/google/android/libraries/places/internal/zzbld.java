package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbld extends zzaxu {
    private static final zzbpl zza = new zzbpl();
    private final zzawa zzb;
    private final String zzc;
    private final zzbjt zzd;
    private final String zze;
    private final zzblc zzf;
    private final zzblb zzg;
    private final zzarv zzh;
    private final boolean zzi;

    zzbld(zzawa zzawaVar, zzavu zzavuVar, zzbkp zzbkpVar, zzblk zzblkVar, zzblz zzblzVar, Object obj, int i, int i2, String str, String str2, zzbjt zzbjtVar, zzbke zzbkeVar, zzasa zzasaVar, boolean z) {
        super(new zzblt(), zzbjtVar, zzbkeVar, zzavuVar, zzasaVar, false);
        this.zzg = new zzblb(this);
        this.zzi = false;
        this.zzd = zzbjtVar;
        this.zzb = zzawaVar;
        this.zze = str;
        this.zzc = str2;
        this.zzh = zzblkVar.zzk();
        this.zzf = new zzblc(this, i, zzbjtVar, obj, zzbkpVar, zzblzVar, zzblkVar, i2, zzawaVar.zzf());
    }

    protected final zzblc zzD() {
        return this.zzf;
    }

    final boolean zzI() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzaxu
    protected final /* synthetic */ zzaxr zza() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final zzarv zzam() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzaxu
    protected final /* synthetic */ zzaxt zzb() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzaxu, com.google.android.libraries.places.internal.zzaxy
    protected final /* synthetic */ zzaxx zzc() {
        return this.zzf;
    }

    public final zzavy zzx() {
        return this.zzb.zzb();
    }
}
