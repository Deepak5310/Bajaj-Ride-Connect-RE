package com.google.android.libraries.navigation.internal.ck;

import android.graphics.Color;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fj;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ct implements cg {
    public static final com.google.android.libraries.navigation.internal.zy.e a;
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.ct");
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final ga j;
    public final Map b;
    public final com.google.android.libraries.navigation.internal.ol.aq c;
    public final com.google.android.libraries.navigation.internal.ol.aq d;
    public final com.google.android.libraries.navigation.internal.ol.aq e;
    private final com.google.android.libraries.navigation.internal.ol.ax k;
    private int l;

    static {
        com.google.android.libraries.navigation.internal.zy.e eVar = com.google.android.libraries.navigation.internal.zy.e.a;
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "the total number of elements must fit in an int");
        int[] iArr = new int[7];
        iArr[0] = 0;
        System.arraycopy(new int[]{4, 8, 11, 12, 13, 16}, 0, iArr, 1, 6);
        a = new com.google.android.libraries.navigation.internal.zy.e(iArr);
        g = new int[]{3, 5, 7, 8, 8, 6, 8};
        h = new int[]{0, 0, 0, 0, 0, 8, 10};
        i = new int[]{4, 7, 11, 12, 12, 20, 22};
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        fj fjVar = (fj) fk.a.q();
        if (!fjVar.b.H()) {
            fjVar.v();
        }
        fk fkVar = (fk) fjVar.b;
        fkVar.b |= 8;
        fkVar.h = true;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        fk fkVar2 = (fk) fjVar.t();
        fkVar2.getClass();
        dbVar2.f = fkVar2;
        dbVar2.b |= 8;
        fxVar.c(daVar);
        j = (ga) fxVar.t();
    }

    public ct(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        HashMap map = new HashMap();
        this.l = 0;
        this.k = axVar;
        this.b = map;
        com.google.android.libraries.navigation.internal.ol.s sVarA = axVar.a(j);
        this.c = sVarA;
        map.put(0, sVarA);
        int i2 = ev.d;
        this.d = axVar.a(com.google.android.libraries.navigation.internal.br.f.c(1224412166, -1, -1033214, lv.a, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE_OVERLAY, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAWCAYAAADJqhx8AAAAAXNSR0IArs4c6QAAAOJJREFUOBGdkz0OgkAQRr8lVrQ2ngFtiaewtNba+2ir1J5E7UzwCMaC2g7WHRLNOAvLLDQsO3xv3vBjMPJ4rpBWLxzMmHy5RNY0OFuLLIkFlDm2dY0bhSmrNvgqw2LDm6oAXJmHaT04glSWgF6DPmUVIKQsAd4IQ8oS8BtBq9wJiFFmgHeSYGdaZYu9K6SsGFwag4cLr+cXd64tjjFh9+kV0xlyClOXSbDVf7FVXlxR8G0VgCvzMK291yhvkMqyHjLoVFYBQsoS4I8gnrIMyGs+gkq5ExCjLAG45zjRf+AVlBsf0d9mMDTLt3oAAAAASUVORK5CYII=", g, h, i, a.e()));
        this.e = axVar.a(com.google.android.libraries.navigation.internal.br.f.a(-8354165, -4341306, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE_DEACTIVATED));
    }

    public static int c(int i2) {
        return Color.argb(Color.alpha(i2), (int) (Color.red(i2) * 0.77f), (int) (Color.green(i2) * 0.77f), (int) (Color.blue(i2) * 0.77f));
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final void a(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final cm b(aq aqVar) {
        return new cs(this, aqVar.b);
    }

    public final com.google.android.libraries.navigation.internal.ol.aq d() {
        Integer numValueOf = Integer.valueOf(this.l);
        if (!this.b.containsKey(numValueOf)) {
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 130)).p("Attempting to retrieve a cached style for a color that is not contained by the TransitPolylineStyles.");
        }
        com.google.android.libraries.navigation.internal.ol.aq aqVar = (com.google.android.libraries.navigation.internal.ol.aq) this.b.get(numValueOf);
        if (aqVar != null) {
            return aqVar;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 129)).p("getCachedStyle attempted to return a null style.");
        return this.c;
    }

    public final void e(int i2) {
        f(i2, c(i2));
    }

    public final void f(int i2, int i3) {
        this.l = i2;
        Map map = this.b;
        Integer numValueOf = Integer.valueOf(i2);
        if (map.containsKey(numValueOf)) {
            return;
        }
        this.b.put(numValueOf, this.k.a(com.google.android.libraries.navigation.internal.br.f.a(i3, i2, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE)));
    }
}
