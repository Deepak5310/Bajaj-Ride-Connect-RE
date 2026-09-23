package com.google.android.libraries.navigation.internal.ck;

import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adr.fe;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.im;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gi;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.ju;
import com.google.android.libraries.navigation.internal.yz.jv;
import com.google.android.libraries.navigation.internal.yz.lr;
import com.google.android.libraries.navigation.internal.yz.mc;
import com.google.android.libraries.navigation.internal.yz.nk;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends ax {
    private final cn a;
    private final k b;
    private final com.google.android.libraries.navigation.internal.on.h c;
    private final bo d;

    public bk(cn cnVar, k kVar, com.google.android.libraries.navigation.internal.on.h hVar, bo boVar) {
        this.a = cnVar;
        this.b = kVar;
        this.c = hVar;
        this.d = boVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ax
    protected final List c(be beVar, boolean z, boolean z2) {
        int i;
        gi giVarA;
        nk nkVar = new nk();
        e eVar = new e();
        eVar.b(com.google.android.libraries.navigation.internal.yx.an.j(im.UNKNOWN_STYLE));
        eVar.a = ex.LEGEND_STYLE_UNDEFINED;
        eVar.b = ex.LEGEND_STYLE_UNDEFINED;
        bn bnVarA = eVar.a();
        int i2 = 0;
        nkVar.c(lr.c(0, Integer.MAX_VALUE), new com.google.android.libraries.navigation.internal.yx.ao(this.d.b(bnVarA, z, z2), this.d.a(bnVarA)));
        HashMap map = new HashMap();
        for (in inVar : beVar.h) {
            int i3 = inVar.d;
            e eVar2 = new e();
            im imVarB = im.b(inVar.c);
            if (imVarB == null) {
                imVarB = im.UNKNOWN_STYLE;
            }
            eVar2.b(com.google.android.libraries.navigation.internal.yx.an.j(imVarB));
            bl.a(map, i3, eVar2.a());
            int i4 = inVar.d + inVar.e;
            e eVar3 = new e();
            eVar3.b(com.google.android.libraries.navigation.internal.yx.an.j(im.UNKNOWN_STYLE));
            bl.a(map, i4, eVar3.a());
        }
        Iterator it2 = beVar.g.iterator();
        while (true) {
            i = 1;
            if (!it2.hasNext()) {
                break;
            }
            fg fgVar = (fg) it2.next();
            if (fgVar.c == 4) {
                fe feVar = fgVar.e;
                if (feVar == null) {
                    feVar = fe.a;
                }
                if ((1 & feVar.b) != 0) {
                    com.google.android.libraries.navigation.internal.adr.ex exVar = fgVar.c == 4 ? (com.google.android.libraries.navigation.internal.adr.ex) fgVar.d : com.google.android.libraries.navigation.internal.adr.ex.a;
                    ex exVarG = ((cq) this.d).a.g(fgVar);
                    int i5 = exVar.c;
                    e eVar4 = new e();
                    eVar4.a = exVarG;
                    bl.a(map, i5, eVar4.a());
                    int i6 = exVar.c + exVar.d;
                    e eVar5 = new e();
                    eVar5.a = ex.LEGEND_STYLE_UNDEFINED;
                    bl.a(map, i6, eVar5.a());
                }
            }
        }
        final Comparator comparator = gi.b;
        Map.Entry[] entryArr = (Map.Entry[]) gs.j(map.entrySet(), gi.a);
        int length = entryArr.length;
        if (length == 0) {
            giVarA = gi.a(comparator);
        } else if (length != 1) {
            Object[] objArr = new Object[length];
            Object[] objArr2 = new Object[length];
            Arrays.sort(entryArr, 0, length, new Comparator() { // from class: com.google.android.libraries.navigation.internal.yz.gd
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Map.Entry entry = (Map.Entry) obj;
                    Map.Entry entry2 = (Map.Entry) obj2;
                    Comparator comparator2 = gi.b;
                    Objects.requireNonNull(entry);
                    Objects.requireNonNull(entry2);
                    return comparator.compare(entry.getKey(), entry2.getKey());
                }
            });
            Map.Entry entry = (Map.Entry) Objects.requireNonNull(entryArr[0]);
            Object key = entry.getKey();
            objArr[0] = key;
            Object value = entry.getValue();
            objArr2[0] = value;
            com.google.android.libraries.navigation.internal.yz.bs.a(objArr[0], value);
            while (i < length) {
                Map.Entry entry2 = (Map.Entry) Objects.requireNonNull(entryArr[i - 1]);
                Map.Entry entry3 = (Map.Entry) Objects.requireNonNull(entryArr[i]);
                Object key2 = entry3.getKey();
                Object value2 = entry3.getValue();
                com.google.android.libraries.navigation.internal.yz.bs.a(key2, value2);
                objArr[i] = key2;
                objArr2[i] = value2;
                if (comparator.compare(key, key2) == 0) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(entry2) + " and " + String.valueOf(entry3));
                }
                i++;
                key = key2;
            }
            giVarA = new gi(new mc(ev.k(objArr), comparator), ev.k(objArr2));
            i2 = 0;
        } else {
            Map.Entry entry4 = (Map.Entry) Objects.requireNonNull(entryArr[0]);
            giVarA = gi.r(comparator, entry4.getKey(), entry4.getValue());
        }
        nn nnVarListIterator = giVarA.entrySet().listIterator();
        im imVar = im.UNKNOWN_STYLE;
        ex exVar2 = ex.LEGEND_STYLE_UNDEFINED;
        ex exVar3 = exVar2;
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry5 = (Map.Entry) nnVarListIterator.next();
            Integer num = (Integer) entry5.getKey();
            int iIntValue = num.intValue();
            bn bnVar = (bn) entry5.getValue();
            e eVar6 = new e();
            eVar6.b(com.google.android.libraries.navigation.internal.yx.an.j(imVar));
            eVar6.a = exVar2;
            eVar6.b = exVar3;
            bn bnVarA2 = eVar6.a();
            nkVar.c(lr.c(Integer.valueOf(i2), num), new com.google.android.libraries.navigation.internal.yx.ao(this.d.b(bnVarA2, z, z2), this.d.a(bnVarA2)));
            if (bnVar.a().g()) {
                imVar = (im) bnVar.a().c();
            }
            ex exVarC = bnVar.c();
            if (exVarC != null) {
                exVar2 = exVarC;
            }
            ex exVarB = bnVar.b();
            if (exVarB != null) {
                exVar3 = exVarB;
            }
            i2 = iIntValue;
        }
        e eVar7 = new e();
        eVar7.b(com.google.android.libraries.navigation.internal.yx.an.j(imVar));
        eVar7.a = exVar2;
        eVar7.b = exVar3;
        bn bnVarA3 = eVar7.a();
        nkVar.c(lr.c(Integer.valueOf(i2), Integer.MAX_VALUE), new com.google.android.libraries.navigation.internal.yx.ao(this.d.b(bnVarA3, z, z2), this.d.a(bnVarA3)));
        return de.d(new ju((jv) nkVar.a())).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.ck.bj
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                Map.Entry entry6 = (Map.Entry) obj;
                return new aw((com.google.android.libraries.navigation.internal.ol.aq) ((com.google.android.libraries.navigation.internal.yx.ao) entry6.getValue()).a, (com.google.android.libraries.navigation.internal.ol.aq) ((com.google.android.libraries.navigation.internal.yx.ao) entry6.getValue()).b, ((Integer) ((lr) entry6.getKey()).e()).intValue());
            }
        }).f();
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final void e(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        this.a.a(axVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final List f(be beVar, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        d(beVar, z, arrayList, arrayList2, arrayList3, arrayList4);
        com.google.android.libraries.navigation.internal.yx.ar.l(!arrayList.isEmpty(), "At least one merged point must be provided.");
        arrayList.size();
        arrayList2.size();
        arrayList3.size();
        int i2 = beVar.j;
        float f = beVar.k;
        List listF = this.c.f(arrayList, com.google.android.libraries.navigation.internal.zy.i.f(arrayList2), arrayList3, arrayList4, 0, beVar.j, ff.b, ff.b, cz.a, beVar.k, i, av.d(i));
        Set setC = av.c(listF);
        if (setC.isEmpty()) {
            return listF;
        }
        com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
        new au(String.format("[b/110101804] ClientLines are transparent. Falling back on hardcoded route polyline styles. styleIds=%s", setC));
        ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE)).o();
        Collections.fill(arrayList3, this.b.a(z));
        Iterator it2 = listF.iterator();
        while (it2.hasNext()) {
            this.c.c.c((com.google.android.libraries.navigation.internal.ol.p) it2.next());
        }
        com.google.android.libraries.navigation.internal.on.h hVar = this.c;
        int[] iArrF = com.google.android.libraries.navigation.internal.zy.i.f(arrayList2);
        int i3 = beVar.j;
        float f2 = beVar.k;
        int i4 = ff.b;
        return hVar.f(arrayList, iArrF, arrayList3, arrayList4, 0, i3, i4, i4, cz.a, f2, i, av.d(i));
    }
}
