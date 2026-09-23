package com.google.android.libraries.navigation.internal.ck;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.ju;
import com.google.android.libraries.navigation.internal.yz.jv;
import com.google.android.libraries.navigation.internal.yz.lr;
import com.google.android.libraries.navigation.internal.yz.nk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class cs extends ax {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.cs");
    private static final int[] b = new int[0];
    private final ct c;
    private final com.google.android.libraries.navigation.internal.on.h d;

    public cs(ct ctVar, com.google.android.libraries.navigation.internal.on.h hVar) {
        this.c = ctVar;
        this.d = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ax
    protected final /* bridge */ /* synthetic */ List c(be beVar, boolean z, boolean z2) {
        List listB = b(beVar.m);
        nk nkVar = new nk();
        int i = 0;
        nkVar.b(lr.c(0, Integer.MAX_VALUE), new com.google.android.libraries.navigation.internal.yx.ao(z2 ? this.c.d() : this.c.e, this.c.d()));
        while (i < beVar.e.size()) {
            int i2 = i + 1;
            bi biVar = (bi) beVar.e.get(i);
            if (biVar.c) {
                int i3 = biVar.b;
                if (i3 == 0) {
                    this.c.f(-12216321, -13342503);
                } else {
                    this.c.e(i3);
                }
            } else {
                int i4 = biVar.b;
                int i5 = i4 != 0 ? i4 : -12216321;
                float[] fArr = new float[3];
                ColorUtils.colorToHSL(i5, fArr);
                fArr[1] = fArr[1] * 0.4f;
                fArr[2] = (fArr[2] + 1.0f) / 2.0f;
                this.c.e(ColorUtils.setAlphaComponent(ColorUtils.HSLToColor(fArr), Color.alpha(i5)));
            }
            if (i == beVar.e.size() - 1) {
                nkVar.c(lr.c((Integer) listB.get(((bi) beVar.e.get(i)).a), (Integer) gs.d(listB)), new com.google.android.libraries.navigation.internal.yx.ao(z2 ? this.c.d() : this.c.e, this.c.d()));
            } else {
                nkVar.c(lr.c((Integer) listB.get(((bi) beVar.e.get(i)).a), (Integer) listB.get(((bi) beVar.e.get(i2)).a)), new com.google.android.libraries.navigation.internal.yx.ao(z2 ? this.c.d() : this.c.e, this.c.d()));
            }
            i = i2;
        }
        for (in inVar : beVar.h) {
            int i6 = inVar.d;
            lr lrVarC = lr.c(Integer.valueOf(i6), Integer.valueOf(i6 + inVar.e));
            ct ctVar = this.c;
            nkVar.c(lrVarC, new com.google.android.libraries.navigation.internal.yx.ao(ctVar.d, ctVar.d()));
        }
        Stream map = new ju((jv) nkVar.a()).stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.ck.cr
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                return new aw((com.google.android.libraries.navigation.internal.ol.aq) ((com.google.android.libraries.navigation.internal.yx.ao) entry.getValue()).a, (com.google.android.libraries.navigation.internal.ol.aq) ((com.google.android.libraries.navigation.internal.yx.ao) entry.getValue()).b, ((Integer) ((lr) entry.getKey()).e()).intValue());
            }
        });
        int i7 = ev.d;
        return (ev) map.collect(com.google.android.libraries.navigation.internal.yz.br.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final void e(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        ct ctVar = this.c;
        Iterator it2 = ctVar.b.values().iterator();
        while (it2.hasNext()) {
            axVar.j((com.google.android.libraries.navigation.internal.ol.aq) it2.next());
        }
        axVar.j(ctVar.c);
        axVar.j(ctVar.d);
        axVar.j(ctVar.e);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final List f(be beVar, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (!z) {
            g(beVar, arrayList, arrayList4, arrayList2);
            return ev.q(this.d.h(arrayList, this.c.e, ff.b, ff.b, cz.a));
        }
        if (beVar.e.isEmpty()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 128)).p("polyline.getVertexBreaks() is empty");
            g(beVar, arrayList, arrayList4, arrayList2);
        } else {
            d(beVar, true, arrayList, arrayList4, arrayList2, arrayList3);
        }
        com.google.android.libraries.navigation.internal.on.h hVar = this.d;
        int[] iArrF = com.google.android.libraries.navigation.internal.zy.i.f(arrayList4);
        float f = beVar.k;
        return hVar.g(com.google.android.libraries.navigation.internal.on.h.a(arrayList), iArrF, arrayList2, arrayList3, 0, 0, ff.b, ff.b, cz.a, f, 1, fd.a);
    }

    protected final void g(be beVar, List list, List list2, List list3) {
        int[] iArr;
        list3.add(this.c.e);
        list.addAll(beVar.m);
        List list4 = beVar.e;
        if (list4.isEmpty()) {
            iArr = b;
        } else {
            int[] iArr2 = new int[list4.size() - 1];
            for (int i = 1; i < list4.size(); i++) {
                iArr2[i - 1] = ((bi) list4.get(i)).a;
            }
            iArr = iArr2;
        }
        int length = iArr.length;
        list2.addAll(length == 0 ? Collections.emptyList() : new com.google.android.libraries.navigation.internal.zy.h(iArr, 0, length));
    }
}
