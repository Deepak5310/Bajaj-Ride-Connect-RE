package com.google.android.gms.internal.auth;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes2.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfxVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, zzl(i2) & 1048575, i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzo(i) & 1048575, obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzo(i2) & 1048575, obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int iZzl = zzl(i);
        long j = iZzl & 1048575;
        if (j != 1048575) {
            return (zzhj.zzc(obj, j) & (1 << (iZzl >>> 20))) != 0;
        }
        int iZzo = zzo(i);
        long j2 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
            case 2:
                return zzhj.zzd(obj, j2) != 0;
            case 3:
                return zzhj.zzd(obj, j2) != 0;
            case 4:
                return zzhj.zzc(obj, j2) != 0;
            case 5:
                return zzhj.zzd(obj, j2) != 0;
            case 6:
                return zzhj.zzc(obj, j2) != 0;
            case 7:
                return zzhj.zzt(obj, j2);
            case 8:
                Object objZzf = zzhj.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzef) {
                    return !zzef.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j2) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j2));
            case 11:
                return zzhj.zzc(obj, j2) != 0;
            case 12:
                return zzhj.zzc(obj, j2) != 0;
            case 13:
                return zzhj.zzc(obj, j2) != 0;
            case 14:
                return zzhj.zzd(obj, j2) != 0;
            case 15:
                return zzhj.zzc(obj, j2) != 0;
            case 16:
                return zzhj.zzd(obj, j2) != 0;
            case 17:
                return zzhj.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzE(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzhaVarZzd = zzha.zzd();
        zzevVar.zzc = zzhaVarZzd;
        return zzhaVarZzd;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x024f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0252  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:128:0x026d  */
    static zzga zzj(Class cls, zzfu zzfuVar, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int iObjectFieldOffset2;
        Field fieldZzv;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field fieldZzv2;
        int i24;
        Object obj2;
        Field fieldZzv3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (!(zzfuVar instanceof zzgh)) {
            throw null;
        }
        zzgh zzghVar = (zzgh) zzfuVar;
        String strZzd = zzghVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (strZzd.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i31 = iCharAt3 & 8191;
            int i32 = 13;
            while (true) {
                i28 = i30 + 1;
                cCharAt13 = strZzd.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i28;
            }
            iCharAt3 = i31 | (cCharAt13 << i32);
            i30 = i28;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i33 = i30 + 1;
            int iCharAt4 = strZzd.charAt(i30);
            if (iCharAt4 >= 55296) {
                int i34 = iCharAt4 & 8191;
                int i35 = 13;
                while (true) {
                    i14 = i33 + 1;
                    cCharAt8 = strZzd.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i14;
                }
                iCharAt4 = i34 | (cCharAt8 << i35);
                i33 = i14;
            }
            int i36 = i33 + 1;
            int iCharAt5 = strZzd.charAt(i33);
            if (iCharAt5 >= 55296) {
                int i37 = iCharAt5 & 8191;
                int i38 = 13;
                while (true) {
                    i13 = i36 + 1;
                    cCharAt7 = strZzd.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i13;
                }
                iCharAt5 = i37 | (cCharAt7 << i38);
                i36 = i13;
            }
            int i39 = i36 + 1;
            int iCharAt6 = strZzd.charAt(i36);
            if (iCharAt6 >= 55296) {
                int i40 = iCharAt6 & 8191;
                int i41 = 13;
                while (true) {
                    i12 = i39 + 1;
                    cCharAt6 = strZzd.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i12;
                }
                iCharAt6 = i40 | (cCharAt6 << i41);
                i39 = i12;
            }
            int i42 = i39 + 1;
            int iCharAt7 = strZzd.charAt(i39);
            if (iCharAt7 >= 55296) {
                int i43 = iCharAt7 & 8191;
                int i44 = 13;
                while (true) {
                    i11 = i42 + 1;
                    cCharAt5 = strZzd.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i11;
                }
                iCharAt7 = i43 | (cCharAt5 << i44);
                i42 = i11;
            }
            int i45 = i42 + 1;
            iCharAt = strZzd.charAt(i42);
            if (iCharAt >= 55296) {
                int i46 = iCharAt & 8191;
                int i47 = 13;
                while (true) {
                    i10 = i45 + 1;
                    cCharAt4 = strZzd.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i10;
                }
                iCharAt = i46 | (cCharAt4 << i47);
                i45 = i10;
            }
            int i48 = i45 + 1;
            iCharAt2 = strZzd.charAt(i45);
            if (iCharAt2 >= 55296) {
                int i49 = iCharAt2 & 8191;
                int i50 = 13;
                while (true) {
                    i9 = i48 + 1;
                    cCharAt3 = strZzd.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i9;
                }
                iCharAt2 = i49 | (cCharAt3 << i50);
                i48 = i9;
            }
            int i51 = i48 + 1;
            int iCharAt8 = strZzd.charAt(i48);
            if (iCharAt8 >= 55296) {
                int i52 = iCharAt8 & 8191;
                int i53 = 13;
                while (true) {
                    i8 = i51 + 1;
                    cCharAt2 = strZzd.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i8;
                }
                iCharAt8 = i52 | (cCharAt2 << i53);
                i51 = i8;
            }
            int i54 = i51 + 1;
            int iCharAt9 = strZzd.charAt(i51);
            if (iCharAt9 >= 55296) {
                int i55 = iCharAt9 & 8191;
                int i56 = 13;
                while (true) {
                    i7 = i54 + 1;
                    cCharAt = strZzd.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i7;
                }
                iCharAt9 = i55 | (cCharAt << i56);
                i54 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i30 = i54;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzghVar.zze();
        Class<?> cls2 = zzghVar.zza().getClass();
        int i57 = i4 + iCharAt2;
        int i58 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i58];
        int i59 = 0;
        int i60 = 0;
        int i61 = i4;
        int i62 = i57;
        while (i30 < length) {
            int i63 = i30 + 1;
            int iCharAt10 = strZzd.charAt(i30);
            if (iCharAt10 >= c) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i27 = i65 + 1;
                    cCharAt12 = strZzd.charAt(i65);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i27;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i15 = i27;
            } else {
                i15 = i63;
            }
            int i67 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i26 = i69 + 1;
                    cCharAt11 = strZzd.charAt(i69);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i26;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i16 = i26;
            } else {
                i16 = i67;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i59] = i60;
                i59++;
            }
            int i71 = iCharAt11 & 255;
            if (i71 >= 51) {
                int i72 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = 13;
                    while (true) {
                        i25 = i72 + 1;
                        cCharAt10 = strZzd.charAt(i72);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i73 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i72 = i25;
                        c2 = 55296;
                    }
                    iCharAt12 = i73 | (cCharAt10 << i74);
                    i72 = i25;
                }
                int i75 = i71 - 51;
                int i76 = i72;
                if (i75 == 9 || i75 == 17) {
                    int i77 = i60 / 3;
                    i22 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i75 == 12 && (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i78 = i60 / 3;
                        i22 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    i23 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i23];
                    if (obj instanceof Field) {
                        fieldZzv2 = (Field) obj;
                    } else {
                        fieldZzv2 = zzv(cls2, (String) obj);
                        objArrZze[i23] = fieldZzv2;
                    }
                    int i79 = i3;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv2);
                    i24 = i23 + 1;
                    obj2 = objArrZze[i24];
                    if (obj2 instanceof Field) {
                        fieldZzv3 = (Field) obj2;
                    } else {
                        fieldZzv3 = zzv(cls2, (String) obj2);
                        objArrZze[i24] = fieldZzv3;
                    }
                    strZzd = strZzd;
                    i17 = i79;
                    i18 = i2;
                    i19 = i76;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv3);
                    i20 = 0;
                }
                i2 = i22;
                i23 = iCharAt12 + iCharAt12;
                obj = objArrZze[i23];
                if (obj instanceof Field) {
                    fieldZzv2 = (Field) obj;
                } else {
                    fieldZzv2 = zzv(cls2, (String) obj);
                    objArrZze[i23] = fieldZzv2;
                }
                int i710 = i3;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv2);
                i24 = i23 + 1;
                obj2 = objArrZze[i24];
                if (obj2 instanceof Field) {
                    fieldZzv3 = (Field) obj2;
                } else {
                    fieldZzv3 = zzv(cls2, (String) obj2);
                    objArrZze[i24] = fieldZzv3;
                }
                strZzd = strZzd;
                i17 = i710;
                i18 = i2;
                i19 = i76;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv3);
                i20 = 0;
            } else {
                i17 = i3;
                i18 = i2 + 1;
                Field fieldZzv4 = zzv(cls2, (String) objArrZze[i2]);
                if (i71 == 9 || i71 == 17) {
                    i17 = i17;
                    int i80 = i60 / 3;
                    objArr[i80 + i80 + 1] = fieldZzv4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        i17 = i17;
                        int i81 = i60 / 3;
                        i21 = i2 + 2;
                        objArr[i81 + i81 + 1] = objArrZze[i18];
                    } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                        i17 = i17;
                        if (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0) {
                            int i82 = i60 / 3;
                            i21 = i2 + 2;
                            objArr[i82 + i82 + 1] = objArrZze[i18];
                        }
                    } else if (i71 == 50) {
                        int i83 = i61 + 1;
                        iArr[i61] = i60;
                        int i84 = i60 / 3;
                        int i85 = i2 + 2;
                        int i86 = i84 + i84;
                        objArr[i86] = objArrZze[i18];
                        if ((iCharAt11 & 2048) != 0) {
                            i18 = i2 + 3;
                            objArr[i86 + 1] = objArrZze[i85];
                            i61 = i83;
                        } else {
                            i61 = i83;
                            i18 = i85;
                        }
                    }
                    i18 = i21;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzv4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i71 > 17) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    int i87 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i88 = iCharAt13 & 8191;
                        int i89 = 13;
                        while (true) {
                            i19 = i87 + 1;
                            cCharAt9 = strZzd.charAt(i87);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i88 |= (cCharAt9 & 8191) << i89;
                            i89 += 13;
                            i87 = i19;
                        }
                        iCharAt13 = i88 | (cCharAt9 << i89);
                    } else {
                        i19 = i87;
                    }
                    int i90 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i90];
                    if (obj3 instanceof Field) {
                        fieldZzv = (Field) obj3;
                    } else {
                        fieldZzv = zzv(cls2, (String) obj3);
                        objArrZze[i90] = fieldZzv;
                    }
                    i20 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv);
                }
                if (i71 >= 18 && i71 <= 49) {
                    iArr[i62] = iObjectFieldOffset3;
                    i62++;
                }
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i91 = i60 + 1;
            iArr2[i60] = iCharAt10;
            int i92 = i60 + 2;
            iArr2[i91] = iObjectFieldOffset2 | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i71 << 20);
            i60 += 3;
            iArr2[i92] = (i20 << 20) | iObjectFieldOffset;
            i2 = i18;
            i30 = i19;
            length = length;
            i3 = i17;
            strZzd = strZzd;
            i6 = i6;
            c = 55296;
        }
        return new zzga(iArr2, objArr, i3, i6, zzghVar.zza(), zzghVar.zzc(), false, iArr, i4, i57, zzgcVar, zzflVar, zzgzVar, zzemVar, zzfsVar);
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
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

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgiVar = (zzgi) this.zzd[i3];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZzb = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgiVarZzb;
        return zzgiVarZzb;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzgiVarZzr = zzr(i);
        int iZzo = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, iZzo);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzgiVarZzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i2) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzE(obj, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzz(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzI(obj, i2, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzA(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i) {
        int iZzl = zzl(i);
        long j = 1048575 & iZzl;
        if (j == 1048575) {
            return;
        }
        zzhj.zzn(obj, j, (1 << (iZzl >>> 20)) | zzhj.zzc(obj, j));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzo = zzo(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzo;
            int iHashCode = 37;
            switch (zzn(iZzo)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j));
                    byte[] bArr = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr2 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr3 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr4 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzfa.zza(zzhj.zzt(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzhj.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr5 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr6 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zzhj.zzf(obj, j);
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
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j)).floatValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j)).booleanValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0255  */
    /* JADX WARN: Code duplicated, block: B:113:0x029d  */
    /* JADX WARN: Code duplicated, block: B:115:0x02a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:129:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:162:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:165:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:173:0x0423  */
    /* JADX WARN: Code duplicated, block: B:176:0x042a  */
    /* JADX WARN: Code duplicated, block: B:178:0x0439  */
    /* JADX WARN: Code duplicated, block: B:180:0x043f  */
    /* JADX WARN: Code duplicated, block: B:182:0x044d  */
    /* JADX WARN: Code duplicated, block: B:183:0x046b  */
    /* JADX WARN: Code duplicated, block: B:185:0x046e  */
    /* JADX WARN: Code duplicated, block: B:187:0x0479 A[LOOP:3: B:186:0x0477->B:187:0x0479, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x0489  */
    /* JADX WARN: Code duplicated, block: B:192:0x049a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x049c  */
    /* JADX WARN: Code duplicated, block: B:195:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:197:0x04b7 A[LOOP:4: B:194:0x04ab->B:197:0x04b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:199:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:200:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:202:0x04da  */
    /* JADX WARN: Code duplicated, block: B:204:0x04e5 A[LOOP:5: B:203:0x04e3->B:204:0x04e5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:209:0x04fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:212:0x050e  */
    /* JADX WARN: Code duplicated, block: B:214:0x0516 A[LOOP:6: B:211:0x050c->B:214:0x0516, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:216:0x0530  */
    /* JADX WARN: Code duplicated, block: B:217:0x0539  */
    /* JADX WARN: Code duplicated, block: B:219:0x053e  */
    /* JADX WARN: Code duplicated, block: B:220:0x0549 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x054b  */
    /* JADX WARN: Code duplicated, block: B:224:0x0568  */
    /* JADX WARN: Code duplicated, block: B:226:0x056c  */
    /* JADX WARN: Code duplicated, block: B:228:0x0579  */
    /* JADX WARN: Code duplicated, block: B:230:0x058d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:231:0x058f  */
    /* JADX WARN: Code duplicated, block: B:233:0x0595  */
    /* JADX WARN: Code duplicated, block: B:237:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:238:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:241:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:244:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:248:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:250:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:252:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:254:0x0603  */
    /* JADX WARN: Code duplicated, block: B:256:0x0607 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x0609  */
    /* JADX WARN: Code duplicated, block: B:258:0x060f  */
    /* JADX WARN: Code duplicated, block: B:261:0x0619  */
    /* JADX WARN: Code duplicated, block: B:263:0x0621  */
    /* JADX WARN: Code duplicated, block: B:265:0x0629  */
    /* JADX WARN: Code duplicated, block: B:267:0x062d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:279:0x0659  */
    /* JADX WARN: Code duplicated, block: B:280:0x0661  */
    /* JADX WARN: Code duplicated, block: B:282:0x066a  */
    /* JADX WARN: Code duplicated, block: B:283:0x068e  */
    /* JADX WARN: Code duplicated, block: B:285:0x0699  */
    /* JADX WARN: Code duplicated, block: B:287:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:289:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:291:0x06b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:292:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:293:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:296:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:298:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:300:0x06dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:307:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:309:0x0701 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:310:0x0703  */
    /* JADX WARN: Code duplicated, block: B:311:0x0707  */
    /* JADX WARN: Code duplicated, block: B:313:0x070f  */
    /* JADX WARN: Code duplicated, block: B:316:0x071c  */
    /* JADX WARN: Code duplicated, block: B:318:0x0724  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:320:0x072c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:324:0x073a  */
    /* JADX WARN: Code duplicated, block: B:333:0x0759 A[PHI: r3 r4 r5 r7 r25
      0x0759: PHI (r3v69 sun.misc.Unsafe) = 
      (r3v64 sun.misc.Unsafe)
      (r3v66 sun.misc.Unsafe)
      (r3v67 sun.misc.Unsafe)
      (r3v68 sun.misc.Unsafe)
      (r3v71 sun.misc.Unsafe)
     binds: [B:399:0x0872, B:388:0x0839, B:372:0x07ee, B:348:0x0792, B:286:0x06a3] A[DONT_GENERATE, DONT_INLINE]
      0x0759: PHI (r4v51 int) = (r4v46 int), (r4v48 int), (r4v49 int), (r4v50 int), (r4v53 int) binds: [B:399:0x0872, B:388:0x0839, B:372:0x07ee, B:348:0x0792, B:286:0x06a3] A[DONT_GENERATE, DONT_INLINE]
      0x0759: PHI (r5v66 int) = (r5v61 int), (r5v63 int), (r5v64 int), (r5v65 int), (r5v68 int) binds: [B:399:0x0872, B:388:0x0839, B:372:0x07ee, B:348:0x0792, B:286:0x06a3] A[DONT_GENERATE, DONT_INLINE]
      0x0759: PHI (r7v14 int) = (r7v10 int), (r7v11 int), (r7v12 int), (r7v13 int), (r7v16 int) binds: [B:399:0x0872, B:388:0x0839, B:372:0x07ee, B:348:0x0792, B:286:0x06a3] A[DONT_GENERATE, DONT_INLINE]
      0x0759: PHI (r25v20 int) = (r25v16 int), (r25v17 int), (r25v18 int), (r25v19 int), (r25v22 int) binds: [B:399:0x0872, B:388:0x0839, B:372:0x07ee, B:348:0x0792, B:286:0x06a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:335:0x0760  */
    /* JADX WARN: Code duplicated, block: B:337:0x076c  */
    /* JADX WARN: Code duplicated, block: B:339:0x0777  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:341:0x0781  */
    /* JADX WARN: Code duplicated, block: B:342:0x0783  */
    /* JADX WARN: Code duplicated, block: B:348:0x0792 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:349:0x0794  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:351:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:352:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:355:0x07a9  */
    /* JADX WARN: Code duplicated, block: B:357:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:359:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:360:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:362:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:364:0x07cf  */
    /* JADX WARN: Code duplicated, block: B:366:0x07da A[LOOP:14: B:365:0x07d8->B:366:0x07da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:371:0x07ed  */
    /* JADX WARN: Code duplicated, block: B:373:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:375:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:377:0x0805 A[LOOP:15: B:374:0x07fb->B:377:0x0805, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:378:0x080f  */
    /* JADX WARN: Code duplicated, block: B:380:0x081b  */
    /* JADX WARN: Code duplicated, block: B:382:0x0826 A[LOOP:16: B:381:0x0824->B:382:0x0826, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:387:0x0838  */
    /* JADX WARN: Code duplicated, block: B:389:0x083b  */
    /* JADX WARN: Code duplicated, block: B:391:0x0848  */
    /* JADX WARN: Code duplicated, block: B:393:0x0850 A[LOOP:17: B:390:0x0846->B:393:0x0850, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:394:0x085a  */
    /* JADX WARN: Code duplicated, block: B:396:0x0866  */
    /* JADX WARN: Code duplicated, block: B:399:0x0872 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:400:0x0874  */
    /* JADX WARN: Code duplicated, block: B:401:0x0888  */
    /* JADX WARN: Code duplicated, block: B:403:0x0896  */
    /* JADX WARN: Code duplicated, block: B:405:0x08a1 A[LOOP:18: B:404:0x089f->B:405:0x08a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:410:0x08b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:411:0x08b6  */
    /* JADX WARN: Code duplicated, block: B:413:0x08c3  */
    /* JADX WARN: Code duplicated, block: B:415:0x08cb A[LOOP:19: B:412:0x08c1->B:415:0x08cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:416:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:418:0x08e3  */
    /* JADX WARN: Code duplicated, block: B:420:0x08ee A[LOOP:20: B:419:0x08ec->B:420:0x08ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:425:0x0905  */
    /* JADX WARN: Code duplicated, block: B:427:0x0908  */
    /* JADX WARN: Code duplicated, block: B:429:0x0919  */
    /* JADX WARN: Code duplicated, block: B:431:0x0921 A[LOOP:21: B:428:0x0917->B:431:0x0921, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:432:0x092f  */
    /* JADX WARN: Code duplicated, block: B:434:0x093d  */
    /* JADX WARN: Code duplicated, block: B:436:0x0948 A[LOOP:22: B:435:0x0946->B:436:0x0948, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:441:0x095e  */
    /* JADX WARN: Code duplicated, block: B:443:0x0961  */
    /* JADX WARN: Code duplicated, block: B:445:0x0972  */
    /* JADX WARN: Code duplicated, block: B:447:0x097a A[LOOP:23: B:444:0x0970->B:447:0x097a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:449:0x098a  */
    /* JADX WARN: Code duplicated, block: B:451:0x0992 A[LOOP:2: B:448:0x0988->B:451:0x0992, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:452:0x09a6 A[PHI: r0 r7 r8 r9 r10 r11 r14 r25
      0x09a6: PHI (r0v34 'this' com.google.android.gms.internal.auth.zzga<T>) = 
      (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
      (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
      (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
      (r0v30 'this' com.google.android.gms.internal.auth.zzga<T>)
      (r0v32 'this' com.google.android.gms.internal.auth.zzga<T>)
      (r0v1 'this' com.google.android.gms.internal.auth.zzga<T>)
     binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r7v33 int) = (r7v7 int), (r7v8 int), (r7v9 int), (r7v24 int), (r7v27 int), (r7v37 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r8v96 sun.misc.Unsafe) = 
      (r8v48 sun.misc.Unsafe)
      (r8v49 sun.misc.Unsafe)
      (r8v50 sun.misc.Unsafe)
      (r8v90 sun.misc.Unsafe)
      (r8v92 sun.misc.Unsafe)
      (r8v99 sun.misc.Unsafe)
     binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r9v80 int) = (r9v37 int), (r9v38 int), (r9v39 int), (r9v71 int), (r10v37 int), (r9v82 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r10v79 int) = (r10v41 int), (r10v42 int), (r10v43 int), (r10v70 int), (r17v3 int), (r10v82 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r11v41 int) = (r11v13 int), (r11v14 int), (r11v15 int), (r11v32 int), (r11v35 int), (r11v44 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r14v41 int) = (r14v17 int), (r14v18 int), (r14v19 int), (r14v31 int), (r14v33 int), (r14v43 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x09a6: PHI (r25v39 int) = (r25v13 int), (r25v14 int), (r25v15 int), (r25v30 int), (r25v33 int), (r25v41 int) binds: [B:442:0x095f, B:426:0x0906, B:410:0x08b4, B:334:0x075d, B:284:0x0695, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:462:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:465:0x0a02  */
    /* JADX WARN: Code duplicated, block: B:467:0x0a0e  */
    /* JADX WARN: Code duplicated, block: B:469:0x0a21 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:470:0x0a2e  */
    /* JADX WARN: Code duplicated, block: B:472:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:473:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:475:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:476:0x0a7d  */
    /* JADX WARN: Code duplicated, block: B:478:0x0a89  */
    /* JADX WARN: Code duplicated, block: B:479:0x0a9e  */
    /* JADX WARN: Code duplicated, block: B:481:0x0aaa  */
    /* JADX WARN: Code duplicated, block: B:487:0x0aca  */
    /* JADX WARN: Code duplicated, block: B:488:0x0ad5  */
    /* JADX WARN: Code duplicated, block: B:490:0x0ae2  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b04  */
    /* JADX WARN: Code duplicated, block: B:495:0x0b0b  */
    /* JADX WARN: Code duplicated, block: B:496:0x0b3a  */
    /* JADX WARN: Code duplicated, block: B:497:0x0b46  */
    /* JADX WARN: Code duplicated, block: B:499:0x0b58  */
    /* JADX WARN: Code duplicated, block: B:501:0x0b60  */
    /* JADX WARN: Code duplicated, block: B:503:0x0b66  */
    /* JADX WARN: Code duplicated, block: B:512:0x0b8e  */
    /* JADX WARN: Code duplicated, block: B:513:0x0b93  */
    /* JADX WARN: Code duplicated, block: B:515:0x0ba2  */
    /* JADX WARN: Code duplicated, block: B:517:0x0bad  */
    /* JADX WARN: Code duplicated, block: B:518:0x0baf  */
    /* JADX WARN: Code duplicated, block: B:520:0x0bbd A[PHI: r1 r5 r6 r7 r17 r20 r26
      0x0bbd: PHI (r1v165 int) = (r1v164 int), (r1v166 int) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r5v90 com.google.android.gms.internal.auth.zzdt) = (r5v89 com.google.android.gms.internal.auth.zzdt), (r5v91 com.google.android.gms.internal.auth.zzdt) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r6v55 int) = (r6v54 int), (r6v56 int) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r7v49 java.lang.Object) = (r7v48 java.lang.Object), (r7v50 java.lang.Object) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r17v20 int) = (r17v19 int), (r17v21 int) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r20v19 int) = (r20v18 int), (r20v20 int) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]
      0x0bbd: PHI (r26v10 sun.misc.Unsafe) = (r26v9 sun.misc.Unsafe), (r26v11 sun.misc.Unsafe) binds: [B:514:0x0ba0, B:512:0x0b8e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:521:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:523:0x0bd1  */
    /* JADX WARN: Code duplicated, block: B:524:0x0be3  */
    /* JADX WARN: Code duplicated, block: B:526:0x0bf4  */
    /* JADX WARN: Code duplicated, block: B:527:0x0c06  */
    /* JADX WARN: Code duplicated, block: B:529:0x0c16  */
    /* JADX WARN: Code duplicated, block: B:530:0x0c28  */
    /* JADX WARN: Code duplicated, block: B:532:0x0c38  */
    /* JADX WARN: Code duplicated, block: B:533:0x0c49  */
    /* JADX WARN: Code duplicated, block: B:535:0x0c5a  */
    /* JADX WARN: Code duplicated, block: B:536:0x0c6f  */
    /* JADX WARN: Code duplicated, block: B:538:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:539:0x0c95 A[PHI: r1 r5 r6 r7 r8 r17 r20 r26
      0x0c95: PHI (r1v177 int) = 
      (r1v158 int)
      (r1v159 int)
      (r1v160 int)
      (r1v161 int)
      (r1v162 int)
      (r1v163 int)
      (r1v165 int)
      (r1v168 int)
      (r1v172 int)
      (r1v178 int)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r5v100 com.google.android.gms.internal.auth.zzdt) = 
      (r5v83 com.google.android.gms.internal.auth.zzdt)
      (r5v84 com.google.android.gms.internal.auth.zzdt)
      (r5v85 com.google.android.gms.internal.auth.zzdt)
      (r5v86 com.google.android.gms.internal.auth.zzdt)
      (r5v87 com.google.android.gms.internal.auth.zzdt)
      (r5v88 com.google.android.gms.internal.auth.zzdt)
      (r5v90 com.google.android.gms.internal.auth.zzdt)
      (r5v92 com.google.android.gms.internal.auth.zzdt)
      (r5v95 com.google.android.gms.internal.auth.zzdt)
      (r5v101 com.google.android.gms.internal.auth.zzdt)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r6v73 int) = 
      (r6v48 int)
      (r6v49 int)
      (r6v50 int)
      (r6v51 int)
      (r6v52 int)
      (r6v53 int)
      (r6v55 int)
      (r6v58 int)
      (r6v65 int)
      (r6v74 int)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r7v60 java.lang.Object) = 
      (r7v42 java.lang.Object)
      (r7v43 java.lang.Object)
      (r7v44 java.lang.Object)
      (r7v45 java.lang.Object)
      (r7v46 java.lang.Object)
      (r7v47 java.lang.Object)
      (r7v49 java.lang.Object)
      (r7v51 java.lang.Object)
      (r7v55 java.lang.Object)
      (r7v61 java.lang.Object)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r8v136 int) = 
      (r8v101 int)
      (r8v102 int)
      (r8v103 int)
      (r8v104 int)
      (r8v105 int)
      (r8v106 int)
      (r8v108 int)
      (r8v115 int)
      (r8v126 int)
      (r8v137 int)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r17v28 int) = 
      (r17v13 int)
      (r17v14 int)
      (r17v15 int)
      (r17v16 int)
      (r17v17 int)
      (r17v18 int)
      (r17v20 int)
      (r17v22 int)
      (r17v24 int)
      (r17v29 int)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r20v28 int) = 
      (r20v12 int)
      (r20v13 int)
      (r20v14 int)
      (r20v15 int)
      (r20v16 int)
      (r20v17 int)
      (r20v19 int)
      (r20v22 int)
      (r20v24 int)
      (r20v29 int)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]
      0x0c95: PHI (r26v14 sun.misc.Unsafe) = 
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v10 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
     binds: [B:537:0x0c7e, B:534:0x0c58, B:531:0x0c36, B:528:0x0c14, B:525:0x0bf2, B:522:0x0bcf, B:520:0x0bbd, B:496:0x0b3a, B:492:0x0af9, B:469:0x0a21] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:577:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x02d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x0306 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x0323 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x03b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0495 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x04f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x0654 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x064f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x0642 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x063d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x06f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x06ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x0754 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x074f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x074a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0745 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x078d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x07e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x0833 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x08af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0900 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x0959 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x09a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x09dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0c98 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x039b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x012b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x02d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x02fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x031d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x034b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x027c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x024c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x026d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x03fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x03b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x09c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x09b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x0caf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x040c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x09d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x09a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x04c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0524 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0524 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x05cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x05b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:0x0647 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x0635 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x062f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x06e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:0x06de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:704:0x0732 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:706:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x072e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:721:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:727:0x09a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:730:0x09a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x09a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:0x0204 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:739:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:740:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:741:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:742:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:0x01f8 A[EDGE_INSN: B:748:0x01f8->B:743:0x01f8 BREAK  A[LOOP:26: B:86:0x020b->B:89:0x0215], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ef A[LOOP:24: B:78:0x01e5->B:81:0x01ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x020d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0215 A[LOOP:26: B:86:0x020b->B:89:0x0215, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x0224  */
    final int zzb(Object obj, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        int i4;
        Unsafe unsafe;
        int iZzi;
        int i5;
        int i6;
        int iZzm;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Unsafe unsafe2;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int iZzn;
        long j;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z;
        int i23;
        int i24;
        int i25;
        int length;
        int i26;
        char[] cArr;
        int i27;
        int i28;
        byte b;
        byte b2;
        byte b3;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        zzez zzezVarZzd;
        long j2;
        Unsafe unsafe3;
        Unsafe unsafe4;
        zzez zzezVar;
        zzez zzezVar2;
        int i38;
        Unsafe unsafe5;
        zzek zzekVar;
        int iZzh;
        zzek zzekVar2;
        int i39;
        zzer zzerVar;
        int iZzh2;
        zzer zzerVar2;
        int i40;
        zzfm zzfmVar;
        int iZzh3;
        zzfm zzfmVar2;
        int i41;
        int i42;
        int i43;
        Unsafe unsafe6;
        int iZzf;
        zzfm zzfmVar3;
        int iZzh4;
        zzfm zzfmVar4;
        int i44;
        zzew zzewVar;
        int iZzh5;
        zzew zzewVar2;
        int i45;
        zzdv zzdvVar;
        boolean z2;
        int iZzh6;
        boolean z3;
        zzdv zzdvVar2;
        int i46;
        boolean z4;
        int i47;
        int i48;
        int iZzh7;
        int i49;
        int i50;
        int i51;
        Object obj2;
        int iZzh8;
        int i52;
        int iZzh9;
        int i53;
        int iZzh10;
        int i54;
        int iZzj;
        zzey zzeyVarZzq;
        zzgz zzgzVar;
        int i55;
        int i56;
        Iterator it2;
        Object objZzc;
        int iIntValue;
        int size;
        Object objZzc2;
        int i57;
        int i58;
        Integer num;
        int iIntValue2;
        int i59;
        zzew zzewVar3;
        int iZzh11;
        int iZzh12;
        zzew zzewVar4;
        int i60;
        zzfm zzfmVar5;
        int iZzh13;
        zzfm zzfmVar6;
        int iZzh14;
        int i61;
        zzgi zzgiVarZzr;
        int i62;
        int iZzh15;
        Unsafe unsafe7;
        Object object;
        Unsafe unsafe8;
        long j3;
        int i63;
        zzdt zzdtVar2;
        int i64;
        int iZzk;
        boolean z5;
        int i65;
        zzdt zzdtVar3;
        int i66;
        int i67;
        zzey zzeyVarZzq2;
        this = this;
        Object obj3 = obj;
        i2 = i2;
        i3 = i3;
        zzdt zzdtVar4 = zzdtVar;
        zzw(obj);
        Unsafe unsafe9 = zzb;
        int i68 = 0;
        int iZzg = i;
        int i69 = 0;
        int i70 = 0;
        int i71 = 0;
        int i72 = -1;
        int i73 = 1048575;
        while (true) {
            if (iZzg < i2) {
                int i74 = iZzg + 1;
                int i75 = bArr[iZzg];
                if (i75 < 0) {
                    iZzi = zzdu.zzi(i75, bArr, i74, zzdtVar4);
                    i70 = zzdtVar4.zza;
                } else {
                    i70 = i75;
                    iZzi = i74;
                }
                int i76 = i70 >>> 3;
                if (i76 > i72) {
                    iZzm = (i76 < this.zze || i76 > this.zzf) ? -1 : this.zzm(i76, i69 / 3);
                } else {
                    if (i76 < this.zze || i76 > this.zzf) {
                        i5 = -1;
                        i6 = -1;
                    } else {
                        iZzm = this.zzm(i76, i68);
                    }
                    if (i6 == i5) {
                        i12 = i70 & 7;
                        iArr = this.zzc;
                        i13 = iArr[i6 + 1];
                        i14 = i70;
                        iZzn = zzn(i13);
                        j = i13 & 1048575;
                        i72 = i76;
                        if (iZzn <= 17) {
                            int i77 = iArr[i6 + 2];
                            i15 = 1 << (i77 >>> 20);
                            i16 = 1048575;
                            i17 = i77 & 1048575;
                            if (i17 != i73) {
                                if (i73 != 1048575) {
                                    unsafe9.putInt(obj3, i73, i71);
                                    i16 = 1048575;
                                }
                                if (i17 == i16) {
                                    i30 = 0;
                                } else {
                                    i30 = unsafe9.getInt(obj3, i17);
                                }
                                i8 = i30;
                                i9 = i17;
                            } else {
                                i8 = i71;
                                i9 = i73;
                            }
                            switch (iZzn) {
                                case 0:
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 1) {
                                        zzhj.zzl(obj3, j, Double.longBitsToDouble(zzdu.zzn(bArr, iZzi)));
                                        iZzg = iZzi + 8;
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 1:
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 5) {
                                        zzhj.zzm(obj3, j, Float.intBitsToFloat(zzdu.zzb(bArr, iZzi)));
                                        iZzg = iZzi + 4;
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 0) {
                                        int iZzk2 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                        unsafe9.putLong(obj, j, zzdtVar4.zzb);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        iZzg = iZzk2;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                        unsafe9.putInt(obj3, j, zzdtVar4.zza);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i21 = iZzi;
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 1) {
                                        unsafe9.putLong(obj, j, zzdu.zzn(bArr, i21));
                                        iZzg = i21 + 8;
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        iZzi = i21;
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i21 = iZzi;
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 5) {
                                        unsafe9.putInt(obj3, j, zzdu.zzb(bArr, i21));
                                        iZzg = i21 + 4;
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        iZzi = i21;
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 7:
                                    i21 = iZzi;
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzk(bArr, i21, zzdtVar4);
                                        if (zzdtVar4.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzhj.zzk(obj3, j, z);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        iZzi = i21;
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 8:
                                    i23 = iZzi;
                                    i18 = i6;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        if ((i13 & PropertyOptions.DELETE_EXISTING) != 0) {
                                            iZzg = zzdu.zzh(bArr, i23, zzdtVar4);
                                            i25 = zzdtVar4.zza;
                                            if (i25 >= 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i25 == 0) {
                                                zzdtVar4.zzc = "";
                                                i20 = 0;
                                            } else {
                                                int i78 = zzhn.zza;
                                                length = bArr.length;
                                                if ((((length - iZzg) - i25) | iZzg | i25) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i25)));
                                                }
                                                i26 = iZzg + i25;
                                                cArr = new char[i25];
                                                i27 = 0;
                                                while (iZzg < i26) {
                                                    b3 = bArr[iZzg];
                                                    if (zzhk.zzd(b3)) {
                                                        iZzg++;
                                                        cArr[i27] = (char) b3;
                                                        i27++;
                                                    } else {
                                                        while (iZzg < i26) {
                                                            i28 = iZzg + 1;
                                                            b = bArr[iZzg];
                                                            if (zzhk.zzd(b)) {
                                                                cArr[i27] = (char) b;
                                                                i27++;
                                                                iZzg = i28;
                                                                while (iZzg < i26) {
                                                                    b2 = bArr[iZzg];
                                                                    if (zzhk.zzd(b2)) {
                                                                    }
                                                                    iZzg++;
                                                                    cArr[i27] = (char) b2;
                                                                    i27++;
                                                                    break;
                                                                }
                                                            } else if (b < -32) {
                                                                if (i28 < i26) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                iZzg += 2;
                                                                zzhk.zzc(b, bArr[i28], cArr, i27);
                                                                i27++;
                                                            } else if (b < -16) {
                                                                if (i28 < i26 - 1) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                int i79 = iZzg + 2;
                                                                iZzg += 3;
                                                                zzhk.zzb(b, bArr[i28], bArr[i79], cArr, i27);
                                                                i27++;
                                                            } else {
                                                                if (i28 < i26 - 2) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                byte b4 = bArr[i28];
                                                                int i80 = iZzg + 3;
                                                                byte b5 = bArr[iZzg + 2];
                                                                iZzg += 4;
                                                                zzhk.zza(b, b4, b5, bArr[i80], cArr, i27);
                                                                i27 += 2;
                                                            }
                                                        }
                                                        i20 = 0;
                                                        zzdtVar4.zzc = new String(cArr, 0, i27);
                                                        iZzg = i26;
                                                    }
                                                }
                                                while (iZzg < i26) {
                                                    i28 = iZzg + 1;
                                                    b = bArr[iZzg];
                                                    if (zzhk.zzd(b)) {
                                                        cArr[i27] = (char) b;
                                                        i27++;
                                                        iZzg = i28;
                                                        while (iZzg < i26) {
                                                            b2 = bArr[iZzg];
                                                            if (zzhk.zzd(b2)) {
                                                            }
                                                            iZzg++;
                                                            cArr[i27] = (char) b2;
                                                            i27++;
                                                            break;
                                                        }
                                                    } else if (b < -32) {
                                                        if (i28 < i26) {
                                                            throw zzfb.zzb();
                                                        }
                                                        iZzg += 2;
                                                        zzhk.zzc(b, bArr[i28], cArr, i27);
                                                        i27++;
                                                    } else if (b < -16) {
                                                        if (i28 < i26 - 1) {
                                                            throw zzfb.zzb();
                                                        }
                                                        int i710 = iZzg + 2;
                                                        iZzg += 3;
                                                        zzhk.zzb(b, bArr[i28], bArr[i710], cArr, i27);
                                                        i27++;
                                                    } else {
                                                        if (i28 < i26 - 2) {
                                                            throw zzfb.zzb();
                                                        }
                                                        byte b6 = bArr[i28];
                                                        int i81 = iZzg + 3;
                                                        byte b7 = bArr[iZzg + 2];
                                                        iZzg += 4;
                                                        zzhk.zza(b, b6, b7, bArr[i81], cArr, i27);
                                                        i27 += 2;
                                                    }
                                                }
                                                i20 = 0;
                                                zzdtVar4.zzc = new String(cArr, 0, i27);
                                                iZzg = i26;
                                            }
                                        } else {
                                            i20 = 0;
                                            iZzg = zzdu.zzh(bArr, i23, zzdtVar4);
                                            i24 = zzdtVar4.zza;
                                            if (i24 >= 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i24 == 0) {
                                                zzdtVar4.zzc = "";
                                            } else {
                                                zzdtVar4.zzc = new String(bArr, iZzg, i24, zzfa.zzb);
                                                iZzg += i24;
                                            }
                                        }
                                        unsafe9.putObject(obj3, j, zzdtVar4.zzc);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i72 = i72;
                                        i73 = i9;
                                        i68 = i20;
                                    } else {
                                        iZzi = i23;
                                        i22 = i19;
                                        i6 = i18;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 9:
                                    i18 = i6;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        Object objZzt = this.zzt(obj3, i18);
                                        iZzg = zzdu.zzm(objZzt, this.zzr(i18), bArr, iZzi, i2, zzdtVar);
                                        this.zzB(obj3, i18, objZzt);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i73 = i9;
                                        i68 = 0;
                                    } else {
                                        i22 = i19;
                                        i6 = i18;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 10:
                                    i18 = i6;
                                    i19 = i14;
                                    if (i12 == 2) {
                                        iZzg = zzdu.zza(bArr, iZzi, zzdtVar4);
                                        unsafe9.putObject(obj3, j, zzdtVar4.zzc);
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i73 = i9;
                                        i68 = 0;
                                    } else {
                                        i22 = i19;
                                        i6 = i18;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 12:
                                    i18 = i6;
                                    i19 = i14;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                        i29 = zzdtVar4.zza;
                                        zzey zzeyVarZzq3 = this.zzq(i18);
                                        if ((i13 & Integer.MIN_VALUE) != 0 || zzeyVarZzq3 == null || zzeyVarZzq3.zza()) {
                                            unsafe9.putInt(obj3, j, i29);
                                            i71 = i8 | i15;
                                            i70 = i19;
                                            i69 = i18;
                                        } else {
                                            zzc(obj).zzh(i19, Long.valueOf(i29));
                                            i2 = i2;
                                            i3 = i3;
                                            i70 = i19;
                                            i69 = i18;
                                            i71 = i8;
                                        }
                                        i73 = i9;
                                        i68 = 0;
                                    } else {
                                        i22 = i19;
                                        i6 = i18;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 15:
                                    i18 = i6;
                                    i19 = i14;
                                    if (i12 == 0) {
                                        iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                        unsafe9.putInt(obj3, j, zzej.zzb(zzdtVar4.zza));
                                        i71 = i8 | i15;
                                        i70 = i19;
                                        i69 = i18;
                                        i73 = i9;
                                        i68 = 0;
                                    } else {
                                        i22 = i19;
                                        i6 = i18;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                case 16:
                                    if (i12 == 0) {
                                        int iZzk3 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                        i18 = i6;
                                        i19 = i14;
                                        unsafe9.putLong(obj, j, zzej.zzc(zzdtVar4.zzb));
                                        i71 = i8 | i15;
                                        iZzg = iZzk3;
                                        i70 = i19;
                                        i69 = i18;
                                        i73 = i9;
                                        i68 = 0;
                                    } else {
                                        i2 = i2;
                                        i22 = i14;
                                        i11 = 0;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                                default:
                                    i18 = i6;
                                    i19 = i14;
                                    i20 = 0;
                                    if (i12 == 3) {
                                        Object objZzt2 = this.zzt(obj3, i18);
                                        i69 = i18;
                                        int iZzl = zzdu.zzl(objZzt2, this.zzr(i18), bArr, iZzi, i2, (i72 << 3) | 4, zzdtVar);
                                        this.zzB(obj3, i69, objZzt2);
                                        i3 = i3;
                                        zzdtVar4 = zzdtVar4;
                                        unsafe9 = unsafe9;
                                        i2 = i2;
                                        iZzg = iZzl;
                                        i68 = 0;
                                        i73 = i9;
                                        i71 = i8 | i15;
                                        i72 = i72;
                                        i70 = i19;
                                    } else {
                                        i11 = i20;
                                        i22 = i19;
                                        i6 = i18;
                                        i68 = i6;
                                        unsafe2 = unsafe9;
                                        i7 = iZzi;
                                        i10 = i72;
                                        i70 = i22;
                                    }
                                    break;
                            }
                        } else {
                            i31 = i6;
                            i9 = i73;
                            i32 = i14;
                            i33 = i72;
                            i11 = 0;
                            i2 = i2;
                            i8 = i71;
                            if (iZzn == 27) {
                                if (iZzn <= 49) {
                                    j2 = i13;
                                    i68 = i31;
                                    unsafe3 = zzb;
                                    unsafe4 = unsafe9;
                                    zzezVar = (zzez) unsafe3.getObject(obj3, j);
                                    if (zzezVar.zzc()) {
                                        zzezVar2 = zzezVar;
                                    } else {
                                        int size2 = zzezVar.size();
                                        zzez zzezVarZzd2 = zzezVar.zzd(size2 != 0 ? size2 + size2 : 10);
                                        unsafe3.putObject(obj3, j, zzezVarZzd2);
                                        zzezVar2 = zzezVarZzd2;
                                    }
                                    switch (iZzn) {
                                        case 18:
                                        case 35:
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i33 = i33;
                                            i68 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            if (i12 == 2) {
                                                zzekVar2 = (zzek) zzezVar2;
                                                iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i39 = zzdtVar4.zza + iZzg;
                                                while (iZzg < i39) {
                                                    zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzg)));
                                                    iZzg += 8;
                                                }
                                                if (iZzg != i39) {
                                                    throw zzfb.zzf();
                                                }
                                            } else if (i12 == 1) {
                                                zzekVar = (zzek) zzezVar2;
                                                zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzi)));
                                                iZzg = iZzi + 8;
                                                while (iZzg < i2) {
                                                    iZzh = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh)));
                                                        iZzg = iZzh + 8;
                                                    }
                                                }
                                            } else {
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i33 = i33;
                                            i68 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            if (i12 == 2) {
                                                zzerVar2 = (zzer) zzezVar2;
                                                iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i40 = zzdtVar4.zza + iZzg;
                                                while (iZzg < i40) {
                                                    zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzg)));
                                                    iZzg += 4;
                                                }
                                                if (iZzg != i40) {
                                                    throw zzfb.zzf();
                                                }
                                            } else if (i12 == 5) {
                                                zzerVar = (zzer) zzezVar2;
                                                zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzi)));
                                                iZzg = iZzi + 4;
                                                while (iZzg < i2) {
                                                    iZzh2 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh2)));
                                                        iZzg = iZzh2 + 4;
                                                    }
                                                }
                                            } else {
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i33 = i33;
                                            i68 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            if (i12 == 2) {
                                                zzfmVar2 = (zzfm) zzezVar2;
                                                iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i41 = zzdtVar4.zza + iZzg;
                                                while (iZzg < i41) {
                                                    iZzg = zzdu.zzk(bArr, iZzg, zzdtVar4);
                                                    zzfmVar2.zze(zzdtVar4.zzb);
                                                }
                                                if (iZzg != i41) {
                                                    throw zzfb.zzf();
                                                }
                                            } else if (i12 == 0) {
                                                zzfmVar = (zzfm) zzezVar2;
                                                iZzg = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                                zzfmVar.zze(zzdtVar4.zzb);
                                                while (iZzg < i2) {
                                                    iZzh3 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        iZzg = zzdu.zzk(bArr, iZzh3, zzdtVar4);
                                                        zzfmVar.zze(zzdtVar4.zzb);
                                                    }
                                                }
                                            } else {
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i42 = i33;
                                            i43 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe6 = unsafe4;
                                            if (i12 == 2) {
                                                iZzf = zzdu.zzf(bArr, iZzi, zzezVar2, zzdtVar4);
                                                iZzg = iZzf;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                            } else if (i12 == 0) {
                                                iZzi = iZzi;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                iZzg = zzdu.zzj(i38, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                            } else {
                                                iZzi = iZzi;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i42 = i33;
                                            i43 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe6 = unsafe4;
                                            if (i12 == 2) {
                                                if (i12 == 1) {
                                                    zzfmVar3 = (zzfm) zzezVar2;
                                                    zzfmVar3.zze(zzdu.zzn(bArr, iZzi));
                                                    iZzf = iZzi + 8;
                                                    while (iZzf < i2) {
                                                        iZzh4 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                        if (i38 == zzdtVar4.zza) {
                                                            zzfmVar3.zze(zzdu.zzn(bArr, iZzh4));
                                                            iZzf = iZzh4 + 8;
                                                        }
                                                    }
                                                }
                                                iZzi = iZzi;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                zzfmVar4 = (zzfm) zzezVar2;
                                                iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i44 = zzdtVar4.zza + iZzf;
                                                while (iZzf < i44) {
                                                    zzfmVar4.zze(zzdu.zzn(bArr, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i44) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzf;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i42 = i33;
                                            i43 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe6 = unsafe4;
                                            if (i12 == 2) {
                                                if (i12 == 5) {
                                                    zzewVar = (zzew) zzezVar2;
                                                    zzewVar.zze(zzdu.zzb(bArr, iZzi));
                                                    iZzf = iZzi + 4;
                                                    while (iZzf < i2) {
                                                        iZzh5 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                        if (i38 == zzdtVar4.zza) {
                                                            zzewVar.zze(zzdu.zzb(bArr, iZzh5));
                                                            iZzf = iZzh5 + 4;
                                                        }
                                                    }
                                                }
                                                iZzi = iZzi;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                zzewVar2 = (zzew) zzezVar2;
                                                iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i45 = zzdtVar4.zza + iZzf;
                                                while (iZzf < i45) {
                                                    zzewVar2.zze(zzdu.zzb(bArr, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i45) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzf;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i42 = i33;
                                            i43 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe6 = unsafe4;
                                            if (i12 == 2) {
                                                if (i12 == 0) {
                                                    zzdvVar = (zzdv) zzezVar2;
                                                    iZzf = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                                    if (zzdtVar4.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    zzdvVar.zze(z2);
                                                    while (iZzf < i2) {
                                                        iZzh6 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                        if (i38 == zzdtVar4.zza) {
                                                            iZzf = zzdu.zzk(bArr, iZzh6, zzdtVar4);
                                                            if (zzdtVar4.zzb != 0) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            zzdvVar.zze(z3);
                                                        }
                                                    }
                                                }
                                                iZzi = iZzi;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                zzdvVar2 = (zzdv) zzezVar2;
                                                iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i46 = zzdtVar4.zza + iZzf;
                                                while (iZzf < i46) {
                                                    iZzf = zzdu.zzk(bArr, iZzf, zzdtVar4);
                                                    if (zzdtVar4.zzb != 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    zzdvVar2.zze(z4);
                                                }
                                                if (iZzf != i46) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzf;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 26:
                                            i42 = i33;
                                            i43 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe6 = unsafe4;
                                            if (i12 == 2) {
                                                if ((j2 & 536870912) == 0) {
                                                    iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                    i51 = zzdtVar4.zza;
                                                    if (i51 >= 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i51 == 0) {
                                                        obj2 = "";
                                                        zzezVar2.add(obj2);
                                                    } else {
                                                        obj2 = r3;
                                                        zzezVar2.add(new String(bArr, iZzf, i51, zzfa.zzb));
                                                        iZzf += i51;
                                                    }
                                                    while (iZzf < i2) {
                                                        iZzh8 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                        if (i38 == zzdtVar4.zza) {
                                                            iZzf = zzdu.zzh(bArr, iZzh8, zzdtVar4);
                                                            i52 = zzdtVar4.zza;
                                                            if (i52 >= 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i52 == 0) {
                                                                zzezVar2.add(obj2);
                                                            } else {
                                                                zzezVar2.add(new String(bArr, iZzf, i52, zzfa.zzb));
                                                                iZzf += i52;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                    i47 = zzdtVar4.zza;
                                                    if (i47 >= 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i47 == 0) {
                                                        zzezVar2.add(r3);
                                                    } else {
                                                        i48 = iZzf + i47;
                                                        if (zzhn.zzc(bArr, iZzf, i48)) {
                                                            throw zzfb.zzb();
                                                        }
                                                        zzezVar2.add(new String(bArr, iZzf, i47, zzfa.zzb));
                                                        iZzf = i48;
                                                    }
                                                    while (iZzf < i2) {
                                                        iZzh7 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                        if (i38 == zzdtVar4.zza) {
                                                            iZzf = zzdu.zzh(bArr, iZzh7, zzdtVar4);
                                                            i49 = zzdtVar4.zza;
                                                            if (i49 >= 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i49 == 0) {
                                                                zzezVar2.add(r3);
                                                            } else {
                                                                i50 = iZzf + i49;
                                                                if (zzhn.zzc(bArr, iZzf, i50)) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                zzezVar2.add(new String(bArr, iZzf, i49, zzfa.zzb));
                                                                iZzf = i50;
                                                            }
                                                        }
                                                    }
                                                }
                                                iZzg = iZzf;
                                                unsafe5 = unsafe6;
                                                i33 = i42;
                                                i68 = i43;
                                                i2 = i2;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            }
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 27:
                                            iZzi = iZzi;
                                            i8 = i8;
                                            if (i12 == 2) {
                                                this = this;
                                                i38 = i32;
                                                zzdtVar4 = zzdtVar4;
                                                i33 = i33;
                                                i68 = i68;
                                                i2 = i2;
                                                iZzg = zzdu.zze(this.zzr(i68), i32, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                                unsafe5 = unsafe4;
                                            } else {
                                                this = this;
                                                i38 = i32;
                                                i2 = i2;
                                                unsafe5 = unsafe4;
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 28:
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i8 = i8;
                                            if (i12 == 2) {
                                                iZzh9 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i53 = zzdtVar4.zza;
                                                if (i53 >= 0) {
                                                    throw zzfb.zzc();
                                                }
                                                if (i53 <= bArr.length - iZzh9) {
                                                    throw zzfb.zzf();
                                                }
                                                if (i53 == 0) {
                                                    zzezVar2.add(zzef.zzb);
                                                } else {
                                                    zzezVar2.add(zzef.zzk(bArr, iZzh9, i53));
                                                    iZzh9 += i53;
                                                }
                                                while (iZzh9 < i2) {
                                                    iZzh10 = zzdu.zzh(bArr, iZzh9, zzdtVar4);
                                                    if (i32 == zzdtVar4.zza) {
                                                        iZzg = iZzh9;
                                                        i38 = i32;
                                                        i68 = i68;
                                                        i2 = i2;
                                                        unsafe5 = unsafe4;
                                                        if (iZzg != iZzi) {
                                                            i3 = i3;
                                                            i70 = i38;
                                                            unsafe9 = unsafe5;
                                                            i72 = i33;
                                                            i69 = i68;
                                                            i68 = 0;
                                                            i71 = i8;
                                                            i73 = i9;
                                                            obj3 = obj;
                                                        } else {
                                                            i7 = iZzg;
                                                            i70 = i38;
                                                            unsafe2 = unsafe5;
                                                            i10 = i33;
                                                            i2 = i2;
                                                            obj3 = obj;
                                                            i3 = i3;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzh9 = zzdu.zzh(bArr, iZzh10, zzdtVar4);
                                                        i54 = zzdtVar4.zza;
                                                        if (i54 >= 0) {
                                                            throw zzfb.zzc();
                                                        }
                                                        if (i54 <= bArr.length - iZzh9) {
                                                            throw zzfb.zzf();
                                                        }
                                                        if (i54 == 0) {
                                                            zzezVar2.add(zzef.zzb);
                                                        } else {
                                                            zzezVar2.add(zzef.zzk(bArr, iZzh9, i54));
                                                            iZzh9 += i54;
                                                        }
                                                    }
                                                }
                                                iZzg = iZzh9;
                                                i38 = i32;
                                                i68 = i68;
                                                i2 = i2;
                                                unsafe5 = unsafe4;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                this = this;
                                                i38 = i32;
                                                i2 = i2;
                                                unsafe5 = unsafe4;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            if (i12 == 2) {
                                                iZzj = zzdu.zzf(bArr, iZzi, zzezVar2, zzdtVar4);
                                                iZzi = iZzi;
                                            } else if (i12 == 0) {
                                                this = this;
                                                i38 = i32;
                                                unsafe5 = unsafe4;
                                                i2 = i2;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                iZzi = iZzi;
                                                iZzj = zzdu.zzj(i32, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                            }
                                            zzeyVarZzq = this.zzq(i68);
                                            zzgzVar = this.zzl;
                                            int i82 = zzgk.zza;
                                            if (zzeyVarZzq != null) {
                                                i55 = iZzj;
                                                i56 = i68;
                                            } else if (zzezVar2 instanceof RandomAccess) {
                                                size = zzezVar2.size();
                                                i55 = iZzj;
                                                objZzc2 = null;
                                                i57 = 0;
                                                i58 = 0;
                                                while (i57 < size) {
                                                    num = (Integer) zzezVar2.get(i57);
                                                    int i83 = i68;
                                                    iIntValue2 = num.intValue();
                                                    if (zzeyVarZzq.zza()) {
                                                        if (i57 != i58) {
                                                            zzezVar2.set(i58, num);
                                                        }
                                                        i58++;
                                                    } else {
                                                        objZzc2 = zzgk.zzc(obj3, i33, iIntValue2, objZzc2, zzgzVar);
                                                    }
                                                    i57++;
                                                    i68 = i83;
                                                }
                                                i56 = i68;
                                                if (i58 != size) {
                                                    zzezVar2.subList(i58, size).clear();
                                                }
                                            } else {
                                                i55 = iZzj;
                                                i56 = i68;
                                                it2 = zzezVar2.iterator();
                                                objZzc = null;
                                                while (it2.hasNext()) {
                                                    iIntValue = ((Integer) it2.next()).intValue();
                                                    if (!zzeyVarZzq.zza()) {
                                                        objZzc = zzgk.zzc(obj3, i33, iIntValue, objZzc, zzgzVar);
                                                        it2.remove();
                                                    }
                                                }
                                            }
                                            iZzg = i55;
                                            i38 = i32;
                                            i68 = i56;
                                            i2 = i2;
                                            unsafe5 = unsafe4;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i59 = i32;
                                            if (i12 == 2) {
                                                zzewVar4 = (zzew) zzezVar2;
                                                iZzh11 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i60 = zzdtVar4.zza + iZzh11;
                                                while (iZzh11 < i60) {
                                                    iZzh11 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                    zzewVar4.zze(zzej.zzb(zzdtVar4.zza));
                                                }
                                                if (iZzh11 != i60) {
                                                    throw zzfb.zzf();
                                                }
                                            } else if (i12 == 0) {
                                                i38 = i59;
                                                unsafe5 = unsafe4;
                                                i2 = i2;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                                break;
                                            } else {
                                                zzewVar3 = (zzew) zzezVar2;
                                                iZzh11 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                zzewVar3.zze(zzej.zzb(zzdtVar4.zza));
                                                while (iZzh11 < i2) {
                                                    iZzh12 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                    if (i59 == zzdtVar4.zza) {
                                                        iZzh11 = zzdu.zzh(bArr, iZzh12, zzdtVar4);
                                                        zzewVar3.zze(zzej.zzb(zzdtVar4.zza));
                                                    }
                                                }
                                            }
                                            iZzg = iZzh11;
                                            i33 = i33;
                                            i38 = i59;
                                            i68 = i68;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            if (i12 == 2) {
                                                zzfmVar6 = (zzfm) zzezVar2;
                                                iZzh14 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i61 = zzdtVar4.zza + iZzh14;
                                                while (iZzh14 < i61) {
                                                    iZzh14 = zzdu.zzk(bArr, iZzh14, zzdtVar4);
                                                    zzfmVar6.zze(zzej.zzc(zzdtVar4.zzb));
                                                }
                                                if (iZzh14 == i61) {
                                                    throw zzfb.zzf();
                                                }
                                                iZzi = iZzi;
                                                iZzg = iZzh14;
                                                i2 = i2;
                                                i33 = i33;
                                                i68 = i68;
                                                i38 = i32;
                                                i8 = i8;
                                                unsafe5 = unsafe4;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else if (i12 == 0) {
                                                zzfmVar5 = (zzfm) zzezVar2;
                                                iZzh11 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                                zzfmVar5.zze(zzej.zzc(zzdtVar4.zzb));
                                                while (true) {
                                                    if (iZzh11 < i2) {
                                                        iZzh13 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                        i59 = i32;
                                                        if (i59 == zzdtVar4.zza) {
                                                            iZzh11 = zzdu.zzk(bArr, iZzh13, zzdtVar4);
                                                            zzfmVar5.zze(zzej.zzc(zzdtVar4.zzb));
                                                            i32 = i59;
                                                        }
                                                    } else {
                                                        i59 = i32;
                                                    }
                                                }
                                                iZzg = iZzh11;
                                                i33 = i33;
                                                i38 = i59;
                                                i68 = i68;
                                                i8 = i8;
                                                unsafe5 = unsafe4;
                                                i2 = i2;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            } else {
                                                iZzi = iZzi;
                                                i2 = i2;
                                                i38 = i32;
                                                i8 = i8;
                                                unsafe5 = unsafe4;
                                                iZzg = iZzi;
                                                if (iZzg != iZzi) {
                                                    i3 = i3;
                                                    i70 = i38;
                                                    unsafe9 = unsafe5;
                                                    i72 = i33;
                                                    i69 = i68;
                                                    i68 = 0;
                                                    i71 = i8;
                                                    i73 = i9;
                                                    obj3 = obj;
                                                } else {
                                                    i7 = iZzg;
                                                    i70 = i38;
                                                    unsafe2 = unsafe5;
                                                    i10 = i33;
                                                    i2 = i2;
                                                    obj3 = obj;
                                                    i3 = i3;
                                                }
                                            }
                                            break;
                                        default:
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i33 = i33;
                                            i68 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            if (i12 == 3) {
                                                zzgiVarZzr = this.zzr(i68);
                                                i62 = (i38 & (-8)) | 4;
                                                iZzg = zzdu.zzc(zzgiVarZzr, bArr, iZzi, i2, i62, zzdtVar);
                                                zzezVar2.add(zzdtVar4.zzc);
                                                while (iZzg < i2) {
                                                    iZzh15 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        iZzg = zzdu.zzc(zzgiVarZzr, bArr, iZzh15, i2, i62, zzdtVar);
                                                        zzezVar2.add(zzdtVar4.zzc);
                                                    }
                                                }
                                            } else {
                                                iZzg = iZzi;
                                            }
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                    }
                                } else {
                                    unsafe2 = unsafe9;
                                    i8 = i8;
                                    i36 = iZzi;
                                    i37 = i31;
                                    i34 = i33;
                                    if (iZzn == 50) {
                                        unsafe8 = zzb;
                                        j3 = iArr[i37 + 2] & 1048575;
                                        switch (iZzn) {
                                            case 51:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 1) {
                                                    unsafe8.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzdu.zzn(bArr, i63))));
                                                    iZzk = i63 + 8;
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i84 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i84;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 52:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 5) {
                                                    unsafe8.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzdu.zzb(bArr, i63))));
                                                    iZzk = i63 + 4;
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i85 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i85;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzk(bArr, i63, zzdtVar2);
                                                    unsafe8.putObject(obj3, j, Long.valueOf(zzdtVar2.zzb));
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i86 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i86;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzh(bArr, i63, zzdtVar2);
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(zzdtVar2.zza));
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i87 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i87;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 1) {
                                                    unsafe8.putObject(obj3, j, Long.valueOf(zzdu.zzn(bArr, i63)));
                                                    iZzk = i63 + 8;
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i88 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i88;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 5) {
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(zzdu.zzb(bArr, i63)));
                                                    iZzk = i63 + 4;
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i89 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i89;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 58:
                                                i22 = i32;
                                                zzdtVar2 = zzdtVar4;
                                                i64 = i37;
                                                i10 = i34;
                                                obj3 = obj;
                                                i2 = i2;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzk(bArr, i36, zzdtVar2);
                                                    i63 = i36;
                                                    if (zzdtVar2.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    unsafe8.putObject(obj3, j, Boolean.valueOf(z5));
                                                    unsafe8.putInt(obj3, j3, i10);
                                                } else {
                                                    i63 = i36;
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i810 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i810;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 59:
                                                obj3 = obj;
                                                i2 = i2;
                                                i64 = i37;
                                                i10 = i34;
                                                zzdtVar2 = zzdtVar4;
                                                if (i12 == 2) {
                                                    iZzk = zzdu.zzh(bArr, i36, zzdtVar2);
                                                    i65 = zzdtVar2.zza;
                                                    if (i65 == 0) {
                                                        unsafe8.putObject(obj3, j, "");
                                                    } else {
                                                        if ((i13 & PropertyOptions.DELETE_EXISTING) == 0 && !zzhn.zzc(bArr, iZzk, iZzk + i65)) {
                                                            throw zzfb.zzb();
                                                        }
                                                        unsafe8.putObject(obj3, j, new String(bArr, iZzk, i65, zzfa.zzb));
                                                        iZzk += i65;
                                                    }
                                                    unsafe8.putInt(obj3, j3, i10);
                                                    i22 = i32;
                                                    unsafe2 = unsafe2;
                                                    i63 = i36;
                                                } else {
                                                    i22 = i32;
                                                    unsafe2 = unsafe2;
                                                    i63 = i36;
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i811 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i811;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 60:
                                                obj3 = obj;
                                                if (i12 == 2) {
                                                    Object objZzu = this.zzu(obj3, i34, i37);
                                                    int iZzm2 = zzdu.zzm(objZzu, this.zzr(i37), bArr, i36, i2, zzdtVar);
                                                    this.zzC(obj3, i34, i37, objZzu);
                                                    zzdtVar2 = zzdtVar;
                                                    iZzk = iZzm2;
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i63 = i36;
                                                    i2 = i2;
                                                } else {
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i22 = i32;
                                                    i63 = i36;
                                                    i2 = i2;
                                                    zzdtVar2 = zzdtVar;
                                                    iZzk = i63;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i812 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i812;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 61:
                                                zzdtVar3 = zzdtVar4;
                                                obj3 = obj;
                                                i66 = i36;
                                                if (i12 == 2) {
                                                    iZzk = zzdu.zza(bArr, i66, zzdtVar3);
                                                    unsafe8.putObject(obj3, j, zzdtVar3.zzc);
                                                    unsafe8.putInt(obj3, j3, i34);
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i22 = i32;
                                                    i63 = i66;
                                                    i2 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (iZzk != i63) {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i3 = i3;
                                                        zzdtVar4 = zzdtVar2;
                                                        i2 = i2;
                                                        i69 = i64;
                                                        i68 = 0;
                                                        i70 = i22;
                                                        i71 = i8;
                                                        unsafe9 = unsafe2;
                                                        i73 = i9;
                                                        int i813 = iZzk;
                                                        i72 = i10;
                                                        iZzg = i813;
                                                    } else {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i7 = iZzk;
                                                        i68 = i64;
                                                        i70 = i22;
                                                    }
                                                }
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                iZzk = i63;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i814 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i814;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 63:
                                                zzdtVar3 = zzdtVar4;
                                                obj3 = obj;
                                                i66 = i36;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzh(bArr, i66, zzdtVar3);
                                                    i67 = zzdtVar3.zza;
                                                    zzeyVarZzq2 = this.zzq(i37);
                                                    if (zzeyVarZzq2 != null || zzeyVarZzq2.zza()) {
                                                        unsafe8.putObject(obj3, j, Integer.valueOf(i67));
                                                        unsafe8.putInt(obj3, j3, i34);
                                                    } else {
                                                        zzc(obj).zzh(i32, Long.valueOf(i67));
                                                    }
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i22 = i32;
                                                    i63 = i66;
                                                    i2 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (iZzk != i63) {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i3 = i3;
                                                        zzdtVar4 = zzdtVar2;
                                                        i2 = i2;
                                                        i69 = i64;
                                                        i68 = 0;
                                                        i70 = i22;
                                                        i71 = i8;
                                                        unsafe9 = unsafe2;
                                                        i73 = i9;
                                                        int i815 = iZzk;
                                                        i72 = i10;
                                                        iZzg = i815;
                                                    } else {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i7 = iZzk;
                                                        i68 = i64;
                                                        i70 = i22;
                                                    }
                                                }
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                iZzk = i63;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i816 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i816;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 66:
                                                zzdtVar3 = zzdtVar4;
                                                obj3 = obj;
                                                i66 = i36;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzh(bArr, i66, zzdtVar3);
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(zzej.zzb(zzdtVar3.zza)));
                                                    unsafe8.putInt(obj3, j3, i34);
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i22 = i32;
                                                    i63 = i66;
                                                    i2 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (iZzk != i63) {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i3 = i3;
                                                        zzdtVar4 = zzdtVar2;
                                                        i2 = i2;
                                                        i69 = i64;
                                                        i68 = 0;
                                                        i70 = i22;
                                                        i71 = i8;
                                                        unsafe9 = unsafe2;
                                                        i73 = i9;
                                                        int i817 = iZzk;
                                                        i72 = i10;
                                                        iZzg = i817;
                                                    } else {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i7 = iZzk;
                                                        i68 = i64;
                                                        i70 = i22;
                                                    }
                                                }
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                iZzk = i63;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i818 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i818;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 67:
                                                zzdtVar3 = zzdtVar4;
                                                obj3 = obj;
                                                i66 = i36;
                                                if (i12 == 0) {
                                                    iZzk = zzdu.zzk(bArr, i66, zzdtVar3);
                                                    unsafe8.putObject(obj3, j, Long.valueOf(zzej.zzc(zzdtVar3.zzb)));
                                                    unsafe8.putInt(obj3, j3, i34);
                                                    i64 = i37;
                                                    i10 = i34;
                                                    i22 = i32;
                                                    i63 = i66;
                                                    i2 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (iZzk != i63) {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i3 = i3;
                                                        zzdtVar4 = zzdtVar2;
                                                        i2 = i2;
                                                        i69 = i64;
                                                        i68 = 0;
                                                        i70 = i22;
                                                        i71 = i8;
                                                        unsafe9 = unsafe2;
                                                        i73 = i9;
                                                        int i819 = iZzk;
                                                        i72 = i10;
                                                        iZzg = i819;
                                                    } else {
                                                        i22 = i32;
                                                        i22 = i32;
                                                        i7 = iZzk;
                                                        i68 = i64;
                                                        i70 = i22;
                                                    }
                                                }
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                iZzk = i63;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i8110 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i8110;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                            case 68:
                                                if (i12 == 3) {
                                                    obj3 = obj;
                                                    Object objZzu2 = this.zzu(obj3, i34, i37);
                                                    int iZzl2 = zzdu.zzl(objZzu2, this.zzr(i37), bArr, i36, i2, (i32 & (-8)) | 4, zzdtVar);
                                                    this.zzC(obj3, i34, i37, objZzu2);
                                                    i64 = i37;
                                                    i10 = i34;
                                                    iZzk = iZzl2;
                                                    zzdtVar2 = zzdtVar4;
                                                    i63 = i36;
                                                    i2 = i2;
                                                }
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                    break;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i8111 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i8111;
                                                    break;
                                                }
                                            default:
                                                obj3 = obj;
                                                i2 = i2;
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i36;
                                                zzdtVar2 = zzdtVar4;
                                                iZzk = i63;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i8112 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i8112;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i12 == 2) {
                                            unsafe7 = zzb;
                                            Object objZzs = this.zzs(i37);
                                            object = unsafe7.getObject(obj, j);
                                            if (!((zzfr) object).zze()) {
                                                zzfr zzfrVarZzb = zzfr.zza().zzb();
                                                zzfs.zza(zzfrVarZzb, object);
                                                unsafe7.putObject(obj, j, zzfrVarZzb);
                                            }
                                            throw null;
                                        }
                                        i35 = i32;
                                        obj3 = obj;
                                        i3 = i3;
                                        i68 = i37;
                                        i10 = i34;
                                        i70 = i35;
                                        i7 = i36;
                                    }
                                }
                            } else if (i12 == 2) {
                                zzezVarZzd = (zzez) unsafe9.getObject(obj3, j);
                                if (!zzezVarZzd.zzc()) {
                                    int size3 = zzezVarZzd.size();
                                    zzezVarZzd = zzezVarZzd.zzd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe9.putObject(obj3, j, zzezVarZzd);
                                }
                                zzez zzezVar3 = zzezVarZzd;
                                i72 = i33;
                                iZzg = zzdu.zze(this.zzr(i31), i32, bArr, iZzi, i2, zzezVar3, zzdtVar);
                                i3 = i3;
                                unsafe9 = unsafe9;
                                zzdtVar4 = zzdtVar4;
                                i69 = i31;
                                i2 = i2;
                                i68 = 0;
                                i70 = i32;
                                i71 = i8;
                                i73 = i9;
                            } else {
                                i34 = i33;
                                unsafe2 = unsafe9;
                                i35 = i32;
                                i8 = i8;
                                i36 = iZzi;
                                i37 = i31;
                                i3 = i3;
                                i68 = i37;
                                i10 = i34;
                                i70 = i35;
                                i7 = i36;
                            }
                        }
                    } else {
                        i7 = iZzi;
                        i8 = i71;
                        i9 = i73;
                        i10 = i76;
                        i11 = i68;
                        unsafe2 = unsafe9;
                        i3 = i3;
                        i2 = i2;
                    }
                    if (i70 == i3 || i3 == 0) {
                        int i90 = i10;
                        iZzg = zzdu.zzg(i70, bArr, i7, i2, zzc(obj), zzdtVar);
                        i2 = i2;
                        i69 = i68;
                        i72 = i90;
                        i70 = i70;
                        unsafe9 = unsafe2;
                        i68 = i11;
                        i71 = i8;
                        i73 = i9;
                        zzdtVar4 = zzdtVar;
                        i3 = i3;
                    } else {
                        iZzg = i7;
                        i4 = i2;
                        i71 = i8;
                        unsafe = unsafe2;
                        i73 = i9;
                    }
                }
                i6 = iZzm;
                i5 = -1;
                if (i6 == i5) {
                    i12 = i70 & 7;
                    iArr = this.zzc;
                    i13 = iArr[i6 + 1];
                    i14 = i70;
                    iZzn = zzn(i13);
                    j = i13 & 1048575;
                    i72 = i76;
                    if (iZzn <= 17) {
                        int i711 = iArr[i6 + 2];
                        i15 = 1 << (i711 >>> 20);
                        i16 = 1048575;
                        i17 = i711 & 1048575;
                        if (i17 != i73) {
                            if (i73 != 1048575) {
                                unsafe9.putInt(obj3, i73, i71);
                                i16 = 1048575;
                            }
                            if (i17 == i16) {
                                i30 = 0;
                            } else {
                                i30 = unsafe9.getInt(obj3, i17);
                            }
                            i8 = i30;
                            i9 = i17;
                        } else {
                            i8 = i71;
                            i9 = i73;
                        }
                        switch (iZzn) {
                            case 0:
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 1) {
                                    zzhj.zzl(obj3, j, Double.longBitsToDouble(zzdu.zzn(bArr, iZzi)));
                                    iZzg = iZzi + 8;
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 1:
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 5) {
                                    zzhj.zzm(obj3, j, Float.intBitsToFloat(zzdu.zzb(bArr, iZzi)));
                                    iZzg = iZzi + 4;
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 2:
                            case 3:
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 0) {
                                    int iZzk4 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                    unsafe9.putLong(obj, j, zzdtVar4.zzb);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    iZzg = iZzk4;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 4:
                            case 11:
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 0) {
                                    iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                    unsafe9.putInt(obj3, j, zzdtVar4.zza);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 5:
                            case 14:
                                i21 = iZzi;
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 1) {
                                    unsafe9.putLong(obj, j, zzdu.zzn(bArr, i21));
                                    iZzg = i21 + 8;
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    iZzi = i21;
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 6:
                            case 13:
                                i21 = iZzi;
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 5) {
                                    unsafe9.putInt(obj3, j, zzdu.zzb(bArr, i21));
                                    iZzg = i21 + 4;
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    iZzi = i21;
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 7:
                                i21 = iZzi;
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 0) {
                                    iZzg = zzdu.zzk(bArr, i21, zzdtVar4);
                                    if (zzdtVar4.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzhj.zzk(obj3, j, z);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    iZzi = i21;
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 8:
                                i23 = iZzi;
                                i18 = i6;
                                i19 = i14;
                                if (i12 == 2) {
                                    if ((i13 & PropertyOptions.DELETE_EXISTING) != 0) {
                                        iZzg = zzdu.zzh(bArr, i23, zzdtVar4);
                                        i25 = zzdtVar4.zza;
                                        if (i25 >= 0) {
                                            throw zzfb.zzc();
                                        }
                                        if (i25 == 0) {
                                            zzdtVar4.zzc = "";
                                            i20 = 0;
                                        } else {
                                            int i712 = zzhn.zza;
                                            length = bArr.length;
                                            if ((((length - iZzg) - i25) | iZzg | i25) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i25)));
                                            }
                                            i26 = iZzg + i25;
                                            cArr = new char[i25];
                                            i27 = 0;
                                            while (iZzg < i26) {
                                                b3 = bArr[iZzg];
                                                if (zzhk.zzd(b3)) {
                                                    iZzg++;
                                                    cArr[i27] = (char) b3;
                                                    i27++;
                                                } else {
                                                    while (iZzg < i26) {
                                                        i28 = iZzg + 1;
                                                        b = bArr[iZzg];
                                                        if (zzhk.zzd(b)) {
                                                            cArr[i27] = (char) b;
                                                            i27++;
                                                            iZzg = i28;
                                                            while (iZzg < i26) {
                                                                b2 = bArr[iZzg];
                                                                if (zzhk.zzd(b2)) {
                                                                }
                                                                iZzg++;
                                                                cArr[i27] = (char) b2;
                                                                i27++;
                                                                break;
                                                            }
                                                        } else if (b < -32) {
                                                            if (i28 < i26) {
                                                                throw zzfb.zzb();
                                                            }
                                                            iZzg += 2;
                                                            zzhk.zzc(b, bArr[i28], cArr, i27);
                                                            i27++;
                                                        } else if (b < -16) {
                                                            if (i28 < i26 - 1) {
                                                                throw zzfb.zzb();
                                                            }
                                                            int i713 = iZzg + 2;
                                                            iZzg += 3;
                                                            zzhk.zzb(b, bArr[i28], bArr[i713], cArr, i27);
                                                            i27++;
                                                        } else {
                                                            if (i28 < i26 - 2) {
                                                                throw zzfb.zzb();
                                                            }
                                                            byte b8 = bArr[i28];
                                                            int i820 = iZzg + 3;
                                                            byte b9 = bArr[iZzg + 2];
                                                            iZzg += 4;
                                                            zzhk.zza(b, b8, b9, bArr[i820], cArr, i27);
                                                            i27 += 2;
                                                        }
                                                    }
                                                    i20 = 0;
                                                    zzdtVar4.zzc = new String(cArr, 0, i27);
                                                    iZzg = i26;
                                                }
                                            }
                                            while (iZzg < i26) {
                                                i28 = iZzg + 1;
                                                b = bArr[iZzg];
                                                if (zzhk.zzd(b)) {
                                                    cArr[i27] = (char) b;
                                                    i27++;
                                                    iZzg = i28;
                                                    while (iZzg < i26) {
                                                        b2 = bArr[iZzg];
                                                        if (zzhk.zzd(b2)) {
                                                        }
                                                        iZzg++;
                                                        cArr[i27] = (char) b2;
                                                        i27++;
                                                        break;
                                                    }
                                                } else if (b < -32) {
                                                    if (i28 < i26) {
                                                        throw zzfb.zzb();
                                                    }
                                                    iZzg += 2;
                                                    zzhk.zzc(b, bArr[i28], cArr, i27);
                                                    i27++;
                                                } else if (b < -16) {
                                                    if (i28 < i26 - 1) {
                                                        throw zzfb.zzb();
                                                    }
                                                    int i714 = iZzg + 2;
                                                    iZzg += 3;
                                                    zzhk.zzb(b, bArr[i28], bArr[i714], cArr, i27);
                                                    i27++;
                                                } else {
                                                    if (i28 < i26 - 2) {
                                                        throw zzfb.zzb();
                                                    }
                                                    byte b10 = bArr[i28];
                                                    int i821 = iZzg + 3;
                                                    byte b11 = bArr[iZzg + 2];
                                                    iZzg += 4;
                                                    zzhk.zza(b, b10, b11, bArr[i821], cArr, i27);
                                                    i27 += 2;
                                                }
                                            }
                                            i20 = 0;
                                            zzdtVar4.zzc = new String(cArr, 0, i27);
                                            iZzg = i26;
                                        }
                                    } else {
                                        i20 = 0;
                                        iZzg = zzdu.zzh(bArr, i23, zzdtVar4);
                                        i24 = zzdtVar4.zza;
                                        if (i24 >= 0) {
                                            throw zzfb.zzc();
                                        }
                                        if (i24 == 0) {
                                            zzdtVar4.zzc = "";
                                        } else {
                                            zzdtVar4.zzc = new String(bArr, iZzg, i24, zzfa.zzb);
                                            iZzg += i24;
                                        }
                                    }
                                    unsafe9.putObject(obj3, j, zzdtVar4.zzc);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i72 = i72;
                                    i73 = i9;
                                    i68 = i20;
                                } else {
                                    iZzi = i23;
                                    i22 = i19;
                                    i6 = i18;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 9:
                                i18 = i6;
                                i19 = i14;
                                if (i12 == 2) {
                                    Object objZzt3 = this.zzt(obj3, i18);
                                    iZzg = zzdu.zzm(objZzt3, this.zzr(i18), bArr, iZzi, i2, zzdtVar);
                                    this.zzB(obj3, i18, objZzt3);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i73 = i9;
                                    i68 = 0;
                                } else {
                                    i22 = i19;
                                    i6 = i18;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 10:
                                i18 = i6;
                                i19 = i14;
                                if (i12 == 2) {
                                    iZzg = zzdu.zza(bArr, iZzi, zzdtVar4);
                                    unsafe9.putObject(obj3, j, zzdtVar4.zzc);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i73 = i9;
                                    i68 = 0;
                                } else {
                                    i22 = i19;
                                    i6 = i18;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 12:
                                i18 = i6;
                                i19 = i14;
                                if (i12 == 0) {
                                    iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                    i29 = zzdtVar4.zza;
                                    zzey zzeyVarZzq4 = this.zzq(i18);
                                    if ((i13 & Integer.MIN_VALUE) != 0) {
                                    }
                                    unsafe9.putInt(obj3, j, i29);
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i73 = i9;
                                    i68 = 0;
                                } else {
                                    i22 = i19;
                                    i6 = i18;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 15:
                                i18 = i6;
                                i19 = i14;
                                if (i12 == 0) {
                                    iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                    unsafe9.putInt(obj3, j, zzej.zzb(zzdtVar4.zza));
                                    i71 = i8 | i15;
                                    i70 = i19;
                                    i69 = i18;
                                    i73 = i9;
                                    i68 = 0;
                                } else {
                                    i22 = i19;
                                    i6 = i18;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            case 16:
                                if (i12 == 0) {
                                    int iZzk5 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                    i18 = i6;
                                    i19 = i14;
                                    unsafe9.putLong(obj, j, zzej.zzc(zzdtVar4.zzb));
                                    i71 = i8 | i15;
                                    iZzg = iZzk5;
                                    i70 = i19;
                                    i69 = i18;
                                    i73 = i9;
                                    i68 = 0;
                                } else {
                                    i2 = i2;
                                    i22 = i14;
                                    i11 = 0;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                            default:
                                i18 = i6;
                                i19 = i14;
                                i20 = 0;
                                if (i12 == 3) {
                                    Object objZzt4 = this.zzt(obj3, i18);
                                    i69 = i18;
                                    int iZzl3 = zzdu.zzl(objZzt4, this.zzr(i18), bArr, iZzi, i2, (i72 << 3) | 4, zzdtVar);
                                    this.zzB(obj3, i69, objZzt4);
                                    i3 = i3;
                                    zzdtVar4 = zzdtVar4;
                                    unsafe9 = unsafe9;
                                    i2 = i2;
                                    iZzg = iZzl3;
                                    i68 = 0;
                                    i73 = i9;
                                    i71 = i8 | i15;
                                    i72 = i72;
                                    i70 = i19;
                                } else {
                                    i11 = i20;
                                    i22 = i19;
                                    i6 = i18;
                                    i68 = i6;
                                    unsafe2 = unsafe9;
                                    i7 = iZzi;
                                    i10 = i72;
                                    i70 = i22;
                                }
                                break;
                        }
                    } else {
                        i31 = i6;
                        i9 = i73;
                        i32 = i14;
                        i33 = i72;
                        i11 = 0;
                        i2 = i2;
                        i8 = i71;
                        if (iZzn == 27) {
                            if (iZzn <= 49) {
                                j2 = i13;
                                i68 = i31;
                                unsafe3 = zzb;
                                unsafe4 = unsafe9;
                                zzezVar = (zzez) unsafe3.getObject(obj3, j);
                                if (zzezVar.zzc()) {
                                    int size4 = zzezVar.size();
                                    zzez zzezVarZzd3 = zzezVar.zzd(size4 != 0 ? size4 + size4 : 10);
                                    unsafe3.putObject(obj3, j, zzezVarZzd3);
                                    zzezVar2 = zzezVarZzd3;
                                } else {
                                    zzezVar2 = zzezVar;
                                }
                                switch (iZzn) {
                                    case 18:
                                    case 35:
                                        iZzi = iZzi;
                                        i2 = i2;
                                        i33 = i33;
                                        i68 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe5 = unsafe4;
                                        if (i12 == 2) {
                                            zzekVar2 = (zzek) zzezVar2;
                                            iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i39 = zzdtVar4.zza + iZzg;
                                            while (iZzg < i39) {
                                                zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzg)));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i39) {
                                                throw zzfb.zzf();
                                            }
                                        } else if (i12 == 1) {
                                            zzekVar = (zzek) zzezVar2;
                                            zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzi)));
                                            iZzg = iZzi + 8;
                                            while (iZzg < i2) {
                                                iZzh = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                if (i38 == zzdtVar4.zza) {
                                                    zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh)));
                                                    iZzg = iZzh + 8;
                                                }
                                            }
                                        } else {
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        iZzi = iZzi;
                                        i2 = i2;
                                        i33 = i33;
                                        i68 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe5 = unsafe4;
                                        if (i12 == 2) {
                                            zzerVar2 = (zzer) zzezVar2;
                                            iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i40 = zzdtVar4.zza + iZzg;
                                            while (iZzg < i40) {
                                                zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzg)));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i40) {
                                                throw zzfb.zzf();
                                            }
                                        } else if (i12 == 5) {
                                            zzerVar = (zzer) zzezVar2;
                                            zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzi)));
                                            iZzg = iZzi + 4;
                                            while (iZzg < i2) {
                                                iZzh2 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                if (i38 == zzdtVar4.zza) {
                                                    zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh2)));
                                                    iZzg = iZzh2 + 4;
                                                }
                                            }
                                        } else {
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        iZzi = iZzi;
                                        i2 = i2;
                                        i33 = i33;
                                        i68 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe5 = unsafe4;
                                        if (i12 == 2) {
                                            zzfmVar2 = (zzfm) zzezVar2;
                                            iZzg = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i41 = zzdtVar4.zza + iZzg;
                                            while (iZzg < i41) {
                                                iZzg = zzdu.zzk(bArr, iZzg, zzdtVar4);
                                                zzfmVar2.zze(zzdtVar4.zzb);
                                            }
                                            if (iZzg != i41) {
                                                throw zzfb.zzf();
                                            }
                                        } else if (i12 == 0) {
                                            zzfmVar = (zzfm) zzezVar2;
                                            iZzg = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                            zzfmVar.zze(zzdtVar4.zzb);
                                            while (iZzg < i2) {
                                                iZzh3 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                if (i38 == zzdtVar4.zza) {
                                                    iZzg = zzdu.zzk(bArr, iZzh3, zzdtVar4);
                                                    zzfmVar.zze(zzdtVar4.zzb);
                                                }
                                            }
                                        } else {
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i42 = i33;
                                        i43 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe6 = unsafe4;
                                        if (i12 == 2) {
                                            iZzf = zzdu.zzf(bArr, iZzi, zzezVar2, zzdtVar4);
                                            iZzg = iZzf;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                        } else if (i12 == 0) {
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = zzdu.zzj(i38, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                        } else {
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i42 = i33;
                                        i43 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe6 = unsafe4;
                                        if (i12 == 2) {
                                            if (i12 == 1) {
                                                zzfmVar3 = (zzfm) zzezVar2;
                                                zzfmVar3.zze(zzdu.zzn(bArr, iZzi));
                                                iZzf = iZzi + 8;
                                                while (iZzf < i2) {
                                                    iZzh4 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        zzfmVar3.zze(zzdu.zzn(bArr, iZzh4));
                                                        iZzf = iZzh4 + 8;
                                                    }
                                                }
                                            }
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            zzfmVar4 = (zzfm) zzezVar2;
                                            iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i44 = zzdtVar4.zza + iZzf;
                                            while (iZzf < i44) {
                                                zzfmVar4.zze(zzdu.zzn(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i44) {
                                                throw zzfb.zzf();
                                            }
                                        }
                                        iZzg = iZzf;
                                        unsafe5 = unsafe6;
                                        i33 = i42;
                                        i68 = i43;
                                        i2 = i2;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i42 = i33;
                                        i43 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe6 = unsafe4;
                                        if (i12 == 2) {
                                            if (i12 == 5) {
                                                zzewVar = (zzew) zzezVar2;
                                                zzewVar.zze(zzdu.zzb(bArr, iZzi));
                                                iZzf = iZzi + 4;
                                                while (iZzf < i2) {
                                                    iZzh5 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        zzewVar.zze(zzdu.zzb(bArr, iZzh5));
                                                        iZzf = iZzh5 + 4;
                                                    }
                                                }
                                            }
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            zzewVar2 = (zzew) zzezVar2;
                                            iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i45 = zzdtVar4.zza + iZzf;
                                            while (iZzf < i45) {
                                                zzewVar2.zze(zzdu.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i45) {
                                                throw zzfb.zzf();
                                            }
                                        }
                                        iZzg = iZzf;
                                        unsafe5 = unsafe6;
                                        i33 = i42;
                                        i68 = i43;
                                        i2 = i2;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i42 = i33;
                                        i43 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe6 = unsafe4;
                                        if (i12 == 2) {
                                            if (i12 == 0) {
                                                zzdvVar = (zzdv) zzezVar2;
                                                iZzf = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                                if (zzdtVar4.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                zzdvVar.zze(z2);
                                                while (iZzf < i2) {
                                                    iZzh6 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        iZzf = zzdu.zzk(bArr, iZzh6, zzdtVar4);
                                                        if (zzdtVar4.zzb != 0) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        zzdvVar.zze(z3);
                                                    }
                                                }
                                            }
                                            iZzi = iZzi;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            zzdvVar2 = (zzdv) zzezVar2;
                                            iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i46 = zzdtVar4.zza + iZzf;
                                            while (iZzf < i46) {
                                                iZzf = zzdu.zzk(bArr, iZzf, zzdtVar4);
                                                if (zzdtVar4.zzb != 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                zzdvVar2.zze(z4);
                                            }
                                            if (iZzf != i46) {
                                                throw zzfb.zzf();
                                            }
                                        }
                                        iZzg = iZzf;
                                        unsafe5 = unsafe6;
                                        i33 = i42;
                                        i68 = i43;
                                        i2 = i2;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 26:
                                        i42 = i33;
                                        i43 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe6 = unsafe4;
                                        if (i12 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i51 = zzdtVar4.zza;
                                                if (i51 >= 0) {
                                                    throw zzfb.zzc();
                                                }
                                                if (i51 == 0) {
                                                    obj2 = "";
                                                    zzezVar2.add(obj2);
                                                } else {
                                                    obj2 = r3;
                                                    zzezVar2.add(new String(bArr, iZzf, i51, zzfa.zzb));
                                                    iZzf += i51;
                                                }
                                                while (iZzf < i2) {
                                                    iZzh8 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        iZzf = zzdu.zzh(bArr, iZzh8, zzdtVar4);
                                                        i52 = zzdtVar4.zza;
                                                        if (i52 >= 0) {
                                                            throw zzfb.zzc();
                                                        }
                                                        if (i52 == 0) {
                                                            zzezVar2.add(obj2);
                                                        } else {
                                                            zzezVar2.add(new String(bArr, iZzf, i52, zzfa.zzb));
                                                            iZzf += i52;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzf = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                                i47 = zzdtVar4.zza;
                                                if (i47 >= 0) {
                                                    throw zzfb.zzc();
                                                }
                                                if (i47 == 0) {
                                                    zzezVar2.add(r3);
                                                } else {
                                                    i48 = iZzf + i47;
                                                    if (zzhn.zzc(bArr, iZzf, i48)) {
                                                        throw zzfb.zzb();
                                                    }
                                                    zzezVar2.add(new String(bArr, iZzf, i47, zzfa.zzb));
                                                    iZzf = i48;
                                                }
                                                while (iZzf < i2) {
                                                    iZzh7 = zzdu.zzh(bArr, iZzf, zzdtVar4);
                                                    if (i38 == zzdtVar4.zza) {
                                                        iZzf = zzdu.zzh(bArr, iZzh7, zzdtVar4);
                                                        i49 = zzdtVar4.zza;
                                                        if (i49 >= 0) {
                                                            throw zzfb.zzc();
                                                        }
                                                        if (i49 == 0) {
                                                            zzezVar2.add(r3);
                                                        } else {
                                                            i50 = iZzf + i49;
                                                            if (zzhn.zzc(bArr, iZzf, i50)) {
                                                                throw zzfb.zzb();
                                                            }
                                                            zzezVar2.add(new String(bArr, iZzf, i49, zzfa.zzb));
                                                            iZzf = i50;
                                                        }
                                                    }
                                                }
                                            }
                                            iZzg = iZzf;
                                            unsafe5 = unsafe6;
                                            i33 = i42;
                                            i68 = i43;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        }
                                        iZzi = iZzi;
                                        unsafe5 = unsafe6;
                                        i33 = i42;
                                        i68 = i43;
                                        i2 = i2;
                                        iZzg = iZzi;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 27:
                                        iZzi = iZzi;
                                        i8 = i8;
                                        if (i12 == 2) {
                                            this = this;
                                            i38 = i32;
                                            zzdtVar4 = zzdtVar4;
                                            i33 = i33;
                                            i68 = i68;
                                            i2 = i2;
                                            iZzg = zzdu.zze(this.zzr(i68), i32, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                            unsafe5 = unsafe4;
                                        } else {
                                            this = this;
                                            i38 = i32;
                                            i2 = i2;
                                            unsafe5 = unsafe4;
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 28:
                                        iZzi = iZzi;
                                        i2 = i2;
                                        i8 = i8;
                                        if (i12 == 2) {
                                            iZzh9 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i53 = zzdtVar4.zza;
                                            if (i53 >= 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i53 <= bArr.length - iZzh9) {
                                                throw zzfb.zzf();
                                            }
                                            if (i53 == 0) {
                                                zzezVar2.add(zzef.zzb);
                                            } else {
                                                zzezVar2.add(zzef.zzk(bArr, iZzh9, i53));
                                                iZzh9 += i53;
                                            }
                                            while (iZzh9 < i2) {
                                                iZzh10 = zzdu.zzh(bArr, iZzh9, zzdtVar4);
                                                if (i32 == zzdtVar4.zza) {
                                                    iZzg = iZzh9;
                                                    i38 = i32;
                                                    i68 = i68;
                                                    i2 = i2;
                                                    unsafe5 = unsafe4;
                                                    if (iZzg != iZzi) {
                                                        i3 = i3;
                                                        i70 = i38;
                                                        unsafe9 = unsafe5;
                                                        i72 = i33;
                                                        i69 = i68;
                                                        i68 = 0;
                                                        i71 = i8;
                                                        i73 = i9;
                                                        obj3 = obj;
                                                    } else {
                                                        i7 = iZzg;
                                                        i70 = i38;
                                                        unsafe2 = unsafe5;
                                                        i10 = i33;
                                                        i2 = i2;
                                                        obj3 = obj;
                                                        i3 = i3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzh9 = zzdu.zzh(bArr, iZzh10, zzdtVar4);
                                                    i54 = zzdtVar4.zza;
                                                    if (i54 >= 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i54 <= bArr.length - iZzh9) {
                                                        throw zzfb.zzf();
                                                    }
                                                    if (i54 == 0) {
                                                        zzezVar2.add(zzef.zzb);
                                                    } else {
                                                        zzezVar2.add(zzef.zzk(bArr, iZzh9, i54));
                                                        iZzh9 += i54;
                                                    }
                                                }
                                            }
                                            iZzg = iZzh9;
                                            i38 = i32;
                                            i68 = i68;
                                            i2 = i2;
                                            unsafe5 = unsafe4;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            this = this;
                                            i38 = i32;
                                            i2 = i2;
                                            unsafe5 = unsafe4;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        if (i12 == 2) {
                                            iZzj = zzdu.zzf(bArr, iZzi, zzezVar2, zzdtVar4);
                                            iZzi = iZzi;
                                        } else if (i12 == 0) {
                                            this = this;
                                            i38 = i32;
                                            unsafe5 = unsafe4;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            iZzi = iZzi;
                                            iZzj = zzdu.zzj(i32, bArr, iZzi, i2, zzezVar2, zzdtVar);
                                        }
                                        zzeyVarZzq = this.zzq(i68);
                                        zzgzVar = this.zzl;
                                        int i822 = zzgk.zza;
                                        if (zzeyVarZzq != null) {
                                            i55 = iZzj;
                                            i56 = i68;
                                        } else if (zzezVar2 instanceof RandomAccess) {
                                            size = zzezVar2.size();
                                            i55 = iZzj;
                                            objZzc2 = null;
                                            i57 = 0;
                                            i58 = 0;
                                            while (i57 < size) {
                                                num = (Integer) zzezVar2.get(i57);
                                                int i823 = i68;
                                                iIntValue2 = num.intValue();
                                                if (zzeyVarZzq.zza()) {
                                                    if (i57 != i58) {
                                                        zzezVar2.set(i58, num);
                                                    }
                                                    i58++;
                                                } else {
                                                    objZzc2 = zzgk.zzc(obj3, i33, iIntValue2, objZzc2, zzgzVar);
                                                }
                                                i57++;
                                                i68 = i823;
                                            }
                                            i56 = i68;
                                            if (i58 != size) {
                                                zzezVar2.subList(i58, size).clear();
                                            }
                                        } else {
                                            i55 = iZzj;
                                            i56 = i68;
                                            it2 = zzezVar2.iterator();
                                            objZzc = null;
                                            while (it2.hasNext()) {
                                                iIntValue = ((Integer) it2.next()).intValue();
                                                if (!zzeyVarZzq.zza()) {
                                                    objZzc = zzgk.zzc(obj3, i33, iIntValue, objZzc, zzgzVar);
                                                    it2.remove();
                                                }
                                            }
                                        }
                                        iZzg = i55;
                                        i38 = i32;
                                        i68 = i56;
                                        i2 = i2;
                                        unsafe5 = unsafe4;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i59 = i32;
                                        if (i12 == 2) {
                                            zzewVar4 = (zzew) zzezVar2;
                                            iZzh11 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i60 = zzdtVar4.zza + iZzh11;
                                            while (iZzh11 < i60) {
                                                iZzh11 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                zzewVar4.zze(zzej.zzb(zzdtVar4.zza));
                                            }
                                            if (iZzh11 != i60) {
                                                throw zzfb.zzf();
                                            }
                                        } else if (i12 == 0) {
                                            i38 = i59;
                                            unsafe5 = unsafe4;
                                            i2 = i2;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                            break;
                                        } else {
                                            zzewVar3 = (zzew) zzezVar2;
                                            iZzh11 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            zzewVar3.zze(zzej.zzb(zzdtVar4.zza));
                                            while (iZzh11 < i2) {
                                                iZzh12 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                if (i59 == zzdtVar4.zza) {
                                                    iZzh11 = zzdu.zzh(bArr, iZzh12, zzdtVar4);
                                                    zzewVar3.zze(zzej.zzb(zzdtVar4.zza));
                                                }
                                            }
                                        }
                                        iZzg = iZzh11;
                                        i33 = i33;
                                        i38 = i59;
                                        i68 = i68;
                                        i8 = i8;
                                        unsafe5 = unsafe4;
                                        i2 = i2;
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        if (i12 == 2) {
                                            zzfmVar6 = (zzfm) zzezVar2;
                                            iZzh14 = zzdu.zzh(bArr, iZzi, zzdtVar4);
                                            i61 = zzdtVar4.zza + iZzh14;
                                            while (iZzh14 < i61) {
                                                iZzh14 = zzdu.zzk(bArr, iZzh14, zzdtVar4);
                                                zzfmVar6.zze(zzej.zzc(zzdtVar4.zzb));
                                            }
                                            if (iZzh14 == i61) {
                                                throw zzfb.zzf();
                                            }
                                            iZzi = iZzi;
                                            iZzg = iZzh14;
                                            i2 = i2;
                                            i33 = i33;
                                            i68 = i68;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else if (i12 == 0) {
                                            zzfmVar5 = (zzfm) zzezVar2;
                                            iZzh11 = zzdu.zzk(bArr, iZzi, zzdtVar4);
                                            zzfmVar5.zze(zzej.zzc(zzdtVar4.zzb));
                                            while (true) {
                                                if (iZzh11 < i2) {
                                                    iZzh13 = zzdu.zzh(bArr, iZzh11, zzdtVar4);
                                                    i59 = i32;
                                                    if (i59 == zzdtVar4.zza) {
                                                        iZzh11 = zzdu.zzk(bArr, iZzh13, zzdtVar4);
                                                        zzfmVar5.zze(zzej.zzc(zzdtVar4.zzb));
                                                        i32 = i59;
                                                    }
                                                } else {
                                                    i59 = i32;
                                                }
                                            }
                                            iZzg = iZzh11;
                                            i33 = i33;
                                            i38 = i59;
                                            i68 = i68;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            i2 = i2;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        } else {
                                            iZzi = iZzi;
                                            i2 = i2;
                                            i38 = i32;
                                            i8 = i8;
                                            unsafe5 = unsafe4;
                                            iZzg = iZzi;
                                            if (iZzg != iZzi) {
                                                i3 = i3;
                                                i70 = i38;
                                                unsafe9 = unsafe5;
                                                i72 = i33;
                                                i69 = i68;
                                                i68 = 0;
                                                i71 = i8;
                                                i73 = i9;
                                                obj3 = obj;
                                            } else {
                                                i7 = iZzg;
                                                i70 = i38;
                                                unsafe2 = unsafe5;
                                                i10 = i33;
                                                i2 = i2;
                                                obj3 = obj;
                                                i3 = i3;
                                            }
                                        }
                                        break;
                                    default:
                                        iZzi = iZzi;
                                        i2 = i2;
                                        i33 = i33;
                                        i68 = i68;
                                        i38 = i32;
                                        i8 = i8;
                                        unsafe5 = unsafe4;
                                        if (i12 == 3) {
                                            zzgiVarZzr = this.zzr(i68);
                                            i62 = (i38 & (-8)) | 4;
                                            iZzg = zzdu.zzc(zzgiVarZzr, bArr, iZzi, i2, i62, zzdtVar);
                                            zzezVar2.add(zzdtVar4.zzc);
                                            while (iZzg < i2) {
                                                iZzh15 = zzdu.zzh(bArr, iZzg, zzdtVar4);
                                                if (i38 == zzdtVar4.zza) {
                                                    iZzg = zzdu.zzc(zzgiVarZzr, bArr, iZzh15, i2, i62, zzdtVar);
                                                    zzezVar2.add(zzdtVar4.zzc);
                                                }
                                            }
                                        } else {
                                            iZzg = iZzi;
                                        }
                                        if (iZzg != iZzi) {
                                            i3 = i3;
                                            i70 = i38;
                                            unsafe9 = unsafe5;
                                            i72 = i33;
                                            i69 = i68;
                                            i68 = 0;
                                            i71 = i8;
                                            i73 = i9;
                                            obj3 = obj;
                                        } else {
                                            i7 = iZzg;
                                            i70 = i38;
                                            unsafe2 = unsafe5;
                                            i10 = i33;
                                            i2 = i2;
                                            obj3 = obj;
                                            i3 = i3;
                                        }
                                        break;
                                }
                            } else {
                                unsafe2 = unsafe9;
                                i8 = i8;
                                i36 = iZzi;
                                i37 = i31;
                                i34 = i33;
                                if (iZzn == 50) {
                                    unsafe8 = zzb;
                                    j3 = iArr[i37 + 2] & 1048575;
                                    switch (iZzn) {
                                        case 51:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 1) {
                                                unsafe8.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzdu.zzn(bArr, i63))));
                                                iZzk = i63 + 8;
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8113 = iZzk;
                                                i72 = i10;
                                                iZzg = i8113;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 52:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 5) {
                                                unsafe8.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzdu.zzb(bArr, i63))));
                                                iZzk = i63 + 4;
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8114 = iZzk;
                                                i72 = i10;
                                                iZzg = i8114;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzk(bArr, i63, zzdtVar2);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzdtVar2.zzb));
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8115 = iZzk;
                                                i72 = i10;
                                                iZzg = i8115;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzh(bArr, i63, zzdtVar2);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzdtVar2.zza));
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8116 = iZzk;
                                                i72 = i10;
                                                iZzg = i8116;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 1) {
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzdu.zzn(bArr, i63)));
                                                iZzk = i63 + 8;
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8117 = iZzk;
                                                i72 = i10;
                                                iZzg = i8117;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 5) {
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzdu.zzb(bArr, i63)));
                                                iZzk = i63 + 4;
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8118 = iZzk;
                                                i72 = i10;
                                                iZzg = i8118;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 58:
                                            i22 = i32;
                                            zzdtVar2 = zzdtVar4;
                                            i64 = i37;
                                            i10 = i34;
                                            obj3 = obj;
                                            i2 = i2;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzk(bArr, i36, zzdtVar2);
                                                i63 = i36;
                                                if (zzdtVar2.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                unsafe8.putObject(obj3, j, Boolean.valueOf(z5));
                                                unsafe8.putInt(obj3, j3, i10);
                                            } else {
                                                i63 = i36;
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i8119 = iZzk;
                                                i72 = i10;
                                                iZzg = i8119;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 59:
                                            obj3 = obj;
                                            i2 = i2;
                                            i64 = i37;
                                            i10 = i34;
                                            zzdtVar2 = zzdtVar4;
                                            if (i12 == 2) {
                                                iZzk = zzdu.zzh(bArr, i36, zzdtVar2);
                                                i65 = zzdtVar2.zza;
                                                if (i65 == 0) {
                                                    unsafe8.putObject(obj3, j, "");
                                                } else {
                                                    if ((i13 & PropertyOptions.DELETE_EXISTING) == 0) {
                                                    }
                                                    unsafe8.putObject(obj3, j, new String(bArr, iZzk, i65, zzfa.zzb));
                                                    iZzk += i65;
                                                }
                                                unsafe8.putInt(obj3, j3, i10);
                                                i22 = i32;
                                                unsafe2 = unsafe2;
                                                i63 = i36;
                                            } else {
                                                i22 = i32;
                                                unsafe2 = unsafe2;
                                                i63 = i36;
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81110 = iZzk;
                                                i72 = i10;
                                                iZzg = i81110;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 60:
                                            obj3 = obj;
                                            if (i12 == 2) {
                                                Object objZzu3 = this.zzu(obj3, i34, i37);
                                                int iZzm3 = zzdu.zzm(objZzu3, this.zzr(i37), bArr, i36, i2, zzdtVar);
                                                this.zzC(obj3, i34, i37, objZzu3);
                                                zzdtVar2 = zzdtVar;
                                                iZzk = iZzm3;
                                                i64 = i37;
                                                i10 = i34;
                                                i63 = i36;
                                                i2 = i2;
                                            } else {
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i36;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar;
                                                iZzk = i63;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81111 = iZzk;
                                                i72 = i10;
                                                iZzg = i81111;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 61:
                                            zzdtVar3 = zzdtVar4;
                                            obj3 = obj;
                                            i66 = i36;
                                            if (i12 == 2) {
                                                iZzk = zzdu.zza(bArr, i66, zzdtVar3);
                                                unsafe8.putObject(obj3, j, zzdtVar3.zzc);
                                                unsafe8.putInt(obj3, j3, i34);
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i81112 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i81112;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                            }
                                            i64 = i37;
                                            i10 = i34;
                                            i22 = i32;
                                            i63 = i66;
                                            i2 = i2;
                                            zzdtVar2 = zzdtVar3;
                                            iZzk = i63;
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81113 = iZzk;
                                                i72 = i10;
                                                iZzg = i81113;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 63:
                                            zzdtVar3 = zzdtVar4;
                                            obj3 = obj;
                                            i66 = i36;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzh(bArr, i66, zzdtVar3);
                                                i67 = zzdtVar3.zza;
                                                zzeyVarZzq2 = this.zzq(i37);
                                                if (zzeyVarZzq2 != null) {
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(i67));
                                                    unsafe8.putInt(obj3, j3, i34);
                                                } else {
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(i67));
                                                    unsafe8.putInt(obj3, j3, i34);
                                                }
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i81114 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i81114;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                            }
                                            i64 = i37;
                                            i10 = i34;
                                            i22 = i32;
                                            i63 = i66;
                                            i2 = i2;
                                            zzdtVar2 = zzdtVar3;
                                            iZzk = i63;
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81115 = iZzk;
                                                i72 = i10;
                                                iZzg = i81115;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 66:
                                            zzdtVar3 = zzdtVar4;
                                            obj3 = obj;
                                            i66 = i36;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzh(bArr, i66, zzdtVar3);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzej.zzb(zzdtVar3.zza)));
                                                unsafe8.putInt(obj3, j3, i34);
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i81116 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i81116;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                            }
                                            i64 = i37;
                                            i10 = i34;
                                            i22 = i32;
                                            i63 = i66;
                                            i2 = i2;
                                            zzdtVar2 = zzdtVar3;
                                            iZzk = i63;
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81117 = iZzk;
                                                i72 = i10;
                                                iZzg = i81117;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 67:
                                            zzdtVar3 = zzdtVar4;
                                            obj3 = obj;
                                            i66 = i36;
                                            if (i12 == 0) {
                                                iZzk = zzdu.zzk(bArr, i66, zzdtVar3);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzej.zzc(zzdtVar3.zzb)));
                                                unsafe8.putInt(obj3, j3, i34);
                                                i64 = i37;
                                                i10 = i34;
                                                i22 = i32;
                                                i63 = i66;
                                                i2 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                if (iZzk != i63) {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i3 = i3;
                                                    zzdtVar4 = zzdtVar2;
                                                    i2 = i2;
                                                    i69 = i64;
                                                    i68 = 0;
                                                    i70 = i22;
                                                    i71 = i8;
                                                    unsafe9 = unsafe2;
                                                    i73 = i9;
                                                    int i81118 = iZzk;
                                                    i72 = i10;
                                                    iZzg = i81118;
                                                } else {
                                                    i22 = i32;
                                                    i22 = i32;
                                                    i7 = iZzk;
                                                    i68 = i64;
                                                    i70 = i22;
                                                }
                                            }
                                            i64 = i37;
                                            i10 = i34;
                                            i22 = i32;
                                            i63 = i66;
                                            i2 = i2;
                                            zzdtVar2 = zzdtVar3;
                                            iZzk = i63;
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i81119 = iZzk;
                                                i72 = i10;
                                                iZzg = i81119;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                        case 68:
                                            if (i12 == 3) {
                                                obj3 = obj;
                                                Object objZzu4 = this.zzu(obj3, i34, i37);
                                                int iZzl4 = zzdu.zzl(objZzu4, this.zzr(i37), bArr, i36, i2, (i32 & (-8)) | 4, zzdtVar);
                                                this.zzC(obj3, i34, i37, objZzu4);
                                                i64 = i37;
                                                i10 = i34;
                                                iZzk = iZzl4;
                                                zzdtVar2 = zzdtVar4;
                                                i63 = i36;
                                                i2 = i2;
                                            }
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                                break;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i811110 = iZzk;
                                                i72 = i10;
                                                iZzg = i811110;
                                                break;
                                            }
                                        default:
                                            obj3 = obj;
                                            i2 = i2;
                                            i64 = i37;
                                            i10 = i34;
                                            i22 = i32;
                                            i63 = i36;
                                            zzdtVar2 = zzdtVar4;
                                            iZzk = i63;
                                            if (iZzk != i63) {
                                                i22 = i32;
                                                i22 = i32;
                                                i3 = i3;
                                                zzdtVar4 = zzdtVar2;
                                                i2 = i2;
                                                i69 = i64;
                                                i68 = 0;
                                                i70 = i22;
                                                i71 = i8;
                                                unsafe9 = unsafe2;
                                                i73 = i9;
                                                int i811111 = iZzk;
                                                i72 = i10;
                                                iZzg = i811111;
                                            } else {
                                                i22 = i32;
                                                i22 = i32;
                                                i7 = iZzk;
                                                i68 = i64;
                                                i70 = i22;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i12 == 2) {
                                        unsafe7 = zzb;
                                        Object objZzs2 = this.zzs(i37);
                                        object = unsafe7.getObject(obj, j);
                                        if (!((zzfr) object).zze()) {
                                            zzfr zzfrVarZzb2 = zzfr.zza().zzb();
                                            zzfs.zza(zzfrVarZzb2, object);
                                            unsafe7.putObject(obj, j, zzfrVarZzb2);
                                        }
                                        throw null;
                                    }
                                    i35 = i32;
                                    obj3 = obj;
                                    i3 = i3;
                                    i68 = i37;
                                    i10 = i34;
                                    i70 = i35;
                                    i7 = i36;
                                }
                            }
                        } else if (i12 == 2) {
                            zzezVarZzd = (zzez) unsafe9.getObject(obj3, j);
                            if (!zzezVarZzd.zzc()) {
                                int size5 = zzezVarZzd.size();
                                zzezVarZzd = zzezVarZzd.zzd(size5 != 0 ? size5 + size5 : 10);
                                unsafe9.putObject(obj3, j, zzezVarZzd);
                            }
                            zzez zzezVar4 = zzezVarZzd;
                            i72 = i33;
                            iZzg = zzdu.zze(this.zzr(i31), i32, bArr, iZzi, i2, zzezVar4, zzdtVar);
                            i3 = i3;
                            unsafe9 = unsafe9;
                            zzdtVar4 = zzdtVar4;
                            i69 = i31;
                            i2 = i2;
                            i68 = 0;
                            i70 = i32;
                            i71 = i8;
                            i73 = i9;
                        } else {
                            i34 = i33;
                            unsafe2 = unsafe9;
                            i35 = i32;
                            i8 = i8;
                            i36 = iZzi;
                            i37 = i31;
                            i3 = i3;
                            i68 = i37;
                            i10 = i34;
                            i70 = i35;
                            i7 = i36;
                        }
                    }
                } else {
                    i7 = iZzi;
                    i8 = i71;
                    i9 = i73;
                    i10 = i76;
                    i11 = i68;
                    unsafe2 = unsafe9;
                    i3 = i3;
                    i2 = i2;
                }
                if (i70 == i3) {
                }
                int i91 = i10;
                iZzg = zzdu.zzg(i70, bArr, i7, i2, zzc(obj), zzdtVar);
                i2 = i2;
                i69 = i68;
                i72 = i91;
                i70 = i70;
                unsafe9 = unsafe2;
                i68 = i11;
                i71 = i8;
                i73 = i9;
                zzdtVar4 = zzdtVar;
                i3 = i3;
            } else {
                i3 = i3;
                i4 = i2;
                unsafe = unsafe9;
            }
        }
        if (i73 != 1048575) {
            unsafe.putInt(obj3, i73, i71);
        }
        for (int i92 = this.zzi; i92 < this.zzj; i92++) {
            int i93 = this.zzh[i92];
            int i94 = this.zzc[i93];
            Object objZzf = zzhj.zzf(obj3, this.zzo(i93) & 1048575);
            if (objZzf != null && this.zzq(i93) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iZzg != i4) {
                throw zzfb.zzd();
            }
        } else if (iZzg > i4 || i70 != i3) {
            throw zzfb.zzd();
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x007f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzevVar = (zzev) obj;
                zzevVar.zzl(Integer.MAX_VALUE);
                zzevVar.zza = 0;
                zzevVar.zzj();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzo = zzo(i);
                int i2 = 1048575 & iZzo;
                int iZzn = zzn(iZzo);
                long j = i2;
                if (iZzn != 9) {
                    if (iZzn != 60 && iZzn != 68) {
                        switch (iZzn) {
                            case 17:
                                if (zzE(obj, i)) {
                                    zzr(i).zze(zzb.getObject(obj, j));
                                }
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
                                this.zzk.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzI(obj, this.zzc[i], i)) {
                        zzr(i).zze(zzb.getObject(obj, j));
                    }
                } else if (zzE(obj, i)) {
                    zzr(i).zze(zzb.getObject(obj, j));
                }
            }
            this.zzl.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzo = zzo(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzo;
            switch (zzn(iZzo)) {
                case 0:
                    if (zzE(obj2, i)) {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 1:
                    if (zzE(obj2, i)) {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 2:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 3:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 4:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 5:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 6:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 7:
                    if (zzE(obj2, i)) {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 8:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 11:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 12:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 13:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 14:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 15:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 16:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 17:
                    zzx(obj, obj2, i);
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
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
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
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                    }
                    break;
                case 60:
                    zzy(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                    }
                    break;
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzf;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzo = zzo(i);
            long j = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    if (!zzD(obj, obj2, i) || Double.doubleToLongBits(zzhj.zza(obj, j)) != Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzD(obj, obj2, i) || Float.floatToIntBits(zzhj.zzb(obj, j)) != Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzD(obj, obj2, i) || zzhj.zzt(obj, j) != zzhj.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
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
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 50:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
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
                    long jZzl = zzl(i) & 1048575;
                    if (zzhj.zzc(obj, jZzl) != zzhj.zzc(obj2, jZzl) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzf) {
                return false;
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        List list;
        zzgi zzgiVarZzr;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzi) {
            int i7 = this.zzh[i5];
            int i8 = this.zzc[i7];
            int iZzo = zzo(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iZzo) != 0 && !zzF(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzn = zzn(iZzo);
            if (iZzn == 9 || iZzn == 17) {
                if (zzF(obj, i7, i, i2, i11) && !zzG(obj, iZzo, zzr(i7))) {
                    return false;
                }
            } else if (iZzn == 27) {
                list = (List) zzhj.zzf(obj, iZzo & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgiVarZzr = zzr(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgiVarZzr.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzn == 60 || iZzn == 68) {
                if (zzI(obj, i8, i7) && !zzG(obj, iZzo, zzr(i7))) {
                    return false;
                }
            } else if (iZzn == 49) {
                list = (List) zzhj.zzf(obj, iZzo & 1048575);
                if (list.isEmpty()) {
                    zzgiVarZzr = zzr(i7);
                    while (i3 < list.size()) {
                        if (!zzgiVarZzr.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzn == 50 && !((zzfr) zzhj.zzf(obj, iZzo & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return true;
    }
}
