package com.google.android.apps.gmm.location.navigation;

import android.hardware.GeomagneticField;
import androidx.core.os.EnvironmentCompat;
import androidx.work.PeriodicWorkRequest;
import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.agi.cu;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class s {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.s");
    bg a;
    private final com.google.android.libraries.navigation.internal.fz.d c;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final com.google.android.libraries.navigation.internal.ia.e e;
    private final com.google.android.libraries.navigation.internal.ia.b f;
    private final com.google.android.libraries.navigation.internal.kl.a g;
    private float i;
    private long j;
    private long k = 0;
    private final cu l = new cu();
    private final InertialsMonitorJni h = new InertialsMonitorJni();

    public s(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ia.b bVar, com.google.android.libraries.navigation.internal.kl.a aVar2, com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.d = aVar;
        this.e = eVar;
        this.f = bVar;
        this.g = aVar2;
        this.c = dVar;
    }

    final com.google.android.libraries.navigation.internal.cy.a a(byte[] bArr) {
        if (bArr != null) {
            try {
                com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.acu.z.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                com.google.android.libraries.navigation.internal.acu.z zVar = (com.google.android.libraries.navigation.internal.acu.z) biVarV;
                bg bgVar = this.a;
                if (bgVar != null && (zVar.b & 2) != 0) {
                    com.google.android.libraries.navigation.internal.acu.ay ayVar = zVar.f;
                    if (ayVar == null) {
                        ayVar = com.google.android.libraries.navigation.internal.acu.ay.a;
                    }
                    Iterator it2 = ayVar.b.iterator();
                    while (it2.hasNext()) {
                        bgVar.c((com.google.android.libraries.navigation.internal.acu.aw) it2.next());
                    }
                }
                w.c(this.g, zVar.d);
                w.d(this.e, zVar.e, this.l, this.d.a());
                if ((zVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.acu.h hVar = zVar.c;
                    if (hVar == null) {
                        hVar = com.google.android.libraries.navigation.internal.acu.h.a;
                    }
                    int i = hVar.b;
                    if ((i & 1) != 0 && (i & 2) != 0 && (i & 4) != 0 && (i & 8) != 0 && (i & 16) != 0) {
                        com.google.android.libraries.navigation.internal.db.g gVar = (com.google.android.libraries.navigation.internal.db.g) com.google.android.libraries.navigation.internal.db.j.a.q();
                        long j = hVar.c;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        jVar.b |= 1;
                        jVar.c = j;
                        float f = hVar.d;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar2 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        jVar2.b |= 2;
                        jVar2.d = f;
                        float f2 = hVar.e;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar3 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        jVar3.b |= 4;
                        jVar3.e = f2;
                        float f3 = hVar.f;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar4 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        jVar4.b |= 8;
                        jVar4.f = f3;
                        boolean z = hVar.g;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar5 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        jVar5.b |= 16;
                        jVar5.g = z;
                        int i2 = com.google.android.libraries.navigation.internal.db.i.c;
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.db.j jVar6 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                        int i3 = i2 - 1;
                        if (i2 == 0) {
                            throw null;
                        }
                        jVar6.i = i3;
                        jVar6.b |= 64;
                        if ((hVar.b & 32) != 0) {
                            com.google.android.libraries.navigation.internal.acu.bm bmVar = hVar.h;
                            if (bmVar == null) {
                                bmVar = com.google.android.libraries.navigation.internal.acu.bm.a;
                            }
                            com.google.android.libraries.navigation.internal.afj.c cVar = (com.google.android.libraries.navigation.internal.afj.c) com.google.android.libraries.navigation.internal.afj.d.a.q();
                            double d = bmVar.b;
                            if (!cVar.b.H()) {
                                cVar.v();
                            }
                            ((com.google.android.libraries.navigation.internal.afj.d) cVar.b).b = d;
                            double d2 = bmVar.c;
                            if (!cVar.b.H()) {
                                cVar.v();
                            }
                            ((com.google.android.libraries.navigation.internal.afj.d) cVar.b).c = d2;
                            double d3 = bmVar.d;
                            if (!cVar.b.H()) {
                                cVar.v();
                            }
                            ((com.google.android.libraries.navigation.internal.afj.d) cVar.b).d = d3;
                            double d4 = bmVar.e;
                            if (!cVar.b.H()) {
                                cVar.v();
                            }
                            ((com.google.android.libraries.navigation.internal.afj.d) cVar.b).e = d4;
                            com.google.android.libraries.navigation.internal.afj.d dVar = (com.google.android.libraries.navigation.internal.afj.d) cVar.t();
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            com.google.android.libraries.navigation.internal.db.j jVar7 = (com.google.android.libraries.navigation.internal.db.j) gVar.b;
                            dVar.getClass();
                            jVar7.h = dVar;
                            jVar7.b |= 32;
                        }
                        return new com.google.android.libraries.navigation.internal.cy.a((com.google.android.libraries.navigation.internal.db.j) gVar.t());
                    }
                }
            } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 204)).p("Failed to parse InertialsMonitorResultProto.");
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(com.google.android.libraries.navigation.internal.db.q qVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (qVar.c().b && com.google.android.libraries.navigation.internal.ja.a.a(qVar.g()) - this.j > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            GeomagneticField geomagneticField = new GeomagneticField((float) qVar.b, (float) qVar.c, 0.0f, this.d.f().toEpochMilli());
            this.j = com.google.android.libraries.navigation.internal.ja.a.a(qVar.g());
            this.i = geomagneticField.getHorizontalStrength() / 1000.0f;
        }
        long jA = this.d.a();
        float f = this.i;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        com.google.android.libraries.navigation.internal.cy.a aVarA = null;
        byte[] bArrNativeOnLocation = null;
        if (this.h.b()) {
            com.google.android.libraries.navigation.internal.oe.x xVarF = qVar.f();
            String str = (String) com.google.android.libraries.navigation.internal.yx.al.c(qVar.a, EnvironmentCompat.MEDIA_UNKNOWN);
            InertialsMonitorJni inertialsMonitorJni = this.h;
            long jA2 = com.google.android.libraries.navigation.internal.ja.a.a(qVar.g());
            int i = xVarF.a;
            int i2 = xVarF.b;
            float f2 = qVar.h() ? qVar.d : Float.NaN;
            float f3 = qVar.m() ? qVar.i : Float.NaN;
            float f4 = qVar.n() ? qVar.j : Float.NaN;
            float f5 = qVar.i() ? qVar.g : Float.NaN;
            float f6 = qVar.j() ? qVar.h : Float.NaN;
            if (inertialsMonitorJni.b()) {
                bArrNativeOnLocation = inertialsMonitorJni.nativeOnLocation(inertialsMonitorJni.c, jA, jA2, str, i, i2, f2, f3, f4, f5, f6, f);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 213)).p("InertialsMonitorJni called onLocation() when stopped");
            }
            aVarA = a(bArrNativeOnLocation);
        }
        if (aVarA != null) {
            this.e.a(aVarA);
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.dh.p pVar) {
        byte[] bArrNativeOnWheelSpeed;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (this.h.b()) {
            InertialsMonitorJni inertialsMonitorJni = this.h;
            long j = pVar.a;
            float f = pVar.b;
            if (inertialsMonitorJni.b()) {
                bArrNativeOnWheelSpeed = inertialsMonitorJni.nativeOnWheelSpeed(inertialsMonitorJni.c, 0L, 0.0f);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 214)).p("InertialsMonitorJni called onWheelSpeed() when stopped");
                bArrNativeOnWheelSpeed = null;
            }
            a(bArrNativeOnWheelSpeed);
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.db.s sVar) {
        com.google.android.libraries.navigation.internal.db.r rVarD = sVar.d();
        if (rVarD == null) {
            return;
        }
        InertialsMonitorJni inertialsMonitorJni = this.h;
        long jA = com.google.android.libraries.navigation.internal.ja.a.a(rVarD.g);
        double d = rVarD.s() ? rVarD.e : Double.NaN;
        double dI = rVarD.A() ? rVarD.i() : Double.POSITIVE_INFINITY;
        boolean z = rVarD.l().h;
        boolean z2 = !rVarD.l().c();
        if (!inertialsMonitorJni.b()) {
            ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 208)).p("InertialsMonitorJni called onSnappedLocation() when stopped");
        } else {
            inertialsMonitorJni.nativeOnSnappedLocation(inertialsMonitorJni.c, jA, rVarD.b, rVarD.c, d, dI, z, z2);
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.dh.ad adVar) {
        byte[] bArrNativeOnInertialsSummary;
        com.google.android.libraries.navigation.internal.cy.a aVarA;
        r rVar;
        this = this;
        long jA = this.d.a();
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        byte[] bArrNativeGetInertialState = null;
        if (this.h.b()) {
            InertialsMonitorJni inertialsMonitorJni = this.h;
            long j = adVar.a;
            long j2 = adVar.b;
            float f = adVar.c;
            float f2 = adVar.d;
            float f3 = adVar.e;
            float f4 = adVar.f;
            boolean z = adVar.g;
            float f5 = adVar.h;
            float f6 = adVar.i;
            float f7 = adVar.j;
            float f8 = adVar.k;
            float f9 = adVar.l;
            float f10 = adVar.m;
            float f11 = adVar.p;
            float f12 = adVar.f394n;
            float f13 = adVar.o;
            if (inertialsMonitorJni.b()) {
                bArrNativeOnInertialsSummary = inertialsMonitorJni.nativeOnInertialsSummary(inertialsMonitorJni.c, jA, j, j2, f, f2, f3, f4, z, f5, f6, f7, f8, f9, f10, f11, f12, f13);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 212)).p("InertialsMonitorJni called onInertialsSummary() when stopped");
                bArrNativeOnInertialsSummary = null;
            }
            aVarA = a(bArrNativeOnInertialsSummary);
        } else {
            jA = jA;
            aVarA = null;
        }
        if (aVarA != null) {
            this.e.a(aVarA);
        }
        if (this.f.e()) {
            long j3 = jA;
            if (j3 - this.k > 120000) {
                this.k = j3;
                com.google.android.libraries.navigation.internal.ia.b bVar = this.f;
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                if (this.h.b()) {
                    InertialsMonitorJni inertialsMonitorJni2 = this.h;
                    if (inertialsMonitorJni2.b()) {
                        bArrNativeGetInertialState = inertialsMonitorJni2.nativeGetInertialState(inertialsMonitorJni2.c);
                    } else {
                        ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 211)).p("InertialsMonitorJni called getInertialState() when stopped");
                    }
                    byte[] bArr = bArrNativeGetInertialState;
                    if (bArr == null) {
                        rVar = r.a;
                    } else {
                        try {
                            com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(r.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                            com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                            rVar = (r) biVarV;
                        } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 205)).p("Failed to parse InertialState.");
                            rVar = r.a;
                        }
                    }
                } else {
                    rVar = r.a;
                }
                bVar.c(new com.google.android.libraries.navigation.internal.fw.t("com.google.android.apps.gmm.location.navigation.InertialState", rVar, true));
            }
        }
    }

    public final void f(r rVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        byte[] bArrM = rVar == null ? r.a.m() : rVar.m();
        InertialsMonitorJni inertialsMonitorJni = this.h;
        boolean z = this.c.b().a.aP;
        if (inertialsMonitorJni.b()) {
            ((com.google.android.libraries.navigation.internal.zb.h) InertialsMonitorJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 209)).p("InertialsMonitorJni called onStart() when started");
        } else {
            NativeHelper.b(InertialsMonitorJni.b);
            inertialsMonitorJni.c = InertialsMonitorJni.nativeCreateInertialsMonitor(bArrM, false, z);
        }
        this.k = this.d.a();
    }

    public final void g() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.h.a();
    }

    public final void h(bg bgVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.a = bgVar;
    }

    public final void i() {
        throw null;
    }
}
