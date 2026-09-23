package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.graphics.Color;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.android.libraries.geo.mapcore.internal.model.bd;
import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.internal.model.bv;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.internal.model.cj;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.renderer.DefaultShaderState;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.ch;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.geo.mapcore.renderer.fg;
import com.google.android.libraries.navigation.internal.adg.bc;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fa;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements g {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.d");
    private static final ArrayDeque c = new ArrayDeque();
    private int d;
    private final List e = new ArrayList();
    private final List f = new ArrayList();

    private d() {
    }

    public static com.google.android.libraries.navigation.internal.gz.e c() {
        ArrayDeque arrayDeque = c;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new com.google.android.libraries.navigation.internal.gz.e(1024);
            }
            return (com.google.android.libraries.navigation.internal.gz.e) arrayDeque.pop();
        }
    }

    public static void d(com.google.android.libraries.navigation.internal.gz.e eVar) {
        eVar.a = 0;
        ArrayDeque arrayDeque = c;
        synchronized (arrayDeque) {
            arrayDeque.push(eVar);
        }
    }

    public static boolean e(com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, m mVar) {
        boolean z = mVar == m.AREA_STROKE;
        m mVar2 = m.VOLUME_STROKE;
        if (!z && mVar != mVar2) {
            return false;
        }
        boolean z2 = z ? aiVar.e : aiVar.g;
        bs[] bsVarArr = z ? aiVar.f58n : aiVar.p;
        if (!z2 && (bsVarArr.length) != 0) {
            for (bs bsVar : bsVarArr) {
                if (bsVar.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f(com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, m mVar) {
        bs[] bsVarArr = mVar == m.AREA_STROKE ? aiVar.f58n : aiVar.p;
        int length = bsVarArr.length;
        if (length == 0) {
            return false;
        }
        if (length > 1) {
            return true;
        }
        for (int i = 0; i <= 0; i++) {
            bs bsVar = bsVarArr[i];
            if (bsVar.d * o.a > 1.0f || Color.alpha(bsVar.b) < 255 || bsVar.c()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x02da  */
    /* JADX WARN: Code duplicated, block: B:147:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:148:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:153:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:154:0x0307  */
    /* JADX WARN: Code duplicated, block: B:157:0x0310  */
    /* JADX WARN: Code duplicated, block: B:158:0x0319  */
    /* JADX WARN: Code duplicated, block: B:159:0x031b  */
    /* JADX WARN: Code duplicated, block: B:161:0x0324  */
    /* JADX WARN: Code duplicated, block: B:164:0x033a  */
    /* JADX WARN: Code duplicated, block: B:165:0x033e  */
    /* JADX WARN: Code duplicated, block: B:167:0x0343 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:168:0x0345  */
    /* JADX WARN: Code duplicated, block: B:169:0x0356  */
    /* JADX WARN: Code duplicated, block: B:172:0x036a  */
    /* JADX WARN: Code duplicated, block: B:174:0x0376  */
    /* JADX WARN: Code duplicated, block: B:175:0x037f  */
    /* JADX WARN: Code duplicated, block: B:176:0x0381  */
    /* JADX WARN: Code duplicated, block: B:178:0x0388  */
    /* JADX WARN: Code duplicated, block: B:180:0x0393  */
    /* JADX WARN: Code duplicated, block: B:181:0x0399  */
    /* JADX WARN: Code duplicated, block: B:182:0x039f  */
    /* JADX WARN: Code duplicated, block: B:183:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:186:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:195:0x03db  */
    /* JADX WARN: Code duplicated, block: B:197:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:198:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:201:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:203:0x0413  */
    /* JADX WARN: Code duplicated, block: B:204:0x043f  */
    /* JADX WARN: Code duplicated, block: B:209:0x046d  */
    /* JADX WARN: Code duplicated, block: B:210:0x0473  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    /* JADX WARN: Code duplicated, block: B:311:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:323:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x0479 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0095  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d A[LOOP:8: B:37:0x0093->B:40:0x009d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b0 A[LOOP:2: B:42:0x00a4->B:46:0x00b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x010a  */
    /* JADX WARN: Code duplicated, block: B:73:0x011a  */
    /* JADX WARN: Code duplicated, block: B:75:0x011e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Code duplicated, block: B:78:0x0141  */
    /* JADX WARN: Code duplicated, block: B:81:0x014f  */
    /* JADX WARN: Code duplicated, block: B:83:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x015d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0168  */
    /* JADX WARN: Code duplicated, block: B:91:0x0180  */
    /* JADX WARN: Code duplicated, block: B:93:0x0183  */
    /* JADX WARN: Code duplicated, block: B:96:0x018a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    public static d g(ce ceVar, ba baVar, bq bqVar, cp cpVar, h hVar, com.google.android.libraries.navigation.internal.ps.q qVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, ef efVar, GmmConfigurableTextureStyleIdShaderState gmmConfigurableTextureStyleIdShaderState, aj ajVar, List list, boolean z, Map map, com.google.android.libraries.navigation.internal.oz.f fVar, boolean z2, List list2) {
        cd cdVar;
        af afVar2;
        ey eyVar;
        ba baVar2;
        cd cdVar2;
        List list3;
        com.google.android.libraries.navigation.internal.gz.e eVar;
        com.google.android.libraries.navigation.internal.gz.e eVar2;
        boolean z3;
        com.google.android.libraries.navigation.internal.qq.an anVar;
        int i;
        ?? r2;
        ArrayList arrayList;
        ez ezVar;
        cd cdVar3;
        br brVar;
        boolean z4;
        com.google.android.libraries.navigation.internal.gz.e eVar3;
        com.google.android.libraries.navigation.internal.gz.e eVar4;
        int i2;
        boolean z5;
        ae aeVar;
        bt btVarC;
        int iA;
        boolean z6;
        byte b2;
        byte b3;
        boolean z7;
        com.google.android.libraries.navigation.internal.gz.e eVar5;
        int iH;
        int iA2;
        int[] iArr;
        int[] iArr2;
        int i3;
        Iterator it2;
        int[] iArr3;
        int iE;
        com.google.android.libraries.navigation.internal.gz.e eVar6;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        bt btVarB;
        ae aeVar2;
        int iH2;
        com.google.android.libraries.navigation.internal.qh.a aVar;
        com.google.android.libraries.navigation.internal.qh.a aVar2;
        com.google.android.libraries.navigation.internal.qh.a aVar3;
        com.google.android.libraries.navigation.internal.oe.j jVar;
        boolean z8;
        boolean z9;
        bt btVarD;
        com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr;
        int length;
        boolean z10;
        int i12;
        int i13;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar;
        com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr2;
        bs[] bsVarArr;
        int length2;
        int i14;
        com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr3;
        int length3;
        int i15;
        boolean z11;
        boolean z12;
        com.google.android.libraries.navigation.internal.pt.d dVar;
        af afVar3;
        boolean z13;
        boolean z14;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF;
        com.google.android.libraries.navigation.internal.pt.d dVar2;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG;
        com.google.android.libraries.navigation.internal.oe.j jVar2;
        ceVar = ceVar;
        fVar = fVar;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        af afVar4 = z2 ? new af() : null;
        br brVar2 = null;
        boolean z15 = false;
        boolean z16 = false;
        while (true) {
            cdVar = ceVar.a;
            af afVar5 = afVar4;
            if (cpVar.hasNext()) {
                br brVarB = cpVar.b();
                if (brVarB instanceof com.google.android.libraries.geo.mapcore.internal.model.g) {
                    com.google.android.libraries.geo.mapcore.internal.model.g gVar = (com.google.android.libraries.geo.mapcore.internal.model.g) brVarB;
                    ez eyVar2 = new com.google.android.libraries.navigation.internal.agg.ey();
                    if (z && fVar != null && (jVar2 = gVar.f) != null) {
                        eyVar2 = fVar.a(jVar2.c);
                    }
                    ez ezVar2 = eyVar2;
                    if (brVar2 == null) {
                        brVar2 = brVarB;
                    } else {
                        if (!ac.G(brVar2, brVarB, ajVar.a)) {
                            if (!z15) {
                                z8 = false;
                            }
                        }
                        z9 = z8;
                        btVarD = ajVar.a.d(brVarB.l(), ezVar2);
                        aiVarArr = btVarD.c;
                        length = aiVarArr.length;
                        z10 = z15;
                        i12 = 0;
                        while (true) {
                            if (i12 < length) {
                                i13 = length;
                                aiVar = aiVarArr[i12];
                                aiVarArr2 = aiVarArr;
                                if (aiVar.d || (Color.alpha(aiVar.j) <= 0 && !aiVar.h())) {
                                    if (!aiVar.e) {
                                        bsVarArr = aiVar.f58n;
                                        length2 = bsVarArr.length;
                                        i14 = 0;
                                        while (true) {
                                            if (i14 >= length2) {
                                                continue;
                                            } else if (!bsVarArr[i14].d()) {
                                                i14++;
                                            }
                                        }
                                    }
                                    i12++;
                                    afVar5 = afVar5;
                                    length = i13;
                                    aiVarArr = aiVarArr2;
                                    arrayList2 = arrayList2;
                                    arrayList3 = arrayList3;
                                }
                                aiVarArr3 = btVarD.c;
                                length3 = aiVarArr3.length;
                                i15 = 0;
                                while (true) {
                                    if (i15 < length3) {
                                        z11 = false;
                                        break;
                                    }
                                    if (aiVarArr3[i15].h()) {
                                        z11 = true;
                                        break;
                                    }
                                    i15++;
                                }
                                if (z2 || brVar2 == brVarB || z16 == z11) {
                                    arrayList2.add(gVar);
                                    arrayList3.add(ezVar2);
                                    if (afVar5 != null || z11) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    dVar = cdVar.d;
                                    if (z12) {
                                        arrayList2 = arrayList2;
                                        arrayList3 = arrayList3;
                                        afVar3 = afVar5;
                                        z13 = z11;
                                    } else {
                                        com.google.android.libraries.navigation.internal.yx.ar.q(afVar5);
                                        afVar3 = afVar5;
                                        afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(btVarD, true));
                                        if (gVar.g()) {
                                            aiVarG = btVarD.g(gVar.r);
                                            z13 = z11;
                                            if (e(aiVarG, m.AREA_STROKE) && !f(aiVarG, m.AREA_STROKE)) {
                                                afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(btVarD, false));
                                            }
                                        } else {
                                            z13 = z11;
                                        }
                                        if (dVar == null || gVar.h()) {
                                            if (dVar != null) {
                                                dVar2 = dVar;
                                            } else {
                                                dVar2 = new com.google.android.libraries.navigation.internal.pt.d(new com.google.android.libraries.navigation.internal.oe.i(0L, 0L), 0);
                                            }
                                            afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(aj.b(dVar2), true));
                                        } else {
                                            arrayList2 = arrayList2;
                                            arrayList3 = arrayList3;
                                        }
                                    }
                                    if (gVar.g()) {
                                        aiVarF = ajVar.a.f(brVarB, ezVar2);
                                        if (!gVar.h()) {
                                            if (dVar != null) {
                                                h(hVar, gVar, aiVarF, dVar.b, gVar.r);
                                                z14 = true;
                                                z9 = true;
                                            } else {
                                                z14 = true;
                                            }
                                        } else if (e(aiVarF, m.AREA_STROKE) || !f(aiVarF, m.AREA_STROKE)) {
                                            z14 = true;
                                        } else {
                                            h(hVar, gVar, aiVarF, gVar.f, cdVar.a);
                                            z14 = true;
                                            z9 = true;
                                        }
                                    } else {
                                        z14 = true;
                                    }
                                    if (z14 != z16) {
                                        z16 = z13;
                                    }
                                    cpVar.next();
                                    if (afVar3 != null) {
                                        if (af.a - afVar3.c.size() <= 3) {
                                            afVar2 = afVar3;
                                            break;
                                        }
                                    }
                                    afVar4 = afVar3;
                                    z15 = z9;
                                    arrayList2 = arrayList2;
                                    arrayList3 = arrayList3;
                                }
                            } else {
                                afVar4 = afVar5;
                                cpVar.next();
                                z15 = z10;
                            }
                        }
                    }
                    z8 = z15;
                    z9 = z8;
                    btVarD = ajVar.a.d(brVarB.l(), ezVar2);
                    aiVarArr = btVarD.c;
                    length = aiVarArr.length;
                    z10 = z15;
                    i12 = 0;
                    while (true) {
                        if (i12 < length) {
                            i13 = length;
                            aiVar = aiVarArr[i12];
                            aiVarArr2 = aiVarArr;
                            if (aiVar.d) {
                                if (!aiVar.e) {
                                    bsVarArr = aiVar.f58n;
                                    length2 = bsVarArr.length;
                                    i14 = 0;
                                    while (true) {
                                        if (i14 >= length2) {
                                            continue;
                                        } else if (!bsVarArr[i14].d()) {
                                            i14++;
                                        }
                                    }
                                }
                                i12++;
                                afVar5 = afVar5;
                                length = i13;
                                aiVarArr = aiVarArr2;
                                arrayList2 = arrayList2;
                                arrayList3 = arrayList3;
                            } else {
                                if (!aiVar.e) {
                                    bsVarArr = aiVar.f58n;
                                    length2 = bsVarArr.length;
                                    i14 = 0;
                                    while (true) {
                                        if (i14 >= length2) {
                                            continue;
                                        } else if (!bsVarArr[i14].d()) {
                                            i14++;
                                        }
                                    }
                                }
                                i12++;
                                afVar5 = afVar5;
                                length = i13;
                                aiVarArr = aiVarArr2;
                                arrayList2 = arrayList2;
                                arrayList3 = arrayList3;
                            }
                            aiVarArr3 = btVarD.c;
                            length3 = aiVarArr3.length;
                            i15 = 0;
                            while (true) {
                                if (i15 < length3) {
                                    z11 = false;
                                    break;
                                }
                                if (aiVarArr3[i15].h()) {
                                    z11 = true;
                                    break;
                                }
                                i15++;
                            }
                            if (z2) {
                            }
                            arrayList2.add(gVar);
                            arrayList3.add(ezVar2);
                            if (afVar5 != null) {
                                z12 = true;
                            } else {
                                z12 = true;
                            }
                            dVar = cdVar.d;
                            if (z12) {
                                com.google.android.libraries.navigation.internal.yx.ar.q(afVar5);
                                afVar3 = afVar5;
                                afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(btVarD, true));
                                if (gVar.g()) {
                                    aiVarG = btVarD.g(gVar.r);
                                    z13 = z11;
                                    if (e(aiVarG, m.AREA_STROKE)) {
                                        afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(btVarD, false));
                                    }
                                } else {
                                    z13 = z11;
                                }
                                if (dVar == null) {
                                    if (dVar != null) {
                                        dVar2 = dVar;
                                    } else {
                                        dVar2 = new com.google.android.libraries.navigation.internal.pt.d(new com.google.android.libraries.navigation.internal.oe.i(0L, 0L), 0);
                                    }
                                    afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(aj.b(dVar2), true));
                                } else {
                                    if (dVar != null) {
                                        dVar2 = dVar;
                                    } else {
                                        dVar2 = new com.google.android.libraries.navigation.internal.pt.d(new com.google.android.libraries.navigation.internal.oe.i(0L, 0L), 0);
                                    }
                                    afVar3.c(new com.google.android.libraries.navigation.internal.qh.a(aj.b(dVar2), true));
                                }
                            } else {
                                arrayList2 = arrayList2;
                                arrayList3 = arrayList3;
                                afVar3 = afVar5;
                                z13 = z11;
                            }
                            if (gVar.g()) {
                                aiVarF = ajVar.a.f(brVarB, ezVar2);
                                if (!gVar.h()) {
                                    if (e(aiVarF, m.AREA_STROKE)) {
                                    }
                                    z14 = true;
                                } else if (dVar != null) {
                                    h(hVar, gVar, aiVarF, dVar.b, gVar.r);
                                    z14 = true;
                                    z9 = true;
                                } else {
                                    z14 = true;
                                }
                            } else {
                                z14 = true;
                            }
                            if (z14 != z16) {
                                z16 = z13;
                            }
                            cpVar.next();
                            if (afVar3 != null) {
                                if (af.a - afVar3.c.size() <= 3) {
                                    afVar2 = afVar3;
                                    break;
                                }
                            }
                            afVar4 = afVar3;
                            z15 = z9;
                            arrayList2 = arrayList2;
                            arrayList3 = arrayList3;
                        } else {
                            afVar4 = afVar5;
                            cpVar.next();
                            z15 = z10;
                        }
                    }
                }
            }
            arrayList2 = arrayList2;
            arrayList3 = arrayList3;
            afVar2 = afVar5;
            break;
        }
        com.google.android.libraries.navigation.internal.gz.e eVarC = c();
        com.google.android.libraries.navigation.internal.gz.e eVarC2 = c();
        com.google.android.libraries.navigation.internal.gz.e eVarC3 = c();
        d dVar3 = new d();
        int i16 = 0;
        boolean zBooleanValue = false;
        while (i16 < arrayList2.size()) {
            arrayList2 = arrayList2;
            com.google.android.libraries.geo.mapcore.internal.model.g gVar2 = (com.google.android.libraries.geo.mapcore.internal.model.g) arrayList2.get(i16);
            boolean zH = gVar2.h();
            fa faVar = fd.a;
            if (arrayList2.size() != arrayList3.size()) {
                ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1045)).p("areas and areaTransformTag sets should be the same size.");
                ezVar = faVar;
                arrayList = arrayList3;
            } else {
                arrayList = arrayList3;
                ezVar = (ez) arrayList.get(i16);
            }
            af afVar6 = true != z16 ? afVar2 : null;
            if (gVar2.e().booleanValue()) {
                dVar3.f.add(gVar2);
            }
            bc bcVar = gVar2.p;
            arrayList3 = arrayList;
            if (bcVar != null) {
                list2.add(bcVar);
            }
            cj cjVar = gVar2.g;
            if (cjVar.d() == 0) {
                eVar5 = eVarC2;
                i2 = i16;
                z7 = zBooleanValue;
                brVar = brVar2;
                z4 = z16;
                cdVar3 = cdVar;
            } else {
                float f = gVar2.a * 4.0f;
                cdVar3 = cdVar;
                brVar = brVar2;
                int i17 = (int) (gVar2.b * 4.0f);
                int i18 = (int) f;
                com.google.android.libraries.navigation.internal.pt.d dVar4 = gVar2.h() ? ceVar.a.d : null;
                com.google.android.libraries.geo.mapcore.internal.model.ba baVar3 = gVar2.q;
                z4 = z16;
                if (z) {
                    com.google.android.libraries.navigation.internal.qh.c cVar = ajVar.a;
                    i2 = i16;
                    bv bvVar = cVar.b;
                    bd bdVar = cVar.c;
                    eVar3 = eVarC2;
                    eVar4 = eVarC3;
                    long j = baVar3.c;
                    if (j != -1 && bvVar != null && bdVar != null) {
                        long jA = bdVar.a.a(j, ezVar);
                        z5 = zBooleanValue;
                        if (jA != baVar3.c) {
                            baVar3 = new com.google.android.libraries.geo.mapcore.internal.model.ba(jA, -1, 0);
                        }
                    }
                    aeVar = new ae(baVar3, gVar2.r, null);
                    btVarC = ajVar.a.c(baVar3);
                    if (!z && (jVar = gVar2.f) != null) {
                        map.put(Long.valueOf(jVar.c), ezVar);
                    }
                    iA = ceVar.a();
                    if (iA > 6) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    b2 = (byte) i17;
                    b3 = (byte) i18;
                    if (afVar6 != null) {
                        aVar2 = new com.google.android.libraries.navigation.internal.qh.a(btVarC, true);
                        z7 = z5;
                        aVar3 = new com.google.android.libraries.navigation.internal.qh.a(btVarC, false);
                        if (afVar6.b(aVar2)) {
                            iA2 = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar2), b3, b2);
                        } else {
                            long j2 = btVarC.b;
                            iA2 = 0;
                        }
                        if (afVar6.b(aVar3)) {
                            iH = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar3), b3, b2);
                        } else {
                            iH = 0;
                        }
                    } else {
                        z7 = z5;
                        if (ajVar.f(aeVar) != 3) {
                            byte bA = ajVar.a(aeVar);
                            int iH3 = com.google.android.libraries.navigation.internal.nq.a.h(bA, 0, b3, b2);
                            iH = com.google.android.libraries.navigation.internal.nq.a.h(bA, 1, b3, b2);
                            iA2 = iH3;
                        } else {
                            eVar5 = eVar3;
                            eVarC3 = eVar4;
                        }
                        zBooleanValue = z7 | gVar2.e().booleanValue();
                        i16 = i2 + 1;
                        brVar2 = brVar;
                        eVarC2 = eVar5;
                        z16 = z4;
                        afVar2 = afVar2;
                        cdVar = cdVar3;
                    }
                    iArr = cjVar.c;
                    iArr2 = cjVar.f;
                    if (iArr2 != null) {
                        i(iArr, iArr2, iA2, z6, eVarC);
                    } else {
                        j(iArr, iA2, z6, eVarC);
                    }
                    if (zH) {
                        if (dVar4 == null) {
                            dVar4 = new com.google.android.libraries.navigation.internal.pt.d(new com.google.android.libraries.navigation.internal.oe.i(0L, 0L), 0);
                        }
                        com.google.android.libraries.geo.mapcore.internal.model.ba baVar4 = gVar2.q;
                        int i19 = gVar2.r;
                        btVarB = aj.b(dVar4);
                        i3 = iA;
                        aeVar2 = new ae(baVar4, i19, dVar4);
                        if (afVar6 != null) {
                            aVar = new com.google.android.libraries.navigation.internal.qh.a(btVarB, true);
                            if (afVar6.b(aVar)) {
                                iH2 = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar), b3, b2);
                            } else {
                                iH2 = 0;
                            }
                        } else if (ajVar.f(aeVar2) != 3) {
                            iH2 = com.google.android.libraries.navigation.internal.nq.a.h(ajVar.a(aeVar2), 0, b3, b2);
                        } else {
                            eVarC3 = eVar4;
                            eVar5 = eVar3;
                        }
                        if (iArr2 != null) {
                            eVarC3 = eVar4;
                            i(iArr, iArr2, iH2, z6, eVarC3);
                        } else {
                            eVarC3 = eVar4;
                            j(iArr, iH2, z6, eVarC3);
                        }
                    } else {
                        iH = iH;
                        i3 = iA;
                        eVarC3 = eVar4;
                    }
                    if (gVar2.g()) {
                        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF2 = ajVar.a.f(gVar2, ezVar);
                        if (!gVar2.h() && e(aiVarF2, m.AREA_STROKE) && !f(aiVarF2, m.AREA_STROKE)) {
                            it2 = gVar2.f().iterator();
                            while (it2.hasNext()) {
                                com.google.android.libraries.navigation.internal.oe.ad adVar = (com.google.android.libraries.navigation.internal.oe.ad) it2.next();
                                iArr3 = adVar.b;
                                iE = adVar.e() - 1;
                                eVar6 = eVar3;
                                int i20 = eVar6.a;
                                i4 = i3;
                                if (i4 > 6) {
                                    i5 = 3;
                                } else {
                                    i5 = 2;
                                }
                                eVar6.b(i20 + ((iE + iE) * i5));
                                i6 = 0;
                                while (i6 < iE) {
                                    int i21 = i6 + i6;
                                    i7 = iArr3[i21];
                                    i8 = iArr3[i21 + 1];
                                    i9 = iArr3[i21 + 2];
                                    i10 = iArr3[i21 + 3];
                                    if (z6) {
                                        eVar6.a(Float.floatToIntBits(i7));
                                        eVar6.a(Float.floatToIntBits(i8));
                                        int i22 = iH;
                                        eVar6.a(i22);
                                        eVar6.a(Float.floatToIntBits(i9));
                                        eVar6.a(Float.floatToIntBits(i10));
                                        eVar6.a(i22);
                                        i11 = i22;
                                    } else {
                                        i11 = iH;
                                        eVar6.a(((char) i7) | (i8 << 16));
                                        eVar6.a(i11);
                                        eVar6.a(((char) i9) | (i10 << 16));
                                        eVar6.a(i11);
                                    }
                                    i6++;
                                    iH = i11;
                                    it2 = it2;
                                }
                                eVar3 = eVar6;
                                i3 = i4;
                            }
                        }
                    }
                    eVar5 = eVar3;
                    if (zH) {
                        dVar3.e.add(gVar2);
                    }
                    zBooleanValue = z7 | gVar2.e().booleanValue();
                    i16 = i2 + 1;
                    brVar2 = brVar;
                    eVarC2 = eVar5;
                    z16 = z4;
                    afVar2 = afVar2;
                    cdVar = cdVar3;
                } else {
                    eVar3 = eVarC2;
                    eVar4 = eVarC3;
                    i2 = i16;
                }
                z5 = zBooleanValue;
                aeVar = new ae(baVar3, gVar2.r, null);
                btVarC = ajVar.a.c(baVar3);
                if (!z) {
                }
                iA = ceVar.a();
                if (iA > 6) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                b2 = (byte) i17;
                b3 = (byte) i18;
                if (afVar6 != null) {
                    aVar2 = new com.google.android.libraries.navigation.internal.qh.a(btVarC, true);
                    z7 = z5;
                    aVar3 = new com.google.android.libraries.navigation.internal.qh.a(btVarC, false);
                    if (afVar6.b(aVar2)) {
                        iA2 = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar2), b3, b2);
                    } else {
                        long j3 = btVarC.b;
                        iA2 = 0;
                    }
                    if (afVar6.b(aVar3)) {
                        iH = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar3), b3, b2);
                    } else {
                        iH = 0;
                    }
                } else {
                    z7 = z5;
                    if (ajVar.f(aeVar) != 3) {
                        byte bA2 = ajVar.a(aeVar);
                        int iH4 = com.google.android.libraries.navigation.internal.nq.a.h(bA2, 0, b3, b2);
                        iH = com.google.android.libraries.navigation.internal.nq.a.h(bA2, 1, b3, b2);
                        iA2 = iH4;
                    } else {
                        eVar5 = eVar3;
                        eVarC3 = eVar4;
                    }
                    zBooleanValue = z7 | gVar2.e().booleanValue();
                    i16 = i2 + 1;
                    brVar2 = brVar;
                    eVarC2 = eVar5;
                    z16 = z4;
                    afVar2 = afVar2;
                    cdVar = cdVar3;
                }
                iArr = cjVar.c;
                iArr2 = cjVar.f;
                if (iArr2 != null) {
                    i(iArr, iArr2, iA2, z6, eVarC);
                } else {
                    j(iArr, iA2, z6, eVarC);
                }
                if (zH) {
                    if (dVar4 == null) {
                        dVar4 = new com.google.android.libraries.navigation.internal.pt.d(new com.google.android.libraries.navigation.internal.oe.i(0L, 0L), 0);
                    }
                    com.google.android.libraries.geo.mapcore.internal.model.ba baVar5 = gVar2.q;
                    int i110 = gVar2.r;
                    btVarB = aj.b(dVar4);
                    i3 = iA;
                    aeVar2 = new ae(baVar5, i110, dVar4);
                    if (afVar6 != null) {
                        aVar = new com.google.android.libraries.navigation.internal.qh.a(btVarB, true);
                        if (afVar6.b(aVar)) {
                            iH2 = com.google.android.libraries.navigation.internal.qh.a.a(afVar6.a(aVar), b3, b2);
                        } else {
                            iH2 = 0;
                        }
                    } else if (ajVar.f(aeVar2) != 3) {
                        iH2 = com.google.android.libraries.navigation.internal.nq.a.h(ajVar.a(aeVar2), 0, b3, b2);
                    } else {
                        eVarC3 = eVar4;
                        eVar5 = eVar3;
                    }
                    if (iArr2 != null) {
                        eVarC3 = eVar4;
                        i(iArr, iArr2, iH2, z6, eVarC3);
                    } else {
                        eVarC3 = eVar4;
                        j(iArr, iH2, z6, eVarC3);
                    }
                } else {
                    iH = iH;
                    i3 = iA;
                    eVarC3 = eVar4;
                }
                if (gVar2.g()) {
                    com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF3 = ajVar.a.f(gVar2, ezVar);
                    if (!gVar2.h()) {
                        it2 = gVar2.f().iterator();
                        while (it2.hasNext()) {
                            com.google.android.libraries.navigation.internal.oe.ad adVar2 = (com.google.android.libraries.navigation.internal.oe.ad) it2.next();
                            iArr3 = adVar2.b;
                            iE = adVar2.e() - 1;
                            eVar6 = eVar3;
                            int i23 = eVar6.a;
                            i4 = i3;
                            if (i4 > 6) {
                                i5 = 3;
                            } else {
                                i5 = 2;
                            }
                            eVar6.b(i23 + ((iE + iE) * i5));
                            i6 = 0;
                            while (i6 < iE) {
                                int i24 = i6 + i6;
                                i7 = iArr3[i24];
                                i8 = iArr3[i24 + 1];
                                i9 = iArr3[i24 + 2];
                                i10 = iArr3[i24 + 3];
                                if (z6) {
                                    eVar6.a(Float.floatToIntBits(i7));
                                    eVar6.a(Float.floatToIntBits(i8));
                                    int i25 = iH;
                                    eVar6.a(i25);
                                    eVar6.a(Float.floatToIntBits(i9));
                                    eVar6.a(Float.floatToIntBits(i10));
                                    eVar6.a(i25);
                                    i11 = i25;
                                } else {
                                    i11 = iH;
                                    eVar6.a(((char) i7) | (i8 << 16));
                                    eVar6.a(i11);
                                    eVar6.a(((char) i9) | (i10 << 16));
                                    eVar6.a(i11);
                                }
                                i6++;
                                iH = i11;
                                it2 = it2;
                            }
                            eVar3 = eVar6;
                            i3 = i4;
                        }
                    }
                }
                eVar5 = eVar3;
                if (zH) {
                    dVar3.e.add(gVar2);
                }
                zBooleanValue = z7 | gVar2.e().booleanValue();
                i16 = i2 + 1;
                brVar2 = brVar;
                eVarC2 = eVar5;
                z16 = z4;
                afVar2 = afVar2;
                cdVar = cdVar3;
            }
            zBooleanValue = z7 | gVar2.e().booleanValue();
            i16 = i2 + 1;
            brVar2 = brVar;
            eVarC2 = eVar5;
            z16 = z4;
            afVar2 = afVar2;
            cdVar = cdVar3;
        }
        com.google.android.libraries.navigation.internal.gz.e eVar7 = eVarC2;
        boolean z17 = zBooleanValue;
        af afVar7 = afVar2;
        br brVar3 = brVar2;
        boolean z18 = z16;
        cd cdVar4 = cdVar;
        ef efVar2 = (!z18 || gmmConfigurableTextureStyleIdShaderState == null) ? efVar : gmmConfigurableTextureStyleIdShaderState;
        fg fgVar = brVar3 == null ? new fg(0, 0, 0) : com.google.android.libraries.navigation.internal.qq.an.k(brVar3, ajVar.a.e(brVar3));
        int iA3 = ceVar.a();
        af afVar8 = true == z18 ? null : afVar7;
        if (afVar8 == null || afVar8.c.size() == 0) {
            eyVar = null;
        } else {
            List list4 = afVar8.b;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(list4.size() * 116);
            for (int i26 = 0; i26 < list4.size(); i26++) {
                int[] iArr4 = ((com.google.android.libraries.navigation.internal.qh.a) list4.get(i26)).a;
                for (int i27 = 0; i27 < 29; i27++) {
                    byteBufferAllocate.put((byte) Color.red(iArr4[i27]));
                    byteBufferAllocate.put((byte) Color.green(iArr4[i27]));
                    byteBufferAllocate.put((byte) Color.blue(iArr4[i27]));
                    byteBufferAllocate.put((byte) Color.alpha(iArr4[i27]));
                }
            }
            eyVar = new ey("area_group", new cs(byteBufferAllocate.array(), 4, 29, list4.size(), false), 2, 1);
        }
        int i28 = iA3 <= 6 ? 2 : 3;
        int i29 = iA3 <= 6 ? 2 : 1;
        boolean z19 = qVar == 0;
        if (eVarC.c()) {
            baVar2 = baVar;
            eVarC = eVarC;
            eVarC3 = eVarC3;
            cdVar2 = cdVar4;
            list3 = list;
        } else {
            ff ffVar = new ff("area_fill", eVarC.d(), eVarC.a / i28, i29 | JfifUtil.MARKER_SOFn, 4, i28 * 4, bqVar);
            ffVar.c(true);
            dVar3.d = ffVar.p;
            baVar2 = baVar;
            cdVar2 = cdVar4;
            com.google.android.libraries.navigation.internal.qq.an anVar2 = new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar2, baVar2.b, fgVar, z19);
            if (!z17 || dVar3.f.isEmpty()) {
                r2 = 0;
            } else {
                r2 = 0;
                anVar2.f74n = new com.google.android.libraries.navigation.internal.qq.u(true, false, new com.google.android.libraries.navigation.internal.qq.o(dVar3.f));
            }
            anVar2.w(ffVar);
            anVar2.v(efVar2);
            anVar2.t(770, 771);
            if (eyVar != null) {
                anVar2.B(r2, eyVar);
            }
            list3 = list;
            list3.add(anVar2);
            anVar2.C(r2);
            if (qVar != 0) {
                qVar.a(anVar2);
                anVar2.f(qVar.a);
            }
        }
        if (eVar7.c()) {
            eVar = eVar7;
        } else {
            eVar = eVar7;
            ff ffVar2 = new ff("area_stroke", eVar7.d(), eVar7.a / i28, i29 | JfifUtil.MARKER_SOFn, 1, i28 * 4, bqVar);
            ffVar2.c(true);
            dVar3.d += ffVar2.p;
            com.google.android.libraries.navigation.internal.qq.an anVar3 = new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar2, baVar2.b, fgVar.a(1), z19);
            anVar3.w(ffVar2);
            anVar3.v(efVar2);
            if (eyVar != null) {
                anVar3.B(0, eyVar);
            }
            list3.add(anVar3);
            anVar3.C(false);
            if (qVar != 0) {
                qVar.a(anVar3);
                anVar3.f(qVar.a);
            }
        }
        if (eVarC3.c()) {
            eVar2 = eVarC3;
        } else {
            eVar2 = eVarC3;
            ff ffVar3 = new ff("area_level", eVarC3.d(), eVar2.a / i28, i29 | JfifUtil.MARKER_SOFn, 4, i28 * 4, bqVar);
            ffVar3.c(true);
            dVar3.d = ffVar3.p;
            com.google.android.libraries.navigation.internal.qq.an anVar4 = new com.google.android.libraries.navigation.internal.qq.an(ch.INDOOR_GROUND, cdVar2, baVar2.b, (fg) null, z19);
            anVar4.w(ffVar3);
            anVar4.v(efVar2);
            anVar4.t(770, 771);
            if (eyVar != null) {
                z3 = false;
                anVar4.B(0, eyVar);
            } else {
                z3 = false;
                eyVar = null;
            }
            list3.add(anVar4);
            anVar4.C(z3);
            cd cdVar5 = cdVar2;
            com.google.android.libraries.navigation.internal.pt.d dVar5 = cdVar5.d;
            if (dVar5 != null) {
                com.google.android.libraries.navigation.internal.afm.ac acVar = (com.google.android.libraries.navigation.internal.afm.ac) com.google.android.libraries.navigation.internal.afm.ad.a.q();
                String strF = dVar5.b.f();
                if (!acVar.b.H()) {
                    acVar.v();
                }
                com.google.android.libraries.navigation.internal.afm.ad adVar3 = (com.google.android.libraries.navigation.internal.afm.ad) acVar.b;
                adVar3.b |= 1;
                adVar3.c = strF;
                int i30 = dVar5.c;
                if (i30 != Integer.MIN_VALUE) {
                    if (!acVar.b.H()) {
                        acVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afm.ad adVar4 = (com.google.android.libraries.navigation.internal.afm.ad) acVar.b;
                    i = 2;
                    adVar4.b |= 2;
                    adVar4.d = i30;
                } else {
                    i = 2;
                }
                final com.google.android.libraries.navigation.internal.afm.ad adVar5 = (com.google.android.libraries.navigation.internal.afm.ad) acVar.t();
                anVar = new com.google.android.libraries.navigation.internal.qq.v(afVar, cdVar5, baVar2.b, fgVar.a(i), false, new com.google.android.libraries.navigation.internal.ol.au() { // from class: com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.c
                    @Override // com.google.android.libraries.navigation.internal.ol.au
                    public final cy n() {
                        int i31 = d.a;
                        return adVar5;
                    }
                });
                anVar.f74n = new com.google.android.libraries.navigation.internal.qq.u(false, true, new com.google.android.libraries.navigation.internal.qq.o(dVar3.e));
            } else {
                anVar = new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar5, baVar2.b, fgVar.a(2), false);
            }
            anVar.w(ffVar3);
            anVar.v(new DefaultShaderState());
            anVar.t = 513;
            anVar.t(0, 1);
            if (eyVar != null) {
                anVar.B(0, eyVar);
            }
            list3.add(anVar);
            anVar.C(false);
            if (qVar != 0) {
                qVar.a(anVar);
                anVar.f(qVar.a);
                qVar.b.add(anVar4);
                qVar.e.d(qVar);
                qVar.e.b();
            }
        }
        com.google.android.libraries.navigation.internal.gz.e eVar8 = eVarC;
        if (eVar8.a < 16384) {
            d(eVar8);
        }
        com.google.android.libraries.navigation.internal.gz.e eVar9 = eVar;
        if (eVar9.a < 16384) {
            d(eVar9);
        }
        if (eVar2.a < 16384) {
            d(eVar2);
        }
        return dVar3;
    }

    private static void h(h hVar, com.google.android.libraries.geo.mapcore.internal.model.g gVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, com.google.android.libraries.navigation.internal.oe.j jVar, int i) {
        if (gVar.g.d() == 0 || !gVar.g()) {
            return;
        }
        List listF = gVar.f();
        float f = gVar.a;
        float f2 = gVar.b;
        int i2 = gVar.c;
        int i3 = gVar.d;
        com.google.android.libraries.navigation.internal.oe.ad[] adVarArr = (com.google.android.libraries.navigation.internal.oe.ad[]) listF.toArray(new com.google.android.libraries.navigation.internal.oe.ad[listF.size()]);
        bt btVar = gVar.h;
        com.google.android.libraries.geo.mapcore.internal.model.ba baVar = gVar.q;
        bt btVar2 = bt.a;
        int i4 = com.google.android.libraries.navigation.internal.adg.ff.a;
        int i5 = i4 - 1;
        if (i4 == 0) {
            throw null;
        }
        int i6 = com.google.android.libraries.navigation.internal.adg.ff.a;
        int i7 = i6 - 1;
        if (i6 == 0) {
            throw null;
        }
        int i8 = cz.a;
        int i9 = i8 - 1;
        if (i8 == 0) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.pt.f fVar = gVar.o;
        com.google.android.libraries.navigation.internal.yz.fd fdVar = gVar.m;
        com.google.android.libraries.geo.mapcore.internal.model.ar arVar = new com.google.android.libraries.geo.mapcore.internal.model.ar(f, i2, i3, adVarArr, btVar, btVar2, baVar, i5, i7, i9, 1, null, null, null, fVar, null, gVar.p, false, i);
        if (arVar.d.length > 0) {
            ((ArrayList) gs.d(hVar.a)).add(new j(arVar, aiVar, com.google.android.libraries.navigation.internal.qq.an.k(arVar, aiVar), m.AREA_STROKE));
        }
    }

    private static void i(int[] iArr, int[] iArr2, int i, boolean z, com.google.android.libraries.navigation.internal.gz.e eVar) {
        int i2 = eVar.a;
        int i3 = true != z ? 2 : 3;
        eVar.b(i2 + (i3 * iArr2.length));
        for (int i4 : iArr2) {
            int i5 = i4 + i4;
            int i6 = iArr[i5];
            int i7 = iArr[i5 + 1];
            if (z) {
                eVar.a(Float.floatToIntBits(i6));
                eVar.a(Float.floatToIntBits(i7));
            } else {
                eVar.a((i7 << 16) | ((char) i6));
            }
            eVar.a(i);
        }
    }

    private static void j(int[] iArr, int i, boolean z, com.google.android.libraries.navigation.internal.gz.e eVar) {
        int i2 = eVar.a;
        int i3 = true != z ? 2 : 3;
        int length = iArr.length >> 1;
        eVar.b(i2 + (i3 * length));
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 + i4;
            int i6 = iArr[i5];
            int i7 = iArr[i5 + 1];
            if (z) {
                eVar.a(Float.floatToIntBits(i6));
                eVar.a(Float.floatToIntBits(i7));
            } else {
                eVar.a((i7 << 16) | ((char) i6));
            }
            eVar.a(i);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int b() {
        return NikonType2MakernoteDirectory.TAG_SCENE_ASSIST;
    }
}
