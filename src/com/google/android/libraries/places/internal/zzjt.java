package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjt implements zzjs {
    private final zzid zza;
    private final zzih zzb;

    public zzjt(zzih zzihVar, zzid zzidVar) {
        this.zzb = zzihVar;
        this.zza = zzidVar;
    }

    @Override // com.google.android.libraries.places.internal.zzjs
    public final void zza(zzjr zzjrVar) {
        zzadl zzadlVarZza = zzado.zza();
        zzadlVarZza.zzg(zzjrVar.zzz());
        zzadlVarZza.zzd(zzjrVar.zzx());
        zzadlVarZza.zze(zzjrVar.zzy());
        zzadlVarZza.zzj(zzjrVar.zzd());
        zzadlVarZza.zzc(zzjrVar.zzb());
        zzadlVarZza.zzb(zzjrVar.zza());
        zzadlVarZza.zzk(zzjrVar.zze());
        zzadlVarZza.zzh(zzjrVar.zzk().length());
        zzadlVarZza.zzl(zzjrVar.zzg());
        zzadlVarZza.zzf(zzjrVar.zzc());
        zzadlVarZza.zzi(zzjrVar.zzA());
        zzadlVarZza.zza(zzjrVar.zzf());
        if (zzjrVar.zzi() == zzis.FRAGMENT) {
            zzadlVarZza.zzn(2);
        } else if (zzjrVar.zzi() == zzis.INTENT) {
            zzadlVarZza.zzn(3);
        } else {
            zzadlVarZza.zzn(1);
        }
        if (zzjrVar.zzj() == AutocompleteActivityMode.FULLSCREEN) {
            zzadlVarZza.zzm(2);
        } else if (zzjrVar.zzj() == AutocompleteActivityMode.OVERLAY) {
            zzadlVarZza.zzm(1);
        }
        zzado zzadoVar = (zzado) zzadlVarZza.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 2);
        zzaduVarZzb.zzm(10);
        zzaduVarZzb.zzc(zzadoVar);
        this.zzb.zza(zzii.zza((zzaea) zzaduVarZzb.zzq()));
    }
}
