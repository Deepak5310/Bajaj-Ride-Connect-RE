package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqh {
    private static final zzaqh zza = new zzaqh(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaqh() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaqh(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaqh zzc() {
        return zza;
    }

    static zzaqh zze(zzaqh zzaqhVar, zzaqh zzaqhVar2) {
        int i = zzaqhVar.zzb + zzaqhVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaqhVar.zzc, i);
        System.arraycopy(zzaqhVar2.zzc, 0, iArrCopyOf, zzaqhVar.zzb, zzaqhVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaqhVar.zzd, i);
        System.arraycopy(zzaqhVar2.zzd, 0, objArrCopyOf, zzaqhVar.zzb, zzaqhVar2.zzb);
        return new zzaqh(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzaqh zzf() {
        return new zzaqh(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaqh)) {
            return false;
        }
        zzaqh zzaqhVar = (zzaqh) obj;
        int i = this.zzb;
        if (i == zzaqhVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaqhVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzaqhVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzB;
        int iZzA;
        int iZzA2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzA2 = zzamy.zzA(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzaml zzamlVar = (zzaml) this.zzd[i3];
                    int i8 = zzamy.zzf;
                    int iZzd = zzamlVar.zzd();
                    iZzA2 = zzamy.zzA(i7) + zzamy.zzA(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int i9 = i5 << 3;
                    int i10 = zzamy.zzf;
                    iZzB = ((zzaqh) this.zzd[i3]).zza();
                    int iZzA3 = zzamy.zzA(i9);
                    iZzA = iZzA3 + iZzA3;
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzaoc.zza());
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzA2 = zzamy.zzA(i5 << 3) + 4;
                }
                i2 += iZzA2;
            } else {
                int i11 = i5 << 3;
                iZzB = zzamy.zzB(((Long) this.zzd[i3]).longValue());
                iZzA = zzamy.zzA(i11);
            }
            iZzA2 = iZzA + iZzB;
            i2 += iZzA2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzA = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzaml zzamlVar = (zzaml) this.zzd[i2];
            int i4 = zzamy.zzf;
            int iZzd = zzamlVar.zzd();
            int iZzA2 = zzamy.zzA(iZzd) + iZzd;
            int iZzA3 = zzamy.zzA(16);
            int iZzA4 = zzamy.zzA(i3);
            int iZzA5 = zzamy.zzA(8);
            iZzA += iZzA5 + iZzA5 + iZzA3 + iZzA4 + zzamy.zzA(24) + iZzA2;
        }
        this.zze = iZzA;
        return iZzA;
    }

    final zzaqh zzd(zzaqh zzaqhVar) {
        if (zzaqhVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzaqhVar.zzb;
        zzl(i);
        System.arraycopy(zzaqhVar.zzc, 0, this.zzc, this.zzb, zzaqhVar.zzb);
        System.arraycopy(zzaqhVar.zzd, 0, this.zzd, this.zzb, zzaqhVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzapb.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzamz zzamzVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzamzVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzamzVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzamzVar.zzd(i4, (zzaml) obj);
                } else if (i3 == 3) {
                    zzamzVar.zzE(i4);
                    ((zzaqh) obj).zzk(zzamzVar);
                    zzamzVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzaoc.zza());
                    }
                    zzamzVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
