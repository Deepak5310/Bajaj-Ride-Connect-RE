package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfo<T> implements zzgb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfl zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzez zzm;
    private final zzgp zzn;
    private final zzdo zzo;
    private final zzfr zzp;
    private final zzfg zzq;

    private zzfo(int[] iArr, Object[] objArr, int i, int i2, zzfl zzflVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzfr zzfrVar, zzez zzezVar, zzgp zzgpVar, zzdo zzdoVar, zzfg zzfgVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzdoVar != null && zzdoVar.zzf(zzflVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzfrVar;
        this.zzm = zzezVar;
        this.zzn = zzgpVar;
        this.zzo = zzdoVar;
        this.zzg = zzflVar;
        this.zzq = zzfgVar;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzgz.zzf(obj, j)).longValue();
    }

    private final zzeg zzD(int i) {
        int i2 = i / 3;
        return (zzeg) this.zzd[i2 + i2 + 1];
    }

    private final zzgb zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgb zzgbVar = (zzgb) this.zzd[i3];
        if (zzgbVar != null) {
            return zzgbVar;
        }
        zzgb zzgbVarZzb = zzfu.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgbVarZzb;
        return zzgbVarZzb;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        if (zzM(obj2, i)) {
            Object objZzf = zzgz.zzf(obj, jZzB);
            Object objZzf2 = zzgz.zzf(obj2, jZzB);
            if (objZzf != null && objZzf2 != null) {
                zzgz.zzs(obj, jZzB, zzel.zzg(objZzf, objZzf2));
                zzJ(obj, i);
            } else if (objZzf2 != null) {
                zzgz.zzs(obj, jZzB, objZzf2);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int iZzB = zzB(i);
        int i2 = this.zzc[i];
        long j = iZzB & 1048575;
        if (zzP(obj2, i2, i)) {
            Object objZzf = zzP(obj, i2, i) ? zzgz.zzf(obj, j) : null;
            Object objZzf2 = zzgz.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzgz.zzs(obj, j, zzel.zzg(objZzf, objZzf2));
                zzK(obj, i2, i);
            } else if (objZzf2 != null) {
                zzgz.zzs(obj, j, objZzf2);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int iZzy = zzy(i);
        long j = 1048575 & iZzy;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (iZzy >>> 20)) | zzgz.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzgz.zzq(obj, zzy(i2) & 1048575, i);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzM(obj, i) == zzM(obj2, i);
    }

    private final boolean zzM(Object obj, int i) {
        int iZzy = zzy(i);
        long j = iZzy & 1048575;
        if (j != 1048575) {
            return (zzgz.zzc(obj, j) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzB = zzB(i);
        long j2 = iZzB & 1048575;
        switch (zzA(iZzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j2)) != 0;
            case 2:
                return zzgz.zzd(obj, j2) != 0;
            case 3:
                return zzgz.zzd(obj, j2) != 0;
            case 4:
                return zzgz.zzc(obj, j2) != 0;
            case 5:
                return zzgz.zzd(obj, j2) != 0;
            case 6:
                return zzgz.zzc(obj, j2) != 0;
            case 7:
                return zzgz.zzw(obj, j2);
            case 8:
                Object objZzf = zzgz.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdb) {
                    return !zzdb.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j2) != null;
            case 10:
                return !zzdb.zzb.equals(zzgz.zzf(obj, j2));
            case 11:
                return zzgz.zzc(obj, j2) != 0;
            case 12:
                return zzgz.zzc(obj, j2) != 0;
            case 13:
                return zzgz.zzc(obj, j2) != 0;
            case 14:
                return zzgz.zzd(obj, j2) != 0;
            case 15:
                return zzgz.zzc(obj, j2) != 0;
            case 16:
                return zzgz.zzd(obj, j2) != 0;
            case 17:
                return zzgz.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzN(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzM(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzO(Object obj, int i, zzgb zzgbVar) {
        return zzgbVar.zzj(zzgz.zzf(obj, i & 1048575));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzgz.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzQ(Object obj, long j) {
        return ((Boolean) zzgz.zzf(obj, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    private final void zzR(Object obj, zzdj zzdjVar) throws IOException {
        Iterator itZzf;
        Map.Entry entry;
        int i;
        boolean z;
        if (this.zzh) {
            zzds zzdsVarZzb = this.zzo.zzb(obj);
            if (zzdsVarZzb.zza.isEmpty()) {
                itZzf = null;
                entry = null;
            } else {
                itZzf = zzdsVarZzb.zzf();
                entry = (Map.Entry) itZzf.next();
            }
        } else {
            itZzf = null;
            entry = null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzB = zzB(i4);
            int[] iArr = this.zzc;
            int i5 = iArr[i4];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i6 = iArr[i4 + 2];
                int i7 = i6 & 1048575;
                if (i7 != i2) {
                    i3 = unsafe.getInt(obj, i7);
                    i2 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.zzo.zza(entry) <= i5) {
                this.zzo.zzg(zzdjVar, entry);
                entry = itZzf.hasNext() ? (Map.Entry) itZzf.next() : null;
            }
            long j = iZzB & 1048575;
            switch (iZzA) {
                case 0:
                    if ((i & i3) != 0) {
                        zzdjVar.zzf(i5, zzgz.zza(obj, j));
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        zzdjVar.zzo(i5, zzgz.zzb(obj, j));
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        zzdjVar.zzt(i5, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        zzdjVar.zzK(i5, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        zzdjVar.zzr(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        zzdjVar.zzm(i5, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        zzdjVar.zzk(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        zzdjVar.zzb(i5, zzgz.zzw(obj, j));
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        zzT(i5, unsafe.getObject(obj, j), zzdjVar);
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        zzdjVar.zzv(i5, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        zzdjVar.zzd(i5, (zzdb) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        zzdjVar.zzI(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        zzdjVar.zzi(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        zzdjVar.zzx(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        zzdjVar.zzz(i5, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        zzdjVar.zzB(i5, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        zzdjVar.zzD(i5, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        zzdjVar.zzq(i5, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case 18:
                    z = false;
                    zzgd.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 19:
                    z = false;
                    zzgd.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 20:
                    z = false;
                    zzgd.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 21:
                    z = false;
                    zzgd.zzaa(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 22:
                    z = false;
                    zzgd.zzR(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 23:
                    z = false;
                    zzgd.zzO(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 24:
                    z = false;
                    zzgd.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 25:
                    z = false;
                    zzgd.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 26:
                    zzgd.zzY(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar);
                    break;
                case 27:
                    zzgd.zzT(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, zzE(i4));
                    break;
                case 28:
                    zzgd.zzK(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar);
                    break;
                case 29:
                    z = false;
                    zzgd.zzZ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 30:
                    z = false;
                    zzgd.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 31:
                    z = false;
                    zzgd.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 32:
                    z = false;
                    zzgd.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 33:
                    z = false;
                    zzgd.zzW(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 34:
                    z = false;
                    zzgd.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, false);
                    break;
                case 35:
                    zzgd.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 36:
                    zzgd.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 37:
                    zzgd.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 38:
                    zzgd.zzaa(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 39:
                    zzgd.zzR(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 40:
                    zzgd.zzO(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 41:
                    zzgd.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 42:
                    zzgd.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 43:
                    zzgd.zzZ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 44:
                    zzgd.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 45:
                    zzgd.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 46:
                    zzgd.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 47:
                    zzgd.zzW(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 48:
                    zzgd.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, true);
                    break;
                case 49:
                    zzgd.zzQ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzdjVar, zzE(i4));
                    break;
                case 50:
                    zzS(zzdjVar, i5, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzf(i5, zzn(obj, j));
                    }
                    break;
                case 52:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzo(i5, zzo(obj, j));
                    }
                    break;
                case 53:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzt(i5, zzC(obj, j));
                    }
                    break;
                case 54:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzK(i5, zzC(obj, j));
                    }
                    break;
                case 55:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzr(i5, zzr(obj, j));
                    }
                    break;
                case 56:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzm(i5, zzC(obj, j));
                    }
                    break;
                case 57:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzk(i5, zzr(obj, j));
                    }
                    break;
                case 58:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzb(i5, zzQ(obj, j));
                    }
                    break;
                case 59:
                    if (zzP(obj, i5, i4)) {
                        zzT(i5, unsafe.getObject(obj, j), zzdjVar);
                    }
                    break;
                case 60:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzv(i5, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case 61:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzd(i5, (zzdb) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzI(i5, zzr(obj, j));
                    }
                    break;
                case 63:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzi(i5, zzr(obj, j));
                    }
                    break;
                case 64:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzx(i5, zzr(obj, j));
                    }
                    break;
                case 65:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzz(i5, zzC(obj, j));
                    }
                    break;
                case 66:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzB(i5, zzr(obj, j));
                    }
                    break;
                case 67:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzD(i5, zzC(obj, j));
                    }
                    break;
                case 68:
                    if (zzP(obj, i5, i4)) {
                        zzdjVar.zzq(i5, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                default:
                    break;
            }
        }
        while (entry != null) {
            this.zzo.zzg(zzdjVar, entry);
            entry = itZzf.hasNext() ? (Map.Entry) itZzf.next() : null;
        }
        zzgp zzgpVar = this.zzn;
        zzgpVar.zzj(zzgpVar.zzc(obj), zzdjVar);
    }

    private final void zzS(zzdj zzdjVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzT(int i, Object obj, zzdj zzdjVar) throws IOException {
        if (obj instanceof String) {
            zzdjVar.zzG(i, (String) obj);
        } else {
            zzdjVar.zzd(i, (zzdb) obj);
        }
    }

    static zzgq zzd(Object obj) {
        zzec zzecVar = (zzec) obj;
        zzgq zzgqVar = zzecVar.zzc;
        if (zzgqVar != zzgq.zzc()) {
            return zzgqVar;
        }
        zzgq zzgqVarZze = zzgq.zze();
        zzecVar.zzc = zzgqVarZze;
        return zzgqVarZze;
    }

    static zzfo zzk(Class cls, zzfi zzfiVar, zzfr zzfrVar, zzez zzezVar, zzgp zzgpVar, zzdo zzdoVar, zzfg zzfgVar) {
        if (zzfiVar instanceof zzfw) {
            return zzl((zzfw) zzfiVar, zzfrVar, zzezVar, zzgpVar, zzdoVar, zzfgVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0261  */
    /* JADX WARN: Code duplicated, block: B:127:0x0279  */
    /* JADX WARN: Code duplicated, block: B:128:0x027c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0330  */
    /* JADX WARN: Code duplicated, block: B:177:0x037f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0389  */
    static zzfo zzl(zzfw zzfwVar, zzfr zzfrVar, zzez zzezVar, zzgp zzgpVar, zzdo zzdoVar, zzfg zzfgVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Object[] objArr;
        int i20;
        int i21;
        Field fieldZzG;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldZzG2;
        int i26;
        Object obj2;
        Field fieldZzG3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        boolean z = zzfwVar.zzc() == 2;
        String strZzd = zzfwVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (strZzd.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt4 = strZzd.charAt(i);
        if (iCharAt4 >= 55296) {
            int i33 = iCharAt4 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = strZzd.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt4 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt4 == 0) {
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i4 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt5 = strZzd.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt8 = strZzd.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt8 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strZzd.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt7 = strZzd.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt7 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            iCharAt = strZzd.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt6 = strZzd.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strZzd.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt5 = strZzd.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strZzd.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt4 = strZzd.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt4 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strZzd.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt3 = strZzd.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt3 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strZzd.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt2 = strZzd.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt2 << i55);
                i53 = i7;
            }
            int i56 = i53 + 1;
            iCharAt3 = strZzd.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt = strZzd.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i6;
                }
                iCharAt3 = i57 | (cCharAt << i58);
                i56 = i6;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i2 = iCharAt5 + iCharAt5 + iCharAt6;
            i3 = iCharAt5;
            i32 = i56;
            int i59 = iCharAt8;
            i4 = iCharAt7;
            i5 = i59;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzfwVar.zze();
        Class<?> cls = zzfwVar.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i60 = iCharAt3 + i5;
        int i61 = iCharAt3;
        int i62 = i60;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt10 = strZzd.charAt(i32);
            if (iCharAt10 >= c) {
                int i66 = iCharAt10 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i29 = i67 + 1;
                    cCharAt12 = strZzd.charAt(i67);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i29;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i14 = i29;
            } else {
                i14 = i65;
            }
            int i69 = i14 + 1;
            int iCharAt11 = strZzd.charAt(i14);
            if (iCharAt11 >= c) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt11 = strZzd.charAt(i71);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    length = i15;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i16 = i28;
            } else {
                i15 = length;
                i16 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i63;
                i64++;
            }
            if (i73 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i27 = i77 + 1;
                        cCharAt10 = strZzd.charAt(i77);
                        i18 = i4;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i76 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i77 = i27;
                        i4 = i18;
                    }
                    iCharAt12 = i76 | (cCharAt10 << i78);
                    i23 = i27;
                } else {
                    i18 = i4;
                    i23 = i75;
                }
                int i79 = i73 - 51;
                int i80 = i23;
                if (i79 == 9 || i79 == 17) {
                    int i81 = i63 / 3;
                    i24 = i2 + 1;
                    objArr2[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i79 == 12 && !z) {
                        int i82 = i63 / 3;
                        i24 = i2 + 1;
                        objArr2[i82 + i82 + 1] = objArrZze[i2];
                    }
                    i25 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i25];
                    if (obj instanceof Field) {
                        fieldZzG2 = (Field) obj;
                    } else {
                        fieldZzG2 = zzG(cls, (String) obj);
                        objArrZze[i25] = fieldZzG2;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzG2);
                    i26 = i25 + 1;
                    obj2 = objArrZze[i26];
                    if (obj2 instanceof Field) {
                        fieldZzG3 = (Field) obj2;
                    } else {
                        fieldZzG3 = zzG(cls, (String) obj2);
                        objArrZze[i26] = fieldZzG3;
                    }
                    strZzd = strZzd;
                    objArr = objArr2;
                    i19 = i2;
                    i20 = i80;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzG3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrZze[i25];
                if (obj instanceof Field) {
                    fieldZzG2 = (Field) obj;
                } else {
                    fieldZzG2 = zzG(cls, (String) obj);
                    objArrZze[i25] = fieldZzG2;
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzG2);
                i26 = i25 + 1;
                obj2 = objArrZze[i26];
                if (obj2 instanceof Field) {
                    fieldZzG3 = (Field) obj2;
                } else {
                    fieldZzG3 = zzG(cls, (String) obj2);
                    objArrZze[i26] = fieldZzG3;
                }
                strZzd = strZzd;
                objArr = objArr2;
                i19 = i2;
                i20 = i80;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzG3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i83 = i2 + 1;
                Field fieldZzG4 = zzG(cls, (String) objArrZze[i2]);
                if (i73 == 9 || i73 == 17) {
                    int i84 = i63 / 3;
                    objArr2[i84 + i84 + 1] = fieldZzG4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        int i85 = i63 / 3;
                        i22 = i2 + 2;
                        objArr2[i85 + i85 + 1] = objArrZze[i83];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        if (!z) {
                            int i86 = i63 / 3;
                            i22 = i2 + 2;
                            objArr2[i86 + i86 + 1] = objArrZze[i83];
                        }
                    } else if (i73 == 50) {
                        int i87 = i61 + 1;
                        iArr[i61] = i63;
                        int i88 = i63 / 3;
                        int i89 = i88 + i88;
                        int i90 = i2 + 2;
                        objArr2[i89] = objArrZze[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            i83 = i2 + 3;
                            objArr2[i89 + 1] = objArrZze[i90];
                            i61 = i87;
                        } else {
                            i61 = i87;
                            i19 = i90;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                        iObjectFieldOffset2 = 1048575;
                        objArr = objArr2;
                        if ((iCharAt11 & 4096) == 4096 || i73 > 17) {
                            i20 = i16;
                            i21 = 0;
                        } else {
                            int i91 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i92 = iCharAt13 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i20 = i91 + 1;
                                    cCharAt9 = strZzd.charAt(i91);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i92 |= (cCharAt9 & 8191) << i93;
                                    i93 += 13;
                                    i91 = i20;
                                }
                                iCharAt13 = i92 | (cCharAt9 << i93);
                            } else {
                                i20 = i91;
                            }
                            int i94 = i3 + i3 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i94];
                            if (obj3 instanceof Field) {
                                fieldZzG = (Field) obj3;
                            } else {
                                fieldZzG = zzG(cls, (String) obj3);
                                objArrZze[i94] = fieldZzG;
                            }
                            i21 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzG);
                        }
                        if (i73 >= 18 && i73 <= 49) {
                            iArr[i62] = iObjectFieldOffset;
                            i62++;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                    iObjectFieldOffset2 = 1048575;
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) == 4096) {
                        i20 = i16;
                        i21 = 0;
                    } else {
                        i20 = i16;
                        i21 = 0;
                    }
                    if (i73 >= 18) {
                        iArr[i62] = iObjectFieldOffset;
                        i62++;
                    }
                }
                i19 = i83;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                iObjectFieldOffset2 = 1048575;
                objArr = objArr2;
                if ((iCharAt11 & 4096) == 4096) {
                    i20 = i16;
                    i21 = 0;
                } else {
                    i20 = i16;
                    i21 = 0;
                }
                if (i73 >= 18) {
                    iArr[i62] = iObjectFieldOffset;
                    i62++;
                }
            }
            int i95 = i63 + 1;
            iArr2[i63] = iCharAt10;
            int i96 = i63 + 2;
            iArr2[i95] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | (i73 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr2[i96] = (i21 << 20) | iObjectFieldOffset2;
            i2 = i19;
            iCharAt = i17;
            iCharAt3 = i74;
            i32 = i20;
            length = i15;
            objArr2 = objArr;
            strZzd = strZzd;
            iArr3 = iArr2;
            i4 = i18;
            c = 55296;
        }
        return new zzfo(iArr3, objArr2, iCharAt, i4, zzfwVar.zza(), z, false, iArr, iCharAt3, i60, zzfrVar, zzezVar, zzgpVar, zzdoVar, zzfgVar, null);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzgz.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzgz.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i;
        int iZzD;
        int iZzD2;
        int iZzD3;
        int iZzE;
        int iZzD4;
        int iZzx;
        int iZzD5;
        int iZzD6;
        int iZzd;
        int iZzD7;
        int i2;
        int iZzu;
        boolean z;
        int iZzd2;
        int iZzi;
        int iZzC;
        int iZzD8;
        int iZzD9;
        int iZzD10;
        int iZzD11;
        int iZzD12;
        int iZzE2;
        int iZzD13;
        int iZzd3;
        int iZzD14;
        int i3;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int iZzD15 = 0;
        int i7 = 0;
        while (i6 < this.zzc.length) {
            int iZzB = zzB(i6);
            int[] iArr = this.zzc;
            int i8 = iArr[i6];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & i4;
                i = 1 << (i9 >>> 20);
                if (i10 != i5) {
                    i7 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
            } else {
                i = 0;
            }
            long j = iZzB & i4;
            switch (iZzA) {
                case 0:
                    if ((i7 & i) != 0) {
                        iZzD = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 1:
                    if ((i7 & i) != 0) {
                        iZzD2 = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 2:
                    if ((i7 & i) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzD3 = zzdi.zzD(i8 << 3);
                        iZzE = zzdi.zzE(j2);
                        iZzD15 += iZzD3 + iZzE;
                    }
                    break;
                case 3:
                    if ((i7 & i) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzD3 = zzdi.zzD(i8 << 3);
                        iZzE = zzdi.zzE(j3);
                        iZzD15 += iZzD3 + iZzE;
                    }
                    break;
                case 4:
                    if ((i7 & i) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzD4 = zzdi.zzD(i8 << 3);
                        iZzx = zzdi.zzx(i11);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                    }
                    break;
                case 5:
                    if ((i7 & i) != 0) {
                        iZzD = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 6:
                    if ((i7 & i) != 0) {
                        iZzD2 = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 7:
                    if ((i7 & i) != 0) {
                        iZzD5 = zzdi.zzD(i8 << 3) + 1;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 8:
                    if ((i7 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdb) {
                            iZzD6 = zzdi.zzD(i8 << 3);
                            iZzd = ((zzdb) object).zzd();
                            iZzD7 = zzdi.zzD(iZzd);
                            i2 = iZzD6 + iZzD7 + iZzd;
                            iZzD15 += i2;
                        } else {
                            iZzD4 = zzdi.zzD(i8 << 3);
                            iZzx = zzdi.zzB((String) object);
                            i2 = iZzD4 + iZzx;
                            iZzD15 += i2;
                        }
                    }
                    break;
                case 9:
                    if ((i7 & i) != 0) {
                        iZzD5 = zzgd.zzo(i8, unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzD5;
                    }
                    break;
                case 10:
                    if ((i7 & i) != 0) {
                        zzdb zzdbVar = (zzdb) unsafe.getObject(obj, j);
                        iZzD6 = zzdi.zzD(i8 << 3);
                        iZzd = zzdbVar.zzd();
                        iZzD7 = zzdi.zzD(iZzd);
                        i2 = iZzD6 + iZzD7 + iZzd;
                        iZzD15 += i2;
                    }
                    break;
                case 11:
                    if ((i7 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzD4 = zzdi.zzD(i8 << 3);
                        iZzx = zzdi.zzD(i12);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                    }
                    break;
                case 12:
                    if ((i7 & i) != 0) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzD4 = zzdi.zzD(i8 << 3);
                        iZzx = zzdi.zzx(i13);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                    }
                    break;
                case 13:
                    if ((i7 & i) != 0) {
                        iZzD2 = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 14:
                    if ((i7 & i) != 0) {
                        iZzD = zzdi.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                    }
                    break;
                case 15:
                    if ((i7 & i) != 0) {
                        int i14 = unsafe.getInt(obj, j);
                        iZzD4 = zzdi.zzD(i8 << 3);
                        iZzx = zzdi.zzD((i14 >> 31) ^ (i14 + i14));
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                    }
                    break;
                case 16:
                    if ((i & i7) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iZzD15 += zzdi.zzD(i8 << 3) + zzdi.zzE((j4 >> 63) ^ (j4 + j4));
                    }
                    break;
                case 17:
                    if ((i7 & i) != 0) {
                        iZzD5 = zzdi.zzv(i8, (zzfl) unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzD5;
                    }
                    break;
                case 18:
                    iZzD5 = zzgd.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 19:
                    iZzD5 = zzgd.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 20:
                    iZzD5 = zzgd.zzm(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 21:
                    iZzD5 = zzgd.zzx(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 22:
                    iZzD5 = zzgd.zzk(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 23:
                    iZzD5 = zzgd.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 24:
                    iZzD5 = zzgd.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 25:
                    iZzD5 = zzgd.zza(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 26:
                    iZzu = zzgd.zzu(i8, (List) unsafe.getObject(obj, j));
                    iZzD15 += iZzu;
                    break;
                case 27:
                    iZzu = zzgd.zzp(i8, (List) unsafe.getObject(obj, j), zzE(i6));
                    iZzD15 += iZzu;
                    break;
                case 28:
                    iZzu = zzgd.zzc(i8, (List) unsafe.getObject(obj, j));
                    iZzD15 += iZzu;
                    break;
                case 29:
                    iZzu = zzgd.zzv(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzu;
                    break;
                case 30:
                    z = false;
                    iZzd2 = zzgd.zzd(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 31:
                    z = false;
                    iZzd2 = zzgd.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 32:
                    z = false;
                    iZzd2 = zzgd.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 33:
                    z = false;
                    iZzd2 = zzgd.zzq(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 34:
                    z = false;
                    iZzd2 = zzgd.zzs(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 35:
                    iZzi = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 36:
                    iZzi = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 37:
                    iZzi = zzgd.zzn((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 38:
                    iZzi = zzgd.zzy((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 39:
                    iZzi = zzgd.zzl((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 40:
                    iZzi = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 41:
                    iZzi = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 42:
                    iZzi = zzgd.zzb((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 43:
                    iZzi = zzgd.zzw((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 44:
                    iZzi = zzgd.zze((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 45:
                    iZzi = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 46:
                    iZzi = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 47:
                    iZzi = zzgd.zzr((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 48:
                    iZzi = zzgd.zzt((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zzdi.zzC(i8);
                        iZzD8 = zzdi.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 49:
                    iZzu = zzgd.zzj(i8, (List) unsafe.getObject(obj, j), zzE(i6));
                    iZzD15 += iZzu;
                    break;
                case 50:
                    zzfg.zza(i8, unsafe.getObject(obj, j), zzF(i6));
                    break;
                case 51:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 52:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 53:
                    if (zzP(obj, i8, i6)) {
                        long jZzC = zzC(obj, j);
                        iZzD12 = zzdi.zzD(i8 << 3);
                        iZzE2 = zzdi.zzE(jZzC);
                        iZzD15 += iZzD12 + iZzE2;
                    }
                    break;
                case 54:
                    if (zzP(obj, i8, i6)) {
                        long jZzC2 = zzC(obj, j);
                        iZzD12 = zzdi.zzD(i8 << 3);
                        iZzE2 = zzdi.zzE(jZzC2);
                        iZzD15 += iZzD12 + iZzE2;
                    }
                    break;
                case 55:
                    if (zzP(obj, i8, i6)) {
                        int iZzr = zzr(obj, j);
                        iZzD9 = zzdi.zzD(i8 << 3);
                        iZzi = zzdi.zzx(iZzr);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 56:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 57:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 58:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zzdi.zzD(i8 << 3) + 1;
                        iZzD15 += iZzu;
                    }
                    break;
                case 59:
                    if (zzP(obj, i8, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdb) {
                            iZzD13 = zzdi.zzD(i8 << 3);
                            iZzd3 = ((zzdb) object2).zzd();
                            iZzD14 = zzdi.zzD(iZzd3);
                            i3 = iZzD13 + iZzD14 + iZzd3;
                            iZzD15 += i3;
                        } else {
                            iZzD9 = zzdi.zzD(i8 << 3);
                            iZzi = zzdi.zzB((String) object2);
                            i3 = iZzD9 + iZzi;
                            iZzD15 += i3;
                        }
                    }
                    break;
                case 60:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zzgd.zzo(i8, unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzu;
                    }
                    break;
                case 61:
                    if (zzP(obj, i8, i6)) {
                        zzdb zzdbVar2 = (zzdb) unsafe.getObject(obj, j);
                        iZzD13 = zzdi.zzD(i8 << 3);
                        iZzd3 = zzdbVar2.zzd();
                        iZzD14 = zzdi.zzD(iZzd3);
                        i3 = iZzD13 + iZzD14 + iZzd3;
                        iZzD15 += i3;
                    }
                    break;
                case 62:
                    if (zzP(obj, i8, i6)) {
                        int iZzr2 = zzr(obj, j);
                        iZzD9 = zzdi.zzD(i8 << 3);
                        iZzi = zzdi.zzD(iZzr2);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 63:
                    if (zzP(obj, i8, i6)) {
                        int iZzr3 = zzr(obj, j);
                        iZzD9 = zzdi.zzD(i8 << 3);
                        iZzi = zzdi.zzx(iZzr3);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 64:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 65:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zzdi.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 66:
                    if (zzP(obj, i8, i6)) {
                        int iZzr4 = zzr(obj, j);
                        iZzD9 = zzdi.zzD(i8 << 3);
                        iZzi = zzdi.zzD((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 67:
                    if (zzP(obj, i8, i6)) {
                        long jZzC3 = zzC(obj, j);
                        iZzD15 += zzdi.zzD(i8 << 3) + zzdi.zzE((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                    }
                    break;
                case 68:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zzdi.zzv(i8, (zzfl) unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzu;
                    }
                    break;
                default:
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int iZza = 0;
        zzgp zzgpVar = this.zzn;
        int iZza2 = iZzD15 + zzgpVar.zza(zzgpVar.zzc(obj));
        if (!this.zzh) {
            return iZza2;
        }
        zzds zzdsVarZzb = this.zzo.zzb(obj);
        for (int i15 = 0; i15 < zzdsVarZzb.zza.zzb(); i15++) {
            Map.Entry entryZzg = zzdsVarZzb.zza.zzg(i15);
            iZza += zzds.zza((zzdr) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzdsVarZzb.zza.zzc()) {
            iZza += zzds.zza((zzdr) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private final int zzq(Object obj) {
        int iZzD;
        int iZzD2;
        int iZzD3;
        int iZzE;
        int iZzD4;
        int iZzx;
        int iZzD5;
        int iZzD6;
        int iZzd;
        int iZzD7;
        int iZzo;
        int iZzC;
        int iZzD8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzB = zzB(i3);
            int iZzA = zzA(iZzB);
            int i4 = this.zzc[i3];
            long j = iZzB & 1048575;
            if (iZzA >= zzdt.DOUBLE_LIST_PACKED.zza() && iZzA <= zzdt.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzA) {
                case 0:
                    if (zzM(obj, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 1:
                    if (zzM(obj, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 2:
                    if (zzM(obj, i3)) {
                        long jZzd = zzgz.zzd(obj, j);
                        iZzD3 = zzdi.zzD(i4 << 3);
                        iZzE = zzdi.zzE(jZzd);
                        i2 += iZzD3 + iZzE;
                    }
                    break;
                case 3:
                    if (zzM(obj, i3)) {
                        long jZzd2 = zzgz.zzd(obj, j);
                        iZzD3 = zzdi.zzD(i4 << 3);
                        iZzE = zzdi.zzE(jZzd2);
                        i2 += iZzD3 + iZzE;
                    }
                    break;
                case 4:
                    if (zzM(obj, i3)) {
                        int iZzc = zzgz.zzc(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzx(iZzc);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 5:
                    if (zzM(obj, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 6:
                    if (zzM(obj, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 7:
                    if (zzM(obj, i3)) {
                        iZzD5 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 8:
                    if (zzM(obj, i3)) {
                        Object objZzf = zzgz.zzf(obj, j);
                        if (objZzf instanceof zzdb) {
                            iZzD6 = zzdi.zzD(i4 << 3);
                            iZzd = ((zzdb) objZzf).zzd();
                            iZzD7 = zzdi.zzD(iZzd);
                            i = iZzD6 + iZzD7 + iZzd;
                            i2 += i;
                        } else {
                            iZzD4 = zzdi.zzD(i4 << 3);
                            iZzx = zzdi.zzB((String) objZzf);
                            i = iZzD4 + iZzx;
                            i2 += i;
                        }
                    }
                    break;
                case 9:
                    if (zzM(obj, i3)) {
                        iZzo = zzgd.zzo(i4, zzgz.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case 10:
                    if (zzM(obj, i3)) {
                        zzdb zzdbVar = (zzdb) zzgz.zzf(obj, j);
                        iZzD6 = zzdi.zzD(i4 << 3);
                        iZzd = zzdbVar.zzd();
                        iZzD7 = zzdi.zzD(iZzd);
                        i = iZzD6 + iZzD7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 11:
                    if (zzM(obj, i3)) {
                        int iZzc2 = zzgz.zzc(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzD(iZzc2);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 12:
                    if (zzM(obj, i3)) {
                        int iZzc3 = zzgz.zzc(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzx(iZzc3);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 13:
                    if (zzM(obj, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 14:
                    if (zzM(obj, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 15:
                    if (zzM(obj, i3)) {
                        int iZzc4 = zzgz.zzc(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzD((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 16:
                    if (zzM(obj, i3)) {
                        long jZzd3 = zzgz.zzd(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzE((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 17:
                    if (zzM(obj, i3)) {
                        iZzo = zzdi.zzv(i4, (zzfl) zzgz.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case 18:
                    iZzo = zzgd.zzh(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 19:
                    iZzo = zzgd.zzf(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 20:
                    iZzo = zzgd.zzm(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 21:
                    iZzo = zzgd.zzx(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 22:
                    iZzo = zzgd.zzk(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 23:
                    iZzo = zzgd.zzh(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 24:
                    iZzo = zzgd.zzf(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 25:
                    iZzo = zzgd.zza(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 26:
                    iZzo = zzgd.zzu(i4, (List) zzgz.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 27:
                    iZzo = zzgd.zzp(i4, (List) zzgz.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 28:
                    iZzo = zzgd.zzc(i4, (List) zzgz.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 29:
                    iZzo = zzgd.zzv(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 30:
                    iZzo = zzgd.zzd(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 31:
                    iZzo = zzgd.zzf(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 32:
                    iZzo = zzgd.zzh(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 33:
                    iZzo = zzgd.zzq(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 34:
                    iZzo = zzgd.zzs(i4, (List) zzgz.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 35:
                    iZzx = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 36:
                    iZzx = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 37:
                    iZzx = zzgd.zzn((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 38:
                    iZzx = zzgd.zzy((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 39:
                    iZzx = zzgd.zzl((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 40:
                    iZzx = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 41:
                    iZzx = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 42:
                    iZzx = zzgd.zzb((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 43:
                    iZzx = zzgd.zzw((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 44:
                    iZzx = zzgd.zze((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 45:
                    iZzx = zzgd.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 46:
                    iZzx = zzgd.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 47:
                    iZzx = zzgd.zzr((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 48:
                    iZzx = zzgd.zzt((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zzdi.zzC(i4);
                        iZzD8 = zzdi.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 49:
                    iZzo = zzgd.zzj(i4, (List) zzgz.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 50:
                    zzfg.zza(i4, zzgz.zzf(obj, j), zzF(i3));
                    break;
                case 51:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 52:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 53:
                    if (zzP(obj, i4, i3)) {
                        long jZzC = zzC(obj, j);
                        iZzD3 = zzdi.zzD(i4 << 3);
                        iZzE = zzdi.zzE(jZzC);
                        i2 += iZzD3 + iZzE;
                    }
                    break;
                case 54:
                    if (zzP(obj, i4, i3)) {
                        long jZzC2 = zzC(obj, j);
                        iZzD3 = zzdi.zzD(i4 << 3);
                        iZzE = zzdi.zzE(jZzC2);
                        i2 += iZzD3 + iZzE;
                    }
                    break;
                case 55:
                    if (zzP(obj, i4, i3)) {
                        int iZzr = zzr(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzx(iZzr);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 56:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 57:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 58:
                    if (zzP(obj, i4, i3)) {
                        iZzD5 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 59:
                    if (zzP(obj, i4, i3)) {
                        Object objZzf2 = zzgz.zzf(obj, j);
                        if (objZzf2 instanceof zzdb) {
                            iZzD6 = zzdi.zzD(i4 << 3);
                            iZzd = ((zzdb) objZzf2).zzd();
                            iZzD7 = zzdi.zzD(iZzd);
                            i = iZzD6 + iZzD7 + iZzd;
                            i2 += i;
                        } else {
                            iZzD4 = zzdi.zzD(i4 << 3);
                            iZzx = zzdi.zzB((String) objZzf2);
                            i = iZzD4 + iZzx;
                            i2 += i;
                        }
                    }
                    break;
                case 60:
                    if (zzP(obj, i4, i3)) {
                        iZzo = zzgd.zzo(i4, zzgz.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case 61:
                    if (zzP(obj, i4, i3)) {
                        zzdb zzdbVar2 = (zzdb) zzgz.zzf(obj, j);
                        iZzD6 = zzdi.zzD(i4 << 3);
                        iZzd = zzdbVar2.zzd();
                        iZzD7 = zzdi.zzD(iZzd);
                        i = iZzD6 + iZzD7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 62:
                    if (zzP(obj, i4, i3)) {
                        int iZzr2 = zzr(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzD(iZzr2);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 63:
                    if (zzP(obj, i4, i3)) {
                        int iZzr3 = zzr(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzx(iZzr3);
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 64:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zzdi.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 65:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zzdi.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                    }
                    break;
                case 66:
                    if (zzP(obj, i4, i3)) {
                        int iZzr4 = zzr(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzD((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 67:
                    if (zzP(obj, i4, i3)) {
                        long jZzC3 = zzC(obj, j);
                        iZzD4 = zzdi.zzD(i4 << 3);
                        iZzx = zzdi.zzE((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i = iZzD4 + iZzx;
                        i2 += i;
                    }
                    break;
                case 68:
                    if (zzP(obj, i4, i3)) {
                        iZzo = zzdi.zzv(i4, (zzfl) zzgz.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
            }
        }
        zzgp zzgpVar = this.zzn;
        return i2 + zzgpVar.zza(zzgpVar.zzc(obj));
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzgz.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzco zzcoVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzff) object).zze()) {
            zzff zzffVarZzb = zzff.zza().zzb();
            zzfg.zzb(zzffVarZzb, object);
            unsafe.putObject(obj, j, zzffVarZzb);
        }
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzco zzcoVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzcp.zzo(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzcp.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzcp.zzm(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, Long.valueOf(zzcoVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzcp.zzj(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzcoVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzcp.zzo(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzcp.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzcp.zzm(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzcoVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzcp.zzj(bArr, i, zzcoVar);
                int i9 = zzcoVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & PropertyOptions.DELETE_EXISTING) != 0 && !zzhe.zzi(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzen.zzc();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzel.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzcp.zzd(zzE(i8), bArr, i, i2, zzcoVar);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zzcoVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzel.zzg(object, zzcoVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzd;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzcp.zza(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, zzcoVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzcp.zzj(bArr, i, zzcoVar);
                int i10 = zzcoVar.zza;
                zzeg zzegVarZzD = zzD(i8);
                if (zzegVarZzD == null || zzegVarZzD.zza(i10)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzd(obj).zzh(i3, Long.valueOf(i10));
                }
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzcp.zzj(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzde.zzb(zzcoVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzcp.zzm(bArr, i, zzcoVar);
                unsafe.putObject(obj, j, Long.valueOf(zzde.zzc(zzcoVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iZzc = zzcp.zzc(zzE(i8), bArr, i, i2, (i3 & (-8)) | 4, zzcoVar);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, zzcoVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzel.zzg(object2, zzcoVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzc;
            default:
                return i;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0080. Please report as an issue. */
    private final int zzu(Object obj, byte[] bArr, int i, int i2, zzco zzcoVar) throws IOException {
        int i3;
        int iZzk;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int iZzm;
        int iZzd;
        int i11;
        int i12;
        int i13;
        zzfo<T> zzfoVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i14 = i2;
        zzcoVar = zzcoVar;
        Unsafe unsafe2 = zzb;
        int i15 = 1048575;
        int i16 = -1;
        int iZzi = i;
        int i17 = -1;
        int i18 = 1048575;
        int i19 = 0;
        int i20 = 0;
        while (iZzi < i14) {
            int i21 = iZzi + 1;
            byte b = bArr2[iZzi];
            if (b < 0) {
                iZzk = zzcp.zzk(b, bArr2, i21, zzcoVar);
                i3 = zzcoVar.zza;
            } else {
                i3 = b;
                iZzk = i21;
            }
            int i22 = i3 >>> 3;
            int i23 = i3 & 7;
            int iZzx = i22 > i17 ? zzfoVar.zzx(i22, i19 / 3) : zzfoVar.zzw(i22);
            if (iZzx == i16) {
                i4 = iZzk;
                i5 = i22;
                i6 = i16;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int[] iArr = zzfoVar.zzc;
                int i24 = iArr[iZzx + 1];
                int iZzA = zzA(i24);
                long j = i24 & i15;
                if (iZzA <= 17) {
                    int i25 = iArr[iZzx + 2];
                    int i26 = 1 << (i25 >>> 20);
                    i8 = 1048575;
                    int i27 = i25 & 1048575;
                    if (i27 != i18) {
                        if (i18 != 1048575) {
                            unsafe2.putInt(obj2, i18, i20);
                        }
                        if (i27 != 1048575) {
                            i20 = unsafe2.getInt(obj2, i27);
                        }
                        i18 = i27;
                    }
                    switch (iZzA) {
                        case 0:
                            i9 = iZzx;
                            i10 = iZzk;
                            i5 = i22;
                            if (i23 != 1) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzgz.zzo(obj2, j, Double.longBitsToDouble(zzcp.zzo(bArr2, i10)));
                                iZzi = i10 + 8;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 1:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i10 = iZzk;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 5) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzgz.zzp(obj2, j, Float.intBitsToFloat(zzcp.zzb(bArr2, i10)));
                                iZzi = i10 + 4;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i10 = iZzk;
                            i5 = i22;
                            if (i23 != 0) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzm = zzcp.zzm(bArr2, i10, zzcoVar);
                                unsafe2.putLong(obj, j, zzcoVar.zzb);
                                i20 |= i26;
                                iZzi = iZzm;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 4:
                        case 11:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i10 = iZzk;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = zzcp.zzj(bArr2, i10, zzcoVar);
                                unsafe2.putInt(obj2, j, zzcoVar.zza);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i9 = iZzx;
                            i5 = i22;
                            if (i23 != 1) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                i10 = iZzk;
                                unsafe2.putLong(obj, j, zzcp.zzo(bArr2, iZzk));
                                iZzi = i10 + 8;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 5) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                unsafe2.putInt(obj2, j, zzcp.zzb(bArr2, iZzk));
                                iZzi = iZzk + 4;
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 7:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = zzcp.zzm(bArr2, iZzk, zzcoVar);
                                zzgz.zzm(obj2, j, zzcoVar.zzb != 0);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 8:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzi = (536870912 & i24) == 0 ? zzcp.zzg(bArr2, iZzk, zzcoVar) : zzcp.zzh(bArr2, iZzk, zzcoVar);
                                unsafe2.putObject(obj2, j, zzcoVar.zzc);
                                i20 |= i26;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 9:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzcp.zzd(zzfoVar.zzE(i9), bArr2, iZzk, i14, zzcoVar);
                                Object object = unsafe2.getObject(obj2, j);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j, zzcoVar.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j, zzel.zzg(object, zzcoVar.zzc));
                                }
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 10:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 2) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzcp.zza(bArr2, iZzk, zzcoVar);
                                unsafe2.putObject(obj2, j, zzcoVar.zzc);
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 12:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzcp.zzj(bArr2, iZzk, zzcoVar);
                                unsafe2.putInt(obj2, j, zzcoVar.zza);
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 15:
                            zzcoVar = zzcoVar;
                            i9 = iZzx;
                            i8 = 1048575;
                            i5 = i22;
                            if (i23 != 0) {
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                iZzd = zzcp.zzj(bArr2, iZzk, zzcoVar);
                                unsafe2.putInt(obj2, j, zzde.zzb(zzcoVar.zza));
                                i20 |= i26;
                                iZzi = iZzd;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        case 16:
                            if (i23 != 0) {
                                i5 = i22;
                                i9 = iZzx;
                                i10 = iZzk;
                                i4 = i10;
                                unsafe = unsafe2;
                                i7 = i9;
                                i6 = -1;
                            } else {
                                zzcoVar = zzcoVar;
                                iZzm = zzcp.zzm(bArr2, iZzk, zzcoVar);
                                i9 = iZzx;
                                i5 = i22;
                                unsafe2.putLong(obj, j, zzde.zzc(zzcoVar.zzb));
                                i20 |= i26;
                                iZzi = iZzm;
                                i19 = i9;
                                i17 = i5;
                                i15 = i8;
                                i16 = -1;
                            }
                            break;
                        default:
                            i5 = i22;
                            i9 = iZzx;
                            i10 = iZzk;
                            i4 = i10;
                            unsafe = unsafe2;
                            i7 = i9;
                            i6 = -1;
                            break;
                    }
                } else {
                    zzcoVar = zzcoVar;
                    i9 = iZzx;
                    int i28 = iZzk;
                    i8 = 1048575;
                    i5 = i22;
                    if (iZzA == 27) {
                        if (i23 == 2) {
                            zzek zzekVarZzd = (zzek) unsafe2.getObject(obj2, j);
                            if (!zzekVarZzd.zzc()) {
                                int size = zzekVarZzd.size();
                                zzekVarZzd = zzekVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j, zzekVarZzd);
                            }
                            iZzi = zzcp.zze(zzfoVar.zzE(i9), i3, bArr, i28, i2, zzekVarZzd, zzcoVar);
                            i20 = i20;
                            i19 = i9;
                            i17 = i5;
                            i15 = i8;
                            i16 = -1;
                        } else {
                            i11 = i28;
                            i12 = i20;
                            i13 = i18;
                            unsafe = unsafe2;
                            i7 = i9;
                            i6 = -1;
                        }
                    } else if (iZzA <= 49) {
                        i12 = i20;
                        i13 = i18;
                        i6 = -1;
                        unsafe = unsafe2;
                        i7 = i9;
                        iZzi = zzv(obj, bArr, i28, i2, i3, i5, i23, i9, i24, iZzA, j, zzcoVar);
                        if (iZzi != i28) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i14 = i2;
                            zzcoVar = zzcoVar;
                            i18 = i13;
                            i16 = i6;
                            i17 = i5;
                            i20 = i12;
                            i19 = i7;
                            unsafe2 = unsafe;
                            i15 = 1048575;
                            zzfoVar = this;
                        } else {
                            i4 = iZzi;
                            i18 = i13;
                            i20 = i12;
                        }
                    } else {
                        i11 = i28;
                        i12 = i20;
                        i13 = i18;
                        unsafe = unsafe2;
                        i7 = i9;
                        i6 = -1;
                        if (iZzA != 50) {
                            iZzi = zzt(obj, bArr, i11, i2, i3, i5, i23, i24, iZzA, j, i7, zzcoVar);
                            if (iZzi != i11) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i14 = i2;
                                zzcoVar = zzcoVar;
                                i18 = i13;
                                i16 = i6;
                                i17 = i5;
                                i20 = i12;
                                i19 = i7;
                                unsafe2 = unsafe;
                                i15 = 1048575;
                                zzfoVar = this;
                            } else {
                                i4 = iZzi;
                                i18 = i13;
                                i20 = i12;
                            }
                        } else if (i23 == 2) {
                            iZzi = zzs(obj, bArr, i11, i2, i7, j, zzcoVar);
                            if (iZzi != i11) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i14 = i2;
                                zzcoVar = zzcoVar;
                                i18 = i13;
                                i16 = i6;
                                i17 = i5;
                                i20 = i12;
                                i19 = i7;
                                unsafe2 = unsafe;
                                i15 = 1048575;
                                zzfoVar = this;
                            } else {
                                i4 = iZzi;
                                i18 = i13;
                                i20 = i12;
                            }
                        }
                    }
                    i4 = i11;
                    i18 = i13;
                    i20 = i12;
                }
            }
            iZzi = zzcp.zzi(i3, bArr, i4, i2, zzd(obj), zzcoVar);
            zzfoVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i14 = i2;
            zzcoVar = zzcoVar;
            i16 = i6;
            i17 = i5;
            i19 = i7;
            unsafe2 = unsafe;
            i15 = 1048575;
        }
        int i29 = i20;
        int i30 = i18;
        Unsafe unsafe3 = unsafe2;
        if (i30 != i15) {
            unsafe3.putInt(obj, i30, i29);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzen.zze();
    }

    private final int zzv(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzco zzcoVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzek zzekVarZzd = (zzek) unsafe.getObject(obj, j2);
        if (!zzekVarZzd.zzc()) {
            int size = zzekVarZzd.size();
            zzekVarZzd = zzekVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzekVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzdk zzdkVar = (zzdk) zzekVarZzd;
                    int iZzj3 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i12 = zzcoVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzdkVar.zze(Double.longBitsToDouble(zzcp.zzo(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 1) {
                    zzdk zzdkVar2 = (zzdk) zzekVarZzd;
                    zzdkVar2.zze(Double.longBitsToDouble(zzcp.zzo(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzcp.zzj(bArr, i8, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzdkVar2.zze(Double.longBitsToDouble(zzcp.zzo(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzdu zzduVar = (zzdu) zzekVarZzd;
                    int iZzj4 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i13 = zzcoVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzduVar.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 5) {
                    zzdu zzduVar2 = (zzdu) zzekVarZzd;
                    zzduVar2.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzcp.zzj(bArr, i9, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzduVar2.zzg(Float.intBitsToFloat(zzcp.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzfa zzfaVar = (zzfa) zzekVarZzd;
                    int iZzj5 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i14 = zzcoVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzcp.zzm(bArr, iZzj5, zzcoVar);
                        zzfaVar.zzf(zzcoVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 0) {
                    zzfa zzfaVar2 = (zzfa) zzekVarZzd;
                    int iZzm = zzcp.zzm(bArr, iZzj2, zzcoVar);
                    zzfaVar2.zzf(zzcoVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzcp.zzj(bArr, iZzm, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzcp.zzm(bArr, iZzj6, zzcoVar);
                        zzfaVar2.zzf(zzcoVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzcp.zzf(bArr, iZzj2, zzekVarZzd, zzcoVar);
                }
                if (i5 == 0) {
                    return zzcp.zzl(i3, bArr, i, i2, zzekVarZzd, zzcoVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzfa zzfaVar3 = (zzfa) zzekVarZzd;
                    int iZzj7 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i15 = zzcoVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzfaVar3.zzf(zzcp.zzo(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 1) {
                    zzfa zzfaVar4 = (zzfa) zzekVarZzd;
                    zzfaVar4.zzf(zzcp.zzo(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzcp.zzj(bArr, i10, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzfaVar4.zzf(zzcp.zzo(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzed zzedVar = (zzed) zzekVarZzd;
                    int iZzj8 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i16 = zzcoVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzedVar.zzg(zzcp.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 5) {
                    zzed zzedVar2 = (zzed) zzekVarZzd;
                    zzedVar2.zzg(zzcp.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzcp.zzj(bArr, i11, zzcoVar);
                            if (i3 == zzcoVar.zza) {
                                zzedVar2.zzg(zzcp.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzcq zzcqVar = (zzcq) zzekVarZzd;
                    iZzj = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i17 = zzcoVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzcp.zzm(bArr, iZzj, zzcoVar);
                        zzcqVar.zze(zzcoVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzen.zzg();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzcq zzcqVar2 = (zzcq) zzekVarZzd;
                    int iZzm2 = zzcp.zzm(bArr, iZzj2, zzcoVar);
                    zzcqVar2.zze(zzcoVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzcp.zzj(bArr, iZzm2, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzcp.zzm(bArr, iZzj9, zzcoVar);
                        zzcqVar2.zze(zzcoVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                        int i18 = zzcoVar.zza;
                        if (i18 < 0) {
                            throw zzen.zzd();
                        }
                        if (i18 == 0) {
                            zzekVarZzd.add("");
                        } else {
                            zzekVarZzd.add(new String(bArr, iZzj10, i18, zzel.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzcp.zzj(bArr, iZzj10, zzcoVar);
                            if (i3 != zzcoVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzcp.zzj(bArr, iZzj11, zzcoVar);
                            int i19 = zzcoVar.zza;
                            if (i19 < 0) {
                                throw zzen.zzd();
                            }
                            if (i19 == 0) {
                                zzekVarZzd.add("");
                            } else {
                                zzekVarZzd.add(new String(bArr, iZzj10, i19, zzel.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i20 = zzcoVar.zza;
                    if (i20 < 0) {
                        throw zzen.zzd();
                    }
                    if (i20 == 0) {
                        zzekVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzhe.zzi(bArr, iZzj12, i21)) {
                            throw zzen.zzc();
                        }
                        zzekVarZzd.add(new String(bArr, iZzj12, i20, zzel.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzcp.zzj(bArr, iZzj12, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzcp.zzj(bArr, iZzj13, zzcoVar);
                        int i22 = zzcoVar.zza;
                        if (i22 < 0) {
                            throw zzen.zzd();
                        }
                        if (i22 == 0) {
                            zzekVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzhe.zzi(bArr, iZzj12, i23)) {
                                throw zzen.zzc();
                            }
                            zzekVarZzd.add(new String(bArr, iZzj12, i22, zzel.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 27:
                if (i5 == 2) {
                    return zzcp.zze(zzE(i6), i3, bArr, i, i2, zzekVarZzd, zzcoVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i24 = zzcoVar.zza;
                    if (i24 < 0) {
                        throw zzen.zzd();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzen.zzg();
                    }
                    if (i24 == 0) {
                        zzekVarZzd.add(zzdb.zzb);
                    } else {
                        zzekVarZzd.add(zzdb.zzr(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzcp.zzj(bArr, iZzj14, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzcp.zzj(bArr, iZzj15, zzcoVar);
                        int i25 = zzcoVar.zza;
                        if (i25 < 0) {
                            throw zzen.zzd();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzen.zzg();
                        }
                        if (i25 == 0) {
                            zzekVarZzd.add(zzdb.zzb);
                        } else {
                            zzekVarZzd.add(zzdb.zzr(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzcp.zzl(i3, bArr, i, i2, zzekVarZzd, zzcoVar);
                    }
                    return iZzj2;
                }
                iZzj = zzcp.zzf(bArr, iZzj2, zzekVarZzd, zzcoVar);
                zzec zzecVar = (zzec) obj;
                zzgq zzgqVar = zzecVar.zzc;
                if (zzgqVar == zzgq.zzc()) {
                    zzgqVar = null;
                }
                Object objZzC = zzgd.zzC(i4, zzekVarZzd, zzD(i6), zzgqVar, this.zzn);
                if (objZzC != null) {
                    zzecVar.zzc = (zzgq) objZzC;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzed zzedVar3 = (zzed) zzekVarZzd;
                    int iZzj16 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i26 = zzcoVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzcp.zzj(bArr, iZzj16, zzcoVar);
                        zzedVar3.zzg(zzde.zzb(zzcoVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 0) {
                    zzed zzedVar4 = (zzed) zzekVarZzd;
                    int iZzj17 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    zzedVar4.zzg(zzde.zzb(zzcoVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzcp.zzj(bArr, iZzj17, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzcp.zzj(bArr, iZzj18, zzcoVar);
                        zzedVar4.zzg(zzde.zzb(zzcoVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzfa zzfaVar5 = (zzfa) zzekVarZzd;
                    int iZzj19 = zzcp.zzj(bArr, iZzj2, zzcoVar);
                    int i27 = zzcoVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzcp.zzm(bArr, iZzj19, zzcoVar);
                        zzfaVar5.zzf(zzde.zzc(zzcoVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzen.zzg();
                }
                if (i5 == 0) {
                    zzfa zzfaVar6 = (zzfa) zzekVarZzd;
                    int iZzm3 = zzcp.zzm(bArr, iZzj2, zzcoVar);
                    zzfaVar6.zzf(zzde.zzc(zzcoVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzcp.zzj(bArr, iZzm3, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzcp.zzm(bArr, iZzj20, zzcoVar);
                        zzfaVar6.zzf(zzde.zzc(zzcoVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzgb zzgbVarZzE = zzE(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzcp.zzc(zzgbVarZzE, bArr, i, i2, i28, zzcoVar);
                    zzekVarZzd.add(zzcoVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzcp.zzj(bArr, iZzc, zzcoVar);
                        if (i3 != zzcoVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzcp.zzc(zzgbVarZzE, bArr, iZzj21, i2, i28, zzcoVar);
                        zzekVarZzd.add(zzcoVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final int zzb(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzB = zzB(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzB;
            int iHashCode = 37;
            switch (zzA(iZzB)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzel.zzc(Double.doubleToLongBits(zzgz.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzgz.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzel.zzc(zzgz.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzel.zzc(zzgz.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzel.zzc(zzgz.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzel.zza(zzgz.zzw(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzgz.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzgz.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzel.zzc(zzgz.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzgz.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzel.zzc(zzgz.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzgz.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZzc = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzgz.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(Double.doubleToLongBits(zzn(obj, j)));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(zzo(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zza(zzQ(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 59:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzgz.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 60:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 61:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzel.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzgz.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzc(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzo.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:182:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:185:0x05db  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzco zzcoVar) throws IOException {
        Unsafe unsafe;
        int i4;
        Object obj2;
        zzfo<T> zzfoVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int iZzm;
        int i9;
        int i10;
        int i11;
        boolean z;
        zzco zzcoVar2;
        Object objZzg;
        Object objValueOf;
        int iOrdinal;
        Object objZze;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        zzfo<T> zzfoVar2 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i23 = i2;
        i3 = i3;
        zzco zzcoVar3 = zzcoVar;
        Unsafe unsafe2 = zzb;
        int iZzi = i;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 1048575;
        while (true) {
            Object objValueOf2 = null;
            if (iZzi < i23) {
                int i29 = iZzi + 1;
                byte b = bArr2[iZzi];
                if (b < 0) {
                    int iZzk = zzcp.zzk(b, bArr2, i29, zzcoVar3);
                    i7 = zzcoVar3.zza;
                    i29 = iZzk;
                } else {
                    i7 = b;
                }
                int i30 = i7 >>> 3;
                int i31 = i7 & 7;
                int iZzx = i30 > i27 ? zzfoVar2.zzx(i30, i25 / 3) : zzfoVar2.zzw(i30);
                if (iZzx == -1) {
                    i8 = i30;
                    iZzm = i29;
                    i9 = i7;
                    i10 = i26;
                    unsafe = unsafe2;
                    i3 = i3;
                    i11 = 0;
                    z = true;
                } else {
                    int[] iArr = zzfoVar2.zzc;
                    int i32 = iArr[iZzx + 1];
                    int iZzA = zzA(i32);
                    long j = i32 & 1048575;
                    int i33 = i7;
                    if (iZzA <= 17) {
                        int i34 = iArr[iZzx + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i28) {
                            if (i28 != 1048575) {
                                obj3 = obj;
                                unsafe2.putInt(obj3, i28, i26);
                            } else {
                                obj3 = obj;
                            }
                            i26 = unsafe2.getInt(obj3, i36);
                            i12 = i36;
                        } else {
                            j = j;
                            obj3 = obj;
                            i12 = i28;
                        }
                        int i37 = i26;
                        switch (iZzA) {
                            case 0:
                                i13 = i29;
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j2 = j;
                                z2 = true;
                                if (i31 == 1) {
                                    zzgz.zzo(obj3, j2, Double.longBitsToDouble(zzcp.zzo(bArr2, i13)));
                                    iZzi = i13 + 8;
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i27 = i16;
                                    i25 = i14;
                                    i24 = i17;
                                    i23 = i2;
                                } else {
                                    i18 = i16;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 1:
                                i13 = i29;
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j3 = j;
                                if (i31 == 5) {
                                    zzgz.zzp(obj3, j3, Float.intBitsToFloat(zzcp.zzb(bArr2, i13)));
                                    iZzi = i13 + 4;
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i27 = i16;
                                    i25 = i14;
                                    i24 = i17;
                                    i23 = i2;
                                } else {
                                    i18 = i16;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 2:
                            case 3:
                                i13 = i29;
                                i14 = iZzx;
                                i15 = i12;
                                i27 = i30;
                                i17 = i33;
                                long j4 = j;
                                if (i31 == 0) {
                                    int iZzm2 = zzcp.zzm(bArr2, i13, zzcoVar3);
                                    i19 = i27;
                                    unsafe2.putLong(obj, j4, zzcoVar3.zzb);
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i25 = i14;
                                    iZzi = iZzm2;
                                    i27 = i19;
                                    i24 = i17;
                                    i23 = i2;
                                    i3 = i3;
                                } else {
                                    i18 = i27;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 4:
                            case 11:
                                i13 = i29;
                                i14 = iZzx;
                                i15 = i12;
                                i27 = i30;
                                i17 = i33;
                                long j5 = j;
                                if (i31 == 0) {
                                    iZzi = zzcp.zzj(bArr2, i13, zzcoVar3);
                                    unsafe2.putInt(obj3, j5, zzcoVar3.zza);
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i25 = i14;
                                    i24 = i17;
                                    i23 = i2;
                                } else {
                                    i18 = i27;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 5:
                            case 14:
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j6 = j;
                                if (i31 == 1) {
                                    unsafe2.putLong(obj, j6, zzcp.zzo(bArr2, i29));
                                    iZzi = i29 + 8;
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i3 = i3;
                                    i25 = i14;
                                    i27 = i16;
                                    i24 = i17;
                                    i23 = i2;
                                } else {
                                    i13 = i29;
                                    z2 = true;
                                    i18 = i16;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 6:
                            case 13:
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j7 = j;
                                if (i31 == 5) {
                                    unsafe2.putInt(obj3, j7, zzcp.zzb(bArr2, i29));
                                    iZzi = i29 + 4;
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i24 = i17;
                                    i23 = i2;
                                    i27 = i16;
                                    i25 = i14;
                                } else {
                                    i13 = i29;
                                    i18 = i16;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 7:
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j8 = j;
                                i2 = i2;
                                if (i31 == 0) {
                                    int iZzm3 = zzcp.zzm(bArr2, i29, zzcoVar3);
                                    zzgz.zzm(obj3, j8, zzcoVar3.zzb != 0);
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    iZzi = iZzm3;
                                    i24 = i17;
                                    i23 = i2;
                                    i27 = i16;
                                    i25 = i14;
                                } else {
                                    i13 = i29;
                                    i18 = i16;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 8:
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j9 = j;
                                if (i31 == 2) {
                                    iZzi = (536870912 & i32) == 0 ? zzcp.zzg(bArr2, i29, zzcoVar3) : zzcp.zzh(bArr2, i29, zzcoVar3);
                                    unsafe2.putObject(obj3, j9, zzcoVar3.zzc);
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i24 = i17;
                                    i23 = i2;
                                    i27 = i16;
                                    i25 = i14;
                                } else {
                                    i13 = i29;
                                    i18 = i16;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 9:
                                i14 = iZzx;
                                i15 = i12;
                                i19 = i30;
                                i17 = i33;
                                long j10 = j;
                                if (i31 == 2) {
                                    iZzi = zzcp.zzd(zzfoVar2.zzE(i14), bArr2, i29, i2, zzcoVar3);
                                    if ((i37 & i35) == 0) {
                                        unsafe2.putObject(obj3, j10, zzcoVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj3, j10, zzel.zzg(unsafe2.getObject(obj3, j10), zzcoVar3.zzc));
                                    }
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i25 = i14;
                                    i24 = i17;
                                    i23 = i2;
                                    i27 = i19;
                                    i3 = i3;
                                } else {
                                    i18 = i19;
                                    z2 = true;
                                    i13 = i29;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 10:
                                i14 = iZzx;
                                i15 = i12;
                                i19 = i30;
                                i17 = i33;
                                long j11 = j;
                                if (i31 == 2) {
                                    iZzi = zzcp.zza(bArr2, i29, zzcoVar3);
                                    unsafe2.putObject(obj3, j11, zzcoVar3.zzc);
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i25 = i14;
                                    i27 = i19;
                                    i24 = i17;
                                    i23 = i2;
                                    i3 = i3;
                                } else {
                                    i18 = i19;
                                    z2 = true;
                                    i13 = i29;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 12:
                                i14 = iZzx;
                                i15 = i12;
                                i19 = i30;
                                i17 = i33;
                                long j12 = j;
                                if (i31 == 0) {
                                    iZzi = zzcp.zzj(bArr2, i29, zzcoVar3);
                                    int i38 = zzcoVar3.zza;
                                    zzeg zzegVarZzD = zzfoVar2.zzD(i14);
                                    if (zzegVarZzD == null || zzegVarZzD.zza(i38)) {
                                        unsafe2.putInt(obj3, j12, i38);
                                        i26 = i37 | i35;
                                        i28 = i15;
                                        i25 = i14;
                                        i27 = i19;
                                        i24 = i17;
                                    } else {
                                        zzd(obj).zzh(i17, Long.valueOf(i38));
                                        i26 = i37;
                                        i25 = i14;
                                        i27 = i19;
                                        i24 = i17;
                                        i28 = i15;
                                    }
                                    i23 = i2;
                                    i3 = i3;
                                } else {
                                    i18 = i19;
                                    z2 = true;
                                    i13 = i29;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 15:
                                i14 = iZzx;
                                i15 = i12;
                                i19 = i30;
                                i17 = i33;
                                if (i31 == 0) {
                                    iZzi = zzcp.zzj(bArr2, i29, zzcoVar3);
                                    unsafe2.putInt(obj3, j, zzde.zzb(zzcoVar3.zza));
                                    i26 = i37 | i35;
                                    i28 = i15;
                                    i25 = i14;
                                    i27 = i19;
                                    i24 = i17;
                                    i23 = i2;
                                    i3 = i3;
                                } else {
                                    i18 = i19;
                                    z2 = true;
                                    i13 = i29;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            case 16:
                                if (i31 == 0) {
                                    int iZzm4 = zzcp.zzm(bArr2, i29, zzcoVar3);
                                    i19 = i30;
                                    int i39 = i12;
                                    i17 = i33;
                                    unsafe2.putLong(obj, j, zzde.zzc(zzcoVar3.zzb));
                                    i26 = i37 | i35;
                                    i28 = i39;
                                    iZzi = iZzm4;
                                    i25 = iZzx;
                                    i27 = i19;
                                    i24 = i17;
                                    i23 = i2;
                                    i3 = i3;
                                } else {
                                    i15 = i12;
                                    i17 = i33;
                                    i13 = i29;
                                    i14 = iZzx;
                                    i18 = i30;
                                    z2 = true;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                            default:
                                i13 = i29;
                                i14 = iZzx;
                                i15 = i12;
                                i16 = i30;
                                i17 = i33;
                                long j13 = j;
                                z2 = true;
                                if (i31 == 3) {
                                    iZzi = zzcp.zzc(zzfoVar2.zzE(i14), bArr, i13, i2, (i16 << 3) | 4, zzcoVar);
                                    if ((i37 & i35) == 0) {
                                        unsafe2.putObject(obj3, j13, zzcoVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj3, j13, zzel.zzg(unsafe2.getObject(obj3, j13), zzcoVar3.zzc));
                                    }
                                    i26 = i37 | i35;
                                    bArr2 = bArr;
                                    i28 = i15;
                                    i3 = i3;
                                    i25 = i14;
                                    i24 = i17;
                                    i27 = i16;
                                    i23 = i2;
                                } else {
                                    i18 = i16;
                                    z = z2;
                                    i10 = i37;
                                    i11 = i14;
                                    unsafe = unsafe2;
                                    iZzm = i13;
                                    i9 = i17;
                                    i28 = i15;
                                    i3 = i3;
                                    i8 = i18;
                                }
                                break;
                        }
                    } else {
                        int i40 = i29;
                        int i41 = iZzx;
                        obj3 = obj;
                        if (iZzA != 27) {
                            i11 = i41;
                            i10 = i26;
                            i20 = i28;
                            if (iZzA <= 49) {
                                i8 = i30;
                                z = true;
                                unsafe = unsafe2;
                                i22 = i33;
                                iZzi = zzv(obj, bArr, i40, i2, i33, i8, i31, i11, i32, iZzA, j, zzcoVar);
                                if (iZzi != i40) {
                                    zzfoVar2 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i27 = i8;
                                    i23 = i2;
                                    i3 = i3;
                                    zzcoVar3 = zzcoVar;
                                    i24 = i22;
                                    i25 = i11;
                                    i26 = i10;
                                    i28 = i20;
                                    unsafe2 = unsafe;
                                } else {
                                    iZzm = iZzi;
                                    i9 = i22;
                                    i28 = i20;
                                }
                            } else {
                                i8 = i30;
                                i21 = i40;
                                unsafe = unsafe2;
                                i22 = i33;
                                z = true;
                                if (iZzA != 50) {
                                    iZzi = zzt(obj, bArr, i21, i2, i22, i8, i31, i32, iZzA, j, i11, zzcoVar);
                                    if (iZzi != i21) {
                                        zzfoVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i27 = i8;
                                        i23 = i2;
                                        i3 = i3;
                                        zzcoVar3 = zzcoVar;
                                        i24 = i22;
                                        i25 = i11;
                                        i26 = i10;
                                        i28 = i20;
                                        unsafe2 = unsafe;
                                    } else {
                                        iZzm = iZzi;
                                        i9 = i22;
                                        i28 = i20;
                                    }
                                } else if (i31 == 2) {
                                    iZzi = zzs(obj, bArr, i21, i2, i11, j, zzcoVar);
                                    if (iZzi != i21) {
                                        zzfoVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i27 = i8;
                                        i23 = i2;
                                        i3 = i3;
                                        zzcoVar3 = zzcoVar;
                                        i24 = i22;
                                        i25 = i11;
                                        i26 = i10;
                                        i28 = i20;
                                        unsafe2 = unsafe;
                                    } else {
                                        iZzm = iZzi;
                                        i9 = i22;
                                        i28 = i20;
                                    }
                                }
                            }
                        } else if (i31 == 2) {
                            zzek zzekVarZzd = (zzek) unsafe2.getObject(obj3, j);
                            if (!zzekVarZzd.zzc()) {
                                int size = zzekVarZzd.size();
                                zzekVarZzd = zzekVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, zzekVarZzd);
                            }
                            zzek zzekVar = zzekVarZzd;
                            i24 = i33;
                            iZzi = zzcp.zze(zzfoVar2.zzE(i41), i24, bArr, i40, i2, zzekVar, zzcoVar);
                            bArr2 = bArr;
                            i27 = i30;
                            i25 = i41;
                            i26 = i26;
                            i28 = i28;
                            i23 = i2;
                            i3 = i3;
                        } else {
                            i11 = i41;
                            i10 = i26;
                            i20 = i28;
                            i21 = i40;
                            i8 = i30;
                            unsafe = unsafe2;
                            i22 = i33;
                            z = true;
                        }
                        iZzm = i21;
                        i9 = i22;
                        i28 = i20;
                    }
                }
                if (i9 != i3 || i3 == 0) {
                    if (this.zzh) {
                        zzcoVar2 = zzcoVar;
                        if (zzcoVar2.zzd != zzdn.zza()) {
                            i8 = i8;
                            zzea zzeaVarZzb = zzcoVar2.zzd.zzb(this.zzg, i8);
                            if (zzeaVarZzb != null) {
                                obj = obj;
                                zzdy zzdyVar = (zzdy) obj;
                                zzdyVar.zzc();
                                zzds zzdsVar = zzdyVar.zza;
                                if (zzeaVarZzb.zzd.zzb == zzhf.ENUM) {
                                    zzcp.zzj(bArr, iZzm, zzcoVar2);
                                    throw null;
                                }
                                switch (zzeaVarZzb.zzd.zzb) {
                                    case DOUBLE:
                                        bArr = bArr;
                                        objValueOf2 = Double.valueOf(Double.longBitsToDouble(zzcp.zzo(bArr, iZzm)));
                                        iZzm += 8;
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar = zzeaVarZzb.zzd;
                                        boolean z3 = zzdzVar.zzc;
                                        iOrdinal = zzdzVar.zzb.ordinal();
                                        if ((iOrdinal != 9 || iOrdinal == 10) && (objZze = zzdsVar.zze(zzeaVarZzb.zzd)) != null) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case FLOAT:
                                        bArr = bArr;
                                        objValueOf2 = Float.valueOf(Float.intBitsToFloat(zzcp.zzb(bArr, iZzm)));
                                        iZzm += 4;
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar2 = zzeaVarZzb.zzd;
                                        boolean z4 = zzdzVar2.zzc;
                                        iOrdinal = zzdzVar2.zzb.ordinal();
                                        objZzg = iOrdinal != 9 ? zzel.zzg(objZze, objZzg) : zzel.zzg(objZze, objZzg);
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case INT64:
                                    case UINT64:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        iZzm = zzcp.zzm(bArr, iZzm, zzcoVar2);
                                        objValueOf2 = Long.valueOf(zzcoVar2.zzb);
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar3 = zzeaVarZzb.zzd;
                                        boolean z5 = zzdzVar3.zzc;
                                        iOrdinal = zzdzVar3.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case INT32:
                                    case UINT32:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        iZzm = zzcp.zzj(bArr, iZzm, zzcoVar2);
                                        objValueOf2 = Integer.valueOf(zzcoVar2.zza);
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar4 = zzeaVarZzb.zzd;
                                        boolean z6 = zzdzVar4.zzc;
                                        iOrdinal = zzdzVar4.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case FIXED64:
                                    case SFIXED64:
                                        bArr = bArr;
                                        objValueOf2 = Long.valueOf(zzcp.zzo(bArr, iZzm));
                                        iZzm += 8;
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar5 = zzeaVarZzb.zzd;
                                        boolean z7 = zzdzVar5.zzc;
                                        iOrdinal = zzdzVar5.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case FIXED32:
                                    case SFIXED32:
                                        bArr = bArr;
                                        objValueOf2 = Integer.valueOf(zzcp.zzb(bArr, iZzm));
                                        iZzm += 4;
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar6 = zzeaVarZzb.zzd;
                                        boolean z8 = zzdzVar6.zzc;
                                        iOrdinal = zzdzVar6.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case BOOL:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        iZzm = zzcp.zzm(bArr, iZzm, zzcoVar2);
                                        if (zzcoVar2.zzb == 0) {
                                            z = false;
                                        }
                                        objValueOf2 = Boolean.valueOf(z);
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar7 = zzeaVarZzb.zzd;
                                        boolean z9 = zzdzVar7.zzc;
                                        iOrdinal = zzdzVar7.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case STRING:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        iZzm = zzcp.zzg(bArr, iZzm, zzcoVar2);
                                        objZzg = zzcoVar2.zzc;
                                        zzdz zzdzVar8 = zzeaVarZzb.zzd;
                                        boolean z10 = zzdzVar8.zzc;
                                        iOrdinal = zzdzVar8.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case GROUP:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        iZzm = zzcp.zzc(zzfu.zza().zzb(zzeaVarZzb.zzc.getClass()), bArr, iZzm, i2, (i8 << 3) | 4, zzcoVar);
                                        objZzg = zzcoVar2.zzc;
                                        zzdz zzdzVar9 = zzeaVarZzb.zzd;
                                        boolean z11 = zzdzVar9.zzc;
                                        iOrdinal = zzdzVar9.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case MESSAGE:
                                        bArr = bArr;
                                        iZzm = zzcp.zzd(zzfu.zza().zzb(zzeaVarZzb.zzc.getClass()), bArr, iZzm, i2, zzcoVar2);
                                        objZzg = zzcoVar2.zzc;
                                        i28 = i28;
                                        i2 = i2;
                                        zzdz zzdzVar10 = zzeaVarZzb.zzd;
                                        boolean z12 = zzdzVar10.zzc;
                                        iOrdinal = zzdzVar10.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case BYTES:
                                        bArr = bArr;
                                        iZzm = zzcp.zza(bArr, iZzm, zzcoVar2);
                                        objZzg = zzcoVar2.zzc;
                                        i2 = i2;
                                        zzdz zzdzVar11 = zzeaVarZzb.zzd;
                                        boolean z13 = zzdzVar11.zzc;
                                        iOrdinal = zzdzVar11.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case ENUM:
                                        throw new IllegalStateException("Shouldn't reach here.");
                                    case SINT32:
                                        bArr = bArr;
                                        iZzm = zzcp.zzj(bArr, iZzm, zzcoVar2);
                                        objValueOf = Integer.valueOf(zzde.zzb(zzcoVar2.zza));
                                        objZzg = objValueOf;
                                        i2 = i2;
                                        zzdz zzdzVar12 = zzeaVarZzb.zzd;
                                        boolean z14 = zzdzVar12.zzc;
                                        iOrdinal = zzdzVar12.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    case SINT64:
                                        bArr = bArr;
                                        iZzm = zzcp.zzm(bArr, iZzm, zzcoVar2);
                                        objValueOf = Long.valueOf(zzde.zzc(zzcoVar2.zzb));
                                        objZzg = objValueOf;
                                        i2 = i2;
                                        zzdz zzdzVar13 = zzeaVarZzb.zzd;
                                        boolean z15 = zzdzVar13.zzc;
                                        iOrdinal = zzdzVar13.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                    default:
                                        bArr = bArr;
                                        i28 = i28;
                                        i2 = i2;
                                        objZzg = objValueOf2;
                                        zzdz zzdzVar14 = zzeaVarZzb.zzd;
                                        boolean z16 = zzdzVar14.zzc;
                                        iOrdinal = zzdzVar14.zzb.ordinal();
                                        if (iOrdinal != 9) {
                                        }
                                        zzdsVar.zzi(zzeaVarZzb.zzd, objZzg);
                                        iZzi = iZzm;
                                        break;
                                }
                            } else {
                                iZzi = zzcp.zzi(i9, bArr, iZzm, i2, zzd(obj), zzcoVar);
                                obj = obj;
                                bArr = bArr;
                                i28 = i28;
                                i2 = i2;
                            }
                        }
                        i24 = i9;
                        i27 = i8;
                        obj3 = obj;
                        bArr2 = bArr;
                        i25 = i11;
                        i26 = i10;
                        i23 = i2;
                        i3 = i3;
                        zzfoVar2 = this;
                        zzcoVar3 = zzcoVar2;
                        unsafe2 = unsafe;
                        i28 = i28;
                    } else {
                        zzcoVar2 = zzcoVar;
                    }
                    i28 = i28;
                    i2 = i2;
                    iZzi = zzcp.zzi(i9, bArr, iZzm, i2, zzd(obj), zzcoVar);
                    i24 = i9;
                    i27 = i8;
                    obj3 = obj;
                    bArr2 = bArr;
                    i25 = i11;
                    i26 = i10;
                    i23 = i2;
                    i3 = i3;
                    zzfoVar2 = this;
                    zzcoVar3 = zzcoVar2;
                    unsafe2 = unsafe;
                    i28 = i28;
                } else {
                    zzfoVar = this;
                    obj2 = obj;
                    iZzi = iZzm;
                    i5 = i28;
                    i24 = i9;
                    i26 = i10;
                    i6 = 1048575;
                    i4 = i2;
                }
            } else {
                int i42 = i28;
                unsafe = unsafe2;
                i3 = i3;
                i4 = i23;
                obj2 = obj3;
                zzfoVar = zzfoVar2;
                i5 = i42;
                i6 = 1048575;
            }
        }
        if (i5 != i6) {
            unsafe.putInt(obj2, i5, i26);
        }
        for (int i43 = zzfoVar.zzk; i43 < zzfoVar.zzl; i43++) {
            int i44 = zzfoVar.zzj[i43];
            int i45 = zzfoVar.zzc[i44];
            Object objZzf = zzgz.zzf(obj2, zzfoVar.zzB(i44) & i6);
            if (objZzf != null && zzfoVar.zzD(i44) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iZzi != i4) {
                throw zzen.zze();
            }
        } else if (iZzi > i4 || i24 != i3) {
            throw zzen.zze();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final Object zze() {
        return ((zzec) this.zzg).zzg(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long jZzB = zzB(this.zzj[i2]) & 1048575;
            Object objZzf = zzgz.zzf(obj, jZzB);
            if (objZzf != null) {
                ((zzff) objZzf).zzc();
                zzgz.zzs(obj, jZzB, objZzf);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzco zzcoVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzcoVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zzcoVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final boolean zzi(Object obj, Object obj2) {
        boolean zZzH;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            long j = iZzB & 1048575;
            switch (zzA(iZzB)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzgz.zza(obj, j)) != Double.doubleToLongBits(zzgz.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzgz.zzb(obj, j)) != Float.floatToIntBits(zzgz.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzgz.zzw(obj, j) != zzgz.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzH = zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 50:
                    zZzH = zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzy = zzy(i) & 1048575;
                    if (zzgz.zzc(obj, jZzy) != zzgz.zzc(obj2, jZzy) || !zzgd.zzH(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final boolean zzj(Object obj) {
        int i;
        int i2;
        List list;
        zzgb zzgbVarZzE;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int i7 = this.zzj[i6];
            int i8 = this.zzc[i7];
            int iZzB = zzB(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzB) != 0 && !zzN(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzA = zzA(iZzB);
            if (iZzA == 9 || iZzA == 17) {
                if (zzN(obj, i7, i, i2, i11) && !zzO(obj, iZzB, zzE(i7))) {
                    return false;
                }
            } else if (iZzA == 27) {
                list = (List) zzgz.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgbVarZzE = zzE(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgbVarZzE.zzj(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzA == 60 || iZzA == 68) {
                if (zzP(obj, i8, i7) && !zzO(obj, iZzB, zzE(i7))) {
                    return false;
                }
            } else if (iZzA == 49) {
                list = (List) zzgz.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    zzgbVarZzE = zzE(i7);
                    while (i3 < list.size()) {
                        if (!zzgbVarZzE.zzj(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzA == 50 && !((zzff) zzgz.zzf(obj, iZzB & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzo.zzb(obj).zzk();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzm(Object obj, zzdj zzdjVar) throws IOException {
        Iterator itZzf;
        Map.Entry entry;
        if (!this.zzi) {
            zzR(obj, zzdjVar);
            return;
        }
        if (this.zzh) {
            zzds zzdsVarZzb = this.zzo.zzb(obj);
            if (zzdsVarZzb.zza.isEmpty()) {
                itZzf = null;
                entry = null;
            } else {
                itZzf = zzdsVarZzb.zzf();
                entry = (Map.Entry) itZzf.next();
            }
        } else {
            itZzf = null;
            entry = null;
        }
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            int i2 = this.zzc[i];
            while (entry != null && this.zzo.zza(entry) <= i2) {
                this.zzo.zzg(zzdjVar, entry);
                entry = itZzf.hasNext() ? (Map.Entry) itZzf.next() : null;
            }
            switch (zzA(iZzB)) {
                case 0:
                    if (zzM(obj, i)) {
                        zzdjVar.zzf(i2, zzgz.zza(obj, iZzB & 1048575));
                    }
                    break;
                case 1:
                    if (zzM(obj, i)) {
                        zzdjVar.zzo(i2, zzgz.zzb(obj, iZzB & 1048575));
                    }
                    break;
                case 2:
                    if (zzM(obj, i)) {
                        zzdjVar.zzt(i2, zzgz.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 3:
                    if (zzM(obj, i)) {
                        zzdjVar.zzK(i2, zzgz.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 4:
                    if (zzM(obj, i)) {
                        zzdjVar.zzr(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 5:
                    if (zzM(obj, i)) {
                        zzdjVar.zzm(i2, zzgz.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 6:
                    if (zzM(obj, i)) {
                        zzdjVar.zzk(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 7:
                    if (zzM(obj, i)) {
                        zzdjVar.zzb(i2, zzgz.zzw(obj, iZzB & 1048575));
                    }
                    break;
                case 8:
                    if (zzM(obj, i)) {
                        zzT(i2, zzgz.zzf(obj, iZzB & 1048575), zzdjVar);
                    }
                    break;
                case 9:
                    if (zzM(obj, i)) {
                        zzdjVar.zzv(i2, zzgz.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case 10:
                    if (zzM(obj, i)) {
                        zzdjVar.zzd(i2, (zzdb) zzgz.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 11:
                    if (zzM(obj, i)) {
                        zzdjVar.zzI(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 12:
                    if (zzM(obj, i)) {
                        zzdjVar.zzi(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 13:
                    if (zzM(obj, i)) {
                        zzdjVar.zzx(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 14:
                    if (zzM(obj, i)) {
                        zzdjVar.zzz(i2, zzgz.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 15:
                    if (zzM(obj, i)) {
                        zzdjVar.zzB(i2, zzgz.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 16:
                    if (zzM(obj, i)) {
                        zzdjVar.zzD(i2, zzgz.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 17:
                    if (zzM(obj, i)) {
                        zzdjVar.zzq(i2, zzgz.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case 18:
                    zzgd.zzL(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 19:
                    zzgd.zzP(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 20:
                    zzgd.zzS(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 21:
                    zzgd.zzaa(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 22:
                    zzgd.zzR(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 23:
                    zzgd.zzO(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 24:
                    zzgd.zzN(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 25:
                    zzgd.zzJ(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 26:
                    zzgd.zzY(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar);
                    break;
                case 27:
                    zzgd.zzT(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, zzE(i));
                    break;
                case 28:
                    zzgd.zzK(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar);
                    break;
                case 29:
                    zzgd.zzZ(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 30:
                    zzgd.zzM(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 31:
                    zzgd.zzU(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 32:
                    zzgd.zzV(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 33:
                    zzgd.zzW(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 34:
                    zzgd.zzX(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, false);
                    break;
                case 35:
                    zzgd.zzL(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 36:
                    zzgd.zzP(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 37:
                    zzgd.zzS(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 38:
                    zzgd.zzaa(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 39:
                    zzgd.zzR(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 40:
                    zzgd.zzO(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 41:
                    zzgd.zzN(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 42:
                    zzgd.zzJ(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 43:
                    zzgd.zzZ(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 44:
                    zzgd.zzM(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 45:
                    zzgd.zzU(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 46:
                    zzgd.zzV(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 47:
                    zzgd.zzW(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 48:
                    zzgd.zzX(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, true);
                    break;
                case 49:
                    zzgd.zzQ(this.zzc[i], (List) zzgz.zzf(obj, iZzB & 1048575), zzdjVar, zzE(i));
                    break;
                case 50:
                    zzS(zzdjVar, i2, zzgz.zzf(obj, iZzB & 1048575), i);
                    break;
                case 51:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzf(i2, zzn(obj, iZzB & 1048575));
                    }
                    break;
                case 52:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzo(i2, zzo(obj, iZzB & 1048575));
                    }
                    break;
                case 53:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzt(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 54:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzK(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 55:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzr(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 56:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzm(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 57:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzk(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 58:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzb(i2, zzQ(obj, iZzB & 1048575));
                    }
                    break;
                case 59:
                    if (zzP(obj, i2, i)) {
                        zzT(i2, zzgz.zzf(obj, iZzB & 1048575), zzdjVar);
                    }
                    break;
                case 60:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzv(i2, zzgz.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case 61:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzd(i2, (zzdb) zzgz.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 62:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzI(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 63:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzi(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 64:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzx(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 65:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzz(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 66:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzB(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 67:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzD(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 68:
                    if (zzP(obj, i2, i)) {
                        zzdjVar.zzq(i2, zzgz.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzo.zzg(zzdjVar, entry);
            entry = itZzf.hasNext() ? (Map.Entry) itZzf.next() : null;
        }
        zzgp zzgpVar = this.zzn;
        zzgpVar.zzj(zzgpVar.zzc(obj), zzdjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzB = zzB(i);
            long j = 1048575 & iZzB;
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzM(obj2, i)) {
                        zzgz.zzo(obj, j, zzgz.zza(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 1:
                    if (zzM(obj2, i)) {
                        zzgz.zzp(obj, j, zzgz.zzb(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 2:
                    if (zzM(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 3:
                    if (zzM(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 4:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 5:
                    if (zzM(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 6:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 7:
                    if (zzM(obj2, i)) {
                        zzgz.zzm(obj, j, zzgz.zzw(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 8:
                    if (zzM(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzM(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 11:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 12:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 13:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 14:
                    if (zzM(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 15:
                    if (zzM(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 16:
                    if (zzM(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzgd.zzI(this.zzq, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzP(obj2, i2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzP(obj2, i2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzgd.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzgd.zzE(this.zzo, obj, obj2);
        }
    }
}
