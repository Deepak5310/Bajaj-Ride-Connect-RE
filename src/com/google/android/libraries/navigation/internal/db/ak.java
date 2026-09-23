package com.google.android.libraries.navigation.internal.db;

import com.google.android.apps.gmm.location.navigation.cb;
import com.google.android.libraries.navigation.internal.acu.bx;
import com.google.android.libraries.navigation.internal.acu.cf;
import com.google.android.libraries.navigation.internal.agg.ef;
import com.google.android.libraries.navigation.internal.agh.gs;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public static final ak a = new ak();
    public boolean b = false;
    public boolean c = false;
    public af d = null;
    public com.google.android.libraries.navigation.internal.oe.x e = null;
    public float f = Float.NaN;
    public int g = -1;
    public boolean h = false;
    public y i = y.a;
    public long j = 0;
    public String k = "";
    private com.google.android.libraries.navigation.internal.ady.al R = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
    public long l = 0;
    public boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f385n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public double r = 0.0d;
    private double S = 0.0d;
    public long s = -1;
    private long T = -1;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = -1;
    public boolean x = false;
    public com.google.android.libraries.navigation.internal.zr.d y = null;
    public long z = 0;
    public m A = null;
    public m B = null;
    public ef C = null;
    public aq D = null;
    public ae E = null;
    public com.google.android.libraries.navigation.internal.adj.d F = null;
    public String G = null;
    public cb H = null;
    public com.google.android.libraries.navigation.internal.acu.aj I = null;
    public bx J = null;
    public cf K = null;
    public com.google.android.libraries.navigation.internal.oe.x L = null;
    public com.google.android.libraries.navigation.internal.oe.x M = null;
    public double N = Double.NaN;
    public double O = Double.NaN;
    public double P = Double.NaN;
    public aa Q = null;

    public final ak a() {
        ak akVar = new ak();
        akVar.b = this.b;
        akVar.c = this.c;
        akVar.d = this.d;
        com.google.android.libraries.navigation.internal.oe.x xVar = this.e;
        akVar.e = xVar == null ? null : new com.google.android.libraries.navigation.internal.oe.x(xVar);
        akVar.f = this.f;
        akVar.g = this.g;
        akVar.h = this.h;
        akVar.i = this.i;
        akVar.j = this.j;
        akVar.k = this.k;
        akVar.R = this.R;
        akVar.l = this.l;
        akVar.m = this.m;
        akVar.f385n = this.f385n;
        akVar.o = this.o;
        akVar.p = this.p;
        akVar.q = this.q;
        akVar.r = this.r;
        akVar.S = 0.0d;
        akVar.s = this.s;
        akVar.T = this.T;
        akVar.t = this.t;
        akVar.u = this.u;
        akVar.v = this.v;
        akVar.w = this.w;
        akVar.x = this.x;
        akVar.y = this.y;
        akVar.z = this.z;
        akVar.A = this.A;
        akVar.B = this.B;
        akVar.C = this.C;
        akVar.D = this.D;
        akVar.E = this.E;
        akVar.F = this.F;
        akVar.G = this.G;
        akVar.H = this.H;
        akVar.I = this.I;
        akVar.J = this.J;
        akVar.K = this.K;
        com.google.android.libraries.navigation.internal.oe.x xVar2 = this.L;
        akVar.L = xVar2 == null ? null : new com.google.android.libraries.navigation.internal.oe.x(xVar2);
        com.google.android.libraries.navigation.internal.oe.x xVar3 = this.M;
        akVar.M = xVar3 != null ? new com.google.android.libraries.navigation.internal.oe.x(xVar3) : null;
        akVar.N = this.N;
        akVar.O = this.O;
        akVar.P = this.P;
        akVar.Q = this.Q;
        return akVar;
    }

    public final boolean b() {
        return this.y != null;
    }

    public final boolean c() {
        return !this.b || this.i.a() < 0.1d;
    }

    public final boolean d() {
        return this.b && this.i.a() > 0.75d;
    }

    public final boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.agh.ai aiVar = new com.google.android.libraries.navigation.internal.agh.ai();
        gs it2 = this.i.b.m();
        while (it2.hasNext()) {
            long jLongValue = it2.next().longValue();
            aiVar.b(jLongValue, this.i.c(jLongValue));
        }
        com.google.android.libraries.navigation.internal.yx.ak akVarC = com.google.android.libraries.navigation.internal.yx.al.b(this).e("onRoad", this.b).e("inStartupConfusion", this.c).c("laneNumberLeftToRight", this.g);
        akVarC.g("onRouteConfidence", aiVar);
        com.google.android.libraries.navigation.internal.yx.ak akVarD = akVarC.d("timeToComputeSnappingMs", this.l).e("jumpedBackwardsAndSpun", this.f385n).e("onToOffRoadTransition", this.o).e("failsafesGenerated", this.p).e("jumpedDisconnectedSegments", this.m).d("selectedRouteId", this.j);
        akVarD.g("selectedRouteUuid", this.k);
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarD.d("snappingTileDataVersion", this.s).d("laneTileVersion", this.T).e("isCarTileVersion", this.x);
        akVarE.g("mostLikelyFuturePath", this.A);
        akVarE.g("mostLikelyFutureRouteLevelPath", this.B);
        com.google.android.libraries.navigation.internal.yx.ak akVarE2 = akVarE.a("lnObservationProbability", this.r).a("lnExpectedDensity", 0.0d).e("singleModeAltitude", this.h);
        ef efVar = this.C;
        akVarE2.g("connectedNonBranchingSegmentIds", efVar == null ? null : Arrays.toString(efVar.l()));
        akVarE2.g("segmentDebugInfoBundle", this.J);
        akVarE2.g("stateDebugInfoProto", this.K);
        return akVarE2.toString();
    }
}
