package com.google.android.libraries.navigation.internal.kk;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.kl.d {
    private final bk a;
    private final bj b;

    public c(Executor executor, com.google.android.libraries.navigation.internal.iz.n nVar) {
        bk bkVar = new bk(new Callable() { // from class: com.google.android.libraries.navigation.internal.kk.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        });
        this.a = bkVar;
        this.b = com.google.android.libraries.navigation.internal.yu.c.c(bkVar, new t() { // from class: com.google.android.libraries.navigation.internal.kk.b
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DeviceBootCountImpl.bootCountTask");
                try {
                    bj bjVarH = az.h(com.google.android.libraries.navigation.internal.yx.a.a);
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    return bjVarH;
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
        }, ac.INSTANCE);
        nVar.d(bkVar, executor, com.google.android.libraries.navigation.internal.iz.m.ON_STARTUP_FULLY_COMPLETE);
    }

    @Override // com.google.android.libraries.navigation.internal.kl.d
    public final an a() {
        if (!this.b.isDone()) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
        try {
            return (an) az.n(this.b);
        } catch (ExecutionException e) {
            throw new AssertionError(e);
        }
    }
}
