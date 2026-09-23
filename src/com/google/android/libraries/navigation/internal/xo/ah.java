package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ah {
    private static final Object a = new Object();
    public static volatile ag b = null;
    public static volatile boolean c = false;
    public static final com.google.android.libraries.navigation.internal.xq.a d;
    public static final AtomicInteger e;
    public final af f;
    public final String g;
    public volatile int h = -1;
    public volatile Object i;
    private Object j;
    private volatile boolean k;

    static {
        new AtomicReference();
        d = new com.google.android.libraries.navigation.internal.xq.a(new com.google.android.libraries.navigation.internal.xr.a() { // from class: com.google.android.libraries.navigation.internal.xo.ad
            @Override // com.google.android.libraries.navigation.internal.xr.a
            public final void a() {
                ag agVar = ah.b;
            }
        });
        e = new AtomicInteger();
    }

    public ah(af afVar, String str, Object obj) {
        if (afVar.a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f = afVar;
        this.g = str;
        this.j = obj;
        this.k = false;
    }

    public static void e() {
        e.incrementAndGet();
    }

    public static void f(final Context context) {
        if (b == null) {
            Object obj = a;
            synchronized (obj) {
                if (b == null) {
                    synchronized (obj) {
                        ag agVar = b;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (agVar == null || ((a) agVar).a != context) {
                            if (agVar != null) {
                                d.b();
                                ak.b();
                                l.d();
                            }
                            b = new a(context, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xo.ac
                                @Override // com.google.android.libraries.navigation.internal.yx.br
                                public final Object a() {
                                    ag agVar2 = ah.b;
                                    return m.a(context);
                                }
                            }));
                            e();
                        }
                    }
                }
            }
        }
    }

    public abstract Object a(Object obj);

    public final Object b() {
        return this.j;
    }

    public final String c() {
        return d(this.f.c);
    }

    public final String d(String str) {
        return str.isEmpty() ? this.g : str.concat(this.g);
    }
}
