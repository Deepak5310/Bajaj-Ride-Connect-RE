package com.google.android.libraries.navigation.internal.ia;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public final ap a;
    public final Executor b;
    protected final Object c;
    public final Class d;
    public boolean e = false;

    public k(Class cls, Object obj, ap apVar, Executor executor) {
        ar.r(obj, "GmmEventHandler target cannot be null.");
        apVar = apVar == ap.DANGEROUS_PUBLISHER_THREAD ? ap.CURRENT : apVar;
        this.a = apVar;
        this.b = executor;
        this.c = obj;
        this.d = cls;
        if (apVar == ap.CURRENT) {
            ar.k(executor == null);
        }
    }

    public static Executor b(ap apVar, Map map) {
        if (apVar == ap.CURRENT || apVar == ap.DANGEROUS_PUBLISHER_THREAD) {
            return null;
        }
        Executor executor = (Executor) map.get(apVar);
        ar.q(executor);
        return executor;
    }

    protected void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        throw null;
    }

    public final synchronized void c(com.google.android.libraries.navigation.internal.ic.a aVar) {
        try {
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            com.google.android.libraries.navigation.internal.nw.d dVarD = null;
            if (Trace.isEnabled()) {
                com.google.android.libraries.navigation.internal.xn.a aVarA = com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.b(this.c.getClass()), com.google.android.libraries.navigation.internal.xn.a.c("-", aVar.getClass()));
                if (Trace.isEnabled()) {
                    dVarD = com.google.android.libraries.navigation.internal.nw.e.d(aVarA.a);
                }
            }
            try {
                a(aVar);
                if (dVarD != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (dVarD != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IllegalArgumentException e) {
            throw new Error("Method rejected target/argument: " + String.valueOf(this.c) + ", " + String.valueOf(aVar), e);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k) && this.c == ((k) obj).c;
    }

    public final int hashCode() {
        return System.identityHashCode(this.c);
    }
}
