package com.google.android.libraries.navigation.internal.dh;

import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@com.google.android.libraries.navigation.internal.ib.a
public final class r extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final String a;
    private final double b;
    private final double c;
    private final double d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f398n;
    private final long o;
    private final double p;
    private final double r;
    private final boolean s;
    private final String t;
    private final int u;
    private final int v;
    private final long w;
    private final long x;

    public r(com.google.android.libraries.navigation.internal.db.r rVar) {
        this.a = rVar.a;
        this.b = rVar.b;
        this.c = rVar.c;
        this.d = rVar.s() ? rVar.e : Double.NaN;
        this.e = rVar.t() ? rVar.f() : Float.NaN;
        this.f = rVar.x() ? rVar.f : Float.NaN;
        this.g = rVar.r() ? rVar.d : Float.NaN;
        this.h = rVar.y() ? rVar.h() : Float.NaN;
        this.i = rVar.u() ? rVar.g() : Float.NaN;
        this.j = rVar.A() ? rVar.i() : Float.NaN;
        this.k = rVar.B();
        this.m = rVar.l().c;
        this.l = rVar.l().p;
        this.f398n = rVar.l().d();
        this.o = rVar.l().s;
        this.w = com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
        this.x = rVar.l().l;
        long j = rVar.l().j;
        this.v = rVar.l().g;
        com.google.android.libraries.navigation.internal.db.y yVar = rVar.l().i;
        if (j < 0 || !yVar.e(j)) {
            this.p = Double.NaN;
            this.r = Double.NaN;
        } else {
            this.p = yVar.c(j);
            this.r = yVar.d(j);
        }
        this.s = rVar.l().q;
        com.google.android.libraries.navigation.internal.pt.d dVar = rVar.f387n;
        this.t = dVar != null ? dVar.b.f() : null;
        this.u = dVar != null ? dVar.c : Integer.MIN_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVarG = new com.google.android.libraries.navigation.internal.kp.f("expected-location").k("provider", this.a).a("lat", this.b).a("lng", this.c).i(SavingTrackHelper.TRACK_COL_ALTITUDE, this.d).j("bearing", this.e).j("speed", this.f).j("accuracy", this.g).j("speedAcc", this.h).j("bearingAcc", this.i).j("vertAcc", this.j).h("onRoad", this.k).h("sc", this.m).l("failsafes", this.l).h("inTunnel", this.f398n).g("tileVer", this.o).i("routeConf", this.p).i("routeDist", this.r).l("patched", this.s).k("levelId", this.t).g("etms", this.w).g("cpuMs", this.x);
        int i = this.v;
        if (i != -1) {
            fVarG.f("laneNum", i);
        }
        int i2 = this.u;
        if (i2 != Integer.MIN_VALUE) {
            fVarG.f("levelNum", i2);
        }
        return fVarG;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g("lanes", null);
        akVarB.g("provider", this.a);
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarB.a("lat", this.b).a("lng", this.c).a(SavingTrackHelper.TRACK_COL_ALTITUDE, this.d).b("bearing", this.e).b("speed", this.f).b("accuracy", this.g).b("speedAcc", this.h).b("bearingAcc", this.i).b("vertAcc", this.j).e("onRoad", this.k).e("inStartupConfusion", this.m).e("failsafesGenerated", this.l).e("inTunnel", this.f398n).d("tileDataVersion", this.o).a("onSelectedRouteConfidence", this.p).a("modalDistanceAlongSelectedRouteMeters", this.r).e("patched", this.s);
        akVarE.g("levelId", this.t);
        return akVarE.c("levelNum", this.u).c("laneNum", this.v).d("elapsedRealtimeMs", this.w).d("cpuMs", this.x).toString();
    }
}
