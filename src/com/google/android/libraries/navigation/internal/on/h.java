package com.google.android.libraries.navigation.internal.on;

import com.google.android.libraries.geo.mapcore.internal.model.at;
import com.google.android.libraries.geo.mapcore.internal.model.aw;
import com.google.android.libraries.geo.mapcore.renderer.af;
import com.google.android.libraries.geo.mapcore.renderer.cg;
import com.google.android.libraries.geo.mapcore.renderer.cl;
import com.google.android.libraries.navigation.internal.adg.ap;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.fd;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.gl;
import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bt;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.ol.ak;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.ol.z;
import com.google.android.libraries.navigation.internal.po.Cdo;
import com.google.android.libraries.navigation.internal.po.dq;
import com.google.android.libraries.navigation.internal.po.y;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public final com.google.android.libraries.navigation.internal.ol.a a;
    public final ai b;
    public final ak c;
    public final ax d;

    public h(z zVar) {
        this.a = zVar.a();
        this.b = zVar.b();
        this.c = zVar.d();
        this.d = zVar.e();
    }

    public static double[] a(List list) {
        int size = list.size();
        double[] dArr = new double[size + size];
        for (int i = 0; i < list.size(); i++) {
            x xVar = (x) list.get(i);
            int i2 = i + i;
            dArr[i2] = xVar.b();
            dArr[i2 + 1] = xVar.d();
        }
        return dArr;
    }

    public static fg d(double[] dArr, aq aqVar, int i, int i2, int i3, int i4, int i5) {
        fd fdVarJ = j(dArr, i, i2, i3, i4, i5);
        es esVarE = aqVar.e();
        if (esVarE != null) {
            fdVarJ.C(et.f, esVarE);
        } else if (aqVar.a() != -1) {
            int iA = aqVar.a();
            if (!fdVarJ.b.H()) {
                fdVarJ.v();
            }
            fg fgVar = (fg) fdVarJ.b;
            fg fgVar2 = fg.a;
            fgVar.b |= 256;
            fgVar.m = iA;
        }
        return (fg) fdVarJ.t();
    }

    public static List e(double[] dArr, int[] iArr, Collection collection, Collection collection2, int i, int i2, int i3, int i4, int i5, float f) {
        Iterator it2;
        float fSqrt;
        ar.l(!collection.isEmpty(), "At least one style must be provided.");
        ar.l(iArr.length == collection.size() + (-1), "The number of linebreaks must equal numberOfStyles-1");
        if (!collection2.isEmpty()) {
            ar.l(collection2.size() == collection.size(), "The number of consumed styles must equal number of segment styles");
        }
        ArrayList arrayList = new ArrayList(collection);
        List arrayList2 = new ArrayList(collection2);
        ArrayList arrayList3 = new ArrayList();
        HashSet hashSet = new HashSet();
        com.google.android.libraries.navigation.internal.pp.g gVar = (com.google.android.libraries.navigation.internal.pp.g) arrayList.get(0);
        hashSet.add(gVar);
        for (int i6 = 1; i6 < arrayList.size(); i6++) {
            com.google.android.libraries.navigation.internal.pp.g gVar2 = (com.google.android.libraries.navigation.internal.pp.g) arrayList.get(i6);
            if (!gVar.o(gVar2, false) || (!hashSet.contains(gVar2) && hashSet.size() == 8)) {
                arrayList3.add(Integer.valueOf(i6));
                hashSet.clear();
                gVar = gVar2;
            }
            hashSet.add(gVar2);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        int i7 = 0;
        int i8 = 0;
        double[] dArr2 = null;
        float f2 = f;
        while (it3.hasNext()) {
            int iIntValue = ((Integer) it3.next()).intValue();
            int i9 = iIntValue - 1;
            int i10 = iArr[i9];
            int i11 = i10 + i10;
            int i12 = i7 / 2;
            int i13 = i11 + 2;
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i7, i13);
            arrayList4.add(k(dArrCopyOfRange, i(Arrays.copyOfRange(iArr, i8, i9), -i12), arrayList.subList(i8, iIntValue), !collection2.isEmpty() ? arrayList2.subList(i8, iIntValue) : arrayList2, i, i2, i3, i4, i5, f2, dArr2, new double[]{dArr[i13], dArr[i11 + 3]}));
            int length = dArrCopyOfRange.length;
            if (length < 4 || (length & 1) != 0) {
                it2 = it3;
                fSqrt = 0.0f;
            } else {
                char c = 1;
                int[] iArrR = x.R(dArrCopyOfRange[0], dArrCopyOfRange[1]);
                int i14 = 1;
                fSqrt = 0.0f;
                while (i14 < (dArrCopyOfRange.length >> 1)) {
                    int i15 = i14 + i14;
                    int[] iArrR2 = x.R(dArrCopyOfRange[i15], dArrCopyOfRange[i15 + 1]);
                    int i16 = iArrR[0] - iArrR2[0];
                    float f3 = iArrR[c] - iArrR2[c];
                    float f4 = i16;
                    fSqrt = (float) (((double) fSqrt) + Math.sqrt((f4 * f4) + (f3 * f3)));
                    i14++;
                    iArrR = iArrR2;
                    it3 = it3;
                    c = 1;
                }
                it2 = it3;
            }
            f2 += fSqrt;
            int length2 = dArrCopyOfRange.length;
            dArr2 = new double[]{dArrCopyOfRange[length2 - 4], dArrCopyOfRange[length2 - 3]};
            it3 = it2;
            i7 = i11;
            i8 = iIntValue;
        }
        int i17 = i7 / 2;
        if (!collection2.isEmpty()) {
            arrayList2 = arrayList2.subList(i8, collection.size());
        }
        arrayList4.add(k(Arrays.copyOfRange(dArr, i7, dArr.length), i(Arrays.copyOfRange(iArr, i8, iArr.length), -i17), arrayList.subList(i8, collection.size()), arrayList2, i, i2, i3, i4, i5, f2, dArr2, null));
        return arrayList4;
    }

    private static int[] i(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = iArr[i2] + i;
        }
        return iArr2;
    }

    private static fd j(double[] dArr, int i, int i2, int i3, int i4, int i5) {
        com.google.android.libraries.navigation.internal.ael.x xVarB = k.b(dArr);
        fd fdVar = (fd) fg.a.q();
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar = (fg) fdVar.b;
        fgVar.b |= 1;
        fgVar.c = xVarB;
        int length = dArr.length >> 1;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar2 = (fg) fdVar.b;
        fgVar2.b |= 2;
        fgVar2.d = length;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar3 = (fg) fdVar.b;
        int i6 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        fgVar3.g = i6;
        fgVar3.b |= 4;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar4 = (fg) fdVar.b;
        int i7 = i4 - 1;
        if (i4 == 0) {
            throw null;
        }
        fgVar4.h = i7;
        fgVar4.b |= 8;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar5 = (fg) fdVar.b;
        int i8 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        fgVar5.i = i8;
        fgVar5.b |= 16;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar6 = (fg) fdVar.b;
        fgVar6.b |= 1024;
        fgVar6.o = i;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar7 = (fg) fdVar.b;
        fgVar7.b |= 2048;
        fgVar7.p = i2;
        return fdVar;
    }

    private static fg k(double[] dArr, int[] iArr, Collection collection, Collection collection2, int i, int i2, int i3, int i4, int i5, float f, double[] dArr2, double[] dArr3) {
        int length;
        double[] dArr4;
        int i6 = 0;
        while (true) {
            length = iArr.length;
            boolean z = true;
            if (i6 >= length) {
                break;
            }
            if (iArr[i6] == 0) {
                z = false;
            }
            ar.l(z, "A lineBreak of 0 is implied and should not be present in the list.");
            i6++;
        }
        ar.l(true, "previousVertex should either be null or only contain one latitude, longitude pair");
        ar.l(true, "nextVertex should either be null or only contain one latitude, longitude pair");
        if (length != 0) {
            double[] dArr5 = new double[dArr.length + length + length];
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < dArr.length; i9 += 2) {
                int i10 = i9 + i7;
                dArr5[i10] = dArr[i9];
                int i11 = i9 + 1;
                dArr5[i10 + 1] = dArr[i11];
                if (i8 < iArr.length) {
                    int i12 = i9 / 2;
                    int i13 = iArr[i8];
                    if (i12 == i13) {
                        dArr5[i10 + 2] = dArr[i9];
                        dArr5[i10 + 3] = dArr[i11];
                        iArr[i8] = i13 + (i7 / 2) + 1;
                        i7 += 2;
                        i8++;
                    }
                }
            }
            dArr4 = dArr5;
        } else {
            dArr4 = dArr;
        }
        fd fdVarJ = j(dArr4, i, i2, i3, i4, i5);
        for (int i14 : iArr) {
            if (!fdVarJ.b.H()) {
                fdVarJ.v();
            }
            fg fgVar = (fg) fdVarJ.b;
            fg fgVar2 = fg.a;
            bq bqVar = fgVar.e;
            if (!bqVar.c()) {
                fgVar.e = bi.w(bqVar);
            }
            fgVar.e.i(i14);
        }
        if (gs.g(collection, new as() { // from class: com.google.android.libraries.navigation.internal.on.g
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                return ((aq) obj).e() != null;
            }
        })) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                es esVarE = ((aq) it2.next()).e();
                if (esVarE != null) {
                    fdVarJ.A(et.g, esVarE);
                }
            }
            Iterator it3 = collection2.iterator();
            while (it3.hasNext()) {
                es esVarE2 = ((aq) it3.next()).e();
                if (esVarE2 != null) {
                    fdVarJ.A(et.h, esVarE2);
                }
            }
        } else {
            Iterator it4 = collection.iterator();
            while (it4.hasNext()) {
                long jA = ((aq) it4.next()).a();
                if (!fdVarJ.b.H()) {
                    fdVarJ.v();
                }
                fg fgVar3 = (fg) fdVarJ.b;
                fg fgVar4 = fg.a;
                bt btVar = fgVar3.f;
                if (!btVar.c()) {
                    fgVar3.f = bi.x(btVar);
                }
                fgVar3.f.f(jA);
            }
        }
        fdVarJ.C(com.google.android.libraries.navigation.internal.adl.k.g, Float.valueOf(f));
        if (!fdVarJ.b.H()) {
            fdVarJ.v();
        }
        fg fgVar5 = (fg) fdVarJ.b;
        fg fgVar6 = fg.a;
        fgVar5.b |= 32;
        fgVar5.j = 4;
        if (dArr2 != null) {
            fdVarJ.C(aw.c, k.b(dArr2));
        }
        if (dArr3 != null) {
            fdVarJ.C(aw.d, k.b(dArr3));
        }
        return (fg) fdVarJ.t();
    }

    public final com.google.android.libraries.navigation.internal.ol.j b(double d, double d2, int i, float f, boolean z, aq aqVar, boolean z2, int i2) {
        return c(d, d2, i, f, z, aqVar, z2, i2, 0, 0);
    }

    public final com.google.android.libraries.navigation.internal.ol.j c(double d, double d2, int i, float f, boolean z, aq aqVar, boolean z2, int i2, int i3, int i4) {
        float[] fArr;
        int i5;
        double d3;
        int length;
        int i6 = i;
        ap apVar = (ap) com.google.android.libraries.navigation.internal.adg.aq.a.q();
        gl glVar = (gl) gm.a.q();
        float f2 = 0.0f;
        double d4 = 0.0d;
        if (i6 == 4) {
            fArr = new float[12];
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f;
            fArr[4] = -1.0f;
            fArr[5] = 1.0f;
            fArr[6] = -1.0f;
            fArr[7] = -1.0f;
            fArr[8] = 1.0f;
            fArr[9] = -1.0f;
            fArr[10] = 1.0f;
            fArr[11] = 1.0f;
            float fCos = (float) Math.cos(0.0d);
            float fSin = (float) Math.sin(0.0d);
            for (int i7 = 0; i7 < 11; i7 += 2) {
                float f3 = fArr[i7];
                int i8 = i7 + 1;
                float f4 = fArr[i8];
                fArr[i7] = (f3 * fCos) - (f4 * fSin);
                fArr[i8] = (f4 * fCos) + (f3 * fSin);
            }
            d3 = 0.0d;
        } else {
            int i9 = i6 + 2;
            fArr = new float[i9 + i9];
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            int i10 = 0;
            int i11 = 2;
            while (true) {
                i5 = i11 + 1;
                if (i10 >= i6) {
                    break;
                }
                double d5 = f2;
                fArr[i11] = (float) Math.cos(d5);
                i11 += 2;
                fArr[i5] = (float) Math.sin(d5);
                f2 += (float) (6.283185307179586d / ((double) i6));
                i10++;
                i6 = i;
                d4 = 0.0d;
            }
            d3 = d4;
            fArr[i11] = (float) Math.cos(d3);
            fArr[i5] = (float) Math.sin(d3);
        }
        if (z) {
            int length2 = fArr.length;
            float[] fArr2 = new float[length2];
            float fCos2 = (float) Math.cos(d3);
            float fSin2 = (float) Math.sin(d3);
            for (int i12 = 0; i12 < fArr.length - 1; i12 += 2) {
                float f5 = fArr[i12];
                int i13 = i12 + 1;
                float f6 = fArr[i13];
                fArr2[i12] = (((f5 * fCos2) - (f6 * fSin2)) + 1.0f) * 0.5f;
                fArr2[i13] = 1.0f - ((((f6 * fCos2) + (f5 * fSin2)) + 1.0f) * 0.5f);
            }
            for (int i14 = 0; i14 < length2; i14++) {
                glVar.d(fArr2[i14]);
            }
        }
        float f7 = f * 0.5f;
        int i15 = 0;
        while (true) {
            length = fArr.length;
            if (i15 >= length) {
                break;
            }
            fArr[i15] = fArr[i15] * f7;
            i15++;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length * 4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.asFloatBuffer().put(fArr);
        com.google.android.libraries.navigation.internal.ael.x xVarS = com.google.android.libraries.navigation.internal.ael.x.s(byteBufferAllocate);
        int i16 = length >> 1;
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm gmVar = (gm) glVar.b;
        gmVar.b |= 2;
        gmVar.f = i16;
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm gmVar2 = (gm) glVar.b;
        gmVar2.b |= 1;
        gmVar2.c = xVarS;
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm.e((gm) glVar.b);
        if (z2) {
            glVar.e(0);
            glVar.e(i + 1);
        }
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar2 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        gm gmVar3 = (gm) glVar.t();
        gmVar3.getClass();
        aqVar2.c = gmVar3;
        aqVar2.b |= 1;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar3 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        aqVar3.b |= 4;
        aqVar3.e = z2;
        es esVarE = aqVar.e();
        if (esVarE != null) {
            apVar.C(et.b, esVarE);
        } else if (aqVar.a() != -1) {
            int iA = aqVar.a();
            if (!apVar.b.H()) {
                apVar.v();
            }
            com.google.android.libraries.navigation.internal.adg.aq aqVar4 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
            aqVar4.b |= 128;
            aqVar4.i = iA;
        }
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar5 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        aqVar5.b |= 512;
        aqVar5.k = i3;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar6 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        aqVar6.b |= 1024;
        aqVar6.l = i4;
        int i17 = i2 - 1;
        apVar.C(aw.b, i17 != 1 ? i17 != 2 ? at.DEFAULT : at.DRAW_OVER_LABELS_AND_CALLOUTS : at.DRAW_OVER_LABELS);
        com.google.android.libraries.navigation.internal.ol.a aVar = this.a;
        com.google.android.libraries.navigation.internal.adg.aq aqVar7 = (com.google.android.libraries.navigation.internal.adg.aq) apVar.t();
        com.google.android.libraries.navigation.internal.pp.h hVar = aqVar.e() != null ? ((com.google.android.libraries.navigation.internal.po.d) aVar).a.g : aqVar instanceof dq ? ((dq) aqVar).d : ((com.google.android.libraries.navigation.internal.po.d) aVar).a.f;
        com.google.android.libraries.navigation.internal.po.d dVar = (com.google.android.libraries.navigation.internal.po.d) aVar;
        com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) dVar.b.get(jr.SCREEN_SPACE_FLOAT);
        ar.q(oVar);
        y yVar = new y(aqVar7, (com.google.android.libraries.navigation.internal.oe.k) oVar, hVar, dVar.f, aqVar, dVar.a, dVar.g, dVar.c, dVar.e, dVar.i, dVar.d, aVar, ((Boolean) dVar.h.a()).booleanValue());
        com.google.android.libraries.navigation.internal.ol.i iVarC = yVar.c();
        iVarC.b(x.A(d, d2));
        yVar.d(iVarC);
        return yVar;
    }

    public final List f(List list, int[] iArr, Collection collection, Collection collection2, int i, int i2, int i3, int i4, int i5, float f, int i6, ez ezVar) {
        return g(a(list), iArr, collection, collection2, i, i2, i3, i4, i5, f, i6, ezVar);
    }

    public final List g(double[] dArr, int[] iArr, Collection collection, Collection collection2, int i, int i2, int i3, int i4, int i5, float f, int i6, ez ezVar) {
        List<fg> listE = e(dArr, iArr, collection, collection2, i, i2, i3, i4, i5, f);
        ArrayList arrayList = new ArrayList(listE.size());
        for (fg fgVar : listE) {
            af afVar = i6 == 2 ? cl.NAV_POLYLINE : cg.CLIENT_INJECTED_DRAW_ORDER;
            Cdo cdo = (Cdo) this.c;
            arrayList.add(cdo.h(fgVar, jr.WORLD_ENCODING_LAT_LNG_DOUBLE, cdo.k(fgVar), afVar, ezVar));
        }
        return arrayList;
    }

    public final com.google.android.libraries.navigation.internal.ol.p h(List list, aq aqVar, int i, int i2, int i3) {
        return this.c.a(d(a(list), aqVar, 0, 0, i, i2, i3), jr.WORLD_ENCODING_LAT_LNG_DOUBLE);
    }
}
