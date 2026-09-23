package com.google.android.libraries.navigation.internal.abh;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.lifecycle.Lifecycle;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zr.Cdo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final bc a;
    public final id b;
    public final gf c;
    public final hl d;
    public final hk e;
    public final gu f;
    public final com.google.android.libraries.navigation.internal.abe.f g;
    public final gh h;
    public final com.google.android.libraries.navigation.internal.om.q i;
    public final com.google.android.libraries.navigation.internal.yx.br j;
    public final ExecutorService k;
    public final com.google.android.libraries.navigation.internal.wd.g l;
    public final com.google.android.libraries.navigation.internal.wx.c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f126n;
    private final l o;

    public m(bc bcVar, id idVar, gf gfVar, hl hlVar, hk hkVar, gu guVar, com.google.android.libraries.navigation.internal.abe.f fVar, gh ghVar, l lVar, com.google.android.libraries.navigation.internal.yx.br brVar, ExecutorService executorService, com.google.android.libraries.navigation.internal.wd.g gVar, com.google.android.libraries.navigation.internal.wx.c cVar, boolean z) {
        this.a = bcVar;
        com.google.android.libraries.navigation.internal.abf.s.k(idVar, "versionManager");
        this.b = idVar;
        this.c = gfVar;
        this.e = hkVar;
        this.d = hlVar;
        this.f = guVar;
        this.g = fVar;
        this.h = ghVar;
        this.i = new ei(guVar);
        com.google.android.libraries.navigation.internal.abf.s.k(lVar, "mapsLifecycleOwner");
        this.o = lVar;
        this.j = brVar;
        this.k = executorService;
        this.l = gVar;
        this.m = cVar;
        this.f126n = z;
    }

    public static m c(final Context context, final id idVar, gh ghVar, final i iVar, com.google.android.libraries.navigation.internal.wd.g gVar, com.google.android.libraries.navigation.internal.wx.c cVar) {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        final com.google.android.libraries.navigation.internal.yx.br brVar;
        l lVar;
        com.google.android.libraries.navigation.internal.wd.g icVar;
        com.google.android.libraries.navigation.internal.abf.s.k(context, "clientApplicationContext");
        com.google.android.libraries.navigation.internal.abf.s.k(idVar, "versionManager");
        com.google.android.libraries.navigation.internal.abf.s.d(com.google.android.libraries.navigation.internal.abf.r.a(context, context.getApplicationContext()), "The provided context is not an application context");
        com.google.android.libraries.navigation.internal.abf.ah.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.e
            @Override // java.lang.Runnable
            public final void run() {
                int i = com.google.android.libraries.navigation.internal.abf.o.b;
                com.google.android.libraries.navigation.internal.abf.p.a = true;
            }
        });
        bp.a(context);
        com.google.android.libraries.navigation.internal.afu.d.o();
        final boolean zA = com.google.android.libraries.navigation.internal.nz.a.a(context, com.google.android.libraries.navigation.internal.yz.ev.q(new com.google.android.libraries.navigation.internal.abk.a()));
        Locale locale = Locale.getDefault();
        Pattern pattern = com.google.android.libraries.navigation.internal.abf.m.a;
        com.google.android.libraries.navigation.internal.abf.l lVar2 = new com.google.android.libraries.navigation.internal.abf.l();
        Matcher matcher = com.google.android.libraries.navigation.internal.abf.m.a.matcher(locale.toString());
        if (matcher.matches()) {
            lVar2.a = matcher.group(1);
            lVar2.b = matcher.group(3);
            if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                lVar2.c = matcher.group(2);
            }
        } else {
            lVar2.a = locale.getLanguage();
            if (!locale.getCountry().isEmpty()) {
                lVar2.c = locale.getCountry();
            }
        }
        if (lVar2.a.equals("en")) {
            String str = lVar2.c;
            if (str.equals("AU") || str.equals("NZ")) {
                lVar2.c = "GB";
            }
        }
        com.google.android.libraries.navigation.internal.abf.e.k = lVar2.toString();
        com.google.android.libraries.navigation.internal.abf.e.f = context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        com.google.android.libraries.navigation.internal.abf.e.g = displayMetrics.densityDpi;
        com.google.android.libraries.navigation.internal.abf.e.h = displayMetrics.density;
        float f = com.google.android.libraries.navigation.internal.abf.e.g;
        if (Math.abs(displayMetrics.xdpi - f) / f > 0.25d || Math.abs(displayMetrics.ydpi - f) / f > 0.25d) {
            com.google.android.libraries.navigation.internal.abf.e.i = f;
            com.google.android.libraries.navigation.internal.abf.e.j = f;
        } else {
            com.google.android.libraries.navigation.internal.abf.e.i = displayMetrics.xdpi;
            com.google.android.libraries.navigation.internal.abf.e.j = displayMetrics.ydpi;
        }
        com.google.android.libraries.navigation.internal.abf.e.a = Math.hypot((double) (((float) displayMetrics.widthPixels) / com.google.android.libraries.navigation.internal.abf.e.i), (double) (((float) displayMetrics.heightPixels) / com.google.android.libraries.navigation.internal.abf.e.j)) >= 7.0d;
        com.google.android.libraries.navigation.internal.abf.e.b = context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager != null) {
            com.google.android.libraries.navigation.internal.abf.e.c = uiModeManager.getCurrentModeType() == 3;
            com.google.android.libraries.navigation.internal.abf.e.d = uiModeManager.getCurrentModeType() == 4;
            com.google.android.libraries.navigation.internal.abf.e.e = Build.VERSION.SDK_INT >= 26 && uiModeManager.getCurrentModeType() == 7;
        }
        final ScheduledExecutorService scheduledExecutorServiceE = com.google.android.libraries.navigation.internal.abf.ah.e("lses");
        String packageName = context.getPackageName();
        ScheduledExecutorService scheduledExecutorServiceE2 = com.google.android.libraries.navigation.internal.abf.ah.e("appenvironment");
        int i = com.google.android.libraries.navigation.internal.abe.f.k;
        com.google.android.libraries.navigation.internal.abf.a aVar = com.google.android.libraries.navigation.internal.abf.a.a;
        Random random = new Random();
        String strB = com.google.android.libraries.navigation.internal.abf.d.a.b(context, packageName);
        com.google.android.libraries.navigation.internal.abe.f fVar = new com.google.android.libraries.navigation.internal.abe.f(context, strB, aVar, random, scheduledExecutorServiceE2, new com.google.android.libraries.navigation.internal.abe.i(context), new com.google.android.libraries.navigation.internal.abe.c(context, strB, packageName), com.google.android.libraries.navigation.internal.abf.ah.a());
        com.google.android.libraries.navigation.internal.wc.b bVarA = com.google.android.libraries.navigation.internal.wc.b.a();
        bc bcVar = new bc(context, idVar, fVar, bVarA, cVar);
        com.google.android.libraries.navigation.internal.yx.br brVar2 = bcVar.b;
        com.google.android.libraries.navigation.internal.abf.s.k(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String string = (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("com.google.android.gms.maps.API_OPTIONS")) ? null : applicationInfo.metaData.getString("com.google.android.gms.maps.API_OPTIONS");
            if (string == null) {
                evVarO = lv.a;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str2 : com.google.android.libraries.navigation.internal.yx.bj.b(',').g(string)) {
                    if (arrayList.size() == 10) {
                        com.google.android.libraries.navigation.internal.abf.p.c(String.format("Maximum number of API options exceeded. Only using the first %s options.", 10));
                        break;
                    }
                    if (str2.matches("^[A-Z0-9]{14}$")) {
                        arrayList.add(str2);
                    } else {
                        com.google.android.libraries.navigation.internal.abf.p.c(String.format("Ignoring invalid API option: %s.", str2));
                    }
                }
                com.google.android.libraries.navigation.internal.abf.p.f(bk.a, 3);
                evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(arrayList);
            }
            final gu guVar = new gu(context, brVar2, new bk(evVarO), com.google.android.libraries.navigation.internal.abg.x.b, Executors.newSingleThreadScheduledExecutor(), com.google.android.libraries.navigation.internal.abf.ah.c, idVar);
            Application applicationA = com.google.android.libraries.navigation.internal.abf.b.a(context);
            com.google.android.libraries.navigation.internal.yx.bv bvVar = new com.google.android.libraries.navigation.internal.yx.bv(null);
            if (applicationA != null) {
                l lVar3 = new l();
                final com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abh.f
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        Context context2 = context;
                        ht.e(context2);
                        com.google.android.libraries.navigation.internal.ky.o oVarA = ds.a(context2, "GMM_REALTIME_COUNTERS");
                        if (oVarA == null) {
                            return null;
                        }
                        ExecutorService executorService = scheduledExecutorServiceE;
                        final gu guVar2 = guVar;
                        oVarA.g(new com.google.android.libraries.navigation.internal.ky.m() { // from class: com.google.android.libraries.navigation.internal.abh.dr
                            @Override // com.google.android.libraries.navigation.internal.ky.m
                            public final com.google.android.libraries.navigation.internal.ky.n a(com.google.android.libraries.navigation.internal.ky.n nVar) {
                                gu guVar3 = guVar2;
                                return (com.google.android.libraries.navigation.internal.ky.n) nVar.a(guVar3.k == null ? new int[0] : com.google.android.libraries.navigation.internal.zy.i.f(guVar3.k.h));
                            }
                        });
                        return new ia(context2, ds.a, executorService, oVarA);
                    }
                });
                applicationA.registerComponentCallbacks(new h(lVar3));
                com.google.android.libraries.navigation.internal.abf.ah.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.g
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
                lVar3.c = brVarA;
                int i2 = bi.b;
                com.google.android.libraries.navigation.internal.zr.ds dsVar = bVarA != null ? bVarA.a : null;
                final com.google.android.libraries.navigation.internal.zr.ds dsVar2 = dsVar;
                brVar = brVarA;
                scheduledExecutorServiceE.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.bf
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = bi.b;
                        com.google.android.libraries.navigation.internal.yx.br brVar3 = brVarA;
                        if (brVar3.a() != null) {
                            Context context2 = context;
                            com.google.android.libraries.navigation.internal.zr.ds dsVar3 = dsVar2;
                            gu guVar2 = guVar;
                            com.google.android.libraries.navigation.internal.ny.e eVar = (com.google.android.libraries.navigation.internal.ny.e) brVar3.a();
                            com.google.android.libraries.navigation.internal.zt.i iVarC = bx.c(guVar2, dsVar3, context2.getPackageName());
                            if (eVar.g == null) {
                                eVar.g = eVar.f.getSharedPreferences("GeoMonitoringSharedPref", 0);
                                eVar.h = eVar.g.getLong("InitializedEventPreviousEventMsPrefKey", -1L);
                            }
                            long j = eVar.h;
                            if (j != -1) {
                                if (!iVarC.b.H()) {
                                    iVarC.v();
                                }
                                com.google.android.libraries.navigation.internal.zt.q qVar = (com.google.android.libraries.navigation.internal.zt.q) iVarC.b;
                                com.google.android.libraries.navigation.internal.zt.q qVar2 = com.google.android.libraries.navigation.internal.zt.q.a;
                                qVar.c |= 268435456;
                                qVar.j = j;
                            }
                            boolean z = zA;
                            eVar.h = eVar.e.f().toEpochMilli();
                            eVar.b((com.google.android.libraries.navigation.internal.zt.q) iVarC.t());
                            if (z) {
                                com.google.android.libraries.navigation.internal.ny.e eVar2 = (com.google.android.libraries.navigation.internal.ny.e) brVar3.a();
                                String packageName2 = context2.getPackageName();
                                int iB = (int) com.google.android.libraries.navigation.internal.afu.a.b();
                                com.google.android.libraries.navigation.internal.zr.x xVar = (com.google.android.libraries.navigation.internal.zr.x) com.google.android.libraries.navigation.internal.zr.aa.a.q();
                                if (!xVar.b.H()) {
                                    xVar.v();
                                }
                                com.google.android.libraries.navigation.internal.zr.aa aaVar = (com.google.android.libraries.navigation.internal.zr.aa) xVar.b;
                                aaVar.b |= 1;
                                aaVar.c = iB;
                                int i4 = com.google.android.libraries.navigation.internal.zr.z.c;
                                if (!xVar.b.H()) {
                                    xVar.v();
                                }
                                com.google.android.libraries.navigation.internal.zr.aa aaVar2 = (com.google.android.libraries.navigation.internal.zr.aa) xVar.b;
                                int i5 = i4 - 1;
                                if (i4 == 0) {
                                    throw null;
                                }
                                aaVar2.d = i5;
                                aaVar2.b |= 2;
                                com.google.android.libraries.navigation.internal.zr.aa aaVar3 = (com.google.android.libraries.navigation.internal.zr.aa) xVar.t();
                                com.google.android.libraries.navigation.internal.zr.dj djVar = (com.google.android.libraries.navigation.internal.zr.dj) Cdo.a.q();
                                int i6 = com.google.android.libraries.navigation.internal.zr.dn.b;
                                if (!djVar.b.H()) {
                                    djVar.v();
                                }
                                Cdo cdo = (Cdo) djVar.b;
                                int i7 = i6 - 1;
                                if (i6 == 0) {
                                    throw null;
                                }
                                cdo.c = i7;
                                cdo.b |= 1;
                                int i8 = com.google.android.libraries.navigation.internal.zr.dl.g;
                                if (!djVar.b.H()) {
                                    djVar.v();
                                }
                                Cdo cdo2 = (Cdo) djVar.b;
                                int i9 = i8 - 1;
                                if (i8 == 0) {
                                    throw null;
                                }
                                cdo2.d = i9;
                                cdo2.b |= 2;
                                if (!djVar.b.H()) {
                                    djVar.v();
                                }
                                Cdo cdo3 = (Cdo) djVar.b;
                                aaVar3.getClass();
                                cdo3.e = aaVar3;
                                cdo3.b |= 4;
                                Cdo cdo4 = (Cdo) djVar.t();
                                com.google.android.libraries.navigation.internal.zt.i iVarC2 = bx.c(guVar2, dsVar3, packageName2);
                                if (!iVarC2.b.H()) {
                                    iVarC2.v();
                                }
                                com.google.android.libraries.navigation.internal.zt.q qVar3 = (com.google.android.libraries.navigation.internal.zt.q) iVarC2.b;
                                com.google.android.libraries.navigation.internal.zt.q qVar4 = com.google.android.libraries.navigation.internal.zt.q.a;
                                cdo4.getClass();
                                qVar3.i = cdo4;
                                qVar3.c |= 134217728;
                                eVar2.c((com.google.android.libraries.navigation.internal.zt.q) iVarC2.t());
                            }
                        }
                    }
                });
                final String absolutePath = context.getFilesDir().getAbsolutePath();
                if (com.google.android.libraries.navigation.internal.nx.d.c(absolutePath)) {
                    final com.google.android.libraries.navigation.internal.zr.ds dsVar3 = dsVar;
                    scheduledExecutorServiceE.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.bg
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = bi.b;
                            com.google.android.libraries.navigation.internal.yx.br brVar3 = brVar;
                            if (brVar3.a() != null) {
                                String str3 = absolutePath;
                                Context context2 = context;
                                com.google.android.libraries.navigation.internal.zr.ds dsVar4 = dsVar3;
                                ((com.google.android.libraries.navigation.internal.ny.e) brVar3.a()).d(bx.b(guVar, dsVar4, context2.getPackageName()));
                                com.google.android.libraries.navigation.internal.nx.d.a(str3);
                            }
                        }
                    });
                }
                com.google.android.libraries.navigation.internal.afu.ae.e();
                lVar = lVar3;
            } else {
                brVar = bvVar;
                lVar = null;
            }
            bi.a = context;
            com.google.android.libraries.navigation.internal.abf.s.k(context, "context");
            com.google.android.libraries.navigation.internal.abf.s.k(brVar2, "drd");
            gf gfVar = new gf(brVar2, new gd(brVar2), new com.google.android.libraries.navigation.internal.abf.h(context.getApplicationContext(), "com.google.android.gms.maps._m_u", (com.google.android.libraries.navigation.internal.ael.dg) com.google.android.libraries.navigation.internal.afm.f.a.aH(7, null)));
            hl hlVar = new hl(gfVar, com.google.android.libraries.navigation.internal.abf.a.a, com.google.android.libraries.navigation.internal.abf.z.a);
            hk hkVar = new hk(brVar2);
            gfVar.e(com.google.android.libraries.navigation.internal.afm.d.STREETVIEW_CREATE_DYNAMIC, hkVar);
            if (gVar == null) {
                com.google.android.libraries.navigation.internal.ky.l lVarE = com.google.android.libraries.navigation.internal.ky.o.e(context, "MAPS_API");
                lVarE.f = eo.a;
                icVar = new ic(context, lVarE.d(), cVar);
            } else {
                icVar = gVar;
            }
            int i3 = l.e;
            lVar.d = icVar;
            return new m(bcVar, idVar, gfVar, hlVar, hkVar, guVar, fVar, ghVar, lVar, brVar, scheduledExecutorServiceE, icVar, cVar, zA && com.google.android.libraries.navigation.internal.afu.a.a.a().c());
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public final void a() {
        int i;
        l lVar = this.o;
        synchronized (lVar) {
            i = lVar.b - 1;
            lVar.b = i;
        }
        if (i == 0) {
            lVar.a();
        }
    }

    public final void b() {
        int i;
        final l lVar = this.o;
        synchronized (lVar) {
            i = lVar.b;
            lVar.b = i + 1;
        }
        if (i == 0) {
            com.google.android.libraries.navigation.internal.abf.ah.a().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.j
                @Override // java.lang.Runnable
                public final void run() {
                    lVar.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                }
            });
        }
        this.l.e();
    }
}
