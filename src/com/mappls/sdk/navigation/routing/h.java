package com.mappls.sdk.navigation.routing;

import android.media.SoundPool;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationConstants;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.navigation.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static com.mappls.sdk.navigation.voice.c f713n = null;
    private static boolean o = false;
    private static int p = 0;
    private static float q = 0.0f;
    private static long r = 0;
    private static long s = 0;
    private static long t = 0;
    private static long u = 0;
    private static boolean v = false;
    private static long w;
    private static NavigationStep x;
    private final d a;
    private final s b;
    private ConcurrentHashMap<b, Integer> l;
    protected float c = 12.0f;
    protected float d = 5.0f;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected int k = 0;
    private double m = 0.0d;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it2 = h.this.l.keySet().iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a();
            }
        }
    }

    public interface b {
        void a();
    }

    public h(d dVar, s sVar) {
        this.a = dVar;
        this.b = sVar;
        o = !((Boolean) sVar.q0.get()).booleanValue();
        this.l = new ConcurrentHashMap<>();
    }

    public static void a() {
        c();
        if (v) {
            v = false;
        }
    }

    private void a(int i, String str, NavigationStep navigationStep) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            g();
            bVarC.a(i, str, navigationStep).d();
        }
    }

    private void a(NavigationStep navigationStep, int i) {
        com.mappls.sdk.navigation.voice.b bVarC;
        com.mappls.sdk.navigation.voice.b bVarC2 = c();
        if (bVarC2 != null) {
            String strA = a(navigationStep.getTurnType());
            if (strA != null) {
                g();
                bVarC = bVarC2.a(strA, i, a(navigationStep), navigationStep);
            } else if (navigationStep.getTurnType().e()) {
                g();
                bVarC = bVarC2.a(i, navigationStep.getTurnType().a(), a(navigationStep), navigationStep);
            } else {
                if (navigationStep.getTurnType().c() != 6 && navigationStep.getTurnType().c() != 41) {
                    return;
                }
                g();
                bVarC = bVarC2.c(i, a(navigationStep), navigationStep);
            }
            bVarC.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0065  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00df  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    private void a(NavigationStep navigationStep, int i, NavigationStep navigationStep2) {
        boolean z;
        com.mappls.sdk.navigation.router.c turnType;
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            String strA = a(navigationStep.getTurnType());
            boolean z2 = true;
            if (strA != null) {
                bVarC.b(strA, i, a(navigationStep), navigationStep);
            } else {
                if (!navigationStep.getTurnType().e()) {
                    if (navigationStep.getTurnType().c() == 6 || navigationStep.getTurnType().c() == 41) {
                        bVarC.b(i, a(navigationStep), navigationStep);
                    } else {
                        z = false;
                    }
                    if (navigationStep2 != null) {
                        turnType = navigationStep2.getTurnType();
                        if (turnType.c() != 7 && navigationStep.getTurnType().c() == 7) {
                            bVarC.a(i, a(navigationStep), navigationStep);
                        }
                        if (turnType.c() != 0 || turnType.c() == 1 || turnType.c() == 2 || turnType.c() == 6 || turnType.c() == 9) {
                            bVarC.g().a(a(navigationStep), navigationStep2);
                        } else if (turnType.c() == 3 || turnType.c() == 4 || turnType.c() == 5 || turnType.c() == 41 || turnType.c() == 10) {
                            bVarC.g().b(a(navigationStep), navigationStep2);
                        }
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        g();
                        bVarC.d();
                    }
                }
                navigationStep.getTurnType().b();
                bVarC.b(i, navigationStep.getTurnType().a(), a(navigationStep), navigationStep);
            }
            z = true;
            if (navigationStep2 != null) {
                turnType = navigationStep2.getTurnType();
                if (turnType.c() != 7) {
                    bVarC.a(i, a(navigationStep), navigationStep);
                }
                if (turnType.c() != 0) {
                    bVarC.g().a(a(navigationStep), navigationStep2);
                } else {
                    bVarC.g().a(a(navigationStep), navigationStep2);
                }
            } else {
                z2 = z;
            }
            if (z2) {
                g();
                bVarC.d();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0089  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    private void a(NavigationStep navigationStep, NavigationRoute.a aVar) {
        boolean z;
        NavigationStep navigationStep2;
        boolean z2;
        String strA;
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            String strA2 = a(navigationStep.getTurnType());
            if (strA2 != null) {
                bVarC.a(strA2, a(navigationStep), navigationStep);
            } else {
                if (!navigationStep.getTurnType().e()) {
                    if (navigationStep.getTurnType().c() == 6 || navigationStep.getTurnType().c() == 41) {
                        bVarC.c(a(navigationStep), navigationStep);
                    } else {
                        z = false;
                    }
                    if (aVar != null && (navigationStep2 = aVar.a) != null) {
                        if (navigationStep2.getTurnType().c() == 7 && navigationStep.getTurnType().c() == 7) {
                            bVarC.b();
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        strA = a(aVar.a.getTurnType());
                        if (strA != null) {
                            if (z2 && aVar.b != 0) {
                                bVarC.g();
                                bVarC.b(strA, aVar.b, (String) null, aVar.a);
                            }
                        } else if (aVar.a.getTurnType().e()) {
                            if (z2) {
                                bVarC.g();
                                double d = aVar.b;
                                aVar.a.getTurnType().b();
                                bVarC.b(d, aVar.a.getTurnType().a(), (String) null, aVar.a);
                            }
                        } else if (aVar.a.getTurnType().c() == 6 && z2 && aVar.b != 0) {
                            bVarC.g();
                            bVarC.b(aVar.b, null, aVar.a);
                        }
                        z = z2;
                    }
                    if (z) {
                        g();
                        bVarC.d();
                    }
                }
                navigationStep.getTurnType().b();
                bVarC.a(navigationStep.getTurnType().a(), a(navigationStep), navigationStep);
            }
            z = true;
            if (aVar != null) {
                if (navigationStep2.getTurnType().c() == 7) {
                    z2 = z;
                } else {
                    z2 = z;
                }
                strA = a(aVar.a.getTurnType());
                if (strA != null) {
                    if (z2) {
                        bVarC.g();
                        bVarC.b(strA, aVar.b, (String) null, aVar.a);
                    }
                } else if (aVar.a.getTurnType().e()) {
                    if (z2) {
                        bVarC.g();
                        double d2 = aVar.b;
                        aVar.a.getTurnType().b();
                        bVarC.b(d2, aVar.a.getTurnType().a(), (String) null, aVar.a);
                    }
                } else if (aVar.a.getTurnType().c() == 6) {
                    bVarC.g();
                    bVarC.b(aVar.b, null, aVar.a);
                }
                z = z2;
            }
            if (z) {
                g();
                bVarC.d();
            }
        }
    }

    public static void a(com.mappls.sdk.navigation.voice.c cVar) {
        f713n = cVar;
    }

    public static void a(boolean z) {
        o = z;
    }

    private static boolean a(int i) {
        return p <= i;
    }

    protected static com.mappls.sdk.navigation.voice.b c() {
        if (f713n == null) {
            return null;
        }
        w = System.currentTimeMillis();
        com.mappls.sdk.navigation.voice.a aVar = (com.mappls.sdk.navigation.voice.a) f713n;
        aVar.getClass();
        return new com.mappls.sdk.navigation.voice.b(aVar);
    }

    public static String d(String str) {
        if (str == null) {
            return str;
        }
        String strReplace = str.replace('-', ' ').replace(':', ' ').replace(";", ", ").replace(RemoteSettings.FORWARD_SLASH_STRING, ", ");
        if (f713n != null) {
            strReplace = strReplace.replace("ß", "ss");
        }
        return f713n != null ? strReplace.replace("SR", "S R") : strReplace;
    }

    public static void d() {
        com.mappls.sdk.navigation.voice.c cVar = f713n;
        if (cVar != null) {
            ((com.mappls.sdk.navigation.voice.e) cVar).j();
        }
    }

    public static boolean e() {
        return o;
    }

    private void f() {
        int iLoad;
        if (o) {
            return;
        }
        boolean z = false;
        SoundPool soundPool = new SoundPool(5, ((Integer) this.b.l0.get()).intValue(), 0);
        try {
            iLoad = soundPool.load(this.b.f().getAssets().openFd("sounds/ding.ogg"), 1);
            z = true;
        } catch (IOException e) {
            NavigationLogger.d(e);
            iLoad = -1;
        }
        int i = iLoad;
        if (z) {
            soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public static void h() {
        com.mappls.sdk.navigation.voice.c cVar = f713n;
        if (cVar != null) {
            ((com.mappls.sdk.navigation.voice.e) cVar).h();
        }
    }

    private void i() {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            g();
            bVarC.g().d();
        }
    }

    public final String a(NavigationStep navigationStep) {
        return (navigationStep == null || !((Boolean) this.a.m().U.get()).booleanValue()) ? "" : navigationStep.getStreetName();
    }

    public final void a(double d) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = u;
        if (j == 0 || jCurrentTimeMillis - t > j) {
            com.mappls.sdk.navigation.voice.b bVarC = c();
            if (bVarC != null) {
                g();
                bVarC.a(d).d();
                v = true;
            }
            long j2 = u;
            u = j2 == 0 ? 60000L : (long) (j2 * 2.5d);
            t = jCurrentTimeMillis;
        }
    }

    public final void a(NavLocation navLocation, List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        double[] dArr = new double[1];
        f();
        bVarC.a(dArr[0], (String) null, (NavigationStep) null).b(a(navLocation, list, dArr)).d();
    }

    public final void a(com.mappls.sdk.navigation.routing.a aVar, float f) {
        com.mappls.sdk.navigation.voice.b bVarC;
        StringBuilder sb;
        com.mappls.sdk.navigation.voice.b bVarC2;
        com.mappls.sdk.navigation.routing.a.EnumC0099a enumC0099aB = aVar.b();
        if (enumC0099aB == com.mappls.sdk.navigation.routing.a.EnumC0099a.c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = s;
            if (j == 0) {
                if (jCurrentTimeMillis - r > 120000) {
                    s = jCurrentTimeMillis;
                    return;
                }
                return;
            } else {
                if (jCurrentTimeMillis - j > 20000) {
                    s = 0L;
                    return;
                }
                if (!((Boolean) this.a.m().X.get()).booleanValue() || jCurrentTimeMillis - s <= 10000 || (bVarC2 = c()) == null) {
                    return;
                }
                g();
                r = jCurrentTimeMillis;
                s = 0L;
                bVarC2.f().d();
                return;
            }
        }
        if (enumC0099aB == com.mappls.sdk.navigation.routing.a.EnumC0099a.b) {
            if (!((Boolean) this.a.m().Y.get()).booleanValue() || (bVarC = c()) == null) {
                return;
            }
            g();
            sb = new StringBuilder();
        } else {
            if (enumC0099aB != com.mappls.sdk.navigation.routing.a.EnumC0099a.e) {
                if (((Boolean) this.a.m().V.get()).booleanValue()) {
                    com.mappls.sdk.navigation.voice.b bVarC3 = c();
                    if (bVarC3 != null) {
                        g();
                        bVarC3.h(enumC0099aB + "").d();
                    }
                    com.mappls.sdk.navigation.routing.a.EnumC0099a enumC0099a = com.mappls.sdk.navigation.routing.a.EnumC0099a.d;
                    return;
                }
                return;
            }
            if (!((Boolean) this.a.m().W.get()).booleanValue() || (bVarC = c()) == null) {
                return;
            }
            g();
            sb = new StringBuilder();
        }
        sb.append(enumC0099aB);
        sb.append("");
        bVarC.h(sb.toString()).d();
    }

    public final void a(String str) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        bVarC.i(str).e();
    }

    public final void a(List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        f();
        bVarC.e(a((NavLocation) null, list, (double[]) null)).d();
    }

    public final boolean a(float f, double d, double d2, float f2) {
        if (f2 <= 0.0f) {
            f2 = this.c;
        }
        if (f <= 0.0f) {
            f = this.c;
        }
        if (NavigationContext.getNavigationContext().l() == 0 && !com.mappls.sdk.navigation.voice.a.c) {
            this.m = (((double) f) * ((double) ((Integer) this.b.n0.get()).intValue())) / 1000.0d;
        }
        double d3 = this.m;
        return d < d2 + d3 || (d - d3) / ((double) f) < d2 / ((double) f2);
    }

    public final void b() {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            g();
            bVarC.d(null).d();
        }
    }

    public final void b(NavLocation navLocation, List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        double[] dArr = new double[1];
        bVarC.a(dArr[0], (String) null, (NavigationStep) null).c(a(navLocation, list, dArr)).d();
    }

    public final void b(String str) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        bVarC.i(str).e();
    }

    public final void b(List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC == null) {
            return;
        }
        g();
        bVarC.g(a((NavLocation) null, list, (double[]) null)).d();
    }

    public final void c(NavLocation navLocation, List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        if (c() == null) {
            return;
        }
        g();
        f();
        a(navLocation, list, new double[1]);
    }

    public final void c(String str) {
        com.mappls.sdk.navigation.voice.b bVarC = c();
        if (bVarC != null) {
            g();
            bVarC.f(d(str)).d();
        }
    }

    public final void c(List<com.mappls.sdk.navigation.helpers.b.C0096b> list) {
        if (c() == null) {
            return;
        }
        g();
        f();
        a((NavLocation) null, list, (double[]) null);
    }

    public final void g() {
        if (this.b.k0.get().intValue() > 0) {
            NavigationContext.getNavigationContext().a(new a());
        }
    }

    public final void j() {
        if (this.a.a().a(com.mappls.sdk.navigation.d.i)) {
            this.e = 3500;
            this.f = NavigationConstants.UI_HANDLER_MAP_CONTROLS;
            this.g = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            this.h = 1200;
            this.i = 300;
            this.j = Mp4VideoDirectory.TAG_COMPRESSION_TYPE;
            this.k = 30;
            this.d = 7.0f;
            this.c = 13.0f;
            return;
        }
        if (this.a.a().a(com.mappls.sdk.navigation.d.j)) {
            this.e = 500;
            this.f = 1300;
            this.g = 200;
            this.h = 120;
            this.i = 80;
            this.j = 60;
            this.k = 30;
            this.c = 5.0f;
            this.d = 5.0f;
            return;
        }
        if (this.a.a().a(com.mappls.sdk.navigation.d.k)) {
            this.e = 500;
            this.f = 600;
            this.g = 200;
            this.h = 250;
            this.i = 50;
            this.j = 30;
            this.k = 15;
            this.c = 2.0f;
            this.d = 2.0f;
            return;
        }
        float fD = this.a.a().d();
        this.c = fD;
        this.d = fD / 2.0f;
        this.e = (int) (270.0f * fD);
        this.f = ((int) (230.0f * fD)) * 2;
        this.g = (int) (115.0f * fD);
        this.h = (int) (92.0f * fD);
        this.i = (int) (23.0f * fD);
        this.j = (int) (16.0f * fD);
        this.k = (int) (fD * 7.0f);
    }

    public final void a(NavLocation navLocation) {
        synchronized (this.a) {
            if (p != -1) {
                a(navLocation, true);
            } else {
                com.mappls.sdk.navigation.voice.b bVarC = c();
                if (bVarC != null) {
                    g();
                    bVarC.c().d();
                    q = 0.0f;
                }
            }
        }
    }

    protected final String a(NavLocation navLocation, List<com.mappls.sdk.navigation.helpers.b.C0096b> list, double[] dArr) {
        String strA = "";
        for (com.mappls.sdk.navigation.helpers.b.C0096b c0096b : list) {
            if (strA.length() != 0) {
                strA = n.a(strA, ", ");
            } else if (navLocation != null && dArr != null) {
                dArr[0] = ((double) c0096b.a()) + com.mappls.sdk.navigation.util.d.a(navLocation.getLatitude(), navLocation.getLongitude(), c0096b.b().getLatitude(), c0096b.b().getLongitude());
            }
            StringBuilder sbA = com.mappls.sdk.navigation.h.a(strA);
            sbA.append(com.mappls.sdk.navigation.data.a.a(c0096b.b(), this.a.b()));
            strA = sbA.toString();
        }
        return strA;
    }

    private static String a(com.mappls.sdk.navigation.router.c cVar) {
        StringBuilder sbA = com.mappls.sdk.navigation.h.a("voice router= ");
        sbA.append(cVar.c());
        NavigationLogger.d(sbA.toString(), new Object[0]);
        if (cVar.c() == 0) {
            return "left";
        }
        if (1 == cVar.c()) {
            return "left_sh";
        }
        if (2 == cVar.c()) {
            return "left_sl";
        }
        if (3 == cVar.c()) {
            return "right";
        }
        if (4 == cVar.c()) {
            return "right_sh";
        }
        if (5 == cVar.c()) {
            return "right_sl";
        }
        if (9 == cVar.c()) {
            return "left_keep";
        }
        if (10 == cVar.c()) {
            return "right_keep";
        }
        if (40 == cVar.c()) {
            return "border_crossing";
        }
        if (36 == cVar.c()) {
            return "take_ferry";
        }
        if (37 == cVar.c()) {
            return "leave_ferry";
        }
        if (21 == cVar.c()) {
            return "continue_straight_at";
        }
        if (20 == cVar.c()) {
            return "keep_right_at";
        }
        if (19 == cVar.c()) {
            return "keep_left_at";
        }
        if (11 == cVar.c()) {
            return "take_left_at";
        }
        if (12 == cVar.c()) {
            return "take_right_at";
        }
        if (14 == cVar.c()) {
            return "take_right_at_end";
        }
        if (13 == cVar.c()) {
            return "take_left_at_end";
        }
        if (15 == cVar.c()) {
            return "at_fork_left";
        }
        if (16 == cVar.c()) {
            return "at_fork_right";
        }
        if (19 == cVar.c()) {
            return "take_left_at_intersection";
        }
        if (20 == cVar.c()) {
            return "take_right_at_intersection";
        }
        if (34 == cVar.c()) {
            return "highway_exit_left_driving_road";
        }
        if (35 == cVar.c()) {
            return "highway_enter_left_driving_road";
        }
        return null;
    }

    protected final void a(NavLocation navLocation, boolean z) {
        NavigationStep navigationStep;
        NavigationRoute.a aVar;
        int i;
        int i2;
        NavigationStep navigationStep2;
        NavigationStep navigationStep3;
        float fMax = this.c;
        if (navLocation != null && navLocation.hasSpeed()) {
            fMax = Math.max(navLocation.getSpeed(), fMax);
        }
        float f = fMax;
        boolean z2 = true;
        NavigationRoute.a aVarA = this.a.a(new NavigationRoute.a(), true);
        this.a.e();
        NavigationStep navigationStep4 = aVarA.a;
        if (navigationStep4 == null) {
            return;
        }
        int i3 = aVarA.b;
        if (navigationStep4 != x) {
            x = navigationStep4;
            p = 0;
            v = false;
            if (q != -1.0f) {
                q = 0.0f;
            }
        }
        if (!z) {
            if (i3 <= 0) {
                return;
            }
            Integer num = this.b.j0.get();
            if (num != null && num.intValue() != 0) {
                if (System.currentTimeMillis() > (((long) (num.intValue() * 60)) * 1000) + w) {
                    a(i3, a(navigationStep4), navigationStep4);
                    return;
                }
            }
            if (p == 5) {
                return;
            }
        }
        if (p == 0 && (q == -1.0f || i3 > this.e)) {
            q = i3 - (this.k * 3);
        }
        NavigationRoute.a aVarA2 = this.a.a(aVarA, new NavigationRoute.a());
        if (z || a(4)) {
            navigationStep = null;
            aVar = aVarA2;
            if (a(f, i3, this.k, this.d)) {
                if (aVar == null || aVar.b >= this.j) {
                    a(navigationStep4, (NavigationRoute.a) null);
                } else {
                    a(navigationStep4, aVar);
                }
                if (!navigationStep4.getTurnType().d()) {
                    boolean z3 = aVar != null && aVar.c;
                    if (aVar != null && (navigationStep3 = aVar.a) != null && navigationStep3.distance != 0) {
                        z2 = false;
                    }
                    if ((z3 || z2) && ((i = aVar.b) >= (i2 = this.j) ? i < i2 * 1.2f : !((navigationStep2 = aVar.a) == null || !navigationStep2.getTurnType().d()))) {
                        i();
                        a(aVar.b, (String) null, aVar.a);
                    }
                }
                p = 5;
                return;
            }
        } else {
            navigationStep = null;
            aVar = aVarA2;
        }
        if ((z || a(3)) && a(f, i3, this.i, 0.0f)) {
            if (z || i3 >= this.j) {
                if (aVar == null || (!a(f, aVar.b, this.k, 0.0f) && aVar.b >= this.j)) {
                    a(navigationStep4, i3 - ((int) this.m), navigationStep);
                } else {
                    a(navigationStep4, i3 - ((int) this.m), aVar.a);
                }
            }
            p = 4;
            return;
        }
        if ((z || a(2)) && i3 <= this.g) {
            if ((z || i3 >= this.h) && (z || (!navigationStep4.getTurnType().f() && !navigationStep4.getTurnType().g()))) {
                a(navigationStep4, i3);
            }
            p = 3;
            return;
        }
        if ((z || a(1)) && i3 <= this.e) {
            if (z || i3 >= this.f) {
                a(navigationStep4, i3);
            }
            p = 2;
            return;
        }
        if (a(0)) {
            p = 1;
        } else if (z || (a(2) && i3 < q)) {
            q = 0.0f;
            a(i3, a(navigationStep4), navigationStep4);
        }
    }
}
