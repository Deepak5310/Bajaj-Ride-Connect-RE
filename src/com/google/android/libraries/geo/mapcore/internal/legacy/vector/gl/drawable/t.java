package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.fc;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public final fg a;
    public final List b;
    public final int c;
    public final int d;
    public final int e;
    public float f = 0.0f;

    /* JADX WARN: Code duplicated, block: B:100:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:102:0x020c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0212  */
    /* JADX WARN: Code duplicated, block: B:105:0x021e  */
    /* JADX WARN: Code duplicated, block: B:108:0x022c  */
    /* JADX WARN: Code duplicated, block: B:109:0x022f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0243  */
    /* JADX WARN: Code duplicated, block: B:113:0x0245  */
    /* JADX WARN: Code duplicated, block: B:117:0x0255  */
    /* JADX WARN: Code duplicated, block: B:119:0x0267  */
    /* JADX WARN: Code duplicated, block: B:120:0x026a  */
    /* JADX WARN: Code duplicated, block: B:125:0x029f A[LOOP:2: B:123:0x0299->B:125:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:131:0x0306  */
    /* JADX WARN: Code duplicated, block: B:134:0x030c  */
    /* JADX WARN: Code duplicated, block: B:136:0x0316  */
    /* JADX WARN: Code duplicated, block: B:139:0x031c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0326  */
    /* JADX WARN: Code duplicated, block: B:144:0x032c  */
    /* JADX WARN: Code duplicated, block: B:146:0x032f  */
    /* JADX WARN: Code duplicated, block: B:148:0x0331  */
    /* JADX WARN: Code duplicated, block: B:150:0x0333  */
    /* JADX WARN: Code duplicated, block: B:61:0x0150  */
    /* JADX WARN: Code duplicated, block: B:64:0x015d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0163  */
    /* JADX WARN: Code duplicated, block: B:68:0x0166  */
    /* JADX WARN: Code duplicated, block: B:69:0x0168  */
    /* JADX WARN: Code duplicated, block: B:70:0x0169  */
    /* JADX WARN: Code duplicated, block: B:74:0x0178  */
    /* JADX WARN: Code duplicated, block: B:76:0x0184  */
    /* JADX WARN: Code duplicated, block: B:78:0x018a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bb A[PHI: r18
      0x01bb: PHI (r18v4 java.util.ArrayList) = (r18v3 java.util.ArrayList), (r18v5 java.util.ArrayList) binds: [B:86:0x01b9, B:81:0x019e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:93:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:95:0x01de  */
    /* JADX WARN: Code duplicated, block: B:96:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x01e5  */
    public t(fg fgVar, com.google.android.libraries.navigation.internal.oe.o oVar) {
        float[] fArr;
        int[] iArrO;
        int[] iArr;
        float[] fArrM;
        float[] fArrM2;
        float[] fArrM3;
        int[] iArr2;
        int i;
        int length;
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z;
        ArrayList arrayList3;
        int i2;
        int i3;
        int iA;
        int i4;
        int iA2;
        int i5;
        int iA3;
        int i6;
        int iIntValue;
        int i7;
        ArrayList arrayList4;
        boolean z2;
        int[] iArrCopyOfRange;
        float[] fArrCopyOfRange;
        int[] iArr3;
        boolean zIsEmpty;
        boolean z3;
        int[] iArr4;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        int i8;
        int i9;
        boolean z4;
        int[] iArr5;
        int i10;
        u uVar;
        int iIntValue2;
        int i11;
        int i12;
        int i13;
        int i14;
        this.a = fgVar;
        boolean z5 = oVar instanceof com.google.android.libraries.navigation.internal.oe.am;
        try {
            if (z5) {
                int[] iArr6 = v.b;
                fArrM = oVar.m(fgVar.c, 0);
                bh bhVarS = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.c);
                fgVar.h(bhVarS);
                if (fgVar.w.n(bhVarS.d)) {
                    bh bhVarS2 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.c);
                    fgVar.h(bhVarS2);
                    Object objK = fgVar.w.k(bhVarS2.d);
                    fArrM3 = oVar.m((com.google.android.libraries.navigation.internal.ael.x) (objK == null ? bhVarS2.b : bhVarS2.c(objK)), 1);
                } else {
                    fArrM3 = null;
                }
                try {
                    bh bhVarS3 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.d);
                    fgVar.h(bhVarS3);
                    if (fgVar.w.n(bhVarS3.d)) {
                        bh bhVarS4 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.d);
                        fgVar.h(bhVarS4);
                        Object objK2 = fgVar.w.k(bhVarS4.d);
                        fArrM2 = oVar.m((com.google.android.libraries.navigation.internal.ael.x) (objK2 == null ? bhVarS4.b : bhVarS4.c(objK2)), 1);
                        iArrO = null;
                    } else {
                        fArrM2 = null;
                        iArrO = null;
                    }
                    iArr = iArr6;
                    iArr2 = iArrO;
                } catch (IOException e) {
                    e = e;
                    fArr = fArrM3;
                    iArrO = null;
                    iArr = v.b;
                    fArrM = v.c;
                    e.printStackTrace();
                    fArrM2 = null;
                    fArrM3 = fArr;
                    iArr2 = null;
                }
            } else {
                int[] iArrO2 = oVar.o(fgVar.c, 0);
                float[] fArr5 = v.c;
                bh bhVarS5 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.c);
                fgVar.h(bhVarS5);
                if (fgVar.w.n(bhVarS5.d)) {
                    bh bhVarS6 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.c);
                    fgVar.h(bhVarS6);
                    Object objK3 = fgVar.w.k(bhVarS6.d);
                    iArrO = oVar.o((com.google.android.libraries.navigation.internal.ael.x) (objK3 == null ? bhVarS6.b : bhVarS6.c(objK3)), 1);
                } else {
                    iArrO = null;
                }
                try {
                    bh bhVarS7 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.d);
                    fgVar.h(bhVarS7);
                    if (fgVar.w.n(bhVarS7.d)) {
                        bh bhVarS8 = bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.d);
                        fgVar.h(bhVarS8);
                        Object objK4 = fgVar.w.k(bhVarS8.d);
                        int[] iArrO3 = oVar.o((com.google.android.libraries.navigation.internal.ael.x) (objK4 == null ? bhVarS8.b : bhVarS8.c(objK4)), 1);
                        fArrM3 = null;
                        fArrM = fArr5;
                        iArr = iArrO2;
                        iArr2 = iArrO3;
                        fArrM2 = null;
                    } else {
                        fArrM2 = null;
                        fArrM3 = null;
                        fArrM = fArr5;
                        iArr = iArrO2;
                        iArr2 = null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fArr = null;
                    iArr = v.b;
                    fArrM = v.c;
                    e.printStackTrace();
                    fArrM2 = null;
                    fArrM3 = fArr;
                    iArr2 = null;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fArr = null;
            iArrO = null;
        }
        if (!z5 || fArrM == v.c) {
            if (iArr != v.b) {
                length = iArr.length;
            } else {
                i = 0;
            }
            arrayList = new ArrayList();
            arrayList2 = new ArrayList(fgVar.e);
            if (arrayList2.isEmpty() || ((Integer) gs.d(arrayList2)).intValue() != i) {
                arrayList2.add(Integer.valueOf(i));
            }
            if ((fgVar.b & 32) != 0) {
                i13 = fgVar.j;
                i14 = fc.c;
                if (i14 != 0) {
                    throw null;
                }
                if ((i13 & i14) != 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            arrayList3 = new ArrayList();
            i2 = 0;
            i3 = 0;
            while (i2 < arrayList2.size()) {
                Integer num = (Integer) arrayList2.get(i2);
                iIntValue = num.intValue();
                if (iIntValue < i) {
                    i7 = i;
                    if (iArr != v.b) {
                        i12 = iIntValue + iIntValue;
                        arrayList4 = arrayList2;
                        if (iArr[i12] != iArr[i12 - 2] && iArr[i12 + 1] == iArr[i12 - 1]) {
                            z2 = true;
                        }
                    } else {
                        arrayList4 = arrayList2;
                        i11 = iIntValue + iIntValue;
                        if (fArrM[i11] != fArrM[i11 - 2] && fArrM[i11 + 1] == fArrM[i11 - 1]) {
                            z2 = true;
                        }
                    }
                    if (z || !z2) {
                        iArrCopyOfRange = v.b;
                        fArrCopyOfRange = v.c;
                        iArr3 = v.b;
                        zIsEmpty = arrayList3.isEmpty();
                        if (iArr != iArr3) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (zIsEmpty) {
                            if (z3) {
                                iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                            } else {
                                fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                            }
                            iArr4 = iArr;
                            fArr2 = fArrM;
                            uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                            i8 = iIntValue;
                            z4 = z;
                        } else {
                            iArr4 = iArr;
                            fArr2 = fArrM;
                            if (z3) {
                                int i15 = iIntValue - i3;
                                int size = arrayList3.size();
                                iArrCopyOfRange = new int[(i15 + i15) - (size + size)];
                            } else {
                                int i16 = iIntValue - i3;
                                int size2 = arrayList3.size();
                                fArrCopyOfRange = new float[(i16 + i16) - (size2 + size2)];
                            }
                            if (true != z3) {
                                fArr3 = fArr2;
                            } else {
                                fArr3 = iArr4;
                            }
                            int i17 = i3 + i3;
                            int iIntValue3 = ((Integer) arrayList3.get(0)).intValue() - i3;
                            if (true != z3) {
                                fArr4 = fArrCopyOfRange;
                            } else {
                                fArr4 = iArrCopyOfRange;
                            }
                            i8 = iIntValue;
                            System.arraycopy(fArr3, i17, fArr4, 0, iIntValue3 + iIntValue3);
                            i9 = 0;
                            while (i9 < arrayList3.size()) {
                                int iIntValue4 = ((Integer) arrayList3.get(i9)).intValue();
                                if (i9 == arrayList3.size() - 1) {
                                    iIntValue2 = i8;
                                } else {
                                    iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                                }
                                int i18 = iIntValue4 - i3;
                                int i19 = (iIntValue2 - iIntValue4) - 1;
                                System.arraycopy(fArr3, iIntValue4 + iIntValue4 + 2, fArr4, (i18 + i18) - (i9 + i9), i19 + i19);
                                i9++;
                                z = z;
                            }
                            z4 = z;
                            iArr5 = new int[arrayList3.size()];
                            for (i10 = 0; i10 < arrayList3.size(); i10++) {
                                iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                            }
                            uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                        }
                        arrayList.add(uVar);
                        arrayList3.clear();
                        i3 = i8;
                    } else {
                        arrayList3.add(num);
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        z4 = z;
                    }
                    i2++;
                    i = i7;
                    arrayList2 = arrayList4;
                    iArr = iArr4;
                    fArrM = fArr2;
                    z = z4;
                } else {
                    i7 = i;
                    arrayList4 = arrayList2;
                }
                z2 = false;
                if (z) {
                    iArrCopyOfRange = v.b;
                    fArrCopyOfRange = v.c;
                    iArr3 = v.b;
                    zIsEmpty = arrayList3.isEmpty();
                    if (iArr != iArr3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (zIsEmpty) {
                        if (z3) {
                            iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                        } else {
                            fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                        }
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                        i8 = iIntValue;
                        z4 = z;
                    } else {
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        if (z3) {
                            int i110 = iIntValue - i3;
                            int size3 = arrayList3.size();
                            iArrCopyOfRange = new int[(i110 + i110) - (size3 + size3)];
                        } else {
                            int i111 = iIntValue - i3;
                            int size4 = arrayList3.size();
                            fArrCopyOfRange = new float[(i111 + i111) - (size4 + size4)];
                        }
                        if (true != z3) {
                            fArr3 = fArr2;
                        } else {
                            fArr3 = iArr4;
                        }
                        int i112 = i3 + i3;
                        int iIntValue5 = ((Integer) arrayList3.get(0)).intValue() - i3;
                        if (true != z3) {
                            fArr4 = fArrCopyOfRange;
                        } else {
                            fArr4 = iArrCopyOfRange;
                        }
                        i8 = iIntValue;
                        System.arraycopy(fArr3, i112, fArr4, 0, iIntValue5 + iIntValue5);
                        i9 = 0;
                        while (i9 < arrayList3.size()) {
                            int iIntValue6 = ((Integer) arrayList3.get(i9)).intValue();
                            if (i9 == arrayList3.size() - 1) {
                                iIntValue2 = i8;
                            } else {
                                iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                            }
                            int i113 = iIntValue6 - i3;
                            int i114 = (iIntValue2 - iIntValue6) - 1;
                            System.arraycopy(fArr3, iIntValue6 + iIntValue6 + 2, fArr4, (i113 + i113) - (i9 + i9), i114 + i114);
                            i9++;
                            z = z;
                        }
                        z4 = z;
                        iArr5 = new int[arrayList3.size()];
                        while (i10 < arrayList3.size()) {
                            iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                        }
                        uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                    }
                    arrayList.add(uVar);
                    arrayList3.clear();
                    i3 = i8;
                } else {
                    iArrCopyOfRange = v.b;
                    fArrCopyOfRange = v.c;
                    iArr3 = v.b;
                    zIsEmpty = arrayList3.isEmpty();
                    if (iArr != iArr3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (zIsEmpty) {
                        if (z3) {
                            iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                        } else {
                            fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                        }
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                        i8 = iIntValue;
                        z4 = z;
                    } else {
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        if (z3) {
                            int i115 = iIntValue - i3;
                            int size5 = arrayList3.size();
                            iArrCopyOfRange = new int[(i115 + i115) - (size5 + size5)];
                        } else {
                            int i116 = iIntValue - i3;
                            int size6 = arrayList3.size();
                            fArrCopyOfRange = new float[(i116 + i116) - (size6 + size6)];
                        }
                        if (true != z3) {
                            fArr3 = fArr2;
                        } else {
                            fArr3 = iArr4;
                        }
                        int i117 = i3 + i3;
                        int iIntValue7 = ((Integer) arrayList3.get(0)).intValue() - i3;
                        if (true != z3) {
                            fArr4 = fArrCopyOfRange;
                        } else {
                            fArr4 = iArrCopyOfRange;
                        }
                        i8 = iIntValue;
                        System.arraycopy(fArr3, i117, fArr4, 0, iIntValue7 + iIntValue7);
                        i9 = 0;
                        while (i9 < arrayList3.size()) {
                            int iIntValue8 = ((Integer) arrayList3.get(i9)).intValue();
                            if (i9 == arrayList3.size() - 1) {
                                iIntValue2 = i8;
                            } else {
                                iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                            }
                            int i118 = iIntValue8 - i3;
                            int i119 = (iIntValue2 - iIntValue8) - 1;
                            System.arraycopy(fArr3, iIntValue8 + iIntValue8 + 2, fArr4, (i118 + i118) - (i9 + i9), i119 + i119);
                            i9++;
                            z = z;
                        }
                        z4 = z;
                        iArr5 = new int[arrayList3.size()];
                        while (i10 < arrayList3.size()) {
                            iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                        }
                        uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                    }
                    arrayList.add(uVar);
                    arrayList3.clear();
                    i3 = i8;
                }
                i2++;
                i = i7;
                arrayList2 = arrayList4;
                iArr = iArr4;
                fArrM = fArr2;
                z = z4;
            }
            this.b = arrayList;
            ((u) arrayList.get(0)).d = iArrO;
            ((u) arrayList.get(0)).f = fArrM3;
            ((u) gs.d(arrayList)).e = iArr2;
            ((u) gs.d(arrayList)).g = fArrM2;
            iA = ff.a(fgVar.g);
            iA = iA == 0 ? ff.b : iA;
            i4 = iA - 1;
            if (iA != 0) {
                throw null;
            }
            this.c = i4;
            iA2 = ff.a(fgVar.h);
            iA2 = iA2 == 0 ? ff.b : iA2;
            i5 = iA2 - 1;
            if (iA2 != 0) {
                throw null;
            }
            this.d = i5;
            iA3 = cz.a(fgVar.i);
            iA3 = iA3 == 0 ? cz.a : iA3;
            i6 = iA3 - 1;
            if (iA3 != 0) {
                throw null;
            }
            this.e = i6;
        }
        length = fArrM.length;
        i = length >> 1;
        arrayList = new ArrayList();
        arrayList2 = new ArrayList(fgVar.e);
        if (arrayList2.isEmpty()) {
            arrayList2.add(Integer.valueOf(i));
        } else {
            arrayList2.add(Integer.valueOf(i));
        }
        if ((fgVar.b & 32) != 0) {
            i13 = fgVar.j;
            i14 = fc.c;
            if (i14 != 0) {
                throw null;
            }
            if ((i13 & i14) != 0) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        arrayList3 = new ArrayList();
        i2 = 0;
        i3 = 0;
        while (i2 < arrayList2.size()) {
            Integer num2 = (Integer) arrayList2.get(i2);
            iIntValue = num2.intValue();
            if (iIntValue < i) {
                i7 = i;
                if (iArr != v.b) {
                    i12 = iIntValue + iIntValue;
                    arrayList4 = arrayList2;
                    if (iArr[i12] != iArr[i12 - 2]) {
                    }
                } else {
                    arrayList4 = arrayList2;
                    i11 = iIntValue + iIntValue;
                    if (fArrM[i11] != fArrM[i11 - 2]) {
                    }
                }
                if (z) {
                    iArrCopyOfRange = v.b;
                    fArrCopyOfRange = v.c;
                    iArr3 = v.b;
                    zIsEmpty = arrayList3.isEmpty();
                    if (iArr != iArr3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (zIsEmpty) {
                        if (z3) {
                            iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                        } else {
                            fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                        }
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                        i8 = iIntValue;
                        z4 = z;
                    } else {
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        if (z3) {
                            int i1110 = iIntValue - i3;
                            int size7 = arrayList3.size();
                            iArrCopyOfRange = new int[(i1110 + i1110) - (size7 + size7)];
                        } else {
                            int i1111 = iIntValue - i3;
                            int size8 = arrayList3.size();
                            fArrCopyOfRange = new float[(i1111 + i1111) - (size8 + size8)];
                        }
                        if (true != z3) {
                            fArr3 = fArr2;
                        } else {
                            fArr3 = iArr4;
                        }
                        int i1112 = i3 + i3;
                        int iIntValue9 = ((Integer) arrayList3.get(0)).intValue() - i3;
                        if (true != z3) {
                            fArr4 = fArrCopyOfRange;
                        } else {
                            fArr4 = iArrCopyOfRange;
                        }
                        i8 = iIntValue;
                        System.arraycopy(fArr3, i1112, fArr4, 0, iIntValue9 + iIntValue9);
                        i9 = 0;
                        while (i9 < arrayList3.size()) {
                            int iIntValue10 = ((Integer) arrayList3.get(i9)).intValue();
                            if (i9 == arrayList3.size() - 1) {
                                iIntValue2 = i8;
                            } else {
                                iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                            }
                            int i1113 = iIntValue10 - i3;
                            int i1114 = (iIntValue2 - iIntValue10) - 1;
                            System.arraycopy(fArr3, iIntValue10 + iIntValue10 + 2, fArr4, (i1113 + i1113) - (i9 + i9), i1114 + i1114);
                            i9++;
                            z = z;
                        }
                        z4 = z;
                        iArr5 = new int[arrayList3.size()];
                        while (i10 < arrayList3.size()) {
                            iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                        }
                        uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                    }
                    arrayList.add(uVar);
                    arrayList3.clear();
                    i3 = i8;
                } else {
                    iArrCopyOfRange = v.b;
                    fArrCopyOfRange = v.c;
                    iArr3 = v.b;
                    zIsEmpty = arrayList3.isEmpty();
                    if (iArr != iArr3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (zIsEmpty) {
                        if (z3) {
                            iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                        } else {
                            fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                        }
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                        i8 = iIntValue;
                        z4 = z;
                    } else {
                        iArr4 = iArr;
                        fArr2 = fArrM;
                        if (z3) {
                            int i1115 = iIntValue - i3;
                            int size9 = arrayList3.size();
                            iArrCopyOfRange = new int[(i1115 + i1115) - (size9 + size9)];
                        } else {
                            int i1116 = iIntValue - i3;
                            int size10 = arrayList3.size();
                            fArrCopyOfRange = new float[(i1116 + i1116) - (size10 + size10)];
                        }
                        if (true != z3) {
                            fArr3 = fArr2;
                        } else {
                            fArr3 = iArr4;
                        }
                        int i1117 = i3 + i3;
                        int iIntValue11 = ((Integer) arrayList3.get(0)).intValue() - i3;
                        if (true != z3) {
                            fArr4 = fArrCopyOfRange;
                        } else {
                            fArr4 = iArrCopyOfRange;
                        }
                        i8 = iIntValue;
                        System.arraycopy(fArr3, i1117, fArr4, 0, iIntValue11 + iIntValue11);
                        i9 = 0;
                        while (i9 < arrayList3.size()) {
                            int iIntValue12 = ((Integer) arrayList3.get(i9)).intValue();
                            if (i9 == arrayList3.size() - 1) {
                                iIntValue2 = i8;
                            } else {
                                iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                            }
                            int i1118 = iIntValue12 - i3;
                            int i1119 = (iIntValue2 - iIntValue12) - 1;
                            System.arraycopy(fArr3, iIntValue12 + iIntValue12 + 2, fArr4, (i1118 + i1118) - (i9 + i9), i1119 + i1119);
                            i9++;
                            z = z;
                        }
                        z4 = z;
                        iArr5 = new int[arrayList3.size()];
                        while (i10 < arrayList3.size()) {
                            iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                        }
                        uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                    }
                    arrayList.add(uVar);
                    arrayList3.clear();
                    i3 = i8;
                }
                i2++;
                i = i7;
                arrayList2 = arrayList4;
                iArr = iArr4;
                fArrM = fArr2;
                z = z4;
            } else {
                i7 = i;
                arrayList4 = arrayList2;
            }
            z2 = false;
            if (z) {
                iArrCopyOfRange = v.b;
                fArrCopyOfRange = v.c;
                iArr3 = v.b;
                zIsEmpty = arrayList3.isEmpty();
                if (iArr != iArr3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (zIsEmpty) {
                    if (z3) {
                        iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                    } else {
                        fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                    }
                    iArr4 = iArr;
                    fArr2 = fArrM;
                    uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                    i8 = iIntValue;
                    z4 = z;
                } else {
                    iArr4 = iArr;
                    fArr2 = fArrM;
                    if (z3) {
                        int i11110 = iIntValue - i3;
                        int size11 = arrayList3.size();
                        iArrCopyOfRange = new int[(i11110 + i11110) - (size11 + size11)];
                    } else {
                        int i11111 = iIntValue - i3;
                        int size12 = arrayList3.size();
                        fArrCopyOfRange = new float[(i11111 + i11111) - (size12 + size12)];
                    }
                    if (true != z3) {
                        fArr3 = fArr2;
                    } else {
                        fArr3 = iArr4;
                    }
                    int i11112 = i3 + i3;
                    int iIntValue13 = ((Integer) arrayList3.get(0)).intValue() - i3;
                    if (true != z3) {
                        fArr4 = fArrCopyOfRange;
                    } else {
                        fArr4 = iArrCopyOfRange;
                    }
                    i8 = iIntValue;
                    System.arraycopy(fArr3, i11112, fArr4, 0, iIntValue13 + iIntValue13);
                    i9 = 0;
                    while (i9 < arrayList3.size()) {
                        int iIntValue14 = ((Integer) arrayList3.get(i9)).intValue();
                        if (i9 == arrayList3.size() - 1) {
                            iIntValue2 = i8;
                        } else {
                            iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                        }
                        int i11113 = iIntValue14 - i3;
                        int i11114 = (iIntValue2 - iIntValue14) - 1;
                        System.arraycopy(fArr3, iIntValue14 + iIntValue14 + 2, fArr4, (i11113 + i11113) - (i9 + i9), i11114 + i11114);
                        i9++;
                        z = z;
                    }
                    z4 = z;
                    iArr5 = new int[arrayList3.size()];
                    while (i10 < arrayList3.size()) {
                        iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                    }
                    uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                }
                arrayList.add(uVar);
                arrayList3.clear();
                i3 = i8;
            } else {
                iArrCopyOfRange = v.b;
                fArrCopyOfRange = v.c;
                iArr3 = v.b;
                zIsEmpty = arrayList3.isEmpty();
                if (iArr != iArr3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (zIsEmpty) {
                    if (z3) {
                        iArrCopyOfRange = Arrays.copyOfRange(iArr, i3 + i3, iIntValue + iIntValue);
                    } else {
                        fArrCopyOfRange = Arrays.copyOfRange(fArrM, i3 + i3, iIntValue + iIntValue);
                    }
                    iArr4 = iArr;
                    fArr2 = fArrM;
                    uVar = new u(new int[0], new int[1], iArrCopyOfRange, fArrCopyOfRange);
                    i8 = iIntValue;
                    z4 = z;
                } else {
                    iArr4 = iArr;
                    fArr2 = fArrM;
                    if (z3) {
                        int i11115 = iIntValue - i3;
                        int size13 = arrayList3.size();
                        iArrCopyOfRange = new int[(i11115 + i11115) - (size13 + size13)];
                    } else {
                        int i11116 = iIntValue - i3;
                        int size14 = arrayList3.size();
                        fArrCopyOfRange = new float[(i11116 + i11116) - (size14 + size14)];
                    }
                    if (true != z3) {
                        fArr3 = fArr2;
                    } else {
                        fArr3 = iArr4;
                    }
                    int i11117 = i3 + i3;
                    int iIntValue15 = ((Integer) arrayList3.get(0)).intValue() - i3;
                    if (true != z3) {
                        fArr4 = fArrCopyOfRange;
                    } else {
                        fArr4 = iArrCopyOfRange;
                    }
                    i8 = iIntValue;
                    System.arraycopy(fArr3, i11117, fArr4, 0, iIntValue15 + iIntValue15);
                    i9 = 0;
                    while (i9 < arrayList3.size()) {
                        int iIntValue16 = ((Integer) arrayList3.get(i9)).intValue();
                        if (i9 == arrayList3.size() - 1) {
                            iIntValue2 = i8;
                        } else {
                            iIntValue2 = ((Integer) arrayList3.get(i9 + 1)).intValue();
                        }
                        int i11118 = iIntValue16 - i3;
                        int i11119 = (iIntValue2 - iIntValue16) - 1;
                        System.arraycopy(fArr3, iIntValue16 + iIntValue16 + 2, fArr4, (i11118 + i11118) - (i9 + i9), i11119 + i11119);
                        i9++;
                        z = z;
                    }
                    z4 = z;
                    iArr5 = new int[arrayList3.size()];
                    while (i10 < arrayList3.size()) {
                        iArr5[i10] = ((((Integer) arrayList3.get(i10)).intValue() - i3) - i10) - 1;
                    }
                    uVar = new u(iArr5, new int[arrayList3.size() + 1], iArrCopyOfRange, fArrCopyOfRange);
                }
                arrayList.add(uVar);
                arrayList3.clear();
                i3 = i8;
            }
            i2++;
            i = i7;
            arrayList2 = arrayList4;
            iArr = iArr4;
            fArrM = fArr2;
            z = z4;
        }
        this.b = arrayList;
        ((u) arrayList.get(0)).d = iArrO;
        ((u) arrayList.get(0)).f = fArrM3;
        ((u) gs.d(arrayList)).e = iArr2;
        ((u) gs.d(arrayList)).g = fArrM2;
        iA = ff.a(fgVar.g);
        if (iA == 0) {
        }
        i4 = iA - 1;
        if (iA != 0) {
            throw null;
        }
        this.c = i4;
        iA2 = ff.a(fgVar.h);
        if (iA2 == 0) {
        }
        i5 = iA2 - 1;
        if (iA2 != 0) {
            throw null;
        }
        this.d = i5;
        iA3 = cz.a(fgVar.i);
        if (iA3 == 0) {
        }
        i6 = iA3 - 1;
        if (iA3 != 0) {
            throw null;
        }
        this.e = i6;
    }
}
