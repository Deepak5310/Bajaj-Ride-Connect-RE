package com.google.android.libraries.navigation.internal.me;

import com.google.android.libraries.navigation.internal.lh.be;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae extends w {
    public final Object a = new Object();
    public final y b = new y();
    public boolean c;
    public volatile boolean d;
    public Exception e;
    private Object f;

    private final void p() {
        boolean z;
        String strConcat;
        if (this.c) {
            synchronized (this.a) {
                z = this.c;
            }
            if (!z) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excC = c();
            if (excC != null) {
                strConcat = "failure";
            } else if (e()) {
                strConcat = "result ".concat(String.valueOf(String.valueOf(d())));
            } else {
                strConcat = this.d ? "cancellation" : "unknown issue";
            }
        }
    }

    private final void q() {
        synchronized (this.a) {
            if (this.c) {
                this.b.b(this);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final w a(Executor executor, e eVar) {
        ae aeVar = new ae();
        this.b.a(new g(ag.a(executor), eVar, aeVar));
        q();
        return aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final w b(Executor executor, e eVar) {
        ae aeVar = new ae();
        this.b.a(new i(ag.a(executor), eVar, aeVar));
        q();
        return aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final Exception c() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final Object d() {
        Object obj;
        synchronized (this.a) {
            be.g(this.c, "Task is not yet complete");
            if (this.d) {
                throw new CancellationException("Task is already canceled.");
            }
            Exception exc = this.e;
            if (exc != null) {
                throw new v(exc);
            }
            obj = this.f;
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            z = false;
            if (this.c && !this.d && this.e == null) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void f(Executor executor, i iVar) {
        this.b.a(new l(ag.a(executor), iVar));
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void g(Executor executor, o oVar) {
        this.b.a(new n(ag.a(executor), oVar));
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void h(r rVar) {
        i(ad.a, rVar);
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void i(Executor executor, r rVar) {
        this.b.a(new q(ag.a(executor), rVar));
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void j(u uVar) {
        k(ad.a, uVar);
    }

    @Override // com.google.android.libraries.navigation.internal.me.w
    public final void k(Executor executor, u uVar) {
        this.b.a(new t(ag.a(executor), uVar));
        q();
    }

    public final void l(Exception exc) {
        be.k(exc, "Exception must not be null");
        synchronized (this.a) {
            p();
            this.c = true;
            this.e = exc;
        }
        this.b.b(this);
    }

    public final void m(Object obj) {
        synchronized (this.a) {
            p();
            this.c = true;
            this.f = obj;
        }
        this.b.b(this);
    }

    public final void n() {
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.d = true;
            this.b.b(this);
        }
    }

    public final void o(Object obj) {
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.f = obj;
            this.b.b(this);
        }
    }
}
