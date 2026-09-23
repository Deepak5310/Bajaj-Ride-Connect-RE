package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbem extends zzatl {
    private final zzauc zza;
    private final zzasb zzb;
    private final Executor zzc;
    private final zzawa zzd;
    private final zzasz zze;
    private zzasa zzf;
    private zzasf zzg;

    zzbem(zzauc zzaucVar, zzasb zzasbVar, Executor executor, zzawa zzawaVar, zzasa zzasaVar) {
        this.zza = zzaucVar;
        this.zzb = zzasbVar;
        this.zzd = zzawaVar;
        executor = zzasaVar.zzn() != null ? zzasaVar.zzn() : executor;
        this.zzc = executor;
        this.zzf = zzasaVar.zzb(executor);
        this.zze = zzasz.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzawr, com.google.android.libraries.places.internal.zzasf
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        zzasf zzasfVar = this.zzg;
        if (zzasfVar != null) {
            zzasfVar.zza(str, th);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzatl, com.google.android.libraries.places.internal.zzasf
    public final void zze(zzase zzaseVar, zzavu zzavuVar) {
        zzaub zzaubVarZza = this.zza.zza(new zzbgx(this.zzd, zzavuVar, this.zzf));
        zzaxd zzaxdVarZzb = zzaubVarZza.zzb();
        if (!zzaxdVarZzb.zzl()) {
            this.zzc.execute(new zzbel(this, zzaseVar, zzbcu.zzb(zzaxdVarZzb)));
            this.zzg = zzbfr.zzj;
            return;
        }
        zzbfx zzbfxVarZzb = ((zzbga) zzaubVarZza.zzc()).zzb(this.zzd);
        if (zzbfxVarZzb != null) {
            this.zzf = this.zzf.zze(zzbfx.zza, zzbfxVarZzb);
        }
        zzasf zzasfVarZza = this.zzb.zza(this.zzd, this.zzf);
        this.zzg = zzasfVarZza;
        zzasfVarZza.zze(zzaseVar, zzavuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzatl, com.google.android.libraries.places.internal.zzawr
    protected final zzasf zzf() {
        return this.zzg;
    }
}
