package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzboo extends zzboj {
    static final zzauz zzc = new zzbon();
    private final zzavb zzd;
    private final zzaus zze;

    @Nullable
    private zzauq zzf;
    private zzavb zzg;

    @Nullable
    private zzauq zzh;
    private zzavb zzi;
    private zzasu zzj;
    private zzauz zzk;
    private boolean zzl;

    public zzboo(zzaus zzausVar) {
        zzbol zzbolVar = new zzbol(this);
        this.zzd = zzbolVar;
        this.zzg = zzbolVar;
        this.zzi = zzbolVar;
        this.zze = zzausVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzr() {
        this.zze.zzd(this.zzj, this.zzk);
        this.zzg.zzd();
        this.zzg = this.zzi;
        this.zzf = this.zzh;
        this.zzi = this.zzd;
        this.zzh = null;
    }

    @Override // com.google.android.libraries.places.internal.zzboj, com.google.android.libraries.places.internal.zzavb
    public final void zzd() {
        this.zzi.zzd();
        this.zzg.zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzboj
    protected final zzavb zzg() {
        zzavb zzavbVar = this.zzi;
        return zzavbVar == this.zzd ? this.zzg : zzavbVar;
    }

    public final void zzp(zzauq zzauqVar) {
        if (zzauqVar.equals(this.zzh)) {
            return;
        }
        this.zzi.zzd();
        this.zzi = this.zzd;
        this.zzh = null;
        this.zzj = zzasu.CONNECTING;
        this.zzk = zzc;
        if (zzauqVar.equals(this.zzf)) {
            return;
        }
        zzbom zzbomVar = new zzbom(this);
        zzbomVar.zza = zzauqVar.zza(zzbomVar);
        this.zzi = zzbomVar.zza;
        this.zzh = zzauqVar;
        if (this.zzl) {
            return;
        }
        zzr();
    }
}
