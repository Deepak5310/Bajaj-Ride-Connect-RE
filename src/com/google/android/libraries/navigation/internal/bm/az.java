package com.google.android.libraries.navigation.internal.bm;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.adg.cf;
import com.google.android.libraries.navigation.internal.adg.ch;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.im;
import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.adg.ip;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az {
    public static final ev a = ev.t(com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT, com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT, com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT, com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT);
    public final com.google.android.libraries.navigation.internal.ol.ax b;
    public final com.google.android.libraries.navigation.internal.oj.l c;
    public final av d;
    public final av e;
    public final at f;
    public final av g;
    public final av h;
    public final av i;
    public final av j;

    public az(Context context, com.google.android.libraries.navigation.internal.ol.ax axVar) {
        this.b = axVar;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        this.c = new com.google.android.libraries.navigation.internal.oj.j(axVar);
        this.f = new at(this, ((BitmapDrawable) context.getResources().getDrawable(com.google.android.libraries.navigation.internal.f.d.u)).getBitmap());
        this.g = c(context, false);
        this.h = c(context, true);
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        int iB = com.google.android.libraries.navigation.internal.ju.b.h.b(context);
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = iB;
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
        chVar.b |= 4;
        chVar.e = 100;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar2 = (ch) cfVar.b;
        chVar2.b |= 1;
        chVar2.c = 14;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar3 = (ch) cfVar.b;
        chVar3.b |= 2;
        chVar3.d = 8;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar4 = (ch) cfVar.b;
        chVar4.b |= 32;
        chVar4.g = 5;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar3 = (eo) ejVar.b;
        ch chVar5 = (ch) cfVar.t();
        chVar5.getClass();
        eoVar3.g = chVar5;
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
        this.i = new av(this, (ga) fxVar.t());
        this.d = b(context, false);
        this.e = b(context, true);
        fx fxVar2 = (fx) ga.a.q();
        da daVar2 = (da) db.a.q();
        if (!daVar2.b.H()) {
            daVar2.v();
        }
        db dbVar3 = (db) daVar2.b;
        dbVar3.b |= 1;
        dbVar3.c = 0;
        ej ejVar2 = (ej) eo.a.q();
        if (!ejVar2.b.H()) {
            ejVar2.v();
        }
        eo eoVar5 = (eo) ejVar2.b;
        eoVar5.b |= 1;
        eoVar5.c = ViewCompat.MEASURED_STATE_MASK;
        cf cfVar2 = (cf) ch.a.q();
        if (!cfVar2.b.H()) {
            cfVar2.v();
        }
        ch chVar6 = (ch) cfVar2.b;
        chVar6.b |= 4;
        chVar6.e = 100;
        if (!cfVar2.b.H()) {
            cfVar2.v();
        }
        ch chVar7 = (ch) cfVar2.b;
        chVar7.b = 1 | chVar7.b;
        chVar7.c = 11;
        if (!ejVar2.b.H()) {
            ejVar2.v();
        }
        eo eoVar6 = (eo) ejVar2.b;
        ch chVar8 = (ch) cfVar2.t();
        chVar8.getClass();
        eoVar6.g = chVar8;
        eoVar6.b |= 16;
        if (!daVar2.b.H()) {
            daVar2.v();
        }
        db dbVar4 = (db) daVar2.b;
        eo eoVar7 = (eo) ejVar2.t();
        eoVar7.getClass();
        dbVar4.e = eoVar7;
        dbVar4.b |= 4;
        fxVar2.c(daVar2);
        this.j = new av(this, (ga) fxVar2.t());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static com.google.android.libraries.navigation.internal.adg.b a() {
        return (com.google.android.libraries.navigation.internal.adg.b) a.get(0);
    }

    private final av b(Context context, boolean z) {
        int color = z ? context.getResources().getColor(com.google.android.libraries.navigation.internal.qr.b.a) : -1;
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        im imVar = (im) ip.b.q();
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar = (ip) imVar.b;
        ipVar.c |= 4;
        ipVar.f = color;
        io ioVar = io.ROUNDED_RECT;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar2 = (ip) imVar.b;
        ipVar2.p = ioVar.d;
        ipVar2.c |= 2048;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar3 = (ip) imVar.b;
        ipVar3.c |= 64;
        ipVar3.k = 0;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.h((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.f((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.g((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar4 = (ip) imVar.b;
        ipVar4.c |= 8192;
        ipVar4.t = 8.0f;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar5 = (ip) imVar.b;
        ipVar5.c |= 16384;
        ipVar5.u = 4.0f;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar6 = (ip) imVar.b;
        ipVar6.c |= 32;
        ipVar6.i = 14;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar7 = (ip) imVar.b;
        ipVar7.c |= 16;
        ipVar7.h = 6;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.e((ip) imVar.b);
        imVar.c(a);
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        ip ipVar8 = (ip) imVar.t();
        ipVar8.getClass();
        eoVar.h = ipVar8;
        eoVar.b |= 32;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        eo eoVar2 = (eo) ejVar.t();
        eoVar2.getClass();
        dbVar2.e = eoVar2;
        dbVar2.b |= 4;
        fxVar.c(daVar);
        return new av(this, (ga) fxVar.t());
    }

    private final av c(Context context, boolean z) {
        int i = z ? com.google.android.libraries.navigation.internal.f.b.F : com.google.android.libraries.navigation.internal.f.b.l;
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        int color = context.getResources().getColor(i);
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = color;
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
        chVar.b |= 4;
        chVar.e = 100;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar2 = (ch) cfVar.b;
        chVar2.b |= 1;
        chVar2.c = 16;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar3 = (ch) cfVar.b;
        chVar3.b |= 2;
        chVar3.d = 1;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar4 = (ch) cfVar.b;
        chVar4.b |= 32;
        chVar4.g = 5;
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar3 = (eo) ejVar.b;
        ch chVar5 = (ch) cfVar.t();
        chVar5.getClass();
        eoVar3.g = chVar5;
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
        return new av(this, (ga) fxVar.t());
    }
}
