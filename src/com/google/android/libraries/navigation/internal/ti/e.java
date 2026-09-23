package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bt;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zs.fb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final ad a;
    public int b;
    public int d;
    public int e;
    public int f;
    public bf g;
    public al h;
    public int i;
    public boolean j;
    private final com.google.android.libraries.navigation.internal.mj.a k;
    private boolean p;
    private boolean q;
    private long l = Long.MAX_VALUE;
    private int m = -1;
    public String c = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f594n = -1;
    private int o = -1;

    public e(com.google.android.libraries.navigation.internal.mj.a aVar, ad adVar) {
        this.k = aVar;
        this.a = adVar;
        al alVarB = al.b(adVar.a.A);
        this.h = alVarB == null ? al.DRIVE : alVarB;
    }

    public final int a() {
        ar.k(c());
        return this.m;
    }

    final void b(com.google.android.libraries.navigation.internal.db.r rVar) {
        long jA = com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
        if (this.a.a.w > 0 && !e(rVar)) {
            this.l = Long.MAX_VALUE;
        } else if (this.l == Long.MAX_VALUE) {
            fb fbVar = this.a.a;
            this.l = jA + (((long) fbVar.w) * ((long) fbVar.f));
        }
    }

    public final boolean c() {
        return this.g != null;
    }

    public final boolean d() {
        return !this.j || this.q;
    }

    final boolean e(com.google.android.libraries.navigation.internal.db.r rVar) {
        return rVar.B() && this.f594n >= 0 && rVar.l().i.e(this.f594n) && rVar.l().i.c(this.f594n) * 100.0d >= ((double) this.a.a.t);
    }

    final boolean f(com.google.android.libraries.navigation.internal.tj.o oVar) {
        int iC;
        int i;
        bt btVar;
        com.google.android.libraries.navigation.internal.se.b bVarC = oVar.c();
        bg bgVar = bVarC.b;
        long jA = this.k.a();
        long j = this.l;
        int iA = com.google.android.libraries.navigation.internal.vm.a.a(this.a.b, bgVar.z);
        if (iA != this.b) {
            this.b = iA;
        }
        int i2 = bgVar.A;
        if (i2 != this.m) {
            this.m = i2;
        }
        String str = bgVar.B;
        if (!am.a(str, this.c)) {
            this.c = str;
        }
        bq bqVar = bVarC.c;
        boolean z = false;
        if (bqVar == null) {
            iC = 0;
        } else {
            iC = com.google.android.libraries.navigation.internal.vm.a.c(this.a.b, bqVar.L);
        }
        if (iC != this.d) {
            this.d = iC;
        }
        int i3 = (bqVar == null || (btVar = bqVar.b) == null) ? -1 : btVar.b;
        if (i3 != this.e) {
            this.e = i3;
        }
        int i4 = bqVar != null ? bqVar.i : -1;
        if (i4 != this.f) {
            this.f = i4;
        }
        long j2 = bgVar.Y;
        if (j2 != this.f594n) {
            this.f594n = j2;
        }
        bf bfVar = bgVar.Q;
        if (bfVar != this.g) {
            this.g = bfVar;
        }
        al alVar = bgVar.j;
        if (!alVar.equals(this.h)) {
            this.h = alVar;
        }
        int iA2 = (int) bVarC.a();
        if (iA2 != this.i) {
            this.i = iA2;
        }
        int i5 = bVarC.k;
        int i6 = i5 != -1 ? i5 : -1;
        if (i6 != this.o) {
            this.o = i6;
        }
        boolean z2 = jA >= j;
        if (!this.p && this.i < this.a.d && z2) {
            this.p = true;
        }
        if (!this.j && this.i >= this.a.d && z2 && this.p) {
            this.j = true;
        }
        if (!this.q && (i = this.o) >= 0 && i < this.a.e) {
            this.q = true;
            z = true;
        }
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("activeEiHash", Integer.toHexString(this.b));
        ak akVarC = akVarB.c("activeTripIndex", this.m);
        akVarC.g("activeTripIdForLogging", this.c);
        akVarC.g("activeStepHash", Integer.toHexString(this.d));
        ak akVarD = akVarC.d("activeTripId", this.f594n);
        akVarD.g("activeTripSource", this.g);
        akVarD.g("travelMode", this.h);
        akVarD.c("startToCurrentM", this.i).c("currentToEndM", this.o).e("wasInStartScrubbingZone", this.p).e("hasLeftStartScrubbingZone", this.j).e("hasEnteredEndScrubbingZone", this.q);
        return z;
    }

    public final String toString() {
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        ak akVarC = akVarB.d("trustworthyHorizonRelativeMs", this.l).c("activeEiHash", this.b).c("activeTripIndex", this.m);
        akVarC.g("activeTripIdForLogging", this.c);
        ak akVarD = akVarC.c("activeStepHash", this.d).d("activeTripId", this.f594n);
        akVarD.g("activeTripSource", this.g);
        akVarD.g("travelMode", this.h);
        return akVarD.c("startToCurrentM", this.i).c("currentToEndM", this.o).e("wasInStartScrubbingZone", this.p).e("hasLeftStartScrubbingZone", this.j).e("hasEnteredEndScrubbingZone", this.q).toString();
    }
}
