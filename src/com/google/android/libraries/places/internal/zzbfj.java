package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfj extends zzasb {
    final /* synthetic */ zzbfr zza;
    private final String zzc;
    private final AtomicReference zzb = new AtomicReference(zzbfr.zzi);
    private final zzasb zzd = new zzbfb(this);

    /* synthetic */ zzbfj(zzbfr zzbfrVar, String str, zzbfi zzbfiVar) {
        this.zza = zzbfrVar;
        this.zzc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzasf zzh(zzawa zzawaVar, zzasa zzasaVar) {
        zzauc zzaucVar = (zzauc) this.zzb.get();
        if (zzaucVar == null) {
            return this.zzd.zza(zzawaVar, zzasaVar);
        }
        if (!(zzaucVar instanceof zzbfz)) {
            return new zzbem(zzaucVar, this.zzd, this.zza.zzu, zzawaVar, zzasaVar);
        }
        zzbfx zzbfxVarZzb = ((zzbfz) zzaucVar).zzb.zzb(zzawaVar);
        if (zzbfxVarZzb != null) {
            zzasaVar = zzasaVar.zze(zzbfx.zza, zzbfxVarZzb);
        }
        return this.zzd.zza(zzawaVar, zzasaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar) {
        if (this.zzb.get() != zzbfr.zzi) {
            return zzh(zzawaVar, zzasaVar);
        }
        zzbfr zzbfrVar = this.zza;
        zzbfc zzbfcVar = new zzbfc(this);
        zzaxl zzaxlVar = zzbfrVar.zzf;
        zzaxlVar.zzc(zzbfcVar);
        zzaxlVar.zzb();
        if (this.zzb.get() != zzbfr.zzi) {
            return zzh(zzawaVar, zzasaVar);
        }
        if (this.zza.zzP.get()) {
            return new zzbfd(this);
        }
        zzbfh zzbfhVar = new zzbfh(this, zzasz.zzb(), zzawaVar, zzasaVar);
        zzbfr zzbfrVar2 = this.zza;
        zzbfe zzbfeVar = new zzbfe(this, zzbfhVar);
        zzaxl zzaxlVar2 = zzbfrVar2.zzf;
        zzaxlVar2.zzc(zzbfeVar);
        zzaxlVar2.zzb();
        return zzbfhVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final String zzb() {
        return this.zzc;
    }

    final void zzf() {
        if (this.zzb.get() == zzbfr.zzi) {
            zzg(null);
        }
    }

    final void zzg(@Nullable zzauc zzaucVar) {
        zzauc zzaucVar2 = (zzauc) this.zzb.get();
        this.zzb.set(zzaucVar);
        if (zzaucVar2 == zzbfr.zzi) {
            zzbfr zzbfrVar = this.zza;
            if (zzbfrVar.zzK != null) {
                Iterator it2 = zzbfrVar.zzK.iterator();
                while (it2.hasNext()) {
                    ((zzbfh) it2.next()).zzl();
                }
            }
        }
    }
}
