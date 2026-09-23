package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblv {
    final /* synthetic */ zzblz zza;
    private final int zzc;
    private int zzd;
    private int zze;
    private final zzblu zzf;
    private final zzbpl zzb = new zzbpl();
    private boolean zzg = false;

    zzblv(zzblz zzblzVar, int i, int i2, zzblu zzbluVar) {
        this.zza = zzblzVar;
        this.zzc = i;
        this.zzd = i2;
        this.zzf = zzbluVar;
    }

    final int zza() {
        return this.zze;
    }

    final int zzb(int i) {
        if (i <= 0 || Integer.MAX_VALUE - i >= this.zzd) {
            int i2 = this.zzd + i;
            this.zzd = i2;
            return i2;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.zzc);
    }

    final int zzc() {
        return Math.max(0, Math.min(this.zzd, (int) this.zzb.getZzb())) - this.zze;
    }

    final int zzd() {
        return this.zzd;
    }

    final int zze() {
        return Math.min(this.zzd, this.zza.zzd.zzd);
    }

    final int zzf(int i, zzbly zzblyVar) {
        int iMin = Math.min(i, zze());
        int zzb = 0;
        while (zzk() && iMin > 0) {
            zzbpl zzbplVar = this.zzb;
            if (iMin >= zzbplVar.getZzb()) {
                zzb += (int) zzbplVar.getZzb();
                zzj(zzbplVar, (int) zzbplVar.getZzb(), this.zzg);
            } else {
                zzb += iMin;
                zzj(zzbplVar, iMin, false);
            }
            zzblyVar.zza++;
            iMin = Math.min(i - zzb, zze());
        }
        return zzb;
    }

    final void zzg(int i) {
        this.zze += i;
    }

    final void zzh() {
        this.zze = 0;
    }

    final void zzi(zzbpl zzbplVar, int i, boolean z) {
        this.zzb.zzn(zzbplVar, i);
        this.zzg |= z;
    }

    final void zzj(zzbpl zzbplVar, int i, boolean z) {
        do {
            int iMin = Math.min(i, this.zza.zzb.zzd());
            int i2 = -iMin;
            this.zza.zzd.zzb(i2);
            zzb(i2);
            try {
                boolean z2 = false;
                if (zzbplVar.getZzb() == iMin && z) {
                    z2 = true;
                }
                this.zza.zzb.zzf(z2, this.zzc, zzbplVar, iMin);
                this.zzf.zzs(iMin);
                i -= iMin;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (i > 0);
    }

    final boolean zzk() {
        return this.zzb.getZzb() > 0;
    }
}
