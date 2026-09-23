package com.google.android.libraries.navigation.internal.gg;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    public static final Duration b = Duration.ofMillis(-1);

    public static l y(k kVar) {
        return new a(kVar.b, kVar.c, kVar.d, kVar.e, kVar.f, kVar.g, kVar.h, kVar.i, kVar.j, kVar.k, kVar.l, kVar.m, kVar.p, kVar.q, kVar.f436n, kVar.o, kVar.r, kVar.s, (Duration) kVar.t.get(), (Duration) kVar.u.get(), (Duration) kVar.v.get(), (Duration) kVar.w.get(), kVar.x, kVar.y);
    }

    public abstract m a();

    public abstract Duration b();

    public abstract Duration c();

    public abstract Duration d();

    public abstract Duration e();

    public abstract Duration f();

    public abstract Duration g();

    public abstract Duration h();

    public abstract Duration i();

    public abstract Duration j();

    public abstract Duration k();

    public abstract Duration l();

    public abstract Duration m();

    public abstract Duration n();

    public abstract Duration o();

    public abstract Duration p();

    public abstract Duration q();

    public abstract Duration r();

    public abstract Duration s();

    public abstract Duration t();

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("REQUIREMENT_START", s());
        akVarB.g("REQUIREMENT_SATISFIED", r());
        akVarB.g("NETWORK_STACK_READY_REQUIREMENT_START", o());
        akVarB.g("NETWORK_STACK_READY_REQUIREMENT_SATISFIED", n());
        akVarB.g("CONNECTIVITY_REQUIREMENT_START", g());
        akVarB.g("CONNECTIVITY_REQUIREMENT_SATISFIED", f());
        akVarB.g("ZWIEBACK_COOKIE_REQUIREMENT_START", x());
        akVarB.g("ZWIEBACK_COOKIE_REQUIREMENT_SATISFIED", w());
        akVarB.g("ZWIEBACK_COOKIE_PRESENT_REQUIREMENT_START", v());
        akVarB.g("ZWIEBACK_COOKIE_PRESENT_REQUIREMENT_SATISFIED", u());
        akVarB.g("AUTH_REQUIREMENT_START", e());
        akVarB.g("AUTH_REQUIREMENT_SATISFIED", d());
        akVarB.g("API_TOKEN_REQUIREMENT_START", c());
        akVarB.g("API_TOKEN_REQUIREMENT_SATISFIED", b());
        akVarB.g("NON_DEFAULT_CLIENTPARAMETERS_REQUIREMENT_START", q());
        akVarB.g("NON_DEFAULT_CLIENTPARAMETERS_REQUIREMENT_SATISFIED", p());
        akVarB.g("LOCATION_REQUIREMENT_START", m());
        akVarB.g("LOCATION_REQUIREMENT_SATISFIED", l());
        akVarB.g("FIRST_BYTE_WRITTEN_TO_WIRE", i());
        akVarB.g("LAST_BYTE_WRITTEN_TO_WIRE", k());
        akVarB.g("FIRST_BYTE_READ_FROM_WIRE", h());
        akVarB.g("LAST_BYTE_READ_FROM_WIRE", j());
        return akVarB.toString();
    }

    public abstract Duration u();

    public abstract Duration v();

    public abstract Duration w();

    public abstract Duration x();
}
