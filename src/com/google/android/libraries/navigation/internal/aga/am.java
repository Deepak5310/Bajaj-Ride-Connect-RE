package com.google.android.libraries.navigation.internal.aga;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.google.android.libraries.navigation.internal.afx.by {
    public static final Logger a;
    public static final Set b;
    static final boolean c;
    static final boolean d;
    protected static final boolean e;
    public static final al f;
    private static final String s;
    private static final String t;
    private static final String u;
    private static String v;
    private final boolean A;
    private com.google.android.libraries.navigation.internal.afx.bu B;
    final com.google.android.libraries.navigation.internal.afx.cd g;
    public final String j;
    public final int k;
    public final long l;
    public final com.google.android.libraries.navigation.internal.afx.cq m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.yx.bm f332n;
    protected boolean o;
    public final com.google.android.libraries.navigation.internal.afx.bx p;
    public boolean q;
    private final String w;
    private final eq x;
    private boolean y;
    private Executor z;
    public final Random h = new Random();
    protected volatile int r = ae.a;
    public final AtomicReference i = new AtomicReference();

    static {
        Logger logger = Logger.getLogger(am.class.getName());
        a = logger;
        b = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        s = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        t = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        u = property3;
        c = Boolean.parseBoolean(property);
        d = Boolean.parseBoolean(property2);
        e = Boolean.parseBoolean(property3);
        al alVar = null;
        try {
            try {
                try {
                    al alVar2 = (al) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, am.class.getClassLoader()).asSubclass(al.class).getConstructor(null).newInstance(null);
                    if (alVar2.b() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", alVar2.b());
                    } else {
                        alVar = alVar2;
                    }
                } catch (Exception e2) {
                    a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e2);
                }
            } catch (Exception e3) {
                a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e3);
            }
        } catch (ClassCastException e4) {
            a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e4);
        } catch (ClassNotFoundException e5) {
            a.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e5);
        }
        f = alVar;
    }

    protected am(String str, com.google.android.libraries.navigation.internal.afx.br brVar, eq eqVar, com.google.android.libraries.navigation.internal.yx.bm bmVar, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.r(brVar, "args");
        this.x = eqVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "name");
        URI uriCreate = URI.create("//".concat(str));
        com.google.android.libraries.navigation.internal.yx.ar.f(uriCreate.getHost() != null, "Invalid DNS name: %s", str);
        String authority = uriCreate.getAuthority();
        com.google.android.libraries.navigation.internal.yx.ar.s(authority, "nameUri (%s) doesn't have an authority", uriCreate);
        this.w = authority;
        this.j = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.k = brVar.a;
        } else {
            this.k = uriCreate.getPort();
        }
        com.google.android.libraries.navigation.internal.afx.cd cdVar = brVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.r(cdVar, "proxyDetector");
        this.g = cdVar;
        long nanos = 0;
        if (!z) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j = 30;
            if (property != null) {
                try {
                    j = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    a.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
        }
        this.l = nanos;
        this.f332n = bmVar;
        com.google.android.libraries.navigation.internal.afx.cq cqVar = brVar.c;
        com.google.android.libraries.navigation.internal.yx.ar.r(cqVar, "syncContext");
        this.m = cqVar;
        Executor executor = brVar.f;
        this.z = executor;
        this.A = executor == null;
        com.google.android.libraries.navigation.internal.afx.bx bxVar = brVar.d;
        com.google.android.libraries.navigation.internal.yx.ar.r(bxVar, "serviceConfigParser");
        this.p = bxVar;
    }

    public static String e() {
        if (v == null) {
            try {
                v = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return v;
    }

    private final void f() {
        if (this.q || this.y) {
            return;
        }
        if (this.o) {
            long j = this.l;
            if (j != 0 && (j <= 0 || this.f332n.a(TimeUnit.NANOSECONDS) <= this.l)) {
                return;
            }
        }
        this.q = true;
        this.z.execute(new aj(this, this.B));
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final String a() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final void b() {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.B != null, "not started");
        f();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final void c() {
        if (this.y) {
            return;
        }
        this.y = true;
        Executor executor = this.z;
        if (executor == null || !this.A) {
            return;
        }
        er.d(this.x, executor);
        this.z = null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.concurrent.Executor] */
    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final void d(com.google.android.libraries.navigation.internal.afx.bu buVar) {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.B == null, "already started");
        if (this.A) {
            this.z = er.a(this.x);
        }
        this.B = buVar;
        f();
    }
}
