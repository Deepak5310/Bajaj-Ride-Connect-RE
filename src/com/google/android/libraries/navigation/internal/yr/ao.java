package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.aac.bj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao implements com.google.android.libraries.navigation.internal.aac.t {
    final /* synthetic */ ag a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.t b;

    public ao(ag agVar, com.google.android.libraries.navigation.internal.aac.t tVar) {
        this.a = agVar;
        this.b = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.t
    public final bj a(Object obj) {
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            bj bjVarA = this.b.a(obj);
            if (bjVarA == null) {
                throw new IllegalStateException("AsyncFunction should return a ListenableFuture instead of null.");
            }
            i.e(aeVarA, agVarE);
            return bjVarA;
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
