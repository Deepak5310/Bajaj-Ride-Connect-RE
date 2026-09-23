package com.google.android.libraries.navigation.internal.aga;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.grpc.internal.GrpcUtil;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cx extends com.google.android.libraries.navigation.internal.afx.bf {
    public static final Method e;
    public boolean A;
    List B;
    es C;
    es D;
    public final com.google.android.libraries.navigation.internal.afz.a E;
    public final cv F;
    public final List f;
    public com.google.android.libraries.navigation.internal.afx.cb g;
    final List h;
    public final String i;
    final com.google.android.libraries.navigation.internal.afx.f j;
    final com.google.android.libraries.navigation.internal.afx.d k;
    String l;
    com.google.android.libraries.navigation.internal.afx.y m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.google.android.libraries.navigation.internal.afx.o f335n;
    long o;
    int p;
    int q;
    long r;
    long s;
    boolean t;
    com.google.android.libraries.navigation.internal.afx.ag u;
    boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public static final Logger a = Logger.getLogger(cx.class.getName());
    static final long b = TimeUnit.MINUTES.toMillis(30);
    static final long c = TimeUnit.SECONDS.toMillis(1);
    private static final es I = new es(az.b);
    private static final com.google.android.libraries.navigation.internal.afx.y G = com.google.android.libraries.navigation.internal.afx.y.b;
    private static final com.google.android.libraries.navigation.internal.afx.o H = com.google.android.libraries.navigation.internal.afx.o.a;
    static final Pattern d = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    static {
        Method declaredMethod = null;
        try {
            declaredMethod = Class.forName("com.google.android.libraries.navigation.internal.afy.a").getDeclaredMethod("getClientInterceptor", Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
        } catch (ClassNotFoundException e2) {
            a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e2);
        } catch (NoSuchMethodException e3) {
            a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e3);
        }
        e = declaredMethod;
    }

    public cx(SocketAddress socketAddress, String str, com.google.android.libraries.navigation.internal.afz.a aVar) {
        es esVar = I;
        this.C = esVar;
        this.D = esVar;
        this.f = new ArrayList();
        this.g = com.google.android.libraries.navigation.internal.afx.cb.b();
        this.h = new ArrayList();
        this.l = GrpcUtil.DEFAULT_LB_POLICY;
        this.m = G;
        this.f335n = H;
        this.o = b;
        this.p = 5;
        this.q = 5;
        this.r = 16777216L;
        this.s = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.t = true;
        this.u = com.google.android.libraries.navigation.internal.afx.ag.a;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = new ArrayList();
        this.i = b(socketAddress);
        this.j = null;
        this.k = null;
        this.E = aVar;
        com.google.android.libraries.navigation.internal.afx.cb cbVar = new com.google.android.libraries.navigation.internal.afx.cb();
        cbVar.e(new ct(socketAddress, str));
        this.g = cbVar;
        this.F = new cv();
        Iterator it2 = com.google.android.libraries.navigation.internal.afx.q.a().b().iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.afx.p) it2.next()).a();
        }
    }

    public static cw a(String str, com.google.android.libraries.navigation.internal.afx.cb cbVar, Collection collection) {
        URI uri;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb.append(e2.getMessage());
            uri = null;
        }
        com.google.android.libraries.navigation.internal.afx.bz bzVarA = uri != null ? cbVar.a(uri.getScheme()) : null;
        if (bzVarA == null && !d.matcher(str).matches()) {
            try {
                uri = new URI(cbVar.c(), "", RemoteSettings.FORWARD_SLASH_STRING + str, null);
                bzVarA = cbVar.a(uri.getScheme());
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        if (bzVarA == null) {
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, sb.length() > 0 ? com.google.android.libraries.navigation.internal.b.b.n(sb, " (", ")") : ""));
        }
        if (collection == null || collection.containsAll(bzVarA.c())) {
            return new cw(uri, bzVarA);
        }
        throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
    }

    static String b(SocketAddress socketAddress) {
        try {
            return new URI("directaddress", "", RemoteSettings.FORWARD_SLASH_STRING + String.valueOf(socketAddress), null).toString();
        } catch (URISyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }
}
