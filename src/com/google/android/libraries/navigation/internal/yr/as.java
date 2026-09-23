package com.google.android.libraries.navigation.internal.yr;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as implements Runnable {
    final /* synthetic */ Ref.ObjectRef a;
    final /* synthetic */ ag b;
    final /* synthetic */ Runnable c;

    public as(Ref.ObjectRef objectRef, ag agVar, Runnable runnable) {
        this.a = objectRef;
        this.b = agVar;
        this.c = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        if (((az) this.a.element) != null) {
            throw null;
        }
        ag agVar = this.b;
        Intrinsics.checkNotNull(agVar, "null cannot be cast to non-null type com.google.apps.tiktok.tracing.Trace");
        Runnable runnable = this.c;
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            runnable.run();
            Unit unit = Unit.INSTANCE;
            i.e(aeVarA, agVarE);
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
        return "propagating=[" + this.c + "]";
    }
}
