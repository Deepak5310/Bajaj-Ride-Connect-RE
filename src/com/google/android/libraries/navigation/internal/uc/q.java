package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends k {
    public final ev f;
    public final k g;

    /* JADX INFO: compiled from: PG */
    public class a extends j {
        private static final com.google.android.libraries.navigation.internal.zb.j h = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.uc.q$a");
        public final eq f;
        public k g;

        public a() {
            int i = ev.d;
            this.f = new eq();
        }

        @Override // com.google.android.libraries.navigation.internal.uc.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final q a() {
            b();
            return new q(this);
        }

        @Override // com.google.android.libraries.navigation.internal.uc.j
        protected final void b() {
            k kVar;
            if (this.a != g.INSPECT_ROUTE_SECTION) {
                ((com.google.android.libraries.navigation.internal.zb.h) h.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1887)).s("CameraMode should be INSPECT_ROUTE_SECTION but was %s.", this.a);
                this.a = g.INSPECT_ROUTE_SECTION;
            }
            while (true) {
                kVar = this.g;
                if (!(kVar instanceof q)) {
                    break;
                } else {
                    this.g = ((q) kVar).g;
                }
            }
            if (kVar == null) {
                this.g = new j().a();
                return;
            }
            g gVar = kVar.a;
            if (gVar == g.FOLLOWING || gVar == g.OVERVIEW || gVar == g.INSPECT_RESULTS_ON_MAP_WITH_LOCATION || gVar == g.INSPECT_RESULTS_ON_MAP_WITHOUT_LOCATION) {
                return;
            }
            j jVar = new j(kVar);
            jVar.a = g.FOLLOWING;
            this.g = jVar.a();
        }

        public a(k kVar) {
            super(kVar);
            int i = ev.d;
            eq eqVar = new eq();
            this.f = eqVar;
            if (kVar instanceof q) {
                q qVar = (q) kVar;
                eqVar.j(qVar.f);
                this.g = qVar.g;
            }
        }
    }

    protected q(a aVar) {
        super(aVar);
        this.f = aVar.f.g();
        k kVar = aVar.g;
        ar.q(kVar);
        this.g = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.k
    public final /* synthetic */ j a() {
        return new a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.k
    protected final ak b() {
        ak akVarB = super.b();
        akVarB.g("routeIntervals", this.f);
        akVarB.g("previousCameraParameters", this.g);
        return akVarB;
    }
}
