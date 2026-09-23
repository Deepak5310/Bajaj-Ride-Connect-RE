package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdm extends zzbcg {
    private final zzazw zza;
    private final zzayv zzb;

    /* synthetic */ zzbdm(zzazw zzazwVar, zzayv zzayvVar, zzbdl zzbdlVar) {
        this.zza = zzazwVar;
        this.zzb = zzayvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbcg, com.google.android.libraries.places.internal.zzazl
    public final zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) {
        return new zzbdk(this, this.zza.zza(zzawaVar, zzavuVar, zzasaVar, zzasoVarArr));
    }

    @Override // com.google.android.libraries.places.internal.zzbcg
    protected final zzazw zzb() {
        return this.zza;
    }
}
