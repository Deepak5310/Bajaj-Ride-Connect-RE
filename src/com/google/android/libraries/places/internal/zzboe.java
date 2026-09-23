package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzboe extends zzboc {
    private final zzboa zza;
    private Object zzb;
    private boolean zzc;

    zzboe(zzboa zzboaVar) {
        super(null);
        this.zzc = false;
        this.zza = zzboaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zza(zzaxd zzaxdVar, zzavu zzavuVar) {
        if (!zzaxdVar.zzl()) {
            this.zza.zzm(new zzaxf(zzaxdVar, zzavuVar));
            return;
        }
        if (!this.zzc) {
            this.zza.zzm(new zzaxf(zzaxd.zzo.zzg("No value received for unary call"), zzavuVar));
        }
        this.zza.zzl(this.zzb);
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zzb(zzavu zzavuVar) {
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zzc(Object obj) {
        if (this.zzc) {
            throw new zzaxf(zzaxd.zzo.zzg("More than one value received for unary call"), null);
        }
        this.zzb = obj;
        this.zzc = true;
    }

    @Override // com.google.android.libraries.places.internal.zzboc
    final void zze() {
        this.zza.zzb.zzc(2);
    }
}
