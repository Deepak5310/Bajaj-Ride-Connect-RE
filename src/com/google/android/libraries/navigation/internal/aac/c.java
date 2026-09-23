package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends am implements Runnable {
    bj a;
    Class b;
    Object c;

    public c(bj bjVar, Class cls, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        this.a = bjVar;
        this.b = cls;
        this.c = obj;
    }

    public static bj h(bj bjVar, Class cls, com.google.android.libraries.navigation.internal.yx.aa aaVar, Executor executor) {
        b bVar = new b(bjVar, cls, aaVar);
        bjVar.l(bVar, bt.b(executor, bVar));
        return bVar;
    }

    public static bj i(bj bjVar, Class cls, t tVar, Executor executor) {
        a aVar = new a(bjVar, cls, tVar);
        bjVar.l(aVar, bt.b(executor, aVar));
        return aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bj bjVar = this.a;
        Class cls = this.b;
        Object obj = this.c;
        String strAo = super.ao();
        String strN = bjVar != null ? com.google.android.libraries.navigation.internal.b.b.n(bjVar, "inputFuture=[", "], ") : "";
        if (cls == null || obj == null) {
            if (strAo != null) {
                return String.valueOf(strN).concat(strAo);
            }
            return null;
        }
        return strN + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + "]";
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        o(this.a);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public abstract Object f(Object obj, Throwable th) throws Exception;

    public abstract void g(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object objN;
        bj bjVar = this.a;
        Class cls = this.b;
        Object obj = this.c;
        if (((obj == null) || ((bjVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.a = null;
        try {
            th = bjVar instanceof com.google.android.libraries.navigation.internal.aad.a ? ((com.google.android.libraries.navigation.internal.aad.a) bjVar).k() : null;
            objN = th == null ? az.n(bjVar) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(bjVar.getClass()) + " threw " + String.valueOf(e.getClass()) + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            d(objN);
            return;
        }
        if (!cls.isInstance(th)) {
            aA(bjVar);
            return;
        }
        try {
            Object objF = f(obj, th);
            this.b = null;
            this.c = null;
            g(objF);
        } catch (Throwable th2) {
            try {
                bu.a(th2);
                ap(th2);
            } finally {
                this.b = null;
                this.c = null;
            }
        }
    }
}
