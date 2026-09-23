package com.google.android.libraries.navigation.internal.yr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq implements com.google.android.libraries.navigation.internal.yx.aa {
    final /* synthetic */ ag a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.yx.aa b;

    public aq(ag agVar, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        this.a = agVar;
        this.b = aaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final Object ak(Object obj) {
        ag agVar = this.a;
        Intrinsics.checkNotNull(agVar);
        ae aeVarA = i.a();
        ag agVarE = i.e(aeVarA, agVar);
        try {
            Object objAk = this.b.ak(obj);
            i.e(aeVarA, agVarE);
            return objAk;
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
