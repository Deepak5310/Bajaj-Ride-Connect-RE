package com.google.android.gms.internal.measurement;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zznk<T> implements zzns<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzol.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznh zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoe zzl;
    private final zzlq zzm;

    private zznk(int[] iArr, Object[] objArr, int i, int i2, zznh zznhVar, boolean z, int[] iArr2, int i3, int i4, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlqVar != null && (zznhVar instanceof zzma)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoeVar;
        this.zzm = zzlqVar;
        this.zzg = zznhVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzns zznsVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zznsVarZzv.zze();
                    zznsVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zznsVarZzv.zze();
                zznsVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zznsVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzns zznsVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zznsVarZzv.zze();
                    zznsVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zznsVarZzv.zze();
                zznsVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zznsVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzol.zzq(obj, j, (1 << (iZzp >>> 20)) | zzol.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzol.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzol.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzol.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzol.zzb(obj, j2)) != 0;
            case 2:
                return zzol.zzd(obj, j2) != 0;
            case 3:
                return zzol.zzd(obj, j2) != 0;
            case 4:
                return zzol.zzc(obj, j2) != 0;
            case 5:
                return zzol.zzd(obj, j2) != 0;
            case 6:
                return zzol.zzc(obj, j2) != 0;
            case 7:
                return zzol.zzw(obj, j2);
            case 8:
                Object objZzf = zzol.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzld) {
                    return !zzld.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzol.zzf(obj, j2) != null;
            case 10:
                return !zzld.zzb.equals(zzol.zzf(obj, j2));
            case 11:
                return zzol.zzc(obj, j2) != 0;
            case 12:
                return zzol.zzc(obj, j2) != 0;
            case 13:
                return zzol.zzc(obj, j2) != 0;
            case 14:
                return zzol.zzd(obj, j2) != 0;
            case 15:
                return zzol.zzc(obj, j2) != 0;
            case 16:
                return zzol.zzd(obj, j2) != 0;
            case 17:
                return zzol.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzns zznsVar) {
        return zznsVar.zzk(zzol.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmd) {
            return ((zzmd) obj).zzcw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzol.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzol.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzor zzorVar) throws IOException {
        if (obj instanceof String) {
            zzorVar.zzG(i, (String) obj);
        } else {
            zzorVar.zzd(i, (zzld) obj);
        }
    }

    static zzof zzd(Object obj) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar != zzof.zzc()) {
            return zzofVar;
        }
        zzof zzofVarZzf = zzof.zzf();
        zzmdVar.zzc = zzofVarZzf;
        return zzofVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zznk zzl(Class cls, zzne zzneVar, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
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
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzz2;
        int i28;
        Object obj2;
        Field fieldZzz3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzneVar instanceof zznr)) {
            throw null;
        }
        zznr zznrVar = (zznr) zzneVar;
        String strZzd = zznrVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zznrVar.zze();
        Class<?> cls2 = zznrVar.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zznrVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i27] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzz3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i20 = 0;
                    strZzd = strZzd;
                    zznrVar = zznrVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i27] = fieldZzz2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzz3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                i20 = 0;
                strZzd = strZzd;
                zznrVar = zznrVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zznrVar = zznrVar;
                            if (zznrVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zznrVar = zznrVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i99];
                            i19 = i96;
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzz;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zznrVar = zznrVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zznk(iArr3, objArr, i2, i5, zznrVar.zza(), false, iArr, i3, i62, zznmVar, zzmuVar, zzoeVar, zzlqVar, zzncVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzol.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzol.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzol.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzol.zzf(obj, j)).longValue();
    }

    private final zzmg zzu(int i) {
        int i2 = i / 3;
        return (zzmg) this.zzd[i2 + i2 + 1];
    }

    private final zzns zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzns zznsVar = (zzns) objArr[i3];
        if (zznsVar != null) {
            return zznsVar;
        }
        zzns zznsVarZzb = zznp.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zznsVarZzb;
        return zznsVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzns zznsVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zznsVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zznsVarZzv.zze();
        if (object != null) {
            zznsVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzns zznsVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zznsVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zznsVarZzv.zze();
        if (object != null) {
            zznsVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Code duplicated, block: B:137:0x038b  */
    /* JADX WARN: Code duplicated, block: B:207:0x054c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzd;
        int iZzz6;
        ?? Zzg;
        int size;
        int iZzz7;
        int iZzy;
        int iZzy2;
        ?? r3;
        int iZzx;
        ?? Zzz;
        ?? Zzh;
        int iZze;
        int iZzz8;
        int iZzz9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iZza = i4 + ((zzmd) obj).zzc.zza();
                if (!this.zzh) {
                    return iZza;
                }
                zzoa zzoaVar = ((zzma) obj).zzb.zza;
                int iZzc = zzoaVar.zzc();
                int iZzb = 0;
                for (int i6 = 0; i6 < iZzc; i6++) {
                    Map.Entry entryZzg = zzoaVar.zzg(i6);
                    iZzb += zzlu.zzb((zzlt) ((zznw) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzoaVar.zzd()) {
                    iZzb += zzlu.zzb((zzlt) entry.getKey(), entry.getValue());
                }
                return iZza + iZzb;
            }
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int i7 = iArr[i3];
            int i8 = iArr[i3 + 2];
            int i9 = i8 & i2;
            if (iZzr <= 17) {
                if (i9 != i5) {
                    r1 = i9 == i2 ? z : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i10 = iZzs & i2;
            if (iZzr >= zzlv.DOUBLE_LIST_PACKED.zza()) {
                zzlv.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j3);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j4);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz4 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzld) {
                            iZzz5 = zzlk.zzz(i11);
                            iZzd = ((zzld) object).zzd();
                            iZzz6 = zzlk.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzlk.zzz(i11);
                            iZzA = zzlk.zzy((String) object);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzld zzldVar = (zzld) unsafe.getObject(obj, j);
                        iZzz5 = zzlk.zzz(i7 << 3);
                        iZzd = zzldVar.zzd();
                        iZzz6 = zzlk.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz(i12);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j5);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zznu.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zznu.zzg(list) + (list.size() * zzlk.zzz(i7 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zznu.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzl(list2);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zznu.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzf(list3);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zznu.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzlk.zzz(i7 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zznu.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzz10 = zzlk.zzz(i7 << 3) * size3;
                        if (r0 instanceof zzmt) {
                            zzmt zzmtVar = (zzmt) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zzmtVar.zzc();
                                if (objZzc instanceof zzld) {
                                    Zzg = iZzz10;
                                    int iZzd2 = ((zzld) objZzc).zzd();
                                    iZzy2 = Zzg + zzlk.zzz(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy2 = Zzg + zzlk.zzy((String) objZzc);
                                }
                                Zzg = iZzy2;
                            }
                            Zzg = iZzz10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzld) {
                                    Zzg = iZzz10;
                                    int iZzd3 = ((zzld) obj2).zzd();
                                    iZzy = Zzg + zzlk.zzz(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy = Zzg + zzlk.zzy((String) obj2);
                                }
                                Zzg = iZzy;
                            }
                            Zzg = iZzz10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv = zzv(i3);
                    int i19 = zznu.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzz11 = zzlk.zzz(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzms) {
                                r3 = iZzz11;
                                int iZza2 = ((zzms) obj3).zza();
                                iZzx = (r3 == true ? 1 : 0) + zzlk.zzz(iZza2) + iZza2;
                            } else {
                                r3 = iZzz11;
                                iZzx = (r3 == true ? 1 : 0) + zzlk.zzx((zznh) obj3, zznsVarZzv);
                            }
                            r3 = iZzx;
                        }
                        r3 = iZzz11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i20 = zznu.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        Zzz = z;
                    } else {
                        Zzz = size5 * zzlk.zzz(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzld) r11.get(r12)).zzd();
                            Zzz += zzlk.zzz(iZzd4) + iZzd4;
                        }
                    }
                    i4 += Zzz;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zznu.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzk(list5);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zznu.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zza(list6);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zznu.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzi(list7);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zznu.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzj(list8);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zznu.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zznu.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zznu.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zznu.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zznu.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zznu.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zznu.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zznu.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv2 = zzv(i3);
                    int i26 = zznu.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzlk.zzw(i7, (zznh) r13.get(r6), zznsVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zznb zznbVar = (zznb) unsafe.getObject(obj, j);
                    if (zznbVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it2 = zznbVar.entrySet().iterator();
                        if (it2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it2.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzM(obj, i7, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzt);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i7, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzt2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i7, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzM(obj, i7, i3)) {
                        iZzz4 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzM(obj, i7, i3)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzld) {
                            iZzz5 = zzlk.zzz(i27);
                            iZzd = ((zzld) object2).zzd();
                            iZzz6 = zzlk.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzlk.zzz(i27);
                            iZzA = zzlk.zzy((String) object2);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i7, i3)) {
                        Zzh = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzM(obj, i7, i3)) {
                        zzld zzldVar2 = (zzld) unsafe.getObject(obj, j);
                        iZzz5 = zzlk.zzz(i7 << 3);
                        iZzd = zzldVar2.zzd();
                        iZzz6 = zzlk.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzM(obj, i7, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz(iZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i7, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzo2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzM(obj, i7, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzM(obj, i7, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i7, i3)) {
                        Zzh = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzmd) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzma) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzol.zza(obj, j));
                    byte[] bArr = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzol.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr2 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr3 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr4 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzmk.zza(zzol.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzol.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr5 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr6 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzol.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzmk.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x026b  */
    /* JADX WARN: Code duplicated, block: B:104:0x028a  */
    /* JADX WARN: Code duplicated, block: B:106:0x028e  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:117:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:119:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:120:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:129:0x0336  */
    /* JADX WARN: Code duplicated, block: B:130:0x0338  */
    /* JADX WARN: Code duplicated, block: B:162:0x0426  */
    /* JADX WARN: Code duplicated, block: B:164:0x042c  */
    /* JADX WARN: Code duplicated, block: B:165:0x042f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0470  */
    /* JADX WARN: Code duplicated, block: B:173:0x0485  */
    /* JADX WARN: Code duplicated, block: B:174:0x0496  */
    /* JADX WARN: Code duplicated, block: B:177:0x049e  */
    /* JADX WARN: Code duplicated, block: B:179:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:180:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:182:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:184:0x04da A[LOOP:3: B:183:0x04d8->B:184:0x04da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:189:0x04f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:192:0x050e  */
    /* JADX WARN: Code duplicated, block: B:194:0x0518 A[LOOP:4: B:191:0x050c->B:194:0x0518, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:196:0x052b  */
    /* JADX WARN: Code duplicated, block: B:197:0x0533  */
    /* JADX WARN: Code duplicated, block: B:199:0x0538  */
    /* JADX WARN: Code duplicated, block: B:201:0x0545 A[LOOP:5: B:200:0x0543->B:201:0x0545, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:206:0x055c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:207:0x055e  */
    /* JADX WARN: Code duplicated, block: B:209:0x0571  */
    /* JADX WARN: Code duplicated, block: B:211:0x0579 A[LOOP:6: B:208:0x056f->B:211:0x0579, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:214:0x0594  */
    /* JADX WARN: Code duplicated, block: B:215:0x0597  */
    /* JADX WARN: Code duplicated, block: B:217:0x059c  */
    /* JADX WARN: Code duplicated, block: B:218:0x05a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:219:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:222:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:224:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:226:0x05db  */
    /* JADX WARN: Code duplicated, block: B:228:0x05ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:229:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:231:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:235:0x0606  */
    /* JADX WARN: Code duplicated, block: B:236:0x060e  */
    /* JADX WARN: Code duplicated, block: B:239:0x061e  */
    /* JADX WARN: Code duplicated, block: B:242:0x0636  */
    /* JADX WARN: Code duplicated, block: B:245:0x0646  */
    /* JADX WARN: Code duplicated, block: B:248:0x0653  */
    /* JADX WARN: Code duplicated, block: B:250:0x0660  */
    /* JADX WARN: Code duplicated, block: B:252:0x0668  */
    /* JADX WARN: Code duplicated, block: B:254:0x066c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:255:0x066e  */
    /* JADX WARN: Code duplicated, block: B:256:0x0674  */
    /* JADX WARN: Code duplicated, block: B:259:0x067e  */
    /* JADX WARN: Code duplicated, block: B:261:0x0686  */
    /* JADX WARN: Code duplicated, block: B:263:0x068e  */
    /* JADX WARN: Code duplicated, block: B:265:0x0692 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:277:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:278:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:280:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:281:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:283:0x0700  */
    /* JADX WARN: Code duplicated, block: B:285:0x070f  */
    /* JADX WARN: Code duplicated, block: B:287:0x0717  */
    /* JADX WARN: Code duplicated, block: B:289:0x071f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:290:0x0721  */
    /* JADX WARN: Code duplicated, block: B:291:0x0727  */
    /* JADX WARN: Code duplicated, block: B:294:0x0736  */
    /* JADX WARN: Code duplicated, block: B:296:0x073e  */
    /* JADX WARN: Code duplicated, block: B:298:0x0746 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:306:0x076a  */
    /* JADX WARN: Code duplicated, block: B:308:0x0774 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:309:0x0776  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:310:0x077c  */
    /* JADX WARN: Code duplicated, block: B:312:0x0784  */
    /* JADX WARN: Code duplicated, block: B:314:0x0793  */
    /* JADX WARN: Code duplicated, block: B:316:0x079b  */
    /* JADX WARN: Code duplicated, block: B:318:0x07a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:322:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:331:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:332:0x07df  */
    /* JADX WARN: Code duplicated, block: B:334:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:336:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:338:0x0804  */
    /* JADX WARN: Code duplicated, block: B:339:0x0806  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:345:0x0816 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:346:0x0818  */
    /* JADX WARN: Code duplicated, block: B:348:0x0827  */
    /* JADX WARN: Code duplicated, block: B:349:0x0829  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:352:0x0830  */
    /* JADX WARN: Code duplicated, block: B:354:0x0838  */
    /* JADX WARN: Code duplicated, block: B:356:0x0842  */
    /* JADX WARN: Code duplicated, block: B:357:0x0844  */
    /* JADX WARN: Code duplicated, block: B:359:0x084a  */
    /* JADX WARN: Code duplicated, block: B:361:0x0857  */
    /* JADX WARN: Code duplicated, block: B:363:0x0867  */
    /* JADX WARN: Code duplicated, block: B:365:0x0873 A[LOOP:14: B:364:0x0871->B:365:0x0873, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:372:0x088d  */
    /* JADX WARN: Code duplicated, block: B:374:0x0890  */
    /* JADX WARN: Code duplicated, block: B:376:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:378:0x08a8 A[LOOP:15: B:375:0x089e->B:378:0x08a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:379:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:381:0x08bf  */
    /* JADX WARN: Code duplicated, block: B:383:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:385:0x08db A[LOOP:16: B:384:0x08d9->B:385:0x08db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:392:0x08f4  */
    /* JADX WARN: Code duplicated, block: B:394:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:396:0x0907  */
    /* JADX WARN: Code duplicated, block: B:398:0x090f A[LOOP:17: B:395:0x0905->B:398:0x090f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:399:0x0919  */
    /* JADX WARN: Code duplicated, block: B:401:0x0926  */
    /* JADX WARN: Code duplicated, block: B:403:0x0932 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:404:0x0934  */
    /* JADX WARN: Code duplicated, block: B:405:0x0947 A[PHI: r0 r1 r4 r6 r14 r35
      0x0947: PHI (r0v55 int) = (r0v48 int), (r0v49 int), (r0v52 int), (r0v56 int) binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]
      0x0947: PHI (r1v152 int) = (r1v148 int), (r1v150 int), (r1v151 int), (r1v153 int) binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]
      0x0947: PHI (r4v59 com.google.android.gms.internal.measurement.zzks) = 
      (r4v55 com.google.android.gms.internal.measurement.zzks)
      (r4v57 com.google.android.gms.internal.measurement.zzks)
      (r4v58 com.google.android.gms.internal.measurement.zzks)
      (r4v60 com.google.android.gms.internal.measurement.zzks)
     binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]
      0x0947: PHI (r6v70 com.google.android.gms.internal.measurement.zznk<T>) = 
      (r6v66 com.google.android.gms.internal.measurement.zznk<T>)
      (r6v68 com.google.android.gms.internal.measurement.zznk<T>)
      (r6v69 com.google.android.gms.internal.measurement.zznk<T>)
      (r6v71 com.google.android.gms.internal.measurement.zznk<T>)
     binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]
      0x0947: PHI (r14v68 int) = (r14v65 int), (r14v66 int), (r14v67 int), (r14v69 int) binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]
      0x0947: PHI (r35v8 sun.misc.Unsafe) = (r35v5 sun.misc.Unsafe), (r35v6 sun.misc.Unsafe), (r35v7 sun.misc.Unsafe), (r35v9 sun.misc.Unsafe) binds: [B:403:0x0932, B:393:0x08f5, B:373:0x088e, B:345:0x0816] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:406:0x094e  */
    /* JADX WARN: Code duplicated, block: B:408:0x095d  */
    /* JADX WARN: Code duplicated, block: B:410:0x096b A[LOOP:18: B:409:0x0969->B:410:0x096b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:415:0x097e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:416:0x0980  */
    /* JADX WARN: Code duplicated, block: B:418:0x0990  */
    /* JADX WARN: Code duplicated, block: B:420:0x0998 A[LOOP:19: B:417:0x098e->B:420:0x0998, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:422:0x09a5  */
    /* JADX WARN: Code duplicated, block: B:424:0x09b4  */
    /* JADX WARN: Code duplicated, block: B:426:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:428:0x09d0 A[LOOP:20: B:427:0x09ce->B:428:0x09d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:435:0x09ed  */
    /* JADX WARN: Code duplicated, block: B:437:0x09f0  */
    /* JADX WARN: Code duplicated, block: B:439:0x0a04  */
    /* JADX WARN: Code duplicated, block: B:441:0x0a0c A[LOOP:21: B:438:0x0a02->B:441:0x0a0c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:442:0x0a1a  */
    /* JADX WARN: Code duplicated, block: B:444:0x0a29  */
    /* JADX WARN: Code duplicated, block: B:446:0x0a39  */
    /* JADX WARN: Code duplicated, block: B:448:0x0a45 A[LOOP:22: B:447:0x0a43->B:448:0x0a45, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:455:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:457:0x0a68  */
    /* JADX WARN: Code duplicated, block: B:459:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:461:0x0a84 A[LOOP:23: B:458:0x0a7a->B:461:0x0a84, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:463:0x0a94  */
    /* JADX WARN: Code duplicated, block: B:465:0x0a9c A[LOOP:2: B:462:0x0a92->B:465:0x0a9c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:466:0x0aaf A[PHI: r0 r9 r10 r11 r13 r14 r35
      0x0aaf: PHI (r0v81 int) = (r0v39 int), (r0v42 int), (r0v46 int), (r0v55 int), (r0v59 int), (r0v67 int), (r0v79 int), (r0v84 int) binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r9v73 com.google.android.gms.internal.measurement.zzks) = 
      (r9v38 com.google.android.gms.internal.measurement.zzks)
      (r9v39 com.google.android.gms.internal.measurement.zzks)
      (r9v41 com.google.android.gms.internal.measurement.zzks)
      (r9v50 com.google.android.gms.internal.measurement.zzks)
      (r9v52 com.google.android.gms.internal.measurement.zzks)
      (r9v61 com.google.android.gms.internal.measurement.zzks)
      (r1v82 com.google.android.gms.internal.measurement.zzks)
      (r9v75 com.google.android.gms.internal.measurement.zzks)
     binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r10v81 int) = (r10v41 int), (r10v42 int), (r10v44 int), (r10v46 int), (r10v58 int), (r10v70 int), (r10v76 int), (r10v85 int) binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r11v77 'this' com.google.android.gms.internal.measurement.zznk<T>) = 
      (r11v31 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r11v32 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r11v34 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r11v44 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r11v50 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r40v0 'this' com.google.android.gms.internal.measurement.zznk<T> A[IMMUTABLE_TYPE, THIS])
      (r11v70 'this' com.google.android.gms.internal.measurement.zznk<T>)
      (r11v80 'this' com.google.android.gms.internal.measurement.zznk<T>)
     binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r13v94 int) = (r13v64 int), (r13v65 int), (r13v67 int), (r13v69 int), (r13v71 int), (r13v76 int), (r13v89 int), (r13v97 int) binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r14v83 int) = (r14v61 int), (r14v62 int), (r14v64 int), (r14v68 int), (r14v71 int), (r14v75 int), (r14v81 int), (r14v85 int) binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]
      0x0aaf: PHI (r35v25 sun.misc.Unsafe) = 
      (r35v1 sun.misc.Unsafe)
      (r35v2 sun.misc.Unsafe)
      (r35v4 sun.misc.Unsafe)
      (r35v8 sun.misc.Unsafe)
      (r35v11 sun.misc.Unsafe)
      (r35v14 sun.misc.Unsafe)
      (r14v31 sun.misc.Unsafe)
      (r35v27 sun.misc.Unsafe)
     binds: [B:456:0x0a66, B:436:0x09ee, B:415:0x097e, B:405:0x0947, B:331:0x07d9, B:282:0x06fd, B:247:0x064c, B:178:0x04ab] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:470:0x0ace  */
    /* JADX WARN: Code duplicated, block: B:476:0x0af7  */
    /* JADX WARN: Code duplicated, block: B:479:0x0b08  */
    /* JADX WARN: Code duplicated, block: B:481:0x0b14  */
    /* JADX WARN: Code duplicated, block: B:483:0x0b2d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:487:0x0b36  */
    /* JADX WARN: Code duplicated, block: B:489:0x0b39  */
    /* JADX WARN: Code duplicated, block: B:490:0x0b62  */
    /* JADX WARN: Code duplicated, block: B:492:0x0b67  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b7e  */
    /* JADX WARN: Code duplicated, block: B:495:0x0b85  */
    /* JADX WARN: Code duplicated, block: B:497:0x0b9e  */
    /* JADX WARN: Code duplicated, block: B:499:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:505:0x0bc7  */
    /* JADX WARN: Code duplicated, block: B:507:0x0bd9  */
    /* JADX WARN: Code duplicated, block: B:509:0x0bdf  */
    /* JADX WARN: Code duplicated, block: B:513:0x0bf5  */
    /* JADX WARN: Code duplicated, block: B:514:0x0bfa  */
    /* JADX WARN: Code duplicated, block: B:516:0x0bfe  */
    /* JADX WARN: Code duplicated, block: B:517:0x0c24  */
    /* JADX WARN: Code duplicated, block: B:518:0x0c2c  */
    /* JADX WARN: Code duplicated, block: B:520:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:522:0x0c3f  */
    /* JADX WARN: Code duplicated, block: B:523:0x0c47  */
    /* JADX WARN: Code duplicated, block: B:532:0x0c6e  */
    /* JADX WARN: Code duplicated, block: B:533:0x0c72  */
    /* JADX WARN: Code duplicated, block: B:535:0x0c7d  */
    /* JADX WARN: Code duplicated, block: B:537:0x0c87  */
    /* JADX WARN: Code duplicated, block: B:538:0x0c8a  */
    /* JADX WARN: Code duplicated, block: B:540:0x0c98  */
    /* JADX WARN: Code duplicated, block: B:542:0x0ca4  */
    /* JADX WARN: Code duplicated, block: B:543:0x0cb6  */
    /* JADX WARN: Code duplicated, block: B:545:0x0cc2  */
    /* JADX WARN: Code duplicated, block: B:546:0x0cd4  */
    /* JADX WARN: Code duplicated, block: B:548:0x0cdf  */
    /* JADX WARN: Code duplicated, block: B:549:0x0cf0  */
    /* JADX WARN: Code duplicated, block: B:551:0x0cfb  */
    /* JADX WARN: Code duplicated, block: B:553:0x0d0d  */
    /* JADX WARN: Code duplicated, block: B:555:0x0d19  */
    /* JADX WARN: Code duplicated, block: B:556:0x0d2e  */
    /* JADX WARN: Code duplicated, block: B:558:0x0d3a  */
    /* JADX WARN: Code duplicated, block: B:559:0x0d4f A[PHI: r6 r13 r14 r29 r36
      0x0d4f: PHI (r6v57 sun.misc.Unsafe) = 
      (r6v43 sun.misc.Unsafe)
      (r6v44 sun.misc.Unsafe)
      (r6v45 sun.misc.Unsafe)
      (r6v46 sun.misc.Unsafe)
      (r6v47 sun.misc.Unsafe)
      (r6v48 sun.misc.Unsafe)
      (r6v50 sun.misc.Unsafe)
      (r6v51 sun.misc.Unsafe)
      (r6v58 sun.misc.Unsafe)
     binds: [B:557:0x0d38, B:554:0x0d17, B:550:0x0cf9, B:547:0x0cdd, B:544:0x0cc0, B:541:0x0ca2, B:534:0x0c7b, B:532:0x0c6e, B:486:0x0b33] A[DONT_GENERATE, DONT_INLINE]
      0x0d4f: PHI (r13v61 com.google.android.gms.internal.measurement.zzks) = 
      (r13v40 com.google.android.gms.internal.measurement.zzks)
      (r13v41 com.google.android.gms.internal.measurement.zzks)
      (r13v42 com.google.android.gms.internal.measurement.zzks)
      (r13v43 com.google.android.gms.internal.measurement.zzks)
      (r13v44 com.google.android.gms.internal.measurement.zzks)
      (r13v45 com.google.android.gms.internal.measurement.zzks)
      (r13v47 com.google.android.gms.internal.measurement.zzks)
      (r13v48 com.google.android.gms.internal.measurement.zzks)
      (r6v42 com.google.android.gms.internal.measurement.zzks)
     binds: [B:557:0x0d38, B:554:0x0d17, B:550:0x0cf9, B:547:0x0cdd, B:544:0x0cc0, B:541:0x0ca2, B:534:0x0c7b, B:532:0x0c6e, B:486:0x0b33] A[DONT_GENERATE, DONT_INLINE]
      0x0d4f: PHI (r14v56 int) = 
      (r14v34 int)
      (r14v35 int)
      (r14v36 int)
      (r14v37 int)
      (r14v38 int)
      (r14v39 int)
      (r14v41 int)
      (r14v42 int)
      (r14v57 int)
     binds: [B:557:0x0d38, B:554:0x0d17, B:550:0x0cf9, B:547:0x0cdd, B:544:0x0cc0, B:541:0x0ca2, B:534:0x0c7b, B:532:0x0c6e, B:486:0x0b33] A[DONT_GENERATE, DONT_INLINE]
      0x0d4f: PHI (r29v24 int) = (r29v2 int), (r29v3 int), (r29v4 int), (r29v5 int), (r29v6 int), (r29v7 int), (r29v9 int), (r29v10 int), (r29v25 int) binds: [B:557:0x0d38, B:554:0x0d17, B:550:0x0cf9, B:547:0x0cdd, B:544:0x0cc0, B:541:0x0ca2, B:534:0x0c7b, B:532:0x0c6e, B:486:0x0b33] A[DONT_GENERATE, DONT_INLINE]
      0x0d4f: PHI (r36v21 int) = (r36v0 int), (r36v1 int), (r36v2 int), (r36v3 int), (r36v4 int), (r36v5 int), (r36v7 int), (r36v8 int), (r36v22 int) binds: [B:557:0x0d38, B:554:0x0d17, B:550:0x0cf9, B:547:0x0cdd, B:544:0x0cc0, B:541:0x0ca2, B:534:0x0c7b, B:532:0x0c6e, B:486:0x0b33] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:568:0x0d80  */
    /* JADX WARN: Code duplicated, block: B:56:0x0179  */
    /* JADX WARN: Code duplicated, block: B:570:0x0d8a  */
    /* JADX WARN: Code duplicated, block: B:572:0x0d94  */
    /* JADX WARN: Code duplicated, block: B:575:0x0dae  */
    /* JADX WARN: Code duplicated, block: B:607:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x01da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x032b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x035a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0374 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x03a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x03b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x041a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x04f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x0556 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x06ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x06b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x06a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x06a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0764 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0757 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x07d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x07cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x07c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x07bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x0810 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x0887 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x0881 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x08ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x08e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0978 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x09e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x09e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x0a5f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0a59 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0ab2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0ae2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x0d52 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0daa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x03f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0324 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x036d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x037f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0399 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x03b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x0417 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x0ac3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0adf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0d65 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x02de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x02c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:682:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:687:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x046c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x045d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x0ab0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:706:0x0587 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x0528 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x01de  */
    /* JADX WARN: Code duplicated, block: B:710:0x0587 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:714:0x062e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:0x0618 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x06ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x069a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x0694 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:728:0x075d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:0x074c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:730:0x0748 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x092a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x07a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:0x07a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:746:0x092a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:752:0x092a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:755:0x092a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:758:0x09a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:761:0x0ab0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:764:0x0ab0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:769:0x023e A[EDGE_INSN: B:769:0x023e->B:90:0x023e BREAK  A[LOOP:26: B:86:0x022b->B:89:0x0235], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:79:0x0206  */
    /* JADX WARN: Code duplicated, block: B:81:0x020e A[LOOP:24: B:78:0x0204->B:81:0x020e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x021a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0224  */
    /* JADX WARN: Code duplicated, block: B:87:0x022d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0235 A[LOOP:26: B:86:0x022b->B:89:0x0235, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x0242  */
    /* JADX WARN: Code duplicated, block: B:93:0x0248 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x024a  */
    /* JADX WARN: Code duplicated, block: B:97:0x025f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0267  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        Object obj2;
        int i4;
        int i5;
        zznk<T> zznkVar;
        int i6;
        int iZzi;
        int i7;
        int i8;
        int iZzq;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        zzks zzksVar2;
        int i14;
        int i15;
        zzlp zzlpVar;
        zznh zznhVar;
        int i16;
        int[] iArr;
        int i17;
        int i18;
        int iZzr;
        long j;
        int i19;
        String str;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int length;
        int i31;
        char[] cArr;
        int i32;
        int i33;
        int i34;
        byte b;
        int i35;
        int i36;
        String str2;
        byte b2;
        byte b3;
        int i37;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        zzks zzksVar3;
        Unsafe unsafe;
        int i43;
        Object object;
        Unsafe unsafe2;
        long j2;
        int i44;
        int i45;
        int iZzk;
        boolean z2;
        int i46;
        int i47;
        int i48;
        int iZza;
        int i49;
        zzmg zzmgVarZzu;
        int iZzh;
        long j3;
        int i50;
        zzmj zzmjVar;
        zzmj zzmjVar2;
        zzmj zzmjVar3;
        int i51;
        int i52;
        zzlm zzlmVar;
        int iZzh2;
        zzlm zzlmVar2;
        int iZzh3;
        int i53;
        int i54;
        zzmj zzmjVar4;
        zzlw zzlwVar;
        int iZzh4;
        zzlw zzlwVar2;
        int i55;
        int i56;
        zzmj zzmjVar5;
        zzmw zzmwVar;
        int iZzh5;
        zzmw zzmwVar2;
        int i57;
        zzks zzksVar4;
        zzmj zzmjVar6;
        int i58;
        zznk<T> zznkVar2;
        int iZzf;
        zzmj zzmjVar7;
        zzmw zzmwVar3;
        int iZzh6;
        zzmw zzmwVar4;
        int i59;
        int i60;
        zzmj zzmjVar8;
        zzme zzmeVar;
        int iZzh7;
        zzme zzmeVar2;
        int i61;
        int i62;
        zzmj zzmjVar9;
        zzku zzkuVar;
        boolean z3;
        int iZzh8;
        boolean z4;
        zzku zzkuVar2;
        int i63;
        boolean z5;
        zzmj zzmjVar10;
        int i64;
        int i65;
        int iZzh9;
        int i66;
        int i67;
        int iZzh10;
        int i68;
        Object obj3;
        int iZzh11;
        int i69;
        int i70;
        int iZzh12;
        int i71;
        int i72;
        int iZzj;
        zzmg zzmgVarZzu2;
        zzoe zzoeVar;
        int i73;
        int i74;
        Iterator it2;
        Object objZzn;
        int iIntValue;
        int size;
        Object objZzn2;
        int i75;
        int i76;
        Integer num;
        int iIntValue2;
        zzme zzmeVar3;
        int iZzh13;
        int iZzh14;
        zzme zzmeVar4;
        int i77;
        zzmw zzmwVar5;
        int iZzh15;
        zzmw zzmwVar6;
        int iZzh16;
        int i78;
        zzmj zzmjVar11;
        int i79;
        zzns zznsVarZzv;
        int iZzh17;
        zzmj zzmjVarZzd;
        int size2;
        int i80;
        this = this;
        Object obj4 = obj;
        int i81 = i2;
        i3 = i3;
        zzks zzksVar5 = zzksVar;
        zzA(obj);
        Unsafe unsafe3 = zzb;
        int i82 = 0;
        int iZzg = i;
        int i83 = 0;
        int i84 = 0;
        int i85 = 0;
        int i86 = -1;
        int i87 = 1048575;
        while (true) {
            if (iZzg < i81) {
                int i88 = iZzg + 1;
                int i89 = bArr[iZzg];
                if (i89 < 0) {
                    iZzi = zzkt.zzi(i89, bArr, i88, zzksVar5);
                    i6 = zzksVar5.zza;
                } else {
                    i6 = i89;
                    iZzi = i88;
                }
                int i90 = i6 >>> 3;
                if (i90 > i86) {
                    iZzq = (i90 < this.zze || i90 > this.zzf) ? -1 : this.zzq(i90, i83 / 3);
                } else {
                    if (i90 < this.zze || i90 > this.zzf) {
                        i7 = -1;
                        i8 = -1;
                    } else {
                        iZzq = this.zzq(i90, i82);
                    }
                    if (i8 == i7) {
                        i9 = iZzi;
                        i10 = i85;
                        i11 = i87;
                        i12 = i90;
                        i13 = i82;
                        unsafe3 = unsafe3;
                        i4 = i3;
                        obj2 = obj4;
                        zzksVar2 = zzksVar5;
                        zznkVar = this;
                        i14 = i13;
                        i15 = i6;
                    } else {
                        i16 = i6 & 7;
                        iArr = this.zzc;
                        i17 = iArr[i8 + 1];
                        i18 = i6;
                        iZzr = zzr(i17);
                        j = i17 & 1048575;
                        i19 = i90;
                        str = "Protocol message had invalid UTF-8.";
                        if (iZzr <= 17) {
                            int i91 = iArr[i8 + 2];
                            i20 = 1 << (i91 >>> 20);
                            i21 = i91 & 1048575;
                            if (i21 != i87) {
                                if (i87 != 1048575) {
                                    unsafe3.putInt(obj4, i87, i85);
                                }
                                if (i21 == 1048575) {
                                    i85 = 0;
                                } else {
                                    i85 = unsafe3.getInt(obj4, i21);
                                }
                                i11 = i21;
                            } else {
                                i11 = i87;
                            }
                            switch (iZzr) {
                                case 0:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 1) {
                                        iZzg = i22 + 8;
                                        i85 |= i20;
                                        zzol.zzo(obj4, j, Double.longBitsToDouble(zzkt.zzn(bArr, i22)));
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 1:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 5) {
                                        iZzg = i22 + 4;
                                        i85 |= i20;
                                        zzol.zzp(obj4, j, Float.intBitsToFloat(zzkt.zzb(bArr, i22)));
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 0) {
                                        int i92 = i85 | i20;
                                        int iZzk2 = zzkt.zzk(bArr, i22, zzksVar5);
                                        unsafe3.putLong(obj, j, zzksVar5.zzb);
                                        i85 = i92;
                                        iZzg = iZzk2;
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 0) {
                                        i85 |= i20;
                                        iZzg = zzkt.zzh(bArr, i22, zzksVar5);
                                        unsafe3.putInt(obj4, j, zzksVar5.zza);
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 1) {
                                        unsafe3.putLong(obj, j, zzkt.zzn(bArr, i22));
                                        iZzg = i22 + 8;
                                        i85 = i20 | i85;
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 5) {
                                        iZzg = i22 + 4;
                                        i85 |= i20;
                                        unsafe3.putInt(obj4, j, zzkt.zzb(bArr, i22));
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 7:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 0) {
                                        i85 |= i20;
                                        iZzg = zzkt.zzk(bArr, i22, zzksVar5);
                                        if (zzksVar5.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzol.zzm(obj4, j, z);
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 8:
                                    i26 = iZzi;
                                    i23 = i8;
                                    i27 = i18;
                                    if (i16 == 2) {
                                        if ((i17 & PropertyOptions.DELETE_EXISTING) != 0) {
                                            iZzg = zzkt.zzh(bArr, i26, zzksVar5);
                                            i29 = zzksVar5.zza;
                                            if (i29 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i30 = i85 | i20;
                                            if (i29 == 0) {
                                                zzksVar5.zzc = "";
                                                i33 = i30;
                                                i18 = i27;
                                                i82 = 0;
                                            } else {
                                                int i93 = zzoo.zza;
                                                length = bArr.length;
                                                if ((((length - iZzg) - i29) | iZzg | i29) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i29)));
                                                }
                                                i31 = iZzg + i29;
                                                cArr = new char[i29];
                                                i32 = 0;
                                                while (iZzg < i31) {
                                                    b3 = bArr[iZzg];
                                                    if (zzom.zzd(b3)) {
                                                        iZzg++;
                                                        cArr[i32] = (char) b3;
                                                        i32++;
                                                    } else {
                                                        while (iZzg < i31) {
                                                            i34 = iZzg + 1;
                                                            b = bArr[iZzg];
                                                            if (zzom.zzd(b)) {
                                                                cArr[i32] = (char) b;
                                                                i32++;
                                                                iZzg = i34;
                                                                while (iZzg < i31) {
                                                                    b2 = bArr[iZzg];
                                                                    if (zzom.zzd(b2)) {
                                                                    }
                                                                    iZzg++;
                                                                    cArr[i32] = (char) b2;
                                                                    i32++;
                                                                    break;
                                                                }
                                                            } else {
                                                                i35 = i30;
                                                                if (b < -32) {
                                                                    i36 = i27;
                                                                    str2 = str;
                                                                    if (b < -16) {
                                                                        if (i34 < i31 - 1) {
                                                                            throw new zzmm(str2);
                                                                        }
                                                                        zzom.zzb(b, bArr[i34], bArr[iZzg + 2], cArr, i32);
                                                                        str = str2;
                                                                        i32++;
                                                                        i30 = i35;
                                                                        i27 = i36;
                                                                        iZzg += 3;
                                                                    } else {
                                                                        if (i34 < i31 - 2) {
                                                                            throw new zzmm(str2);
                                                                        }
                                                                        byte b4 = bArr[i34];
                                                                        int i94 = iZzg + 3;
                                                                        byte b5 = bArr[iZzg + 2];
                                                                        iZzg += 4;
                                                                        zzom.zza(b, b4, b5, bArr[i94], cArr, i32);
                                                                        i32 += 2;
                                                                        str = str2;
                                                                        i30 = i35;
                                                                        i27 = i36;
                                                                    }
                                                                } else {
                                                                    if (i34 < i31) {
                                                                        throw new zzmm(str);
                                                                    }
                                                                    iZzg += 2;
                                                                    zzom.zzc(b, bArr[i34], cArr, i32);
                                                                    i32++;
                                                                    i30 = i35;
                                                                }
                                                            }
                                                        }
                                                        i33 = i30;
                                                        i18 = i27;
                                                        i82 = 0;
                                                        zzksVar5.zzc = new String(cArr, 0, i32);
                                                        iZzg = i31;
                                                    }
                                                }
                                                while (iZzg < i31) {
                                                    i34 = iZzg + 1;
                                                    b = bArr[iZzg];
                                                    if (zzom.zzd(b)) {
                                                        cArr[i32] = (char) b;
                                                        i32++;
                                                        iZzg = i34;
                                                        while (iZzg < i31) {
                                                            b2 = bArr[iZzg];
                                                            if (zzom.zzd(b2)) {
                                                            }
                                                            iZzg++;
                                                            cArr[i32] = (char) b2;
                                                            i32++;
                                                            break;
                                                        }
                                                    } else {
                                                        i35 = i30;
                                                        if (b < -32) {
                                                            i36 = i27;
                                                            str2 = str;
                                                            if (b < -16) {
                                                                if (i34 < i31 - 1) {
                                                                    throw new zzmm(str2);
                                                                }
                                                                zzom.zzb(b, bArr[i34], bArr[iZzg + 2], cArr, i32);
                                                                str = str2;
                                                                i32++;
                                                                i30 = i35;
                                                                i27 = i36;
                                                                iZzg += 3;
                                                            } else {
                                                                if (i34 < i31 - 2) {
                                                                    throw new zzmm(str2);
                                                                }
                                                                byte b6 = bArr[i34];
                                                                int i95 = iZzg + 3;
                                                                byte b7 = bArr[iZzg + 2];
                                                                iZzg += 4;
                                                                zzom.zza(b, b6, b7, bArr[i95], cArr, i32);
                                                                i32 += 2;
                                                                str = str2;
                                                                i30 = i35;
                                                                i27 = i36;
                                                            }
                                                        } else {
                                                            if (i34 < i31) {
                                                                throw new zzmm(str);
                                                            }
                                                            iZzg += 2;
                                                            zzom.zzc(b, bArr[i34], cArr, i32);
                                                            i32++;
                                                            i30 = i35;
                                                        }
                                                    }
                                                }
                                                i33 = i30;
                                                i18 = i27;
                                                i82 = 0;
                                                zzksVar5.zzc = new String(cArr, 0, i32);
                                                iZzg = i31;
                                            }
                                            i85 = i33;
                                        } else {
                                            i18 = i27;
                                            i82 = 0;
                                            iZzg = zzkt.zzh(bArr, i26, zzksVar5);
                                            i28 = zzksVar5.zza;
                                            if (i28 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i85 |= i20;
                                            if (i28 == 0) {
                                                zzksVar5.zzc = "";
                                            } else {
                                                zzksVar5.zzc = new String(bArr, iZzg, i28, zzmk.zza);
                                                iZzg += i28;
                                            }
                                        }
                                        unsafe3.putObject(obj4, j, zzksVar5.zzc);
                                        i83 = i23;
                                        i87 = i11;
                                        i84 = i18;
                                        i86 = i19;
                                        i81 = i2;
                                    } else {
                                        i24 = i26;
                                        i18 = i27;
                                        i25 = i23;
                                        i13 = 0;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 9:
                                    i37 = i8;
                                    i38 = i18;
                                    if (i16 == 2) {
                                        int i96 = i85 | i20;
                                        Object objZzx = this.zzx(obj4, i37);
                                        iZzg = zzkt.zzm(objZzx, this.zzv(i37), bArr, iZzi, i2, zzksVar);
                                        this.zzF(obj4, i37, objZzx);
                                        i85 = i96;
                                        i84 = i38;
                                        i83 = i37;
                                        i87 = i11;
                                        i86 = i19;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i24 = iZzi;
                                        i85 = i85;
                                        unsafe3 = unsafe3;
                                        zzksVar5 = zzksVar5;
                                        i18 = i38;
                                        i25 = i37;
                                        i19 = i19;
                                        i13 = 0;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 10:
                                    i37 = i8;
                                    i38 = i18;
                                    if (i16 == 2) {
                                        i85 |= i20;
                                        iZzg = zzkt.zza(bArr, iZzi, zzksVar5);
                                        unsafe3.putObject(obj4, j, zzksVar5.zzc);
                                        i84 = i38;
                                        i83 = i37;
                                        i87 = i11;
                                        i86 = i19;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i24 = iZzi;
                                        i85 = i85;
                                        unsafe3 = unsafe3;
                                        zzksVar5 = zzksVar5;
                                        i18 = i38;
                                        i25 = i37;
                                        i19 = i19;
                                        i13 = 0;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 12:
                                    i37 = i8;
                                    i38 = i18;
                                    if (i16 == 0) {
                                        iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                        i39 = zzksVar5.zza;
                                        zzmg zzmgVarZzu3 = this.zzu(i37);
                                        if ((i17 & Integer.MIN_VALUE) != 0 || zzmgVarZzu3 == null || zzmgVarZzu3.zza(i39)) {
                                            i85 |= i20;
                                            unsafe3.putInt(obj4, j, i39);
                                        } else {
                                            zzd(obj).zzj(i38, Long.valueOf(i39));
                                        }
                                        i84 = i38;
                                        i83 = i37;
                                        i87 = i11;
                                        i86 = i19;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i24 = iZzi;
                                        i85 = i85;
                                        unsafe3 = unsafe3;
                                        zzksVar5 = zzksVar5;
                                        i18 = i38;
                                        i25 = i37;
                                        i19 = i19;
                                        i13 = 0;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 15:
                                    i37 = i8;
                                    i38 = i18;
                                    if (i16 == 0) {
                                        i85 |= i20;
                                        iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                        unsafe3.putInt(obj4, j, zzlg.zzb(zzksVar5.zza));
                                        i84 = i38;
                                        i83 = i37;
                                        i87 = i11;
                                        i86 = i19;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i24 = iZzi;
                                        i85 = i85;
                                        unsafe3 = unsafe3;
                                        zzksVar5 = zzksVar5;
                                        i18 = i38;
                                        i25 = i37;
                                        i19 = i19;
                                        i13 = 0;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                case 16:
                                    if (i16 == 0) {
                                        int i97 = i85 | i20;
                                        int iZzk3 = zzkt.zzk(bArr, iZzi, zzksVar5);
                                        i37 = i8;
                                        i38 = i18;
                                        unsafe3.putLong(obj, j, zzlg.zzc(zzksVar5.zzb));
                                        i85 = i97;
                                        iZzg = iZzk3;
                                        i84 = i38;
                                        i83 = i37;
                                        i87 = i11;
                                        i86 = i19;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i24 = iZzi;
                                        i85 = i85;
                                        unsafe3 = unsafe3;
                                        zzksVar5 = zzksVar5;
                                        i13 = 0;
                                        i25 = i8;
                                        i19 = i19;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                                default:
                                    i22 = iZzi;
                                    i23 = i8;
                                    i82 = 0;
                                    if (i16 == 3) {
                                        Object objZzx2 = this.zzx(obj4, i23);
                                        int iZzl = zzkt.zzl(objZzx2, this.zzv(i23), bArr, i22, i2, (i19 << 3) | 4, zzksVar);
                                        this.zzF(obj4, i23, objZzx2);
                                        i3 = i3;
                                        zzksVar5 = zzksVar;
                                        i86 = i19;
                                        unsafe3 = unsafe3;
                                        i83 = i23;
                                        i81 = i2;
                                        iZzg = iZzl;
                                        i87 = i11;
                                        i84 = i18;
                                        i82 = 0;
                                        i85 |= i20;
                                    } else {
                                        i24 = i22;
                                        i13 = i82;
                                        i25 = i23;
                                        zzksVar2 = zzksVar5;
                                        unsafe3 = unsafe3;
                                        i10 = i85;
                                        i15 = i18;
                                        obj2 = obj4;
                                        zznkVar = this;
                                        i14 = i25;
                                        i12 = i19;
                                        i9 = i24;
                                        i4 = i3;
                                    }
                                    break;
                            }
                        } else {
                            i11 = i87;
                            i40 = i19;
                            i13 = 0;
                            i81 = i2;
                            i10 = i85;
                            i41 = i8;
                            zzks zzksVar6 = zzksVar5;
                            i42 = iZzi;
                            zzksVar3 = zzksVar6;
                            unsafe = unsafe3;
                            if (iZzr == 27) {
                                if (iZzr <= 49) {
                                    j3 = i17;
                                    i50 = i41;
                                    zzmjVar = (zzmj) unsafe.getObject(obj4, j);
                                    if (zzmjVar.zzc()) {
                                        zzmjVar2 = zzmjVar;
                                    } else {
                                        int size3 = zzmjVar.size();
                                        zzmj zzmjVarZzd2 = zzmjVar.zzd(size3 + size3);
                                        unsafe.putObject(obj4, j, zzmjVarZzd2);
                                        zzmjVar2 = zzmjVarZzd2;
                                    }
                                    switch (iZzr) {
                                        case 18:
                                        case 35:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar3 = zzmjVar2;
                                            unsafe = unsafe;
                                            i51 = i18;
                                            i52 = i40;
                                            this = this;
                                            i81 = i81;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                int i98 = zzkt.zza;
                                                zzlmVar2 = (zzlm) zzmjVar3;
                                                iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                                i53 = zzksVar3.zza;
                                                i54 = iZzh3 + i53;
                                                if (i54 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzlmVar2.zzg(zzlmVar2.size() + (i53 / 8));
                                                while (iZzh3 < i54) {
                                                    zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh3)));
                                                    iZzh3 += 8;
                                                }
                                                if (iZzh3 != i54) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh3;
                                            } else if (i16 == 1) {
                                                iZzg = i42 + 8;
                                                int i99 = zzkt.zza;
                                                zzlmVar = (zzlm) zzmjVar3;
                                                zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, i42)));
                                                while (iZzg < i81) {
                                                    iZzh2 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i51 == zzksVar3.zza) {
                                                        zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh2)));
                                                        iZzg = iZzh2 + 8;
                                                    }
                                                }
                                            } else {
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar4 = zzmjVar2;
                                            unsafe = unsafe;
                                            i51 = i18;
                                            i52 = i40;
                                            this = this;
                                            i81 = i81;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                int i100 = zzkt.zza;
                                                zzlwVar2 = (zzlw) zzmjVar4;
                                                iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                                i55 = zzksVar3.zza;
                                                i56 = iZzh3 + i55;
                                                if (i56 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzlwVar2.zzg(zzlwVar2.size() + (i55 / 4));
                                                while (iZzh3 < i56) {
                                                    zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh3)));
                                                    iZzh3 += 4;
                                                }
                                                if (iZzh3 != i56) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh3;
                                            } else if (i16 == 5) {
                                                iZzg = i42 + 4;
                                                int i101 = zzkt.zza;
                                                zzlwVar = (zzlw) zzmjVar4;
                                                zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, i42)));
                                                while (iZzg < i81) {
                                                    iZzh4 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i51 == zzksVar3.zza) {
                                                        zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh4)));
                                                        iZzg = iZzh4 + 4;
                                                    }
                                                }
                                            } else {
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar5 = zzmjVar2;
                                            unsafe = unsafe;
                                            i51 = i18;
                                            i52 = i40;
                                            this = this;
                                            i81 = i81;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                if (i16 == 0) {
                                                    int i102 = zzkt.zza;
                                                    zzmwVar = (zzmw) zzmjVar5;
                                                    iZzh3 = zzkt.zzk(bArr, i42, zzksVar3);
                                                    zzmwVar.zzg(zzksVar3.zzb);
                                                    while (iZzh3 < i81) {
                                                        iZzh5 = zzkt.zzh(bArr, iZzh3, zzksVar3);
                                                        if (i51 == zzksVar3.zza) {
                                                            iZzh3 = zzkt.zzk(bArr, iZzh5, zzksVar3);
                                                            zzmwVar.zzg(zzksVar3.zzb);
                                                        }
                                                    }
                                                } else {
                                                    iZzg = i42;
                                                }
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i103 = zzkt.zza;
                                                zzmwVar2 = (zzmw) zzmjVar5;
                                                iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                                i57 = zzksVar3.zza + iZzh3;
                                                while (iZzh3 < i57) {
                                                    iZzh3 = zzkt.zzk(bArr, iZzh3, zzksVar3);
                                                    zzmwVar2.zzg(zzksVar3.zzb);
                                                }
                                                if (iZzh3 != i57) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            iZzg = iZzh3;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar6 = zzmjVar2;
                                            unsafe = unsafe;
                                            i58 = i18;
                                            i81 = i81;
                                            zznkVar2 = this;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                iZzf = zzkt.zzf(bArr, i42, zzmjVar6, zzksVar4);
                                                i51 = i58;
                                                iZzg = iZzf;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                            } else if (i16 == 0) {
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                i52 = i40;
                                                this = zznkVar2;
                                                iZzg = zzkt.zzj(i58, bArr, i42, i2, zzmjVar6, zzksVar);
                                            } else {
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar7 = zzmjVar2;
                                            unsafe = unsafe;
                                            i58 = i18;
                                            i81 = i81;
                                            zznkVar2 = this;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                if (i16 == 1) {
                                                    iZzf = i42 + 8;
                                                    int i104 = zzkt.zza;
                                                    zzmwVar3 = (zzmw) zzmjVar7;
                                                    zzmwVar3.zzg(zzkt.zzn(bArr, i42));
                                                    while (iZzf < i81) {
                                                        iZzh6 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i58 == zzksVar4.zza) {
                                                            zzmwVar3.zzg(zzkt.zzn(bArr, iZzh6));
                                                            iZzf = iZzh6 + 8;
                                                        }
                                                    }
                                                }
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i105 = zzkt.zza;
                                                zzmwVar4 = (zzmw) zzmjVar7;
                                                iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                                i59 = zzksVar4.zza;
                                                i60 = iZzf + i59;
                                                if (i60 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzmwVar4.zzh(zzmwVar4.size() + (i59 / 8));
                                                while (iZzf < i60) {
                                                    zzmwVar4.zzg(zzkt.zzn(bArr, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i60) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i51 = i58;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar8 = zzmjVar2;
                                            unsafe = unsafe;
                                            i58 = i18;
                                            i81 = i81;
                                            zznkVar2 = this;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                if (i16 == 5) {
                                                    iZzf = i42 + 4;
                                                    int i106 = zzkt.zza;
                                                    zzmeVar = (zzme) zzmjVar8;
                                                    zzmeVar.zzh(zzkt.zzb(bArr, i42));
                                                    while (iZzf < i81) {
                                                        iZzh7 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i58 == zzksVar4.zza) {
                                                            zzmeVar.zzh(zzkt.zzb(bArr, iZzh7));
                                                            iZzf = iZzh7 + 4;
                                                        }
                                                    }
                                                }
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i107 = zzkt.zza;
                                                zzmeVar2 = (zzme) zzmjVar8;
                                                iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                                i61 = zzksVar4.zza;
                                                i62 = iZzf + i61;
                                                if (i62 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzmeVar2.zzi(zzmeVar2.size() + (i61 / 4));
                                                while (iZzf < i62) {
                                                    zzmeVar2.zzh(zzkt.zzb(bArr, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i62) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i51 = i58;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar9 = zzmjVar2;
                                            unsafe = unsafe;
                                            i58 = i18;
                                            i81 = i81;
                                            zznkVar2 = this;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                if (i16 == 0) {
                                                    int i108 = zzkt.zza;
                                                    zzkuVar = (zzku) zzmjVar9;
                                                    iZzf = zzkt.zzk(bArr, i42, zzksVar4);
                                                    if (zzksVar4.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    zzkuVar.zze(z3);
                                                    while (iZzf < i81) {
                                                        iZzh8 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i58 == zzksVar4.zza) {
                                                            iZzf = zzkt.zzk(bArr, iZzh8, zzksVar4);
                                                            if (zzksVar4.zzb != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            zzkuVar.zze(z4);
                                                        }
                                                    }
                                                }
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i109 = zzkt.zza;
                                                zzkuVar2 = (zzku) zzmjVar9;
                                                iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                                i63 = zzksVar4.zza + iZzf;
                                                while (iZzf < i63) {
                                                    iZzf = zzkt.zzk(bArr, iZzf, zzksVar4);
                                                    if (zzksVar4.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    zzkuVar2.zze(z5);
                                                }
                                                if (iZzf != i63) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i51 = i58;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 26:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar10 = zzmjVar2;
                                            unsafe = unsafe;
                                            i58 = i18;
                                            i40 = i40;
                                            i81 = i81;
                                            zznkVar2 = this;
                                            i14 = i50;
                                            if (i16 == 2) {
                                                i51 = i58;
                                                zzksVar3 = zzksVar4;
                                                i52 = i40;
                                                this = zznkVar2;
                                                iZzg = i42;
                                            } else if ((j3 & 536870912) == 0) {
                                                iZzh10 = zzkt.zzh(bArr, i42, zzksVar4);
                                                i68 = zzksVar4.zza;
                                                if (i68 >= 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i68 == 0) {
                                                    obj3 = "";
                                                    zzmjVar10.add(obj3);
                                                } else {
                                                    obj3 = "";
                                                    zzmjVar10.add(new String(bArr, iZzh10, i68, zzmk.zza));
                                                    iZzh10 += i68;
                                                }
                                                while (iZzh10 < i81) {
                                                    iZzh11 = zzkt.zzh(bArr, iZzh10, zzksVar4);
                                                    if (i58 == zzksVar4.zza) {
                                                        iZzh10 = zzkt.zzh(bArr, iZzh11, zzksVar4);
                                                        i69 = zzksVar4.zza;
                                                        if (i69 >= 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i69 == 0) {
                                                            zzmjVar10.add(obj3);
                                                        } else {
                                                            zzmjVar10.add(new String(bArr, iZzh10, i69, zzmk.zza));
                                                            iZzh10 += i69;
                                                        }
                                                    } else {
                                                        i51 = i58;
                                                        iZzg = iZzh10;
                                                        zzksVar3 = zzksVar4;
                                                        i52 = i40;
                                                        this = zznkVar2;
                                                    }
                                                }
                                                i51 = i58;
                                                iZzg = iZzh10;
                                                zzksVar3 = zzksVar4;
                                                i52 = i40;
                                                this = zznkVar2;
                                            } else {
                                                iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                                i64 = zzksVar4.zza;
                                                if (i64 >= 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i64 == 0) {
                                                    zzmjVar10.add("");
                                                } else {
                                                    i65 = iZzf + i64;
                                                    if (zzoo.zzd(bArr, iZzf, i65)) {
                                                        throw new zzmm(r3);
                                                    }
                                                    zzmjVar10.add(new String(bArr, iZzf, i64, zzmk.zza));
                                                    iZzf = i65;
                                                }
                                                while (iZzf < i81) {
                                                    iZzh9 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                    if (i58 == zzksVar4.zza) {
                                                        iZzf = zzkt.zzh(bArr, iZzh9, zzksVar4);
                                                        i66 = zzksVar4.zza;
                                                        if (i66 >= 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i66 == 0) {
                                                            zzmjVar10.add("");
                                                        } else {
                                                            i67 = iZzf + i66;
                                                            if (zzoo.zzd(bArr, iZzf, i67)) {
                                                                throw new zzmm(str);
                                                            }
                                                            zzmjVar10.add(new String(bArr, iZzf, i66, zzmk.zza));
                                                            iZzf = i67;
                                                        }
                                                    } else {
                                                        i51 = i58;
                                                        iZzg = iZzf;
                                                        zzksVar3 = zzksVar4;
                                                        this = zznkVar2;
                                                        i52 = i40;
                                                    }
                                                }
                                                i51 = i58;
                                                iZzg = iZzf;
                                                zzksVar3 = zzksVar4;
                                                this = zznkVar2;
                                                i52 = i40;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 27:
                                            zzksVar3 = zzksVar3;
                                            i40 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            if (i16 == 2) {
                                                unsafe = unsafe;
                                                int iZze = zzkt.zze(zzv(i14), i18, bArr, i42, i2, zzmjVar2, zzksVar);
                                                i51 = i18;
                                                i52 = i40;
                                                this = this;
                                                iZzg = iZze;
                                            } else {
                                                unsafe = unsafe;
                                                i51 = i18;
                                                i52 = i40;
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 28:
                                            zzksVar3 = zzksVar3;
                                            i40 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            if (i16 == 2) {
                                                iZzg = zzkt.zzh(bArr, i42, zzksVar3);
                                                i70 = zzksVar3.zza;
                                                if (i70 >= 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i70 <= bArr.length - iZzg) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i70 == 0) {
                                                    zzmjVar2.add(zzld.zzb);
                                                } else {
                                                    zzmjVar2.add(zzld.zzj(bArr, iZzg, i70));
                                                    iZzg += i70;
                                                }
                                                while (iZzg < i81) {
                                                    iZzh12 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i18 == zzksVar3.zza) {
                                                        i51 = i18;
                                                        unsafe = unsafe;
                                                        i52 = i40;
                                                        if (iZzg != i42) {
                                                            i42 = i42;
                                                            i81 = i81;
                                                            zzksVar3 = zzksVar3;
                                                            obj4 = obj;
                                                            i83 = i14;
                                                            zzksVar5 = zzksVar3;
                                                            i86 = i52;
                                                            this = this;
                                                            i84 = i51;
                                                            i87 = i11;
                                                            i82 = 0;
                                                            i85 = i10;
                                                            unsafe3 = unsafe;
                                                        } else {
                                                            i42 = i42;
                                                            i81 = i81;
                                                            zzksVar3 = zzksVar3;
                                                            obj2 = obj;
                                                            i9 = iZzg;
                                                            i12 = i52;
                                                            zznkVar = this;
                                                            i15 = i51;
                                                            unsafe3 = unsafe;
                                                            zzksVar2 = zzksVar3;
                                                            i4 = i3;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzg = zzkt.zzh(bArr, iZzh12, zzksVar3);
                                                        i71 = zzksVar3.zza;
                                                        if (i71 >= 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i71 <= bArr.length - iZzg) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i71 == 0) {
                                                            zzmjVar2.add(zzld.zzb);
                                                        } else {
                                                            zzmjVar2.add(zzld.zzj(bArr, iZzg, i71));
                                                            iZzg += i71;
                                                        }
                                                    }
                                                }
                                                i51 = i18;
                                                unsafe = unsafe;
                                                i52 = i40;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                i51 = i18;
                                                unsafe = unsafe;
                                                i52 = i40;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i72 = i18;
                                            if (i16 == 2) {
                                                iZzj = zzkt.zzf(bArr, i42, zzmjVar2, zzksVar3);
                                            } else if (i16 == 0) {
                                                this = this;
                                                i51 = i72;
                                                i52 = i40;
                                                i14 = i50;
                                                i81 = i81;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                iZzj = zzkt.zzj(i72, bArr, i42, i2, zzmjVar2, zzksVar);
                                            }
                                            zzmgVarZzu2 = this.zzu(i50);
                                            zzoeVar = this.zzl;
                                            int i110 = zznu.zza;
                                            if (zzmgVarZzu2 != null) {
                                                i73 = iZzj;
                                                i74 = i50;
                                            } else if (zzmjVar2 instanceof RandomAccess) {
                                                size = zzmjVar2.size();
                                                i73 = iZzj;
                                                objZzn2 = null;
                                                i75 = 0;
                                                i76 = 0;
                                                while (i75 < size) {
                                                    int i111 = i50;
                                                    num = (Integer) zzmjVar2.get(i75);
                                                    iIntValue2 = num.intValue();
                                                    if (zzmgVarZzu2.zza(iIntValue2)) {
                                                        if (i75 != i76) {
                                                            zzmjVar2.set(i76, num);
                                                        }
                                                        i76++;
                                                    } else {
                                                        objZzn2 = zznu.zzn(obj4, i40, iIntValue2, objZzn2, zzoeVar);
                                                    }
                                                    i75++;
                                                    i50 = i111;
                                                }
                                                i74 = i50;
                                                if (i76 != size) {
                                                    zzmjVar2.subList(i76, size).clear();
                                                }
                                            } else {
                                                i73 = iZzj;
                                                i74 = i50;
                                                it2 = zzmjVar2.iterator();
                                                objZzn = null;
                                                while (it2.hasNext()) {
                                                    iIntValue = ((Integer) it2.next()).intValue();
                                                    if (!zzmgVarZzu2.zza(iIntValue)) {
                                                        objZzn = zznu.zzn(obj4, i40, iIntValue, objZzn, zzoeVar);
                                                        it2.remove();
                                                    }
                                                }
                                            }
                                            iZzg = i73;
                                            i51 = i72;
                                            unsafe = unsafe;
                                            i14 = i74;
                                            i52 = i40;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i72 = i18;
                                            if (i16 == 2) {
                                                int i112 = zzkt.zza;
                                                zzmeVar4 = (zzme) zzmjVar2;
                                                iZzh13 = zzkt.zzh(bArr, i42, zzksVar3);
                                                i77 = zzksVar3.zza + iZzh13;
                                                while (iZzh13 < i77) {
                                                    iZzh13 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                    zzmeVar4.zzh(zzlg.zzb(zzksVar3.zza));
                                                }
                                                if (iZzh13 != i77) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else if (i16 == 0) {
                                                this = this;
                                                i51 = i72;
                                                i52 = i40;
                                                i14 = i50;
                                                i81 = i81;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                                break;
                                            } else {
                                                int i113 = zzkt.zza;
                                                zzmeVar3 = (zzme) zzmjVar2;
                                                iZzh13 = zzkt.zzh(bArr, i42, zzksVar3);
                                                zzmeVar3.zzh(zzlg.zzb(zzksVar3.zza));
                                                while (iZzh13 < i81) {
                                                    iZzh14 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                    if (i72 == zzksVar3.zza) {
                                                        iZzh13 = zzkt.zzh(bArr, iZzh14, zzksVar3);
                                                        zzmeVar3.zzh(zzlg.zzb(zzksVar3.zza));
                                                    }
                                                }
                                            }
                                            iZzg = iZzh13;
                                            i51 = i72;
                                            i52 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            if (i16 == 2) {
                                                int i114 = zzkt.zza;
                                                zzmwVar6 = (zzmw) zzmjVar2;
                                                iZzh16 = zzkt.zzh(bArr, i42, zzksVar3);
                                                i78 = zzksVar3.zza + iZzh16;
                                                while (iZzh16 < i78) {
                                                    iZzh16 = zzkt.zzk(bArr, iZzh16, zzksVar3);
                                                    zzmwVar6.zzg(zzlg.zzc(zzksVar3.zzb));
                                                }
                                                if (iZzh16 == i78) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh16;
                                                i51 = i18;
                                            } else if (i16 == 0) {
                                                this = this;
                                                i51 = i18;
                                                i52 = i40;
                                                i14 = i50;
                                                i81 = i81;
                                                iZzg = i42;
                                                if (iZzg != i42) {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    i83 = i14;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i52;
                                                    this = this;
                                                    i84 = i51;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i42 = i42;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i9 = iZzg;
                                                    i12 = i52;
                                                    zznkVar = this;
                                                    i15 = i51;
                                                    unsafe3 = unsafe;
                                                    zzksVar2 = zzksVar3;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i115 = zzkt.zza;
                                                zzmwVar5 = (zzmw) zzmjVar2;
                                                iZzh13 = zzkt.zzk(bArr, i42, zzksVar3);
                                                zzmwVar5.zzg(zzlg.zzc(zzksVar3.zzb));
                                                while (true) {
                                                    if (iZzh13 < i81) {
                                                        iZzh15 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                        i72 = i18;
                                                        if (i72 == zzksVar3.zza) {
                                                            iZzh13 = zzkt.zzk(bArr, iZzh15, zzksVar3);
                                                            zzmwVar5.zzg(zzlg.zzc(zzksVar3.zzb));
                                                            i18 = i72;
                                                        }
                                                    } else {
                                                        i72 = i18;
                                                    }
                                                }
                                                iZzg = iZzh13;
                                                i51 = i72;
                                            }
                                            i52 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        default:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar11 = zzmjVar2;
                                            unsafe = unsafe;
                                            i51 = i18;
                                            i52 = i40;
                                            this = this;
                                            i81 = i81;
                                            i14 = i50;
                                            if (i16 == 3) {
                                                i79 = (i51 & (-8)) | 4;
                                                zznsVarZzv = this.zzv(i14);
                                                iZzg = zzkt.zzc(zznsVarZzv, bArr, i42, i2, i79, zzksVar);
                                                zzmjVar11.add(zzksVar3.zzc);
                                                while (iZzg < i81) {
                                                    iZzh17 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i51 == zzksVar3.zza) {
                                                        iZzg = zzkt.zzc(zznsVarZzv, bArr, iZzh17, i2, i79, zzksVar);
                                                        zzmjVar11.add(zzksVar3.zzc);
                                                    }
                                                }
                                            } else {
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                    }
                                } else {
                                    zznkVar = this;
                                    i14 = i41;
                                    i43 = i18;
                                    i12 = i40;
                                    zzksVar2 = zzksVar3;
                                    if (iZzr == 50) {
                                        obj2 = obj;
                                        j2 = iArr[i14 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 1) {
                                                    iZzg = i44 + 8;
                                                    unsafe3.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzkt.zzn(bArr, i44))));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 52:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 5) {
                                                    iZzg = i44 + 4;
                                                    unsafe3.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzkt.zzb(bArr, i44))));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 0) {
                                                    iZzk = zzkt.zzk(bArr, i44, zzksVar2);
                                                    unsafe3.putObject(obj2, j, Long.valueOf(zzksVar2.zzb));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                    iZzg = iZzk;
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 0) {
                                                    iZzk = zzkt.zzh(bArr, i44, zzksVar2);
                                                    unsafe3.putObject(obj2, j, Integer.valueOf(zzksVar2.zza));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                    iZzg = iZzk;
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 1) {
                                                    iZzg = i44 + 8;
                                                    unsafe3.putObject(obj2, j, Long.valueOf(zzkt.zzn(bArr, i44)));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 5) {
                                                    iZzg = i44 + 4;
                                                    unsafe3.putObject(obj2, j, Integer.valueOf(zzkt.zzb(bArr, i44)));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 58:
                                                i14 = i14;
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 0) {
                                                    iZzk = zzkt.zzk(bArr, i44, zzksVar2);
                                                    if (zzksVar2.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    unsafe3.putObject(obj2, j, Boolean.valueOf(z2));
                                                    unsafe3.putInt(obj2, j2, i12);
                                                    iZzg = iZzk;
                                                } else {
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 59:
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                unsafe3 = unsafe;
                                                if (i16 == 2) {
                                                    iZzg = zzkt.zzh(bArr, i44, zzksVar2);
                                                    i46 = zzksVar2.zza;
                                                    if (i46 == 0) {
                                                        unsafe3.putObject(obj2, j, "");
                                                    } else {
                                                        i47 = iZzg + i46;
                                                        if ((i17 & PropertyOptions.DELETE_EXISTING) == 0 && !zzoo.zzd(bArr, iZzg, i47)) {
                                                            throw new zzmm(str);
                                                        }
                                                        unsafe3.putObject(obj2, j, new String(bArr, iZzg, i46, zzmk.zza));
                                                        iZzg = i47;
                                                    }
                                                    unsafe3.putInt(obj2, j2, i12);
                                                } else {
                                                    i14 = i14;
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 60:
                                                if (i16 == 2) {
                                                    Object objZzy = zznkVar.zzy(obj2, i12, i14);
                                                    i44 = i42;
                                                    i45 = i43;
                                                    zzksVar2 = zzksVar2;
                                                    iZzg = zzkt.zzm(objZzy, zznkVar.zzv(i14), bArr, i44, i2, zzksVar);
                                                    zznkVar.zzG(obj2, i12, i14, objZzy);
                                                    i14 = i14;
                                                    unsafe3 = unsafe;
                                                } else {
                                                    i44 = i42;
                                                    i45 = i43;
                                                    i14 = i14;
                                                    unsafe3 = unsafe;
                                                    iZzg = i44;
                                                }
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 61:
                                                i48 = i42;
                                                if (i16 == 2) {
                                                    iZza = zzkt.zza(bArr, i48, zzksVar2);
                                                    unsafe.putObject(obj2, j, zzksVar2.zzc);
                                                    unsafe.putInt(obj2, j2, i12);
                                                    i44 = i48;
                                                    iZzg = iZza;
                                                    i45 = i43;
                                                    unsafe3 = unsafe;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                } else {
                                                    i44 = i48;
                                                    i45 = i43;
                                                    unsafe3 = unsafe;
                                                    iZzg = i44;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                }
                                                break;
                                            case 63:
                                                i48 = i42;
                                                i45 = i43;
                                                if (i16 == 0) {
                                                    iZza = zzkt.zzh(bArr, i48, zzksVar2);
                                                    i49 = zzksVar2.zza;
                                                    zzmgVarZzu = zznkVar.zzu(i14);
                                                    if (zzmgVarZzu != null || zzmgVarZzu.zza(i49)) {
                                                        i43 = i45;
                                                        unsafe.putObject(obj2, j, Integer.valueOf(i49));
                                                        unsafe.putInt(obj2, j2, i12);
                                                    } else {
                                                        i43 = i45;
                                                        zzd(obj).zzj(i43, Long.valueOf(i49));
                                                    }
                                                    i44 = i48;
                                                    iZzg = iZza;
                                                    i45 = i43;
                                                    unsafe3 = unsafe;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                }
                                                i14 = i14;
                                                i44 = i48;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 66:
                                                i48 = i42;
                                                i45 = i43;
                                                if (i16 == 0) {
                                                    iZzh = zzkt.zzh(bArr, i48, zzksVar2);
                                                    unsafe.putObject(obj2, j, Integer.valueOf(zzlg.zzb(zzksVar2.zza)));
                                                    unsafe.putInt(obj2, j2, i12);
                                                    i44 = i48;
                                                    iZzg = iZzh;
                                                    unsafe3 = unsafe;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                }
                                                i14 = i14;
                                                i44 = i48;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 67:
                                                i48 = i42;
                                                i45 = i43;
                                                if (i16 == 0) {
                                                    iZzh = zzkt.zzk(bArr, i48, zzksVar2);
                                                    unsafe.putObject(obj2, j, Long.valueOf(zzlg.zzc(zzksVar2.zzb)));
                                                    unsafe.putInt(obj2, j2, i12);
                                                    i44 = i48;
                                                    iZzg = iZzh;
                                                    unsafe3 = unsafe;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                }
                                                i14 = i14;
                                                i44 = i48;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            case 68:
                                                if (i16 == 3) {
                                                    Object objZzy2 = zznkVar.zzy(obj2, i12, i14);
                                                    i45 = i43;
                                                    int iZzl2 = zzkt.zzl(objZzy2, zznkVar.zzv(i14), bArr, i42, i2, (i43 & (-8)) | 4, zzksVar);
                                                    zznkVar.zzG(obj2, i12, i14, objZzy2);
                                                    i14 = i14;
                                                    i44 = i42;
                                                    iZzg = iZzl2;
                                                    obj2 = obj2;
                                                    unsafe3 = unsafe;
                                                    if (iZzg != i44) {
                                                        i12 = i12;
                                                        i81 = i2;
                                                        i86 = i12;
                                                        unsafe3 = unsafe3;
                                                        this = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar5 = zzksVar2;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        i83 = i14;
                                                        i84 = i45;
                                                    } else {
                                                        i12 = i12;
                                                        i4 = i3;
                                                        i9 = iZzg;
                                                        i14 = i14;
                                                        i15 = i45;
                                                    }
                                                    break;
                                                }
                                            default:
                                                i44 = i42;
                                                i45 = i43;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i16 == 2) {
                                            Object objZzw = zznkVar.zzw(i14);
                                            object = unsafe.getObject(obj, j);
                                            if (!((zznb) object).zze()) {
                                                zznb zznbVarZzb = zznb.zza().zzb();
                                                zznc.zza(zznbVarZzb, object);
                                                unsafe.putObject(obj, j, zznbVarZzb);
                                            }
                                            throw null;
                                        }
                                        obj2 = obj;
                                        unsafe2 = unsafe;
                                    }
                                }
                                i3 = i3;
                            } else if (i16 == 2) {
                                zzmjVarZzd = (zzmj) unsafe.getObject(obj4, j);
                                if (!zzmjVarZzd.zzc()) {
                                    size2 = zzmjVarZzd.size();
                                    if (size2 == 0) {
                                        i80 = 10;
                                    } else {
                                        i80 = size2 + size2;
                                    }
                                    zzmjVarZzd = zzmjVarZzd.zzd(i80);
                                    unsafe.putObject(obj4, j, zzmjVarZzd);
                                }
                                int iZze2 = zzkt.zze(this.zzv(i41), i18, bArr, i42, i2, zzmjVarZzd, zzksVar);
                                i3 = i3;
                                zzksVar5 = zzksVar3;
                                unsafe3 = unsafe;
                                iZzg = iZze2;
                                i83 = i41;
                                i81 = i81;
                                i87 = i11;
                                i84 = i18;
                                i82 = 0;
                                i85 = i10;
                                i86 = i40;
                            } else {
                                obj2 = obj4;
                                i43 = i18;
                                zznkVar = this;
                                i14 = i41;
                                i12 = i40;
                                zzksVar2 = zzksVar3;
                                unsafe2 = unsafe;
                            }
                            i4 = i3;
                            i9 = i42;
                            i15 = i43;
                            zzksVar2 = zzksVar2;
                            unsafe3 = unsafe2;
                        }
                    }
                    if (i15 == i4 || i4 == 0) {
                        if (zznkVar.zzh) {
                            zzlpVar = zzksVar2.zzd;
                            int i116 = zzlp.zzb;
                            int i117 = zznp.zza;
                            if (zzlpVar != zzlp.zza) {
                                zznhVar = zznkVar.zzg;
                                int i118 = zzkt.zza;
                                if (zzlpVar.zzb(zznhVar, i12) == null) {
                                    throw null;
                                }
                                iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                            } else {
                                iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                            }
                        } else {
                            iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                        }
                        i83 = i14;
                        this = zznkVar;
                        obj4 = obj2;
                        i84 = i15;
                        zzksVar5 = zzksVar2;
                        i86 = i12;
                        i87 = i11;
                        i82 = i13;
                        i85 = i10;
                        i81 = i2;
                        i3 = i4;
                    } else {
                        iZzg = i9;
                        unsafe3 = unsafe3;
                        i84 = i15;
                        i87 = i11;
                        i85 = i10;
                        i5 = 1048575;
                    }
                }
                i8 = iZzq;
                i7 = -1;
                if (i8 == i7) {
                    i9 = iZzi;
                    i10 = i85;
                    i11 = i87;
                    i12 = i90;
                    i13 = i82;
                    unsafe3 = unsafe3;
                    i4 = i3;
                    obj2 = obj4;
                    zzksVar2 = zzksVar5;
                    zznkVar = this;
                    i14 = i13;
                    i15 = i6;
                } else {
                    i16 = i6 & 7;
                    iArr = this.zzc;
                    i17 = iArr[i8 + 1];
                    i18 = i6;
                    iZzr = zzr(i17);
                    j = i17 & 1048575;
                    i19 = i90;
                    str = "Protocol message had invalid UTF-8.";
                    if (iZzr <= 17) {
                        int i910 = iArr[i8 + 2];
                        i20 = 1 << (i910 >>> 20);
                        i21 = i910 & 1048575;
                        if (i21 != i87) {
                            if (i87 != 1048575) {
                                unsafe3.putInt(obj4, i87, i85);
                            }
                            if (i21 == 1048575) {
                                i85 = 0;
                            } else {
                                i85 = unsafe3.getInt(obj4, i21);
                            }
                            i11 = i21;
                        } else {
                            i11 = i87;
                        }
                        switch (iZzr) {
                            case 0:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 1) {
                                    iZzg = i22 + 8;
                                    i85 |= i20;
                                    zzol.zzo(obj4, j, Double.longBitsToDouble(zzkt.zzn(bArr, i22)));
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 1:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 5) {
                                    iZzg = i22 + 4;
                                    i85 |= i20;
                                    zzol.zzp(obj4, j, Float.intBitsToFloat(zzkt.zzb(bArr, i22)));
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 2:
                            case 3:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 0) {
                                    int i911 = i85 | i20;
                                    int iZzk4 = zzkt.zzk(bArr, i22, zzksVar5);
                                    unsafe3.putLong(obj, j, zzksVar5.zzb);
                                    i85 = i911;
                                    iZzg = iZzk4;
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 4:
                            case 11:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 0) {
                                    i85 |= i20;
                                    iZzg = zzkt.zzh(bArr, i22, zzksVar5);
                                    unsafe3.putInt(obj4, j, zzksVar5.zza);
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 5:
                            case 14:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 1) {
                                    unsafe3.putLong(obj, j, zzkt.zzn(bArr, i22));
                                    iZzg = i22 + 8;
                                    i85 = i20 | i85;
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 6:
                            case 13:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 5) {
                                    iZzg = i22 + 4;
                                    i85 |= i20;
                                    unsafe3.putInt(obj4, j, zzkt.zzb(bArr, i22));
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 7:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 0) {
                                    i85 |= i20;
                                    iZzg = zzkt.zzk(bArr, i22, zzksVar5);
                                    if (zzksVar5.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzol.zzm(obj4, j, z);
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 8:
                                i26 = iZzi;
                                i23 = i8;
                                i27 = i18;
                                if (i16 == 2) {
                                    if ((i17 & PropertyOptions.DELETE_EXISTING) != 0) {
                                        iZzg = zzkt.zzh(bArr, i26, zzksVar5);
                                        i29 = zzksVar5.zza;
                                        if (i29 >= 0) {
                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i30 = i85 | i20;
                                        if (i29 == 0) {
                                            zzksVar5.zzc = "";
                                            i33 = i30;
                                            i18 = i27;
                                            i82 = 0;
                                        } else {
                                            int i912 = zzoo.zza;
                                            length = bArr.length;
                                            if ((((length - iZzg) - i29) | iZzg | i29) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i29)));
                                            }
                                            i31 = iZzg + i29;
                                            cArr = new char[i29];
                                            i32 = 0;
                                            while (iZzg < i31) {
                                                b3 = bArr[iZzg];
                                                if (zzom.zzd(b3)) {
                                                    iZzg++;
                                                    cArr[i32] = (char) b3;
                                                    i32++;
                                                } else {
                                                    while (iZzg < i31) {
                                                        i34 = iZzg + 1;
                                                        b = bArr[iZzg];
                                                        if (zzom.zzd(b)) {
                                                            cArr[i32] = (char) b;
                                                            i32++;
                                                            iZzg = i34;
                                                            while (iZzg < i31) {
                                                                b2 = bArr[iZzg];
                                                                if (zzom.zzd(b2)) {
                                                                }
                                                                iZzg++;
                                                                cArr[i32] = (char) b2;
                                                                i32++;
                                                                break;
                                                            }
                                                        } else {
                                                            i35 = i30;
                                                            if (b < -32) {
                                                                i36 = i27;
                                                                str2 = str;
                                                                if (b < -16) {
                                                                    if (i34 < i31 - 1) {
                                                                        throw new zzmm(str2);
                                                                    }
                                                                    zzom.zzb(b, bArr[i34], bArr[iZzg + 2], cArr, i32);
                                                                    str = str2;
                                                                    i32++;
                                                                    i30 = i35;
                                                                    i27 = i36;
                                                                    iZzg += 3;
                                                                } else {
                                                                    if (i34 < i31 - 2) {
                                                                        throw new zzmm(str2);
                                                                    }
                                                                    byte b8 = bArr[i34];
                                                                    int i913 = iZzg + 3;
                                                                    byte b9 = bArr[iZzg + 2];
                                                                    iZzg += 4;
                                                                    zzom.zza(b, b8, b9, bArr[i913], cArr, i32);
                                                                    i32 += 2;
                                                                    str = str2;
                                                                    i30 = i35;
                                                                    i27 = i36;
                                                                }
                                                            } else {
                                                                if (i34 < i31) {
                                                                    throw new zzmm(str);
                                                                }
                                                                iZzg += 2;
                                                                zzom.zzc(b, bArr[i34], cArr, i32);
                                                                i32++;
                                                                i30 = i35;
                                                            }
                                                        }
                                                    }
                                                    i33 = i30;
                                                    i18 = i27;
                                                    i82 = 0;
                                                    zzksVar5.zzc = new String(cArr, 0, i32);
                                                    iZzg = i31;
                                                }
                                            }
                                            while (iZzg < i31) {
                                                i34 = iZzg + 1;
                                                b = bArr[iZzg];
                                                if (zzom.zzd(b)) {
                                                    cArr[i32] = (char) b;
                                                    i32++;
                                                    iZzg = i34;
                                                    while (iZzg < i31) {
                                                        b2 = bArr[iZzg];
                                                        if (zzom.zzd(b2)) {
                                                        }
                                                        iZzg++;
                                                        cArr[i32] = (char) b2;
                                                        i32++;
                                                        break;
                                                    }
                                                } else {
                                                    i35 = i30;
                                                    if (b < -32) {
                                                        i36 = i27;
                                                        str2 = str;
                                                        if (b < -16) {
                                                            if (i34 < i31 - 1) {
                                                                throw new zzmm(str2);
                                                            }
                                                            zzom.zzb(b, bArr[i34], bArr[iZzg + 2], cArr, i32);
                                                            str = str2;
                                                            i32++;
                                                            i30 = i35;
                                                            i27 = i36;
                                                            iZzg += 3;
                                                        } else {
                                                            if (i34 < i31 - 2) {
                                                                throw new zzmm(str2);
                                                            }
                                                            byte b10 = bArr[i34];
                                                            int i914 = iZzg + 3;
                                                            byte b11 = bArr[iZzg + 2];
                                                            iZzg += 4;
                                                            zzom.zza(b, b10, b11, bArr[i914], cArr, i32);
                                                            i32 += 2;
                                                            str = str2;
                                                            i30 = i35;
                                                            i27 = i36;
                                                        }
                                                    } else {
                                                        if (i34 < i31) {
                                                            throw new zzmm(str);
                                                        }
                                                        iZzg += 2;
                                                        zzom.zzc(b, bArr[i34], cArr, i32);
                                                        i32++;
                                                        i30 = i35;
                                                    }
                                                }
                                            }
                                            i33 = i30;
                                            i18 = i27;
                                            i82 = 0;
                                            zzksVar5.zzc = new String(cArr, 0, i32);
                                            iZzg = i31;
                                        }
                                        i85 = i33;
                                    } else {
                                        i18 = i27;
                                        i82 = 0;
                                        iZzg = zzkt.zzh(bArr, i26, zzksVar5);
                                        i28 = zzksVar5.zza;
                                        if (i28 >= 0) {
                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i85 |= i20;
                                        if (i28 == 0) {
                                            zzksVar5.zzc = "";
                                        } else {
                                            zzksVar5.zzc = new String(bArr, iZzg, i28, zzmk.zza);
                                            iZzg += i28;
                                        }
                                    }
                                    unsafe3.putObject(obj4, j, zzksVar5.zzc);
                                    i83 = i23;
                                    i87 = i11;
                                    i84 = i18;
                                    i86 = i19;
                                    i81 = i2;
                                } else {
                                    i24 = i26;
                                    i18 = i27;
                                    i25 = i23;
                                    i13 = 0;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 9:
                                i37 = i8;
                                i38 = i18;
                                if (i16 == 2) {
                                    int i915 = i85 | i20;
                                    Object objZzx3 = this.zzx(obj4, i37);
                                    iZzg = zzkt.zzm(objZzx3, this.zzv(i37), bArr, iZzi, i2, zzksVar);
                                    this.zzF(obj4, i37, objZzx3);
                                    i85 = i915;
                                    i84 = i38;
                                    i83 = i37;
                                    i87 = i11;
                                    i86 = i19;
                                    i82 = 0;
                                    i81 = i2;
                                    i3 = i3;
                                } else {
                                    i24 = iZzi;
                                    i85 = i85;
                                    unsafe3 = unsafe3;
                                    zzksVar5 = zzksVar5;
                                    i18 = i38;
                                    i25 = i37;
                                    i19 = i19;
                                    i13 = 0;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 10:
                                i37 = i8;
                                i38 = i18;
                                if (i16 == 2) {
                                    i85 |= i20;
                                    iZzg = zzkt.zza(bArr, iZzi, zzksVar5);
                                    unsafe3.putObject(obj4, j, zzksVar5.zzc);
                                    i84 = i38;
                                    i83 = i37;
                                    i87 = i11;
                                    i86 = i19;
                                    i82 = 0;
                                    i81 = i2;
                                    i3 = i3;
                                } else {
                                    i24 = iZzi;
                                    i85 = i85;
                                    unsafe3 = unsafe3;
                                    zzksVar5 = zzksVar5;
                                    i18 = i38;
                                    i25 = i37;
                                    i19 = i19;
                                    i13 = 0;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 12:
                                i37 = i8;
                                i38 = i18;
                                if (i16 == 0) {
                                    iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                    i39 = zzksVar5.zza;
                                    zzmg zzmgVarZzu4 = this.zzu(i37);
                                    if ((i17 & Integer.MIN_VALUE) != 0) {
                                        i85 |= i20;
                                        unsafe3.putInt(obj4, j, i39);
                                    } else {
                                        i85 |= i20;
                                        unsafe3.putInt(obj4, j, i39);
                                    }
                                    i84 = i38;
                                    i83 = i37;
                                    i87 = i11;
                                    i86 = i19;
                                    i82 = 0;
                                    i81 = i2;
                                    i3 = i3;
                                } else {
                                    i24 = iZzi;
                                    i85 = i85;
                                    unsafe3 = unsafe3;
                                    zzksVar5 = zzksVar5;
                                    i18 = i38;
                                    i25 = i37;
                                    i19 = i19;
                                    i13 = 0;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 15:
                                i37 = i8;
                                i38 = i18;
                                if (i16 == 0) {
                                    i85 |= i20;
                                    iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                    unsafe3.putInt(obj4, j, zzlg.zzb(zzksVar5.zza));
                                    i84 = i38;
                                    i83 = i37;
                                    i87 = i11;
                                    i86 = i19;
                                    i82 = 0;
                                    i81 = i2;
                                    i3 = i3;
                                } else {
                                    i24 = iZzi;
                                    i85 = i85;
                                    unsafe3 = unsafe3;
                                    zzksVar5 = zzksVar5;
                                    i18 = i38;
                                    i25 = i37;
                                    i19 = i19;
                                    i13 = 0;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            case 16:
                                if (i16 == 0) {
                                    int i916 = i85 | i20;
                                    int iZzk5 = zzkt.zzk(bArr, iZzi, zzksVar5);
                                    i37 = i8;
                                    i38 = i18;
                                    unsafe3.putLong(obj, j, zzlg.zzc(zzksVar5.zzb));
                                    i85 = i916;
                                    iZzg = iZzk5;
                                    i84 = i38;
                                    i83 = i37;
                                    i87 = i11;
                                    i86 = i19;
                                    i82 = 0;
                                    i81 = i2;
                                    i3 = i3;
                                } else {
                                    i24 = iZzi;
                                    i85 = i85;
                                    unsafe3 = unsafe3;
                                    zzksVar5 = zzksVar5;
                                    i13 = 0;
                                    i25 = i8;
                                    i19 = i19;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                            default:
                                i22 = iZzi;
                                i23 = i8;
                                i82 = 0;
                                if (i16 == 3) {
                                    Object objZzx4 = this.zzx(obj4, i23);
                                    int iZzl3 = zzkt.zzl(objZzx4, this.zzv(i23), bArr, i22, i2, (i19 << 3) | 4, zzksVar);
                                    this.zzF(obj4, i23, objZzx4);
                                    i3 = i3;
                                    zzksVar5 = zzksVar;
                                    i86 = i19;
                                    unsafe3 = unsafe3;
                                    i83 = i23;
                                    i81 = i2;
                                    iZzg = iZzl3;
                                    i87 = i11;
                                    i84 = i18;
                                    i82 = 0;
                                    i85 |= i20;
                                } else {
                                    i24 = i22;
                                    i13 = i82;
                                    i25 = i23;
                                    zzksVar2 = zzksVar5;
                                    unsafe3 = unsafe3;
                                    i10 = i85;
                                    i15 = i18;
                                    obj2 = obj4;
                                    zznkVar = this;
                                    i14 = i25;
                                    i12 = i19;
                                    i9 = i24;
                                    i4 = i3;
                                }
                                break;
                        }
                    } else {
                        i11 = i87;
                        i40 = i19;
                        i13 = 0;
                        i81 = i2;
                        i10 = i85;
                        i41 = i8;
                        zzks zzksVar7 = zzksVar5;
                        i42 = iZzi;
                        zzksVar3 = zzksVar7;
                        unsafe = unsafe3;
                        if (iZzr == 27) {
                            if (iZzr <= 49) {
                                j3 = i17;
                                i50 = i41;
                                zzmjVar = (zzmj) unsafe.getObject(obj4, j);
                                if (zzmjVar.zzc()) {
                                    int size4 = zzmjVar.size();
                                    zzmj zzmjVarZzd3 = zzmjVar.zzd(size4 + size4);
                                    unsafe.putObject(obj4, j, zzmjVarZzd3);
                                    zzmjVar2 = zzmjVarZzd3;
                                } else {
                                    zzmjVar2 = zzmjVar;
                                }
                                switch (iZzr) {
                                    case 18:
                                    case 35:
                                        zzksVar3 = zzksVar3;
                                        zzmjVar3 = zzmjVar2;
                                        unsafe = unsafe;
                                        i51 = i18;
                                        i52 = i40;
                                        this = this;
                                        i81 = i81;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            int i917 = zzkt.zza;
                                            zzlmVar2 = (zzlm) zzmjVar3;
                                            iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                            i53 = zzksVar3.zza;
                                            i54 = iZzh3 + i53;
                                            if (i54 <= bArr.length) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzlmVar2.zzg(zzlmVar2.size() + (i53 / 8));
                                            while (iZzh3 < i54) {
                                                zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh3)));
                                                iZzh3 += 8;
                                            }
                                            if (iZzh3 != i54) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzg = iZzh3;
                                        } else if (i16 == 1) {
                                            iZzg = i42 + 8;
                                            int i918 = zzkt.zza;
                                            zzlmVar = (zzlm) zzmjVar3;
                                            zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, i42)));
                                            while (iZzg < i81) {
                                                iZzh2 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                if (i51 == zzksVar3.zza) {
                                                    zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh2)));
                                                    iZzg = iZzh2 + 8;
                                                }
                                            }
                                        } else {
                                            iZzg = i42;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        zzksVar3 = zzksVar3;
                                        zzmjVar4 = zzmjVar2;
                                        unsafe = unsafe;
                                        i51 = i18;
                                        i52 = i40;
                                        this = this;
                                        i81 = i81;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            int i1010 = zzkt.zza;
                                            zzlwVar2 = (zzlw) zzmjVar4;
                                            iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                            i55 = zzksVar3.zza;
                                            i56 = iZzh3 + i55;
                                            if (i56 <= bArr.length) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzlwVar2.zzg(zzlwVar2.size() + (i55 / 4));
                                            while (iZzh3 < i56) {
                                                zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh3)));
                                                iZzh3 += 4;
                                            }
                                            if (iZzh3 != i56) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzg = iZzh3;
                                        } else if (i16 == 5) {
                                            iZzg = i42 + 4;
                                            int i1011 = zzkt.zza;
                                            zzlwVar = (zzlw) zzmjVar4;
                                            zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, i42)));
                                            while (iZzg < i81) {
                                                iZzh4 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                if (i51 == zzksVar3.zza) {
                                                    zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh4)));
                                                    iZzg = iZzh4 + 4;
                                                }
                                            }
                                        } else {
                                            iZzg = i42;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        zzksVar3 = zzksVar3;
                                        zzmjVar5 = zzmjVar2;
                                        unsafe = unsafe;
                                        i51 = i18;
                                        i52 = i40;
                                        this = this;
                                        i81 = i81;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            if (i16 == 0) {
                                                int i1012 = zzkt.zza;
                                                zzmwVar = (zzmw) zzmjVar5;
                                                iZzh3 = zzkt.zzk(bArr, i42, zzksVar3);
                                                zzmwVar.zzg(zzksVar3.zzb);
                                                while (iZzh3 < i81) {
                                                    iZzh5 = zzkt.zzh(bArr, iZzh3, zzksVar3);
                                                    if (i51 == zzksVar3.zza) {
                                                        iZzh3 = zzkt.zzk(bArr, iZzh5, zzksVar3);
                                                        zzmwVar.zzg(zzksVar3.zzb);
                                                    }
                                                }
                                            } else {
                                                iZzg = i42;
                                            }
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i1013 = zzkt.zza;
                                            zzmwVar2 = (zzmw) zzmjVar5;
                                            iZzh3 = zzkt.zzh(bArr, i42, zzksVar3);
                                            i57 = zzksVar3.zza + iZzh3;
                                            while (iZzh3 < i57) {
                                                iZzh3 = zzkt.zzk(bArr, iZzh3, zzksVar3);
                                                zzmwVar2.zzg(zzksVar3.zzb);
                                            }
                                            if (iZzh3 != i57) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        iZzg = iZzh3;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        zzksVar4 = zzksVar3;
                                        zzmjVar6 = zzmjVar2;
                                        unsafe = unsafe;
                                        i58 = i18;
                                        i81 = i81;
                                        zznkVar2 = this;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            iZzf = zzkt.zzf(bArr, i42, zzmjVar6, zzksVar4);
                                            i51 = i58;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                        } else if (i16 == 0) {
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            i52 = i40;
                                            this = zznkVar2;
                                            iZzg = zzkt.zzj(i58, bArr, i42, i2, zzmjVar6, zzksVar);
                                        } else {
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            iZzg = i42;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        zzksVar4 = zzksVar3;
                                        zzmjVar7 = zzmjVar2;
                                        unsafe = unsafe;
                                        i58 = i18;
                                        i81 = i81;
                                        zznkVar2 = this;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            if (i16 == 1) {
                                                iZzf = i42 + 8;
                                                int i1014 = zzkt.zza;
                                                zzmwVar3 = (zzmw) zzmjVar7;
                                                zzmwVar3.zzg(zzkt.zzn(bArr, i42));
                                                while (iZzf < i81) {
                                                    iZzh6 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                    if (i58 == zzksVar4.zza) {
                                                        zzmwVar3.zzg(zzkt.zzn(bArr, iZzh6));
                                                        iZzf = iZzh6 + 8;
                                                    }
                                                }
                                            }
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i1015 = zzkt.zza;
                                            zzmwVar4 = (zzmw) zzmjVar7;
                                            iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                            i59 = zzksVar4.zza;
                                            i60 = iZzf + i59;
                                            if (i60 <= bArr.length) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzmwVar4.zzh(zzmwVar4.size() + (i59 / 8));
                                            while (iZzf < i60) {
                                                zzmwVar4.zzg(zzkt.zzn(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i60) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i51 = i58;
                                        iZzg = iZzf;
                                        zzksVar3 = zzksVar4;
                                        this = zznkVar2;
                                        i52 = i40;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        zzksVar4 = zzksVar3;
                                        zzmjVar8 = zzmjVar2;
                                        unsafe = unsafe;
                                        i58 = i18;
                                        i81 = i81;
                                        zznkVar2 = this;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            if (i16 == 5) {
                                                iZzf = i42 + 4;
                                                int i1016 = zzkt.zza;
                                                zzmeVar = (zzme) zzmjVar8;
                                                zzmeVar.zzh(zzkt.zzb(bArr, i42));
                                                while (iZzf < i81) {
                                                    iZzh7 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                    if (i58 == zzksVar4.zza) {
                                                        zzmeVar.zzh(zzkt.zzb(bArr, iZzh7));
                                                        iZzf = iZzh7 + 4;
                                                    }
                                                }
                                            }
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i1017 = zzkt.zza;
                                            zzmeVar2 = (zzme) zzmjVar8;
                                            iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                            i61 = zzksVar4.zza;
                                            i62 = iZzf + i61;
                                            if (i62 <= bArr.length) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzmeVar2.zzi(zzmeVar2.size() + (i61 / 4));
                                            while (iZzf < i62) {
                                                zzmeVar2.zzh(zzkt.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i62) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i51 = i58;
                                        iZzg = iZzf;
                                        zzksVar3 = zzksVar4;
                                        this = zznkVar2;
                                        i52 = i40;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        zzksVar4 = zzksVar3;
                                        zzmjVar9 = zzmjVar2;
                                        unsafe = unsafe;
                                        i58 = i18;
                                        i81 = i81;
                                        zznkVar2 = this;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            if (i16 == 0) {
                                                int i1018 = zzkt.zza;
                                                zzkuVar = (zzku) zzmjVar9;
                                                iZzf = zzkt.zzk(bArr, i42, zzksVar4);
                                                if (zzksVar4.zzb != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                zzkuVar.zze(z3);
                                                while (iZzf < i81) {
                                                    iZzh8 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                    if (i58 == zzksVar4.zza) {
                                                        iZzf = zzkt.zzk(bArr, iZzh8, zzksVar4);
                                                        if (zzksVar4.zzb != 0) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        zzkuVar.zze(z4);
                                                    }
                                                }
                                            }
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i1019 = zzkt.zza;
                                            zzkuVar2 = (zzku) zzmjVar9;
                                            iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                            i63 = zzksVar4.zza + iZzf;
                                            while (iZzf < i63) {
                                                iZzf = zzkt.zzk(bArr, iZzf, zzksVar4);
                                                if (zzksVar4.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                zzkuVar2.zze(z5);
                                            }
                                            if (iZzf != i63) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i51 = i58;
                                        iZzg = iZzf;
                                        zzksVar3 = zzksVar4;
                                        this = zznkVar2;
                                        i52 = i40;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 26:
                                        zzksVar4 = zzksVar3;
                                        zzmjVar10 = zzmjVar2;
                                        unsafe = unsafe;
                                        i58 = i18;
                                        i40 = i40;
                                        i81 = i81;
                                        zznkVar2 = this;
                                        i14 = i50;
                                        if (i16 == 2) {
                                            i51 = i58;
                                            zzksVar3 = zzksVar4;
                                            i52 = i40;
                                            this = zznkVar2;
                                            iZzg = i42;
                                        } else if ((j3 & 536870912) == 0) {
                                            iZzh10 = zzkt.zzh(bArr, i42, zzksVar4);
                                            i68 = zzksVar4.zza;
                                            if (i68 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i68 == 0) {
                                                obj3 = "";
                                                zzmjVar10.add(obj3);
                                            } else {
                                                obj3 = "";
                                                zzmjVar10.add(new String(bArr, iZzh10, i68, zzmk.zza));
                                                iZzh10 += i68;
                                            }
                                            while (iZzh10 < i81) {
                                                iZzh11 = zzkt.zzh(bArr, iZzh10, zzksVar4);
                                                if (i58 == zzksVar4.zza) {
                                                    iZzh10 = zzkt.zzh(bArr, iZzh11, zzksVar4);
                                                    i69 = zzksVar4.zza;
                                                    if (i69 >= 0) {
                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i69 == 0) {
                                                        zzmjVar10.add(obj3);
                                                    } else {
                                                        zzmjVar10.add(new String(bArr, iZzh10, i69, zzmk.zza));
                                                        iZzh10 += i69;
                                                    }
                                                } else {
                                                    i51 = i58;
                                                    iZzg = iZzh10;
                                                    zzksVar3 = zzksVar4;
                                                    i52 = i40;
                                                    this = zznkVar2;
                                                }
                                            }
                                            i51 = i58;
                                            iZzg = iZzh10;
                                            zzksVar3 = zzksVar4;
                                            i52 = i40;
                                            this = zznkVar2;
                                        } else {
                                            iZzf = zzkt.zzh(bArr, i42, zzksVar4);
                                            i64 = zzksVar4.zza;
                                            if (i64 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i64 == 0) {
                                                zzmjVar10.add("");
                                            } else {
                                                i65 = iZzf + i64;
                                                if (zzoo.zzd(bArr, iZzf, i65)) {
                                                    throw new zzmm(r3);
                                                }
                                                zzmjVar10.add(new String(bArr, iZzf, i64, zzmk.zza));
                                                iZzf = i65;
                                            }
                                            while (iZzf < i81) {
                                                iZzh9 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                if (i58 == zzksVar4.zza) {
                                                    iZzf = zzkt.zzh(bArr, iZzh9, zzksVar4);
                                                    i66 = zzksVar4.zza;
                                                    if (i66 >= 0) {
                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i66 == 0) {
                                                        zzmjVar10.add("");
                                                    } else {
                                                        i67 = iZzf + i66;
                                                        if (zzoo.zzd(bArr, iZzf, i67)) {
                                                            throw new zzmm(str);
                                                        }
                                                        zzmjVar10.add(new String(bArr, iZzf, i66, zzmk.zza));
                                                        iZzf = i67;
                                                    }
                                                } else {
                                                    i51 = i58;
                                                    iZzg = iZzf;
                                                    zzksVar3 = zzksVar4;
                                                    this = zznkVar2;
                                                    i52 = i40;
                                                }
                                            }
                                            i51 = i58;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            this = zznkVar2;
                                            i52 = i40;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 27:
                                        zzksVar3 = zzksVar3;
                                        i40 = i40;
                                        i14 = i50;
                                        i81 = i81;
                                        if (i16 == 2) {
                                            unsafe = unsafe;
                                            int iZze3 = zzkt.zze(zzv(i14), i18, bArr, i42, i2, zzmjVar2, zzksVar);
                                            i51 = i18;
                                            i52 = i40;
                                            this = this;
                                            iZzg = iZze3;
                                        } else {
                                            unsafe = unsafe;
                                            i51 = i18;
                                            i52 = i40;
                                            iZzg = i42;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 28:
                                        zzksVar3 = zzksVar3;
                                        i40 = i40;
                                        i14 = i50;
                                        i81 = i81;
                                        if (i16 == 2) {
                                            iZzg = zzkt.zzh(bArr, i42, zzksVar3);
                                            i70 = zzksVar3.zza;
                                            if (i70 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i70 <= bArr.length - iZzg) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i70 == 0) {
                                                zzmjVar2.add(zzld.zzb);
                                            } else {
                                                zzmjVar2.add(zzld.zzj(bArr, iZzg, i70));
                                                iZzg += i70;
                                            }
                                            while (iZzg < i81) {
                                                iZzh12 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                if (i18 == zzksVar3.zza) {
                                                    i51 = i18;
                                                    unsafe = unsafe;
                                                    i52 = i40;
                                                    if (iZzg != i42) {
                                                        i42 = i42;
                                                        i81 = i81;
                                                        zzksVar3 = zzksVar3;
                                                        obj4 = obj;
                                                        i83 = i14;
                                                        zzksVar5 = zzksVar3;
                                                        i86 = i52;
                                                        this = this;
                                                        i84 = i51;
                                                        i87 = i11;
                                                        i82 = 0;
                                                        i85 = i10;
                                                        unsafe3 = unsafe;
                                                    } else {
                                                        i42 = i42;
                                                        i81 = i81;
                                                        zzksVar3 = zzksVar3;
                                                        obj2 = obj;
                                                        i9 = iZzg;
                                                        i12 = i52;
                                                        zznkVar = this;
                                                        i15 = i51;
                                                        unsafe3 = unsafe;
                                                        zzksVar2 = zzksVar3;
                                                        i4 = i3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzg = zzkt.zzh(bArr, iZzh12, zzksVar3);
                                                    i71 = zzksVar3.zza;
                                                    if (i71 >= 0) {
                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i71 <= bArr.length - iZzg) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i71 == 0) {
                                                        zzmjVar2.add(zzld.zzb);
                                                    } else {
                                                        zzmjVar2.add(zzld.zzj(bArr, iZzg, i71));
                                                        iZzg += i71;
                                                    }
                                                }
                                            }
                                            i51 = i18;
                                            unsafe = unsafe;
                                            i52 = i40;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            i51 = i18;
                                            unsafe = unsafe;
                                            i52 = i40;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i72 = i18;
                                        if (i16 == 2) {
                                            iZzj = zzkt.zzf(bArr, i42, zzmjVar2, zzksVar3);
                                        } else if (i16 == 0) {
                                            this = this;
                                            i51 = i72;
                                            i52 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            iZzj = zzkt.zzj(i72, bArr, i42, i2, zzmjVar2, zzksVar);
                                        }
                                        zzmgVarZzu2 = this.zzu(i50);
                                        zzoeVar = this.zzl;
                                        int i119 = zznu.zza;
                                        if (zzmgVarZzu2 != null) {
                                            i73 = iZzj;
                                            i74 = i50;
                                        } else if (zzmjVar2 instanceof RandomAccess) {
                                            size = zzmjVar2.size();
                                            i73 = iZzj;
                                            objZzn2 = null;
                                            i75 = 0;
                                            i76 = 0;
                                            while (i75 < size) {
                                                int i1110 = i50;
                                                num = (Integer) zzmjVar2.get(i75);
                                                iIntValue2 = num.intValue();
                                                if (zzmgVarZzu2.zza(iIntValue2)) {
                                                    if (i75 != i76) {
                                                        zzmjVar2.set(i76, num);
                                                    }
                                                    i76++;
                                                } else {
                                                    objZzn2 = zznu.zzn(obj4, i40, iIntValue2, objZzn2, zzoeVar);
                                                }
                                                i75++;
                                                i50 = i1110;
                                            }
                                            i74 = i50;
                                            if (i76 != size) {
                                                zzmjVar2.subList(i76, size).clear();
                                            }
                                        } else {
                                            i73 = iZzj;
                                            i74 = i50;
                                            it2 = zzmjVar2.iterator();
                                            objZzn = null;
                                            while (it2.hasNext()) {
                                                iIntValue = ((Integer) it2.next()).intValue();
                                                if (!zzmgVarZzu2.zza(iIntValue)) {
                                                    objZzn = zznu.zzn(obj4, i40, iIntValue, objZzn, zzoeVar);
                                                    it2.remove();
                                                }
                                            }
                                        }
                                        iZzg = i73;
                                        i51 = i72;
                                        unsafe = unsafe;
                                        i14 = i74;
                                        i52 = i40;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i72 = i18;
                                        if (i16 == 2) {
                                            int i1111 = zzkt.zza;
                                            zzmeVar4 = (zzme) zzmjVar2;
                                            iZzh13 = zzkt.zzh(bArr, i42, zzksVar3);
                                            i77 = zzksVar3.zza + iZzh13;
                                            while (iZzh13 < i77) {
                                                iZzh13 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                zzmeVar4.zzh(zzlg.zzb(zzksVar3.zza));
                                            }
                                            if (iZzh13 != i77) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i16 == 0) {
                                            this = this;
                                            i51 = i72;
                                            i52 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                            break;
                                        } else {
                                            int i1112 = zzkt.zza;
                                            zzmeVar3 = (zzme) zzmjVar2;
                                            iZzh13 = zzkt.zzh(bArr, i42, zzksVar3);
                                            zzmeVar3.zzh(zzlg.zzb(zzksVar3.zza));
                                            while (iZzh13 < i81) {
                                                iZzh14 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                if (i72 == zzksVar3.zza) {
                                                    iZzh13 = zzkt.zzh(bArr, iZzh14, zzksVar3);
                                                    zzmeVar3.zzh(zzlg.zzb(zzksVar3.zza));
                                                }
                                            }
                                        }
                                        iZzg = iZzh13;
                                        i51 = i72;
                                        i52 = i40;
                                        i14 = i50;
                                        i81 = i81;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        if (i16 == 2) {
                                            int i1113 = zzkt.zza;
                                            zzmwVar6 = (zzmw) zzmjVar2;
                                            iZzh16 = zzkt.zzh(bArr, i42, zzksVar3);
                                            i78 = zzksVar3.zza + iZzh16;
                                            while (iZzh16 < i78) {
                                                iZzh16 = zzkt.zzk(bArr, iZzh16, zzksVar3);
                                                zzmwVar6.zzg(zzlg.zzc(zzksVar3.zzb));
                                            }
                                            if (iZzh16 == i78) {
                                                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzg = iZzh16;
                                            i51 = i18;
                                        } else if (i16 == 0) {
                                            this = this;
                                            i51 = i18;
                                            i52 = i40;
                                            i14 = i50;
                                            i81 = i81;
                                            iZzg = i42;
                                            if (iZzg != i42) {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                i83 = i14;
                                                zzksVar5 = zzksVar3;
                                                i86 = i52;
                                                this = this;
                                                i84 = i51;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                unsafe3 = unsafe;
                                            } else {
                                                i42 = i42;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i9 = iZzg;
                                                i12 = i52;
                                                zznkVar = this;
                                                i15 = i51;
                                                unsafe3 = unsafe;
                                                zzksVar2 = zzksVar3;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i1114 = zzkt.zza;
                                            zzmwVar5 = (zzmw) zzmjVar2;
                                            iZzh13 = zzkt.zzk(bArr, i42, zzksVar3);
                                            zzmwVar5.zzg(zzlg.zzc(zzksVar3.zzb));
                                            while (true) {
                                                if (iZzh13 < i81) {
                                                    iZzh15 = zzkt.zzh(bArr, iZzh13, zzksVar3);
                                                    i72 = i18;
                                                    if (i72 == zzksVar3.zza) {
                                                        iZzh13 = zzkt.zzk(bArr, iZzh15, zzksVar3);
                                                        zzmwVar5.zzg(zzlg.zzc(zzksVar3.zzb));
                                                        i18 = i72;
                                                    }
                                                } else {
                                                    i72 = i18;
                                                }
                                            }
                                            iZzg = iZzh13;
                                            i51 = i72;
                                        }
                                        i52 = i40;
                                        i14 = i50;
                                        i81 = i81;
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                    default:
                                        zzksVar3 = zzksVar3;
                                        zzmjVar11 = zzmjVar2;
                                        unsafe = unsafe;
                                        i51 = i18;
                                        i52 = i40;
                                        this = this;
                                        i81 = i81;
                                        i14 = i50;
                                        if (i16 == 3) {
                                            i79 = (i51 & (-8)) | 4;
                                            zznsVarZzv = this.zzv(i14);
                                            iZzg = zzkt.zzc(zznsVarZzv, bArr, i42, i2, i79, zzksVar);
                                            zzmjVar11.add(zzksVar3.zzc);
                                            while (iZzg < i81) {
                                                iZzh17 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                if (i51 == zzksVar3.zza) {
                                                    iZzg = zzkt.zzc(zznsVarZzv, bArr, iZzh17, i2, i79, zzksVar);
                                                    zzmjVar11.add(zzksVar3.zzc);
                                                }
                                            }
                                        } else {
                                            iZzg = i42;
                                        }
                                        if (iZzg != i42) {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj4 = obj;
                                            i83 = i14;
                                            zzksVar5 = zzksVar3;
                                            i86 = i52;
                                            this = this;
                                            i84 = i51;
                                            i87 = i11;
                                            i82 = 0;
                                            i85 = i10;
                                            unsafe3 = unsafe;
                                        } else {
                                            i42 = i42;
                                            i81 = i81;
                                            zzksVar3 = zzksVar3;
                                            obj2 = obj;
                                            i9 = iZzg;
                                            i12 = i52;
                                            zznkVar = this;
                                            i15 = i51;
                                            unsafe3 = unsafe;
                                            zzksVar2 = zzksVar3;
                                            i4 = i3;
                                        }
                                        break;
                                }
                            } else {
                                zznkVar = this;
                                i14 = i41;
                                i43 = i18;
                                i12 = i40;
                                zzksVar2 = zzksVar3;
                                if (iZzr == 50) {
                                    obj2 = obj;
                                    j2 = iArr[i14 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 1) {
                                                iZzg = i44 + 8;
                                                unsafe3.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzkt.zzn(bArr, i44))));
                                                unsafe3.putInt(obj2, j2, i12);
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 52:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 5) {
                                                iZzg = i44 + 4;
                                                unsafe3.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzkt.zzb(bArr, i44))));
                                                unsafe3.putInt(obj2, j2, i12);
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 0) {
                                                iZzk = zzkt.zzk(bArr, i44, zzksVar2);
                                                unsafe3.putObject(obj2, j, Long.valueOf(zzksVar2.zzb));
                                                unsafe3.putInt(obj2, j2, i12);
                                                iZzg = iZzk;
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 0) {
                                                iZzk = zzkt.zzh(bArr, i44, zzksVar2);
                                                unsafe3.putObject(obj2, j, Integer.valueOf(zzksVar2.zza));
                                                unsafe3.putInt(obj2, j2, i12);
                                                iZzg = iZzk;
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 1) {
                                                iZzg = i44 + 8;
                                                unsafe3.putObject(obj2, j, Long.valueOf(zzkt.zzn(bArr, i44)));
                                                unsafe3.putInt(obj2, j2, i12);
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 5) {
                                                iZzg = i44 + 4;
                                                unsafe3.putObject(obj2, j, Integer.valueOf(zzkt.zzb(bArr, i44)));
                                                unsafe3.putInt(obj2, j2, i12);
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 58:
                                            i14 = i14;
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 0) {
                                                iZzk = zzkt.zzk(bArr, i44, zzksVar2);
                                                if (zzksVar2.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                unsafe3.putObject(obj2, j, Boolean.valueOf(z2));
                                                unsafe3.putInt(obj2, j2, i12);
                                                iZzg = iZzk;
                                            } else {
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 59:
                                            i44 = i42;
                                            i45 = i43;
                                            zzksVar2 = zzksVar2;
                                            unsafe3 = unsafe;
                                            if (i16 == 2) {
                                                iZzg = zzkt.zzh(bArr, i44, zzksVar2);
                                                i46 = zzksVar2.zza;
                                                if (i46 == 0) {
                                                    unsafe3.putObject(obj2, j, "");
                                                } else {
                                                    i47 = iZzg + i46;
                                                    if ((i17 & PropertyOptions.DELETE_EXISTING) == 0) {
                                                    }
                                                    unsafe3.putObject(obj2, j, new String(bArr, iZzg, i46, zzmk.zza));
                                                    iZzg = i47;
                                                }
                                                unsafe3.putInt(obj2, j2, i12);
                                            } else {
                                                i14 = i14;
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 60:
                                            if (i16 == 2) {
                                                Object objZzy3 = zznkVar.zzy(obj2, i12, i14);
                                                i44 = i42;
                                                i45 = i43;
                                                zzksVar2 = zzksVar2;
                                                iZzg = zzkt.zzm(objZzy3, zznkVar.zzv(i14), bArr, i44, i2, zzksVar);
                                                zznkVar.zzG(obj2, i12, i14, objZzy3);
                                                i14 = i14;
                                                unsafe3 = unsafe;
                                            } else {
                                                i44 = i42;
                                                i45 = i43;
                                                i14 = i14;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                            }
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 61:
                                            i48 = i42;
                                            if (i16 == 2) {
                                                iZza = zzkt.zza(bArr, i48, zzksVar2);
                                                unsafe.putObject(obj2, j, zzksVar2.zzc);
                                                unsafe.putInt(obj2, j2, i12);
                                                i44 = i48;
                                                iZzg = iZza;
                                                i45 = i43;
                                                unsafe3 = unsafe;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                            } else {
                                                i44 = i48;
                                                i45 = i43;
                                                unsafe3 = unsafe;
                                                iZzg = i44;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                            }
                                            break;
                                        case 63:
                                            i48 = i42;
                                            i45 = i43;
                                            if (i16 == 0) {
                                                iZza = zzkt.zzh(bArr, i48, zzksVar2);
                                                i49 = zzksVar2.zza;
                                                zzmgVarZzu = zznkVar.zzu(i14);
                                                if (zzmgVarZzu != null) {
                                                    i43 = i45;
                                                    unsafe.putObject(obj2, j, Integer.valueOf(i49));
                                                    unsafe.putInt(obj2, j2, i12);
                                                } else {
                                                    i43 = i45;
                                                    unsafe.putObject(obj2, j, Integer.valueOf(i49));
                                                    unsafe.putInt(obj2, j2, i12);
                                                }
                                                i44 = i48;
                                                iZzg = iZza;
                                                i45 = i43;
                                                unsafe3 = unsafe;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                            }
                                            i14 = i14;
                                            i44 = i48;
                                            unsafe3 = unsafe;
                                            iZzg = i44;
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 66:
                                            i48 = i42;
                                            i45 = i43;
                                            if (i16 == 0) {
                                                iZzh = zzkt.zzh(bArr, i48, zzksVar2);
                                                unsafe.putObject(obj2, j, Integer.valueOf(zzlg.zzb(zzksVar2.zza)));
                                                unsafe.putInt(obj2, j2, i12);
                                                i44 = i48;
                                                iZzg = iZzh;
                                                unsafe3 = unsafe;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                            }
                                            i14 = i14;
                                            i44 = i48;
                                            unsafe3 = unsafe;
                                            iZzg = i44;
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 67:
                                            i48 = i42;
                                            i45 = i43;
                                            if (i16 == 0) {
                                                iZzh = zzkt.zzk(bArr, i48, zzksVar2);
                                                unsafe.putObject(obj2, j, Long.valueOf(zzlg.zzc(zzksVar2.zzb)));
                                                unsafe.putInt(obj2, j2, i12);
                                                i44 = i48;
                                                iZzg = iZzh;
                                                unsafe3 = unsafe;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                            }
                                            i14 = i14;
                                            i44 = i48;
                                            unsafe3 = unsafe;
                                            iZzg = i44;
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                        case 68:
                                            if (i16 == 3) {
                                                Object objZzy4 = zznkVar.zzy(obj2, i12, i14);
                                                i45 = i43;
                                                int iZzl4 = zzkt.zzl(objZzy4, zznkVar.zzv(i14), bArr, i42, i2, (i43 & (-8)) | 4, zzksVar);
                                                zznkVar.zzG(obj2, i12, i14, objZzy4);
                                                i14 = i14;
                                                i44 = i42;
                                                iZzg = iZzl4;
                                                obj2 = obj2;
                                                unsafe3 = unsafe;
                                                if (iZzg != i44) {
                                                    i12 = i12;
                                                    i81 = i2;
                                                    i86 = i12;
                                                    unsafe3 = unsafe3;
                                                    this = zznkVar;
                                                    obj4 = obj2;
                                                    zzksVar5 = zzksVar2;
                                                    i87 = i11;
                                                    i82 = 0;
                                                    i85 = i10;
                                                    i83 = i14;
                                                    i84 = i45;
                                                } else {
                                                    i12 = i12;
                                                    i4 = i3;
                                                    i9 = iZzg;
                                                    i14 = i14;
                                                    i15 = i45;
                                                }
                                                break;
                                            }
                                        default:
                                            i44 = i42;
                                            i45 = i43;
                                            unsafe3 = unsafe;
                                            iZzg = i44;
                                            if (iZzg != i44) {
                                                i12 = i12;
                                                i81 = i2;
                                                i86 = i12;
                                                unsafe3 = unsafe3;
                                                this = zznkVar;
                                                obj4 = obj2;
                                                zzksVar5 = zzksVar2;
                                                i87 = i11;
                                                i82 = 0;
                                                i85 = i10;
                                                i83 = i14;
                                                i84 = i45;
                                            } else {
                                                i12 = i12;
                                                i4 = i3;
                                                i9 = iZzg;
                                                i14 = i14;
                                                i15 = i45;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i16 == 2) {
                                        Object objZzw2 = zznkVar.zzw(i14);
                                        object = unsafe.getObject(obj, j);
                                        if (!((zznb) object).zze()) {
                                            zznb zznbVarZzb2 = zznb.zza().zzb();
                                            zznc.zza(zznbVarZzb2, object);
                                            unsafe.putObject(obj, j, zznbVarZzb2);
                                        }
                                        throw null;
                                    }
                                    obj2 = obj;
                                    unsafe2 = unsafe;
                                }
                            }
                            i3 = i3;
                        } else if (i16 == 2) {
                            zzmjVarZzd = (zzmj) unsafe.getObject(obj4, j);
                            if (!zzmjVarZzd.zzc()) {
                                size2 = zzmjVarZzd.size();
                                if (size2 == 0) {
                                    i80 = 10;
                                } else {
                                    i80 = size2 + size2;
                                }
                                zzmjVarZzd = zzmjVarZzd.zzd(i80);
                                unsafe.putObject(obj4, j, zzmjVarZzd);
                            }
                            int iZze4 = zzkt.zze(this.zzv(i41), i18, bArr, i42, i2, zzmjVarZzd, zzksVar);
                            i3 = i3;
                            zzksVar5 = zzksVar3;
                            unsafe3 = unsafe;
                            iZzg = iZze4;
                            i83 = i41;
                            i81 = i81;
                            i87 = i11;
                            i84 = i18;
                            i82 = 0;
                            i85 = i10;
                            i86 = i40;
                        } else {
                            obj2 = obj4;
                            i43 = i18;
                            zznkVar = this;
                            i14 = i41;
                            i12 = i40;
                            zzksVar2 = zzksVar3;
                            unsafe2 = unsafe;
                        }
                        i4 = i3;
                        i9 = i42;
                        i15 = i43;
                        zzksVar2 = zzksVar2;
                        unsafe3 = unsafe2;
                    }
                }
                if (i15 == i4) {
                }
                if (zznkVar.zzh) {
                    zzlpVar = zzksVar2.zzd;
                    int i1115 = zzlp.zzb;
                    int i1116 = zznp.zza;
                    if (zzlpVar != zzlp.zza) {
                        zznhVar = zznkVar.zzg;
                        int i1117 = zzkt.zza;
                        if (zzlpVar.zzb(zznhVar, i12) == null) {
                            throw null;
                        }
                        iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                    } else {
                        iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                    }
                } else {
                    iZzg = zzkt.zzg(i15, bArr, i9, i2, zzd(obj), zzksVar);
                }
                i83 = i14;
                this = zznkVar;
                obj4 = obj2;
                i84 = i15;
                zzksVar5 = zzksVar2;
                i86 = i12;
                i87 = i11;
                i82 = i13;
                i85 = i10;
                i81 = i2;
                i3 = i4;
            } else {
                obj2 = obj4;
                i4 = i3;
                i5 = 1048575;
                zznkVar = this;
            }
        }
        if (i87 != i5) {
            unsafe3.putInt(obj2, i87, i85);
        }
        for (int i120 = zznkVar.zzj; i120 < zznkVar.zzk; i120++) {
            int[] iArr2 = zznkVar.zzi;
            int[] iArr3 = zznkVar.zzc;
            int i121 = iArr2[i120];
            int i122 = iArr3[i121];
            Object objZzf = zzol.zzf(obj2, zznkVar.zzs(i121) & i5);
            if (objZzf != null && zznkVar.zzu(i121) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzg != i2) {
                throw new zzmm("Failed to parse the message.");
            }
        } else if (iZzg > i2 || i84 != i4) {
            throw new zzmm("Failed to parse the message.");
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final Object zze() {
        return ((zzmd) this.zzg).zzcj();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzmd) {
                zzmd zzmdVar = (zzmd) obj;
                zzmdVar.zzcu(Integer.MAX_VALUE);
                zzmdVar.zza = 0;
                zzmdVar.zzcs();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
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
                                ((zzmj) zzol.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zznb) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zznu.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznu.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzol.zzo(obj, j, zzol.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzol.zzp(obj, j, zzol.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzol.zzm(obj, j, zzol.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    zzmj zzmjVarZzd = (zzmj) zzol.zzf(obj, j);
                    zzmj zzmjVar = (zzmj) zzol.zzf(obj2, j);
                    int size = zzmjVarZzd.size();
                    int size2 = zzmjVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzmjVarZzd.zzc()) {
                            zzmjVarZzd = zzmjVarZzd.zzd(size2 + size);
                        }
                        zzmjVarZzd.addAll(zzmjVar);
                    }
                    if (size > 0) {
                        zzmjVar = zzmjVarZzd;
                    }
                    zzol.zzs(obj, j, zzmjVar);
                    break;
                case 50:
                    int i4 = zznu.zza;
                    zzol.zzs(obj, j, zznc.zza(zzol.zzf(obj, j), zzol.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzksVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzi(Object obj, zzor zzorVar) throws IOException {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        int[] iArr;
        if (this.zzh) {
            zzlu zzluVar = ((zzma) obj).zzb;
            if (zzluVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzluVar.zze().next();
            }
        } else {
            entry = null;
        }
        int[] iArr2 = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr2.length) {
            int iZzs = zzs(i7);
            int iZzr = zzr(iZzs);
            int i8 = iArr2[i7];
            if (iZzr <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j = iZzs & i4;
            switch (iZzr) {
                case 0:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzf(i8, zzol.zza(obj, j));
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 1:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzo(i8, zzol.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 2:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzt(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 3:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzK(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 4:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzr(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 5:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzm(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 6:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzk(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 7:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzb(i8, zzol.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 8:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzorVar);
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 9:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 10:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 11:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzI(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 12:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzi(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 13:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzx(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 14:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzz(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 15:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzB(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 16:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzD(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 17:
                    iArr = iArr2;
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    iArr2 = iArr;
                    i4 = 1048575;
                    break;
                case 18:
                    zznu.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 19:
                    zznu.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 20:
                    zznu.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 21:
                    zznu.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 22:
                    zznu.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 23:
                    zznu.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 24:
                    zznu.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 25:
                    zznu.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 26:
                    int i11 = iArr2[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zznu.zza;
                    if (list != null && !list.isEmpty()) {
                        zzorVar.zzH(i11, list);
                    }
                    break;
                case 27:
                    int i13 = iArr2[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv = zzv(i7);
                    int i14 = zznu.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzll) zzorVar).zzv(i13, list2.get(i15), zznsVarZzv);
                        }
                    }
                    break;
                case 28:
                    int i16 = iArr2[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zznu.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzorVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zznu.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 30:
                    zznu.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 31:
                    zznu.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 32:
                    zznu.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 33:
                    zznu.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 34:
                    zznu.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                    break;
                case 35:
                    zznu.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 36:
                    zznu.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 37:
                    zznu.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 38:
                    zznu.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 39:
                    zznu.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 40:
                    zznu.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 41:
                    zznu.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 42:
                    zznu.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 43:
                    zznu.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 44:
                    zznu.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 45:
                    zznu.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 46:
                    zznu.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 47:
                    zznu.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 48:
                    zznu.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                    break;
                case 49:
                    int i18 = iArr2[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv2 = zzv(i7);
                    int i19 = zznu.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzll) zzorVar).zzq(i18, list4.get(i20), zznsVarZzv2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzf(i8, zzm(obj, j));
                    }
                    break;
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzo(i8, zzn(obj, j));
                    }
                    break;
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzt(i8, zzt(obj, j));
                    }
                    break;
                case 54:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzK(i8, zzt(obj, j));
                    }
                    break;
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzr(i8, zzo(obj, j));
                    }
                    break;
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzm(i8, zzt(obj, j));
                    }
                    break;
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzk(i8, zzo(obj, j));
                    }
                    break;
                case 58:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzb(i8, zzN(obj, j));
                    }
                    break;
                case 59:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzorVar);
                    }
                    break;
                case 60:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                    }
                    break;
                case 61:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzI(i8, zzo(obj, j));
                    }
                    break;
                case 63:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzi(i8, zzo(obj, j));
                    }
                    break;
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzx(i8, zzo(obj, j));
                    }
                    break;
                case 65:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzz(i8, zzt(obj, j));
                    }
                    break;
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzB(i8, zzo(obj, j));
                    }
                    break;
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzD(i8, zzt(obj, j));
                    }
                    break;
                case 68:
                    if (zzM(obj, i8, i7)) {
                        zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                    }
                    break;
            }
            iArr = iArr2;
            i7 += 3;
            i5 = i;
            i6 = i2;
            iArr2 = iArr;
            i4 = 1048575;
        }
        if (entry != null) {
            throw null;
        }
        ((zzmd) obj).zzc.zzl(zzorVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzol.zza(obj, j)) != Double.doubleToLongBits(zzol.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzol.zzb(obj, j)) != Float.floatToIntBits(zzol.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzol.zzw(obj, j) != zzol.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
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
                    zZzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzol.zzc(obj, jZzp) != zzol.zzc(obj2, jZzp) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzmd) obj).zzc.equals(((zzmd) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzma) obj).zzb.equals(((zzma) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be A[LOOP:1: B:45:0x00ad->B:50:0x00be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00db A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzns zznsVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzs = zzs(i7);
            int i9 = iArr2[i7 + 2];
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
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzol.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zznsVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zznsVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzol.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zznsVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zznsVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zznb) zzol.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzma) obj).zzb.zzh();
    }
}
