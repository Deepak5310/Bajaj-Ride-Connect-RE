package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.nc.bi;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends d {
    private final dd c;
    private final cx d;

    public ac(cw cwVar, dd ddVar, cx cxVar) {
        super(cwVar);
        ar.r(ddVar, "Null should never be used in place of a VmFunction. If you want to pass a null value, use VmFunction.of(null).");
        this.c = ddVar;
        this.d = cxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.d, com.google.android.libraries.navigation.internal.mx.w
    public final void b(cx cxVar, ck ckVar) {
        ar.k(this.c.b());
        Object objA = this.c.a(cs.r);
        if (cxVar.a(this.a, objA, ckVar)) {
            return;
        }
        this.d.a(this.a, objA, ckVar);
    }

    @Override // com.google.android.libraries.navigation.internal.mx.d, com.google.android.libraries.navigation.internal.mx.w
    public final boolean c() {
        if (this.c.b()) {
            return bi.a(this.c.a(cs.r));
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.w
    public final bw d(ck ckVar) {
        return new ab(this.a, ckVar, this.d, this.b, this.c);
    }
}
