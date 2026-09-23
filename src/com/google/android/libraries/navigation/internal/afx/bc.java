package com.google.android.libraries.navigation.internal.afx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc {
    private static final Logger a = Logger.getLogger(bc.class.getName());
    private static bc b;
    private static final Iterable c;
    private final LinkedHashSet d = new LinkedHashSet();
    private final LinkedHashMap e = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("com.google.android.libraries.navigation.internal.aga.dv"));
        } catch (ClassNotFoundException e) {
            a.logp(Level.WARNING, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("com.google.android.libraries.navigation.internal.agb.k"));
        } catch (ClassNotFoundException e2) {
            a.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        c = Collections.unmodifiableList(arrayList);
    }

    public static synchronized bc b() {
        if (b == null) {
            List<ba> listA = ch.a(ba.class, c, ba.class.getClassLoader(), new bb());
            b = new bc();
            for (ba baVar : listA) {
                a.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(baVar))));
                b.c(baVar);
            }
            b.d();
        }
        return b;
    }

    private final synchronized void c(ba baVar) {
        baVar.e();
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "isAvailable() returned false");
        this.d.add(baVar);
    }

    private final synchronized void d() {
        this.e.clear();
        for (ba baVar : this.d) {
            String strC = baVar.c();
            if (((ba) this.e.get(strC)) != null) {
                baVar.d();
            } else {
                this.e.put(strC, baVar);
            }
        }
    }

    public final synchronized ba a(String str) {
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "policy");
        return (ba) this.e.get(str);
    }
}
