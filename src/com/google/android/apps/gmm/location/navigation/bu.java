package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.zr.dx;
import com.google.android.libraries.navigation.internal.zr.ea;
import com.google.android.libraries.navigation.internal.zr.eb;
import com.google.android.libraries.navigation.internal.zr.ec;
import com.google.android.libraries.navigation.internal.zr.ed;
import com.google.android.libraries.navigation.internal.zr.ee;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class bu {
    private static final com.google.android.libraries.navigation.internal.zb.j j = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.bu");
    public final float a;
    public final float b;
    public final long c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.rw.f e;
    public final com.google.android.libraries.navigation.internal.rw.q f;
    public final Executor g;
    public final bs h = new bs(this);
    public final SnappingTracerJni i = new SnappingTracerJni();
    private final bt k;

    public bu(float f, float f2, bt btVar, long j2, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.rw.q qVar, Executor executor) {
        this.a = f;
        this.b = f2;
        this.k = btVar;
        this.c = j2;
        this.d = aVar;
        this.e = fVar;
        this.f = qVar;
        this.g = executor;
    }

    private static dx k(byte[] bArr) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        try {
            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(dx.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
            return (dx) biVarV;
        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) j.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 287)).p("Failed to parse SnappingTrace.");
            return null;
        }
    }

    public final long a() {
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni == null) {
            return 0L;
        }
        if (snappingTracerJni.c()) {
            return snappingTracerJni.c;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 288)).p("SnappingTracerJni called getNativeSnappingTracerPtr() when stopped");
        return 0L;
    }

    public final void b() {
        dx dxVarK;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni == null) {
            return;
        }
        byte[] bArr = null;
        if (snappingTracerJni.c()) {
            byte[] bArrNativeFlush = snappingTracerJni.nativeFlush(snappingTracerJni.c);
            if (bArrNativeFlush.length > 0) {
                bArr = bArrNativeFlush;
            }
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 302)).p("SnappingTracerJni called flush() when stopped");
        }
        if (bArr == null || (dxVarK = k(bArr)) == null) {
            return;
        }
        this.k.a(dxVarK);
    }

    public final void c() {
        dx dxVarK;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni == null) {
            return;
        }
        long jA = this.d.a();
        byte[] bArr = null;
        if (snappingTracerJni.c()) {
            byte[] bArrNativeMaybeFlush = snappingTracerJni.nativeMaybeFlush(snappingTracerJni.c, jA);
            if (bArrNativeMaybeFlush.length > 0) {
                bArr = bArrNativeMaybeFlush;
            }
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 303)).p("SnappingTracerJni called maybeFlush() when stopped");
        }
        if (bArr == null || (dxVarK = k(bArr)) == null) {
            return;
        }
        this.k.a(dxVarK);
    }

    public final void d(com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni != null) {
            double d = rVar.b;
            double d2 = rVar.c;
            float f = rVar.r() ? rVar.d : Float.NaN;
            float f2 = rVar.x() ? rVar.f : Float.NaN;
            float f3 = rVar.t() ? rVar.f() : Float.NaN;
            String str = rVar.a;
            long jA = com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
            if (snappingTracerJni.c()) {
                snappingTracerJni.nativeOnRawLocation(snappingTracerJni.c, d, d2, f, f2, f3, str, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 296)).p("SnappingTracerJni called onRawLocation() when stopped");
            }
        }
    }

    public final void e() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni != null) {
            long jA = this.d.a();
            if (snappingTracerJni.c()) {
                snappingTracerJni.nativeOnRawLocationTimeout(snappingTracerJni.c, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 297)).p("SnappingTracerJni called onRawLocationTimeout() when stopped");
            }
        }
    }

    public final void g(com.google.android.libraries.navigation.internal.sm.d dVar) {
        if (this.i == null) {
            return;
        }
        ed edVar = (ed) ee.a.q();
        com.google.android.libraries.navigation.internal.aap.l lVar = dVar.a.d;
        if (!edVar.b.H()) {
            edVar.v();
        }
        ee eeVar = (ee) edVar.b;
        eeVar.c = lVar.F;
        eeVar.b |= 1;
        hu huVar = dVar.a.f;
        if (!edVar.b.H()) {
            edVar.v();
        }
        ee eeVar2 = (ee) edVar.b;
        eeVar2.d = huVar.j;
        eeVar2.b |= 2;
        hs hsVar = dVar.a.e;
        if (!edVar.b.H()) {
            edVar.v();
        }
        ee eeVar3 = (ee) edVar.b;
        eeVar3.e = hsVar.d;
        eeVar3.b |= 4;
        String str = dVar.b;
        if (str != null) {
            if (dVar.a.d != com.google.android.libraries.navigation.internal.aap.l.DESTINATION) {
                if (!edVar.b.H()) {
                    edVar.v();
                }
                ee eeVar4 = (ee) edVar.b;
                eeVar4.b |= 8;
                eeVar4.f = str;
            } else {
                if (!edVar.b.H()) {
                    edVar.v();
                }
                ee eeVar5 = (ee) edVar.b;
                eeVar5.b |= 16;
                eeVar5.g = true;
            }
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = dVar.a.c;
        SnappingTracerJni snappingTracerJni = this.i;
        byte[] bArrM = ((ee) edVar.t()).m();
        com.google.android.libraries.navigation.internal.mj.a aVar = this.d;
        double dB = xVar.b();
        double d = xVar.d();
        long jA = aVar.a();
        if (snappingTracerJni.c()) {
            snappingTracerJni.nativeOnGuidanceAlertQueued(snappingTracerJni.c, bArrM, dB, d, jA);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 293)).p("SnappingTracerJni called onGuidanceAlertQueued() when stopped");
        }
    }

    public final void h(com.google.android.libraries.navigation.internal.sm.e eVar) {
        if (this.i == null) {
            return;
        }
        int i = (int) eVar.a;
        eb ebVar = (eb) ec.a.q();
        if (i != -1) {
            if (!ebVar.b.H()) {
                ebVar.v();
            }
            ec ecVar = (ec) ebVar.b;
            ecVar.b |= 1;
            ecVar.c = i;
        }
        SnappingTracerJni snappingTracerJni = this.i;
        byte[] bArrM = ((ec) ebVar.t()).m();
        long jA = this.d.a();
        if (snappingTracerJni.c()) {
            snappingTracerJni.nativeOnGuidanceAlertStarted(snappingTracerJni.c, bArrM, jA);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 294)).p("SnappingTracerJni called onGuidanceAlertStarted() when stopped");
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.tl.b bVar) {
        SnappingTracerJni snappingTracerJni = this.i;
        if (snappingTracerJni != null) {
            boolean z = bVar.c;
            long jA = this.d.a();
            if (snappingTracerJni.c()) {
                snappingTracerJni.nativeOnForegroundnessChanged(snappingTracerJni.c, z, jA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 290)).p("SnappingTracerJni called onForegroundnessChanged() when stopped");
            }
        }
    }

    public final void j() {
        if (this.i == null) {
            return;
        }
        throw null;
    }

    public final void f(com.google.android.libraries.navigation.internal.sm.c cVar) {
        if (this.i == null) {
            return;
        }
        int i = cVar.d;
        int i2 = i - 1;
        int i3 = ea.a;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            i3 = ea.b;
        } else if (i2 == 1) {
            i3 = ea.c;
        } else if (i2 == 2) {
            i3 = ea.d;
        } else if (i2 == 3) {
            i3 = ea.e;
        }
        SnappingTracerJni snappingTracerJni = this.i;
        long jA = this.d.a();
        if (!snappingTracerJni.c()) {
            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 292)).p("SnappingTracerJni called onGuidanceAlertEnded() when stopped");
            return;
        }
        long j2 = snappingTracerJni.c;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        snappingTracerJni.nativeOnGuidanceAlertEnded(j2, i4, jA);
    }
}
