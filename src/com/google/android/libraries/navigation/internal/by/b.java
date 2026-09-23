package com.google.android.libraries.navigation.internal.by;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.bv.d;
import com.google.android.libraries.navigation.internal.hh.n;
import com.google.android.libraries.navigation.internal.hh.p;
import com.google.android.libraries.navigation.internal.hh.q;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final fd a;

    public b(Context context, Executor executor) {
        a aVar = new a(context, executor);
        ez ezVar = new ez();
        for (c cVar : c.values()) {
            ezVar.f(cVar, new q((dg) d.a.aH(7, null), aVar.a, n.PERSISTENT_FILE, cVar.f));
        }
        this.a = ezVar.d();
    }

    public final d a(c cVar) {
        q qVar = (q) this.a.get(cVar);
        ar.q(qVar);
        p pVarA = qVar.a();
        if (pVarA.a == null) {
            return null;
        }
        return (d) pVarA.a;
    }
}
