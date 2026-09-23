package com.google.android.libraries.navigation.internal.afx;

import androidx.core.os.EnvironmentCompat;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cb {
    private static final Logger a = Logger.getLogger(cb.class.getName());
    private static cb b;
    private String c = EnvironmentCompat.MEDIA_UNKNOWN;
    private final LinkedHashSet d = new LinkedHashSet();
    private fd e = ma.b;

    public static synchronized cb b() {
        if (b == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("com.google.android.libraries.navigation.internal.aga.an"));
            } catch (ClassNotFoundException e) {
                a.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e);
            }
            List<bz> listA = ch.a(bz.class, Collections.unmodifiableList(arrayList), bz.class.getClassLoader(), new ca());
            if (listA.isEmpty()) {
                a.logp(Level.WARNING, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            b = new cb();
            for (bz bzVar : listA) {
                a.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(bzVar))));
                b.f(bzVar);
            }
            b.g();
        }
        return b;
    }

    private final synchronized void f(bz bzVar) {
        bzVar.d();
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "isAvailable() returned false");
        this.d.add(bzVar);
    }

    private final synchronized void g() {
        HashMap map = new HashMap();
        String strB = EnvironmentCompat.MEDIA_UNKNOWN;
        byte b2 = -2147483648;
        for (bz bzVar : this.d) {
            String strB2 = bzVar.b();
            if (((bz) map.get(strB2)) != null) {
                bzVar.e();
            } else {
                map.put(strB2, bzVar);
            }
            bzVar.e();
            if (b2 < 5) {
                bzVar.e();
                strB = bzVar.b();
            }
            b2 = 5;
        }
        this.e = fd.j(map);
        this.c = strB;
    }

    public final bz a(String str) {
        if (str == null) {
            return null;
        }
        return (bz) d().get(str.toLowerCase(Locale.US));
    }

    public final synchronized String c() {
        return this.c;
    }

    final synchronized Map d() {
        return this.e;
    }

    public final synchronized void e(bz bzVar) {
        f(bzVar);
        g();
    }
}
