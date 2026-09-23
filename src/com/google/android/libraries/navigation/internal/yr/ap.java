package com.google.android.libraries.navigation.internal.yr;

import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements Callable {
    final /* synthetic */ ag a;
    final /* synthetic */ Callable b;

    public ap(ag agVar, Callable callable) {
        this.a = agVar;
        this.b = callable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            Object objCall = this.b.call();
            i.e(aeVarA, agVarE);
            return objCall;
        } catch (Throwable th) {
            try {
                f.a(th);
                throw th;
            } catch (Throwable th2) {
                i.e(aeVarA, agVarE);
                throw th2;
            }
        }
    }

    public final String toString() {
        return "propagating=[" + this.b + "]";
    }
}
