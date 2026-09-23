package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnc {
    zzbnb[] zza;
    int zzb;
    private final zzbpn zzf;
    private final List zze = new ArrayList();
    int zzc = 0;
    int zzd = 0;
    private int zzg = 4096;
    private int zzh = 4096;

    zzbnc(int i, int i2, zzbqc zzbqcVar) {
        zzbnb[] zzbnbVarArr = new zzbnb[8];
        this.zza = zzbnbVarArr;
        this.zzb = zzbnbVarArr.length - 1;
        this.zzf = zzbpr.zzb(zzbqcVar);
    }

    private final int zzf(int i) {
        return this.zzb + 1 + i;
    }

    private final int zzg(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.zza.length;
            while (true) {
                length--;
                i2 = this.zzb;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.zza[length].zzj;
                i -= i4;
                this.zzd -= i4;
                this.zzc--;
                i3++;
            }
            zzbnb[] zzbnbVarArr = this.zza;
            int i5 = i2 + 1;
            System.arraycopy(zzbnbVarArr, i5, zzbnbVarArr, i5 + i3, this.zzc);
            this.zzb += i3;
        }
        return i3;
    }

    private final int zzh() throws IOException {
        return this.zzf.zzc() & 255;
    }

    private final zzbpp zzi(int i) throws IOException {
        if (zzm(i)) {
            return zzbne.zzb[i].zzh;
        }
        int length = zzbne.zzb.length;
        int iZzf = zzf(i - 61);
        if (iZzf >= 0) {
            zzbnb[] zzbnbVarArr = this.zza;
            if (iZzf < zzbnbVarArr.length) {
                return zzbnbVarArr[iZzf].zzh;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    private final void zzj() {
        int i = this.zzh;
        int i2 = this.zzd;
        if (i < i2) {
            if (i == 0) {
                zzk();
            } else {
                zzg(i2 - i);
            }
        }
    }

    private final void zzk() {
        Arrays.fill(this.zza, (Object) null);
        this.zzb = this.zza.length - 1;
        this.zzc = 0;
        this.zzd = 0;
    }

    private final void zzl(int i, zzbnb zzbnbVar) {
        this.zze.add(zzbnbVar);
        int i2 = zzbnbVar.zzj;
        int i3 = this.zzh;
        if (i2 > i3) {
            zzk();
            return;
        }
        zzg((this.zzd + i2) - i3);
        int i4 = this.zzc + 1;
        zzbnb[] zzbnbVarArr = this.zza;
        int length = zzbnbVarArr.length;
        if (i4 > length) {
            zzbnb[] zzbnbVarArr2 = new zzbnb[length + length];
            System.arraycopy(zzbnbVarArr, 0, zzbnbVarArr2, length, length);
            this.zzb = this.zza.length - 1;
            this.zza = zzbnbVarArr2;
        }
        int i5 = this.zzb;
        this.zzb = i5 - 1;
        this.zza[i5] = zzbnbVar;
        this.zzc++;
        this.zzd += i2;
    }

    private static final boolean zzm(int i) {
        if (i < 0) {
            return false;
        }
        int length = zzbne.zzb.length;
        return i <= 60;
    }

    final int zza(int i, int i2) throws IOException {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            int iZzh = zzh();
            if ((iZzh & 128) == 0) {
                return i2 + (iZzh << i4);
            }
            i2 += (iZzh & 127) << i4;
            i4 += 7;
        }
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(this.zze);
        this.zze.clear();
        return arrayList;
    }

    final zzbpp zzc() throws IOException {
        int iZzh = zzh();
        int i = iZzh & 128;
        long jZza = zza(iZzh, 127);
        if (i != 128) {
            return this.zzf.zzy(jZza);
        }
        zzbpn zzbpnVar = this.zzf;
        zzbnl zzbnlVarZza = zzbnl.zza();
        zzbpv zzbpvVar = (zzbpv) zzbpnVar;
        zzbpvVar.zzD(jZza);
        byte[] bArrZzb = zzbnlVarZza.zzb(zzbpvVar.zzb.zzH(jZza));
        zzbpo zzbpoVar = zzbpp.zza;
        return zzbpo.zzb(bArrZzb);
    }

    final void zzd(int i) {
        this.zzg = i;
        this.zzh = i;
        zzj();
    }

    final void zze() throws IOException {
        while (true) {
            zzbpv zzbpvVar = (zzbpv) this.zzf;
            if (zzbpvVar.zzc) {
                throw new IllegalStateException("closed");
            }
            zzbpl zzbplVar = zzbpvVar.zzb;
            if (zzbplVar.zzG() && zzbpvVar.zza.zza(zzbplVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return;
            }
            byte bZzc = this.zzf.zzc();
            int i = bZzc & 255;
            if (i == 128) {
                throw new IOException("index == 0");
            }
            if ((bZzc & 128) == 128) {
                int iZza = zza(i, 127);
                int i2 = iZza - 1;
                if (!zzm(i2)) {
                    int length = zzbne.zzb.length;
                    int iZzf = zzf(iZza - 62);
                    if (iZzf >= 0) {
                        zzbnb[] zzbnbVarArr = this.zza;
                        if (iZzf <= zzbnbVarArr.length - 1) {
                            this.zze.add(zzbnbVarArr[iZzf]);
                        }
                    }
                    throw new IOException("Header index too large " + iZza);
                }
                this.zze.add(zzbne.zzb[i2]);
            } else if (i == 64) {
                zzbpp zzbppVarZzc = zzc();
                zzbne.zzc(zzbppVarZzc);
                zzl(-1, new zzbnb(zzbppVarZzc, zzc()));
            } else if ((bZzc & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                zzl(-1, new zzbnb(zzi(zza(i, 63) - 1), zzc()));
            } else if ((bZzc & 32) == 32) {
                int iZza2 = zza(i, 31);
                this.zzh = iZza2;
                if (iZza2 < 0 || iZza2 > this.zzg) {
                    throw new IOException("Invalid dynamic table size update " + iZza2);
                }
                zzj();
            } else if (i == 16 || i == 0) {
                zzbpp zzbppVarZzc2 = zzc();
                zzbne.zzc(zzbppVarZzc2);
                this.zze.add(new zzbnb(zzbppVarZzc2, zzc()));
            } else {
                this.zze.add(new zzbnb(zzi(zza(i, 15) - 1), zzc()));
            }
        }
    }
}
