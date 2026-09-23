package com.google.android.libraries.navigation.internal.kh;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class p {
    private final fd a;
    public final ConcurrentMap c = new ConcurrentHashMap();
    public final com.google.android.libraries.navigation.internal.di.b d;

    public p(com.google.android.libraries.navigation.internal.di.b bVar) {
        ez ezVar = new ez();
        for (y yVar : y.values()) {
            ezVar.f(yVar, new q());
        }
        this.a = ezVar.d();
        this.d = bVar;
    }

    protected abstract void a(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar, y yVar);

    protected abstract void b(o oVar);

    protected abstract boolean c();

    protected final com.google.android.libraries.navigation.internal.hj.i f() {
        return this.d.c();
    }

    public final q g(y yVar) {
        q qVar = (q) this.a.get(yVar);
        ar.q(qVar);
        return qVar;
    }

    protected final void h(q qVar, y yVar) {
        q qVarG = g(yVar);
        nn nnVarListIterator = qVar.a().u().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            qVarG.b((String) entry.getKey(), (com.google.android.libraries.navigation.internal.ke.c) entry.getValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    protected final void i(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar, y yVar) {
        String str;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LoggingClient.enqueue");
        try {
            if (!iVar.e() && !iVar.f()) {
                if (iVar.b()) {
                    str = "";
                } else {
                    ar.b(false, "'account' must be Google, Incognito or Signed Out.");
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
            }
            String strC = iVar.c();
            this.c.putIfAbsent(strC, iVar);
            str = strC;
            g(yVar).b(str, cVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
