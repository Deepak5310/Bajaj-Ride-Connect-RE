package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnd {
    zzbnb[] zza;
    int zzb;
    private final zzbpl zzc;
    private int zzd;
    private int zze;

    zzbnd(int i, boolean z, zzbpl zzbplVar) {
        zzbnb[] zzbnbVarArr = new zzbnb[8];
        this.zza = zzbnbVarArr;
        this.zzd = zzbnbVarArr.length - 1;
        this.zzc = zzbplVar;
    }

    private final void zzd(zzbnb zzbnbVar) {
        int i;
        int i2 = zzbnbVar.zzj;
        if (i2 > 4096) {
            Arrays.fill(this.zza, (Object) null);
            this.zzd = this.zza.length - 1;
            this.zzb = 0;
            this.zze = 0;
            return;
        }
        int i3 = (this.zze + i2) - 4096;
        if (i3 > 0) {
            int length = this.zza.length - 1;
            int i4 = 0;
            while (true) {
                i = this.zzd;
                if (length < i || i3 <= 0) {
                    break;
                }
                int i5 = this.zza[length].zzj;
                i3 -= i5;
                this.zze -= i5;
                this.zzb--;
                i4++;
                length--;
            }
            zzbnb[] zzbnbVarArr = this.zza;
            int i6 = i + 1;
            System.arraycopy(zzbnbVarArr, i6, zzbnbVarArr, i6 + i4, this.zzb);
            this.zzd += i4;
        }
        int i7 = this.zzb + 1;
        zzbnb[] zzbnbVarArr2 = this.zza;
        int length2 = zzbnbVarArr2.length;
        if (i7 > length2) {
            zzbnb[] zzbnbVarArr3 = new zzbnb[length2 + length2];
            System.arraycopy(zzbnbVarArr2, 0, zzbnbVarArr3, length2, length2);
            this.zzd = this.zza.length - 1;
            this.zza = zzbnbVarArr3;
        }
        int i8 = this.zzd;
        this.zzd = i8 - 1;
        this.zza[i8] = zzbnbVar;
        this.zzb++;
        this.zze += i2;
    }

    final void zza(zzbpp zzbppVar) throws IOException {
        zzc(zzbppVar.zzc(), 127, 0);
        this.zzc.zzk(zzbppVar);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0053  */
    final void zzb(List list) throws IOException {
        int i;
        int i2;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzbnb zzbnbVar = (zzbnb) list.get(i3);
            zzbpp zzbppVarZzg = zzbnbVar.zzh.zzg();
            zzbpp zzbppVar = zzbnbVar.zzi;
            Integer num = (Integer) zzbne.zzc.get(zzbppVarZzg);
            if (num != null) {
                int iIntValue = num.intValue();
                i2 = iIntValue + 1;
                if (i2 < 2 || i2 > 7) {
                    i = i2;
                    i2 = -1;
                } else if (zzbne.zzb[iIntValue].zzi.equals(zzbppVar)) {
                    i = i2;
                } else if (zzbne.zzb[i2].zzi.equals(zzbppVar)) {
                    i2 = iIntValue + 2;
                    i = i2;
                } else {
                    i = i2;
                    i2 = -1;
                }
            } else {
                i = -1;
                i2 = -1;
            }
            if (i2 == -1) {
                int i4 = this.zzd;
                while (true) {
                    i4++;
                    zzbnb[] zzbnbVarArr = this.zza;
                    if (i4 >= zzbnbVarArr.length) {
                        i2 = -1;
                        break;
                    }
                    if (zzbnbVarArr[i4].zzh.equals(zzbppVarZzg)) {
                        if (this.zza[i4].zzi.equals(zzbppVar)) {
                            int i5 = i4 - this.zzd;
                            int length = zzbne.zzb.length;
                            i2 = i5 + 61;
                            break;
                        } else if (i == -1) {
                            int i6 = i4 - this.zzd;
                            int length2 = zzbne.zzb.length;
                            i = i6 + 61;
                        }
                    }
                }
            }
            if (i2 != -1) {
                zzc(i2, 127, 128);
            } else if (i == -1) {
                this.zzc.zzm(64);
                zza(zzbppVarZzg);
                zza(zzbppVar);
                zzd(zzbnbVar);
            } else if (!zzbppVarZzg.zzm(zzbne.zza) || zzbnb.zze.equals(zzbppVarZzg)) {
                zzc(i, 63, 64);
                zza(zzbppVar);
                zzd(zzbnbVar);
            } else {
                zzc(i, 15, 0);
                zza(zzbppVar);
            }
        }
    }

    final void zzc(int i, int i2, int i3) throws IOException {
        if (i < i2) {
            this.zzc.zzm(i | i3);
            return;
        }
        this.zzc.zzm(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            this.zzc.zzm(128 | (i4 & 127));
            i4 >>>= 7;
        }
        this.zzc.zzm(i4);
    }
}
