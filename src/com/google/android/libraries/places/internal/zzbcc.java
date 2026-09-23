package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbcc extends zzbgp {
    private boolean zzb;
    private final zzaxd zzc;
    private final zzazj zzd;
    private final zzaso[] zze;

    public zzbcc(zzaxd zzaxdVar, zzazj zzazjVar, zzaso[] zzasoVarArr) {
        zzkt.zzf(!zzaxdVar.zzl(), "error must not be OK");
        this.zzc = zzaxdVar;
        this.zzd = zzazjVar;
        this.zze = zzasoVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbgp, com.google.android.libraries.places.internal.zzazi
    public final void zzg(zzbda zzbdaVar) {
        zzbdaVar.zzb("error", this.zzc);
        zzbdaVar.zzb("progress", this.zzd);
    }

    @Override // com.google.android.libraries.places.internal.zzbgp, com.google.android.libraries.places.internal.zzazi
    public final void zzo(zzazk zzazkVar) {
        zzkt.zzo(!this.zzb, "already started");
        this.zzb = true;
        int i = 0;
        while (true) {
            zzaso[] zzasoVarArr = this.zze;
            if (i >= zzasoVarArr.length) {
                zzazkVar.zzd(this.zzc, this.zzd, new zzavu());
                return;
            } else {
                zzaso zzasoVar = zzasoVarArr[i];
                i++;
            }
        }
    }
}
