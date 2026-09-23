package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import androidx.core.view.MotionEventCompat;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.renderer.dq;
import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.adg.ia;
import com.google.android.libraries.navigation.internal.adg.jl;
import com.google.android.libraries.navigation.internal.adg.jn;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.agg.de;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static void a(jn jnVar, ce ceVar, boolean z, boolean z2, com.google.android.libraries.geo.mapcore.renderer.r rVar, aj ajVar, List list, dq dqVar) {
        boolean z3;
        int i;
        int i2;
        int i3;
        boolean z4;
        float f;
        ArrayList arrayList;
        List list2;
        int i4;
        Iterator it2;
        boolean z5;
        cd cdVar;
        int iC;
        int i5;
        int i6;
        ArrayList arrayList2;
        com.google.android.libraries.navigation.internal.agj.o oVar;
        int i7;
        int iD;
        boolean z6;
        int i8;
        ArrayList arrayList3;
        ce ceVar2 = ceVar;
        aj ajVar2 = ajVar;
        if (jnVar != null) {
            int i9 = 1;
            if (z) {
                z3 = z2;
            } else if (!z2) {
                return;
            } else {
                z3 = true;
            }
            cd cdVar2 = ceVar2.a;
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            e eVar = new e();
            arrayList4.add(new de(6144));
            arrayList5.add(new com.google.android.libraries.navigation.internal.agj.o(2048));
            arrayList6.add(new de(6144));
            arrayList7.add(new com.google.android.libraries.navigation.internal.agj.o(2048));
            Iterator it3 = jnVar.b.iterator();
            while (true) {
                i = cdVar2.a;
                arrayList6 = arrayList6;
                if (!it3.hasNext()) {
                    break;
                }
                jl jlVar = (jl) it3.next();
                int i10 = jlVar.b & i9;
                bh bhVarS = bi.s(bj.ah);
                jlVar.h(bhVarS);
                Object objK = jlVar.w.k(bhVarS.d);
                boolean zBooleanValue = ((Boolean) (objK == null ? bhVarS.b : bhVarS.c(objK))).booleanValue();
                if (i10 == 0 ? z : z3) {
                    ag agVar = new ag(new com.google.android.libraries.geo.mapcore.internal.model.az().d(jlVar).e(), i);
                    if (zBooleanValue) {
                        iC = ajVar2.e.c(agVar);
                        it2 = it3;
                        if (iC == 1) {
                            z5 = z3;
                            ajVar2.j.add(new com.google.android.libraries.geo.mapcore.renderer.s());
                        } else {
                            z5 = z3;
                            if (iC == 3) {
                                com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
                                cdVar = cdVar2;
                                i5 = iC;
                                new ah(ajVar2, "indoor building", 16);
                                ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(PhotoshopDirectory.TAG_LAYER_COMPS)).o();
                            }
                        }
                        cdVar = cdVar2;
                        i5 = iC;
                    } else {
                        it2 = it3;
                        z5 = z3;
                        cdVar = cdVar2;
                        iC = ajVar2.d.c(agVar);
                        if (iC == 1) {
                            ajVar2.i.add(new com.google.android.libraries.geo.mapcore.renderer.s());
                        } else if (iC == 3) {
                            com.google.android.libraries.navigation.internal.zb.j.a aVar2 = com.google.android.libraries.navigation.internal.zb.j.b;
                            i5 = iC;
                            new ah(ajVar2, "building", 16);
                            ((com.google.android.libraries.navigation.internal.zb.h) aVar2.F(PhotoshopDirectory.TAG_PIXEL_ASPECT_RATIO)).o();
                        }
                        i5 = iC;
                    }
                    if (i5 != 3) {
                        ArrayList arrayList8 = true != zBooleanValue ? arrayList5 : arrayList7;
                        ArrayList arrayList9 = true != zBooleanValue ? arrayList4 : arrayList6;
                        int iH = com.google.android.libraries.navigation.internal.nq.a.h(zBooleanValue ? ajVar2.e.a(agVar) : ajVar2.d.a(agVar), 0, (byte) (com.google.android.libraries.geo.mapcore.internal.model.ay.e(i, jlVar.e) * 4.0f), (byte) (com.google.android.libraries.geo.mapcore.internal.model.ay.c(i, jlVar.f) * 4.0f));
                        if (i10 != 0) {
                            ia iaVar = jlVar.d;
                            if (iaVar == null) {
                                iaVar = ia.a;
                            }
                            int i11 = ceVar2.e;
                            int iA = ceVar.a();
                            int i12 = com.google.android.libraries.geo.mapcore.renderer.n.m;
                            if (iaVar == null) {
                                arrayList3 = arrayList7;
                            } else {
                                try {
                                    arrayList3 = arrayList7;
                                    try {
                                        int[] iArrC = com.google.android.libraries.navigation.internal.oe.n.c(iaVar.b, i11, 3, iaVar.c * 3);
                                        int i13 = 256 << iA;
                                        boolean z7 = iA > 6;
                                        int i14 = iA > 6 ? 4 : 3;
                                        for (int i15 = 0; i15 < iArrC.length; i15 += 3) {
                                            int i16 = i15 + 1;
                                            iArrC[i16] = i13 - iArrC[i16];
                                        }
                                        de deVar = (de) arrayList9.get(arrayList9.size() - 1);
                                        com.google.android.libraries.navigation.internal.agj.o oVar2 = (com.google.android.libraries.navigation.internal.agj.o) arrayList8.get(arrayList8.size() - 1);
                                        int iD2 = iaVar.d.d(0);
                                        com.google.android.libraries.navigation.internal.agj.o oVar3 = oVar2;
                                        int iD3 = iaVar.d.d(1);
                                        de deVar2 = deVar;
                                        int iD4 = iD2;
                                        int i17 = 2;
                                        int i18 = 0;
                                        boolean z8 = true;
                                        int iD5 = iaVar.e.size() == 0 ? -123456 : iaVar.e.d(0);
                                        int iD6 = iD3;
                                        while (i17 < iaVar.d.size()) {
                                            de deVar3 = deVar2;
                                            if (deVar2.b / i14 >= 65533) {
                                                de deVar4 = new de(i14 * 2048);
                                                arrayList9.add(deVar4);
                                                com.google.android.libraries.navigation.internal.agj.o oVar4 = new com.google.android.libraries.navigation.internal.agj.o(2048);
                                                arrayList8.add(oVar4);
                                                deVar2 = deVar4;
                                                oVar3 = oVar4;
                                            } else {
                                                deVar2 = deVar3;
                                            }
                                            int i19 = i17 + 1;
                                            i14 = i14;
                                            int iD7 = iaVar.d.d(i17);
                                            if (z8) {
                                                com.google.android.libraries.geo.mapcore.renderer.n.b(iArrC, iD4, iD7, iD6, iH, z7, deVar2, oVar3);
                                            } else {
                                                com.google.android.libraries.geo.mapcore.renderer.n.b(iArrC, iD4, iD6, iD7, iH, z7, deVar2, oVar3);
                                            }
                                            z8 = !z8;
                                            if (i19 == iD5) {
                                                int i20 = i17 + 2;
                                                iD4 = iaVar.d.d(i19);
                                                i17 += 3;
                                                iD6 = iaVar.d.d(i20);
                                                int i21 = i18 + 1;
                                                iD5 = i21 < iaVar.e.size() ? iaVar.e.d(i21) : -123456;
                                                z8 = true;
                                                i18 = i21;
                                            } else {
                                                iD4 = iD6;
                                                i17 = i19;
                                                iD6 = iD7;
                                            }
                                        }
                                    } catch (IOException unused) {
                                    }
                                } catch (IOException unused2) {
                                    arrayList3 = arrayList7;
                                }
                            }
                            if (!zBooleanValue) {
                                int i22 = eVar.a;
                                ia iaVar2 = jlVar.d;
                                if (iaVar2 == null) {
                                    iaVar2 = ia.a;
                                }
                                eVar.a = i22 + iaVar2.c;
                            }
                            ajVar2 = ajVar;
                            it3 = it2;
                            z3 = z5;
                            cdVar2 = cdVar;
                            arrayList7 = arrayList3;
                            arrayList5 = arrayList5;
                        } else {
                            ArrayList arrayList10 = arrayList5;
                            ArrayList arrayList11 = arrayList7;
                            bz bzVar = jlVar.c;
                            int i23 = ceVar2.e;
                            int iA2 = ceVar.a();
                            de deVar5 = (de) arrayList9.get(arrayList9.size() - 1);
                            com.google.android.libraries.navigation.internal.agj.o oVar5 = (com.google.android.libraries.navigation.internal.agj.o) arrayList8.get(arrayList8.size() - 1);
                            int i24 = 256 << iA2;
                            Iterator it4 = bzVar.iterator();
                            while (it4.hasNext()) {
                                com.google.android.libraries.navigation.internal.adg.ce ceVar3 = (com.google.android.libraries.navigation.internal.adg.ce) it4.next();
                                gm gmVar = ceVar3.b;
                                if (gmVar == null) {
                                    gmVar = gm.a;
                                }
                                it4 = it4;
                                int i25 = 1 << iA2;
                                int i26 = (ceVar3.c * i25) / 16;
                                int i27 = (ceVar3.d * i25) / 16;
                                com.google.android.libraries.navigation.internal.agj.o oVar6 = oVar5;
                                try {
                                    com.google.android.libraries.navigation.internal.ael.x xVar = gmVar.c;
                                    int i28 = gmVar.f;
                                    arrayList2 = arrayList4;
                                    try {
                                        int[] iArrC2 = com.google.android.libraries.navigation.internal.oe.n.c(xVar, i23, 2, i28 + i28);
                                        try {
                                            int length = iArrC2.length >> 1;
                                            i6 = i23;
                                            for (int i29 = 0; i29 < iArrC2.length; i29 += 2) {
                                                try {
                                                    int i30 = i29 + 1;
                                                    iArrC2[i30] = i24 - iArrC2[i30];
                                                } catch (IOException unused3) {
                                                }
                                            }
                                            if (length != 0) {
                                                int i31 = iA2 > 6 ? 4 : 3;
                                                i24 = i24;
                                                if ((deVar5.b / i31) + (length * 5) >= 65536) {
                                                    deVar5 = new de(i31 * 2048);
                                                    arrayList9.add(deVar5);
                                                    oVar = new com.google.android.libraries.navigation.internal.agj.o(2048);
                                                    arrayList8.add(oVar);
                                                } else {
                                                    oVar = oVar6;
                                                }
                                                int i32 = deVar5.b / i31;
                                                arrayList9 = arrayList9;
                                                int i33 = iH | MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                                                arrayList8 = arrayList8;
                                                int i34 = 0;
                                                while (i34 < length) {
                                                    int i35 = i34 + i34;
                                                    e eVar2 = eVar;
                                                    int i36 = iArrC2[i35];
                                                    jl jlVar2 = jlVar;
                                                    int i37 = iArrC2[i35 + 1];
                                                    boolean z9 = zBooleanValue;
                                                    if (iA2 > 6) {
                                                        deVar5.c(Float.floatToIntBits(i36));
                                                        deVar5.c(Float.floatToIntBits(i37));
                                                        deVar5.c(Float.floatToIntBits(i27));
                                                    } else {
                                                        deVar5.c((i37 << 16) | ((char) i36));
                                                        deVar5.c(i27);
                                                    }
                                                    deVar5.c(i33);
                                                    i34++;
                                                    eVar = eVar2;
                                                    jlVar = jlVar2;
                                                    zBooleanValue = z9;
                                                }
                                                zBooleanValue = zBooleanValue;
                                                eVar = eVar;
                                                jlVar = jlVar;
                                                if (gmVar.g.size() > 0) {
                                                    int size = gmVar.g.size();
                                                    for (int i38 = 0; i38 < size; i38++) {
                                                        oVar.i((short) (gmVar.g.d(i38) + i32));
                                                    }
                                                } else if ((gmVar.b & 4) != 0) {
                                                    int i39 = gmVar.h;
                                                    int i40 = length - 2;
                                                    for (int i41 = 0; i41 < i40; i41++) {
                                                        int i42 = i39 + i41;
                                                        oVar.i((short) (((i42 + 2) % length) + i32));
                                                        oVar.i((short) (i32 + ((i42 + 1) % length)));
                                                        oVar.i((short) (i32 + i39));
                                                    }
                                                }
                                                if (gmVar.d.size() == 0) {
                                                    iD = -123456;
                                                    i7 = 0;
                                                } else {
                                                    i7 = 0;
                                                    iD = gmVar.d.d(0);
                                                }
                                                int iD8 = gmVar.i.size() == 0 ? -123456 : gmVar.i.d(i7);
                                                float f2 = (float) (-Math.sqrt(0.5d));
                                                int i43 = 0;
                                                int i44 = 0;
                                                int i45 = 0;
                                                int i46 = 0;
                                                while (i43 < length) {
                                                    com.google.android.libraries.navigation.internal.agj.o oVar7 = oVar;
                                                    int i47 = i43 + 1;
                                                    if (iD8 == i43) {
                                                        i44++;
                                                        iD8 = i44 < gmVar.i.size() ? gmVar.i.d(i44) : -123456;
                                                        z6 = false;
                                                    } else {
                                                        z6 = true;
                                                    }
                                                    if (i47 == length || i47 == iD) {
                                                        i45++;
                                                        iD = i45 < gmVar.d.size() ? gmVar.d.d(i45) : -123456;
                                                        i8 = i47;
                                                    } else {
                                                        i8 = i46;
                                                        i46 = i47;
                                                    }
                                                    if (z6) {
                                                        int i48 = deVar5.b / i31;
                                                        int i49 = i43 + i43;
                                                        int i50 = iArrC2[i49];
                                                        int i51 = iArrC2[i49 + 1];
                                                        int i52 = i46 + i46;
                                                        int i53 = iArrC2[i52];
                                                        int i54 = iArrC2[i52 + 1];
                                                        float f3 = i54 - i51;
                                                        float f4 = i53 - i50;
                                                        float fSqrt = (float) Math.sqrt((f4 * f4) + (f3 * f3));
                                                        float fMin = Math.min((Math.abs(((f3 / fSqrt) * f2) + (((-f4) / fSqrt) * (-f2))) * 0.3f) + 0.7f, 1.0f);
                                                        int i55 = (((int) ((0.9f * fMin) * 255.0f)) << 8) | iH;
                                                        int i56 = (((int) (fMin * 255.0f)) << 8) | iH;
                                                        if (iA2 > 6) {
                                                            float f5 = i27;
                                                            float f6 = i53;
                                                            deVar5.c(Float.floatToIntBits(f6));
                                                            float f7 = i54;
                                                            deVar5.c(Float.floatToIntBits(f7));
                                                            float f8 = i26;
                                                            deVar5.c(Float.floatToIntBits(f8));
                                                            deVar5.c(i55);
                                                            deVar5.c(Float.floatToIntBits(f6));
                                                            deVar5.c(Float.floatToIntBits(f7));
                                                            deVar5.c(Float.floatToIntBits(f5));
                                                            deVar5.c(i56);
                                                            float f9 = i50;
                                                            deVar5.c(Float.floatToIntBits(f9));
                                                            float f10 = i51;
                                                            deVar5.c(Float.floatToIntBits(f10));
                                                            deVar5.c(Float.floatToIntBits(f8));
                                                            deVar5.c(i55);
                                                            deVar5.c(Float.floatToIntBits(f9));
                                                            deVar5.c(Float.floatToIntBits(f10));
                                                            deVar5.c(Float.floatToIntBits(f5));
                                                            deVar5.c(i56);
                                                        } else {
                                                            int i57 = ((char) i53) | (i54 << 16);
                                                            deVar5.c(i57);
                                                            deVar5.c(i26);
                                                            deVar5.c(i55);
                                                            deVar5.c(i57);
                                                            deVar5.c(i27);
                                                            deVar5.c(i56);
                                                            int i58 = ((char) i50) | (i51 << 16);
                                                            deVar5.c(i58);
                                                            deVar5.c(i26);
                                                            deVar5.c(i55);
                                                            deVar5.c(i58);
                                                            deVar5.c(i27);
                                                            deVar5.c(i56);
                                                        }
                                                        oVar = oVar7;
                                                        oVar.i((short) (i48 + 1));
                                                        short s = (short) i48;
                                                        oVar.i(s);
                                                        short s2 = (short) (i48 + 3);
                                                        oVar.i(s2);
                                                        oVar.i(s2);
                                                        oVar.i(s);
                                                        oVar.i((short) (i48 + 2));
                                                    } else {
                                                        oVar = oVar7;
                                                    }
                                                    i43 = i47;
                                                    iD = iD;
                                                    i46 = i8;
                                                    iD8 = iD8;
                                                    i31 = i31;
                                                    i44 = i44;
                                                    length = length;
                                                    iArrC2 = iArrC2;
                                                    gmVar = gmVar;
                                                    i45 = i45;
                                                }
                                                oVar5 = oVar;
                                            } else {
                                                oVar5 = oVar6;
                                            }
                                        } catch (IOException unused4) {
                                            i6 = i23;
                                        }
                                    } catch (IOException unused5) {
                                        arrayList9 = arrayList9;
                                        i6 = i23;
                                        zBooleanValue = zBooleanValue;
                                        arrayList8 = arrayList8;
                                        eVar = eVar;
                                        jlVar = jlVar;
                                    }
                                } catch (IOException unused6) {
                                    arrayList9 = arrayList9;
                                    i6 = i23;
                                    arrayList2 = arrayList4;
                                }
                                arrayList4 = arrayList2;
                                i23 = i6;
                                i24 = i24;
                                arrayList9 = arrayList9;
                                arrayList8 = arrayList8;
                                eVar = eVar;
                                jlVar = jlVar;
                                zBooleanValue = zBooleanValue;
                            }
                            e eVar3 = eVar;
                            jl jlVar3 = jlVar;
                            ArrayList arrayList12 = arrayList4;
                            if (!zBooleanValue) {
                                for (com.google.android.libraries.navigation.internal.adg.ce ceVar4 : jlVar3.c) {
                                    e eVar4 = eVar3;
                                    int i59 = eVar4.a;
                                    gm gmVar2 = ceVar4.b;
                                    if (gmVar2 == null) {
                                        gmVar2 = gm.a;
                                    }
                                    eVar4.a = i59 + gmVar2.f;
                                    eVar3 = eVar4;
                                }
                            }
                            ceVar2 = ceVar;
                            ajVar2 = ajVar;
                            it3 = it2;
                            z3 = z5;
                            cdVar2 = cdVar;
                            arrayList4 = arrayList12;
                            arrayList7 = arrayList11;
                            arrayList5 = arrayList10;
                            eVar = eVar3;
                        }
                    } else {
                        ceVar2 = ceVar;
                        ajVar2 = ajVar;
                        it3 = it2;
                        z3 = z5;
                        cdVar2 = cdVar;
                    }
                }
                i9 = 1;
            }
            e eVar5 = eVar;
            ArrayList arrayList13 = arrayList4;
            ArrayList arrayList14 = arrayList5;
            ArrayList arrayList15 = arrayList7;
            int size2 = arrayList13.size();
            for (int i60 = 0; i60 < size2; i60++) {
                eVar5.b += ((de) arrayList13.get(i60)).b;
            }
            int size3 = arrayList14.size();
            for (int i61 = 0; i61 < size3; i61++) {
                eVar5.c += ((com.google.android.libraries.navigation.internal.agj.o) arrayList14.get(i61)).b;
            }
            cd cdVar3 = ceVar.a;
            int iA3 = ceVar.a();
            int i62 = 1 << iA3;
            int i63 = com.google.android.libraries.geo.mapcore.renderer.n.m;
            int size4 = arrayList13.size();
            int i64 = 0;
            while (true) {
                i2 = cdVar3.c;
                i3 = cdVar3.b;
                float f11 = i62;
                z4 = iA3 > 6;
                f = 16.0f / f11;
                if (i64 >= size4) {
                    arrayList = arrayList6;
                    list2 = list;
                    i4 = 0;
                    break;
                }
                boolean zIsEmpty = ((de) arrayList13.get(i64)).isEmpty();
                i64++;
                if (!zIsEmpty) {
                    i4 = 0;
                    list2 = list;
                    list2.add(new com.google.android.libraries.geo.mapcore.renderer.m(i3, i2, i, f, arrayList13, arrayList14, rVar, false, z4, dqVar));
                    arrayList = arrayList6;
                    break;
                }
            }
            int size5 = arrayList.size();
            int i65 = i4;
            while (i65 < size5) {
                boolean zIsEmpty2 = ((de) arrayList.get(i65)).isEmpty();
                i65++;
                if (!zIsEmpty2) {
                    list2.add(new com.google.android.libraries.geo.mapcore.renderer.m(i3, i2, i, f, arrayList, arrayList15, rVar, true, z4, dqVar));
                    return;
                }
            }
        }
    }
}
