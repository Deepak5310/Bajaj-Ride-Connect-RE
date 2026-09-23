package com.google.android.libraries.navigation.internal.nt;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends s implements a {
    static final ab a = new c();
    public CallbackToFutureAdapter.Completer b;
    private bj d;

    d() {
        super(a);
        this.b = null;
        this.d = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.libraries.navigation.internal.nt.b
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                d dVar = this.a;
                synchronized (dVar) {
                    dVar.b = completer;
                }
                return "valueFuture";
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.nt.a
    public final synchronized Object a() {
        try {
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        }
        return az.n(this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.a
    public final void b(com.google.android.libraries.navigation.internal.tc.g gVar, Executor executor) {
        super.p(gVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.a
    public final void c(com.google.android.libraries.navigation.internal.tc.g gVar) {
        super.s(gVar);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.s
    public final synchronized bj d() {
        return az.i(this.d);
    }

    final bj e() {
        synchronized (this) {
            ar.k(this.d.isDone());
        }
        super.r();
        k kVar = (k) this.c.get();
        ArrayList arrayList = new ArrayList();
        while (true) {
            final aa aaVar = (aa) kVar.a.poll();
            if (aaVar == null) {
                return az.b(arrayList).a(new Callable() { // from class: com.google.android.libraries.navigation.internal.nt.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return null;
                    }
                }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            }
            arrayList.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.libraries.navigation.internal.nt.w
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                    final aa aaVar2 = aaVar;
                    completer.addCancellationListener(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nt.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            aaVar2.a();
                        }
                    }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                    final s sVar = this;
                    aaVar2.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.nt.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            aa aaVar3 = aaVar2;
                            bj bjVar = be.a;
                            if (!aaVar3.d) {
                                s sVar2 = sVar;
                                sVar2.q(true);
                                try {
                                    bj bjVarA = aaVar3.c.a(aaVar3.b, sVar2);
                                    sVar2.q(false);
                                    bjVar = bjVarA;
                                } catch (Throwable th) {
                                    sVar2.q(false);
                                    throw th;
                                }
                            }
                            az.o(bjVar, new z(completer), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                        }
                    });
                    return "dispatch";
                }
            }));
        }
    }

    final synchronized Object f(Object obj) {
        Object obj2;
        CallbackToFutureAdapter.Completer completer = this.b;
        if (completer != null) {
            completer.set(obj);
            obj2 = null;
            this.b = null;
        } else {
            Object objA = a();
            this.d = az.h(obj);
            obj2 = objA;
        }
        return obj2;
    }

    public d(byte[] bArr) {
        super(a);
        this.b = null;
        this.d = az.h("UNKNOWN");
    }
}
