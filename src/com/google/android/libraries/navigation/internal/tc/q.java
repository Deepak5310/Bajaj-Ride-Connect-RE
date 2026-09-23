package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q {
    public com.google.android.libraries.navigation.internal.kd.g a = new com.google.android.libraries.navigation.internal.kd.g();
    public final com.google.android.libraries.navigation.internal.kd.g b = new com.google.android.libraries.navigation.internal.kd.g();
    public final com.google.android.libraries.navigation.internal.kd.g c = new com.google.android.libraries.navigation.internal.kd.g();
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    private bg k;

    final void a(com.google.android.libraries.navigation.internal.db.r rVar) {
        if (rVar.w()) {
            bg bgVar = this.k;
            if (bgVar != null) {
                com.google.android.libraries.navigation.internal.db.y yVar = rVar.l().i;
                long j = bgVar.Y;
                if (yVar.e(j)) {
                    this.a.b((float) rVar.l().i.c(j));
                }
            }
            this.b.b((float) rVar.l().r);
            this.c.b(rVar.l().l);
            if (rVar.l().f385n) {
                this.e++;
            }
            if (rVar.l().m) {
                this.d++;
            }
            if (rVar.l().o) {
                this.f++;
            }
            if (rVar.l().p) {
                this.h++;
            }
            if (!rVar.l().b) {
                this.g++;
            }
            this.i++;
        }
    }

    final void b(bg bgVar) {
        this.k = bgVar;
        this.a = new com.google.android.libraries.navigation.internal.kd.g();
    }

    final void c() {
        this.j++;
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("onRouteConfidence", this.a);
        akVarB.g("lnObservationProbabilities", this.b);
        akVarB.g("routeSnappingPerformance", this.c);
        ak akVarC = akVarB.c("jumpingTransitions", this.d).c("spinningTransitions", this.e).c("onToOffRoadTransitions", this.f).c("failsafes", this.h).c("unsnappedLocations", this.g).c("totalProcessedLocations", this.i).c("offRouteReroutes", this.j);
        akVarC.h();
        return akVarC.toString();
    }
}
