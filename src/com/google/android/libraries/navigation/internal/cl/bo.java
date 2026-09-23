package com.google.android.libraries.navigation.internal.cl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.adg.cf;
import com.google.android.libraries.navigation.internal.adg.ch;
import com.google.android.libraries.navigation.internal.adg.cq;
import com.google.android.libraries.navigation.internal.adg.cr;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bo {
    public static final ev a = ev.t(com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT, com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT, com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT, com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT);
    public final Map A = new LinkedHashMap();
    public final com.google.android.libraries.navigation.internal.ol.ax b;
    public final com.google.android.libraries.navigation.internal.oj.l c;
    public final bn d;
    public final bk e;
    public final bk f;
    public final bn g;
    public final bn h;
    public final bn i;
    public final bn j;
    final com.google.android.libraries.navigation.internal.yx.an k;
    final com.google.android.libraries.navigation.internal.yx.an l;
    final com.google.android.libraries.navigation.internal.yx.an m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final com.google.android.libraries.navigation.internal.yx.an f373n;
    final com.google.android.libraries.navigation.internal.yx.an o;
    final com.google.android.libraries.navigation.internal.yx.an p;
    final com.google.android.libraries.navigation.internal.yx.an q;
    final com.google.android.libraries.navigation.internal.yx.an r;
    final com.google.android.libraries.navigation.internal.yx.an s;
    final com.google.android.libraries.navigation.internal.yx.an t;
    final com.google.android.libraries.navigation.internal.yx.an u;
    final com.google.android.libraries.navigation.internal.yx.an v;
    final com.google.android.libraries.navigation.internal.yx.an w;
    final com.google.android.libraries.navigation.internal.yx.an x;
    final com.google.android.libraries.navigation.internal.yx.an y;
    final com.google.android.libraries.navigation.internal.yx.an z;

    public bo(com.google.android.libraries.navigation.internal.ol.ax axVar, Resources resources) {
        this.b = axVar;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        this.c = new com.google.android.libraries.navigation.internal.oj.j(axVar);
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = ViewCompat.MEASURED_STATE_MASK;
        cf cfVar = (cf) ch.a.q();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar = (ch) cfVar.b;
        chVar.b |= 4;
        chVar.e = 100;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar2 = (ch) cfVar.b;
        chVar2.b |= 1;
        chVar2.c = 14;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar2 = (eo) ejVar.b;
        ch chVar3 = (ch) cfVar.t();
        chVar3.getClass();
        eoVar2.g = chVar3;
        eoVar2.b |= 16;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        eo eoVar3 = (eo) ejVar.t();
        eoVar3.getClass();
        dbVar2.e = eoVar3;
        dbVar2.b |= 4;
        fxVar.c(daVar);
        this.d = new bn(this, (ga) fxVar.t());
        this.g = i(bl.SELECTED_SUBTEXT_DAY);
        this.h = i(bl.SELECTED_SUBTEXT_NIGHT);
        this.i = i(bl.ALTERNATE_DAY_SUBTEXT);
        this.j = i(bl.ALTERNATE_NIGHT_SUBTEXT);
        this.f = new bk(this, BitmapFactory.decodeResource(resources, 2130837619));
        this.e = new bk(this, BitmapFactory.decodeResource(resources, 2130837620));
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.o = aVar;
        this.p = aVar;
        this.q = aVar;
        this.r = aVar;
        this.k = aVar;
        this.l = aVar;
        this.m = aVar;
        this.f373n = aVar;
        this.s = aVar;
        this.t = aVar;
        this.u = aVar;
        this.v = aVar;
        this.w = com.google.android.libraries.navigation.internal.yx.an.j(new bk(this, h(com.google.android.libraries.navigation.internal.gw.o.c().a(resources, com.google.android.libraries.navigation.internal.bx.f.c, com.google.android.libraries.navigation.internal.gw.x.c), -1, resources, 15)));
        this.x = com.google.android.libraries.navigation.internal.yx.an.j(new bk(this, h(com.google.android.libraries.navigation.internal.gw.o.c().a(resources, com.google.android.libraries.navigation.internal.bx.f.c, com.google.android.libraries.navigation.internal.gw.x.c), -1, resources, 15)));
        this.y = com.google.android.libraries.navigation.internal.yx.an.j(new bk(this, h(com.google.android.libraries.navigation.internal.gw.o.c().a(resources, com.google.android.libraries.navigation.internal.bx.f.c, com.google.android.libraries.navigation.internal.gw.x.c), -16033840, resources, 15)));
        this.z = com.google.android.libraries.navigation.internal.yx.an.j(new bk(this, h(com.google.android.libraries.navigation.internal.gw.o.c().a(resources, com.google.android.libraries.navigation.internal.bx.f.c, com.google.android.libraries.navigation.internal.gw.x.c), -1, resources, 15)));
    }

    public static Object e(com.google.android.libraries.navigation.internal.oj.l lVar, boolean z) {
        return lVar.d(z ? ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_SELECTED_SUBTITLE : ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_SUBTITLE);
    }

    public static Object f(com.google.android.libraries.navigation.internal.oj.l lVar, boolean z, boolean z2, boolean z3) {
        ex exVar;
        if (z2) {
            exVar = z ? ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_SELECTED_PRIMARY_GROUP : ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_PRIMARY_GROUP;
        } else {
            exVar = z ? ex.LEGEND_STYLE_ROUTE_CALLOUT_SELECTED_PRIMARY_GROUP : ex.LEGEND_STYLE_ROUTE_CALLOUT_PRIMARY_GROUP;
        }
        return lVar.d(exVar);
    }

    public static Object g(com.google.android.libraries.navigation.internal.oj.l lVar, boolean z, boolean z2) {
        ex exVar;
        if (z2) {
            exVar = z ? ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_SELECTED_TITLE : ex.LEGEND_STYLE_CAR_ROUTE_CALLOUT_TITLE;
        } else {
            exVar = z ? ex.LEGEND_STYLE_ROUTE_CALLOUT_SELECTED_TITLE : ex.LEGEND_STYLE_ROUTE_CALLOUT_TITLE;
        }
        return lVar.d(exVar);
    }

    private static Bitmap h(Drawable drawable, int i, Resources resources, int i2) {
        int iCeil = (int) Math.ceil(resources.getDisplayMetrics().density * 15.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private final bn i(bl blVar) {
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        bl blVar2 = bl.SELECTED_SUBTEXT_DAY;
        int i = blVar.e;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = i;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar2 = (eo) ejVar.b;
        eoVar2.b |= 2;
        eoVar2.d = 0;
        cf cfVar = (cf) ch.a.q();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar = (ch) cfVar.b;
        chVar.b |= 1;
        chVar.c = 14;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar2 = (ch) cfVar.b;
        chVar2.b |= 32;
        chVar2.g = 22;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar3 = (ch) cfVar.b;
        chVar3.b |= 4;
        chVar3.e = 90;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar4 = (ch) cfVar.b;
        chVar4.b |= 8;
        chVar4.f = 0;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar5 = (ch) cfVar.b;
        chVar5.b |= 2;
        chVar5.d = 0;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar3 = (eo) ejVar.b;
        ch chVar6 = (ch) cfVar.t();
        chVar6.getClass();
        eoVar3.g = chVar6;
        eoVar3.b |= 16;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        eo eoVar4 = (eo) ejVar.t();
        eoVar4.getClass();
        dbVar2.e = eoVar4;
        dbVar2.b |= 4;
        fxVar.c(daVar);
        return new bn(this, (ga) fxVar.t());
    }

    private final bn j(Resources resources, String str, boolean z) {
        bn bnVar;
        synchronized (this) {
            String str2 = str + "&car=" + (true != z ? "0" : "1");
            if (!this.A.containsKey(str2)) {
                cq cqVar = (cq) cr.a.q();
                if (!cqVar.b.H()) {
                    cqVar.v();
                }
                cr crVar = (cr) cqVar.b;
                str.getClass();
                crVar.b |= 1;
                crVar.c = str;
                int i = true != z ? 4 : 3;
                if (!cqVar.b.H()) {
                    cqVar.v();
                }
                cr crVar2 = (cr) cqVar.b;
                crVar2.b |= 8;
                crVar2.f = i;
                if (z) {
                    int iCeil = (int) Math.ceil(resources.getDisplayMetrics().density * 24.0f);
                    if (!cqVar.b.H()) {
                        cqVar.v();
                    }
                    cr crVar3 = (cr) cqVar.b;
                    crVar3.b |= 16;
                    crVar3.g = iCeil;
                    int iCeil2 = (int) Math.ceil(resources.getDisplayMetrics().density * 24.0f);
                    if (!cqVar.b.H()) {
                        cqVar.v();
                    }
                    cr crVar4 = (cr) cqVar.b;
                    crVar4.b |= 32;
                    crVar4.h = iCeil2;
                }
                fx fxVar = (fx) ga.a.q();
                da daVar = (da) db.a.q();
                if (!daVar.b.H()) {
                    daVar.v();
                }
                db dbVar = (db) daVar.b;
                dbVar.b = 1 | dbVar.b;
                dbVar.c = 0;
                ej ejVar = (ej) eo.a.q();
                ejVar.c(cqVar);
                if (!daVar.b.H()) {
                    daVar.v();
                }
                db dbVar2 = (db) daVar.b;
                eo eoVar = (eo) ejVar.t();
                eoVar.getClass();
                dbVar2.e = eoVar;
                dbVar2.b = 4 | dbVar2.b;
                fxVar.c(daVar);
                this.A.put(str2, new bn(this, (ga) fxVar.t()));
            }
            bnVar = (bn) this.A.get(str2);
        }
        return bnVar;
    }

    public final bn a(boolean z, boolean z2) {
        if (z2) {
            return z ? this.h : this.g;
        }
        return z ? this.j : this.i;
    }

    public final com.google.android.libraries.navigation.internal.ol.aq b(Resources resources, String str, boolean z) {
        return j(resources, str, z).a();
    }

    public final com.google.android.libraries.navigation.internal.oo.f c(boolean z, boolean z2, boolean z3) {
        return (com.google.android.libraries.navigation.internal.oo.f) f(com.google.android.libraries.navigation.internal.oj.l.a, z, z2, false);
    }

    public final com.google.android.libraries.navigation.internal.oo.f d(Resources resources, String str, boolean z) {
        return j(resources, str, z).b();
    }
}
