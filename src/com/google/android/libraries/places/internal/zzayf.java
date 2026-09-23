package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayf {
    final /* synthetic */ zzayn zza;
    private final zzaus zzb;
    private zzavb zzc;
    private zzavd zzd;

    zzayf(zzayn zzaynVar, zzaus zzausVar) {
        this.zza = zzaynVar;
        this.zzb = zzausVar;
        zzavd zzavdVarZza = zzaynVar.zza.zza(zzaynVar.zzb);
        this.zzd = zzavdVarZza;
        if (zzavdVarZza != null) {
            this.zzc = zzavdVarZza.zza(zzausVar);
            return;
        }
        throw new IllegalStateException("Could not find policy '" + zzaynVar.zzb + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
    }

    public final zzavb zza() {
        return this.zzc;
    }

    final void zzb() {
        this.zzc.zzd();
        this.zzc = null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0057  */
    /* JADX WARN: Multi-variable type inference failed */
    final boolean zzc(zzaux zzauxVar) {
        zzbjl zzbjlVar = (zzbjl) zzauxVar.zzd();
        zzayg zzaygVar = null;
        Object[] objArr = 0;
        if (zzbjlVar == null) {
            try {
                zzayn zzaynVar = this.zza;
                zzbjlVar = new zzbjl(zzayn.zza(zzaynVar, zzaynVar.zzb, "using default policy"), null);
            } catch (zzaym e) {
                this.zzb.zzd(zzasu.TRANSIENT_FAILURE, new zzayi(zzaxd.zzo.zzg(e.getMessage())));
                this.zzc.zzd();
                this.zzd = null;
                this.zzc = new zzayk(objArr == true ? 1 : 0);
                return true;
            }
        }
        zzavd zzavdVar = this.zzd;
        if (zzavdVar != null) {
            zzavd zzavdVar2 = zzbjlVar.zza;
            if (!zzavdVar2.zzd().equals(zzavdVar.zzd())) {
                this.zzb.zzd(zzasu.CONNECTING, new zzayh(zzaygVar));
                this.zzc.zzd();
                zzavd zzavdVar3 = zzbjlVar.zza;
                this.zzd = zzavdVar3;
                zzavb zzavbVar = this.zzc;
                this.zzc = zzavdVar3.zza(this.zzb);
                ((zzbex) this.zzb).zzb.zzW.zzb(2, "Load balancer changed from {0} to {1}", zzavbVar.getClass().getSimpleName(), this.zzc.getClass().getSimpleName());
            }
        } else {
            this.zzb.zzd(zzasu.CONNECTING, new zzayh(zzaygVar));
            this.zzc.zzd();
            zzavd zzavdVar4 = zzbjlVar.zza;
            this.zzd = zzavdVar4;
            zzavb zzavbVar2 = this.zzc;
            this.zzc = zzavdVar4.zza(this.zzb);
            ((zzbex) this.zzb).zzb.zzW.zzb(2, "Load balancer changed from {0} to {1}", zzavbVar2.getClass().getSimpleName(), this.zzc.getClass().getSimpleName());
        }
        Object obj = zzbjlVar.zzb;
        if (obj != null) {
            ((zzbex) this.zzb).zzb.zzW.zzb(1, "Load-balancing config: {0}", obj);
        }
        zzavb zzavbVar3 = this.zzc;
        zzauv zzauvVarZzb = zzaux.zzb();
        zzauvVarZzb.zza(zzauxVar.zze());
        zzauvVarZzb.zzb(zzauxVar.zza());
        zzauvVarZzb.zzc(obj);
        return zzavbVar3.zze(zzauvVarZzb.zzd());
    }
}
