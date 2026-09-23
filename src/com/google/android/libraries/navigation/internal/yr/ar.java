package com.google.android.libraries.navigation.internal.yr;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ ag a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.as b;

    public ar(ag agVar, com.google.android.libraries.navigation.internal.aac.as asVar) {
        this.a = agVar;
        this.b = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            this.b.a(t);
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

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void b(Object obj) {
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            this.b.b(obj);
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
}
