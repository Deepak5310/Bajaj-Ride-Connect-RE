package com.google.android.libraries.navigation.internal.dr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.af;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.at;
import com.google.android.libraries.navigation.internal.adg.ba;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.agg.bz;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public final com.google.android.libraries.navigation.internal.on.h a;
    public final com.google.android.libraries.navigation.internal.oo.b b;

    @Deprecated
    public final v c;
    public final v d;
    public final com.google.android.libraries.navigation.internal.cr.f e;
    private final Resources f;
    private final com.google.android.libraries.navigation.internal.hn.r g;
    private final Map h = new HashMap();
    private final bz i = new bz();

    public z(Resources resources, com.google.android.libraries.navigation.internal.on.h hVar, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.cr.f fVar) {
        this.f = resources;
        this.a = hVar;
        ax axVar = hVar.d;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        this.c = new v(new com.google.android.libraries.navigation.internal.oj.j(axVar), resources);
        this.d = new v(com.google.android.libraries.navigation.internal.oj.l.a, resources);
        this.b = bVar;
        this.e = fVar;
        this.g = rVar;
    }

    public static Object c(com.google.android.libraries.navigation.internal.oj.c cVar, v vVar, String str, int i, int i2, int i3) {
        Object objB = vVar.b(i, i2);
        Object objA = vVar.a(i3, i2);
        dy dyVarC = cVar.c();
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar = (ef) dyVarC.b;
        ef efVar2 = ef.a;
        efVar.b |= 16384;
        efVar.f186n = c.a(6);
        dq dqVarB = cVar.b(objA);
        Cdo cdoA = cVar.a(objB);
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        dp dpVar = (dp) cdoA.b;
        dp dpVar2 = dp.a;
        dpVar.b |= 1;
        dpVar.c = str;
        dqVarB.d(cdoA);
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar3 = (ef) dyVarC.b;
        dt dtVar = (dt) dqVarB.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.BOTTOM;
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar.d = bVar.j;
        dVar.b |= 2;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar4 = (ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        dVar2.getClass();
        efVar4.e = dVar2;
        efVar4.b |= 8;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar5 = (ef) dyVarC.b;
        efVar5.b |= 64;
        efVar5.h = 3;
        bh bhVar = com.google.android.libraries.navigation.internal.adl.k.a;
        com.google.android.libraries.navigation.internal.adl.v vVar2 = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        if (!vVar2.b.H()) {
            vVar2.v();
        }
        com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar2.b);
        dyVarC.C(bhVar, (com.google.android.libraries.navigation.internal.adl.x) vVar2.t());
        return cVar.e();
    }

    public final synchronized x a(int i) {
        x xVar = (x) this.i.p(i);
        if (xVar != null) {
            return xVar;
        }
        final com.google.android.libraries.geo.mapcore.renderer.k kVar = new com.google.android.libraries.geo.mapcore.renderer.k(this.f, i);
        x xVar2 = new x(((com.google.android.libraries.geo.mapcore.renderer.g) kVar.b()).a, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.dr.t
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.d.m(kVar, k.a);
            }
        }));
        this.i.a(i, xVar2);
        return xVar2;
    }

    public final Object b(com.google.android.libraries.navigation.internal.oj.c cVar, v vVar, int i, int i2, int i3, int i4, int i5, int i6) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) vVar.b.getDrawable(i5);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) vVar.b.getDrawable(i6);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap bitmap2 = bitmapDrawable2.getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double height2 = bitmap2.getHeight();
        Bitmap bitmapCopy = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapCopy).drawBitmap(bitmap, (float) ((((double) bitmap2.getWidth()) * 0.5d) - (((double) width) * 0.5d)), (float) ((height2 * 0.5d) - (((double) height) * 0.5d)), (Paint) null);
        Object objF = vVar.a.f(bitmapCopy);
        vVar.e.add(objF);
        Object objB = vVar.b(i2, i3);
        Object objA = vVar.a(i4, i3);
        dy dyVarC = cVar.c();
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar = (ef) dyVarC.b;
        ef efVar2 = ef.a;
        efVar.b |= 16384;
        efVar.f186n = c.a(6);
        dq dqVarB = cVar.b(objA);
        dqVarB.d(cVar.a(objF));
        Cdo cdoA = cVar.a(objB);
        String strValueOf = String.valueOf(this.f.getString(i));
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        String strConcat = StringUtils.SPACE.concat(strValueOf);
        dp dpVar = (dp) cdoA.b;
        dp dpVar2 = dp.a;
        dpVar.b |= 1;
        dpVar.c = strConcat;
        dqVarB.d(cdoA);
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar3 = (ef) dyVarC.b;
        dt dtVar = (dt) dqVarB.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.BOTTOM;
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar.d = bVar.j;
        dVar.b |= 2;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar4 = (ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        dVar2.getClass();
        efVar4.e = dVar2;
        efVar4.b |= 8;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar5 = (ef) dyVarC.b;
        efVar5.b |= 64;
        efVar5.h = 3;
        bh bhVar = com.google.android.libraries.navigation.internal.adl.k.a;
        com.google.android.libraries.navigation.internal.adl.v vVar2 = (com.google.android.libraries.navigation.internal.adl.v) com.google.android.libraries.navigation.internal.adl.x.a.q();
        if (!vVar2.b.H()) {
            vVar2.v();
        }
        com.google.android.libraries.navigation.internal.adl.x.c((com.google.android.libraries.navigation.internal.adl.x) vVar2.b);
        dyVarC.C(bhVar, (com.google.android.libraries.navigation.internal.adl.x) vVar2.t());
        return cVar.e();
    }

    public final synchronized void d() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("destroyAllStyles");
        try {
            gi giVarListIterator = this.i.values().listIterator();
            while (giVarListIterator.hasNext()) {
                this.a.d.j((aq) ((x) giVarListIterator.next()).b.a());
            }
            this.i.clear();
            Iterator it2 = this.h.values().iterator();
            while (it2.hasNext()) {
                this.a.d.j((aq) ((br) it2.next()).a());
            }
            this.h.clear();
            v vVar = this.c;
            int i = ev.d;
            eq eqVar = new eq();
            eqVar.j(vVar.c.values());
            eqVar.j(vVar.d.values());
            eqVar.j(vVar.e);
            vVar.c.clear();
            vVar.d.clear();
            vVar.e.clear();
            no it3 = eqVar.g().iterator();
            while (it3.hasNext()) {
                this.a.d.j((aq) it3.next());
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void e(k kVar, int i) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("updateImageEntity");
        try {
            x xVarA = a(i);
            int i2 = xVarA.a;
            aq aqVar = (aq) xVarA.b.a();
            kVar.d = i2;
            kVar.c = true;
            ((com.google.android.libraries.navigation.internal.ol.j) kVar.b.a()).b(aqVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final boolean f() {
        return (!((fj) this.g.b()).c || this.b == null || this.e == null) ? false : true;
    }

    public final k g(int i, String str, int i2) {
        x xVarA = a(i);
        return new k(this.a.a, str, xVarA.a, j(xVarA, i2));
    }

    public final k h(String str, final int i) {
        return new k(this.a.a, str, 1, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.dr.s
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i2 = k.a;
                fx fxVar = (fx) ga.a.q();
                da daVar = (da) db.a.q();
                if (!daVar.b.H()) {
                    daVar.v();
                }
                db dbVar = (db) daVar.b;
                dbVar.b |= 1;
                dbVar.c = 0;
                at atVar = (at) ba.a.q();
                if (!atVar.b.H()) {
                    atVar.v();
                }
                ba baVar = (ba) atVar.b;
                baVar.b |= 2;
                baVar.f = -1;
                if (!atVar.b.H()) {
                    atVar.v();
                }
                ba baVar2 = (ba) atVar.b;
                baVar2.b |= 8;
                baVar2.h = true;
                if (!atVar.b.H()) {
                    atVar.v();
                }
                ba baVar3 = (ba) atVar.b;
                baVar3.b |= 16;
                baVar3.i = false;
                if (!atVar.b.H()) {
                    atVar.v();
                }
                ba baVar4 = (ba) atVar.b;
                baVar4.b |= 4;
                baVar4.g = i2;
                if (!atVar.b.H()) {
                    atVar.v();
                }
                ba baVar5 = (ba) atVar.b;
                baVar5.b |= 32;
                baVar5.j = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAAA1JREFUCJljYGBgYAAAAAUAAYehTtQAAAAASUVORK5CYII=";
                if (!daVar.b.H()) {
                    daVar.v();
                }
                z zVar = this.a;
                int i3 = i;
                db dbVar2 = (db) daVar.b;
                ba baVar6 = (ba) atVar.t();
                baVar6.getClass();
                dbVar2.d = baVar6;
                dbVar2.b |= 2;
                fxVar.c(daVar);
                ga gaVar = (ga) fxVar.t();
                com.google.android.libraries.navigation.internal.on.h hVar = zVar.a;
                com.google.android.libraries.navigation.internal.ol.j jVarC = hVar.c(0.0d, 0.0d, 8, 2.0f, true, hVar.d.a(gaVar), false, 3, c.a(i3), 0);
                com.google.android.libraries.navigation.internal.ol.i iVarC = jVarC.c();
                iVarC.d(1.0f, com.google.android.libraries.navigation.internal.ol.h.PIXEL);
                jVarC.d(iVarC);
                return jVarC;
            }
        }));
    }

    public final aa i(int i, final boolean z, final af afVar, final int i2) {
        final br brVarA;
        final int color = this.f.getColor(i);
        a aVar = new a(color, z);
        synchronized (this) {
            if (this.h.containsKey(aVar)) {
                brVarA = (br) this.h.get(aVar);
            } else {
                brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.dr.q
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        int i3 = color;
                        int iArgb = Color.argb(255, Color.red(i3), Color.green(i3), Color.blue(i3));
                        fx fxVar = (fx) ga.a.q();
                        da daVar = (da) db.a.q();
                        if (!daVar.b.H()) {
                            daVar.v();
                        }
                        af afVar2 = afVar;
                        db dbVar = (db) daVar.b;
                        dbVar.b |= 1;
                        dbVar.c = 0;
                        at atVar = (at) ba.a.q();
                        int iA = afVar2.a();
                        if (!atVar.b.H()) {
                            atVar.v();
                        }
                        ba baVar = (ba) atVar.b;
                        baVar.b |= 4;
                        baVar.g = iA;
                        if (!atVar.b.H()) {
                            atVar.v();
                        }
                        ba baVar2 = (ba) atVar.b;
                        baVar2.b |= 2;
                        baVar2.f = i3;
                        if (!atVar.b.H()) {
                            atVar.v();
                        }
                        boolean z2 = z;
                        ba baVar3 = (ba) atVar.b;
                        baVar3.b |= 16;
                        baVar3.i = z2;
                        boolean z3 = !z2;
                        if (!atVar.b.H()) {
                            atVar.v();
                        }
                        ba baVar4 = (ba) atVar.b;
                        baVar4.b |= 8;
                        baVar4.h = z3;
                        ic icVar = (ic) id.a.q();
                        if (!icVar.b.H()) {
                            icVar.v();
                        }
                        id idVar = (id) icVar.b;
                        idVar.b |= 1;
                        idVar.c = iArgb;
                        if (!icVar.b.H()) {
                            icVar.v();
                        }
                        id idVar2 = (id) icVar.b;
                        idVar2.b |= 8;
                        idVar2.e = 1;
                        atVar.c(icVar);
                        if (!daVar.b.H()) {
                            daVar.v();
                        }
                        z zVar = this.a;
                        db dbVar2 = (db) daVar.b;
                        ba baVar5 = (ba) atVar.t();
                        baVar5.getClass();
                        dbVar2.d = baVar5;
                        dbVar2.b |= 2;
                        fxVar.c(daVar);
                        return zVar.a.d.a((ga) fxVar.t());
                    }
                });
                this.h.put(aVar, brVarA);
            }
        }
        com.google.android.libraries.navigation.internal.on.h hVar = this.a;
        return new aa(hVar.a, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.dr.r
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.ol.j jVarC = this.a.a.c(0.0d, 0.0d, 100, 2.0f, false, (aq) brVarA.a(), z, 3, c.a(i2), 0);
                com.google.android.libraries.navigation.internal.ol.i iVarC = jVarC.c();
                iVarC.d(100.0f, com.google.android.libraries.navigation.internal.ol.h.PIXEL);
                jVarC.d(iVarC);
                return jVarC;
            }
        }));
    }

    public final br j(final x xVar, final int i) {
        return bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.dr.u
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.c(0.0d, 0.0d, 4, 2.0f, true, (aq) xVar.b.a(), false, 3, c.a(i), 0);
            }
        });
    }
}
