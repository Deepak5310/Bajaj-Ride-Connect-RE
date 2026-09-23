package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.yz.el;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bc {
    public boolean a;
    public int[] b = NativeTessellator.a;
    public float[] c;
    public int d;
    public int[] e;
    public float[] f;
    public int[] g;
    public float[] h;

    public bc() {
        float[] fArr = NativeTessellator.b;
        this.c = fArr;
        this.e = this.b;
        this.f = fArr;
        this.g = NativeTessellator.a;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x09d5 */
    /* JADX WARN: Code duplicated, block: B:177:0x0394  */
    /* JADX WARN: Code duplicated, block: B:198:0x0408  */
    /* JADX WARN: Code duplicated, block: B:200:0x0412  */
    /* JADX WARN: Code duplicated, block: B:208:0x0443  */
    /* JADX WARN: Code duplicated, block: B:209:0x0446  */
    /* JADX WARN: Code duplicated, block: B:212:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:213:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:217:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:220:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:223:0x04d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:225:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:226:0x04da  */
    /* JADX WARN: Code duplicated, block: B:229:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:230:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:233:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:234:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:238:0x0513 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:239:0x0515  */
    /* JADX WARN: Code duplicated, block: B:240:0x0518  */
    /* JADX WARN: Code duplicated, block: B:243:0x051e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:244:0x0520  */
    /* JADX WARN: Code duplicated, block: B:245:0x0523  */
    /* JADX WARN: Code duplicated, block: B:248:0x0532  */
    /* JADX WARN: Code duplicated, block: B:249:0x0534  */
    /* JADX WARN: Code duplicated, block: B:252:0x053b  */
    /* JADX WARN: Code duplicated, block: B:253:0x053f  */
    /* JADX WARN: Code duplicated, block: B:381:0x0881  */
    /* JADX WARN: Code duplicated, block: B:487:0x050f A[EDGE_INSN: B:487:0x050f->B:236:0x050f BREAK  A[LOOP:17: B:215:0x04ba->B:235:0x04f4], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(gm gmVar, com.google.android.libraries.navigation.internal.oe.o oVar, boolean z) throws Throwable {
        NativeTessellator nativeTessellator;
        NativeTessellator nativeTessellator2;
        ArrayList<List> arrayList;
        bc bcVar;
        int length;
        Iterator it2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int iIndexOf;
        boolean z2;
        Iterator it3;
        NativeTessellator nativeTessellator3;
        List list;
        int size;
        int iIntValue;
        int iIntValue2;
        int iRound;
        int i;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iIntValue3;
        gm gmVar2 = gmVar;
        this.e = this.b;
        this.f = this.c;
        int i20 = gmVar2.b;
        if ((i20 & 4) != 0) {
            this.g = cj.g(gmVar2.h, this.d);
            return;
        }
        if ((i20 & 8) == 0) {
            if ((i20 & 16) == 0 || (i20 & 32) != 0) {
                this.g = com.google.android.libraries.navigation.internal.zy.i.f(gmVar2.g);
                return;
            }
            return;
        }
        synchronized (NativeTessellator.c) {
            try {
                nativeTessellator = (NativeTessellator) NativeTessellator.c.c();
            } catch (Throwable th) {
                th = th;
                while (true) {
                    throw th;
                }
            }
        }
        if (this.a) {
            float[] fArr = this.c;
            int i21 = this.d;
            com.google.android.libraries.navigation.internal.ael.bq bqVar = gmVar2.d;
            nativeTessellator.nativePrepareForLoopsFloat(fArr, i21, nativeTessellator.nativeTessellatorPtr);
            int i22 = 0;
            for (int i23 = gmVar2.j; i23 < i21; i23 = iIntValue3) {
                while (true) {
                    if (i22 >= bqVar.size()) {
                        iIntValue3 = 0;
                        break;
                    } else {
                        if (((Integer) bqVar.get(i22)).intValue() > i23) {
                            iIntValue3 = ((Integer) bqVar.get(i22)).intValue();
                            break;
                        }
                        i22++;
                    }
                }
                if (i22 >= bqVar.size()) {
                    iIntValue3 = i21;
                }
                nativeTessellator.nativeAddLoop(i23, iIntValue3, nativeTessellator.nativeTessellatorPtr);
                if (z) {
                    nativeTessellator.nativeFinishPolygon(nativeTessellator.nativeTessellatorPtr);
                }
            }
            nativeTessellator.nativeFinishPolygon(nativeTessellator.nativeTessellatorPtr);
            nativeTessellator.nativeFinishLoopsFloat(fArr, nativeTessellator.nativeTessellatorPtr);
            bcVar = this;
        } else {
            boolean z4 = true;
            if (gmVar2.j < 0 || !((oVar instanceof com.google.android.libraries.navigation.internal.oe.v) || (oVar instanceof com.google.android.libraries.navigation.internal.oe.u))) {
                nativeTessellator2 = nativeTessellator;
                arrayList = null;
            } else {
                int[] iArr = this.b;
                com.google.android.libraries.navigation.internal.ael.bq bqVar2 = gmVar2.d;
                int[] iArr2 = (int[]) iArr.clone();
                int i24 = ev.d;
                eq eqVar = new eq();
                eqVar.j(bqVar2);
                if (bqVar2.isEmpty() || ((Integer) gs.d(bqVar2)).intValue() != (iArr2.length >> 1)) {
                    eqVar.h(Integer.valueOf(iArr2.length >> 1));
                }
                int i25 = 0;
                while (true) {
                    length = iArr2.length;
                    if (i25 >= length) {
                        break;
                    }
                    int i26 = iArr2[i25];
                    int i27 = bj.a;
                    if (i26 > i27 || i26 < (-i27)) {
                        iArr2[i25] = i26 % i27;
                    }
                    i25 += 2;
                }
                int i28 = length >> 1;
                int[] iArr3 = new int[length];
                for (int i29 = 0; i29 < i28; i29++) {
                    if (i29 == i28 - 1) {
                        i18 = 0;
                    } else {
                        int i30 = i29 + 1;
                        i18 = i30 + i30;
                    }
                    int i31 = i29 + i29;
                    int i32 = iArr2[i31];
                    int i33 = i31 + 1;
                    int i34 = iArr2[i33];
                    int i35 = iArr2[i18];
                    int i36 = i18 + 1;
                    int i37 = iArr2[i36];
                    iArr3[i31] = i32;
                    iArr3[i33] = i34;
                    iArr3[i18] = i35;
                    iArr3[i36] = i37;
                    int iAbs = Math.abs(i32);
                    int i38 = bj.a;
                    if ((iAbs == i38 || Math.abs(i35) == i38) && (Math.abs(i32) != i38 || Math.abs(i35) != i38)) {
                        int i39 = -i38;
                        if (i32 == i39 && i35 > 0) {
                            iArr3[i31] = i38;
                            iArr3[i18] = i35;
                        } else if (i32 == i38 && i35 < 0) {
                            iArr3[i31] = i39;
                            iArr3[i18] = i35;
                        } else if (i35 == i39 && i32 > 0) {
                            iArr3[i31] = i32;
                            iArr3[i18] = i38;
                        } else if (i35 == i38 && i32 < 0) {
                            iArr3[i31] = i32;
                            iArr3[i18] = i39;
                        }
                    }
                }
                ev evVarG = eqVar.g();
                bi biVar = new bi();
                biVar.e.clear();
                no it4 = evVarG.iterator();
                int iIntValue4 = 0;
                while (it4.hasNext()) {
                    Integer num = (Integer) it4.next();
                    ArrayList arrayList4 = new ArrayList();
                    while (iIntValue4 < num.intValue()) {
                        int i40 = iIntValue4 + iIntValue4;
                        arrayList4.add(Integer.valueOf(iArr3[i40]));
                        arrayList4.add(Integer.valueOf(iArr3[i40 + 1]));
                        iIntValue4++;
                    }
                    biVar.e.add(arrayList4);
                    iIntValue4 = num.intValue();
                }
                biVar.c.clear();
                biVar.d.clear();
                for (int i41 = 0; i41 < biVar.e.size(); i41++) {
                    biVar.c.add(new ArrayList());
                    biVar.d.add(new ArrayList());
                }
                Iterator it5 = biVar.e.iterator();
                while (it5.hasNext()) {
                    List list2 = (List) it5.next();
                    int iIndexOf2 = biVar.e.indexOf(list2);
                    if (iIndexOf2 > 0) {
                        int iIntValue5 = ((Integer) evVarG.get(iIndexOf2 - 1)).intValue();
                        i15 = iIntValue5 + iIntValue5;
                    } else {
                        i15 = 0;
                    }
                    int size2 = list2.size() / 2;
                    int i42 = 0;
                    int i43 = 0;
                    while (i42 < size2) {
                        if (i42 == size2 - 1) {
                            i16 = 0;
                        } else {
                            int i44 = i42 + 1;
                            i16 = i44 + i44;
                        }
                        int i45 = i42 + i42 + i15;
                        ev evVar = evVarG;
                        int iAbs2 = iArr3[i45];
                        int i46 = iArr3[i45 + (z4 ? 1 : 0)];
                        int i47 = i16 + i15;
                        Iterator it6 = it5;
                        int iAbs3 = iArr3[i47];
                        int i48 = iArr3[i47 + (z4 ? 1 : 0)];
                        boolean zB = bj.b(iAbs2, iAbs3);
                        boolean zB2 = bj.b(iAbs3, iAbs2);
                        if (zB) {
                            z4 = zB2;
                        } else {
                            if (!zB2) {
                                i17 = z4 ? 1 : 0;
                                size2 = size2;
                            }
                            i43 += i17;
                            i42++;
                            z4 = i17;
                            it5 = it6;
                            size2 = size2;
                            evVarG = evVar;
                        }
                        if (iAbs2 < 0) {
                            int i49 = bj.a;
                            iAbs2 = (i49 + i49) - Math.abs(iAbs2);
                        } else {
                            int i50 = bj.a;
                            iAbs3 = (i50 + i50) - Math.abs(iAbs3);
                        }
                        float f = iAbs3 - iAbs2;
                        float f2 = i48 - i46;
                        int iRound2 = f == 0.0f ? i46 + ((int) (f2 / 2.0f)) : Math.round(((f2 * bj.a) / f) + (i46 - ((iAbs2 * f2) / f)));
                        int i51 = i43 + 1;
                        int i52 = i51 + i51;
                        biVar.a(iIndexOf2, i52, iRound2, z4);
                        Integer numValueOf = Integer.valueOf((i52 + 2) / 2);
                        Integer numValueOf2 = Integer.valueOf(iRound2);
                        el elVar = new el(numValueOf, numValueOf2);
                        if (z4) {
                            ((List) biVar.c.get(iIndexOf2)).add(elVar);
                        } else {
                            ((List) biVar.d.get(iIndexOf2)).add(elVar);
                        }
                        biVar.a(iIndexOf2, i52, iRound2, !z4);
                        el elVar2 = new el(Integer.valueOf(i52 / 2), numValueOf2);
                        if (z4) {
                            ((List) biVar.d.get(iIndexOf2)).add(elVar2);
                        } else {
                            ((List) biVar.c.get(iIndexOf2)).add(elVar2);
                        }
                        i43 += 2;
                        i17 = 1;
                        i43 += i17;
                        i42++;
                        z4 = i17;
                        it5 = it6;
                        size2 = size2;
                        evVarG = evVar;
                    }
                }
                int i53 = z4 ? 1 : 0;
                if (biVar.e.isEmpty() || (biVar.e.size() == i53 && ((List) biVar.e.get(0)).size() == length)) {
                    nativeTessellator2 = nativeTessellator;
                    arrayList = null;
                } else {
                    Iterator it7 = biVar.c.iterator();
                    while (it7.hasNext()) {
                        Collections.sort((List) it7.next(), bi.a);
                    }
                    Iterator it8 = biVar.d.iterator();
                    while (it8.hasNext()) {
                        Collections.sort((List) it8.next(), bi.b);
                    }
                    Iterator it9 = biVar.e.iterator();
                    while (it9.hasNext()) {
                        List list3 = (List) it9.next();
                        int iIndexOf3 = biVar.e.indexOf(list3);
                        List list4 = (List) biVar.c.get(iIndexOf3);
                        if (list4.size() % 2 != 0) {
                            if (list3 == null || list3.isEmpty() || list3.size() % 2 == 1) {
                                z2 = false;
                            } else {
                                int size3 = list3.size() / 2;
                                int i54 = 0;
                                int i55 = 0;
                                for (int i56 = 0; i56 < size3; i56++) {
                                    int iIntValue6 = ((Integer) list3.get(i56 + i56)).intValue();
                                    if (i56 == size3 - 1) {
                                        i13 = 0;
                                    } else {
                                        int i57 = i56 + 1;
                                        i13 = i57 + i57;
                                    }
                                    int iIntValue7 = ((Integer) list3.get(i13)).intValue();
                                    if (bj.b(iIntValue6, iIntValue7) || (iIntValue6 == (i14 = bj.b) && iIntValue7 == (-i14))) {
                                        i54++;
                                    } else if (bj.b(iIntValue7, iIntValue6) || (iIntValue7 == i14 && iIntValue6 == (-i14))) {
                                        i55++;
                                    }
                                }
                                if (i54 > i55) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            int size4 = list4.size() - 1;
                            if (!z2) {
                                int iIntValue8 = ((Integer) ((Map.Entry) list4.get(0)).getValue()).intValue();
                                int i58 = 0;
                                while (i58 < list4.size() && ((Integer) ((Map.Entry) list4.get(i58)).getValue()).intValue() == iIntValue8) {
                                    i58++;
                                }
                                size4 = (i58 == list4.size() || ((Integer) ((Map.Entry) list4.get(i58)).getValue()).intValue() != iIntValue8) ? i58 - 1 : i58;
                            }
                            Map.Entry entry = (Map.Entry) list4.get(size4);
                            int iIntValue9 = ((Integer) entry.getValue()).intValue();
                            int iIntValue10 = ((Integer) entry.getValue()).intValue();
                            while (true) {
                                if (!z2) {
                                    if (iIntValue10 > iIntValue9) {
                                        it3 = it9;
                                        nativeTessellator3 = nativeTessellator;
                                        break;
                                    }
                                    list = (List) biVar.d.get(iIndexOf3);
                                    if (z2) {
                                        size = 0;
                                    } else {
                                        size = list.size() - 1;
                                        while (size >= 0) {
                                            size--;
                                        }
                                        if (size >= 0) {
                                            size++;
                                        } else {
                                            size++;
                                        }
                                    }
                                    iIntValue = ((Integer) ((Map.Entry) list.get(size)).getKey()).intValue();
                                    iIntValue2 = ((Integer) entry.getKey()).intValue();
                                    ((List) biVar.c.get(iIndexOf3)).remove(size4);
                                    ((List) biVar.d.get(iIndexOf3)).remove(size);
                                    list3.set(iIntValue2 + iIntValue2, Integer.valueOf(bj.a));
                                    list3.set(iIntValue + iIntValue, Integer.valueOf(-bj.a));
                                    iRound = (int) (Math.round(new com.google.android.libraries.navigation.internal.oe.x(0, iIntValue10).b() / 10.0d) * 10);
                                    if (z2) {
                                        i2 = ((86 - iRound) / 10) + 1;
                                        i = 10;
                                    } else {
                                        i = 10;
                                        i2 = ((iRound + 86) / 10) + 1;
                                    }
                                    i3 = i2;
                                    while (true) {
                                        it3 = it9;
                                        nativeTessellator3 = nativeTessellator;
                                        if (i3 > 0) {
                                            break;
                                            break;
                                        }
                                        i9 = iRound + ((true == z2 ? i : -10) * i3);
                                        if (i3 == i2) {
                                            i10 = i9;
                                        } else if (true != z2) {
                                            i10 = -86;
                                        } else {
                                            i10 = 86;
                                        }
                                        int i59 = com.google.android.libraries.navigation.internal.oe.x.A(i10, 0.0d).b;
                                        if (iIntValue2 < iIntValue) {
                                            i11 = iIntValue2;
                                        } else {
                                            i11 = iIntValue;
                                        }
                                        int i60 = i11 + 1;
                                        if (iIntValue2 < iIntValue) {
                                            i12 = bj.a;
                                        } else {
                                            i12 = -bj.a;
                                        }
                                        int i61 = i60 + i60;
                                        list3.add(i61, Integer.valueOf(i12));
                                        list3.add(i61 + 1, Integer.valueOf(i59));
                                        i3--;
                                        nativeTessellator = nativeTessellator3;
                                        it9 = it3;
                                    }
                                    z3 = true;
                                    i4 = i2;
                                    while (i4 > 0) {
                                        if (z3 != z2) {
                                            i5 = -10;
                                        } else {
                                            i5 = i;
                                        }
                                        i6 = (i5 * i4) + iRound;
                                        if (i4 == i2) {
                                            if (z3 != z2) {
                                                i6 = -86;
                                            } else {
                                                i6 = 86;
                                            }
                                        }
                                        int i62 = iIntValue9;
                                        int i63 = iRound;
                                        int i64 = com.google.android.libraries.navigation.internal.oe.x.A(i6, 0.0d).b;
                                        if (iIntValue2 < iIntValue) {
                                            i7 = iIntValue;
                                        } else {
                                            i7 = iIntValue2;
                                        }
                                        int i65 = (i2 + i2) - i4;
                                        if (iIntValue2 < iIntValue) {
                                            i8 = -bj.a;
                                        } else {
                                            i8 = bj.a;
                                        }
                                        int i66 = i7 + i65;
                                        int i67 = i66 + i66;
                                        list3.add(i67, Integer.valueOf(i8));
                                        list3.add(i67 + 1, Integer.valueOf(i64));
                                        i4--;
                                        iIntValue9 = i62;
                                        iRound = i63;
                                        z3 = true;
                                    }
                                    int i68 = iIntValue9;
                                    size4--;
                                    if (!list4.isEmpty()) {
                                        break;
                                        break;
                                    }
                                    break;
                                }
                                if (iIntValue10 < iIntValue9) {
                                    it3 = it9;
                                    nativeTessellator3 = nativeTessellator;
                                    break;
                                }
                                list = (List) biVar.d.get(iIndexOf3);
                                if (z2) {
                                    size = list.size() - 1;
                                    while (size >= 0 && ((Integer) ((Map.Entry) list.get(size)).getValue()).intValue() == iIntValue10) {
                                        size--;
                                    }
                                    if (size >= 0 || ((Integer) ((Map.Entry) list.get(size)).getValue()).intValue() != iIntValue10) {
                                        size++;
                                    }
                                } else {
                                    size = 0;
                                }
                                iIntValue = ((Integer) ((Map.Entry) list.get(size)).getKey()).intValue();
                                iIntValue2 = ((Integer) entry.getKey()).intValue();
                                ((List) biVar.c.get(iIndexOf3)).remove(size4);
                                ((List) biVar.d.get(iIndexOf3)).remove(size);
                                list3.set(iIntValue2 + iIntValue2, Integer.valueOf(bj.a));
                                list3.set(iIntValue + iIntValue, Integer.valueOf(-bj.a));
                                iRound = (int) (Math.round(new com.google.android.libraries.navigation.internal.oe.x(0, iIntValue10).b() / 10.0d) * 10);
                                if (z2) {
                                    i2 = ((86 - iRound) / 10) + 1;
                                    i = 10;
                                } else {
                                    i = 10;
                                    i2 = ((iRound + 86) / 10) + 1;
                                }
                                i3 = i2;
                                while (true) {
                                    it3 = it9;
                                    nativeTessellator3 = nativeTessellator;
                                    if (i3 > 0) {
                                        break;
                                    }
                                    i9 = iRound + ((true == z2 ? i : -10) * i3);
                                    if (i3 == i2) {
                                        i10 = i9;
                                    } else if (true != z2) {
                                        i10 = -86;
                                    } else {
                                        i10 = 86;
                                    }
                                    int i510 = com.google.android.libraries.navigation.internal.oe.x.A(i10, 0.0d).b;
                                    if (iIntValue2 < iIntValue) {
                                        i11 = iIntValue2;
                                    } else {
                                        i11 = iIntValue;
                                    }
                                    int i69 = i11 + 1;
                                    if (iIntValue2 < iIntValue) {
                                        i12 = bj.a;
                                    } else {
                                        i12 = -bj.a;
                                    }
                                    int i610 = i69 + i69;
                                    list3.add(i610, Integer.valueOf(i12));
                                    list3.add(i610 + 1, Integer.valueOf(i510));
                                    i3--;
                                    nativeTessellator = nativeTessellator3;
                                    it9 = it3;
                                }
                                z3 = true;
                                i4 = i2;
                                while (i4 > 0) {
                                    if (z3 != z2) {
                                        i5 = -10;
                                    } else {
                                        i5 = i;
                                    }
                                    i6 = (i5 * i4) + iRound;
                                    if (i4 == i2) {
                                        if (z3 != z2) {
                                            i6 = -86;
                                        } else {
                                            i6 = 86;
                                        }
                                    }
                                    int i611 = iIntValue9;
                                    int i612 = iRound;
                                    int i613 = com.google.android.libraries.navigation.internal.oe.x.A(i6, 0.0d).b;
                                    if (iIntValue2 < iIntValue) {
                                        i7 = iIntValue;
                                    } else {
                                        i7 = iIntValue2;
                                    }
                                    int i614 = (i2 + i2) - i4;
                                    if (iIntValue2 < iIntValue) {
                                        i8 = -bj.a;
                                    } else {
                                        i8 = bj.a;
                                    }
                                    int i615 = i7 + i614;
                                    int i616 = i615 + i615;
                                    list3.add(i616, Integer.valueOf(i8));
                                    list3.add(i616 + 1, Integer.valueOf(i613));
                                    i4--;
                                    iIntValue9 = i611;
                                    iRound = i612;
                                    z3 = true;
                                }
                                int i617 = iIntValue9;
                                size4--;
                                if (!list4.isEmpty() || size4 < 0) {
                                    break;
                                }
                                entry = (Map.Entry) list4.get(size4);
                                iIntValue10 = ((Integer) entry.getValue()).intValue();
                                iIntValue9 = i617;
                                nativeTessellator = nativeTessellator3;
                                it9 = it3;
                            }
                            List list5 = (List) biVar.d.get(iIndexOf3);
                            if (list4.size() % 2 == 1) {
                                int size5 = list4.size() - 1;
                                int iIntValue11 = ((Integer) ((Map.Entry) list4.get(size5)).getKey()).intValue();
                                list4.remove(size5);
                                list3.set(iIntValue11 + iIntValue11, Integer.valueOf(bj.a));
                                int iIntValue12 = ((Integer) ((Map.Entry) list5.get(size5)).getKey()).intValue();
                                list5.remove(size5);
                                list3.set(iIntValue12 + iIntValue12, Integer.valueOf(-bj.a));
                            }
                            nativeTessellator = nativeTessellator3;
                            it9 = it3;
                        }
                    }
                    nativeTessellator2 = nativeTessellator;
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it10 = biVar.e.iterator();
                    while (it10.hasNext()) {
                        List list6 = (List) it10.next();
                        int iIndexOf4 = biVar.e.indexOf(list6);
                        if (((List) biVar.c.get(iIndexOf4)).isEmpty() || ((List) biVar.d.get(iIndexOf4)).isEmpty()) {
                            it2 = it10;
                            arrayList2 = arrayList5;
                            ArrayList arrayList6 = new ArrayList(list6.size());
                            arrayList6.addAll(list6);
                            arrayList2.add(arrayList6);
                        } else {
                            ArrayList arrayList7 = new ArrayList();
                            int i70 = 0;
                            int iA = 0;
                            int iA2 = 0;
                            boolean z5 = false;
                            boolean z6 = false;
                            while (i70 < list6.size() / 2) {
                                int i71 = iA + iA;
                                Integer num2 = (Integer) list6.get(i71);
                                int iIntValue13 = num2.intValue();
                                int i72 = i71 + 1;
                                Integer num3 = (Integer) list6.get(i72);
                                it10 = it10;
                                int iIntValue14 = num3.intValue();
                                ArrayList arrayList8 = arrayList5;
                                int i73 = bj.c;
                                if (iIntValue13 == i73 || iIntValue14 == i73) {
                                    if (iA != iA2 - 1 || iA2 == 0 || !z5 || arrayList7.size() < 3) {
                                        arrayList3 = arrayList8;
                                    } else {
                                        arrayList3 = arrayList8;
                                        arrayList3.add(arrayList7);
                                        arrayList7 = new ArrayList();
                                        iA2 = 0;
                                        z5 = false;
                                        z6 = false;
                                    }
                                    iA = bj.a(iA, list6.size() / 2);
                                    arrayList5 = arrayList3;
                                } else {
                                    int i74 = iIntValue14;
                                    if (Math.abs(iIntValue13) == bj.b && (z6 || arrayList7.isEmpty())) {
                                        iA = bj.a(iA, list6.size() / 2);
                                    } else {
                                        arrayList7.add(num2);
                                        arrayList7.add(num3);
                                        list6.set(i71, Integer.valueOf(bj.c));
                                        list6.set(i72, Integer.valueOf(bj.c));
                                        int i75 = i70 + 1;
                                        if (Math.abs(iIntValue13) == bj.b) {
                                            if (iA2 < iA && !z5) {
                                                iA2 = bj.a(iA, list6.size() / 2);
                                                z5 = true;
                                            }
                                            boolean z7 = iIntValue13 > 0;
                                            List list7 = z7 ? (List) biVar.c.get(iIndexOf4) : (List) biVar.d.get(iIndexOf4);
                                            Iterator it11 = list7.iterator();
                                            while (true) {
                                                if (!it11.hasNext()) {
                                                    iIndexOf = -1;
                                                    break;
                                                }
                                                Map.Entry entry2 = (Map.Entry) it11.next();
                                                int i76 = i74;
                                                if (((Integer) entry2.getValue()).intValue() == i76) {
                                                    iIndexOf = list7.indexOf(entry2);
                                                    break;
                                                }
                                                i74 = i76;
                                            }
                                            int i77 = iIndexOf % 2;
                                            int iIntValue15 = ((z7 || iIndexOf <= 0) && (!z7 || iIndexOf >= list7.size() - 1)) ? -1 : ((Integer) ((Map.Entry) list7.get(z7 ? iIndexOf + 1 : iIndexOf - 1)).getKey()).intValue();
                                            int iIntValue16 = ((z7 || iIndexOf >= list7.size() - 1) && (!z7 || iIndexOf <= 0)) ? -1 : ((Integer) ((Map.Entry) list7.get(z7 ? iIndexOf - 1 : iIndexOf + 1)).getKey()).intValue();
                                            if (!z7) {
                                                if (i77 == 0) {
                                                    iA = iIntValue16;
                                                }
                                                int i78 = iA + iA;
                                                Integer num4 = (Integer) list6.get(i78);
                                                num4.intValue();
                                                int i79 = i78 + 1;
                                                Integer num5 = (Integer) list6.get(i79);
                                                num5.intValue();
                                                arrayList7.add(num4);
                                                arrayList7.add(num5);
                                                i70 += 2;
                                                list6.set(i78, Integer.valueOf(bj.c));
                                                list6.set(i79, Integer.valueOf(bj.c));
                                                z6 = true;
                                            } else if (i77 != 0) {
                                                iIntValue15 = iIntValue16;
                                            }
                                            iA = iIntValue15;
                                            int i710 = iA + iA;
                                            Integer num6 = (Integer) list6.get(i710);
                                            num6.intValue();
                                            int i711 = i710 + 1;
                                            Integer num7 = (Integer) list6.get(i711);
                                            num7.intValue();
                                            arrayList7.add(num6);
                                            arrayList7.add(num7);
                                            i70 += 2;
                                            list6.set(i710, Integer.valueOf(bj.c));
                                            list6.set(i711, Integer.valueOf(bj.c));
                                            z6 = true;
                                        } else {
                                            i70 = i75;
                                            z6 = false;
                                        }
                                        iA = bj.a(iA, list6.size() / 2);
                                    }
                                    arrayList5 = arrayList8;
                                }
                            }
                            it2 = it10;
                            arrayList2 = arrayList5;
                            if (arrayList7.size() >= 3) {
                                arrayList2.add(arrayList7);
                            }
                        }
                        arrayList5 = arrayList2;
                        it10 = it2;
                    }
                    ArrayList arrayList9 = arrayList5;
                    int size6 = arrayList9.size();
                    for (int i80 = 0; i80 < size6; i80++) {
                        List list8 = (List) arrayList9.get(i80);
                        int iIntValue17 = ((Integer) list8.get(list8.size() - 2)).intValue();
                        int iIntValue18 = ((Integer) gs.d(list8)).intValue();
                        Integer num8 = (Integer) list8.get(0);
                        int iIntValue19 = num8.intValue();
                        Integer num9 = (Integer) list8.get(1);
                        int iIntValue20 = num9.intValue();
                        if (iIntValue17 != iIntValue19 || iIntValue18 != iIntValue20) {
                            list8.add(num8);
                            list8.add(num9);
                        }
                    }
                    for (int size7 = arrayList9.size() - 1; size7 >= 0; size7--) {
                        List list9 = (List) arrayList9.get(size7);
                        boolean z8 = true;
                        for (int i81 = 0; i81 < list9.size(); i81++) {
                            if (i81 % 2 == 0) {
                                int iIntValue21 = ((Integer) list9.get(i81)).intValue();
                                int iAbs4 = Math.abs(iIntValue21);
                                int i82 = bj.b;
                                if (iAbs4 == i82) {
                                    list9.set(i81, Integer.valueOf(iIntValue21 == i82 ? bj.a : -bj.a));
                                }
                                if (Math.abs(iIntValue21) != bj.a && Math.abs(iIntValue21) != bj.b) {
                                    z8 = false;
                                }
                            }
                        }
                        if (z8) {
                            arrayList9.remove(size7);
                        }
                    }
                    arrayList = arrayList9;
                }
            }
            if (arrayList != null) {
                Iterator it12 = arrayList.iterator();
                int size8 = 0;
                while (it12.hasNext()) {
                    size8 += ((List) it12.next()).size();
                }
                int[] iArr4 = new int[size8];
                bcVar = this;
                bcVar.b = iArr4;
                bcVar.d = size8 / 2;
                int size9 = 0;
                for (List list10 : arrayList) {
                    for (int i83 = 0; i83 < list10.size(); i83++) {
                        iArr4[i83 + size9] = ((Integer) list10.get(i83)).intValue();
                    }
                    size9 += list10.size();
                }
                ArrayList arrayList10 = new ArrayList(arrayList.size());
                Iterator it13 = arrayList.iterator();
                int size10 = 0;
                while (it13.hasNext()) {
                    size10 += ((List) it13.next()).size() / 2;
                    arrayList10.add(Integer.valueOf(size10));
                }
                nativeTessellator2.a(iArr4, 0, iArr4.length >> 1, arrayList10, z);
                int i84 = bcVar.d;
                int i85 = i84 + i84;
                int[] iArr5 = new int[i85];
                bcVar.e = iArr5;
                System.arraycopy(bcVar.b, 0, iArr5, 0, i85);
                gmVar2 = gmVar;
            } else {
                bcVar = this;
                gmVar2 = gmVar;
                nativeTessellator2.a(bcVar.b, gmVar2.j, bcVar.d, gmVar2.d, z);
            }
            nativeTessellator = nativeTessellator2;
        }
        int iNativeNumSyntheticVertices = nativeTessellator.nativeNumSyntheticVertices(nativeTessellator.nativeTessellatorPtr);
        if (iNativeNumSyntheticVertices > 0) {
            int i86 = iNativeNumSyntheticVertices + iNativeNumSyntheticVertices;
            if (bcVar.a) {
                bcVar.f = new float[bcVar.b.length + i86];
                bcVar.e = NativeTessellator.a;
                float[] fArr2 = bcVar.c;
                float[] fArr3 = bcVar.f;
                int i87 = bcVar.d;
                System.arraycopy(fArr2, 0, fArr3, 0, i87 + i87);
                float[] fArr4 = bcVar.f;
                int i88 = bcVar.d;
                nativeTessellator.nativeAppendSyntheticVerticesFloat(fArr4, i88 + i88, nativeTessellator.nativeTessellatorPtr);
                bcVar.d += iNativeNumSyntheticVertices;
                i19 = 0;
            } else {
                int[] iArr6 = bcVar.b;
                bcVar.e = new int[iArr6.length + i86];
                bcVar.f = NativeTessellator.b;
                int[] iArr7 = bcVar.e;
                int i89 = bcVar.d;
                i19 = 0;
                System.arraycopy(iArr6, 0, iArr7, 0, i89 + i89);
                int[] iArr8 = bcVar.e;
                int i90 = bcVar.d;
                nativeTessellator.nativeAppendSyntheticVertices(iArr8, i90 + i90, nativeTessellator.nativeTessellatorPtr);
                bcVar.d += iNativeNumSyntheticVertices;
            }
        } else {
            i19 = 0;
        }
        com.google.android.libraries.navigation.internal.ael.bq bqVar3 = gmVar2.g;
        bcVar.g = new int[bqVar3.size() + nativeTessellator.nativeNumIndices(nativeTessellator.nativeTessellatorPtr)];
        for (int i91 = i19; i91 < bqVar3.size(); i91++) {
            bcVar.g[i91] = ((Integer) bqVar3.get(i91)).intValue();
        }
        nativeTessellator.nativeAppendIndices(bcVar.g, bqVar3.size(), nativeTessellator.nativeTessellatorPtr);
        nativeTessellator.nativeClear(nativeTessellator.nativeTessellatorPtr);
        synchronized (NativeTessellator.c) {
            NativeTessellator.c.g(nativeTessellator);
        }
    }
}
