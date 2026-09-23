package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzavb {
    public static final zzart zza = zzart.zza("internal:health-checking-config");
    public static final zzauz zzb = new zzaum();
    private int zzc;

    public abstract void zza(zzaxd zzaxdVar);

    public void zzb(zzaux zzauxVar) {
        int i = this.zzc;
        this.zzc = i + 1;
        if (i == 0) {
            zze(zzauxVar);
        }
        this.zzc = 0;
    }

    public void zzc() {
    }

    public abstract void zzd();

    public boolean zze(zzaux zzauxVar) {
        if (!zzauxVar.zze().isEmpty()) {
            int i = this.zzc;
            this.zzc = i + 1;
            if (i == 0) {
                zzb(zzauxVar);
            }
            this.zzc = 0;
            return true;
        }
        zzf();
        zza(zzaxd.zzp.zzg("NameResolver returned no usable address. addrs=" + String.valueOf(zzauxVar.zze()) + ", attrs=" + zzauxVar.zza().toString()));
        return false;
    }

    public boolean zzf() {
        return false;
    }
}
