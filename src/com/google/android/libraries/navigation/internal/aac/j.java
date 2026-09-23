package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j extends am implements Runnable {
    bj a;
    Object b;

    public j(bj bjVar, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        this.a = bjVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        this.b = obj;
    }

    public static bj h(bj bjVar, com.google.android.libraries.navigation.internal.yx.aa aaVar, Executor executor) {
        i iVar = new i(bjVar, aaVar);
        bjVar.l(iVar, bt.b(executor, iVar));
        return iVar;
    }

    public static bj i(bj bjVar, t tVar, Executor executor) {
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        h hVar = new h(bjVar, tVar);
        bjVar.l(hVar, bt.b(executor, hVar));
        return hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bj bjVar = this.a;
        Object obj = this.b;
        String strAo = super.ao();
        String strN = bjVar != null ? com.google.android.libraries.navigation.internal.b.b.n(bjVar, "inputFuture=[", "], ") : "";
        if (obj == null) {
            if (strAo != null) {
                return String.valueOf(strN).concat(strAo);
            }
            return null;
        }
        return strN + "function=[" + obj.toString() + "]";
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        o(this.a);
        this.a = null;
        this.b = null;
    }

    public abstract Object f(Object obj, Object obj2) throws Exception;

    public abstract void g(Object obj);

    @Override // java.lang.Runnable
    public final void run() {
        bj bjVar = this.a;
        Object obj = this.b;
        if ((isCancelled() | (bjVar == null)) || (obj == null)) {
            return;
        }
        this.a = null;
        if (bjVar.isCancelled()) {
            aA(bjVar);
            return;
        }
        try {
            try {
                Object objF = f(obj, az.n(bjVar));
                this.b = null;
                g(objF);
            } catch (Throwable th) {
                try {
                    bu.a(th);
                    ap(th);
                } finally {
                    this.b = null;
                }
            }
        } catch (Error e) {
            ap(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            ap(e2.getCause());
        } catch (Exception e3) {
            ap(e3);
        }
    }
}
