package com.google.android.libraries.navigation.internal.bt;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.EnumSet;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bt.h");

    public static d Q() {
        a aVar = new a();
        aVar.v(bh.b);
        int i = ev.d;
        aVar.F(lv.a);
        u uVar = u.NORMAL;
        Objects.requireNonNull(uVar);
        aVar.c = uVar;
        aVar.t(e.FIRST_DESTINATION);
        aVar.s(com.google.android.libraries.navigation.internal.yx.a.a);
        aVar.d = new c(EnumSet.allOf(f.class));
        aVar.B(true);
        aVar.y(false);
        aVar.x();
        aVar.r(false);
        aVar.q(false);
        aVar.G(true);
        aVar.k();
        int i2 = aVar.j;
        aVar.e = -1;
        aVar.f = -1;
        aVar.a = true;
        aVar.j = i2 | 30728;
        aVar.n(lv.a);
        aVar.C(false);
        aVar.m(new bv(be.TIME));
        aVar.w(false);
        aVar.D(false);
        int i3 = aVar.j;
        aVar.g = true;
        aVar.j = i3 | 983040;
        aVar.o();
        aVar.H();
        aVar.A(true);
        aVar.z(true);
        return aVar;
    }

    public abstract boolean A();

    public abstract boolean B();

    public abstract boolean C();

    public abstract boolean D();

    public abstract void E();

    public abstract void F();

    public abstract void G();

    public abstract void H();

    public abstract void I();

    public abstract void J();

    public abstract void K();

    public abstract void L();

    public abstract void M();

    public abstract void N();

    public abstract void O();

    public abstract void P();

    public final bd R() {
        return (bd) m().a();
    }

    public abstract int a();

    public abstract int b();

    public abstract com.google.android.libraries.navigation.internal.bn.f c();

    public abstract bh d();

    public abstract bq e();

    public abstract d f();

    public abstract e g();

    public abstract g h();

    public abstract u i();

    public abstract an j();

    public abstract an k();

    public abstract an l();

    public abstract br m();

    public abstract br n();

    public abstract ev o();

    public abstract ev p();

    public abstract ev q();

    public abstract ev r();

    public abstract boolean s();

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    public abstract boolean w();

    public abstract boolean x();

    public abstract boolean y();

    public abstract boolean z();
}
