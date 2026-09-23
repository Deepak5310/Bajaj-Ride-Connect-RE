package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bt;
import com.google.android.libraries.navigation.internal.ma.al;
import com.google.android.libraries.navigation.internal.xt.ar;
import com.google.android.libraries.navigation.internal.xt.av;
import com.google.android.libraries.navigation.internal.xt.ax;
import com.google.android.libraries.navigation.internal.xt.cf;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public final com.google.android.libraries.navigation.internal.xt.j c = new com.google.android.libraries.navigation.internal.xt.n();
    public final Context d;
    public final br e;
    public final cf f;
    public final br g;
    public final ar h;
    private final br m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final br f651n;
    private final br o;
    private static final Object i = new Object();
    private static final aj j = new aj();
    public static Context a = null;
    private static volatile y k = null;
    private static volatile y l = null;
    public static final br b = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xo.p
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            Context context = y.a;
            return bt.a(Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.android.libraries.navigation.internal.xo.t
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Context context2 = y.a;
                    return new Thread(runnable, "ProcessStablePhenotypeFlag");
                }
            }));
        }
    });

    /* JADX INFO: compiled from: PG */
    public interface a {
        an a();
    }

    public y(Context context, br brVar, br brVar2, final br brVar3, br brVar4, br brVar5) {
        Context applicationContext = context.getApplicationContext();
        com.google.android.libraries.navigation.internal.yx.ar.q(applicationContext);
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar2);
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar3);
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar4);
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar5);
        br brVarA = bw.a(brVar);
        br brVarA2 = bw.a(brVar2);
        br brVarA3 = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xo.u
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                Context context2 = y.a;
                return (ax) ((an) brVar3.a()).f();
            }
        });
        br brVarA4 = bw.a(brVar4);
        br brVarA5 = bw.a(brVar5);
        this.d = applicationContext;
        this.m = brVarA;
        this.f651n = brVarA2;
        this.e = brVarA3;
        this.o = brVarA4;
        this.f = new cf(applicationContext, brVarA, brVarA4, brVarA2);
        this.g = brVarA5;
        this.h = new ar(brVarA3, brVarA2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static y a(Context context) {
        boolean z;
        y yVar = k;
        if (yVar != null) {
            return yVar;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            Object applicationContext2 = applicationContext.getApplicationContext();
            if (!(applicationContext2 instanceof com.google.android.libraries.navigation.internal.afq.a)) {
                throw new IllegalStateException("Given application context does not implement GeneratedComponentManager: ".concat(String.valueOf(String.valueOf(applicationContext2.getClass()))));
            }
            try {
                an anVarA = ((a) a.class.cast(((com.google.android.libraries.navigation.internal.afq.a) applicationContext2).a())).a();
                z = true;
                try {
                    if (anVarA.g()) {
                        return (y) anVarA.c();
                    }
                } catch (IllegalStateException unused) {
                }
            } catch (ClassCastException e) {
                throw new IllegalStateException("Failed to get an entry point. Did you mark your interface with @SingletonEntryPoint?", e);
            }
        } catch (IllegalStateException unused2) {
            z = false;
        }
        synchronized (i) {
            if (k != null) {
                return k;
            }
            an anVarA2 = com.google.android.libraries.navigation.internal.yx.a.a;
            boolean z2 = applicationContext instanceof a;
            if (z2) {
                anVarA2 = ((a) applicationContext).a();
            }
            y yVar2 = (y) anVarA2.d(new br() { // from class: com.google.android.libraries.navigation.internal.xo.q
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    Context context2 = y.a;
                    final x xVar = new x();
                    xVar.a = applicationContext;
                    com.google.android.libraries.navigation.internal.yx.ar.q(xVar.a);
                    if (xVar.b == null) {
                        xVar.b = y.b;
                    }
                    if (xVar.c == null) {
                        final Context context3 = xVar.a;
                        xVar.c = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xo.r
                            @Override // com.google.android.libraries.navigation.internal.yx.br
                            public final Object a() {
                                Context context4 = y.a;
                                return new com.google.android.libraries.navigation.internal.xp.p(new al(context3));
                            }
                        });
                    }
                    if (xVar.d == null) {
                        xVar.d = new br() { // from class: com.google.android.libraries.navigation.internal.xo.v
                            @Override // com.google.android.libraries.navigation.internal.yx.br
                            public final Object a() {
                                return an.j(new av(xVar.b));
                            }
                        };
                    }
                    if (xVar.e == null) {
                        Context context4 = xVar.a;
                        final ArrayList arrayList = new ArrayList();
                        Collections.addAll(arrayList, new com.google.android.libraries.navigation.internal.xz.d(new com.google.android.libraries.navigation.internal.xz.c(context4)), new com.google.android.libraries.navigation.internal.xz.k());
                        xVar.e = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xo.s
                            @Override // com.google.android.libraries.navigation.internal.yx.br
                            public final Object a() {
                                Context context5 = y.a;
                                return new com.google.android.libraries.navigation.internal.xy.f(arrayList, Collections.emptyList(), Collections.emptyList());
                            }
                        });
                    }
                    if (xVar.f == null) {
                        xVar.f = new br() { // from class: com.google.android.libraries.navigation.internal.xo.w
                            @Override // com.google.android.libraries.navigation.internal.yx.br
                            public final Object a() {
                                Context context5 = xVar.a;
                                Context context6 = y.a;
                                try {
                                    return an.j(context5.getPackageManager().getApplicationInfo("com.google.android.gms", 0));
                                } catch (PackageManager.NameNotFoundException unused3) {
                                    return com.google.android.libraries.navigation.internal.yx.a.a;
                                }
                            }
                        };
                    }
                    return new y(xVar.a, xVar.b, xVar.c, xVar.d, xVar.e, xVar.f);
                }
            });
            k = yVar2;
            if (!z && !z2) {
                j.a(Level.CONFIG, yVar2.d(), "Application doesn't implement PhenotypeApplication interface, falling back to globally set context. See go/phenotype-flag#process-stable-init for more info.", new Object[0]);
            }
            return yVar2;
        }
    }

    public static void e(Context context) {
        synchronized (i) {
            if (a != null) {
                return;
            }
            try {
                a = context.getApplicationContext();
            } catch (NullPointerException unused) {
                f();
                j.a(Level.WARNING, (Executor) b.a(), "context.getApplicationContext() yielded NullPointerException", new Object[0]);
            }
        }
    }

    public static void f() {
        aa.a();
        if (a == null && aa.a == null) {
            aa.a = new z();
        }
    }

    public final com.google.android.libraries.navigation.internal.xp.l b() {
        return (com.google.android.libraries.navigation.internal.xp.l) this.f651n.a();
    }

    public final com.google.android.libraries.navigation.internal.xy.f c() {
        return (com.google.android.libraries.navigation.internal.xy.f) this.o.a();
    }

    public final bn d() {
        return (bn) this.m.a();
    }
}
