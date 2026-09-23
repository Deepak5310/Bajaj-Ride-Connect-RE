package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.aac.bj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an implements com.google.android.libraries.navigation.internal.aac.s {
    final /* synthetic */ ag a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.s b;

    public an(ag agVar, com.google.android.libraries.navigation.internal.aac.s sVar) {
        this.a = agVar;
        this.b = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.s
    public final bj a() {
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            bj bjVarA = this.b.a();
            i.e(aeVarA, agVarE);
            Intrinsics.checkNotNullExpressionValue(bjVarA, "wrapInTrace(...)");
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
