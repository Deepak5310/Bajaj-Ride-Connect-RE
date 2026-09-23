package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.adg.ip;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class bz {
    public static final bz p = u().A();

    public static by u() {
        l lVar = new l();
        lVar.t(0);
        lVar.x(bs.a);
        lVar.r(0);
        lVar.s(0);
        lVar.q(ItemViewTypeComposer.BIT_MASK_SEGMENT);
        lVar.p(0.0f);
        lVar.v(0.0f);
        lVar.w(0.0f);
        lVar.m(0);
        lVar.n(0);
        lVar.l(0);
        lVar.o(0.0f);
        int i = ev.d;
        lVar.z(lv.a);
        lVar.y(io.RECT);
        lVar.k(false);
        lVar.u(false);
        return lVar;
    }

    public static bz v(ip ipVar) {
        int i;
        float f = ipVar.e;
        float f2 = ipVar.f203n;
        float f3 = ipVar.o;
        if ((ipVar.c & 128) == 0 || (i = ipVar.l) == 0) {
            i = ipVar.k;
        }
        boolean z = true;
        if (ipVar.r.size() <= 0 && ipVar.s.size() <= 0) {
            z = false;
        }
        ev evVarO = ev.o(new com.google.android.libraries.navigation.internal.ael.bs(ipVar.j, ip.a));
        int i2 = ipVar.m;
        if (i2 == 0) {
            i2 = ItemViewTypeComposer.BIT_MASK_SEGMENT;
        }
        by byVarU = u();
        byVarU.t(ipVar.f);
        byVarU.x(new bs(ipVar.d, f / 8.0f, new int[0], 0.0f));
        byVarU.r(ipVar.k);
        byVarU.s(i);
        byVarU.q(i2);
        byVarU.p(f2 / 8.0f);
        io ioVarB = io.b(ipVar.p);
        if (ioVarB == null) {
            ioVarB = io.RECT;
        }
        byVarU.y(ioVarB);
        byVarU.k(ipVar.q);
        byVarU.v(ipVar.t);
        byVarU.w(ipVar.u);
        byVarU.z(evVarO);
        byVarU.m(ipVar.g);
        byVarU.n(ipVar.i);
        byVarU.l(ipVar.h);
        byVarU.o(f3 / 8.0f);
        byVarU.u(z);
        return byVarU.A();
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract bs l();

    public abstract ev m();

    public abstract io n();

    public abstract boolean o();

    public abstract boolean p();

    public final float q() {
        return Math.max(b() - j(), 0.0f);
    }

    public final float r() {
        return b() + j();
    }

    public final float s() {
        return Math.max(b() - i(), 0.0f);
    }

    public final float t() {
        return b() + i();
    }
}
