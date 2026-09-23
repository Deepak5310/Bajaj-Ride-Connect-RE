package com.google.android.libraries.navigation.internal.ru;

import android.app.Application;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.navigation.environment.NavApiEnvironmentManager;
import com.google.android.libraries.navigation.environment.av;
import com.google.android.libraries.navigation.environment.ay;
import com.google.android.libraries.navigation.environment.m;
import com.google.android.libraries.navigation.environment.u;
import com.google.android.libraries.navigation.environment.z;
import com.google.android.libraries.navigation.internal.afr.j;
import com.google.android.libraries.navigation.internal.afr.k;
import com.google.android.libraries.navigation.internal.is.h;
import com.google.android.libraries.navigation.internal.iz.n;
import com.google.android.libraries.navigation.internal.lc.aj;
import com.google.android.libraries.navigation.internal.lc.ak;
import com.google.android.libraries.navigation.internal.xo.y;
import com.google.android.libraries.navigation.internal.yr.ai;
import com.google.android.libraries.navigation.internal.yu.f;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zr.Cdo;
import com.google.android.libraries.navigation.internal.zr.dl;
import com.google.android.libraries.navigation.internal.zr.dn;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final Object a = new Object();
    public static d b;
    private static c c;

    public static c a() {
        c cVar;
        d dVar;
        ar.l(b(), "Environment has not been configured. You must call setNavEnvironment() before getOrCreate().");
        c cVar2 = c;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (a) {
            if (c == null && (dVar = b) != null) {
                boolean zA = com.google.android.libraries.navigation.internal.nz.a.a(((ay) dVar).a, ev.r(new com.google.android.libraries.navigation.environment.a(), new z()));
                com.google.android.libraries.navigation.internal.nx.a.b(2);
                Application application = ((ay) dVar).a;
                System.setProperty("org.joda.time.DateTimeZone.Provider", com.google.android.libraries.navigation.internal.ne.c.class.getName());
                com.google.android.libraries.navigation.internal.ne.d.a(application);
                k kVar = u.a;
                com.google.android.libraries.navigation.environment.e eVar = new com.google.android.libraries.navigation.environment.e();
                Application application2 = ((ay) dVar).a;
                j.b(application2);
                eVar.a = application2;
                String packageName = ((ay) dVar).a.getPackageName();
                j.b(packageName);
                eVar.b = packageName;
                j.a(eVar.a, Application.class);
                j.a(eVar.b, String.class);
                final m mVar = new m(eVar.a, eVar.b);
                com.google.android.libraries.navigation.internal.ii.b.a = new com.google.android.libraries.navigation.environment.c(mVar);
                final h hVar = new h(mVar.S(), mVar.h, mVar.p, mVar.x, mVar.o, mVar.J, mVar.i, mVar.G, mVar.s);
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.initialize");
                try {
                    ai aiVarA = f.a();
                    try {
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.initializeClientParametersManager");
                        try {
                            hVar.c.a();
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                            aiVarA.close();
                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.initializeClientParametersUpdaterController");
                            try {
                                hVar.d.a();
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                hVar.e.a();
                                ((n) hVar.e.a()).c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.a
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        h hVar2 = hVar;
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadClearcutController");
                                        try {
                                            hVar2.b.a();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }, hVar.a);
                                ((n) hVar.e.a()).c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.b
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        h hVar2 = hVar;
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadUserEvent3Reporter");
                                        try {
                                            hVar2.i.a();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }, hVar.a);
                                hVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.c
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadGlConstants");
                                        try {
                                            bt.a();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                });
                                hVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.d
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        h hVar2 = hVar;
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadLoginController");
                                        try {
                                            hVar2.g.a();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                });
                                hVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.e
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.populateGcorePlayServicesAvailabilityCache");
                                        try {
                                            int i = com.google.android.libraries.navigation.internal.fs.b.a;
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                });
                                ((n) hVar.e.a()).c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.f
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        h hVar2 = hVar;
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadGlobalStyleTables");
                                        try {
                                            hVar2.f.a();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }, hVar.a);
                                ((n) hVar.e.a()).c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.is.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        h hVar2 = hVar;
                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("PlatformInitializer.preloadResourceManager");
                                        try {
                                            ((com.google.android.libraries.navigation.internal.qy.h) hVar2.h.a()).f();
                                            if (dVarB4 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th) {
                                            if (dVarB4 != null) {
                                                try {
                                                    Trace.endSection();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }, hVar.a);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                int i = aj.a;
                                ak.c();
                                y.e(((ay) dVar).a);
                                final Application application3 = ((ay) dVar).a;
                                mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.as
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        y.a(application3);
                                        com.google.android.libraries.navigation.internal.afw.d.a.a().a();
                                    }
                                });
                                mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.aq
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        mVar.bz().b();
                                    }
                                });
                                com.google.android.libraries.navigation.environment.b.a = new com.google.android.libraries.navigation.environment.b(mVar.a, com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.environment.ar
                                    @Override // com.google.android.libraries.navigation.internal.yx.br
                                    public final Object a() {
                                        return mVar.E();
                                    }
                                }), mVar.bq());
                                final com.google.android.libraries.navigation.environment.b bVar = com.google.android.libraries.navigation.environment.b.a;
                                if (NavApiEnvironmentManager.a) {
                                    mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.au
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            am amVar = mVar;
                                            amVar.bs().b((com.google.android.libraries.navigation.internal.zt.q) ay.a(amVar, true).t());
                                        }
                                    });
                                    final com.google.android.libraries.navigation.internal.ny.b bVarA = com.google.android.libraries.navigation.internal.ny.b.a();
                                    bVarA.c(new av(mVar));
                                    final ay ayVar = (ay) dVar;
                                    com.google.android.libraries.navigation.internal.vq.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.aw
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            bVarA.d(ayVar.a);
                                        }
                                    });
                                }
                                if (zA && NavApiEnvironmentManager.a) {
                                    mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.ap
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            am amVar = mVar;
                                            com.google.android.libraries.navigation.internal.ny.e eVarBs = amVar.bs();
                                            com.google.android.libraries.navigation.internal.zr.x xVar = (com.google.android.libraries.navigation.internal.zr.x) com.google.android.libraries.navigation.internal.zr.aa.a.q();
                                            if (!xVar.b.H()) {
                                                xVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.zr.aa aaVar = (com.google.android.libraries.navigation.internal.zr.aa) xVar.b;
                                            aaVar.b |= 1;
                                            aaVar.c = 2;
                                            int i2 = com.google.android.libraries.navigation.internal.zr.z.c;
                                            if (!xVar.b.H()) {
                                                xVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.zr.aa aaVar2 = (com.google.android.libraries.navigation.internal.zr.aa) xVar.b;
                                            int i3 = i2 - 1;
                                            if (i2 == 0) {
                                                throw null;
                                            }
                                            aaVar2.d = i3;
                                            aaVar2.b |= 2;
                                            com.google.android.libraries.navigation.internal.zr.aa aaVar3 = (com.google.android.libraries.navigation.internal.zr.aa) xVar.t();
                                            com.google.android.libraries.navigation.internal.zr.dj djVar = (com.google.android.libraries.navigation.internal.zr.dj) Cdo.a.q();
                                            int i4 = dn.b;
                                            if (!djVar.b.H()) {
                                                djVar.v();
                                            }
                                            Cdo cdo = (Cdo) djVar.b;
                                            int i5 = i4 - 1;
                                            if (i4 == 0) {
                                                throw null;
                                            }
                                            cdo.c = i5;
                                            cdo.b |= 1;
                                            int i6 = dl.g;
                                            if (!djVar.b.H()) {
                                                djVar.v();
                                            }
                                            Cdo cdo2 = (Cdo) djVar.b;
                                            int i7 = i6 - 1;
                                            if (i6 == 0) {
                                                throw null;
                                            }
                                            cdo2.d = i7;
                                            cdo2.b = 2 | cdo2.b;
                                            if (!djVar.b.H()) {
                                                djVar.v();
                                            }
                                            Cdo cdo3 = (Cdo) djVar.b;
                                            aaVar3.getClass();
                                            cdo3.e = aaVar3;
                                            cdo3.b |= 4;
                                            Cdo cdo4 = (Cdo) djVar.t();
                                            com.google.android.libraries.navigation.internal.zt.i iVarA = ay.a(amVar, true);
                                            if (!iVarA.b.H()) {
                                                iVarA.v();
                                            }
                                            com.google.android.libraries.navigation.internal.zt.q qVar = (com.google.android.libraries.navigation.internal.zt.q) iVarA.b;
                                            com.google.android.libraries.navigation.internal.zt.q qVar2 = com.google.android.libraries.navigation.internal.zt.q.a;
                                            cdo4.getClass();
                                            qVar.i = cdo4;
                                            qVar.c |= 134217728;
                                            eVarBs.c((com.google.android.libraries.navigation.internal.zt.q) iVarA.t());
                                        }
                                    });
                                }
                                mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.at
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        String strA = bVar.a();
                                        if (com.google.android.libraries.navigation.internal.nx.d.c(strA)) {
                                            am amVar = mVar;
                                            amVar.bs().d((com.google.android.libraries.navigation.internal.zt.q) ay.a(amVar, true).t());
                                            com.google.android.libraries.navigation.internal.nx.d.a(strA);
                                        }
                                    }
                                });
                                mVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.ax
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        String strB = bVar.b();
                                        if (new File(strB, "_google_maps_sdk_developer_exception_").exists()) {
                                            am amVar = mVar;
                                            com.google.android.libraries.navigation.internal.ny.e eVarBs = amVar.bs();
                                            com.google.android.libraries.navigation.internal.zt.q qVar = (com.google.android.libraries.navigation.internal.zt.q) ay.a(amVar, true).t();
                                            eVarBs.a.c("SdkDeveloperException").a(0L, 1L, com.google.android.libraries.navigation.internal.ky.ah.a(qVar));
                                            eVarBs.a();
                                            com.google.android.libraries.navigation.internal.ny.e.e(qVar);
                                            com.google.android.libraries.navigation.internal.nx.d.b(strB, "_google_maps_sdk_developer_exception_");
                                        }
                                    }
                                });
                                c = mVar;
                            } catch (Throwable th) {
                                if (dVarB3 != null) {
                                    try {
                                        Trace.endSection();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (dVarB2 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            aiVarA.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th8) {
                            th7.addSuppressed(th8);
                        }
                    }
                    throw th7;
                }
            }
            cVar = c;
        }
        return cVar;
    }

    public static boolean b() {
        return b != null;
    }
}
