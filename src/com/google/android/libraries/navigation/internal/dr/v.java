package com.google.android.libraries.navigation.internal.dr;

import android.content.res.Resources;
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
import com.google.android.libraries.navigation.internal.agg.bz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v {
    public final com.google.android.libraries.navigation.internal.oj.l a;
    public final Resources b;
    public final bz c = new bz();
    public final Map d = new HashMap();
    public final List e = new ArrayList();

    public v(com.google.android.libraries.navigation.internal.oj.l lVar, Resources resources) {
        this.a = lVar;
        this.b = resources;
    }

    final Object a(int i, int i2) {
        Object objP = this.c.p(i);
        if (objP != null) {
            return objP;
        }
        float dimension = this.b.getDimension(i2) / this.b.getDisplayMetrics().density;
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        float f = dimension / 2.0f;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        im imVar = (im) ip.b.q();
        int color = this.b.getColor(i) & 16777215;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar = (ip) imVar.b;
        ipVar.c |= 4;
        ipVar.f = color | (-553648128);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar2 = (ip) imVar.b;
        ipVar2.c |= 64;
        ipVar2.k = 0;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.h((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.g((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.f((ip) imVar.b);
        io ioVar = io.PILL;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar3 = (ip) imVar.b;
        ipVar3.p = ioVar.d;
        ipVar3.c |= 2048;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar4 = (ip) imVar.b;
        ipVar4.c |= 8;
        ipVar4.g = 0;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar5 = (ip) imVar.b;
        ipVar5.c |= 16;
        ipVar5.h = 6;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar6 = (ip) imVar.b;
        ipVar6.c |= 8192;
        ipVar6.t = 2.0f;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar7 = (ip) imVar.b;
        ipVar7.c |= 16384;
        ipVar7.u = 3.0f;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip.d((ip) imVar.b);
        if (!imVar.b.H()) {
            imVar.v();
        }
        float f2 = f + 3.0f;
        ip ipVar8 = (ip) imVar.b;
        ipVar8.c |= 262144;
        ipVar8.w = f2;
        if (!imVar.b.H()) {
            imVar.v();
        }
        ip ipVar9 = (ip) imVar.b;
        ipVar9.c |= 65536;
        ipVar9.v = f2;
        imVar.d(com.google.android.libraries.navigation.internal.adg.b.BOTTOM);
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        ip ipVar10 = (ip) imVar.t();
        ipVar10.getClass();
        eoVar.h = ipVar10;
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
        Object objC = this.a.c((ga) fxVar.t());
        this.c.a(i, objC);
        return objC;
    }

    final Object b(int i, int i2) {
        b bVar = new b(i, i2);
        Object obj = this.d.get(bVar);
        if (obj != null) {
            return obj;
        }
        float dimension = this.b.getDimension(i2) / this.b.getDisplayMetrics().density;
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        int color = this.b.getColor(i);
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.b |= 1;
        eoVar.c = color;
        cf cfVar = (cf) ch.a.q();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar = (ch) cfVar.b;
        chVar.b |= 1;
        chVar.c = (int) dimension;
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        ch chVar2 = (ch) cfVar.b;
        chVar2.b |= 2;
        chVar2.d = 1;
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
        Object objC = this.a.c((ga) fxVar.t());
        this.d.put(bVar, objC);
        return objC;
    }
}
