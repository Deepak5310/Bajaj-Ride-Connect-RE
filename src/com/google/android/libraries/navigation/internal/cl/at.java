package com.google.android.libraries.navigation.internal.cl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.adg.cf;
import com.google.android.libraries.navigation.internal.adg.ch;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class at {
    protected final com.google.android.libraries.navigation.internal.ol.ax a;
    public final com.google.android.libraries.navigation.internal.oj.l b;
    public final com.google.android.libraries.navigation.internal.ol.aq c;
    public final com.google.android.libraries.navigation.internal.oo.f d;
    private final Resources e;
    private final boolean f;
    private final List g = new ArrayList();

    public at(com.google.android.libraries.navigation.internal.ol.ax axVar, Resources resources, boolean z) {
        this.a = axVar;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        com.google.android.libraries.navigation.internal.oj.j jVar = new com.google.android.libraries.navigation.internal.oj.j(axVar);
        this.b = jVar;
        this.e = resources;
        this.f = z;
        this.c = jVar.c(i());
        this.d = new com.google.android.libraries.navigation.internal.rd.c(i());
    }

    private static ga i() {
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
        chVar2.c = 16;
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
        return (ga) fxVar.t();
    }

    public final as a(bq bqVar, int i) {
        Drawable drawableC;
        if (this.f) {
            drawableC = com.google.android.libraries.navigation.internal.bl.d.b(com.google.android.libraries.navigation.internal.bl.d.f(bqVar), this.e.getColor(i));
        } else {
            drawableC = com.google.android.libraries.navigation.internal.bl.d.c(bqVar, this.e.getColor(i));
        }
        int iRound = Math.round(this.e.getDisplayMetrics().density * 22.0f);
        as asVar = new as(this, com.google.android.libraries.navigation.internal.gw.f.a(drawableC, iRound, iRound, Bitmap.Config.ARGB_8888));
        synchronized (this) {
            this.g.add(asVar);
        }
        return asVar;
    }

    public abstract com.google.android.libraries.navigation.internal.ol.aq b();

    public abstract com.google.android.libraries.navigation.internal.ol.aq c(bq bqVar);

    public abstract com.google.android.libraries.navigation.internal.ol.aq d();

    public abstract com.google.android.libraries.navigation.internal.oo.f e();

    public abstract com.google.android.libraries.navigation.internal.oo.f f(bq bqVar);

    public abstract com.google.android.libraries.navigation.internal.oo.f g();

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        ev evVarO;
        this.a.j(this.c);
        synchronized (this) {
            evVarO = ev.o(this.g);
            this.g.clear();
        }
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            as asVar = (as) evVarO.get(i);
            br brVar = (br) asVar.a.getAndSet(null);
            if (brVar != null) {
                asVar.b.a.j((com.google.android.libraries.navigation.internal.ol.aq) brVar.a());
            }
        }
    }
}
