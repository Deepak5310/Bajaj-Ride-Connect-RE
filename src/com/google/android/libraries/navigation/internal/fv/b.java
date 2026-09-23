package com.google.android.libraries.navigation.internal.fv;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oh.e;
import com.google.android.libraries.navigation.internal.oh.f;
import com.google.android.libraries.navigation.internal.oh.n;
import com.google.android.libraries.navigation.internal.oh.p;
import com.google.android.libraries.navigation.internal.op.g;
import com.google.android.libraries.navigation.internal.qk.q;
import com.google.android.libraries.navigation.internal.qk.r;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b implements r {
    private final n a = new n();
    private final com.google.android.libraries.navigation.internal.oh.a b;

    public b(com.google.android.libraries.navigation.internal.oh.a aVar) {
        this.b = aVar;
    }

    public static b c() {
        p.a aVar = new p.a();
        aVar.c(new f());
        aVar.d(10, new com.google.android.libraries.navigation.internal.oh.b());
        aVar.e(1, new e());
        return new b(aVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean a(g gVar, q qVar, com.google.android.libraries.navigation.internal.qk.p pVar) {
        return b(gVar, qVar, pVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean b(g gVar, q qVar, com.google.android.libraries.navigation.internal.qk.p pVar, s sVar) {
        x xVarA = qVar.a();
        ar.q(xVarA);
        return n.b(gVar, qVar, this.b, xVarA, pVar, sVar);
    }
}
