package com.google.android.libraries.places.internal;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapc<T> implements zzapm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzaqq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaoz zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaon zzm;
    private final zzaqg zzn;
    private final zzane zzo;
    private final zzape zzp;
    private final zzaou zzq;

    private zzapc(int[] iArr, Object[] objArr, int i, int i2, zzaoz zzaozVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzape zzapeVar, zzaon zzaonVar, zzaqg zzaqgVar, zzane zzaneVar, zzaou zzaouVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzaozVar instanceof zzanr;
        boolean z2 = false;
        if (zzaneVar != null && zzaneVar.zzh(zzaozVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzapeVar;
        this.zzm = zzaonVar;
        this.zzn = zzaqgVar;
        this.zzo = zzaneVar;
        this.zzg = zzaozVar;
        this.zzq = zzaouVar;
    }

    private final void zzA(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzapm zzapmVarZzs = zzs(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZzc = zzapmVarZzs.zzc();
                    zzapmVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZzc2 = zzapmVarZzs.zzc();
                zzapmVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzapmVarZzs.zze(object2, object);
        }
    }

    private final void zzB(Object obj, int i, zzapl zzaplVar) throws IOException {
        long j = i & 1048575;
        if (zzH(i)) {
            zzaqq.zzs(obj, j, zzaplVar.zzs());
        } else if (this.zzi) {
            zzaqq.zzs(obj, j, zzaplVar.zzr());
        } else {
            zzaqq.zzs(obj, j, zzaplVar.zzp());
        }
    }

    private final void zzC(Object obj, int i) {
        int iZzn = zzn(i);
        long j = 1048575 & iZzn;
        if (j == 1048575) {
            return;
        }
        zzaqq.zzq(obj, j, (1 << (iZzn >>> 20)) | zzaqq.zzc(obj, j));
    }

    private final void zzD(Object obj, int i, int i2) {
        zzaqq.zzq(obj, zzn(i2) & 1048575, i);
    }

    private final void zzE(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzp(i) & 1048575, obj2);
        zzC(obj, i);
    }

    private final void zzF(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzp(i2) & 1048575, obj2);
        zzD(obj, i, i2);
    }

    private final boolean zzG(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private static boolean zzH(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    private final boolean zzI(Object obj, int i) {
        int iZzn = zzn(i);
        long j = iZzn & 1048575;
        if (j != 1048575) {
            return (zzaqq.zzc(obj, j) & (1 << (iZzn >>> 20))) != 0;
        }
        int iZzp = zzp(i);
        long j2 = iZzp & 1048575;
        switch (zzo(iZzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzaqq.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzaqq.zzb(obj, j2)) != 0;
            case 2:
                return zzaqq.zzd(obj, j2) != 0;
            case 3:
                return zzaqq.zzd(obj, j2) != 0;
            case 4:
                return zzaqq.zzc(obj, j2) != 0;
            case 5:
                return zzaqq.zzd(obj, j2) != 0;
            case 6:
                return zzaqq.zzc(obj, j2) != 0;
            case 7:
                return zzaqq.zzw(obj, j2);
            case 8:
                Object objZzf = zzaqq.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzaml) {
                    return !zzaml.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzaqq.zzf(obj, j2) != null;
            case 10:
                return !zzaml.zzb.equals(zzaqq.zzf(obj, j2));
            case 11:
                return zzaqq.zzc(obj, j2) != 0;
            case 12:
                return zzaqq.zzc(obj, j2) != 0;
            case 13:
                return zzaqq.zzc(obj, j2) != 0;
            case 14:
                return zzaqq.zzd(obj, j2) != 0;
            case 15:
                return zzaqq.zzc(obj, j2) != 0;
            case 16:
                return zzaqq.zzd(obj, j2) != 0;
            case 17:
                return zzaqq.zzf(obj, j2) != null;
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

    private static boolean zzK(Object obj, int i, zzapm zzapmVar) {
        return zzapmVar.zzh(zzaqq.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzanr) {
            return ((zzanr) obj).zzaD();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzaqq.zzc(obj, (long) (zzn(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzaqq.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzamz zzamzVar) throws IOException {
        if (obj instanceof String) {
            zzamzVar.zzF(i, (String) obj);
        } else {
            zzamzVar.zzd(i, (zzaml) obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    static zzapc zzi(Class cls, zzaow zzaowVar, zzape zzapeVar, zzaon zzaonVar, zzaqg zzaqgVar, zzane zzaneVar, zzaou zzaouVar) {
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
        int iObjectFieldOffset;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        Field fieldZzx;
        char cCharAt9;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZzx2;
        int i25;
        Object obj2;
        Field fieldZzx3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        if (!(zzaowVar instanceof zzapk)) {
            throw null;
        }
        zzapk zzapkVar = (zzapk) zzaowVar;
        String strZzd = zzapkVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i32 = iCharAt3 & 8191;
            int i33 = 13;
            while (true) {
                i29 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i29;
            }
            iCharAt3 = i32 | (cCharAt13 << i33);
            i31 = i29;
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
            int i34 = i31 + 1;
            int iCharAt4 = strZzd.charAt(i31);
            if (iCharAt4 >= 55296) {
                int i35 = iCharAt4 & 8191;
                int i36 = 13;
                while (true) {
                    i14 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i14;
                }
                iCharAt4 = i35 | (cCharAt8 << i36);
                i34 = i14;
            }
            int i37 = i34 + 1;
            int iCharAt5 = strZzd.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i13 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i13;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i13;
            }
            int i40 = i37 + 1;
            int iCharAt6 = strZzd.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i12 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i12;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i12;
            }
            int i43 = i40 + 1;
            int iCharAt7 = strZzd.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i11 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i11;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i11;
            }
            int i46 = i43 + 1;
            iCharAt = strZzd.charAt(i43);
            if (iCharAt >= 55296) {
                int i47 = iCharAt & 8191;
                int i48 = 13;
                while (true) {
                    i10 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i10;
                }
                iCharAt = i47 | (cCharAt4 << i48);
                i46 = i10;
            }
            int i49 = i46 + 1;
            iCharAt2 = strZzd.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i9 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i9;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i9;
            }
            int i52 = i49 + 1;
            int iCharAt8 = strZzd.charAt(i49);
            if (iCharAt8 >= 55296) {
                int i53 = iCharAt8 & 8191;
                int i54 = 13;
                while (true) {
                    i8 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i8;
                }
                iCharAt8 = i53 | (cCharAt2 << i54);
                i52 = i8;
            }
            int i55 = i52 + 1;
            int iCharAt9 = strZzd.charAt(i52);
            if (iCharAt9 >= 55296) {
                int i56 = iCharAt9 & 8191;
                int i57 = 13;
                while (true) {
                    i7 = i55 + 1;
                    cCharAt = strZzd.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i7;
                }
                iCharAt9 = i56 | (cCharAt << i57);
                i55 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i31 = i55;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzapkVar.zze();
        Class<?> cls2 = zzapkVar.zza().getClass();
        int i58 = i4 + iCharAt2;
        int i59 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i59];
        int i60 = 0;
        int i61 = 0;
        int i62 = i4;
        int i63 = i58;
        while (i31 < length) {
            int i64 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= c) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i28 = i66 + 1;
                    cCharAt12 = strZzd.charAt(i66);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i28;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i15 = i28;
            } else {
                i15 = i64;
            }
            int i68 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i27 = i70 + 1;
                    cCharAt11 = strZzd.charAt(i70);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i27;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i16 = i27;
            } else {
                i16 = i68;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i61] = i60;
                i61++;
            }
            int i72 = iCharAt11 & 255;
            int i73 = iCharAt11 & 2048;
            int i74 = length;
            if (i72 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i76 = 13;
                    int i77 = iCharAt12 & 8191;
                    int i78 = i75;
                    while (true) {
                        i26 = i78 + 1;
                        cCharAt10 = strZzd.charAt(i78);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i77 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i78 = i26;
                        c2 = 55296;
                    }
                    iCharAt12 = i77 | (cCharAt10 << i76);
                    i22 = i26;
                } else {
                    i22 = i75;
                }
                int i79 = i22;
                int i80 = i72 - 51;
                if (i80 == 9 || i80 == 17) {
                    i23 = i2 + 1;
                    int i81 = i60 / 3;
                    objArr[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i80 == 12) {
                        if (zzapkVar.zzc() == 1 || i73 != 0) {
                            i23 = i2 + 1;
                            int i82 = i60 / 3;
                            objArr[i82 + i82 + 1] = objArrZze[i2];
                        } else {
                            i73 = 0;
                        }
                    }
                    i24 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i24];
                    if (obj instanceof Field) {
                        fieldZzx2 = (Field) obj;
                    } else {
                        fieldZzx2 = zzx(cls2, (String) obj);
                        objArrZze[i24] = fieldZzx2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzx2);
                    i25 = i24 + 1;
                    obj2 = objArrZze[i25];
                    if (obj2 instanceof Field) {
                        fieldZzx3 = (Field) obj2;
                    } else {
                        fieldZzx3 = zzx(cls2, (String) obj2);
                        objArrZze[i25] = fieldZzx3;
                    }
                    zzapkVar = zzapkVar;
                    strZzd = strZzd;
                    i19 = i2;
                    i17 = i79;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx3);
                    i18 = 0;
                }
                i2 = i23;
                i24 = iCharAt12 + iCharAt12;
                obj = objArrZze[i24];
                if (obj instanceof Field) {
                    fieldZzx2 = (Field) obj;
                } else {
                    fieldZzx2 = zzx(cls2, (String) obj);
                    objArrZze[i24] = fieldZzx2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzx2);
                i25 = i24 + 1;
                obj2 = objArrZze[i25];
                if (obj2 instanceof Field) {
                    fieldZzx3 = (Field) obj2;
                } else {
                    fieldZzx3 = zzx(cls2, (String) obj2);
                    objArrZze[i25] = fieldZzx3;
                }
                zzapkVar = zzapkVar;
                strZzd = strZzd;
                i19 = i2;
                i17 = i79;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx3);
                i18 = 0;
            } else {
                int i83 = i2 + 1;
                Field fieldZzx4 = zzx(cls2, (String) objArrZze[i2]);
                if (i72 == 9 || i72 == 17) {
                    zzapkVar = zzapkVar;
                    int i84 = i60 / 3;
                    objArr[i84 + i84 + 1] = fieldZzx4.getType();
                } else {
                    if (i72 == 27) {
                        i20 = 1;
                        i21 = i2 + 2;
                    } else if (i72 == 49) {
                        i21 = i2 + 2;
                        i20 = 1;
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        zzapkVar = zzapkVar;
                        if (zzapkVar.zzc() == 1 || i73 != 0) {
                            i21 = i2 + 2;
                            int i85 = i60 / 3;
                            objArr[i85 + i85 + 1] = objArrZze[i83];
                            i83 = i21;
                        } else {
                            i73 = 0;
                        }
                    } else {
                        if (i72 == 50) {
                            int i86 = i2 + 2;
                            int i87 = i62 + 1;
                            iArr[i62] = i60;
                            int i88 = i60 / 3;
                            int i89 = i88 + i88;
                            objArr[i89] = objArrZze[i83];
                            if (i73 != 0) {
                                i83 = i2 + 3;
                                objArr[i89 + 1] = objArrZze[i86];
                                i62 = i87;
                            } else {
                                i83 = i86;
                                i62 = i87;
                                i73 = 0;
                            }
                        }
                        zzapkVar = zzapkVar;
                    }
                    int i90 = i60 / 3;
                    objArr[i90 + i90 + i20] = objArrZze[i83];
                    i83 = i21;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzx4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i72 > 17) {
                    i17 = i16;
                    i18 = 0;
                } else {
                    int i91 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i92 = iCharAt13 & 8191;
                        int i93 = 13;
                        while (true) {
                            i17 = i91 + 1;
                            cCharAt9 = strZzd.charAt(i91);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i92 |= (cCharAt9 & 8191) << i93;
                            i93 += 13;
                            i91 = i17;
                        }
                        iCharAt13 = i92 | (cCharAt9 << i93);
                    } else {
                        i17 = i91;
                    }
                    int i94 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i94];
                    if (obj3 instanceof Field) {
                        fieldZzx = (Field) obj3;
                    } else {
                        fieldZzx = zzx(cls2, (String) obj3);
                        objArrZze[i94] = fieldZzx;
                    }
                    i18 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx);
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i63] = iObjectFieldOffset3;
                    i63++;
                }
                i19 = i83;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i95 = i60 + 1;
            iArr2[i60] = iCharAt10;
            int i96 = i60 + 2;
            iArr2[i95] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? PropertyOptions.DELETE_EXISTING : 0) | (i73 != 0 ? Integer.MIN_VALUE : 0) | (i72 << 20);
            i60 += 3;
            iArr2[i96] = (i18 << 20) | iObjectFieldOffset;
            i2 = i19;
            i31 = i17;
            length = i74;
            zzapkVar = zzapkVar;
            strZzd = strZzd;
            i6 = i6;
            i3 = i3;
            c = 55296;
        }
        zzapk zzapkVar2 = zzapkVar;
        return new zzapc(iArr2, objArr, i3, i6, zzapkVar2.zza(), zzapkVar2.zzc(), false, iArr, i4, i58, zzapeVar, zzaonVar, zzaqgVar, zzaneVar, zzaouVar);
    }

    private static double zzk(Object obj, long j) {
        return ((Double) zzaqq.zzf(obj, j)).doubleValue();
    }

    private static float zzl(Object obj, long j) {
        return ((Float) zzaqq.zzf(obj, j)).floatValue();
    }

    private static int zzm(Object obj, long j) {
        return ((Integer) zzaqq.zzf(obj, j)).intValue();
    }

    private final int zzn(int i) {
        return this.zzc[i + 2];
    }

    private static int zzo(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzp(int i) {
        return this.zzc[i + 1];
    }

    private static long zzq(Object obj, long j) {
        return ((Long) zzaqq.zzf(obj, j)).longValue();
    }

    private final zzanv zzr(int i) {
        int i2 = i / 3;
        return (zzanv) this.zzd[i2 + i2 + 1];
    }

    private final zzapm zzs(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzapm zzapmVar = (zzapm) objArr[i3];
        if (zzapmVar != null) {
            return zzapmVar;
        }
        zzapm zzapmVarZzb = zzapi.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzapmVarZzb;
        return zzapmVarZzb;
    }

    private final Object zzt(Object obj, int i, Object obj2, zzaqg zzaqgVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzaqq.zzf(obj, zzp(i) & 1048575);
        if (objZzf == null || zzr(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzu(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzv(Object obj, int i) {
        zzapm zzapmVarZzs = zzs(i);
        int iZzp = zzp(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzapmVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, iZzp);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzapmVarZzs.zzc();
        if (object != null) {
            zzapmVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private final Object zzw(Object obj, int i, int i2) {
        zzapm zzapmVarZzs = zzs(i2);
        if (!zzM(obj, i, i2)) {
            return zzapmVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, zzp(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzapmVarZzs.zzc();
        if (object != null) {
            zzapmVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private static Field zzx(Class cls, String str) {
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

    private static void zzy(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzz(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzapm zzapmVarZzs = zzs(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZzc = zzapmVarZzs.zzc();
                    zzapmVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzC(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZzc2 = zzapmVarZzs.zzc();
                zzapmVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzapmVarZzs.zze(object2, object);
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038f  */
    /* JADX WARN: Code duplicated, block: B:207:0x0551  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.libraries.places.internal.zzaoh] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v248, types: [int] */
    /* JADX WARN: Type inference failed for: r0v256 */
    /* JADX WARN: Type inference failed for: r0v258 */
    /* JADX WARN: Type inference failed for: r0v259 */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
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
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v113, types: [int] */
    /* JADX WARN: Type inference failed for: r1v149 */
    /* JADX WARN: Type inference failed for: r1v152 */
    /* JADX WARN: Type inference failed for: r1v153 */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v156 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v70, types: [int] */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
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
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.libraries.places.internal.zzapm
    public final int zza(Object obj) {
        int i;
        ?? r15;
        ?? r5;
        int iZzA;
        int iZzA2;
        int iZzB;
        int iZzA3;
        int iZzA4;
        int iZzA5;
        int iZzA6;
        ?? Zzg;
        int size;
        int iZzA7;
        int iZzz;
        int iZzz2;
        ?? r3;
        int iZzy;
        ?? ZzA;
        ?? Zzh;
        int iZze;
        int iZzA8;
        int iZzA9;
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
        while (i3 < this.zzc.length) {
            int iZzp = zzp(i3);
            int iZzo = zzo(iZzp);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzo <= 17) {
                if (i8 != i5) {
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = i5;
                r15 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r15 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i9 = iZzp & i2;
            if (iZzo >= zzanj.DOUBLE_LIST_PACKED.zza()) {
                zzanj.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzo) {
                case 0:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzamy.zzB(unsafe.getLong(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzamy.zzB(unsafe.getLong(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzamy.zzx(unsafe.getInt(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA4 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzaml) {
                            int i11 = zzamy.zzf;
                            int iZzd = ((zzaml) object).zzd();
                            iZzA5 = zzamy.zzA(iZzd) + iZzd;
                            iZzA6 = zzamy.zzA(i10);
                            Zzh = iZzA6 + iZzA5;
                            i4 += Zzh;
                        } else {
                            iZzB = zzamy.zzz((String) object);
                            iZzA3 = zzamy.zzA(i10);
                            Zzh = iZzA3 + iZzB;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzapo.zzh(i6, unsafe.getObject(obj, j), zzs(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        zzaml zzamlVar = (zzaml) unsafe.getObject(obj, j);
                        int i12 = zzamy.zzf;
                        int iZzd2 = zzamlVar.zzd();
                        iZzA5 = zzamy.zzA(iZzd2) + iZzd2;
                        iZzA6 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA6 + iZzA5;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzamy.zzA(unsafe.getInt(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzamy.zzx(unsafe.getInt(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzA3 = zzamy.zzA(i6 << 3);
                        iZzB = zzamy.zzA((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzamy.zzA(i6 << 3);
                        iZzB = zzamy.zzB((j2 >> 63) ^ (j2 + j2));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzamy.zzw(i6, (zzaoz) unsafe.getObject(obj, j), zzs(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzapo.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzapo.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzapo.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzapo.zzg(list) + (list.size() * zzamy.zzA(i6 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzapo.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zzl(list2);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzapo.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zzf(list3);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzapo.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzapo.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzapo.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzamy.zzA(i6 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zzapo.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        boolean z2 = r0 instanceof zzaoh;
                        int iZzA10 = zzamy.zzA(i6 << 3) * size3;
                        if (z2) {
                            ?? r7 = (zzaoh) r0;
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object objZzf = r7.zzf(r8);
                                if (objZzf instanceof zzaml) {
                                    Zzg = iZzA10;
                                    int iZzd3 = ((zzaml) objZzf).zzd();
                                    iZzz2 = Zzg + zzamy.zzA(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz2 = Zzg + zzamy.zzz((String) objZzf);
                                }
                                Zzg = iZzz2;
                            }
                            Zzg = iZzA10;
                        } else {
                            for (?? r9 = z; r9 < size3; r9++) {
                                Object obj2 = r0.get(r9);
                                if (obj2 instanceof zzaml) {
                                    Zzg = iZzA10;
                                    int iZzd4 = ((zzaml) obj2).zzd();
                                    iZzz = Zzg + zzamy.zzA(iZzd4) + iZzd4;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz = Zzg + zzamy.zzz((String) obj2);
                                }
                                Zzg = iZzz;
                            }
                            Zzg = iZzA10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r10 = (List) unsafe.getObject(obj, j);
                    zzapm zzapmVarZzs = zzs(i3);
                    int i19 = zzapo.zza;
                    int size4 = r10.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzA11 = zzamy.zzA(i6 << 3) * size4;
                        for (?? r11 = z; r11 < size4; r11++) {
                            Object obj3 = r10.get(r11);
                            if (obj3 instanceof zzaof) {
                                r3 = iZzA11;
                                int iZza = ((zzaof) obj3).zza();
                                iZzy = (r3 == true ? 1 : 0) + zzamy.zzA(iZza) + iZza;
                            } else {
                                r3 = iZzA11;
                                iZzy = (r3 == true ? 1 : 0) + zzamy.zzy((zzaoz) obj3, zzapmVarZzs);
                            }
                            r3 = iZzy;
                        }
                        r3 = iZzA11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r12 = (List) unsafe.getObject(obj, j);
                    int i20 = zzapo.zza;
                    int size5 = r12.size();
                    if (size5 == 0) {
                        ZzA = z;
                    } else {
                        ZzA = size5 * zzamy.zzA(i6 << 3);
                        for (?? r13 = z; r13 < r12.size(); r13++) {
                            int iZzd5 = ((zzaml) r12.get(r13)).zzd();
                            ZzA += zzamy.zzA(iZzd5) + iZzd5;
                        }
                    }
                    i4 += ZzA;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzapo.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zzk(list5);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzapo.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zza(list6);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzapo.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzapo.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzapo.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zzi(list7);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzapo.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzapo.zzj(list8);
                        iZzA7 = zzamy.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzapo.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzapo.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzapo.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzapo.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzapo.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzapo.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzapo.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzapo.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzapo.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzapo.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzapo.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzapo.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzapo.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzapo.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzamy.zzA(iZze);
                        iZzA9 = zzamy.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r14 = (List) unsafe.getObject(obj, j);
                    zzapm zzapmVarZzs2 = zzs(i3);
                    int i26 = zzapo.zza;
                    int size6 = r14.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z3 = z;
                        r4 = z3;
                        while (r6 < size6) {
                            r6 = z3;
                            int iZzw = zzamy.zzw(i6, (zzaoz) r14.get(r6), zzapmVarZzs2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z3;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zzaot zzaotVar = (zzaot) unsafe.getObject(obj, j);
                    if (zzaotVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it2 = zzaotVar.entrySet().iterator();
                        if (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        iZzB = zzamy.zzB(zzq(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        iZzB = zzamy.zzB(zzq(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        iZzB = zzamy.zzx(zzm(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        iZzA4 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        int i27 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzaml) {
                            int i28 = zzamy.zzf;
                            int iZzd6 = ((zzaml) object2).zzd();
                            iZzA5 = zzamy.zzA(iZzd6) + iZzd6;
                            iZzA6 = zzamy.zzA(i27);
                            Zzh = iZzA6 + iZzA5;
                            i4 += Zzh;
                        } else {
                            iZzB = zzamy.zzz((String) object2);
                            iZzA3 = zzamy.zzA(i27);
                            Zzh = iZzA3 + iZzB;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzapo.zzh(i6, unsafe.getObject(obj, j), zzs(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        zzaml zzamlVar2 = (zzaml) unsafe.getObject(obj, j);
                        int i29 = zzamy.zzf;
                        int iZzd7 = zzamlVar2.zzd();
                        iZzA5 = zzamy.zzA(iZzd7) + iZzd7;
                        iZzA6 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA6 + iZzA5;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        iZzB = zzamy.zzA(zzm(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        iZzB = zzamy.zzx(zzm(obj, j));
                        iZzA3 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzamy.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzamy.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        int iZzm = zzm(obj, j);
                        iZzA3 = zzamy.zzA(i6 << 3);
                        iZzB = zzamy.zzA((iZzm >> 31) ^ (iZzm + iZzm));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        long jZzq = zzq(obj, j);
                        iZzA3 = zzamy.zzA(i6 << 3);
                        iZzB = zzamy.zzB((jZzq >> 63) ^ (jZzq + jZzq));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzamy.zzw(i6, (zzaoz) unsafe.getObject(obj, j), zzs(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
        zzaqg zzaqgVar = this.zzn;
        int iZza2 = i4 + zzaqgVar.zza(zzaqgVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzp = zzp(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzp;
            int iZzo = zzo(iZzp);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzo) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzaqq.zza(obj, j));
                    byte[] bArr = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzaqq.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaqq.zzd(obj, j);
                    byte[] bArr2 = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaqq.zzd(obj, j);
                    byte[] bArr3 = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaqq.zzd(obj, j);
                    byte[] bArr4 = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzaoa.zza(zzaqq.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzaqq.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzaqq.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaqq.zzd(obj, j);
                    byte[] bArr5 = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaqq.zzd(obj, j);
                    byte[] bArr6 = zzaoa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzaqq.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzk(obj, j));
                        byte[] bArr7 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzl(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr8 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr9 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr10 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaoa.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzaqq.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr11 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr12 = zzaoa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaqq.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final Object zzc() {
        return ((zzanr) this.zzg).zzao();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzd(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzanr) {
                zzanr zzanrVar = (zzanr) obj;
                zzanrVar.zzaB(Integer.MAX_VALUE);
                zzanrVar.zza = 0;
                zzanrVar.zzaz();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzp = zzp(i);
                int i2 = 1048575 & iZzp;
                int iZzo = zzo(iZzp);
                long j = i2;
                if (iZzo != 9) {
                    if (iZzo != 60 && iZzo != 68) {
                        switch (iZzo) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzs(i).zzd(zzb.getObject(obj, j));
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
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzaot) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzs(i).zzd(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzs(i).zzd(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zze(Object obj, Object obj2) {
        zzy(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzp = zzp(i);
            int i2 = 1048575 & iZzp;
            int[] iArr = this.zzc;
            int iZzo = zzo(iZzp);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzo) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzaqq.zzo(obj, j, zzaqq.zza(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzaqq.zzp(obj, j, zzaqq.zzb(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzaqq.zzr(obj, j, zzaqq.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzaqq.zzr(obj, j, zzaqq.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzaqq.zzr(obj, j, zzaqq.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzaqq.zzm(obj, j, zzaqq.zzw(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzaqq.zzs(obj, j, zzaqq.zzf(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 9:
                    zzz(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzaqq.zzs(obj, j, zzaqq.zzf(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzaqq.zzr(obj, j, zzaqq.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzaqq.zzq(obj, j, zzaqq.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzaqq.zzr(obj, j, zzaqq.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 17:
                    zzz(obj, obj2, i);
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
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzapo.zza;
                    zzaqq.zzs(obj, j, zzaou.zza(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j)));
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
                        zzaqq.zzs(obj, j, zzaqq.zzf(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case 60:
                    zzA(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzaqq.zzs(obj, j, zzaqq.zzf(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case 68:
                    zzA(obj, obj2, i);
                    break;
            }
        }
        zzapo.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:175:0x060e A[Catch: all -> 0x055b, TryCatch #5 {all -> 0x055b, blocks: (B:59:0x00ea, B:166:0x05e7, B:173:0x0609, B:175:0x060e, B:176:0x0613, B:101:0x02c7, B:102:0x02cd, B:103:0x02dd, B:104:0x02ed, B:105:0x02fd, B:106:0x030d, B:107:0x031d, B:108:0x032d, B:109:0x033d, B:110:0x034d, B:111:0x035d, B:112:0x036d, B:113:0x037d, B:114:0x038c, B:115:0x039b, B:117:0x03b9, B:118:0x03c8, B:120:0x03d9, B:124:0x03f2, B:126:0x03f8, B:127:0x0408, B:128:0x0418, B:129:0x0428, B:130:0x0438, B:131:0x0448, B:132:0x0458, B:133:0x0468, B:134:0x0478, B:135:0x0488, B:136:0x0498, B:137:0x04ad, B:138:0x04be, B:139:0x04cf, B:140:0x04e0, B:141:0x04f1, B:143:0x04fe, B:146:0x0505, B:147:0x050f, B:148:0x0519, B:149:0x052a, B:150:0x053b, B:151:0x0550, B:154:0x055e, B:155:0x056f, B:156:0x0580, B:157:0x0590, B:158:0x05a0, B:159:0x05b0, B:160:0x05c0, B:161:0x05d0), top: B:200:0x00ea }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0620 A[LOOP:3: B:179:0x061c->B:181:0x0620, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:183:0x0634  */
    /* JADX WARN: Code duplicated, block: B:193:0x0647 A[LOOP:4: B:191:0x0643->B:193:0x0647, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x065b  */
    /* JADX WARN: Code duplicated, block: B:220:0x0619 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzf(Object obj, zzapl zzaplVar, zzand zzandVar) throws Throwable {
        Object obj2;
        int i;
        int i2;
        zzaqg zzaqgVar;
        Object obj3;
        zzand zzandVar2;
        int i3;
        zzand zzandVar3;
        zzand zzandVar4;
        Object obj4 = obj;
        zzand zzandVar5 = zzandVar;
        zzandVar.getClass();
        zzy(obj);
        zzaqg zzaqgVar2 = this.zzn;
        zzane zzaneVar = this.zzo;
        Object objZzt = null;
        zzani zzaniVarZzb = null;
        while (true) {
            try {
                int iZzc = zzaplVar.zzc();
                if (iZzc < this.zze || iZzc > this.zzf) {
                    i2 = -1;
                } else {
                    int length = (this.zzc.length / 3) - 1;
                    int i4 = 0;
                    while (true) {
                        if (i4 > length) {
                            i2 = -1;
                        } else {
                            int i5 = (length + i4) >>> 1;
                            int i6 = i5 * 3;
                            int i7 = this.zzc[i6];
                            if (iZzc == i7) {
                                i2 = i6;
                            } else if (iZzc < i7) {
                                length = i5 - 1;
                            } else {
                                i4 = i5 + 1;
                            }
                        }
                    }
                }
                if (i2 >= 0) {
                    zzaqgVar2 = zzaqgVar2;
                    obj2 = obj4;
                    try {
                        int iZzp = zzp(i2);
                        try {
                            switch (zzo(iZzp)) {
                                case 0:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzo(obj2, iZzp & 1048575, zzaplVar.zza());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 1:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzp(obj2, iZzp & 1048575, zzaplVar.zzb());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 2:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzr(obj2, iZzp & 1048575, zzaplVar.zzl());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 3:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzr(obj2, iZzp & 1048575, zzaplVar.zzo());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 4:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzq(obj2, iZzp & 1048575, zzaplVar.zzg());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 5:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzr(obj2, iZzp & 1048575, zzaplVar.zzk());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 6:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzq(obj2, iZzp & 1048575, zzaplVar.zzf());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 7:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzm(obj2, iZzp & 1048575, zzaplVar.zzN());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 8:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzB(obj2, iZzp, zzaplVar);
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 9:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaoz zzaozVar = (zzaoz) zzv(obj2, i2);
                                    zzaplVar.zzu(zzaozVar, zzs(i2), zzandVar2);
                                    zzE(obj2, i2, zzaozVar);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 10:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzs(obj2, iZzp & 1048575, zzaplVar.zzp());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 11:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzq(obj2, iZzp & 1048575, zzaplVar.zzj());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 12:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    int iZze = zzaplVar.zze();
                                    zzanv zzanvVarZzr = zzr(i2);
                                    if (zzanvVarZzr == null || zzanvVarZzr.zza(iZze)) {
                                        zzaqq.zzq(obj2, iZzp & 1048575, iZze);
                                        zzC(obj2, i2);
                                        zzandVar5 = zzandVar2;
                                        objZzt = objZzt;
                                        zzaneVar = zzaneVar;
                                    } else {
                                        zzandVar5 = zzandVar2;
                                        zzaqgVar2 = zzaqgVar2;
                                        zzaneVar = zzaneVar;
                                        objZzt = zzapo.zzp(obj2, iZzc, iZze, objZzt, zzaqgVar2);
                                    }
                                    obj4 = obj2;
                                    break;
                                case 13:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzq(obj2, iZzp & 1048575, zzaplVar.zzh());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 14:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzr(obj2, iZzp & 1048575, zzaplVar.zzm());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 15:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzq(obj2, iZzp & 1048575, zzaplVar.zzi());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 16:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaqq.zzr(obj2, iZzp & 1048575, zzaplVar.zzn());
                                    zzC(obj2, i2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 17:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaoz zzaozVar2 = (zzaoz) zzv(obj2, i2);
                                    zzaplVar.zzt(zzaozVar2, zzs(i2), zzandVar2);
                                    zzE(obj2, i2, zzaozVar2);
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 18:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzx(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 19:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzB(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 20:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzE(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 21:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzM(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 22:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzD(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 23:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzA(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 24:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzz(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 25:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzaplVar.zzv(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 26:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    if (zzH(iZzp)) {
                                        ((zzams) zzaplVar).zzK(this.zzm.zza(obj2, iZzp & 1048575), true);
                                    } else {
                                        ((zzams) zzaplVar).zzK(this.zzm.zza(obj2, iZzp & 1048575), false);
                                    }
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 27:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzF(this.zzm.zza(obj2, iZzp & 1048575), zzs(i2), zzandVar3);
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 28:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzw(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 29:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzL(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 30:
                                    zzaneVar = zzaneVar;
                                    zzandVar4 = zzandVar5;
                                    List listZza = this.zzm.zza(obj2, iZzp & 1048575);
                                    zzaplVar.zzy(listZza);
                                    objZzt = zzapo.zzo(obj, iZzc, listZza, zzr(i2), objZzt, zzaqgVar2);
                                    zzandVar5 = zzandVar4;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 31:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzG(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 32:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzH(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 33:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzI(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 34:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzJ(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 35:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzx(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 36:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzB(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 37:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzE(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 38:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzM(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 39:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzD(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 40:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzA(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 41:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzz(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 42:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzv(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 43:
                                    zzandVar3 = zzandVar5;
                                    zzaplVar.zzL(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzandVar2 = zzandVar3;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 44:
                                    List listZza2 = this.zzm.zza(obj2, iZzp & 1048575);
                                    zzaplVar.zzy(listZza2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar4 = zzandVar5;
                                    try {
                                        objZzt = zzapo.zzo(obj, iZzc, listZza2, zzr(i2), objZzt, zzaqgVar2);
                                        zzandVar5 = zzandVar4;
                                    } catch (zzaob unused) {
                                        zzandVar2 = zzandVar4;
                                        zzaqgVar2.zzq(zzaplVar);
                                        if (objZzt == null) {
                                            objZzt = zzaqgVar2.zzc(obj2);
                                        }
                                        if (!zzaqgVar2.zzp(objZzt, zzaplVar)) {
                                            objZzt = objZzt;
                                            for (i3 = this.zzk; i3 < this.zzl; i3++) {
                                                objZzt = zzt(obj, this.zzj[i3], objZzt, zzaqgVar2, obj);
                                            }
                                            if (objZzt != null) {
                                                zzaqgVar2.zzn(obj2, objZzt);
                                            }
                                        }
                                        zzandVar5 = zzandVar2;
                                        objZzt = objZzt;
                                    }
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 45:
                                    zzaplVar.zzG(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 46:
                                    zzaplVar.zzH(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 47:
                                    zzaplVar.zzI(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 48:
                                    zzaplVar.zzJ(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 49:
                                    zzaplVar.zzC(this.zzm.zza(obj2, iZzp & 1048575), zzs(i2), zzandVar5);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 50:
                                    Object objZzu = zzu(i2);
                                    long jZzp = zzp(i2) & 1048575;
                                    Object objZzf = zzaqq.zzf(obj2, jZzp);
                                    if (objZzf == null) {
                                        objZzf = zzaot.zza().zzb();
                                        zzaqq.zzs(obj2, jZzp, objZzf);
                                    } else if (!((zzaot) objZzf).zze()) {
                                        Object objZzb = zzaot.zza().zzb();
                                        zzaou.zza(objZzb, objZzf);
                                        zzaqq.zzs(obj2, jZzp, objZzb);
                                        objZzf = objZzb;
                                    }
                                    throw null;
                                case 51:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Double.valueOf(zzaplVar.zza()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 52:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Float.valueOf(zzaplVar.zzb()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 53:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Long.valueOf(zzaplVar.zzl()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 54:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Long.valueOf(zzaplVar.zzo()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 55:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzaplVar.zzg()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 56:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Long.valueOf(zzaplVar.zzk()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 57:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzaplVar.zzf()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 58:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Boolean.valueOf(zzaplVar.zzN()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 59:
                                    zzB(obj2, iZzp, zzaplVar);
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 60:
                                    zzaoz zzaozVar3 = (zzaoz) zzw(obj2, iZzc, i2);
                                    zzaplVar.zzu(zzaozVar3, zzs(i2), zzandVar5);
                                    zzF(obj2, iZzc, i2, zzaozVar3);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 61:
                                    zzaqq.zzs(obj2, iZzp & 1048575, zzaplVar.zzp());
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 62:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzaplVar.zzj()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 63:
                                    int iZze2 = zzaplVar.zze();
                                    zzanv zzanvVarZzr2 = zzr(i2);
                                    if (zzanvVarZzr2 == null || zzanvVarZzr2.zza(iZze2)) {
                                        zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(iZze2));
                                        zzD(obj2, iZzc, i2);
                                        objZzt = objZzt;
                                        zzaneVar = zzaneVar;
                                        zzandVar2 = zzandVar5;
                                        zzandVar5 = zzandVar2;
                                        objZzt = objZzt;
                                        zzaneVar = zzaneVar;
                                        obj4 = obj2;
                                    } else {
                                        objZzt = zzapo.zzp(obj2, iZzc, iZze2, objZzt, zzaqgVar2);
                                        obj4 = obj2;
                                        zzaqgVar2 = zzaqgVar2;
                                    }
                                    break;
                                case 64:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzaplVar.zzh()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 65:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Long.valueOf(zzaplVar.zzm()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 66:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzaplVar.zzi()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 67:
                                    zzaqq.zzs(obj2, iZzp & 1048575, Long.valueOf(zzaplVar.zzn()));
                                    zzD(obj2, iZzc, i2);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                case 68:
                                    zzaoz zzaozVar4 = (zzaoz) zzw(obj2, iZzc, i2);
                                    zzaplVar.zzt(zzaozVar4, zzs(i2), zzandVar5);
                                    zzF(obj2, iZzc, i2, zzaozVar4);
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                                default:
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    zzandVar2 = zzandVar5;
                                    if (objZzt == null) {
                                        try {
                                            try {
                                                objZzt = zzaqgVar2.zzc(obj2);
                                            } catch (zzaob unused2) {
                                                zzaqgVar2.zzq(zzaplVar);
                                                if (objZzt == null) {
                                                    objZzt = zzaqgVar2.zzc(obj2);
                                                }
                                                if (!zzaqgVar2.zzp(objZzt, zzaplVar)) {
                                                    objZzt = objZzt;
                                                    while (i3 < this.zzl) {
                                                        objZzt = zzt(obj, this.zzj[i3], objZzt, zzaqgVar2, obj);
                                                    }
                                                    if (objZzt != null) {
                                                        zzaqgVar2.zzn(obj2, objZzt);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            break;
                                        }
                                    }
                                    if (!zzaqgVar2.zzp(objZzt, zzaplVar)) {
                                        objZzt = objZzt;
                                        for (int i8 = this.zzk; i8 < this.zzl; i8++) {
                                            objZzt = zzt(obj, this.zzj[i8], objZzt, zzaqgVar2, obj);
                                        }
                                    }
                                    zzandVar5 = zzandVar2;
                                    objZzt = objZzt;
                                    zzaneVar = zzaneVar;
                                    obj4 = obj2;
                                    break;
                            }
                        } catch (zzaob unused3) {
                            objZzt = objZzt;
                            zzaneVar = zzaneVar;
                            zzandVar2 = zzandVar5;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objZzt = objZzt;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i9 = this.zzk; i9 < this.zzl; i9++) {
                        objZzt = zzt(obj, this.zzj[i9], objZzt, zzaqgVar2, obj);
                    }
                    zzaqgVar2 = zzaqgVar2;
                    obj2 = obj4;
                } else {
                    try {
                        Object objZzc = !this.zzh ? null : zzaneVar.zzc(zzandVar5, this.zzg, iZzc);
                        if (objZzc != null) {
                            if (zzaniVarZzb == null) {
                                zzaniVarZzb = zzaneVar.zzb(obj4);
                            }
                            zzani zzaniVar = zzaniVarZzb;
                            zzaqgVar = zzaqgVar2;
                            obj3 = obj4;
                            try {
                                objZzt = zzaneVar.zzd(obj, zzaplVar, objZzc, zzandVar, zzaniVar, objZzt, zzaqgVar);
                                zzaniVarZzb = zzaniVar;
                            } catch (Throwable th3) {
                                th = th3;
                                obj2 = obj3;
                                zzaqgVar2 = zzaqgVar;
                                objZzt = objZzt;
                                objZzt = objZzt;
                                for (i = this.zzk; i < this.zzl; i++) {
                                    objZzt = zzt(obj, this.zzj[i], objZzt, zzaqgVar2, obj);
                                }
                                if (objZzt != null) {
                                    zzaqgVar2.zzn(obj2, objZzt);
                                }
                                throw th;
                            }
                        } else {
                            zzaqgVar = zzaqgVar2;
                            obj3 = obj4;
                            zzaqgVar.zzq(zzaplVar);
                            if (objZzt == null) {
                                objZzt = zzaqgVar.zzc(obj3);
                            }
                            try {
                                if (!zzaqgVar.zzp(objZzt, zzaplVar)) {
                                    int i10 = this.zzk;
                                    while (i10 < this.zzl) {
                                        zzaqg zzaqgVar3 = zzaqgVar;
                                        objZzt = zzt(obj, this.zzj[i10], objZzt, zzaqgVar3, obj);
                                        i10++;
                                        obj3 = obj3;
                                        zzaqgVar = zzaqgVar3;
                                    }
                                    obj2 = obj3;
                                    zzaqgVar2 = zzaqgVar;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj2 = obj3;
                                zzaqgVar2 = zzaqgVar;
                            }
                        }
                        obj4 = obj3;
                        zzaqgVar2 = zzaqgVar;
                    } catch (Throwable th5) {
                        th = th5;
                        zzaqgVar2 = zzaqgVar2;
                        obj2 = obj4;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                objZzt = objZzt;
                zzaqgVar2 = zzaqgVar2;
                obj2 = obj4;
            }
            objZzt = objZzt;
            while (i < this.zzl) {
                objZzt = zzt(obj, this.zzj[i], objZzt, zzaqgVar2, obj);
            }
            if (objZzt != null) {
                zzaqgVar2.zzn(obj2, objZzt);
            }
            throw th;
        }
        if (objZzt != null) {
            zzaqgVar2.zzn(obj2, objZzt);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final boolean zzg(Object obj, Object obj2) {
        boolean zZzs;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzp = zzp(i);
            long j = iZzp & 1048575;
            switch (zzo(iZzp)) {
                case 0:
                    if (!zzG(obj, obj2, i) || Double.doubleToLongBits(zzaqq.zza(obj, j)) != Double.doubleToLongBits(zzaqq.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzG(obj, obj2, i) || Float.floatToIntBits(zzaqq.zzb(obj, j)) != Float.floatToIntBits(zzaqq.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzG(obj, obj2, i) || zzaqq.zzd(obj, j) != zzaqq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzG(obj, obj2, i) || zzaqq.zzd(obj, j) != zzaqq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzG(obj, obj2, i) || zzaqq.zzd(obj, j) != zzaqq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzG(obj, obj2, i) || zzaqq.zzw(obj, j) != zzaqq.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzG(obj, obj2, i) || !zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzG(obj, obj2, i) || !zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzG(obj, obj2, i) || !zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzG(obj, obj2, i) || zzaqq.zzd(obj, j) != zzaqq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzG(obj, obj2, i) || zzaqq.zzc(obj, j) != zzaqq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzG(obj, obj2, i) || zzaqq.zzd(obj, j) != zzaqq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzG(obj, obj2, i) || !zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j))) {
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
                    zZzs = zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j));
                    break;
                case 50:
                    zZzs = zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j));
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
                    long jZzn = zzn(i) & 1048575;
                    if (zzaqq.zzc(obj, jZzn) != zzaqq.zzc(obj2, jZzn) || !zzapo.zzs(zzaqq.zzf(obj, j), zzaqq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzs) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[LOOP:1: B:45:0x00b2->B:50:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1 A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzapm
    public final boolean zzh(Object obj) {
        int i;
        int i2;
        List list;
        zzapm zzapmVarZzs;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzp = zzp(i7);
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
            if ((268435456 & iZzp) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzo = zzo(iZzp);
            if (iZzo == 9 || iZzo == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzp, zzs(i7))) {
                    return false;
                }
            } else if (iZzo == 27) {
                list = (List) zzaqq.zzf(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzapmVarZzs = zzs(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzapmVarZzs.zzh(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzo == 60 || iZzo == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzp, zzs(i7))) {
                    return false;
                }
            } else if (iZzo == 49) {
                list = (List) zzaqq.zzf(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    zzapmVarZzs = zzs(i7);
                    while (i3 < list.size()) {
                        if (!zzapmVarZzs.zzh(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzo == 50 && !((zzaot) zzaqq.zzf(obj, iZzp & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzj(Object obj, zzamz zzamzVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzp = zzp(i7);
            int[] iArr2 = this.zzc;
            int iZzo = zzo(iZzp);
            int i8 = iArr2[i7];
            if (iZzo <= 17) {
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
            long j = iZzp & i4;
            switch (iZzo) {
                case 0:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzf(i8, zzaqq.zza(obj, j));
                    }
                    break;
                case 1:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzo(i8, zzaqq.zzb(obj, j));
                    }
                    break;
                case 2:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzJ(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzb(i8, zzaqq.zzw(obj, j));
                    }
                    break;
                case 8:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzamzVar);
                    }
                    break;
                case 9:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzv(i8, unsafe.getObject(obj, j), zzs(i7));
                    }
                    break;
                case 10:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzd(i8, (zzaml) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzH(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzw(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzy(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzA(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzC(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzamzVar.zzq(i8, unsafe.getObject(obj, j), zzs(i7));
                    }
                    break;
                case 18:
                    zzapo.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 19:
                    zzapo.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 20:
                    zzapo.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 21:
                    zzapo.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 22:
                    zzapo.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 23:
                    zzapo.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 24:
                    zzapo.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 25:
                    zzapo.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzapo.zza;
                    if (list != null && !list.isEmpty()) {
                        zzamzVar.zzG(i11, list);
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzapm zzapmVarZzs = zzs(i7);
                    int i14 = zzapo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            zzamzVar.zzv(i13, list2.get(i15), zzapmVarZzs);
                        }
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzapo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzamzVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zzapo.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 30:
                    zzapo.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 31:
                    zzapo.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 32:
                    zzapo.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 33:
                    zzapo.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 34:
                    zzapo.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, false);
                    break;
                case 35:
                    zzapo.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 36:
                    zzapo.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 37:
                    zzapo.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 38:
                    zzapo.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 39:
                    zzapo.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 40:
                    zzapo.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 41:
                    zzapo.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 42:
                    zzapo.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 43:
                    zzapo.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 44:
                    zzapo.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 45:
                    zzapo.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 46:
                    zzapo.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 47:
                    zzapo.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 48:
                    zzapo.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzamzVar, true);
                    break;
                case 49:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzapm zzapmVarZzs2 = zzs(i7);
                    int i19 = zzapo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zzamzVar.zzq(i18, list4.get(i20), zzapmVarZzs2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                    break;
                case 51:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzf(i8, zzk(obj, j));
                    }
                    break;
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzo(i8, zzl(obj, j));
                    }
                    break;
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzt(i8, zzq(obj, j));
                    }
                    break;
                case 54:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzJ(i8, zzq(obj, j));
                    }
                    break;
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzr(i8, zzm(obj, j));
                    }
                    break;
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzm(i8, zzq(obj, j));
                    }
                    break;
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzk(i8, zzm(obj, j));
                    }
                    break;
                case 58:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzb(i8, zzN(obj, j));
                    }
                    break;
                case 59:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzamzVar);
                    }
                    break;
                case 60:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzv(i8, unsafe.getObject(obj, j), zzs(i7));
                    }
                    break;
                case 61:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzd(i8, (zzaml) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzH(i8, zzm(obj, j));
                    }
                    break;
                case 63:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzi(i8, zzm(obj, j));
                    }
                    break;
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzw(i8, zzm(obj, j));
                    }
                    break;
                case 65:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzy(i8, zzq(obj, j));
                    }
                    break;
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzA(i8, zzm(obj, j));
                    }
                    break;
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzC(i8, zzq(obj, j));
                    }
                    break;
                case 68:
                    if (zzM(obj, i8, i7)) {
                        zzamzVar.zzq(i8, unsafe.getObject(obj, j), zzs(i7));
                    }
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        zzaqg zzaqgVar = this.zzn;
        zzaqgVar.zzr(zzaqgVar.zzd(obj), zzamzVar);
    }
}
