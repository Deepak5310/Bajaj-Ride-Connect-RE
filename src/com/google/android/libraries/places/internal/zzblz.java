package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblz {
    private final zzblw zza;
    private final zzbna zzb;
    private int zzc;
    private final zzblv zzd;

    public zzblz(zzblw zzblwVar, zzbna zzbnaVar) {
        this.zza = zzblwVar;
        zzkt.zzc(zzbnaVar, "frameWriter");
        this.zzb = zzbnaVar;
        this.zzc = 65535;
        this.zzd = new zzblv(this, 0, 65535, null);
    }

    public final int zza(@Nullable zzblv zzblvVar, int i) {
        if (zzblvVar == null) {
            int iZzb = this.zzd.zzb(i);
            zzg();
            return iZzb;
        }
        int iZzb2 = zzblvVar.zzb(i);
        zzbly zzblyVar = new zzbly(null);
        zzblvVar.zzf(zzblvVar.zze(), zzblyVar);
        if (!zzblyVar.zza()) {
            return iZzb2;
        }
        zzf();
        return iZzb2;
    }

    public final zzblv zzc(zzblu zzbluVar, int i) {
        return new zzblv(this, i, this.zzc, zzbluVar);
    }

    public final void zze(boolean z, zzblv zzblvVar, zzbpl zzbplVar, boolean z2) {
        zzkt.zzc(zzbplVar, "source");
        int iZze = zzblvVar.zze();
        boolean zZzk = zzblvVar.zzk();
        int iZzg = (int) zzbplVar.getZzb();
        if (zZzk || iZze < iZzg) {
            if (!zZzk && iZze > 0) {
                zzblvVar.zzj(zzbplVar, iZze, false);
            }
            zzblvVar.zzi(zzbplVar, (int) zzbplVar.getZzb(), z);
        } else {
            zzblvVar.zzj(zzbplVar, iZzg, z);
        }
        if (z2) {
            zzf();
        }
    }

    public final void zzg() {
        int i;
        zzblv[] zzblvVarArrZzV = this.zza.zzV();
        Collections.shuffle(Arrays.asList(zzblvVarArrZzV));
        int length = zzblvVarArrZzV.length;
        int iZzd = this.zzd.zzd();
        while (true) {
            i = 0;
            if (length <= 0 || iZzd <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(iZzd / length);
            for (int i2 = 0; i2 < length && iZzd > 0; i2++) {
                zzblv zzblvVar = zzblvVarArrZzV[i2];
                int iMin = Math.min(iZzd, Math.min(zzblvVar.zzc(), iCeil));
                if (iMin > 0) {
                    zzblvVar.zzg(iMin);
                    iZzd -= iMin;
                }
                if (zzblvVar.zzc() > 0) {
                    zzblvVarArrZzV[i] = zzblvVar;
                    i++;
                }
            }
            length = i;
        }
        zzbly zzblyVar = new zzbly(null);
        zzblv[] zzblvVarArrZzV2 = this.zza.zzV();
        int length2 = zzblvVarArrZzV2.length;
        while (i < length2) {
            zzblv zzblvVar2 = zzblvVarArrZzV2[i];
            zzblvVar2.zzf(zzblvVar2.zza(), zzblyVar);
            zzblvVar2.zzh();
            i++;
        }
        if (zzblyVar.zza()) {
            zzf();
        }
    }

    public final boolean zzh(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i);
        }
        int i2 = i - this.zzc;
        this.zzc = i;
        for (zzblv zzblvVar : this.zza.zzV()) {
            zzblvVar.zzb(i2);
        }
        return i2 > 0;
    }

    public final void zzf() {
        try {
            this.zzb.zzg();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
