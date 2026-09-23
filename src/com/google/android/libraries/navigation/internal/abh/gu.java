package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.android.datatransport.BuildConfig;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.yz.mp;
import com.google.android.libraries.navigation.internal.yz.mq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gu {
    public static final String a = "gu";
    public static final String[] b = {"DATA_ServerControlledParametersManager.data"};
    public static final ScheduledExecutorService c = com.google.android.libraries.navigation.internal.abf.ah.e("scpm");
    private static final List w;
    private final com.google.android.libraries.navigation.internal.yx.br A;
    private final com.google.android.libraries.navigation.internal.abf.ah D;
    public volatile ArrayList d;
    public volatile boolean g;
    public volatile String h;
    public volatile com.google.android.libraries.navigation.internal.adi.aj i;
    public volatile List j;
    public volatile com.google.android.libraries.navigation.internal.afl.ea k;
    public final Context r;
    public gq s;
    public final com.google.android.libraries.navigation.internal.yx.br t;
    public final com.google.android.libraries.navigation.internal.yx.br u;
    public com.google.android.libraries.navigation.internal.afl.am v;
    private volatile boolean y;
    public volatile HashMap e = new HashMap();
    private volatile HashMap x = new HashMap();
    public volatile HashMap f = new HashMap();
    public volatile ScheduledFuture l = null;
    public volatile boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f124n = false;
    public final Object o = new Object();
    public boolean p = false;
    public boolean q = false;
    private boolean z = false;
    private final List B = new ArrayList();
    private final Set C = new HashSet();

    static {
        ArrayList arrayList = new ArrayList();
        w = arrayList;
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.PREFETCHER_SETTINGS);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.VECTOR_MAPS);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.API);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.PAINT_PARAMETERS);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.IMAGERY_VIEWER);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.TILE_ZOOM_PROGRESSION);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.MAPS_API_PARAMETERS);
        arrayList.add(com.google.android.libraries.navigation.internal.afl.ha.LOGGING);
    }

    public gu(final Context context, com.google.android.libraries.navigation.internal.yx.br brVar, final bk bkVar, final com.google.android.libraries.navigation.internal.abg.x xVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.abf.ah ahVar, final id idVar) {
        new ConcurrentHashMap();
        mp.i();
        com.google.android.libraries.navigation.internal.abf.s.k(context, "clientApplicationContext");
        this.r = context;
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "dispatcher");
        this.A = brVar;
        com.google.android.libraries.navigation.internal.abf.s.k(xVar, "util");
        com.google.android.libraries.navigation.internal.abf.s.k(scheduledExecutorService, "mapsApiClientParamsExecutorService");
        final String packageName = context.getPackageName();
        this.D = ahVar;
        this.t = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abh.gm
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() throws Throwable {
                String str = gu.a;
                int i = idVar.c;
                com.google.android.libraries.navigation.internal.abg.x xVar2 = xVar;
                Context context2 = context;
                String str2 = packageName;
                String string = Integer.toString(0);
                PackageInfo packageInfoA = xVar2.a(context2, str2);
                com.google.android.libraries.navigation.internal.abf.s.k(packageInfoA, "packageInfo");
                com.google.android.libraries.navigation.internal.adi.aa aaVar = (com.google.android.libraries.navigation.internal.adi.aa) com.google.android.libraries.navigation.internal.adi.ab.a.q();
                String strC = xVar2.c(com.google.android.libraries.navigation.internal.abf.e.b);
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                strC.getClass();
                abVar.b |= 2;
                abVar.d = strC;
                String strB = xVar2.b(context2);
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar2 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                abVar2.b |= 4;
                abVar2.e = strB;
                String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar3 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                strValueOf.getClass();
                abVar3.b |= 8;
                abVar3.f = strValueOf;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar4 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                str2.getClass();
                abVar4.b |= 16;
                abVar4.g = str2;
                String strValueOf2 = String.valueOf(packageInfoA.versionCode);
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar5 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                strValueOf2.getClass();
                abVar5.b |= 64;
                abVar5.h = strValueOf2;
                double d = com.google.android.libraries.navigation.internal.abf.e.h;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar6 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                abVar6.b |= 1024;
                abVar6.l = (float) d;
                boolean z = com.google.android.libraries.navigation.internal.abf.e.a;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar7 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                abVar7.b |= 2048;
                abVar7.f207n = z;
                com.google.android.libraries.navigation.internal.adi.c cVar = com.google.android.libraries.navigation.internal.adi.c.COMPACT_MULTIZOOM_STYLE_TABLE;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab abVar8 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                abVar8.p = cVar.d;
                abVar8.b |= 8192;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.ab.d((com.google.android.libraries.navigation.internal.adi.ab) aaVar.b);
                if (com.google.android.libraries.navigation.internal.afu.d.a.a().k()) {
                    if (!aaVar.b.H()) {
                        aaVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adi.ab abVar9 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                    abVar9.b |= 128;
                    abVar9.i = BuildConfig.VERSION_NAME;
                } else {
                    if (!aaVar.b.H()) {
                        aaVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adi.ab abVar10 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                    abVar10.b |= 128;
                    abVar10.i = BuildConfig.VERSION_NAME;
                }
                if (com.google.android.libraries.navigation.internal.afu.d.a.a().a()) {
                    if (!aaVar.b.H()) {
                        aaVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adi.ab abVar11 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                    abVar11.b |= 131072;
                    abVar11.r = "9.0.0";
                }
                if (com.google.android.libraries.navigation.internal.afu.d.c()) {
                    if (!aaVar.b.H()) {
                        aaVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adi.ab abVar12 = (com.google.android.libraries.navigation.internal.adi.ab) aaVar.b;
                    string.getClass();
                    abVar12.b |= 256;
                    abVar12.j = string;
                }
                bk bkVar2 = bkVar;
                if (!bkVar2.b.isEmpty()) {
                    aaVar.c(bkVar2.b);
                }
                return (com.google.android.libraries.navigation.internal.adi.ab) aaVar.t();
            }
        });
        com.google.android.libraries.navigation.internal.abf.ah.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.gn
            @Override // java.lang.Runnable
            public final void run() {
                String[] strArr = gu.b;
                int length = strArr.length;
                String str = strArr[0];
                Context context2 = this.a.r;
                context2.deleteFile(str + "." + context2.getPackageName());
            }
        });
        this.u = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abh.go
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new com.google.android.libraries.navigation.internal.abf.h(context, "DATA_ServerControlledParametersManager.data.v1.".concat(String.valueOf(packageName)), (com.google.android.libraries.navigation.internal.ael.dg) com.google.android.libraries.navigation.internal.afl.am.a.aH(7, null));
            }
        });
        com.google.android.libraries.navigation.internal.abf.ah.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.gp
            @Override // java.lang.Runnable
            public final void run() {
                gu guVar = this.a;
                if (guVar.d != null) {
                    return;
                }
                guVar.d = new ArrayList();
                ArrayList arrayList = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar = com.google.android.libraries.navigation.internal.afl.ha.PREFETCHER_SETTINGS;
                if (!gyVar.b.H()) {
                    gyVar.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar = (com.google.android.libraries.navigation.internal.afl.hb) gyVar.b;
                hbVar.e = haVar.eg;
                hbVar.b |= 1;
                com.google.android.libraries.navigation.internal.afl.hy hyVar = com.google.android.libraries.navigation.internal.afl.hy.a;
                if (!gyVar.b.H()) {
                    gyVar.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar2 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar.b;
                hyVar.getClass();
                hbVar2.d = hyVar;
                hbVar2.c = 8;
                arrayList.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar.t());
                ArrayList arrayList2 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar2 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar2 = com.google.android.libraries.navigation.internal.afl.ha.VECTOR_MAPS;
                if (!gyVar2.b.H()) {
                    gyVar2.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar3 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar2.b;
                hbVar3.e = haVar2.eg;
                hbVar3.b |= 1;
                qj qjVar = qj.a;
                if (!gyVar2.b.H()) {
                    gyVar2.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar4 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar2.b;
                qjVar.getClass();
                hbVar4.d = qjVar;
                hbVar4.c = 10;
                arrayList2.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar2.t());
                ArrayList arrayList3 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar3 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar3 = com.google.android.libraries.navigation.internal.afl.ha.API;
                if (!gyVar3.b.H()) {
                    gyVar3.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar5 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar3.b;
                hbVar5.e = haVar3.eg;
                hbVar5.b |= 1;
                com.google.android.libraries.navigation.internal.afl.j jVar = com.google.android.libraries.navigation.internal.afl.j.a;
                if (!gyVar3.b.H()) {
                    gyVar3.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar6 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar3.b;
                jVar.getClass();
                hbVar6.d = jVar;
                hbVar6.c = 14;
                arrayList3.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar3.t());
                ArrayList arrayList4 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar4 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar4 = com.google.android.libraries.navigation.internal.afl.ha.PAINT_PARAMETERS;
                if (!gyVar4.b.H()) {
                    gyVar4.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar7 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar4.b;
                hbVar7.e = haVar4.eg;
                hbVar7.b |= 1;
                com.google.android.libraries.navigation.internal.adi.af afVar = com.google.android.libraries.navigation.internal.adi.af.a;
                if (!gyVar4.b.H()) {
                    gyVar4.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar8 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar4.b;
                afVar.getClass();
                hbVar8.d = afVar;
                hbVar8.c = 39;
                arrayList4.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar4.t());
                ArrayList arrayList5 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar5 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar5 = com.google.android.libraries.navigation.internal.afl.ha.IMAGERY_VIEWER;
                if (!gyVar5.b.H()) {
                    gyVar5.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar9 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar5.b;
                hbVar9.e = haVar5.eg;
                hbVar9.b |= 1;
                com.google.android.libraries.navigation.internal.afl.de deVar = com.google.android.libraries.navigation.internal.afl.de.a;
                if (!gyVar5.b.H()) {
                    gyVar5.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar10 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar5.b;
                deVar.getClass();
                hbVar10.d = deVar;
                hbVar10.c = 47;
                arrayList5.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar5.t());
                ArrayList arrayList6 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar6 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar6 = com.google.android.libraries.navigation.internal.afl.ha.MAPS_API_PARAMETERS;
                if (!gyVar6.b.H()) {
                    gyVar6.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar11 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar6.b;
                hbVar11.e = haVar6.eg;
                hbVar11.b |= 1;
                arrayList6.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar6.t());
                ArrayList arrayList7 = guVar.d;
                com.google.android.libraries.navigation.internal.afl.gy gyVar7 = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                com.google.android.libraries.navigation.internal.afl.ha haVar7 = com.google.android.libraries.navigation.internal.afl.ha.LOGGING;
                if (!gyVar7.b.H()) {
                    gyVar7.v();
                }
                com.google.android.libraries.navigation.internal.afl.hb hbVar12 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar7.b;
                hbVar12.e = haVar7.eg;
                hbVar12.b |= 1;
                arrayList7.add((com.google.android.libraries.navigation.internal.afl.hb) gyVar7.t());
                guVar.e = new HashMap();
                guVar.v = guVar.b();
                if (guVar.v != null) {
                    synchronized (guVar) {
                        Iterator it2 = guVar.v.c.iterator();
                        while (it2.hasNext()) {
                            guVar.i((com.google.android.libraries.navigation.internal.afl.hb) it2.next());
                        }
                        Iterator it3 = guVar.d.iterator();
                        while (it3.hasNext()) {
                            guVar.j((com.google.android.libraries.navigation.internal.afl.hb) it3.next());
                        }
                        guVar.q = true;
                    }
                    guVar.d();
                }
            }
        });
    }

    static void k(com.google.android.libraries.navigation.internal.afl.ak akVar) {
        com.google.android.libraries.navigation.internal.afl.ai aiVar;
        if (akVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(akVar);
        int i = 0;
        while (true) {
            aiVar = (com.google.android.libraries.navigation.internal.afl.ai) akVar;
            if (i >= ((com.google.android.libraries.navigation.internal.afl.aj) aiVar.b).c.size()) {
                break;
            }
            ajVarF.g(com.google.android.libraries.navigation.internal.b.b.b(i, "ParameterGroup$"), m((com.google.android.libraries.navigation.internal.afl.hb) ((com.google.android.libraries.navigation.internal.afl.aj) aiVar.b).c.get(i)));
            i++;
        }
        com.google.android.libraries.navigation.internal.afl.aj ajVar = (com.google.android.libraries.navigation.internal.afl.aj) aiVar.b;
        if ((ajVar.b & 1) != 0) {
            com.google.android.libraries.navigation.internal.afl.ah ahVar = ajVar.d;
            if (ahVar == null) {
                ahVar = com.google.android.libraries.navigation.internal.afl.ah.a;
            }
            com.google.android.libraries.navigation.internal.abf.aj ajVarF2 = com.google.android.libraries.navigation.internal.abf.aj.f(ahVar);
            if ((ahVar.b & 1) != 0) {
                ajVarF2.e("opengl_es_1x_supported", ahVar.c);
            }
            if ((ahVar.b & 2) != 0) {
                ajVarF2.e("opengl_es_2x_supported", ahVar.d);
            }
            if ((ahVar.b & 8) != 0) {
                ajVarF2.e("full_base_zoom_table_supported", ahVar.f);
            }
            if ((ahVar.b & 32) != 0) {
                com.google.android.libraries.navigation.internal.adi.ab abVar = ahVar.h;
                if (abVar == null) {
                    abVar = com.google.android.libraries.navigation.internal.adi.ab.a;
                }
                com.google.android.libraries.navigation.internal.abf.aj ajVarF3 = com.google.android.libraries.navigation.internal.abf.aj.f(ahVar);
                if ((abVar.b & 2) != 0) {
                    ajVarF3.g("client_platform", abVar.d);
                }
                if ((abVar.b & 4) != 0) {
                    ajVarF3.g("distribution_channel", abVar.e);
                }
                if ((abVar.b & 8) != 0) {
                    ajVarF3.g("os_version", abVar.f);
                }
                if ((abVar.b & 16) != 0) {
                    ajVarF3.g("application_name", abVar.g);
                }
                if ((abVar.b & 64) != 0) {
                    ajVarF3.g("application_version", abVar.h);
                }
                if ((abVar.b & 128) != 0) {
                    ajVarF3.g("maps_api_version", abVar.i);
                }
                if ((abVar.b & 1024) != 0) {
                    ajVarF3.b("dpi_ratio", abVar.l);
                }
                if ((abVar.b & 2048) != 0) {
                    ajVarF3.e("include_copyrights", abVar.f207n);
                }
                if (com.google.android.libraries.navigation.internal.afu.d.c() && (abVar.b & 256) != 0) {
                    ajVarF3.g("renderer_version", abVar.j);
                }
                ajVarF2.g("paintfe_client_properties", ajVarF3.toString());
            }
            ajVarF.g("request_info", ajVarF2.toString());
        }
        ajVarF.toString();
    }

    static void l(com.google.android.libraries.navigation.internal.afl.an anVar) {
        if (anVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(anVar);
        int i = 0;
        while (true) {
            com.google.android.libraries.navigation.internal.afl.am amVar = (com.google.android.libraries.navigation.internal.afl.am) anVar;
            if (i >= amVar.c.size()) {
                ajVarF.toString();
                return;
            } else {
                ajVarF.g(com.google.android.libraries.navigation.internal.b.b.b(i, "ParameterGroup$"), m((com.google.android.libraries.navigation.internal.afl.hb) amVar.c.get(i)));
                i++;
            }
        }
    }

    private static String m(com.google.android.libraries.navigation.internal.afl.hc hcVar) {
        if (hcVar == null) {
            return com.google.maps.android.BuildConfig.TRAVIS;
        }
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(hcVar);
        com.google.android.libraries.navigation.internal.afl.hb hbVar = (com.google.android.libraries.navigation.internal.afl.hb) hcVar;
        if ((hbVar.b & 1) != 0) {
            com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
            if (haVarB == null) {
                haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
            }
            ajVarF.g("type", haVarB);
        }
        if ((hbVar.b & 2) != 0) {
            ajVarF.d("hash", hbVar.f);
        }
        return ajVarF.toString();
    }

    private final synchronized void n(boolean z) {
        com.google.android.libraries.navigation.internal.ace.fv fvVar = (com.google.android.libraries.navigation.internal.ace.fv) com.google.android.libraries.navigation.internal.ace.fw.a.q();
        fvVar.c(new ArrayList(this.C));
        h(z, (com.google.android.libraries.navigation.internal.ace.fw) fvVar.t());
    }

    final com.google.android.libraries.navigation.internal.yz.fy a(String str) {
        return this.x.containsKey(str) ? com.google.android.libraries.navigation.internal.yz.fy.o((Collection) this.x.get(str)) : new mq(com.google.android.libraries.navigation.internal.ace.fp.UNKNOWN_MAP_FACTS_TYPE);
    }

    final synchronized com.google.android.libraries.navigation.internal.afl.am b() {
        if (this.z) {
            return this.v;
        }
        com.google.android.libraries.navigation.internal.afl.am amVar = (com.google.android.libraries.navigation.internal.afl.am) ((com.google.android.libraries.navigation.internal.abf.h) this.u.a()).a();
        this.v = amVar;
        this.z = true;
        return amVar;
    }

    public final void c(gr grVar) {
        synchronized (this) {
            if (!this.p && !this.q) {
                this.B.add(grVar);
                grVar = null;
            }
        }
        if (grVar != null) {
            grVar.k();
        }
    }

    public final void d() {
        ArrayList arrayList;
        new ArrayList();
        synchronized (this) {
            arrayList = new ArrayList(this.B);
            this.B.clear();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((gr) arrayList.get(i)).k();
        }
    }

    public final synchronized void e() {
        n(true);
    }

    public final synchronized void g() {
        n(false);
    }

    public final synchronized void h(boolean z, com.google.android.libraries.navigation.internal.ace.fw fwVar) {
        synchronized (this.o) {
            if (this.l != null) {
                this.l.cancel(false);
                this.l = null;
            }
            if (!this.f124n || z) {
                this.f124n = true;
                this.m = false;
                ((com.google.android.libraries.navigation.internal.abg.q) this.A.a()).j(new gt(this, z, fwVar));
            } else {
                this.m = true;
            }
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.afl.hb hbVar) {
        com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
        if (haVarB == null) {
            haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
        }
        if (w.contains(haVarB)) {
            ArrayList arrayList = new ArrayList(this.d);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                com.google.android.libraries.navigation.internal.afl.hb hbVar2 = (com.google.android.libraries.navigation.internal.afl.hb) arrayList.get(i);
                com.google.android.libraries.navigation.internal.afl.ha haVarB2 = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar2.e);
                if (haVarB2 == null) {
                    haVarB2 = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                }
                i++;
                if (haVarB == haVarB2) {
                    this.d.remove(hbVar2);
                    break;
                }
            }
            this.d.add(hbVar);
        }
    }

    public final boolean j(com.google.android.libraries.navigation.internal.afl.hb hbVar) {
        com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
        if (haVarB == null) {
            haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
        }
        if ((haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.PREFETCHER_SETTINGS) && hbVar.c == 8) || (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.IMAGERY_VIEWER) && hbVar.c == 47)) {
            return true;
        }
        if (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.VECTOR_MAPS) && hbVar.c == 10) {
            qj qjVar = (qj) hbVar.d;
            this.y = qjVar.e;
            this.h = qjVar.i;
            return true;
        }
        if (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.API) && hbVar.c == 14) {
            this.g = ((com.google.android.libraries.navigation.internal.afl.j) hbVar.d).b;
            return true;
        }
        if (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.PAINT_PARAMETERS) && hbVar.c == 39) {
            com.google.android.libraries.navigation.internal.adi.ar arVar = ((com.google.android.libraries.navigation.internal.adi.af) hbVar.d).c;
            if (arVar == null) {
                arVar = com.google.android.libraries.navigation.internal.adi.ar.a;
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar = arVar.b;
            if (ajVar == null) {
                ajVar = com.google.android.libraries.navigation.internal.adi.aj.a;
            }
            this.i = ajVar;
            this.j = (hbVar.c == 39 ? (com.google.android.libraries.navigation.internal.adi.af) hbVar.d : com.google.android.libraries.navigation.internal.adi.af.a).h;
            return true;
        }
        if (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.MAPS_API_PARAMETERS) && hbVar.c == 151) {
            com.google.android.libraries.navigation.internal.afu.v.c();
            return true;
        }
        if (haVarB.equals(com.google.android.libraries.navigation.internal.afl.ha.LOGGING) && hbVar.c == 18) {
            this.k = (com.google.android.libraries.navigation.internal.afl.ea) hbVar.d;
            return true;
        }
        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        return false;
    }

    public final synchronized void f(String str) {
        final com.google.android.libraries.navigation.internal.ace.fw fwVar;
        if (str.isEmpty()) {
            com.google.android.libraries.navigation.internal.ace.fv fvVar = (com.google.android.libraries.navigation.internal.ace.fv) com.google.android.libraries.navigation.internal.ace.fw.a.q();
            fvVar.c(new ArrayList(this.C));
            fwVar = (com.google.android.libraries.navigation.internal.ace.fw) fvVar.t();
        } else {
            com.google.android.libraries.navigation.internal.ace.fv fvVar2 = (com.google.android.libraries.navigation.internal.ace.fv) com.google.android.libraries.navigation.internal.ace.fw.a.q();
            fvVar2.d(str);
            fwVar = (com.google.android.libraries.navigation.internal.ace.fw) fvVar2.t();
            this.C.add(str);
        }
        com.google.android.libraries.navigation.internal.abf.ah.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.gl
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(true, fwVar);
            }
        });
    }
}
