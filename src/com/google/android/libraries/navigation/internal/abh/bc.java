package com.google.android.libraries.navigation.internal.abh;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.android.datatransport.BuildConfig;
import java.io.File;
import java.util.HashSet;
import java.util.Random;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc {
    public final Context a;
    public final com.google.android.libraries.navigation.internal.yx.br b;
    public final com.google.android.libraries.navigation.internal.yx.br c;
    private com.google.android.libraries.navigation.internal.b.w d;
    private final com.google.android.libraries.navigation.internal.abg.y e;

    public bc(final Context context, final id idVar, final com.google.android.libraries.navigation.internal.abg.f fVar, final com.google.android.libraries.navigation.internal.wc.b bVar, final com.google.android.libraries.navigation.internal.wx.c cVar) {
        com.google.android.libraries.navigation.internal.abg.y yVar = com.google.android.libraries.navigation.internal.abg.y.a;
        this.a = context;
        this.c = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abh.aw
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                String str = Build.VERSION.SDK;
                String strValueOf = String.valueOf(com.google.android.libraries.navigation.internal.abf.e.k);
                Context context2 = context;
                String packageName = context2.getPackageName();
                return String.valueOf(String.format("Mozilla/5.0 (%s; U; %s; %s; ) AppleWebKit/0.0 (KHTML, like Gecko) Version/0.0; GmmClient:%s/%s/%s/%s/%s/%s", "Android", str, strValueOf, SystemMediaRouteProvider.PACKAGE_NAME, packageName, BuildConfig.VERSION_NAME, "Mobile", com.google.android.libraries.navigation.internal.abg.x.b.c(com.google.android.libraries.navigation.internal.abf.e.b), com.google.android.libraries.navigation.internal.abg.x.b.b(context2))).concat(String.valueOf(String.format("/%s/%s/%s", "", String.valueOf(com.google.android.libraries.navigation.internal.abg.x.b.a(context2, packageName).versionCode), "9.0.0")));
            }
        });
        this.e = yVar;
        new bb(this);
        this.b = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abh.ax
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                final Context context2 = context;
                String packageName = context2.getPackageName();
                String strValueOf = String.valueOf(com.google.android.libraries.navigation.internal.abg.x.b.a(context2, packageName).versionCode);
                String strC = com.google.android.libraries.navigation.internal.abg.x.b.c(com.google.android.libraries.navigation.internal.abf.e.b);
                int i = idVar.c;
                com.google.android.libraries.navigation.internal.b.w wVarA = this.a.a();
                com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
                int iA = com.google.android.libraries.navigation.internal.lc.ak.a(context2);
                Integer numValueOf = Integer.valueOf(iA);
                String str = com.google.android.libraries.navigation.internal.abg.p.a;
                com.google.android.libraries.navigation.internal.abf.s.k(context2, "Context");
                if (com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abg.p.a, 4)) {
                    com.google.android.libraries.navigation.internal.afu.ab.c();
                }
                String strC2 = com.google.android.libraries.navigation.internal.afu.ab.c();
                com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.abg.o
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        String str2 = p.a;
                        return x.b.b(context2);
                    }
                });
                StrictMode.ThreadPolicy threadPolicyB = com.google.android.libraries.navigation.internal.abf.w.a.b();
                try {
                    SharedPreferences sharedPreferences = context2.getSharedPreferences("com.google.maps.api.android.lib6.drd.PREFERENCES_FILE", 0);
                    com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
                    int i2 = com.google.android.libraries.navigation.internal.abf.e.g;
                    com.google.android.libraries.navigation.internal.abf.s.k(context2, "context");
                    com.google.android.libraries.navigation.internal.abf.s.k(packageName, "applicationName");
                    com.google.android.libraries.navigation.internal.afl.ao aoVar = (com.google.android.libraries.navigation.internal.afl.ao) com.google.android.libraries.navigation.internal.afl.ar.a.q();
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    packageName.getClass();
                    arVar.b |= 1024;
                    arVar.h = packageName;
                    int i3 = com.google.android.libraries.navigation.internal.afl.ab.d;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar2 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    int i4 = i3 - 1;
                    if (i3 == 0) {
                        throw null;
                    }
                    arVar2.F = i4;
                    arVar2.c |= 134217728;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar3 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    arVar3.c |= 8192;
                    arVar3.B = 0;
                    numValueOf.getClass();
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar4 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    arVar4.c |= 16384;
                    arVar4.C = iA;
                    if (strValueOf != null) {
                        if (!aoVar.b.H()) {
                            aoVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afl.ar arVar5 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                        arVar5.c |= 64;
                        arVar5.v = strValueOf;
                    }
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar6 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    String str2 = Build.VERSION.SDK;
                    str2.getClass();
                    arVar6.b |= 33554432;
                    arVar6.q = str2;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar.g((com.google.android.libraries.navigation.internal.afl.ar) aoVar.b);
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar.h((com.google.android.libraries.navigation.internal.afl.ar) aoVar.b);
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar.e((com.google.android.libraries.navigation.internal.afl.ar) aoVar.b);
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.ar arVar7 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                    arVar7.c |= 128;
                    arVar7.w = "9.0.0";
                    if (i2 > 200) {
                        int i5 = com.google.android.libraries.navigation.internal.afl.aq.c;
                        if (!aoVar.b.H()) {
                            aoVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afl.ar arVar8 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                        if (i5 == 0) {
                            throw null;
                        }
                        arVar8.f297n = i5;
                        arVar8.b |= 2097152;
                    } else {
                        int i6 = com.google.android.libraries.navigation.internal.afl.aq.a;
                        if (!aoVar.b.H()) {
                            aoVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afl.ar arVar9 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                        if (i6 == 0) {
                            throw null;
                        }
                        arVar9.f297n = i6;
                        arVar9.b |= 2097152;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                    if (telephonyManager != null) {
                        String simCountryIso = telephonyManager.getSimCountryIso();
                        if (!com.google.android.libraries.navigation.internal.abf.x.a(simCountryIso)) {
                            if (!aoVar.b.H()) {
                                aoVar.v();
                            }
                            com.google.android.libraries.navigation.internal.afl.ar arVar10 = (com.google.android.libraries.navigation.internal.afl.ar) aoVar.b;
                            simCountryIso.getClass();
                            arVar10.b |= 16;
                            arVar10.g = simCountryIso;
                        }
                    }
                    if (com.google.android.libraries.navigation.internal.afu.d.a.a().h()) {
                        if (!aoVar.b.H()) {
                            aoVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afl.ar.i((com.google.android.libraries.navigation.internal.afl.ar) aoVar.b);
                    }
                    com.google.android.libraries.navigation.internal.wx.c cVar2 = cVar;
                    com.google.android.libraries.navigation.internal.abg.p pVar = new com.google.android.libraries.navigation.internal.abg.p(strC2, strC, brVarA, (com.google.android.libraries.navigation.internal.afl.ar) aoVar.t(), sharedPreferences, wVarA, fVar, com.google.android.libraries.navigation.internal.abf.a.a, new Random(), com.google.android.libraries.navigation.internal.abf.ah.f("DataRequestDispatcher"), bVar, cVar2);
                    pVar.m();
                    pVar.d.addIfAbsent(new ba());
                    return pVar;
                } catch (Throwable th) {
                    com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
                    throw th;
                }
            }
        });
        synchronized (this) {
            new HashSet();
            this.d = null;
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.b.w a() {
        if (this.d == null) {
            Context context = this.a;
            com.google.android.libraries.navigation.internal.c.b bVar = new com.google.android.libraries.navigation.internal.c.b(new com.google.android.libraries.navigation.internal.c.l());
            StrictMode.ThreadPolicy threadPolicyA = com.google.android.libraries.navigation.internal.abf.w.a.a();
            try {
                com.google.android.libraries.navigation.internal.abg.l lVar = new com.google.android.libraries.navigation.internal.abg.l(new com.google.android.libraries.navigation.internal.c.h(new File(context.getCacheDir(), "com.google.android.gms.maps.volley")), bVar, new com.google.android.libraries.navigation.internal.abg.j((((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1048576) / 8), new com.google.android.libraries.navigation.internal.b.j(new Handler(Looper.getMainLooper())));
                com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
                this.d = lVar;
                com.google.android.libraries.navigation.internal.b.e eVar = lVar.h;
                if (eVar != null) {
                    eVar.a();
                }
                com.google.android.libraries.navigation.internal.b.m[] mVarArr = lVar.g;
                for (int i = 0; i < 4; i++) {
                    com.google.android.libraries.navigation.internal.b.m mVar = mVarArr[i];
                    if (mVar != null) {
                        mVar.a = true;
                        mVar.interrupt();
                    }
                }
                lVar.h = new com.google.android.libraries.navigation.internal.b.e(lVar.b, lVar.c, lVar.d, lVar.f);
                lVar.h.start();
                for (int i2 = 0; i2 < 4; i2++) {
                    com.google.android.libraries.navigation.internal.b.m mVar2 = new com.google.android.libraries.navigation.internal.b.m(lVar.c, lVar.e, lVar.d, lVar.f);
                    lVar.g[i2] = mVar2;
                    mVar2.start();
                }
            } catch (Throwable th) {
                com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
                throw th;
            }
        }
        return this.d;
    }
}
